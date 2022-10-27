package Logica;

public class Producto {
	
	private String nombre;
	private double precio;
	private int id;
	private int stock;
	
	
	public Producto(String nombre, double precio, int id, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
		this.stock = stock;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	
}
