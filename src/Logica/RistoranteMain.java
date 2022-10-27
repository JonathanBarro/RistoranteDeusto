package Logica;

import java.sql.Connection;

import BD.BD;

public class RistoranteMain {
	
	public static void main(String[] args) {
		
		
		Connection con = BD.initBD("RistoranteBD.db");
		BD.crearTablas(con);
		
		BD.closeBD(con);
		
	}

}