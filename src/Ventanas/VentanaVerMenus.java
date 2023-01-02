package Ventanas;

import java.awt.EventQueue;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BD.BD;
import Logica.Bebida;
import Logica.Comida;
import Logica.Menu;

import Logica.Menu_Infantil;
import Logica.Producto;



import java.awt.BorderLayout;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;


public class VentanaVerMenus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BD bd = new BD();
	
	public VentanaVerMenus() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 150);
		
//		List<Comida> aComid2 = bd.obtenerDatosComidas();
		ArrayList<Producto> aComida = new ArrayList<>();
		ArrayList<Producto> aBebdia = new ArrayList<>();
		Comida p1 = new Comida("Plato1", 10.1,01,1,"1A");
		Comida p2 = new Comida("Plato2", 10.1,02,1,"1A");
		Comida p3 = new Comida("Plato3", 10.1,03,1,"1A");
		Bebida b1 = new Bebida("Bebida1", 10.1,3,1,true);
		Bebida b2 = new Bebida("Bebida2", 10.1,3,1,true);
		
		aComida.add(p1);
		aComida.add(p2);
		aComida.add(p3);
		
		aBebdia.add(b1);
		aBebdia.add(b2);
		
		HashMap<String, List<Producto>> hmProds = new HashMap<>();
		
		hmProds.putIfAbsent("Bebida", aBebdia);
		hmProds.putIfAbsent("Comida", aComida);
		
		double precioTot=0;
		
		
		Menu m1 = new Menu("Menu_Degustacion", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot, "");
		Menu m2 = new Menu("Menu_EntreSemana", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot, "");
		Menu m3 = new Menu("Menu_Infantil", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot,"");
		Menu m4 = new Menu("Menu_FinDeSemana", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot, "");
		
		
		m1.setPrecioTotal(m1.obtenerPreciototal(hmProds));
		m2.setPrecioTotal(m2.obtenerPreciototal(hmProds));
		m3.setPrecioTotal(m3.obtenerPreciototal(hmProds));
		m4.setPrecioTotal(m4.obtenerPreciototal(hmProds));
		
		JLabel lblDegus = new JLabel(m1.toString());
		JLabel lblEntre = new JLabel(m2.toString());
		JLabel lblFinDe = new JLabel(m4.toString());
		JLabel lblInfant = new JLabel(m3.toString());
		JPanel panel = new JPanel(new FlowLayout());
		
		
		panel.add(lblDegus);
		panel.add(lblEntre);
		panel.add(lblFinDe);
		panel.add(lblInfant);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
