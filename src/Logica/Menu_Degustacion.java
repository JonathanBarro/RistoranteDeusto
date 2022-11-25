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

	public String toString() {
		return getId();
	}
	public String toStringCarta() {
		return getId() + " : " + " numero de platos: " + getNumProductos() + " Primer plato: " + getpL().get("Comida").get(0).getNombre() + "Segundo plato: " + getpL().get("Comida").get(1).getNombre() 
				+ " Postre: " + getpL().get("Comida").get(3).getNombre() + " Bebida: " + getpL().get("Bebida").get(0).getNombre(); 
	}
}
