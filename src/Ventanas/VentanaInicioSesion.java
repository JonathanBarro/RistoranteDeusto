package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VentanaInicioSesion {

	private JFrame frame;
	private JTextField textFieldContrasenia;
	private JTextField textFieldUsuario;
	private JButton btnVueltaInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioSesion window = new VentanaInicioSesion();
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
	public VentanaInicioSesion() {
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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//Labels
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 4;
		gbc_lblUsuario.gridy = 2;
		frame.getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblContrasenia = new GridBagConstraints();
		gbc_lblContrasenia.anchor = GridBagConstraints.WEST;
		gbc_lblContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasenia.gridx = 4;
		gbc_lblContrasenia.gridy = 5;
		frame.getContentPane().add(lblContrasenia, gbc_lblContrasenia);
		
		//TextFields
		textFieldContrasenia = new JTextField();
		GridBagConstraints gbc_textFieldContrasenia = new GridBagConstraints();
		gbc_textFieldContrasenia.anchor = GridBagConstraints.WEST;
		gbc_textFieldContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContrasenia.gridx = 4;
		gbc_textFieldContrasenia.gridy = 6;
		frame.getContentPane().add(textFieldContrasenia, gbc_textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
	
		textFieldUsuario = new JTextField();
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.anchor = GridBagConstraints.WEST;
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsuario.gridx = 4;
		gbc_textFieldUsuario.gridy = 3;
		frame.getContentPane().add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		//Boton
		JButton btnConfirmarInicio = new JButton("Iniciar Sesion");
		btnConfirmarInicio.setForeground(Color.BLACK);
		btnConfirmarInicio.setBackground(Color.GREEN);
		btnConfirmarInicio.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_btnConfirmarInicio = new GridBagConstraints();
		gbc_btnConfirmarInicio.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmarInicio.anchor = GridBagConstraints.WEST;
		gbc_btnConfirmarInicio.gridx = 6;
		gbc_btnConfirmarInicio.gridy = 9;
		frame.getContentPane().add(btnConfirmarInicio, gbc_btnConfirmarInicio);
		

		btnVueltaInicio = new JButton("Inicio");
		btnVueltaInicio.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVueltaInicio.setBackground(Color.RED);
		GridBagConstraints gbc_btnVueltaInicio = new GridBagConstraints();
		gbc_btnVueltaInicio.insets = new Insets(0, 0, 0, 5);
		gbc_btnVueltaInicio.gridx = 2;
		gbc_btnVueltaInicio.gridy = 9;
		frame.getContentPane().add(btnVueltaInicio, gbc_btnVueltaInicio);
	}

}











