package Logica;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Merch implements Serializable{
	
	private static final long serialVersionUID = 4974698442812198434L;

	public static enum Tipo{CAMISETA, SUDADERA}
	private String idMerch;
	private String color;
	private int talla;
	private float precio;
	private String imagen;
	private Tipo tipo;
	
	public Merch(String idMerch, String color, int talla, float precio, String imagen, Tipo tipo) {
		super();
		this.idMerch = idMerch;
		this.color = color;
		this.talla = talla;
		this.precio = precio;
		this.imagen = imagen;
		this.tipo = tipo;
	}

	public Merch() {
		super();
	}

	public String getIdMerch() {
		return idMerch;
	}

	public void setIdMerch(String idMerch) {
		this.idMerch = idMerch;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public ImageIcon getIcono() {
		return new ImageIcon(imagen);
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return tipo + " color: "+color+", talla: "+talla+" "+precio+"€";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Merch && ((Merch)obj).getIdMerch() == idMerch;
	}
	
	
	
}
