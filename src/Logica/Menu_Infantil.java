package Logica;

import java.util.ArrayList;

public class Menu_Infantil extends Menu {
	
	public Menu_Infantil() {


	}

	

	public Menu_Infantil(String id, ArrayList<Producto> aProducto, int numProductos, double precioTotal) {
		super(id, aProducto, numProductos, precioTotal);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return getId() + " : " + "numero de platos: " + getNumProductos();
	}

}
