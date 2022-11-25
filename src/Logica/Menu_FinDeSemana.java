package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu_FinDeSemana extends Menu{

	private int numPersonas;//Si hay más de X numero de perosnas se le aplica un 10% descuento.


	
	public Menu_FinDeSemana() {

	}

	public Menu_FinDeSemana(String id, HashMap<String, List<Producto>> hmProds, int numProductos, double precioTotal, int numPersonas) {
		super(id, hmProds, numProductos, precioTotal);
		// TODO Auto-generated constructor stub
		this.numPersonas = numPersonas;
	}


	public int getNumPersonas() {
		return numPersonas;
	}



	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	@Override
	public String toString() {
		return "Menu_FinDeSemana [numPersonas=" + numPersonas + ", getId()=" + getId() + ", getpL()=" + getpL()
				+ ", getNumProductos()=" + getNumProductos() + ", getPrecioTotal()=" + getPrecioTotal()
				+ "]";
	}



}
