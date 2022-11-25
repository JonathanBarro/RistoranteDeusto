package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu_EntreSemana extends Menu{
	
	public boolean descuentoEstudiantes;//Si es estudiantes se le aplica un 15% de descuento
	
	
	public Menu_EntreSemana() {

	}

	public Menu_EntreSemana(String id, HashMap<String, List<Producto>> hmProds, int numProductos, double precioTotal, boolean descuentoEstudiantes) {
		super(id, hmProds, numProductos, precioTotal);
		// TODO Auto-generated constructor stub
		this.descuentoEstudiantes = descuentoEstudiantes;
	}

	public boolean isDescuentoEstudiantes() {
		return descuentoEstudiantes;
	}



	public void setDescuentoEstudiantes(boolean descuentoEstudiantes) {
		this.descuentoEstudiantes = descuentoEstudiantes;
	}

	@Override
	public String toString() {
		return "Menu_EntreSemana [descuentoEstudiantes=" + descuentoEstudiantes + ", isDescuentoEstudiantes()="
				+ isDescuentoEstudiantes() + ", getId()=" + getId() + ", getpL()=" + getpL() + ", getNumProductos()="
				+ getNumProductos() + ", getPrecioTotal()=" + getPrecioTotal() + "]"; 
	}



}
