package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Menu_EntreSemana;
import Logica.Menu_FinDeSemana;
import Logica.Producto;

public class testMenudEntreSemana {
	
	private String idMen="1B";
	private HashMap<String, List<Producto>> hmPods = new HashMap<>();
	private int numProd=6;
	private boolean estudiante=false;
	private double precioTot = 15;
	Menu_EntreSemana menFin;

	@Before
	public void setUp() throws Exception {
		menFin = new Menu_EntreSemana(idMen, hmPods, numProd, precioTot, estudiante);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMenu_EntreSemana() {
		assertNotNull(menFin);
	}

	@Test
	public void testIsDescuentoEstudiantes() {
		assertEquals(estudiante, menFin.isDescuentoEstudiantes());
	}

	@Test
	public void testSetDescuentoEstudiantes() {
		menFin.setDescuentoEstudiantes(true);
		assertEquals(estudiante=true, menFin.isDescuentoEstudiantes());
	}

	@Test
	public void testToString() {
		assertEquals( "Menu_EntreSemana [descuentoEstudiantes=" + menFin.descuentoEstudiantes + ", isDescuentoEstudiantes()="
				+ menFin.isDescuentoEstudiantes() + ", getId()=" + menFin.getId() + ", getpL()=" + menFin.getpL() + ", getNumProductos()="
				+ menFin.getNumProductos() + ", getPrecioTotal()=" + menFin.getPrecioTotal() + "]", menFin.toString());
	}

}
