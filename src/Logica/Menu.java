package Logica;

import java.util.ArrayList;

public class Menu {
	
	private String id;
	private ArrayList<Producto> aProducto = new ArrayList<>();
	private int numProductos;
	
	
	public Menu(){
		
	}
	
	
	public Menu(String id, ArrayList<Producto> aProducto, int numProductos) {
		super();
		this.id = id;
		this.aProducto = aProducto;
		this.numProductos = numProductos;
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

	
	
}
