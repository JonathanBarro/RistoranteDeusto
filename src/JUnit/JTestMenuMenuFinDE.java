package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Menu;
import Logica.Menu_FinDeSemana;
import Logica.Producto;

public class JTestMenuMenuFinDE {
	
	Menu men;
	private String idMen="1A";
	private ArrayList<Producto> pL = new ArrayList<>();
	private int numProd=4;
	private int numPersonas=6;
	Menu_FinDeSemana menDdS;
	

	@Before
	public void setUp() throws Exception {
		men = new Menu(idMen, pL, numProd);
		menDdS = new Menu_FinDeSemana(idMen, pL, numProd, numPersonas);
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

	@Test
	public void testMenu() {
		assertNotNull(men);
	}

	@Test
	public void testMenuStringArrayListOfProductoInt() {
		
	}

	@Test
	public void testGetId() {
		assertEquals(idMen, men.getId());
	}

	@Test
	public void testSetId() {
		men.setId(idMen);
		assertEquals(idMen, men.getId());
		
		
	}

	@Test
	public void testGetpL() {
		assertEquals(pL, men.getpL());
	}

	@Test
	public void testSetpL() {
		men.setpL(pL);
		assertEquals(pL, men.getpL());
	}

	@Test
	public void testGetNumProductos() {
		assertEquals(numProd, men.getNumProductos());
	}

	@Test
	public void testSetNumProductos() {
		men.setNumProductos(5);
		assertEquals(numProd+1, men.getNumProductos());
		
	}

}
