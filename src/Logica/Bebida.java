package Logica;

public class Bebida extends Producto{

	private boolean frio;

	public Bebida(String nombre, double precio, int id, int stock, boolean frio) {
		super(nombre, precio, id, stock);
		this.frio = frio;
	}

	public boolean isFrio() {
		return frio;
	}


	public void setFrio(boolean frio) {
		this.frio = frio;
	}


	@Override
	public String toString() {
		return  getNombre() + " " + getPrecio() + "€" ;
	}
	
}
