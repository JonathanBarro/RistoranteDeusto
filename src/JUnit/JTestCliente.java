package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Cliente;

public class JTestCliente {
	
	private Cliente cliente;
	private String nombre = "Iker"; 
	private String apellido = "Fuente"; 
	private String contrasenia = "123"; 
	private int numTlfn = 612123123;
	private String toString = "Cliente [numTlfn=612123123, nombre=Iker, apellido=Fuente, contrasenia=123]";

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente(nombre, apellido, contrasenia, numTlfn);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCliente() {
		assertNotNull(cliente);
	}

	@Test
	public void testGetNumTlfn() {
		assertEquals(numTlfn, cliente.getNumTlfn());
	}

	@Test
	public void testSetNumTlfn() {
		cliente.setNumTlfn(numTlfn-1);
		assertEquals(numTlfn-1, cliente.getNumTlfn());
	}

	@Test
	public void testToString() {
		assertEquals(toString, cliente.toString());
	}

}
