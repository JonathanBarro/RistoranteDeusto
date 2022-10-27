package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Comida;
import Logica.Menu;
import Logica.Menu_FinDeSemana;
import Logica.Producto;

public class testMenu {
	
	private Menu men;
	private String idMen="1A";
	private ArrayList<Producto> pL = new ArrayList<>();
	private int numProd=4;
	private double precioTot = 10;
	private Comida producto;
	private Comida producto1;
	private Comida producto2;
	
	
	@Before
	public void setUp() throws Exception {
		men = new Menu(idMen, pL, numProd, precioTot);
		producto = new Comida(idMen, 25, 1, 1);
		producto1 =  new Comida(idMen, 25, 1, 1);
		producto2 = new Comida(idMen, 25, 1, 1);
		pL.add(producto);
		pL.add(producto1);
		pL.add(producto2);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMenu() {
		assertNotNull(men);
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

	@Test
	public void testGetaProducto() {
		assertEquals(pL, men.getpL());
	}

	@Test
	public void testSetaProducto() {
		men.setpL(pL);
		assertEquals(pL, men.getpL());
	}

	@Test
	public void testGetPrecioTotal() {
		assertEquals(precioTot, men.getPrecioTotal(),0);
	}

	@Test
	public void testSetPrecioTotal() {
		men.setPrecioTotal(precioTot-1);
		assertEquals(precioTot-1, men.getPrecioTotal(),0);
	}

	@Test
	public void testObtenerPreciototal() {
		assertEquals(75, men.obtenerPreciototal(pL),0);
	}

}
