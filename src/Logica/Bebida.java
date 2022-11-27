package Logica;

public class Bebida extends Producto{

	private boolean frio;
	
	
	public Bebida() {

	}

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
		if( this.isFrio() == false) {
		return  getNombre() + " " + getPrecio() + " € del tiempo"  ;
		}else {
			return  getNombre() + " " + getPrecio() + " € fria"  ;
		}
	}
	
}
