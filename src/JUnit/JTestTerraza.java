package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Mesa;
import Logica.Terraza;

public class JTestTerraza {
	Terraza tr;
	int nMe=3;
	ArrayList<Mesa> ms = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		tr = new Terraza(nMe, ms);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testTerraza() {
		assertNotNull(tr);
	}

	@Test
	public void testGetNumMesas() {
		assertEquals(nMe,tr.getNumMesas());
	}

	@Test
	public void testSetNumMesas() {
		tr.setNumMesas(4);
		assertEquals(nMe+1, tr.getNumMesas());
	}

	@Test
	public void testGetmL() {
		assertEquals(ms, tr.getmL());
	}

	@Test
	public void testSetmL() {
		tr.setmL(ms);
		assertEquals(ms, tr.getmL());
	}

	@Test
	public void testToString() {
		assertEquals("Terraza [numMesasExterior=" + nMe + ", mLExterior=" + ms + "]", tr.toString());

	}

}
