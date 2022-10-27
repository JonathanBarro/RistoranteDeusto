package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Menu;
import Logica.Menu_FinDeSemana;
import Logica.Producto;

public class testMenud_Finde {
	
	private String idMen="1A";
	private ArrayList<Producto> pL = new ArrayList<>();
	private int numProd=4;
	private int numPersonas=6;
	private double precioTot = 10;
	Menu_FinDeSemana menDdS;

	@Before
	public void setUp() throws Exception {
		menDdS = new Menu_FinDeSemana(idMen, pL, numProd, precioTot,numPersonas);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMenu_FinDeSemana() {
		assertNotNull(menDdS);
	}

	@Test
	public void testGetNumPersonas() {
		assertEquals(numPersonas, menDdS.getNumPersonas());
	}

	@Test
	public void testSetNumPersonas() {
		menDdS.setNumPersonas(4);
		assertEquals(numPersonas-2, menDdS.getNumPersonas());
	}

	@Test
	public void testToString() {
		assertEquals(idMen + " : " + "	Platos :  " + pL + "  Número de platos : "
				+ numProd, menDdS.toString());
	}

}
