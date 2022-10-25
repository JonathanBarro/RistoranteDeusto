package Logica;

public class Producto {
	
	private String nombre;
	private double precio;
	private int id;
	private int cantidad;
	
	
	public Producto(String nombre, double precio, int id, int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
		this.cantidad = cantidad;
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


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	
}
