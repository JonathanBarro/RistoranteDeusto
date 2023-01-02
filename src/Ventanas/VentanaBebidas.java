package Ventanas;

import java.awt.EventQueue;


import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Logica.Bebida;
import Logica.Comida;
import Logica.Menu;
import Logica.Producto;


import javax.swing.JScrollPane;

import BD.BD;

import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JList;

public class VentanaBebidas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BD bd = new BD();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBebidas frame = new VentanaBebidas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaBebidas() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 400);

//		List<Bebida> bebidas = bd.obtenerDatosBebidas();
		
		JRadioButton jrb1 = new JRadioButton("Cocacola");
		JRadioButton jrb2 = new JRadioButton("Kas");
		JRadioButton jrb3 = new JRadioButton("Acuarius");
		JRadioButton jrb4 = new JRadioButton("Agua");
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(jrb1);
		btnG.add(jrb2);
		btnG.add(jrb3);
		btnG.add(jrb4);
		
		JPanel pMedio = new JPanel(new FlowLayout());
		
		
		getContentPane().add(pMedio, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
	}

}
