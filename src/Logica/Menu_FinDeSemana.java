package Logica;

import java.util.ArrayList;

public class Menu_FinDeSemana extends Menu{

	private int numPersonas;//Si hay más de X numero de perosnas se le aplica un 10% descuento.


	public Menu_FinDeSemana(String id, ArrayList<Producto> aProducto, int numProductos, int numPersonas) {
		super(id, aProducto, numProductos);
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
				+ getNumProductos() ;
	}
}
