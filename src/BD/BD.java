package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	/**
	 * Método que realiza la conexión con la base de datos
	 * @param nombreBD : Nombre de la base de datos a la que nos vamos a conectar
	 * @return Devuelve la conexión a la base de datos
	 */
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
		public static void crearTablas(Connection con) {
			String sql = "CREATE TABLE IF NOT EXISTS Cliente (nombre String, apellido String, contrasena String)";
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Admin(nombre String, apellido String, contrasena String, idAdmin Integer, sueldo Real)";
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Bebida(nombre String, precio Real, id Integer, stock Integer, frio String)";
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Comida(nombre String, precio Real, id Integer, stock Integer)";
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Menu_Degustacion(id String, numProductos Integer)";
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Menu_EntreSemana(id String, numProductos Integer, descuentoEstudiante String)";
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Menu_FinDeSemana(id String, numProductos Integer, numPersonas Integer)";
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Menu_Infantil(id String, numProductos Integer)";
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Mesa(idMesa String, lugar Integer, ocupada String)";
				st.executeUpdate(sql);
				sql = "CREATE TABLE IF NOT EXISTS Reserva(fecha String, numeroPersonas Integer, idReserva String)";
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
	}
	
	
	

}
