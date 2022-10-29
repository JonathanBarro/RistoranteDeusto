package Logica;

import java.util.ArrayList;

public class Menu {
	
	private String id;
	private ArrayList<Producto> aProducto = new ArrayList<>();
	private int numProductos;
	private double precioTotal;
	

	public Menu() {

	}
	
	public Menu(String id, ArrayList<Producto> aProducto, int numProductos, double precioTotal) {
		super();
		this.id = id;
		this.aProducto = aProducto;
		this.numProductos = numProductos;
		this.precioTotal = precioTotal;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ArrayList<Producto> getpL() {
		return aProducto;
	}
	

	public void setpL(ArrayList<Producto> aProducto) {
		this.aProducto = aProducto;
	}


	public int getNumProductos() {
		return numProductos;
	}


	public void setNumProductos(int numProductos) {
		this.numProductos = numProductos;
	}


	public ArrayList<Producto> getaProducto() {
		return aProducto;
	}


	public void setaProducto(ArrayList<Producto> aProducto) {
		this.aProducto = aProducto;
	}


	public double getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public double obtenerPreciototal(ArrayList<Producto> aProducto) {
		double sumaTotal = 0;
		for (Producto producto : aProducto) {
			sumaTotal += producto.getPrecio();
		}
		return sumaTotal;
	}
	
}
