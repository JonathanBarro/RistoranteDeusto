package BD;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Logica.Admin;
import Logica.Bebida;
import Logica.Cliente;
import Logica.Comida;
import Logica.Menu_Degustacion;
import Logica.Menu_EntreSemana;
import Logica.Menu_FinDeSemana;
import Logica.Menu_Infantil;
import Logica.Mesa;
import Logica.Reserva;

public class BD {
	/**
	 * Método que realiza la conexión con la base de datos
	 * @param nombreBD : Nombre de la base de datos a la que nos vamos a conectar
	 * @return Devuelve la conexión a la base de datos
	 */
	
	protected static final String DRIVER_NAME = "org.sqlite.JDBC";
	protected static final String DATABASE_FILE = "db/database.db";
	protected static final String CONNECTION_STRING = "jdbc:sqlite:" + DATABASE_FILE;
	
	public BD() {		
		try {
			//Cargar el diver SQLite
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException ex) {
			System.err.println(String.format("* Error al cargar el driver de BBDD: %s", ex.getMessage()));
			ex.printStackTrace();
		}
	}
	
	public void crearBBDD() {
		//Se abre la conexi�n y se obtiene el Statement
		//Al abrir la conexi�n, si no exist�a el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + "db/database.db");
		     Statement st = con.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS Cliente (nombre String, apellido String, contrasena String, numTlf Integer)";
			st.executeUpdate(sql);
			String sql1 = "CREATE TABLE IF NOT EXISTS Admin(nombre String, apellido String, contrasena String, idAdmin Integer, sueldo Real)";
			st.executeUpdate(sql1);
			String sql2 = "CREATE TABLE IF NOT EXISTS Bebida(nombre String, precio Real, id Integer, stock Integer, frio String)";
			st.executeUpdate(sql2);
			String sql3 = "CREATE TABLE IF NOT EXISTS Comida(nombre String, precio Real, id Integer, stock Integer)";
			st.executeUpdate(sql3);
			String sql4 = "CREATE TABLE IF NOT EXISTS Menu_Degustacion(id String, numProductos Integer)";
			st.executeUpdate(sql4);
			String sql5 = "CREATE TABLE IF NOT EXISTS Menu_EntreSemana(id String, numProductos Integer, descuentoEstudiante String)";
			st.executeUpdate(sql5);
			String sql6 = "CREATE TABLE IF NOT EXISTS Menu_FinDeSemana(id String, numProductos Integer, numPersonas Integer)";
			st.executeUpdate(sql6);
			String sql7 = "CREATE TABLE IF NOT EXISTS Menu_Infantil(id String, numProductos Integer)";
			st.executeUpdate(sql7);
			String sql8 = "CREATE TABLE IF NOT EXISTS Mesa(idMesa String, lugar Integer, ocupada String)";
			st.executeUpdate(sql8);
			String sql9 = "CREATE TABLE IF NOT EXISTS Reserva(fecha String, numeroPersonas Integer, idReserva Integer)";
			st.executeUpdate(sql9);
	        	        
	        if (!st.execute(sql)) {
	        	System.out.println("- Se ha creado la tabla Cliente");
	        	System.out.println("- Se ha creado la tabla Admin");
	        	System.out.println("- Se ha creado la tabla Bebida");
	        	System.out.println("- Se ha creado la tabla Comida");
	        	System.out.println("- Se ha creado las tabla de Menus");
	        	System.out.println("- Se ha creado la tabla de Rervas");
	        	System.out.println("- Se ha creado la tabla Mesas");
	     
	        }
		} catch (Exception ex) {
			System.err.println(String.format("* Error al crear la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();			
		}
	}
	
	public void borrarBBDD() {
		//Se abre la conexi�n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
	        String sql = "DROP TABLE IF EXISTS Cliente";
	         sql = "DROP TABLE IF EXISTS Admin";
	         sql = "DROP TABLE IF EXISTS Comida";
	         sql = "DROP TABLE IF EXISTS Bebida";
	         sql = "DROP TABLE IF EXISTS Menu_Degustacion";
	         sql = "DROP TABLE IF EXISTS Menu_EntreSemana";
	         sql = "DROP TABLE IF EXISTS Menu_FinDeSemana";
	         sql = "DROP TABLE IF EXISTS Menu_Infantil";
	         sql = "DROP TABLE IF EXISTS Mesa";
	         sql = "DROP TABLE IF EXISTS Reserva";
			
	        //Se ejecuta la sentencia de creaci�n de la tabla Estudiantes
	        if (!stmt.execute(sql)) {
	        	System.out.println("- Se ha borrado las tablas");
	        }
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE));
			System.out.println("- Se ha borrado el fichero de la BBDD");
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar el archivo de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}
	}
	
		
		
		public void insertarDatos(List<Cliente> clientes, List<Admin> admins,
				List<Bebida> bebidas, List<Comida> comidas, List<Menu_Degustacion> menus_degustacion,
				List<Menu_EntreSemana> menus_entreSemana, List<Menu_FinDeSemana> menus_finDeSemanas,
				List<Menu_Infantil> menus_infantiles, List<Mesa> mesas, List<Reserva> reservas) {
		
			
			//Se abre la conexi�n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				//Se define la plantilla de la sentencia SQL
				String sql = "INSERT INTO Cliente (nombre, apellido, contrasena, numTlf) VALUES ('%s', '%s', '%s',%d);";
				System.out.println("- Insertando clientes...");
				
				String sql1 = "INSERT INTO Admin (nombre, apellido, contrasena, idAdmin, sueldo) VALUES ('%s', '%s', '%s', %d, '%.2f');";
				System.out.println("- Insertando admministradores...");
				
				String sql2 = "INSERT INTO Bebida (nombre, precio, id, stock, frio) VALUES ('%s', '%f', %d, %d, '%s');";
				System.out.println("- Insertando bebida...");
				
				String sql3 = "INSERT INTO Comida (nombre, precio, id, stock) VALUES ('%s', '%.2f', %d, %d);";
				System.out.println("- Insertando comida...");
				
				String sql4 = "INSERT INTO Menu_Degustacion(id , numProductos) VALUES ('%s', %d);";
				String sql5 = "INSERT INTO Menu_EntreSemana(id , numProductos , descuentoEstudiante) VALUES ('%s', %d, '%s');";
				String sql6 = "INSERT INTO Menu_FinDeSemana(id, numProductos, numPersonas) VALUES ('%s', %d, %d);";
				String sql7 = "INSERT INTO Menu_Infantil(id, numProductos) VALUES ('%s', %d);";
				System.out.println("- Insertando menus...");
				

				String sql8 = "INSERT INTO Mesa(idMesa, lugar, ocupada) VALUES ('%s', %d, '%s');";
				System.out.println("- Insertando mesas...");
				
				String sql9 = "INSERT INTO Reserva(fecha, numeroPersonas, idReserva) VALUES ('%s', %d, '%d');";
				
				System.out.println("- Insertando reservas...");
				
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
				for (Menu_Degustacion mD : menus_degustacion) {
					if (1 == stmt.executeUpdate(String.format(sql4, mD.getId(), mD.getNumProductos()))) {					
						System.out.println(String.format(" - Menu degustacion insertado: %s", mD.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado el menu degustacion: %s", mD.toString()));
					}
				}
				for (Menu_Infantil mI : menus_infantiles) {
					if (1 == stmt.executeUpdate(String.format(sql7, mI.getId(), mI.getNumProductos()))) {					
						System.out.println(String.format(" - Menu infantil insertado: %s", mI.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado el menu infantil: %s", mI.toString()));
					}
				}
				for (Menu_FinDeSemana mDS : menus_finDeSemanas) {
					if (1 == stmt.executeUpdate(String.format(sql6, mDS.getId(), mDS.getNumProductos(), mDS.getNumPersonas()))) {					
						System.out.println(String.format(" - Menu fin de semana insertado: %s", mDS.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado el menu fin de semana: %s", mDS.toString()));
					}
				}
				for (Menu_EntreSemana mES : menus_entreSemana) {
					if (1 == stmt.executeUpdate(String.format(sql5, mES.getId(),mES.getNumProductos(), mES.isDescuentoEstudiantes()))) {					
						System.out.println(String.format(" - Menu entre semana insertado: %s", mES.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado el menu entre semana: %s", mES.toString()));
					}
				}
				for (Mesa mes : mesas) {
					if (1 == stmt.executeUpdate(String.format(sql8, mes.getIdMesa(), mes.getLugar(), mes.isOcupada()))) {				
						System.out.println(String.format(" - Mesas insertadas: %s", mes.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado las mesas: %s", mes.toString()));
					}
				}
				for (Reserva r : reservas) {
					if (1 == stmt.executeUpdate(String.format(sql9, r.getFecha(), r.getNumPersonas(),r.getIdReserva()))) {					
						System.out.println(String.format(" - Reservas insertadas: %s", r.toString()));
					} else {
						System.out.println(String.format(" - No se ha insertado las reservas: %s", r.toString()));
					}
				}
			} catch (Exception ex) {
				System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}				
		}
		
		
		
		public List<Cliente> obtenerDatosClientes() {
			List<Cliente> clientes = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
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
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return clientes;
		}
		
		
		public List<Admin> obtenerDatosAdmins() {
			List<Admin> admins = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
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
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return admins;
		}
		
		
		public List<Bebida> obtenerDatosBebidas() {
			List<Bebida> bebidas = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
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
					bebidas.add(bebida);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d bebidas...", bebidas.size()));			
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return bebidas;
		}
		
		public List<Comida> obtenerDatosComidas() {
			List<Comida> comidas = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
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
					comidas.add(comida);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d comidas...", comidas.size()));			
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return comidas;
		}
		
		public List<Mesa> obtenerDatosMesas() {
			List<Mesa> mesas = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
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
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					mesas.add(mesa);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d mesas...", mesas.size()));			
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return mesas;
		}
		
		public List<Reserva> obtenerDatosReservas() {
			List<Reserva> reservas = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
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
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					reservas.add(reserva);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d reservas...", reservas.size()));			
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return reservas;
		}
		
		public List<Menu_EntreSemana> obtenerDatosMenu_EntreSemana() {
			List<Menu_EntreSemana> menusEntreSemana = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Menu_EntreSemana";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Menu_EntreSemana menuEntreSemana;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					menuEntreSemana = new Menu_EntreSemana();
					
					menuEntreSemana.setId(rs.getString("id"));
					menuEntreSemana.setNumProductos(rs.getInt("numProductos"));
					menuEntreSemana.setDescuentoEstudiantes(rs.getBoolean("descuentoEstudiante"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					menusEntreSemana.add(menuEntreSemana);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d Menu_EntreSemana...", menusEntreSemana.size()));			
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return menusEntreSemana;
		}
		
		public List<Menu_FinDeSemana> obtenerDatosMenu_FinDeSemana() {
			List<Menu_FinDeSemana> menusFinDeSemana = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Menu_FinDeSemana";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Menu_FinDeSemana menuFinDeSemana;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					menuFinDeSemana = new Menu_FinDeSemana();
					
					menuFinDeSemana.setId(rs.getString("id"));
					menuFinDeSemana.setNumProductos(rs.getInt("numProductos"));
					menuFinDeSemana.setNumPersonas(rs.getInt("numPersonas"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					menusFinDeSemana.add(menuFinDeSemana);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d Menu_FinDeSemana...", menusFinDeSemana.size()));			
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return menusFinDeSemana;
		}
		
		public List<Menu_Degustacion> obtenerDatosMenu_Degustacion() {
			List<Menu_Degustacion> menusDegustacion = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Menu_Degustacion";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Menu_Degustacion menuDegustacion;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					menuDegustacion = new Menu_Degustacion();
					
					menuDegustacion.setId(rs.getString("id"));
					menuDegustacion.setNumProductos(rs.getInt("numProductos"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					menusDegustacion.add(menuDegustacion);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d Menu_Degustacion...", menusDegustacion.size()));			
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return menusDegustacion;
		}
		
		public List<Menu_Infantil> obtenerDatosMenu_Infantil() {
			List<Menu_Infantil> menusInfantil = new ArrayList<>();
			
			//Se abre la conexi�n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM Menu_Infantil";
				
				//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
				ResultSet rs = stmt.executeQuery(sql);			
				Menu_Infantil menuInfantil;
				
				//Se recorre el ResultSet y se crean objetos Cliente
				while (rs.next()) {
					menuInfantil = new Menu_Infantil();
					
					menuInfantil.setId(rs.getString("id"));
					menuInfantil.setNumProductos(rs.getInt("numProductos"));
					
					
					//Se inserta cada nuevo cliente en la lista de clientes
					menusInfantil.add(menuInfantil);
				}
				
				//Se cierra el ResultSet
				rs.close();
				
				System.out.println(String.format("- Se han recuperado %d Menu_Infantil...", menusInfantil.size()));			
			} catch (Exception ex) {
				System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
			
			return menusInfantil;
		}
		
		
		public void cambiarPrecio(Bebida bebida, Integer nuevoprecio) {
			//Se abre la conexi�n y se obtiene el Statement
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			     Statement stmt = con.createStatement()) {
				//Se ejecuta la sentencia de borrado de datos
				String sql = "UPDATE BEBIDA SET precio = %d WHERE ID = %d;";
				
				int result = stmt.executeUpdate(String.format(sql, nuevoprecio, bebida.getId()));
				
				System.out.println(String.format("- Se ha actulizado %d bebida", result));
			} catch (Exception ex) {
				System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
		}
		
		
		public void borrarCliente(int numTlfn) {
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				     Statement stmt = con.createStatement()) {
					//Se ejecuta la sentencia de borrado de datos
					String sql = "DELETE FROM Cliente WHERE numTlf=%d";
					
					int result = stmt.executeUpdate(String.format(sql, numTlfn));
					
					System.out.println(String.format("- Se ha borrad %d Cliente", result));
				} catch (Exception ex) {
					System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
					ex.printStackTrace();						
				}		
		}
		
		
		public void borrarDatos() {
			//Se abre la conexi�n y se obtiene el Statement
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
				String sql4 = "DELETE FROM Menu_Degustacion;";			
				int result4 = stmt.executeUpdate(sql4);
				String sql5 = "DELETE FROM Menu_FinDeSemana;";			
				int result5 = stmt.executeUpdate(sql5);
				String sql6 = "DELETE FROM Menu_EntreSemana;";			
				int result6 = stmt.executeUpdate(sql6);
				String sql7= "DELETE FROM Menu_Infantil;";			
				int result7 = stmt.executeUpdate(sql7);
				String sql8 = "DELETE FROM Reserva;";			
				int result8 = stmt.executeUpdate(sql8);
				String sql9 = "DELETE FROM Mesa;";			
				int result9 = stmt.executeUpdate(sql9);
				
				System.out.println(String.format("- Se han borrado %d clientes", result));
				System.out.println(String.format("- Se han borrado %d admins", result1));
				System.out.println(String.format("- Se han borrado %d bebidas", result2));
				System.out.println(String.format("- Se han borrado %d comidas", result3));
				System.out.println(String.format("- Se han borrado %d menus de degustacion", result4));
				System.out.println(String.format("- Se han borrado %d menus de fin de semana", result5));
				System.out.println(String.format("- Se han borrado %d menus de entre semana", result6));
				System.out.println(String.format("- Se han borrado %d menu infantil", result7));
				System.out.println(String.format("- Se han borrado %d reservas", result8));
				System.out.println(String.format("- Se han borrado %d mesas", result9));
			} catch (Exception ex) {
				System.err.println(String.format("* Error al borrar datos de la BBDD: %s", ex.getMessage()));
				ex.printStackTrace();						
			}		
		}	
		
		
		
		//Cambiar ocupacion
		
	
	
	

}
