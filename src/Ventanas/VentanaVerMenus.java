package Ventanas;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;


import Logica.Comida;

import Logica.Menu_Degustacion;
import Logica.Menu_EntreSemana;
import Logica.Menu_FinDeSemana;
import Logica.Menu_Infantil;
import Logica.Producto;



import java.awt.BorderLayout;



import java.util.ArrayList;

import javax.swing.JLabel;


public class VentanaVerMenus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerMenus frame = new VentanaVerMenus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaVerMenus() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 150);
		
		ArrayList<Producto> aComida = new ArrayList<>();
		Comida p1 = new Comida("Plato1", 10.1,01,1);
		Comida p2 = new Comida("Plato2", 10.1,02,1);
		Comida p3 = new Comida("Plato3", 10.1,03,1);
		
		aComida.add(p1);
		aComida.add(p2);
		aComida.add(p3);
		
double precioTot=0;
		
		
		Menu_Degustacion m1 = new Menu_Degustacion("Menu_Degustacion", aComida, aComida.size(),precioTot);
		Menu_EntreSemana m2 = new Menu_EntreSemana("Menu_EntreSemana", aComida, aComida.size(), precioTot,false);
		Menu_Infantil m3 = new Menu_Infantil("Menu_Infantil", aComida, aComida.size(),precioTot);
		Menu_FinDeSemana m4 = new Menu_FinDeSemana("Menu_FinDeSemana", aComida, aComida.size(), precioTot,8);
		
		m1.setPrecioTotal(m1.obtenerPreciototal(aComida));
		m2.setPrecioTotal(m2.obtenerPreciototal(aComida));
		m3.setPrecioTotal(m3.obtenerPreciototal(aComida));
		m4.setPrecioTotal(m4.obtenerPreciototal(aComida));
		
		JLabel lblDegus = new JLabel(m1.toString());
		JLabel lblEntre = new JLabel(m2.toString());
		JLabel lblFinDe = new JLabel(m4.toString());
		JLabel lblInfant = new JLabel(m3.toString());
		JPanel panel = new JPanel();
		
		panel.add(lblDegus);
		panel.add(lblEntre);
		panel.add(lblFinDe);
		panel.add(lblInfant);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
