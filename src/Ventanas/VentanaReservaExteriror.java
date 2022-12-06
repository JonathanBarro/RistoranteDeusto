package Ventanas;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BD.BD;
import Logica.Reserva;
import Logica.RistoranteMain;

import java.awt.BorderLayout;

import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;



public class VentanaReservaExteriror extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDateChooser calen; 
	private JTable tabla;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JButton btnGuardarDatos;
	private JPanel pNorte;
	private JLabel lblNombre;
	private Reserva res;
	private JFrame ventanaActual;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaReservaExteriror() {
		res = new Reserva();
		ventanaActual = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Izquirda = new JPanel();
		panel_Izquirda.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_Izquirda, BorderLayout.WEST);
		
		JPanel panel_Norte = new JPanel();
		panel_Norte.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_Norte, BorderLayout.NORTH);
		
		JLabel jLRistorante = new JLabel("Ristorante");
		jLRistorante.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		panel_Norte.add(jLRistorante);
		
		JPanel panel_Sur = new JPanel();
		panel_Sur.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_Sur, BorderLayout.SOUTH);
		
		
		
		JPanel panel_Dercha = new JPanel();
		panel_Dercha.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_Dercha, BorderLayout.EAST);
		
		JPanel panel_Cent = new JPanel();
		contentPane.add(panel_Cent, BorderLayout.CENTER);
		panel_Cent.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_ComboCent = new JPanel();
		panel_ComboCent.setBackground(new Color(231, 237, 236));
		panel_Cent.add(panel_ComboCent, BorderLayout.NORTH);
		
		JLabel jLNumeroPersonas = new JLabel("Pulse en el boton para ver la mesas libres:");
		panel_ComboCent.add(jLNumeroPersonas);
		
		JButton btnMesas = new JButton("Mesas");
		btnMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMesasInterior window = new VentanaMesasInterior(res, ventanaActual);
				window.setVisible(true);
				ventanaActual.setVisible(false);
				
			}
		});
		btnMesas.setBackground(new Color(255, 128, 64));
		panel_ComboCent.add(btnMesas);
		
		
		JPanel panel_JCalendar = new JPanel();
		panel_JCalendar.setBackground(new Color(128, 255, 128));
		panel_Cent.add(panel_JCalendar, BorderLayout.CENTER);
		
		Date fechaActual = new Date(System.currentTimeMillis());
		SimpleDateFormat sdfAnio = new SimpleDateFormat("yyyy");
		String anio = sdfAnio.format(fechaActual);
		String sultimaFecha = "31-12-"+anio;
		SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
		Date ultimaFecha;
		try {
			ultimaFecha = sdfFecha.parse(sultimaFecha);
		} catch (ParseException e1) {
			ultimaFecha = fechaActual;
		}
		panel_JCalendar.setLayout(null);

		calen = new JDateChooser();
		calen.setBounds(141, 35, 100, 25);
		calen.setMinSelectableDate(fechaActual);
		calen.setMaxSelectableDate(ultimaFecha);
		panel_JCalendar.add(calen);
		calen.setPreferredSize(new Dimension(100,25));
		calen.setDateFormatString("dd-MMMM");
		
		JLabel lblCalen = new JLabel("Seleccione el dia de reserva:");
		lblCalen.setBounds(117, 10, 215, 14);
		panel_JCalendar.add(lblCalen);
		
	
		
	
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.setFont(new Font("MV Boli", Font.PLAIN, 11));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					List<Reserva> reservas = new ArrayList <Reserva>();
					
					reservas = RistoranteMain.bd.obtenerDatosReservas();
				
					int i = reservas.get(reservas.size()-1).getIdReserva()+1;
					res.setIdReserva(i);
					 //String año = Integer.toString(calen.getCalendar().get(java.util.Calendar.YEAR));
					String mes = Integer.toString(calen.getCalendar().get(java.util.Calendar.MONTH) + 1);
					String dia = Integer.toString(calen.getCalendar().get(java.util.Calendar.DATE));
					res.setFecha(dia+"-"+mes);
					System.out.println( res.toString());
					 
					reservas.add(res);
					VentanaMenus window = new VentanaMenus(res);
					
					window.setVisible(true);
					ventanaActual.setVisible(false);
				
				
			}
		});
		panel_Sur.add(btnConfirm);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 128));
		panel_Cent.add(panel, BorderLayout.WEST);
	}
}

