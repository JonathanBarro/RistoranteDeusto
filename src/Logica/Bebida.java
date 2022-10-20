package Logica;

public class Bebida extends Producto{

	public Bebida(String nombre, double precio, int id) {
		super(nombre, precio, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bebida [nombre=" + getNombre() + ", precio=" + getPrecio() + ", Id=" + getId() + "]";
	}
	
}
