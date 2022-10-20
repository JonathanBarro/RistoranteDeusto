package Logica;

public class Mesa {
	
	int numSitios;
	String idMesa;
	int lugar;//para saber si se ubica dentro a fuera
	boolean ocupada;
	
	
	
	public Mesa(int numSitios, String idMesa, int lugar, boolean ocupada) {
		super();
		this.numSitios = numSitios;
		this.idMesa = idMesa;
		this.lugar = lugar;
		this.ocupada = ocupada;
	}



	public int getNumSitios() {
		return numSitios;
	}



	public void setNumSitios(int numSitios) {
		this.numSitios = numSitios;
	}



	public String getIdMesa() {
		return idMesa;
	}



	public void setIdMesa(String idMesa) {
		this.idMesa = idMesa;
	}



	public int getLugar() {
		return lugar;
	}



	public void setLugar(int lugar) {
		this.lugar = lugar;
	}



	public boolean isOcupada() {
		return ocupada;
	}



	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}



	@Override
	public String toString() {
		return "Mesa [numSitios=" + numSitios + ", idMesa=" + idMesa + ", lugar=" + lugar + ", ocupada=" + ocupada
				+ "]";
	}
	
	
	
	
	
	

}
