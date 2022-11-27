package Ventanas;


import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;


import javax.swing.JLabel;

public class VentanaAdminCliente extends JFrame {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaAdminCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAdminCliente.class.getResource("/junit/runner/smalllogo.gif")));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelIzq, BorderLayout.WEST);
		
		JPanel panelDercha = new JPanel();
		panelDercha.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelDercha, BorderLayout.EAST);
		
		JPanel panelBajo = new JPanel();
		panelBajo.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelBajo, BorderLayout.SOUTH);
		
		JPanel panelNoth = new JPanel();
		panelNoth.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelNoth, BorderLayout.NORTH);
		
		JLabel lblRis = new JLabel("Ristorante");
		lblRis.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		panelNoth.add(lblRis);
		
		JPanel panelCent = new JPanel();
		panelCent.setBackground(new Color(255, 255, 128));
		getContentPane().add(panelCent, BorderLayout.CENTER);
		
		JButton btnAmin = new JButton("Administrador");
		btnAmin.setBackground(new Color(255, 128, 64));
		panelCent.add(btnAmin);
		
		btnAmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicioAdmin window = new VentanaInicioAdmin();
				window.setVisible(true);
				
			}
		});
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBackground(new Color(255, 128, 64));
		btnCliente.setVerticalAlignment(SwingConstants.CENTER);
		btnCliente.setHorizontalAlignment(SwingConstants.CENTER);
		panelCent.add(btnCliente);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				VentanaInicio window = new VentanaInicio();
				window.setVisible(true);
				
			}
		});
		
		
	}

}


