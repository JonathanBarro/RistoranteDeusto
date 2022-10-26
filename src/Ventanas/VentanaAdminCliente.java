package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
		//Botones
		
		JButton btnAdmin = new JButton("Administrador");
		GridBagConstraints gbc_btnAdmin = new GridBagConstraints();
		gbc_btnAdmin.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdmin.gridx = 5;
		gbc_btnAdmin.gridy = 2;
		frame.getContentPane().add(btnAdmin, gbc_btnAdmin);
		
		JButton btnCliente = new JButton("Cliente");
		GridBagConstraints gbc_btnCliente = new GridBagConstraints();
		gbc_btnCliente.gridx = 5;
		gbc_btnCliente.gridy = 6;
		frame.getContentPane().add(btnCliente, gbc_btnCliente);
	}

}
