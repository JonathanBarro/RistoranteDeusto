package Logica;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import BD.BD;

public class RistoranteMain {
	
	public static void main(String[] args) {
		
		
//		GestorBD gestorBD = new GestorBD();		
//		
//		//CREATE DATABASE: Se crea la BBDD
//		gestorBD.crearBBDD();
//		
//		//INSERT: Insertar datos en la BBDD		
//		List<Cliente> clientes = initClientes();
//		gestorBD.insertarDatos(clientes.toArray(new Cliente[clientes.size()]));
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
		admin.setApellido(null);
		admin.setIdAdmin(0);
		admin.setSueldo(0);
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
		bebida.setNombre("Bruce Banner");
		bebida.setPrecio(0);
		bebida.setId(0);
		bebida.setStock(0);
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
		comida.setNombre("Bruce Banner");
		comida.setPrecio(0);
		comida.getId();
		comida.setStock(0);
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
		menuDegustacion.setId(null);
		menuDegustacion.setNumProductos(0);
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
		mES.setId(null);
		mES.setDescuentoEstudiantes(false);
		mES.setNumProductos(0);
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
		mI.setId(null);
		mI.setNumProductos(0);
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
		mFS.setId(null);
		mFS.setNumProductos(0);
		mFS.setNumPersonas(0);
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
		mesa.setIdMesa(null);
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
		reserva.setFecha(null);
		reserva.setIdReserva(0);
		reserva.setNumPersonas(0);
		reservas.add(reserva);
		
		return reservas;
	}
	
	
	

}