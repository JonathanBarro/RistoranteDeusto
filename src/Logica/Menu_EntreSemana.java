package Logica;

import java.util.ArrayList;

public class Menu_EntreSemana extends Menu{
	

	public Menu_EntreSemana(String id, ArrayList<Producto> aProducto, int numProductos) {
		super(id, aProducto, numProductos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Menu_Degustacion [Id=" + getId() + ", productos=" + getpL() + ", numProductos="
				+ getNumProductos() + "]";
	}
	
}
