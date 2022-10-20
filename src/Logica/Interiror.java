package Logica;

import java.util.ArrayList;

public class Interiror {
	
	private int numMesasInteriror;
	private ArrayList<Mesa> mLInterior = new ArrayList<>();
	
	
	
	public Interiror(int numMesasInteriror, ArrayList<Mesa> mLInterior) {
		super();
		this.numMesasInteriror = numMesasInteriror;
		this.mLInterior = mLInterior;
	}



	public int getNumMesas() {
		return numMesasInteriror;
	}



	public void setNumMesas(int numMesas) {
		this.numMesasInteriror = numMesas;
	}



	public ArrayList<Mesa> getmL() {
		return mLInterior;
	}



	public void setmL(ArrayList<Mesa> mL) {
		this.mLInterior = mL;
	}
	
	
	
	

}
