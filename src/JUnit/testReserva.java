package JUnit;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.Cliente;
import Logica.Menu;
import Logica.Mesa;
import Logica.Producto;
import Logica.Reserva;

public class testReserva {
	
	private String fecha = "10-12-2020"; 
	private int numPersonas = 2;
	private int idReserva = 11;
	private ArrayList<Mesa> aMesa = new ArrayList<>();
	private ArrayList<Mesa> aMesa2 = new ArrayList<>();
	private ArrayList<Menu> aMenu = new ArrayList<>();
	private ArrayList<Menu> aMenu2 = new ArrayList<>();
	private HashMap<String, List<Producto>> hmPods = new HashMap<>();
	private Cliente cliente;
	private Cliente cliente2;
	private Reserva reserva;
	private Mesa mesa;
	private Mesa mesa2;
	private Menu menu;
	private Menu menu2;
	

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("iker", "Mario", "123", 612123123);
		cliente2 = new Cliente("ander", "Perez", "123", 612123123);
		mesa = new Mesa("M1", 0, false,0);
		aMesa.add(mesa);
		mesa2 = new Mesa("M2", 1, true,0);
		aMesa2.add(mesa2);
		menu = new Menu("menu1", hmPods, 4, 10.5);
		aMenu.add(menu);
		menu2 = new Menu("menu2", hmPods, 3, 12.5);
		aMenu2.add(menu2);
		reserva = new Reserva(fecha, numPersonas, idReserva, aMesa, aMenu, cliente);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testReserva() {
		assertNotNull(reserva);
	}

	@Test
	public void testGetFecha() {
		assertEquals(fecha, reserva.getFecha());
	}

	@Test
	public void testSetFecha() {
		reserva.setFecha("11-10-2019");
		assertEquals("11-10-2019", reserva.getFecha());
	}

	@Test
	public void testGetNumPersonas() {
		assertEquals(numPersonas, reserva.getNumPersonas());
	}

	@Test
	public void testSetNumPersonas() {
		reserva.setNumPersonas(numPersonas-1);
		assertEquals(numPersonas-1, reserva.getNumPersonas());
	}

	@Test
	public void testGetIdReserva() {
		assertEquals(idReserva, reserva.getIdReserva());
	}

	@Test
	public void testSetIdReserva() {
		reserva.setIdReserva(idReserva-1);
		assertEquals(idReserva-1, reserva.getIdReserva());
	}

	@Test
	public void testGetaMesa() {
		assertEquals(aMesa, reserva.getaMesa());
	}

	@Test
	public void testSetaMesa() {
		reserva.setaMesa(aMesa2);
		assertEquals(aMesa2, reserva.getaMesa());
	}

	@Test
	public void testGetaMenu() {
		assertEquals(aMenu, reserva.getaMenu());
	}

	@Test
	public void testSetaMenu() {
		reserva.setaMenu(aMenu2);
		assertEquals(aMenu2, reserva.getaMenu());
	}

	@Test
	public void testGetCliente() {
		assertEquals(cliente, reserva.getCliente());
	}

	@Test
	public void testSetCliente() {
		reserva.setCliente(cliente2);
		assertEquals(cliente2, reserva.getCliente());
	}

	@Test
	public void testToString() {
		assertEquals("Reserva [fecha=" + fecha + ", numPersonas=" + numPersonas + ", idReserva=" + idReserva + "]", reserva.toString());
	}

}
