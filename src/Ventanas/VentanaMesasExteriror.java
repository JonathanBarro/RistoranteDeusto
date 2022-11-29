package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Mesa;
import Logica.Reserva;

public class VentanaMesasExteriror extends JFrame {
	private JPanel contentPane;
	private JPanel pSur;	
	private JTable tabla;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JButton btnVolver;
	private JButton btnMesa;
	private JPanel pNorte;
	private JLabel lblNombre;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VentanaMesasExteriror() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Creamos la conexiÃ³n con la BBDD
		
		//Obtenemos el ArrayList de Persona
		ArrayList<Reserva> aMesas = new ArrayList<>();
		
		//Creamos el modelo de la tabla
		modelo = new DefaultTableModel();
		//Le asignamos al modelo la fila con los tÃ­tulos
		String [] titulos = {"NOMBRE DE MESA","NUMERO DE PERSONAS"};
		modelo.setColumnIdentifiers(titulos);
		//Rellenamos el modelo con los datos de la lista de personas
		for(Reserva p: aMesas) {
			//Con cada persona creamos una fila de datos
			String [] datos = {p.getaMesa()+"",p.getNumPersonas()+""};
			//AÃ±ado la fila al modelo
			modelo.addRow(datos);
		}
		String [] datos1 = {"Mesa1","3"};
		modelo.addRow(datos1);
		String [] datos2 = {"Mesa3","6"};
		modelo.addRow(datos2);
		String [] datos3 = {"Mesa4","4"};
		modelo.addRow(datos3);
		String [] datos4 = {"Mesa6","5"};
		modelo.addRow(datos4);
		
		//Creamos la JTable a partir del modelo
		tabla = new JTable(modelo);
		
		//Creamos el panel con el scroll y le aÃ±adimos la tabla
		scroll = new JScrollPane(tabla);
		
		//AÃ±adimos el scroll a la ventana
		contentPane.add(scroll, BorderLayout.CENTER);
		
		pSur = new JPanel();
		pSur.setBackground(new Color(255, 255, 128));
		contentPane.add(pSur, BorderLayout.SOUTH);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(0, 128, 255));
		btnVolver.setForeground(new Color(255, 128, 64));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaReservaExteriror window = new VentanaReservaExteriror();
				window.setVisible(true);
				dispose();
			}
		});
		pSur.add(btnVolver);
		
		
		btnMesa = new JButton("Seleccione Mesa");
		btnMesa.setBackground(new Color(0, 128, 255));
		btnMesa.setForeground(new Color(255, 128, 64));
		btnMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pSur.add(btnMesa);
		
		pNorte = new JPanel();
		pNorte.setBackground(new Color(255, 255, 128));
		pNorte.setForeground(new Color(255, 128, 64));
		contentPane.add(pNorte, BorderLayout.NORTH);
		
		lblNombre = new JLabel("Mesas permitidas");
		lblNombre.setForeground(new Color(255, 128, 64));
		lblNombre.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		pNorte.add(lblNombre);
	}
	
	

	

}
