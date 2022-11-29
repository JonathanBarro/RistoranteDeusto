package Logica;

public class Comida extends Producto{

	
	public Comida() {
		

	}
	
	
	
	public Comida(String nombre, double precio, int id, int stock) {
		super(nombre, precio, id, stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  getNombre() + " " + getPrecio() + "€ " + getId() + " - " + getStock();
	}
}
