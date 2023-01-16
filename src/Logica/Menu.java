package Logica;

import java.util.HashMap;
import java.util.List;

public class Menu {
	
	private Integer id;
	private HashMap<String, List<? extends Producto>> hmProds;
	private int numProductos;
	private double precioTotal;
	private String caracteristicas;

	public Menu() {

	}
	
	public Menu(Integer id, HashMap<String, List<? extends Producto>> hmProds, int numProductos, double precioTotal,String caracteristicas) {
		super();
		this.id = id;
		this.hmProds = hmProds;
		this.numProductos = numProductos;
		this.precioTotal = precioTotal;
		this.caracteristicas = caracteristicas;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public HashMap<String, List<? extends Producto>> getpL() {
		return hmProds;
	}
	

	public void setpL(HashMap<String, List<? extends Producto>> hmProds1) {
		this.hmProds = hmProds1;
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
	
	
	
	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public double obtenerPreciototal(HashMap<String, List<? extends Producto>> hashMap) {
		double sumaTotal = 0;
		for (Producto producto : hashMap.get("Comida")) {
			sumaTotal += producto.getPrecio();
		}
		for (Producto producto : hashMap.get("Bebida")) {
			sumaTotal += producto.getPrecio();
		}
		return sumaTotal;
	}
	public int contarProds() {
		int cont = 0;
		cont += this.getpL().get("Comida").size();
		cont += this.getpL().get("Bebida").size();
		return cont;
	}

	
	public String toStringMenu() {
		return "Menu: " + id;
		
	}
	@Override
	public String toString() {
		return "Menu: id = " + id + ", hmProds = " + hmProds + ", numProductos = " + numProductos + ", precioTotal = "
				+ precioTotal + ", caracteristicas = " + caracteristicas + "]";
	}

	
}
