package Logica;

public class Comida extends Producto{

	private String idMenu;
	
	public Comida() {

	}
	
	public Comida(String nombre, double precio, int id, int stock) {
		// TODO Auto-generated constructor stub
		
	}
	
	public Comida(String nombre, double precio, int id, int stock, String idMenu) {
		super(nombre, precio, id, stock);
		// TODO Auto-generated constructor stub
		this.idMenu = idMenu;
	}

	public String getIdMenu() {
		return idMenu;
	}


	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}


	@Override
	public String toString() {
		return  getNombre() + " " + getPrecio() + "€ " + getId() + " - " + getStock();
	}
}
