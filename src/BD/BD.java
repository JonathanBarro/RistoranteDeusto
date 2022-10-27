package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	
	
	

}
