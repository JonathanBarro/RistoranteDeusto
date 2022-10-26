package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaRegistro {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEdad;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
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
	public VentanaRegistro() {
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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//Labels
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 1;
		frame.getContentPane().add(lblNombre, gbc_lblNombre);
		
		//TextFields
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.anchor = GridBagConstraints.WEST;
		gbc_textNombre.gridx = 4;
		gbc_textNombre.gridy = 2;
		frame.getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 4;
		gbc_lblApellido.gridy = 3;
		frame.getContentPane().add(lblApellido, gbc_lblApellido);
		
		
		textApellido = new JTextField();
		GridBagConstraints gbc_textApellido = new GridBagConstraints();
		gbc_textApellido.anchor = GridBagConstraints.WEST;
		gbc_textApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textApellido.gridx = 4;
		gbc_textApellido.gridy = 4;
		frame.getContentPane().add(textApellido, gbc_textApellido);
		textApellido.setColumns(10);
		
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.WEST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 4;
		gbc_lblEdad.gridy = 5;
		frame.getContentPane().add(lblEdad, gbc_lblEdad);
		
		
		textEdad = new JTextField();
		GridBagConstraints gbc_textEdad = new GridBagConstraints();
		gbc_textEdad.anchor = GridBagConstraints.WEST;
		gbc_textEdad.insets = new Insets(0, 0, 5, 5);
		gbc_textEdad.gridx = 4;
		gbc_textEdad.gridy = 6;
		frame.getContentPane().add(textEdad, gbc_textEdad);
		textEdad.setColumns(10);
		
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 4;
		gbc_lblTelefono.gridy = 7;
		frame.getContentPane().add(lblTelefono, gbc_lblTelefono);
		
		
		textTelefono = new JTextField();
		GridBagConstraints gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.anchor = GridBagConstraints.WEST;
		gbc_textTelefono.gridwidth = 2;
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.gridx = 4;
		gbc_textTelefono.gridy = 8;
		frame.getContentPane().add(textTelefono, gbc_textTelefono);
		textTelefono.setColumns(10);
		
		//Botones
		
		JButton btnVolverInicioSesion = new JButton("Inicio");
		btnVolverInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVolverInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolverInicioSesion.setBackground(Color.RED);
		GridBagConstraints gbc_btnVolverInicioSesion = new GridBagConstraints();
		gbc_btnVolverInicioSesion.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolverInicioSesion.gridx = 2;
		gbc_btnVolverInicioSesion.gridy = 10;
		frame.getContentPane().add(btnVolverInicioSesion, gbc_btnVolverInicioSesion);
		
		JButton btnConfirmarRegistro = new JButton("Registro");
		btnConfirmarRegistro.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConfirmarRegistro.setBackground(Color.GREEN);
		GridBagConstraints gbc_btnConfirmarRegistro = new GridBagConstraints();
		gbc_btnConfirmarRegistro.anchor = GridBagConstraints.WEST;
		gbc_btnConfirmarRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmarRegistro.gridx = 6;
		gbc_btnConfirmarRegistro.gridy = 10;
		frame.getContentPane().add(btnConfirmarRegistro, gbc_btnConfirmarRegistro);
	}

}
