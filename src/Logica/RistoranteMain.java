package Logica;


import java.util.ArrayList;
import java.util.List;

import BD.BD;
import Ventanas.VentanaAdminCliente;

public class RistoranteMain {
	public static BD bd;
	public static void main(String[] args) {
		
		bd = new BD();	
		bd.borrarDatos();
	    bd.borrarBBDD();
		VentanaAdminCliente window = new VentanaAdminCliente();
		window.setVisible(true);
		
		//CREATE DATABASE: Se crea la BBDD
		bd.crearBBDD();
		
		//INSERT: Insertar datos en la BBDD		
		cargarBD(bd);
		
//		List<Cliente> clientes = bd.obtenerDatosClientes();
//		printClientes(clientes);
//		List<Producto> bebidas = bd.obtenerDatosBebidas();
//		printBebidas(bebidas);
//		bd.cambiarPrecio(bebidas.get(0), 4); 
//		bebidas = bd.obtenerDatosBebidas();
//		printBebidas(bebidas);
//		
//		List<Admin> admins = bd.obtenerDatosAdmins();
//		printAdmin(admins);
//		
		List<Producto> comidas = bd.obtenerDatosComidas();
		printComida(comidas);
//		
		List<Mesa> mesas = bd.obtenerDatosMesas();
		printMesa(mesas);
//		
		List<Reserva> reservas = bd.obtenerDatosReservas();
		printReserva(reservas);
//		
//		List<Menu_Degustacion> menuDegustacion = bd.obtenerDatosMenu_Degustacion();
//		printMenu_Degustacion(menuDegustacion);
//		
//		List<Menu_EntreSemana>menuEntreSemanas = bd.obtenerDatosMenu_EntreSemana();
//		printMenu_EntreSemana(menuEntreSemanas);
//		
		List<Menu> menuFinDeSemanas = bd.obtenerDatosMenu();
		printMenu_FinDeSemana(menuFinDeSemanas);
//		
//		List<Menu_Infantil> menuInfantiles = bd.obtenerDatosMenu_Infantil();
//		printMenu_Infantil(menuInfantiles);
		
		//PARA LA PARTE DEL ADMIN
		
//		bd.borrarCliente(1);
//		List<Cliente> clientes2 = bd.obtenerDatosClientes();
//		printClientes(clientes2);
//		
//		bd.borrarComida(3);
//		List<Comida> comida2 = bd.obtenerDatosComidas();
//		printComida(comida2);
//		
//		bd.borrarBebida(123);
//		List<Bebida> bebida2 = bd.obtenerDatosBebidas();
//		printBebidas(bebida2);
//		
//		
//		bd.borrarReserva(2);
//		List<Reserva> reserva2 = bd.obtenerDatosReservas();
//		printReserva(reserva2);
		
		//ACABAPARTE DEL ADMIN
		

	
	}
	private static void cargarBD(BD bd) {
		List<Cliente> clientes = initClientes();
		List<Admin> admins = initAdmin();
		List<Bebida> bebidas = initBebidas();
		List<Comida> comidas = initComidas();
		List<Menu> menuInfantiles = initMenu();
		List<Mesa> mesas = initMesa();
		List<Reserva> reservas = initReservas();
		bd.insertarDatos(clientes, admins, bebidas, comidas, menuInfantiles, mesas, reservas);
	}
	
	private static void printClientes(List<Cliente> clientes) {
		if (!clientes.isEmpty()) {		
			for(Cliente cliente : clientes) {
				System.out.println(String.format(" - %s", cliente.toString()));
			}
		}		
	}
	
	public static List<Cliente> initClientes() {
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente cliente = new Cliente();
		cliente.setNombre("Bruce Banner");
		cliente.setApellido("hulk@gmail.com");
		cliente.setContrasenia("NUcRn8h85RZZTjg6UBwa");
		cliente.setNumTlfn(1);
		clientes.add(cliente);
		
		return clientes;
	}
	
	
	
	private static void printAdmin(List<Admin> admins) {
		if (!admins.isEmpty()) {		
			for(Admin admin : admins) {
				System.out.println(String.format(" - %s", admin.toString()));
			}
		}		
	}
	
	public static List<Admin> initAdmin() {
		List<Admin> admins = new ArrayList<>();
		
		Admin admin = new Admin();
		admin.setNombre("NomA1");
		admin.setApellido("ApeA1");
		admin.setIdAdmin(12);
		admin.setSueldo(2234);
		admin.setContrasenia("123");
		admins.add(admin);
		
		return admins;
	}
	
	private static void printBebidas(List<Producto> bebidas) {
		if (!bebidas.isEmpty()) {		
			for(Producto bebida : bebidas) {
				System.out.println(String.format(" - %s", bebida.toString()));
			}
		}		
	}
	
	public static List<Bebida> initBebidas() {
		List<Bebida> bebidas = new ArrayList<>();
		
		Bebida bebida = new Bebida();
		bebida.setNombre("Cocacola");
		bebida.setPrecio(2);
		bebida.setId(123);
		bebida.setStock(3);
		bebida.setFrio(false);
		bebidas.add(bebida);
		
		return bebidas;
	}
	
	
	private static void printComida(List<Producto> comidas) {
		if (!comidas.isEmpty()) {		
			for(Producto comida : comidas) {
				System.out.println(String.format(" - %s", comida.toString()));
			}
		}		
	}
	
	public static List<Comida> initComidas() {
		List<Comida> comidas = new ArrayList<>();
		
		Comida comida = new Comida();
		comida.setNombre("Spagueti");
		comida.setPrecio(6);
		comida.setId(3);
		comida.setStock(6);
		comidas.add(comida);
		comida.setIdMenu("1A");
		
		return comidas;
	}
	
	


	

	
	private static void printMenu_FinDeSemana(List<Menu> menuFinDeSemanas) {
		if (!menuFinDeSemanas.isEmpty()) {		
			for(Menu mFS : menuFinDeSemanas) {
				System.out.println(String.format(" - %s", mFS.toString()));
			}
		}		
	}
	
	public static List<Menu> initMenu() {
		List<Menu> menuFinDeSemanas = new ArrayList<>();
		
		Menu mFS = new Menu();
		mFS.setId(3);
		mFS.setNumProductos(3);
		mFS.setCaracteristicas("Menu Fin de Semana");
		Menu mFS1 = new Menu();
		mFS.setId(1);
		mFS.setNumProductos(3);
		mFS.setCaracteristicas("Menu Infantil");
		Menu mFS2 = new Menu();
		mFS.setId(2);
		mFS.setNumProductos(3);
		mFS.setCaracteristicas("Menu Entre Semana");
		menuFinDeSemanas.add(mFS);
		menuFinDeSemanas.add(mFS1);
		menuFinDeSemanas.add(mFS2);
		return menuFinDeSemanas;
	}
	
	
	private static void printMesa(List<Mesa> mesas) {
		if (!mesas.isEmpty()) {		
			for(Mesa mesa : mesas) {
				System.out.println(String.format(" - %s", mesa.toString()));
			}
		}		
	}
	
	public static List<Mesa> initMesa() {
		List<Mesa> mesas = new ArrayList<>();
		
		Mesa mesa = new Mesa();
		mesa.setIdMesa("1z");
		mesa.setNumPersonas(3);
		mesa.setLugar(0);
		mesa.setOcupada(false);
		mesas.add(mesa);
		Mesa mesa1 = new Mesa();
		mesa1.setIdMesa("2z");
		mesa1.setNumPersonas(5);
		mesa1.setLugar(1);
		mesa1.setOcupada(true);
		mesas.add(mesa1);
		Mesa mesa3 = new Mesa();
		mesa3.setIdMesa("3z");
		mesa3.setNumPersonas(7);
		mesa3.setLugar(0);
		mesa3.setOcupada(false);
		mesas.add(mesa3);
		Mesa mesa5 = new Mesa();
		mesa5.setIdMesa("7z");
		mesa5.setNumPersonas(7);
		mesa5.setLugar(0);
		mesa5.setOcupada(false);
		mesas.add(mesa5);
		return mesas;
	}
	
	private static void printReserva(List<Reserva> reservas) {
		if (!reservas.isEmpty()) {		
			for(Reserva rs : reservas) {
				System.out.println(String.format(" - %s", rs.toString()));
			}
		}		
	}
	
	public static List<Reserva> initReservas() {
		List<Reserva> reservas = new ArrayList<>();
		
		Reserva reserva = new Reserva();
		reserva.setFecha("20-03-22");
		reserva.setIdReserva(2);
		reserva.setNumPersonas(3);
		reserva.setHora("14:00");
		reservas.add(reserva);
		
		return reservas;
	}
	
	
	

}