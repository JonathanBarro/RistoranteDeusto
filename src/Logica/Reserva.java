package Logica;


import java.util.ArrayList;


public class Reserva {
	
	private String fecha;
	private int numPersonas;
	private int idReserva;
	private ArrayList<Mesa> aMesa;
	private ArrayList<Menu> aMenu;
	private Cliente cliente;
	private String hora;
	
	
	public Reserva() {

		this.aMenu = new ArrayList<>();
		this.aMesa = new ArrayList<>();
	}
	
	public Reserva(String fecha, int numPersonas, int idReserva, ArrayList<Mesa> aMesa, ArrayList<Menu> aMenu,
			Cliente cliente) {
		super();
		this.fecha = fecha;
		this.numPersonas = numPersonas;
		this.idReserva = idReserva;
		this.aMesa = aMesa;
		this.aMenu = aMenu;
		this.cliente = cliente;
	}
	public Reserva(String fecha, int numPersonas, int idReserva, String hora) {
		super();
		this.fecha = fecha;
		this.numPersonas = numPersonas;
		this.idReserva = idReserva;
		this.hora = hora;
		this.aMenu = new ArrayList<>();
		this.aMesa = new ArrayList<>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public ArrayList<Mesa> getaMesa() {
		return aMesa;
	}

	public void setaMesa(ArrayList<Mesa> aMesa) {
		this.aMesa = aMesa;
	}

	public ArrayList<Menu> getaMenu() {
		return aMenu;
	}

	public void setaMenu(ArrayList<Menu> aMenu) {
		this.aMenu = aMenu;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Reserva [fecha=" + fecha + ", numPersonas=" + numPersonas + ", idReserva=" + idReserva + ", hora= "+ hora +"]";
	}
	
	public String toString1() {
		return "Reserva [fecha=" + fecha + ", numPersonas=" + numPersonas + ", idReserva=" + idReserva + ", aMesa="
				+ aMesa + ", aMenu=" + aMenu + ", cliente=" + cliente + "]";
	}
	
}
