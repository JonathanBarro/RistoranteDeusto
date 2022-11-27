package Ventanas;
import Logica.Comida;


import Logica.Producto;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;


public class VentanaStock extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Producto> listaProductos= new ArrayList<>();
	/**
	 * Create the application.
	 */

	public VentanaStock() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		panelNorte.add(lblStock);
		
		Comida macarrones= new Comida("macarrones", 5, 111,1);
		listaProductos.add(macarrones);
		
		
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		JLabel txtAreaStock= new JLabel();
		txtAreaStock.setFont(new Font("Times New Roman" , Font.BOLD, 28));
		txtAreaStock.setBounds(10, 10, 200, 30);
		
		JButton AñadirStock= new JButton("Añadir");
		panelSur.add(AñadirStock);
//		for (Producto p : listaProductos) {
//			
//			
//		}
		
		panelCentro.add(txtAreaStock);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	

}
