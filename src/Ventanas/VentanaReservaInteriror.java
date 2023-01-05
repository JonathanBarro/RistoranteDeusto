package Ventanas;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
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
	private JPanel panel_hora;
	JComboBox<String> hora_comboBox = new JComboBox<String>();
	private JPanel panel_Mesas ;
	boolean posiciones;
	JLabel modif = new JLabel("Reserva:");

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
		
		panel_hora = new JPanel();
		panel_hora.setBounds(0, 96, 72, 76);
		
		 
		panel_Mesas = new JPanel();
		panel_Mesas.setBounds(72, 96, 334, 76);
		panel_Cent.setLayout(null);
		panel_Sur.add(modif);
		
		//Calendario-------------------------------------------------------
		
		
		
		
		JPanel panel_Calendar = new JPanel();
		panel_Calendar.setBounds(0, 0, 406, 97);
		panel_Calendar.setBackground(new Color(231, 237, 236));
		panel_Cent.add(panel_Calendar);
		
	
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
		panel_Calendar.setLayout(null);
		
		JLabel lblCalen = new JLabel("Seleccione el dia de reserva:");
		lblCalen.setBounds(24, 15, 209, 14);
		panel_Calendar.add(lblCalen);
		calen = new JDateChooser();
		calen.setBounds(243, 15, 100, 25);
		panel_Calendar.add(calen);
		calen.setMinSelectableDate(fechaActual);
		calen.setMaxSelectableDate(ultimaFecha);
		calen.setPreferredSize(new Dimension(100,25));
		calen.setDateFormatString("dd-MMMM");
		JButton btnConfirmCalen = new JButton("Seleccionar dia");
		btnConfirmCalen.setBounds(179, 50, 147, 23);
		panel_Calendar.add(btnConfirmCalen);
		if(calen.getDate() == null) {
			panel_hora.setVisible(false);
			panel_Mesas.setVisible(false);
		}
		
	
		btnConfirmCalen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calen.getDate() != null) {
					int resp = JOptionPane.showConfirmDialog(null, "Tras seleccionar la fecha no se podra volver atras para cambiarla\n"+"¿Esta seguro?",//<- EL MENSAJE
				            "Alerta!"/*<- El título de la ventana*/, JOptionPane.YES_NO_OPTION);
					if(resp==0) {
					panel_hora.setVisible(true);
					panel_Mesas.setVisible(false);
					btnConfirmCalen.setVisible(false);
					String mes = Integer.toString(calen.getCalendar().get(java.util.Calendar.MONTH) + 1);
					String dia = Integer.toString(calen.getCalendar().get(java.util.Calendar.DATE));
					modif.setText("Reserva: Dia: "+ dia +"-" + mes+".");
					}else{
						calen.setEnabled(true);
						;
					}
				}else {
					JOptionPane aviso = new JOptionPane();
					aviso.showMessageDialog(null, "Debe seleccionar un dia");
				}
			}
		});
	
	
	
		

		
		
		
		
		//HORA-----------------------------------
		
	
		panel_hora.setBackground(new Color(255, 255, 128));
		panel_Cent.add(panel_hora);
		
		JLabel lblNewLabel = new JLabel("Hora:");
		panel_hora.add(lblNewLabel);
		

		
		
		
		panel_hora.add(hora_comboBox);
		
		
		 String hora;
		 ArrayList<String> horas = new ArrayList<>();
		 horas.add("");
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
		 hora_comboBox.setSelectedIndex(0);
		
		 
		 hora_comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hora_comboBox.getSelectedItem()!="") {
					int resp = JOptionPane.showConfirmDialog(null, "Tras seleccionar la hora no se podra volver atras para cambiarla\n"+"¿Esta seguro?",//<- EL MENSAJE
				            "Alerta!"/*<- El título de la ventana*/, JOptionPane.YES_NO_OPTION);
					if(resp == 0) {
						panel_Mesas.setVisible(true);
						hora_comboBox.setEnabled(false);
						String mes = Integer.toString(calen.getCalendar().get(java.util.Calendar.MONTH) + 1);
						String dia = Integer.toString(calen.getCalendar().get(java.util.Calendar.DATE));
						modif.setText("Reserva: Dia: "+ dia +"-" + mes+", hora:" + hora_comboBox.getSelectedItem() +".");
					}
					
				}
				
			}
		});
		
		 
		//Mesas----------------------------------------------------------------------
	
		
		panel_Mesas.setBackground(new Color(128, 255, 128));
		panel_Cent.add(panel_Mesas);
		
		panel_Mesas.setLayout(null);
		
		JLabel jLNumeroPersonas = new JLabel("Pulse en el boton para ver la mesas libres:");
		jLNumeroPersonas.setBounds(26, 11, 259, 14);
		panel_Mesas.add(jLNumeroPersonas);
		
		JButton btnMesas = new JButton("Mesas");
		btnMesas.setBounds(79, 36, 86, 23);
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
				if(calen==null || hora_comboBox.getSelectedItem() == "") {
					JOptionPane.showMessageDialog(btnConfirm, "Debe rellenar todos los campos");
					ventanaActual.setVisible(true);
				}
					
			
				
			
				
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
					modif.setText("Reserva: Dia: "+ dia +"-" + mes+", hora:" + hora_comboBox.getSelectedItem() +"Id de la mesa: " + res.getIdReserva());
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
