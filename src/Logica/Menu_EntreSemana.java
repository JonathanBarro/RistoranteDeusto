package Logica;

import java.util.ArrayList;

public class Menu_EntreSemana extends Menu{
	
	private boolean descuentoEstudiantes;//Si es estudiantes se le aplica un 15% de descuento
	
	
	public Menu_EntreSemana() {

	}

	public Menu_EntreSemana(String id, ArrayList<Producto> aProducto, int numProductos, double precioTotal,
			boolean descuentoEstudiantes) {
		super(id, aProducto, numProductos, precioTotal);
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
		return getId() + " : " + "	Platos :  " + getpL() + "  Número de platos : "
				+ getNumProductos() + " precio del menu: " + getPrecioTotal();
	}
}
