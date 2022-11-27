package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class VentanaAdminCliente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdminCliente window = new VentanaAdminCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaAdminCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAdminCliente.class.getResource("/junit/runner/smalllogo.gif")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(new Color(255, 128, 64));
		frame.getContentPane().add(panelIzq, BorderLayout.WEST);
		
		JPanel panelDercha = new JPanel();
		panelDercha.setBackground(new Color(255, 128, 64));
		frame.getContentPane().add(panelDercha, BorderLayout.EAST);
		
		JPanel panelBajo = new JPanel();
		panelBajo.setBackground(new Color(255, 128, 64));
		frame.getContentPane().add(panelBajo, BorderLayout.SOUTH);
		
		JPanel panelNoth = new JPanel();
		panelNoth.setBackground(new Color(255, 128, 64));
		frame.getContentPane().add(panelNoth, BorderLayout.NORTH);
		
		JLabel lblRis = new JLabel("Ristorante");
		lblRis.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		panelNoth.add(lblRis);
		
		JPanel panelCent = new JPanel();
		panelCent.setBackground(new Color(255, 255, 128));
		frame.getContentPane().add(panelCent, BorderLayout.CENTER);
		
		JButton btnAmin = new JButton("Administrador");
		btnAmin.setBackground(new Color(255, 128, 64));
		panelCent.add(btnAmin);
		
		JButton btnNewButton_1 = new JButton("Cliente");
		btnNewButton_1.setBackground(new Color(255, 128, 64));
		btnNewButton_1.setVerticalAlignment(SwingConstants.CENTER);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCent.add(btnNewButton_1);
	}

}


