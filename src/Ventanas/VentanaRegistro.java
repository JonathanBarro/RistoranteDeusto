package Ventanas;




import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BD.BD;
import Logica.RistoranteMain;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;



public class VentanaRegistro extends JFrame{



	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_Contrasenia;
	private JTextField textField_NumTlfn;
	private JPanel panelProgress;
	JProgressBar progreso;
	BD metodosbases = new BD();
	JButton btnRegis = new JButton("Regristrarse");/**
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
		
		setBounds(100, 100, 450, 400);
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
		
		JLabel lblNumTlfn = new JLabel("Numero de telefono");
		lblNumTlfn.setBounds(106, 131, 136, 14);
		panelCent.add(lblNumTlfn);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(231, 19, 96, 20);
		panelCent.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setBounds(231, 53, 96, 20);
		panelCent.add(textField_Apellido);
		textField_Apellido.setColumns(10);
		
		textField_Contrasenia = new JPasswordField();
		textField_Contrasenia.setBounds(231, 92, 96, 20);
		panelCent.add(textField_Contrasenia);
		textField_Contrasenia.setColumns(10);
		
		textField_NumTlfn = new JTextField();
		textField_NumTlfn.setBounds(231, 128, 96, 20);
		panelCent.add(textField_NumTlfn);
		textField_NumTlfn.setColumns(10);
		 
		
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String erNombre = "[A-Z][a-z]{0,19}";
				String erApellido = "[A-Z][a-z]{0,19}";
				String erContrasenia = "[A-Z][a-z][0-9]{0,19}";
				String erNumTlfn = 	"[0-9]{0,9}";
				if(Pattern.matches(erNombre, textField_Nombre.getText()) && Pattern.matches(erApellido, textField_Apellido.getText()) && Pattern.matches(erContrasenia, textField_Contrasenia.getText()) && Pattern.matches(erNumTlfn, textField_NumTlfn.getText()))  {
					JOptionPane.showMessageDialog(null, "Los datos cumplen los requisitos, ahora comprobaremos si el usuario existe en la base de datos", "OK", JOptionPane.OK_OPTION);
					RistoranteMain.bd.buscarClienteRegistrado(erNombre, erNumTlfn);
					RistoranteMain.bd.guardarClientes(textField_Nombre.getText(), textField_Apellido.getText(), textField_Contrasenia.getText(), Integer.parseInt(textField_NumTlfn.getText()));
					JOptionPane.showMessageDialog(null, "Se ha registrado correctamente.");
					VentanaInicio window = new VentanaInicio();
					window.setVisible(true);
		 
				}else {  
					JOptionPane.showMessageDialog(null, "Este cliente ya existe o no se estan respetando los 20 carácteres alfanuméricos de los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);

				}

				RistoranteMain.bd.guardarClientes(textField_Nombre.getText(), textField_Contrasenia.getText(), textField_Apellido.getText(), Integer.parseInt(textField_NumTlfn.getText()));
				progreso.setVisible(true);
				Thread hilo = new Thread(new Runnable() {
					public void run() {
						for (int i = 0; i <= 100; i++) {
							progreso.setValue(i);
							try {
								Thread.sleep(100);
							}
							catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						JOptionPane.showMessageDialog(null, "Se ha registrado correctamente");
						progreso.setVisible(false);
						dispose();
						VentanaInicio window = new VentanaInicio();
						window.setVisible(true);
					}
				
				});
				hilo.start();

			}
				
			}
		);
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
		progreso = new JProgressBar(0, 100);
		progreso.setBounds(131, 242, 146, 14);
		panelCent.add(progreso);
		progreso.setVisible(false);
		
		panelProgress = new JPanel();
		panelProgress.setOpaque(false);
		panelSur.add(panelProgress, BorderLayout.CENTER);

	}

}	