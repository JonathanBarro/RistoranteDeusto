package Logica;

public class Cliente extends Usuario{

	private int numTlfn;

	public Cliente(String nombre, String apellido, String contrasenia, int numTlfn) {
		super(nombre, apellido, contrasenia);
		this.numTlfn = numTlfn;
	}

	public int getNumTlfn() {
		return numTlfn;
	}

	public void setNumTlfn(int numTlfn) {
		this.numTlfn = numTlfn;
	}

	@Override
	public String toString() {
		return "Cliente [numTlfn=" + numTlfn + ", nombre=" + getNombre() + ", apellido=" + getApellido()
				+ ", contrasenia=" + getContrasenia() + "]"; 
	}


	
	
}
