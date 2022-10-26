package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Interiror;
import Logica.Mesa;

public class JTestInterior {
	
	private Interiror interiror;
	private int numMes=3;
	private ArrayList<Mesa> ms = new ArrayList<>();
	private Mesa m1;
	

	@Before
	public void setUp() throws Exception {
		interiror = new Interiror(numMes,ms);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInteriror() {
		assertNotNull(interiror);
		
	}

	@Test
	public void testGetNumMesas() {
		assertEquals(numMes, interiror.getNumMesas());
		
	}

	@Test
	public void testSetNumMesas() {
		interiror.setNumMesas(4);
		assertEquals(numMes+1, interiror.getNumMesas());
		
		
	}

	@Test
	public void testGetmL() {
		assertEquals(ms, interiror.getmL());
		
	}

	@Test
	public void testSetmL() {
	interiror.setmL(ms);
	assertEquals(ms,interiror.getmL());
		
		
	}

}
