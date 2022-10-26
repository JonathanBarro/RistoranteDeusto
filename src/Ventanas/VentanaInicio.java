
package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

public class VentanaInicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio window = new VentanaInicio();
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
	public VentanaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//Botones 
		
		JButton btnInicioSesion = new JButton("Inicio Sesion");
		btnInicioSesion.setBackground(Color.GREEN);
		btnInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_btnInicioSesion = new GridBagConstraints();
		gbc_btnInicioSesion.insets = new Insets(0, 0, 5, 0);
		gbc_btnInicioSesion.gridx = 5;
		gbc_btnInicioSesion.gridy = 2;
		frame.getContentPane().add(btnInicioSesion, gbc_btnInicioSesion);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setBackground(Color.GREEN);
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.gridx = 5;
		gbc_btnRegistro.gridy = 6;
		frame.getContentPane().add(btnRegistro, gbc_btnRegistro);
	}

}





