package Ventanas;




import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame{


	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */


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
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelIzq, BorderLayout.WEST);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblRegis = new JLabel("Registro");
		lblRegis.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		panelNorth.add(lblRegis);
		
		JPanel panelDer = new JPanel();
		panelDer.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelDer, BorderLayout.EAST);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelCent = new JPanel();
		panelCent.setBackground(new Color(255, 255, 128));
		getContentPane().add(panelCent, BorderLayout.CENTER);
		panelCent.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(106, 22, 99, 14);
		panelCent.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(106, 56, 129, 14);
		panelCent.add(lblApellido);
		
		JLabel lblContrasenia = new JLabel("Contrasenya");
		lblContrasenia.setBounds(106, 92, 129, 14);
		panelCent.add(lblContrasenia);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de telefono");
		lblNewLabel_3.setBounds(106, 131, 136, 14);
		panelCent.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(231, 19, 96, 20);
		panelCent.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(231, 53, 96, 20);
		panelCent.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(231, 92, 96, 20);
		panelCent.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(231, 128, 96, 20);
		panelCent.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnRegis = new JButton("Regristrarse");
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio window = new VentanaInicio();
				window.setVisible(true);
			}
		});
		btnRegis.setBackground(new Color(255, 128, 64));
		btnRegis.setBounds(226, 175, 129, 23);
		panelCent.add(btnRegis);
		
		JButton btnVolver = new JButton("<-");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio window = new VentanaInicio();
				window.setVisible(true);
			}
		});
		btnVolver.setForeground(new Color(0, 128, 255));
		btnVolver.setBounds(37, 175, 89, 23);
		panelCent.add(btnVolver);
	}

}
