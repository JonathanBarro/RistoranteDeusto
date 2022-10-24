package Logica;

import java.sql.Date;
import java.util.ArrayList;


public class Reserva {
	
	private Date fecha;
	private int numPersonas;
	private int idReserva;
	private ArrayList<Mesa> aMesa;
	private ArrayList<Menu> aMenu;
	private Cliente cliente;
	
	public Reserva(Date fecha, int numPersonas, int idReserva, ArrayList<Mesa> aMesa, ArrayList<Menu> aMenu,
			Cliente cliente) {
		super();
		this.fecha = fecha;
		this.numPersonas = numPersonas;
		this.idReserva = idReserva;
		this.aMesa = aMesa;
		this.aMenu = aMenu;
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	@Override
	public String toString() {
		return "Reserva [fecha=" + fecha + ", numPersonas=" + numPersonas + ", idReserva=" + idReserva + ", aMesa="
				+ aMesa + ", aMenu=" + aMenu + ", cliente=" + cliente + "]";
	}
	
	
	
}