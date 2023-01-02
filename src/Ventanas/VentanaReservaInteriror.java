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
import javax.swing.JOptionPane;

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



public class VentanaReservaInteriror extends JFrame {

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
	private JPanel panel_hora = new JPanel();
	JComboBox<String> hora_comboBox = new JComboBox<String>();
	boolean posiciones;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaReservaInteriror() {
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
		
		
		
		
		//Calendario-------------------------------------------------------
		
		
		
		
		JPanel panel_Calendar = new JPanel();
		panel_Calendar.setBackground(new Color(231, 237, 236));
		panel_Cent.add(panel_Calendar, BorderLayout.NORTH);
		
		hora_comboBox.setEnabled(false);
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
		
		JLabel lblCalen = new JLabel("Seleccione el dia de reserva:");
		panel_Calendar.add(lblCalen);
		calen = new JDateChooser();
		panel_Calendar.add(calen);
		calen.setMinSelectableDate(fechaActual);
		calen.setMaxSelectableDate(ultimaFecha);
		calen.setPreferredSize(new Dimension(100,25));
		calen.setDateFormatString("dd-MMMM");
		
		

		
		
		
		//HORA-----------------------------------
		hora_comboBox.setEnabled(true);
		
		panel_hora.setBackground(new Color(255, 255, 128));
		panel_Cent.add(panel_hora, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Hora:");
		panel_hora.add(lblNewLabel);
		

		
		
		
		panel_hora.add(hora_comboBox);
		
		
		 String hora;
		 ArrayList<String> horas = new ArrayList<>();
		 horas.add("14:00");
		 horas.add("15:00");
		 horas.add("16:00");
		 horas.add("20:00");
		 horas.add("21:00");
		 horas.add("22:00");
		 
		 try {
			 for(int i = 0; i<horas.size(); i++){
                 hora = horas.get(i);
                 hora_comboBox.addItem(hora);
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 
		//Mesas----------------------------------------------------------------------
		 
		
		JPanel panel_Mesas = new JPanel();
		panel_Mesas.setBackground(new Color(128, 255, 128));
		panel_Cent.add(panel_Mesas, BorderLayout.CENTER);
		
		panel_Mesas.setLayout(null);
		
		JLabel jLNumeroPersonas = new JLabel("Pulse en el boton para ver la mesas libres:");
		jLNumeroPersonas.setBounds(48, 25, 259, 14);
		panel_Mesas.add(jLNumeroPersonas);
		
		JButton btnMesas = new JButton("Mesas");
		btnMesas.setBounds(105, 50, 86, 23);
		panel_Mesas.add(btnMesas);
		btnMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaMesasInterior window = new VentanaMesasInterior(res, ventanaActual);
				window.setVisible(true);
				ventanaActual.setVisible(false);
				btnMesas.setEnabled(false);
				jLNumeroPersonas.setVisible(false);
				
				
			}
		});
		btnMesas.setBackground(new Color(255, 128, 64));
		
		
		
		
		

		
		

		
		
	
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.setFont(new Font("MV Boli", Font.PLAIN, 11));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				int resp = JOptionPane.showConfirmDialog(null, "Tras confirmar la reserva no se podra volver atras para cambiarla\n"+"¿Esta seguro?",//<- EL MENSAJE
			            "Alerta!"/*<- El título de la ventana*/, JOptionPane.YES_NO_OPTION/*Las opciones (si o no)*/, JOptionPane.WARNING_MESSAGE/*El tipo de ventana, en este caso WARNING*/);
					
				if(resp==0) {
					List<Reserva> reservas = new ArrayList <Reserva>();
					
					reservas = RistoranteMain.bd.obtenerDatosReservas();
				
					int i = reservas.get(reservas.size()-1).getIdReserva()+1;
					res.setIdReserva(i);
					 //String año = Integer.toString(calen.getCalendar().get(java.util.Calendar.YEAR));
					String mes = Integer.toString(calen.getCalendar().get(java.util.Calendar.MONTH) + 1);
					String dia = Integer.toString(calen.getCalendar().get(java.util.Calendar.DATE));
					res.setFecha(dia+"-"+mes);
					String horass = (String) hora_comboBox.getSelectedItem();
					res.setHora(horass);
					System.out.println( res.toString());
					 
					reservas.add(res);
					VentanaMenus window = new VentanaMenus(res);
					
					window.setVisible(true);
					ventanaActual.setVisible(false);
				}else {
					ventanaActual.setVisible(true);
				}
				
				
			}
		});
		panel_Sur.add(btnConfirm);
		
		

		//hora_comboBox.addI
	}
}
