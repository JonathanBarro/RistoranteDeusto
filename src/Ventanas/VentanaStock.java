package Ventanas;
import Logica.Comida;


import Logica.Producto;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.BD;

import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaStock extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Producto> listaProductos;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel modelo;

	BD bd = new BD();
	
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
		
	
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		JLabel txtAreaStock= new JLabel();
		txtAreaStock.setFont(new Font("Times New Roman" , Font.BOLD, 28));
		txtAreaStock.setBounds(10, 10, 200, 30);
		
		JButton btnVolver= new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelSur.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaInicio window= new VentanaInicio();
				window.setVisible(true);
				dispose();
				
				
			}
		});
		
		
	
	
	listaProductos=bd.obtenerDatosComidas();
	
		JButton CambiarPrecio= new JButton("Cambiar el precio");
		panelSur.add(CambiarPrecio);
		
		

		modelo = new DefaultTableModel();
		
		String [] titulos = {"NOMBRE","ID","PRECIO","STOCK"};
		modelo.setColumnIdentifiers(titulos);
		for (Producto p : listaProductos) {
			String [] datos = {p.getNombre()+"",p.getId()+""+ p.getPrecio()+ ""+ p.getStock()+""};
			modelo.addRow(datos);
		}
		
		
		table = new JTable(modelo);
		scroll = new JScrollPane(table);
		contentPane.add(scroll, BorderLayout.CENTER);
		
	}

}

