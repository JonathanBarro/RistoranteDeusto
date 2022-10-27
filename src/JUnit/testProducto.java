package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Producto;

public class testProducto {

	private String nombre = "name";
	private double precio = 0;
	private int id = 11;
	private int stock = 12;
	Producto producto;
	
	@Before
	public void setUp() throws Exception {
		producto = new Producto(nombre, precio, id, stock);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testProducto() {
		assertNotNull(producto);
	}

	@Test
	public void testGetNombre() {
		assertEquals(nombre, producto.getNombre());
	}

	@Test
	public void testSetNombre() {
		producto.setNombre("Alvaro");
		assertEquals("Alvaro", producto.getNombre());
	}

	@Test
	public void testGetPrecio() {
		assertEquals(precio, producto.getPrecio(),0);
	}

	@Test
	public void testSetPrecio() {
		producto.setPrecio(20.5);
		assertEquals(20.5, producto.getPrecio(),0);
	}

	@Test
	public void testGetId() {
		assertEquals(id, producto.getId());
	}

	@Test
	public void testSetId() {
		producto.setId(22);
		assertEquals(22, producto.getId());
	}

	@Test
	public void testGetStock() {
		assertEquals(stock, producto.getStock());
	}

	@Test
	public void testSetStock() {
		producto.setStock(0);
		assertEquals(0, producto.getStock());
	}

}
