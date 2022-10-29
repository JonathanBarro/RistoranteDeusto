package Logica;

public class Usuario {

	private String nombre;
	private String apellido;
	private String contrasenia;
	
	
	public Usuario() {

	}
	
	public Usuario(String nombre, String apellido, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
