package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BD.BD;
import Logica.Bebida;
import Logica.Comida;
import Logica.Menu;
import Logica.Menu_FinDeSemana;
import Logica.Producto;

public class testMenu {
	
	BD bd = new BD();
	private Menu men;
	private String idMen="1A";
	private HashMap<String, List<Producto>> hmPods = new HashMap<>();
	private ArrayList<Producto> comida = new ArrayList<>();
	private ArrayList<Producto> Bebida = new ArrayList<>();
	private int numProd=4;
	private double precioTot = 10;
	private Comida producto;
	private Comida producto1;
	private Comida producto2;
	private Bebida producto3;
	
	
	@Before
	public void setUp() throws Exception {
		producto = new Comida(idMen, 25, 1, 1,"1A");
		producto1 =  new Comida(idMen, 25, 1, 1,"1A");
		producto2 = new Comida(idMen, 25, 1, 1,"1A");
		producto3 = new Bebida(idMen, precioTot, numProd, 10, false);
		comida.add(producto);
		comida.add(producto1);
		comida.add(producto2);
		Bebida.add(producto3);
//		hmPods = bd.obtenerProductos();
		hmPods.putIfAbsent("Comida", comida);
		hmPods.putIfAbsent("Bebida", Bebida);
		men = new Menu(idMen, hmPods, numProd, precioTot);
		
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
		assertEquals(hmPods, men.getpL());
	}

	@Test
	public void testSetpL() {
		men.setpL(hmPods);
		assertEquals(hmPods, men.getpL());
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
		assertEquals(hmPods, men.getpL());
	}

	@Test
	public void testSetaProducto() {
		men.setpL(hmPods);
		assertEquals(hmPods, men.getpL());
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
		assertEquals(85, men.obtenerPreciototal(hmPods),0);
	}

}
