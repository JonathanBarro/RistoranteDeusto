package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu_Infantil extends Menu {
	
	public Menu_Infantil() {


	}

	public Menu_Infantil(String id, HashMap<String, List<Producto>> hmProds, int numProductos, double precioTotal) {
		super(id, hmProds, numProductos, precioTotal);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return getId() + " : " + "numero de platos: " + getNumProductos();
	}

}
