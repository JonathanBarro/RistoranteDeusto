package Logica;

import java.util.ArrayList;

public class Menu_FinDeSemana extends Menu{

	private int numPersonas;//Si hay más de X numero de perosnas se le aplica un 10% descuento.


	
	public Menu_FinDeSemana() {

	}

	public Menu_FinDeSemana(String id, ArrayList<Producto> aProducto, int numProductos, double precioTotal,
			int numPersonas) {
		super(id, aProducto, numProductos, precioTotal);
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
		return getId() + " : " + "	Platos :  " + getpL() + "  Número de platos : "
				+ getNumProductos() + " precio del menu: " + getPrecioTotal();
	}
}
