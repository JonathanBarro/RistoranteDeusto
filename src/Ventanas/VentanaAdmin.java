package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaAdmin extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2955480294589424894L;
	
	public VentanaAdmin() {
		JButton btnStock = new JButton("Gestionar Stock");
		JButton btnMesas = new JButton("Gestionar Mesas");
		JButton btnVolver = new JButton("Volver");
		
		btnStock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaStock ventana = new VentanaStock();
				ventana.setVisible(true);
				dispose();
			}
			
		});
		
		btnMesas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAdminMesas ventana = new VentanaAdminMesas();
				ventana.setVisible(true);
				dispose();				
			}
			
		});
		
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventana = new VentanaInicio();
				ventana.setVisible(true);
				dispose();
			}
			
		});
		setSize(200, 150);
		getContentPane().setLayout(new FlowLayout());
		
		getContentPane().add(btnStock);
		getContentPane().add(btnMesas);
		getContentPane().add(btnVolver);
	}

}
