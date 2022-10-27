package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Menu_EntreSemana;
import Logica.Menu_FinDeSemana;
import Logica.Producto;

public class testMenudEntreSemana {
	
	private String idMen="1B";
	private ArrayList<Producto> pL = new ArrayList<>();
	private int numProd=6;
	private boolean estudiante=false;
	private double precioTot = 15;
	Menu_EntreSemana menFin;

	@Before
	public void setUp() throws Exception {
		menFin = new Menu_EntreSemana(idMen, pL, numProd, precioTot, estudiante);
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
		assertEquals( idMen + " : " + "	Platos :  " + pL + "  Número de platos : "
				+ numProd + " precio del menu: " + precioTot, menFin.toString());
	}

}
