package Ventanas;

import java.util.Date;

import Logica.Menu;
import Logica.Reserva;

public class VentanaImprimirPedido extends VentanaImprimir{

	private static final long serialVersionUID = -7166440269767478647L;
	private Reserva res;
	
	public VentanaImprimirPedido(Reserva res) {
		super(null);
		this.res = res;
		cargarCarritoEnTextArea();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void cargarCarritoEnTextArea() {
		Date d = new Date(System.currentTimeMillis());
		//StringBuilser para concatenar strings y objetos.
		StringBuilder texto = new StringBuilder();
				texto.append("Factura de la compra del dia: " + sdf.format(d) + "\n------------------------------------\n");
		double total = 0;
		for(Menu m : res.getaMenu()) {
			total += m.getPrecioTotal();
			texto.append(m.toString().replace("\n", "") + "\n");
		}
		texto.append("------------------------------------\n");
		texto.append("Reserva de "+ res.getNumPersonas()+" personas en la(s) mesa(s) ");
		res.getaMesa().forEach(v -> texto.append(v.getIdMesa() + ", "));
		texto.setLength(texto.length() - 2);
		texto.append(" a las "+res.getHora()+"\n\n Total: "+total+"€");
		taResumen.setText(texto.toString());
	}

}
