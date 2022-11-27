package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Bebida;

public class testBebida {
	
	private String nombre = "name";
	private double precio = 0;
	private int id = 11;
	private int stock = 12;
	private boolean frio = true;
	private Bebida bebida;
	
	@Before
	public void setUp() throws Exception {
		bebida = new Bebida(nombre, precio, id, stock, frio);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testBebida() {
		assertNotNull(bebida);
	}

	@Test
	public void testIsFrio() {
		assertEquals(true, bebida.isFrio());
	}

	@Test
	public void testSetFrio() {
		bebida.setFrio(false);
		assertEquals(false, bebida.isFrio());
	}

	@Test
	public void testToString() {
		//toString si es FRIA
		assertEquals(bebida.getNombre() + " " + bebida.getPrecio() + " € fria", bebida.toString());
		//toString si es DEL TIEMPO
		bebida.setFrio(false);
		assertEquals(bebida.getNombre() + " " + bebida.getPrecio() + " € del tiempo", bebida.toString());
	}

}
