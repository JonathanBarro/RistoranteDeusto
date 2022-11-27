package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu_Degustacion extends Menu{
	
	
	public Menu_Degustacion() {
	
	}

	public Menu_Degustacion(String id, HashMap<String, List<Producto>> hmProds, int numProductos, double precioTotal) {
		super(id, hmProds, numProductos, precioTotal);
		// TODO Auto-generated constructor stub
	}

	

	public String toStringTot() {
		return "Menu_Degustacion [getId()=" + getId() + ", getpL()=" + getpL() + ", getNumProductos()="
				+ getNumProductos() + ", getPrecioTotal()=" + getPrecioTotal() + "]";
	}

	public String toString() {
		return getId();
	}
	public String toStringCarta() {
		String aBebida = "";
		for (int i = 0; i < getpL().get("Bebida").size(); i++) {
			aBebida.concat(getpL().get("Bebida").get(i).getNombre());
			aBebida.concat("  ");
			
		}
		return getId() + " : " + " numero de platos: " + getNumProductos() + "   Primer plato: " + getpL().get("Comida").get(0).getNombre() + "   Segundo plato: " + getpL().get("Comida").get(1).getNombre() 
				+ "   Postre: " + getpL().get("Comida").get(2).getNombre() + "   Bebida: " + aBebida;   
	}
}
