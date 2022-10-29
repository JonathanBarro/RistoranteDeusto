package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Usuario;

public class testUsuario {
	private Usuario usuario;
	private String nombre = "Manolo";
	private String apellido = "Martinez";
	private String contrasenia = "1a2b3c4d";
	private String toString = "usuario [nombre = Manolo, apellido = Martinez, contraseña = 1a2b3c4d]";
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario(nombre,apellido,contrasenia);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testUsuario() {
		assertNotNull("Usuario");
	}

	@Test
	public void testGetNombre() {
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	public void testSetNombre() {
		usuario.setNombre("Manolo");
		assertEquals("Manolo", usuario.getNombre());
	}

	@Test
	public void testGetApellido() {
		assertEquals(apellido, usuario.getApellido());
	}

	@Test
	public void testSetApellido() {
		usuario.setApellido("Martinez");
		assertEquals("Martinez", usuario.getApellido());
	}

	@Test
	public void testGetContrasenia() {
		assertEquals(contrasenia, usuario.getContrasenia());
	}

	@Test
	public void testSetContrasenia() {
		usuario.setContrasenia("1a2b3c4d");
		assertEquals("1a2b3c4d" ,usuario.getContrasenia());
	}

}
