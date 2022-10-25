package Logica;

public class Bebida extends Producto{


	public Bebida(String nombre, double precio, int id, int cantidad) {
		super(nombre, precio, id, cantidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  getNombre() + " " + getPrecio() + "€" ;
	}
	
}
