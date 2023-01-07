package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Mesa;

public class testMesa {
	
	private String idMesa="1";
	private int lugar=3;
	private boolean ocupada=false;
	private int numPersonas=1;
	Mesa mesa;
	
	@Before
	public void setUp() throws Exception {
		mesa= new Mesa(idMesa, numPersonas);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMesa() {
		assertNotNull(mesa);
	}

	@Test
	public void testGetSitiosmesa() {
		assertEquals(4, mesa.getSitiosmesa());
	}

	@Test
	public void testGetIdMesa() {
		assertEquals(idMesa, mesa.getIdMesa());
	}

	@Test
	public void testSetIdMesa() {
		mesa.setIdMesa("2");
		assertEquals("2", mesa.getIdMesa());
	}

	@Test
	public void testGetLugar() {
		assertEquals(lugar, mesa.getLugar());
	}

	@Test
	public void testSetLugar() {
		mesa.setLugar(2);
		assertEquals(lugar-1, mesa.getLugar());
	}

	@Test
	public void testIsOcupada() {
		assertEquals(ocupada, mesa.isOcupada());
	}

	@Test
	public void testSetOcupada() {
		mesa.setOcupada(true);
		assertEquals(ocupada=true, mesa.isOcupada());
	}

	@Test
	public void testToString() {
		assertEquals("Mesa [idMesa=" + idMesa + ", lugar=" + lugar + ", ocupada=" + ocupada + ", sitios por mesa="+ mesa.getSitiosmesa() + "]",mesa.toString());
	}

}
