package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Menu;
import Logica.Producto;

public class JTestMenuMenuFinDE {
	
	Menu men;
	private String idMen="1A";
	private ArrayList<Producto> pL = new ArrayList<>();
	private int numProd=4;
	

	@Before
	public void setUp() throws Exception {
		men = new Menu(idMen, pL, numProd);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMenu_FinDeSemana() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumPersonas() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumPersonas() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testMenu() {
		assertNotNull(men);
	}

	@Test
	public void testMenuStringArrayListOfProductoInt() {
		fail("Not yet implemented");
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
