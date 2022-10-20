package Logica;

import java.util.ArrayList;

public class Terraza {
	
	
	private int numMesasExterior;
	private ArrayList<Mesa> mLExterior = new ArrayList<>();
	
	
	
	public Terraza(int numMesasExterior, ArrayList<Mesa> mLExterior) {
		super();
		this.numMesasExterior = numMesasExterior;
		this.mLExterior = mLExterior;
	}



	public int getNumMesas() {
		return numMesasExterior;
	}



	public void setNumMesas(int numMesas) {
		this.numMesasExterior = numMesas;
	}



	public ArrayList<Mesa> getmL() {
		return mLExterior;
	}



	public void setmL(ArrayList<Mesa> mL) {
		this.mLExterior = mL;
	}



	@Override
	public String toString() {
		return "Terraza [numMesasExterior=" + numMesasExterior + ", mLExterior=" + mLExterior + "]";
	}
	
	
	

}
