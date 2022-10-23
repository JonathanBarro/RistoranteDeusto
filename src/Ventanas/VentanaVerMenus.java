package Ventanas;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Comida;
import Logica.Menu;
import Logica.Menu_Degustacion;
import Logica.Menu_EntreSemana;
import Logica.Menu_Infantil;
import Logica.Producto;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;

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
		Comida p1 = new Comida("Plato1", 10.1,01);
		Comida p2 = new Comida("Plato2", 10.1,02);
		Comida p3 = new Comida("Plato3", 10.1,03);
		
		aComida.add(p1);
		aComida.add(p2);
		aComida.add(p3);
		
		Menu_Degustacion m1 = new Menu_Degustacion("Menu_Degustacion", aComida, aComida.size());
		Menu_EntreSemana m2 = new Menu_EntreSemana("Menu_EntreSemana", aComida, aComida.size());
		Menu_Infantil m3 = new Menu_Infantil("Menu_Infantil", aComida, aComida.size());
		Menu_Infantil m4 = new Menu_Infantil("Menu_FinDeSemana", aComida, aComida.size());
		
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
