package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Admin;

public class testAdmin {
	private Admin admin;
	private String nombre = "Juanjo";
	private String apellido = "Perez";
	private String contrasenia = "contrasenia12345";
	private int idAdmin = 111;
	private double sueldo = 1500;
	
	@Before
	public void setUp() throws Exception {
		admin = new Admin(nombre, apellido, contrasenia, idAdmin, sueldo);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAdmin() {
		assertNotNull("admin");
	}


	@Test
	public void testGetNombre() {
		assertEquals(nombre, admin.getNombre());
	}

	@Test
	public void testSetNombre() {
		admin.setNombre("Juanjo");
		assertEquals("Juanjo", admin.getNombre());
	}

	@Test
	public void testGetApellido() {
		assertEquals(apellido, admin.getApellido());
	}

	@Test
	public void testSetApellido() {
		admin.setApellido("Perez");
		assertEquals("Perez", admin.getApellido());
	}

	@Test
	public void testGetContrasenia() {
		assertEquals(contrasenia, admin.getContrasenia());
	}

	@Test
	public void testSetContrasenia() {
		admin.setContrasenia("1a2b3c4d");
		assertEquals("1a2b3c4d" ,admin.getContrasenia());
	}

	@Test
	public void testGetIdAdmin() {
		assertEquals(idAdmin, admin.getIdAdmin());
	}

	@Test
	public void testSetIdAdmin() {
		admin.setIdAdmin(idAdmin-1);
		assertEquals(idAdmin-1, admin.getIdAdmin());
	}

	@Test
	public void testGetSueldo() {
		assertEquals(sueldo, admin.getSueldo(),0);
	}

	@Test
	public void testSetSueldo() {
		admin.setSueldo(sueldo-1);
		assertEquals(sueldo-1, admin.getSueldo(),0);
	}

	@Test
	public void testToString() {
		assertEquals("Admin [idAdmin=" + idAdmin + ", sueldo=" + sueldo + ", nombre=" + admin.getNombre() + ", apellido="
				+ admin.getApellido() +  "]", admin.toString());
	}

}


