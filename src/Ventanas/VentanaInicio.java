
package Ventanas;

import javax.swing.JFrame;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BD.BD;
import Logica.RistoranteMain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldContrasena;
	
	JButton btnInicioSesion = new JButton("Iniciar Sesion");
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
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		getContentPane().setLayout(null);
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBounds(0, 44, 10, 209);
		panelIzq.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelIzq);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(0, 0, 436, 44);
		panelNorth.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelNorth);
		
		JLabel lblRisoteante = new JLabel("Inicio de Sesion");
		lblRisoteante.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		panelNorth.add(lblRisoteante);
		
		JPanel panelSur = new JPanel();
		panelSur.setBounds(0, 253, 436, 10);
		panelSur.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelSur);
		
		JPanel panelDe = new JPanel();
		panelDe.setBounds(426, 44, 10, 209);
		panelDe.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelDe);
		
		JPanel panelCent = new JPanel();
		panelCent.setBackground(new Color(255, 255, 128));
		panelCent.setBounds(10, 44, 416, 209);
		getContentPane().add(panelCent);
		panelCent.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(116, 43, 87, 14);
		panelCent.add(lblNewLabel);
		
		JTextField JTextField = new JTextField();
		JTextField.setBounds(213, 40, 96, 20);
		panelCent.add(JTextField);
		JTextField.setColumns(10);
		
		JLabel LabelContrasenya = new JLabel("Contrasenya:");
		LabelContrasenya.setBounds(116, 81, 87, 14);
		panelCent.add(LabelContrasenya);
		
		textFieldContrasena = new JPasswordField();
		textFieldContrasena.setBounds(213, 78, 96, 20);
		panelCent.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		JLabel lblNewLabelRegis = new JLabel("Si no tiene una cuenta creada pulse aqui");
		lblNewLabelRegis.setBounds(33, 170, 236, 14);
		panelCent.add(lblNewLabelRegis);
		
		JButton btnRegis = new JButton("Registrarse");
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro window = new VentanaRegistro();
				window.setVisible(true);
				dispose();
				
			}
		});
		JButton volver = new JButton("Voler");
		volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAdminCliente v = new VentanaAdminCliente();
				v.setVisible(true);
			}
		});
		panelCent.add(volver);
		btnRegis.setForeground(new Color(0, 128, 255));
		btnRegis.setBounds(271, 166, 104, 23);
		panelCent.add(btnRegis);
		
		
		JButton btnInicioSesion = new JButton("Iniciar Sesion");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String busqueda_cliente = BD.buscarClienteRegistrado(JTextField.getText(), textFieldContrasena.getText());		
				if(busqueda_cliente.equals("Cliente encontrado")) {
					String busqueda_nombre = BD.buscarNombre(JTextField.getText());
					JOptionPane.showMessageDialog(null, "Bienvenido al Ristorante \n"+ busqueda_nombre);
					EleccionInteriorExterior window = new EleccionInteriorExterior();
					window.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Error al iniciar sesion.");
				}
				
				
			}
		});
		btnInicioSesion.setBackground(new Color(255, 128, 64));
		btnInicioSesion.setBounds(159, 123, 123, 20);
		panelCent.add(btnInicioSesion);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
				
	}
}





