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
	public String toString() {
		return getId();
	}
	public String toStringTot() {
		return "Menu_Degustacion [getId()=" + getId() + ", getpL()=" + getpL() + ", getNumProductos()="
				+ getNumProductos() + ", getPrecioTotal()=" + getPrecioTotal() + "]";
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
