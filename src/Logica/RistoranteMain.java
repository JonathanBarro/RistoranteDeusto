package Logica;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import BD.BD;

public class RistoranteMain {
	
	public static void main(String[] args) {
		
		BD bd = new BD();		
		
		//CREATE DATABASE: Se crea la BBDD
		//bd.crearBBDD();
		
		//INSERT: Insertar datos en la BBDD		
		//cargarBD(bd);
		
		List<Cliente> clientes = bd.obtenerDatosClientes();
		printClientes(clientes);
		List<Bebida> bebidas = bd.obtenerDatosBebidas();
		printBebidas(bebidas);
		bd.cambiarPrecio(bebidas.get(0), 4);
		bebidas = bd.obtenerDatosBebidas();
		printBebidas(bebidas);
		
		List<Admin> admins = bd.obtenerDatosAdmins();
		printAdmin(admins);
		
		List<Comida> comidas = bd.obtenerDatosComidas();
		printComida(comidas);
		
		List<Mesa> mesas = bd.obtenerDatosMesas();
		printMesa(mesas);
		
		List<Reserva> reservas = bd.obtenerDatosReservas();
		printReserva(reservas);
		
		List<Menu_Degustacion> menuDegustacion = bd.obtenerDatosMenu_Degustacion();
		printMenu_Degustacion(menuDegustacion);
		
		List<Menu_EntreSemana>menuEntreSemanas = bd.obtenerDatosMenu_EntreSemana();
		printMenu_EntreSemana(menuEntreSemanas);
		
		List<Menu_FinDeSemana> menuFinDeSemanas = bd.obtenerDatosMenu_FinDeSemana();
		printMenu_FinDeSemana(menuFinDeSemanas);
		
		List<Menu_Infantil> menuInfantiles = bd.obtenerDatosMenu_Infantil();
		printMenu_Infantil(menuInfantiles);
		
		//bd.borrarCliente(1);
		List<Cliente> clientes2 = bd.obtenerDatosClientes();
		printClientes(clientes2);
		
		//bd.borrarDatos();
		
		//bd.borrarBBDD();
	
	}
	private static void cargarBD(BD bd) {
		List<Cliente> clientes = initClientes();
		List<Admin> admins = initAdmin();
		List<Bebida> bebidas = initBebidas();
		List<Comida> comidas = initComidas();
		List<Menu_Degustacion> menuDegustacion = initMenu_Degustacion();
		List<Menu_EntreSemana> menuEntreSemanas = initMenu_EntreSemana();
		List<Menu_FinDeSemana> menuFinDeSemanas = initMenu_FinDeSemana();
		List<Menu_Infantil> menuInfantiles = initMenu_Infantil();
		List<Mesa> mesas = initMesa();
		List<Reserva> reservas = initReservas();
		bd.insertarDatos(clientes, admins, bebidas, comidas, menuDegustacion, menuEntreSemanas, menuFinDeSemanas, menuInfantiles, mesas, reservas);
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
		admins.add(admin);
		
		return admins;
	}
	
	private static void printBebidas(List<Bebida> bebidas) {
		if (!bebidas.isEmpty()) {		
			for(Bebida bebida : bebidas) {
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
	
	
	private static void printComida(List<Comida> comidas) {
		if (!comidas.isEmpty()) {		
			for(Comida comida : comidas) {
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
		
		return comidas;
	}
	
	
	private static void printMenu_Degustacion(List<Menu_Degustacion> menuDegustaciones) {
		if (!menuDegustaciones.isEmpty()) {		
			for(Menu_Degustacion mD : menuDegustaciones) {
				System.out.println(String.format(" - %s", mD.toString()));
			}
		}		
	}
	
	public static List<Menu_Degustacion> initMenu_Degustacion() {
		List<Menu_Degustacion> menuDegustaciones = new ArrayList<>();
		
		Menu_Degustacion menuDegustacion = new Menu_Degustacion();
		menuDegustacion.setId("1A");
		menuDegustacion.setNumProductos(3);
		menuDegustaciones.add(menuDegustacion);
		
		return menuDegustaciones;
	}
	
	
	private static void printMenu_EntreSemana(List<Menu_EntreSemana> menuEntreSemanas) {
		if (!menuEntreSemanas.isEmpty()) {		
			for(Menu_EntreSemana mES : menuEntreSemanas) {
				System.out.println(String.format(" - %s", mES.toString()));
			}
		}		
	}
	
	public static List<Menu_EntreSemana> initMenu_EntreSemana() {
		List<Menu_EntreSemana> menuEntreSemanas = new ArrayList<>();
		
		Menu_EntreSemana mES = new Menu_EntreSemana();
		mES.setId("1B");
		mES.setDescuentoEstudiantes(false);
		mES.setNumProductos(4);
		menuEntreSemanas.add(mES);
		
		return menuEntreSemanas;
	}
	
	
	private static void printMenu_Infantil(List<Menu_Infantil> menuInfantiles) {
		if (!menuInfantiles.isEmpty()) {		
			for(Menu_Infantil mI : menuInfantiles) {
				System.out.println(String.format(" - %s", mI.toString()));
			}
		}		
	}
	
	public static List<Menu_Infantil> initMenu_Infantil() {
		List<Menu_Infantil> menuInfantiles = new ArrayList<>();
		
		Menu_Infantil mI = new Menu_Infantil();
		mI.setId("3D");
		mI.setNumProductos(3);
		menuInfantiles.add(mI);
		
		return menuInfantiles;
	}
	
	
	private static void printMenu_FinDeSemana(List<Menu_FinDeSemana> menuFinDeSemanas) {
		if (!menuFinDeSemanas.isEmpty()) {		
			for(Menu_FinDeSemana mFS : menuFinDeSemanas) {
				System.out.println(String.format(" - %s", mFS.toString()));
			}
		}		
	}
	
	public static List<Menu_FinDeSemana> initMenu_FinDeSemana() {
		List<Menu_FinDeSemana> menuFinDeSemanas = new ArrayList<>();
		
		Menu_FinDeSemana mFS = new Menu_FinDeSemana();
		mFS.setId("3A");
		mFS.setNumProductos(3);
		mFS.setNumPersonas(6);
		menuFinDeSemanas.add(mFS);
		
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
		mesa.setLugar(0);
		mesa.setOcupada(false);
		mesas.add(mesa);
		
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
		reservas.add(reserva);
		
		return reservas;
	}
	
	
	

}