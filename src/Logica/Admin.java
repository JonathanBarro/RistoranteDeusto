package Logica;

public class Admin extends Usuario{

	private int idAdmin;
	private double sueldo;
	
	
	
	public Admin() {

	}
	
	
	public Admin(String nombre, String apellido, String contrasenia, int idAdmin, double sueldo) {
		super(nombre, apellido, contrasenia);
		this.idAdmin = idAdmin;
		this.sueldo = sueldo;
	}
	
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", sueldo=" + sueldo + ", nombre=" + getNombre() + ", apellido="
				+ getApellido() + ", contrasenia=" + getContrasenia() + "]";
	}
	
	
}
