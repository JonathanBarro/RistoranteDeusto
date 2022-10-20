package Logica;

public class Comida extends Producto{

	public Comida(String nombre, double precio, int id) {
		super(nombre, precio, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comida [nombre=" + getNombre() + ", precio=" + getPrecio() + ", Id=" + getId() + "]";
	}
}
