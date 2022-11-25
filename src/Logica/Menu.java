package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {
	
	private String id;
	private HashMap<String, List<Producto>> hmProds;
	private int numProductos;
	private double precioTotal;
	

	public Menu() {

	}
	
	public Menu(String id, HashMap<String, List<Producto>> hmProds, int numProductos, double precioTotal) {
		super();
		this.id = id;
		this.hmProds = hmProds;
		this.numProductos = numProductos;
		this.precioTotal = precioTotal;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public HashMap<String, List<Producto>> getpL() {
		return hmProds;
	}
	

	public void setpL(HashMap<String, List<Producto>> hmProds) {
		this.hmProds = hmProds;
	}


	public int getNumProductos() {
		return numProductos;
	}


	public void setNumProductos(int numProductos) {
		this.numProductos = numProductos;
	}


	public double getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public double obtenerPreciototal(HashMap<String, List<Producto>> hmProds) {
		double sumaTotal = 0;
		for (Producto producto : hmProds.get("Comida")) {
			sumaTotal += producto.getPrecio();
		}
		for (Producto producto : hmProds.get("Bebida")) {
			sumaTotal += producto.getPrecio();
		}
		return sumaTotal;
	}
	
}
