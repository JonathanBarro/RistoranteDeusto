package Logica;

import java.util.ArrayList;

public class Menu {
	
	String id;
	ArrayList<Producto> pL = new ArrayList<>();
	int numProductos;
	
	
	public Menu(){
		
	}
	
	
	public Menu(String id, ArrayList<Producto> pL, int numProductos) {
		super();
		this.id = id;
		this.pL = pL;
		this.numProductos = numProductos;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ArrayList<Producto> getpL() {
		return pL;
	}


	public void setpL(ArrayList<Producto> pL) {
		this.pL = pL;
	}


	public int getNumProductos() {
		return numProductos;
	}


	public void setNumProductos(int numProductos) {
		this.numProductos = numProductos;
	}


	@Override
	public String toString() {
		return "Menu [id=" + id + ", pL=" + pL + ", numProductos=" + numProductos + "]";
	}
	
	
	
	
}
