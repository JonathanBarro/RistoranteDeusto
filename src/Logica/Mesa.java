package Logica;

public class Mesa {
	
	static final int sitiosMesa = 4;
	private String idMesa;
	private int lugar;//para saber si se ubica dentro a fuera: 0 Dentro / 1 Fuera
	private boolean ocupada;
	private int numPersonas;
	
	
	
	public Mesa() {

		
	}

	public Mesa(String idMesa, int lugar, boolean ocupada,int numPersonas) {
		super();
		this.idMesa = idMesa;
		this.lugar = lugar;
		this.ocupada = ocupada;
		this.numPersonas = numPersonas;
		
	}


	public static int getSitiosmesa() {
		return sitiosMesa;
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
	
	


	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", lugar=" + lugar + ", ocupada=" + ocupada + ", numPersonas=" + numPersonas
				+ "]";
	}


	

}
