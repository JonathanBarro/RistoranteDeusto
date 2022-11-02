package Logica;

import java.util.ArrayList;

public class Menu_Degustacion extends Menu{
	
	
	public Menu_Degustacion() {
	
	}


	public Menu_Degustacion(String id, ArrayList<Producto> aProducto, int numProductos, double precioTotal) {
		super(id, aProducto, numProductos, precioTotal);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return getId() + " : " + "numero de platos: " + getNumProductos();
	}
	
}
