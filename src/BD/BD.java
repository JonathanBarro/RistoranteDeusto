package BD;

import java.nio.file.Files;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Logica.Admin;
import Logica.Bebida;
import Logica.Merch;
import Logica.Cliente;
import Logica.Comida;
import Logica.Menu;


import Logica.Mesa;
import Logica.Producto;
import Logica.Reserva;
import Logica.Merch.Tipo;

public class BD {
	/**
	 * Método que realiza la conexión con la base de datos
	 * @param nombreBD : Nombre de la base de datos a la que nos vamos a conectar
	 * @return Devuelve la conexión a la base de datos
	 */
	
	protected static final String DRIVER_NAME = "org.sqlite.JDBC";
	private static Exception lastError = null; 
	protected static final String DATABASE_FILE = "db/database.db";
	protected static final String CONNECTION_STRING = "jdbc:sqlite:" + DATABASE_FILE;
	public static ResultSet resultado;
	public static int resultadoguardar;
	private Logger logger = null;
	
	
	public BD() {		
		try {
			//Cargar el diver SQLite
			Class.forName(DRIVER_NAME);
			log( Level.INFO, "ConexiÃ³n de base de datos " , null );
		} catch (ClassNotFoundException ex) {
			System.err.println(String.format("* Error al cargar el driver de BBDD: %s", ex.getMessage()));
			log( Level.SEVERE, "Error en conexiÃ³n de base de datos " , ex );
			ex.printStackTrace();
		}
	}
	
	public void crearBBDD() {
		//Se abre la conexi n y se obtiene el Statement
		//Al abrir la conexi n, si no exist a el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + "db/database.db");
		     Statement st = con.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS Cliente (nombre TEXT NOT NULL, apellido TEXT NOT NULL, contrasena TEXT NOT NULL, numTlf Integer PRIMARY KEY NOT NULL)";
			st.executeUpdate(sql);
			String sql1 = "CREATE TABLE IF NOT EXISTS Admin(nombre TEXT NOT NULL, apellido TEXT NOT NULL, contrasena TEXT NOT NULL, idAdmin Integer PRIMARY KEY NOT NULL, sueldo Real)";
			st.executeUpdate(sql1);
			String sql2 = "CREATE TABLE IF NOT EXISTS Bebida(nombre TEXT NOT NULL, precio Real, id Integer PRIMARY KEY NOT NULL, stock Integer, frio TEXT NOT NULL)";
			st.executeUpdate(sql2);
			String sql4 = "CREATE TABLE IF NOT EXISTS Menu(idMenu Integer PRIMARY KEY NOT NULL, numProductos Integer, caracteristica TEXT)";
			st.executeUpdate(sql4);
			String sql3 = "CREATE TABLE IF NOT EXISTS Comida(nombre TEXT NOT NULL, precio Real, id Integer PRIMARY KEY NOT NULL, stock Integer, FOREING KEY idMenu references Menu)";
			st.executeUpdate(sql3);
			String sql8 = "CREATE TABLE IF NOT EXISTS Mesa(idMesa TEXT NOT NULL, lugar Integer, ocupada TEXT NOT NULL, numPersonas Integer)";
			st.executeUpdate(sql8);
			String sql9 = "CREATE TABLE IF NOT EXISTS Reserva(fecha TEXT NOT NULL, numeroPersonas Integer, idReserva Integer , idMesa TEXT, idMenu TEXT, hora TEXT)";
			st.executeUpdate(sql9);
			String sql10 = "CREATE TABLE IF NOT EXISTS Merch(idMerch TEXT NOT NULL, color TEXT, talla Integer, precio FLOAT, imagen TEXT, tipo TEXT)";
			st.executeUpdate(sql10);
	        if (!st.execute(sql)) {
	        	System.out.println("- Se ha creado la tabla Cliente");
	        	System.out.println("- Se ha creado la tabla Admin");
	        	System.out.println("- Se ha creado la tabla Bebida");
	        	System.out.println("- Se ha creado la tabla Comida");
	        	System.out.println("- Se ha creado las tabla de Menu");
	        	System.out.println("- Se ha creado la tabla de Rervas");
	        	System.out.println("- Se ha creado la tabla Mesas");
	        	System.out.println("- Se ha creado la tabla Camiseta");
	     
	        }
	
	        log( Level.INFO, "Se han creado las tablas de la BD" , null );
		} catch (Exception ex) {
			System.err.println(String.format("* Error al crear la BBDD: %s", ex.getMessage()));
			log( Level.SEVERE, "* Error al crear la BBDD" , ex );
			ex.printStackTrace();			
		}
	}
	
	public void borrarBBDD() {
		//Se abre la conexi n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
	        String sql = "DROP TABLE IF EXISTS Cliente;";
	         sql += "DROP TABLE IF EXISTS Admin;";
	         sql += "DROP TABLE IF EXISTS Comida;";
	         sql += "DROP TABLE IF EXISTS Bebida;";
	         sql += "DROP TABLE IF EXISTS Menu;";
	         sql += "DROP TABLE IF EXISTS Mesa;";
	         sql += "DROP TABLE IF EXISTS Reserva;";
	         sql += "DROP TABLE IF EXISTS Camiseta;";
			
	        //Se ejecuta la sentencia de creaci n de la tabla Estudiantes
	        if (!stmt.execute(sql)) {
	        	System.out.println("- Se ha borrado las tablas");
	        }
	        log( Level.INFO, "Se han borrado las tablas" , null );
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar la BBDD: %s", ex.getMessage()));
			log( Level.SEVERE, " Error al borrar la BBDD:" , ex );
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE));
			System.out.println("- Se ha borrado el fichero de la BBDD");
			log( Level.INFO, "ConexiÃ³n de base de datos " , null );
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar el archivo de la BBDD: %s", ex.getMessage()));
			log( Level.SEVERE, " Error al borrar el archivo de la BBDD: " , ex );
			ex.printStackTrace();						
		}
	}
	
		
		public void insertarDatos(List<Cliente> clientes, List<Admin> admins,
				List<Bebida> bebidas, List<Comida> comidas,  List<Menu> menus,
				List<Mesa> mesas, List<Reserva> reservas, List<Merch> merchs) {
		
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				//Se define la plantilla de la sentencia SQL
				
				String sql = "INSERT INTO Cliente (nombre, apellido, contrasena, numTlf) VALUES ('%s', '%s', '%s', %d);";
				System.out.println("- Insertando clientes...");
				
				String sql1 = "INSERT INTO Admin (nombre, apellido, contrasena, idAdmin, sueldo) VALUES ('%s', '%s', '%s', %d, '%.2f');";
				System.out.println("- Insertando admministradores...");
				
				String sql2 = "INSERT INTO Bebida (nombre, precio, id, stock, frio) VALUES ('%s', '%f', %d, %d, '%s');";
				System.out.println("- Insertando bebida...");
				
				String sql3 = "INSERT INTO Comida (nombre, precio, id, stock) VALUES ('%s', '%.2f', %d, %d);";
				System.out.println("- Insertando comida...");
				
				String sql4 = "INSERT INTO Menu(idMenu, numProductos, caracteristica) VALUES (%d, %d, '%s');";
				System.out.println("- Insertando menus...");
				
				String sql8 = "INSERT INTO Mesa(idMesa, lugar, ocupada, numPersonas) VALUES ('%s', %d, '%s', %d);";
				System.out.println("- Insertando mesas...");
				
				String sql9 = "INSERT INTO Reserva(fecha, numeroPersonas, idReserva, hora) VALUES ('%s', %d, %d, '%s');";
				//System.out.println("- Insertando reservas...");
				
				String sql10 = "INSERT INTO Merch(idMerch, color, talla, precio, imagen, tipo) VALUES ('%s', '%s', %d, %s, '%s', '%s');";
				System.out.println("- Insertando mesas...");
				
				//Se recorren los clientes y se insertan uno a uno
				for (Cliente c : clientes) {
					
					if (1 == stmt.executeUpdate(String.format(sql, c.getNombre(), c.getApellido(), c.getContrasenia(), c.getNumTlfn()))) {					
						System.out.println(String.format(" - Cliente insertado: %s", c.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado el cliente: %s", c.toString()));
					}
				}
				
				//Se recorren los admins y se insertan uno a uno
				for (Admin a : admins) {
					if (1 == stmt.executeUpdate(String.format(sql1, a.getNombre(),a.getApellido(),a.getContrasenia(), a.getIdAdmin(), a.getSueldo()))) {					
						System.out.println(String.format(" - Admin insertado: %s", a.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado el Admin: %s", a.toString()));
					}
				}
				for (Bebida b : bebidas) {
					if (1 == stmt.executeUpdate(String.format(sql2, b.getNombre(),b.getPrecio(),b.getId(),b.getStock(), b.isFrio()))) {			
						System.out.println(String.format(" - Comida insertado: %s", b.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado la comida: %s", b.toString()));
					}
				}
				for (Comida com : comidas) {
					if (1 == stmt.executeUpdate(String.format(sql3, com.getNombre(), com.getPrecio(), com.getId(),com.getStock()))) {					
						System.out.println(String.format(" - Comida insertada: %s", com.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado la comida: %s", com.toString()));
					}
				}

				for (Menu mES : menus) {
					if (1 == stmt.executeUpdate(String.format(sql4, mES.getId(),mES.getNumProductos(), mES.getCaracteristicas()))) {					
						System.out.println(String.format(" - Menu entre semana insertado: %s", mES.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado el menu entre semana: %s", mES.toString()));
					}
				}
				for (Mesa mes : mesas) {
					if (1 == stmt.executeUpdate(String.format(sql8, mes.getIdMesa(), mes.getLugar(), mes.isOcupada(), mes.getNumPersonas()))) {				
						System.out.println(String.format(" - Mesas insertadas: %s", mes.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado las mesas: %s", mes.toString()));
					}
				}
			for (Reserva r : reservas) {
					if (1 == stmt.executeUpdate(String.format(sql9, r.getFecha(), r.getNumPersonas(),r.getIdReserva(), r.getHora()))) {					
						System.out.println(String.format(" - Reservas insertadas: %s", r.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado las reservas: %s", r.toString()));
					}
				}
			for(Merch c : merchs) {
				if (1 == stmt.executeUpdate(String.format(sql10, c.getIdMerch(), c.getColor(), c.getTalla(), ((Float)c.getPrecio()).toString().replace(",", "."), c.getImagen(), c.getTipo().toString()))) {					
					System.out.println(String.format(" - Merch insertado: %s", c.toString()));
				} else {
					System.out.println(String.format(" - No se ha insertado el merch: %s", c.toString()));
				}
			}
			log( Level.INFO, "Se han insertado todas las tablas " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al insertar datos de la BBDD:s " , ex );
				ex.printStackTrace();						
			}				
		}
		
		public void insertarNuevaComida(Comida c) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
				String sql = "INSERT INTO Comida (nombre, precio, id, stock) VALUES ('%s', '%.2f', %d, %d);";
				System.out.println("- Insertando comida...");
				
				if (1 == stmt.executeUpdate(String.format(sql, c.getNombre(), c.getPrecio(), c.getId(),c.getStock()))) {					
					System.out.println(String.format(" - Comida insertada: %s", c.toString()));
				} else {
					System.out.println(String.format(" - No se ha insertado la comida: %s", c.toString()));
				}
				log( Level.INFO, "Comida insertada" , null );
				
			}catch (Exception ex) {
				System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al insertar datos de la BBDD: " , ex );
				ex.printStackTrace();						
			}
		}
		
		public void insertarNuevaBebida(Bebida c) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
				String sql = "INSERT INTO Bebida (nombre, precio, id, stock, frio) VALUES ('%s', '%.2f', %d, %d, %b);";
				System.out.println("- Insertando bebida...");
				
				if (1 == stmt.executeUpdate(String.format(sql, c.getNombre(), c.getPrecio(), c.getId(),c.getStock(), c.isFrio()))) {					
					System.out.println(String.format(" - Bebida insertada: %s", c.toString()));
				} else {
					System.out.println(String.format(" - No se ha insertado la bebida: %s", c.toString()));
				}
				log( Level.INFO, "Bebida insertada" , null );
				
			}catch (Exception ex) {
				System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al insertar datos de la BBDD: " , ex );
				ex.printStackTrace();						
			}
		}
		
		public void insertarDatosReserva(Reserva r) {
			if(r.getIdReserva() == -1)return;
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
				int numP = r.getNumPersonas();
//				int numM = 0;
				while(numP>0) {
					for(Mesa m: r.getaMesa()) {
						for(int i=0;i<m.getNumPersonas() && numP>0;i++) {
							numP--;
							Menu me = r.getaMenu().get(i);
//							numM++;
							String sql = "INSERT INTO Reserva(fecha, numeroPersonas, idReserva, idMesa, idMenu, hora) VALUES ('%s', %d, %d, '%s',%d,'%s');";
							System.out.println("- Insertando reservas...");	
							
							if (1 == stmt.executeUpdate(String.format(sql, r.getFecha(), r.getNumPersonas(),r.getIdReserva(),m.getIdMesa(),me.getId(), r.getHora()))) {					
								System.out.println(String.format(" - Reservas insertadas: %s", r.toString()));
							} else {
								System.out.println(String.format(" - No se ha insertado las reservas: %s", r.toString()));
							}
						}
					}
				}
				log( Level.INFO, "Reservas insertadas " , null );
			}catch (Exception ex) {
				System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al insertar datos de la BBDD:  " , ex );
				ex.printStackTrace();						
			}
		}
		
		
		
		public List<Cliente> obtenerDatosClientes() {
			List<Cliente> clientes = new ArrayList<>();
			
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM CLIENTE WHERE numTlf >= 0";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Cliente cliente;
				
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					cliente = new Cliente();
					
					cliente.setNombre(rs.getString("nombre"));
					cliente.setApellido(rs.getString("apellido"));
					cliente.setContrasenia(rs.getString("contrasena"));
					cliente.setNumTlfn(rs.getInt("numTlf"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					clientes.add(cliente);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d clientes...", clientes.size()));
				log( Level.INFO, "- Se han recuperado clientes... " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "* Error al obtener datos de la BBDD: " , ex );
				ex.printStackTrace();						
			}		
			
			return clientes;
		}
		
		
		public List<Admin> obtenerDatosAdmins() {
			List<Admin> admins = new ArrayList<>();
			
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Admin WHERE idAdmin >= 0";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Admin admin;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					admin = new Admin();
					
					admin.setNombre(rs.getString("nombre"));
					admin.setIdAdmin(rs.getInt("idAdmin"));
					admin.setApellido(rs.getString("apellido"));
					admin.setContrasenia(rs.getString("contrasena"));
					admin.setSueldo(rs.getDouble("sueldo"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					admins.add(admin);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d admins...", admins.size()));	
				log( Level.INFO, "Se han recuperado %d admins... " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al obtener datos de la BBDD: " , ex );
				ex.printStackTrace();						
			}		
			
			return admins;
		}
		
		
		public List<Bebida> obtenerDatosBebidas() {
			List<Bebida> productos = new ArrayList<>();
			
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM BEBIDA WHERE id >= 0";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Bebida bebida;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					bebida = new Bebida();
					
					bebida.setNombre(rs.getString("nombre"));
					bebida.setId(rs.getInt("id"));
					bebida.setPrecio(rs.getInt("precio"));
					bebida.setStock(rs.getInt("stock"));
					bebida.setFrio(rs.getBoolean("frio"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					productos.add(bebida);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d bebidas...", productos.size()));
				log( Level.INFO, "Se han recuperado %d bebidas... " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al obtener datos de la BBDD:" , ex );
				ex.printStackTrace();						
			}		
			
			return productos;
		}
		
		public List<Comida> obtenerDatosComidas() {
			
			List<Comida> producto = new ArrayList<>();
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Comida WHERE id >= 0";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Comida comida;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					comida = new Comida();
					
					comida.setNombre(rs.getString("nombre"));
					comida.setId(rs.getInt("id"));
					comida.setPrecio(rs.getInt("precio"));
					comida.setStock(rs.getInt("stock"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					producto.add(comida);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d comidas...", producto.size()));
				log( Level.INFO, " Se han recuperado %d comidas..." , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al obtener datos de la BBDD:" , ex );
				ex.printStackTrace();						
			}		
			
			
			return producto;
		}
		
		public List<Merch> obtenerDatosMerch() {
			
			List<Merch> producto = new ArrayList<>();
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Merch";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Merch merch;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					merch = new Merch();
					merch.setColor(rs.getString("color"));
					merch.setIdMerch(rs.getString("idMerch"));
					merch.setImagen(rs.getString("imagen"));
					merch.setPrecio(rs.getFloat("precio"));
					merch.setTalla(rs.getInt("talla"));
					merch.setTipo(Tipo.valueOf(rs.getString("tipo")));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					producto.add(merch);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d comidas...", producto.size()));
				log( Level.INFO, " Se han recuperado %d comidas..." , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al obtener datos de la BBDD:" , ex );
				ex.printStackTrace();						
			}		
			
			
			return producto;
		}
		
		public HashMap<String, List<? extends Producto>> obtenerProductos(){
			HashMap<String, List<? extends Producto>> hmProds = new HashMap<>();
			List<Comida> comida = obtenerDatosComidas();
			List<Bebida> bebida = obtenerDatosBebidas();
			hmProds.putIfAbsent("Comida", comida);
			hmProds.putIfAbsent("Bebida", bebida);
			return hmProds;
		}
		
		public List<Mesa> obtenerDatosMesas() {
			List<Mesa> mesas = new ArrayList<>();
			
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Mesa";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Mesa mesa;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					mesa = new Mesa();
					
					mesa.setIdMesa(rs.getString("idMesa"));
					mesa.setLugar(rs.getInt("lugar"));
					mesa.setOcupada(rs.getBoolean("ocupada"));
					mesa.setNumPersonas(rs.getInt("numPersonas"));
					
					//Se inserta cada nuevo cliente en la lista de clientes
					mesas.add(mesa);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d mesas...", mesas.size()));	
				log( Level.INFO, "- Se han recuperado mesas... " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al obtener datos de la BBDD: " , ex );
				ex.printStackTrace();						
			}		
			
			return mesas;
		}
		
		public List<Reserva> obtenerDatosReservas() {
			List<Reserva> reservas = new ArrayList<>();
			
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Reserva";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Reserva reserva;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					reserva = new Reserva();
					
					reserva.setFecha(rs.getString("fecha"));
					reserva.setNumPersonas(rs.getInt("numeroPersonas"));
					reserva.setIdReserva(rs.getInt("idReserva"));
					reserva.setHora(rs.getString("hora"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					reservas.add(reserva);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d reservas...", reservas.size()));
				log( Level.INFO, "Se han recuperado reservas" , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al obtener datos de la BBDD: " , ex );
				ex.printStackTrace();						
			}		
			
			return reservas;
		}
		
		public List<Menu> obtenerDatosMenu() {
			List<Menu> menusEntreSemana = new ArrayList<>();
			
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Menu";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Menu menuEntreSemana;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					menuEntreSemana = new Menu();
					
					menuEntreSemana.setId(rs.getInt("idMenu"));
					menuEntreSemana.setNumProductos(rs.getInt("numProductos"));
					menuEntreSemana.setCaracteristicas(rs.getString("caracteristica"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					menusEntreSemana.add(menuEntreSemana);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d Menu...", menusEntreSemana.size()));
				log( Level.INFO, "Se han recuperado Menu_EntreSemana... " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "Error al obtener datos de la BBDD " , ex );
				ex.printStackTrace();						
			}		
			
			return menusEntreSemana;
		}
		

		
		
		public void cambiarPrecioBebida(Producto bebida, Integer nuevoprecio) {
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				//Se ejecuta la sentencia de borrado de datos
				String sql = "UPDATE BEBIDA SET precio = %d WHERE ID = %d;";
				
				int result = stmt.executeUpdate(String.format(sql, nuevoprecio, bebida.getId()));
				
				System.out.println(String.format("- Se ha actulizado %d bebida", result));
				log( Level.INFO, "- Se ha actulizado bebida " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "* Error actualizando datos de la BBDD" , ex );
				ex.printStackTrace();						
			}		
		}
		public void cambiarPrecioComida(Integer id, Integer nuevoprecio) {
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				//Se ejecuta la sentencia de borrado de datos
				String sql = "UPDATE COMIDA SET precio = %d WHERE ID = %d;";
				
				int result = stmt.executeUpdate(String.format(sql, nuevoprecio, id));
				
				System.out.println(String.format("- Se ha actulizado %d comida", result));
				log( Level.INFO, "Se ha actulizado %d comida " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "* Error actualizando datos de la BBDD: " , ex );
				ex.printStackTrace();						
			}		
		}
		
		
		public void modificarDatoComidas(Comida c) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
					Statement stmt = con.createStatement())  {
				String sql = "UPDATE Comida SET nombre='"+c.getNombre()+"',precio='"+c.getPrecio()+"',stock='"+c.getStock()+"' WHERE id='"+c.getId()+"'";
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void modificarDatoBebidas(Bebida b) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
					Statement stmt = con.createStatement())  {
				String sql = "UPDATE Bebida SET nombre='"+b.getNombre()+"',precio='"+b.getPrecio()+"',stock='"+b.getStock()+"', frio='"+b.isFrio()+"' WHERE id='"+b.getId()+"'";
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	
//Borrar para el admin
		
		public void borrarCliente(int numTlfn) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
					//Se ejecuta la sentencia de borrado de datos
					String sql = "DELETE FROM Cliente WHERE numTlf=%d";
					
					int result = stmt.executeUpdate(String.format(sql, numTlfn));
					
					System.out.println(String.format("- Se ha borrado %d Cliente", result));
					log( Level.INFO, "- Se ha borrado Cliente\"" , null );
				} catch (Exception ex) {
					System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
					log( Level.SEVERE, "* Error actualizando datos de la BBDD: " , ex );
					ex.printStackTrace();						
				}		
		}
		
		public void borrarReserva(int id) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
					//Se ejecuta la sentencia de borrado de datos
					String sql = "DELETE FROM Reserva WHERE idReserva=%d";
					
					int result = stmt.executeUpdate(String.format(sql, id));
					
					System.out.println(String.format("- Se ha borrado %d reserva", result));
					log( Level.INFO, "- Se ha borrado %d reserva " , null );
				} catch (Exception ex) {
					System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
					log( Level.SEVERE, "* Error actualizando datos de la BBDD: " , ex );
					ex.printStackTrace();						
				}		
		}
		
		public void borrarBebida(int id) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
					//Se ejecuta la sentencia de borrado de datos
					String sql = "DELETE FROM Bebida WHERE id=%d";
					
					int result = stmt.executeUpdate(String.format(sql, id));
					
					System.out.println(String.format("- Se ha borrado %d bebida", result));
					log( Level.INFO, "- Se ha borrado bebida" , null );
				} catch (Exception ex) {
					System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
					log( Level.SEVERE, "* Error actualizando datos de la BBDD: " , ex );
					ex.printStackTrace();						
				}		
		}
		
		
		public void borrarComida(int id) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
					//Se ejecuta la sentencia de borrado de datos
					String sql = "DELETE FROM Comida WHERE id=%d";
					
					int result = stmt.executeUpdate(String.format(sql, id));
					
					System.out.println(String.format("- Se ha borrado %d comida", result));
					log( Level.INFO, "ConexiÃ³n de base de datos " , null );
				} catch (Exception ex) {
					System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
					log( Level.SEVERE, "Error en conexiÃ³n de base de datos " , ex );
					ex.printStackTrace();						
				}		
		}
		
		
		
		
		public void borrarMesa(String id) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
					//Se ejecuta la sentencia de borrado de datos
					String sql = "DELETE FROM Mesa WHERE idMesa='%s'";
					
					int result = stmt.executeUpdate(String.format(sql, id));
					
					System.out.println(String.format("- Se ha borrado %d mesa", result));
					log( Level.INFO, "- Se ha borrado %d mesa" , null );
				} catch (Exception ex) {
					System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
					log( Level.SEVERE, "Error actualizando datos de la BBDD:  " , ex );
					ex.printStackTrace();						
				}		
		}
//Se acaba para borrar en la parte del admin
		
		
		public void borrarDatos() {
			//Se abre la conexi n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				//Se ejecuta la sentencia de borrado de datos
				String sql = "DELETE FROM CLIENTE;";			
				int result = stmt.executeUpdate(sql);
				String sql1 = "DELETE FROM Admin;";			
				int result1 = stmt.executeUpdate(sql1);
				String sql2 = "DELETE FROM Bebida;";			
				int result2 = stmt.executeUpdate(sql2);
				String sql3 = "DELETE FROM Comida;";			
				int result3 = stmt.executeUpdate(sql3);
				String sql7= "DELETE FROM Menu;";			
				int result7 = stmt.executeUpdate(sql7);
				String sql8 = "DELETE FROM Reserva;";			
				int result8 = stmt.executeUpdate(sql8);
				String sql9 = "DELETE FROM Mesa;";			
				int result9 = stmt.executeUpdate(sql9);
				
				System.out.println(String.format("- Se han borrado %d clientes", result));
				System.out.println(String.format("- Se han borrado %d admins", result1));
				System.out.println(String.format("- Se han borrado %d bebidas", result2));
				System.out.println(String.format("- Se han borrado %d comidas", result3));
				System.out.println(String.format("- Se han borrado %d menu infantil", result7));
				System.out.println(String.format("- Se han borrado %d reservas", result8));
				System.out.println(String.format("- Se han borrado %d mesas", result9));
				log( Level.INFO, "Se han borrado todos los datos correctamente " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al borrar datos de la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, " Error al borrar datos de la BBDD" , ex );
				ex.printStackTrace();						
			}		
		}	
		
		//Guardar Clientes en la base de datos
		public static PreparedStatement sentencia_preparada;
//		public int guardarClientes(String nombre, String apellido, String contrasenia, int numTlfn){
//			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
//				     Statement stmt = con.createStatement()) {
//			String sentencia_guardar = ("INSERT INTO Cliente (nombre, apellido, contrasena, numTlf) VALUES ('%s', '%s', '%s', %d);");
//			
//				sentencia_preparada = con.prepareStatement(sentencia_guardar);
//				sentencia_preparada.setString(1, nombre	);
//				sentencia_preparada.setString(2, apellido);
//				sentencia_preparada.setString(3, contrasenia	);
//				sentencia_preparada.setInt(4, numTlfn	);
//				resultadoguardar = sentencia_preparada.executeUpdate();
//				sentencia_preparada.close();
//				
//				System.out.println(String.format("- Se ha guardado un nuevo cliente en la BBDD", resultadoguardar));
//			} catch (Exception ex) {
//				System.err.println(String.format("* Error al guardar un nuevo cliente en la BBDD: %s", ex.getMessage()));
//				ex.printStackTrace();	
//			}
//			
//			return resultadoguardar;
//			}
		public int guardarClientes(String nombre, String apellido, String contrasenia, int numTlfn){
			Cliente c = new Cliente(nombre, apellido, contrasenia, numTlfn);
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
			String sentencia_guardar = ("INSERT INTO Cliente (nombre, apellido, contrasena, numTlf) VALUES ('%s', '%s', '%s', %d);");
			
			if (1 == stmt.executeUpdate(String.format(sentencia_guardar, c.getNombre(), c.getApellido(), c.getContrasenia(), c.getNumTlfn()))) {					
				System.out.println(String.format(" - Cliente insertado: %s", c.toString()));
			} else {
				System.out.println(String.format(" - No se ha insertado el cliente: %s", c.toString()));
			}
				
				System.out.println(String.format("- Se ha guardado un nuevo cliente en la BBDD", resultadoguardar));
				log( Level.INFO, "ConexiÃ³n de base de datos " , null );
			} catch (Exception ex) {
				System.err.println(String.format("* Error al guardar un nuevo cliente en la BBDD: %s", ex.getMessage()));
				log( Level.SEVERE, "* Error al guardar un nuevo cliente en la BBDD:" , ex );
				ex.printStackTrace();	
			}
			
			return resultadoguardar;
			}

		//Guardar Administradores en la base de datos
//		public int guardarAdmins(String nombre, String apellido, String contrasenia, int idAdmin, int sueldo){
//			Admin a = new Admin(nombre, apellido, contrasenia, idAdmin, sueldo);
//			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
//				     Statement stmt = con.createStatement()) {
//			String sentencia_guardar = ("INSERT INTO Admin (nombre, apellido, contrasena, idAdmin, sueldo) VALUES ('%s', '%s', '%s', %d, '%.2f');");
//					
//			if (1 == stmt.executeUpdate(String.format(sentencia_guardar, a.getNombre(),a.getApellido(),a.getContrasenia(), a.getIdAdmin(), a.getSueldo()))) {					
//				System.out.println(String.format(" - Admin insertado: %s", a.toString()));
//			} else {
//				System.out.println(String.format(" - No se ha insertado el Admin: %s", a.toString()));
//			}
//				
//				System.out.println(String.format("- Se ha guardado un nuevo administrador en la BBDD", resultadoguardar));
//			} catch (Exception ex) {
//				System.err.println(String.format("* Error al guardar un nuevo administrador en la BBDD: %s", ex.getMessage()));
//				ex.printStackTrace();	
//			}
//					
//			return resultadoguardar;
//		}
		//Buscar nombre del Cliente
		public static String buscarNombre(String usuario) {
			
			String busqueda_nombre = null;
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);){
				
				String sentencia_buscar = ("SELECT nombre, apellido FROM Cliente WHERE nombre = '" + usuario + "'");
				sentencia_preparada = con.prepareStatement(sentencia_buscar);
				resultado = sentencia_preparada.executeQuery();
				if(resultado.next()) {
					String nombre = resultado.getString("nombre");
					String apellido = resultado.getString("apellido");
					busqueda_nombre = (nombre +" "+ apellido);
				}
				
				
			}
			
			catch (Exception e) {
				
					
			}
			return busqueda_nombre;	
		}
		//Buscar si un cliente esta registrado
		public static String buscarClienteRegistrado ( String usuario, String contrasenya) {
			String busqueda_cliente = null;
			Connection conexion = null;
			
			try {
				conexion = DriverManager.getConnection(CONNECTION_STRING);
				String sentencia_buscar_cliente = ("SELECT nombre,apellido,numTlf,contrasena FROM Cliente WHERE nombre = '"+ usuario +"' AND contrasena = '"+ contrasenya +"'");	
				sentencia_preparada = conexion.prepareStatement(sentencia_buscar_cliente);
				resultado = sentencia_preparada.executeQuery();
				if(resultado.next()) {
					busqueda_cliente = "Cliente encontrado";
				}else {
					busqueda_cliente = "Cliente no encontrado";
				}
				
			
			
				conexion.close();
				System.out.println(String.format("- Se ha podido iniciar sesion correctamente", resultado));
				
			} catch (Exception e) {
				System.err.println(String.format("* Error, no se puede iniciar sesion porque este Cliente no esta registrado", e.getMessage()));
				e.printStackTrace();
			}
			return busqueda_cliente;
		
		
		}
		
		public static String buscarAdminRegistrado ( String usuario, String contrasenya) {
			String busqueda_cliente = null;
			Connection conexion = null;
			
			try {
				conexion = DriverManager.getConnection(CONNECTION_STRING);
				String sentencia_buscar_cliente = ("SELECT nombre,apellido,idAdmin,contrasena,sueldo FROM Admin WHERE nombre = '"+ usuario +"' AND contrasena = '"+ contrasenya +"'");	
				sentencia_preparada = conexion.prepareStatement(sentencia_buscar_cliente);
				resultado = sentencia_preparada.executeQuery();
				if(resultado.next()) {
					busqueda_cliente = "Admin encontrado";
				}else {
					busqueda_cliente = "Admin no encontrado";
				}
				
			
			
				conexion.close();
				System.out.println(String.format("- Se ha podido iniciar sesion correctamente", resultado));
			} catch (Exception e) {
				System.err.println(String.format("* Error, no se puede iniciar sesion porque este Admin no esta registrado", e.getMessage()));
				e.printStackTrace();
			}
			return busqueda_cliente;
		
		
		}
			
		
		//LOGGE


	private void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( "BD-local" );  // Nombre del logger
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				logger.addHandler( new FileHandler( "bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
	
	/** Devuelve la informaciÃ³n de excepciÃ³n del Ãºltimo error producido por cualquiera 
	 * de los mÃ©todos de gestiÃ³n de base de datos
	 */
	public Exception getLastError() {
		return lastError;
	}

	
		

}
	
	
