package Ventanas;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import BD.BD;
import Logica.Reserva;



public class VentanaReservaExteriror extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDateChooser calen;
	private BD bd;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaReservaExteriror() {
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
		
		JLabel jLNumeroPer = new JLabel("Seleccione mesas:");
		panel_ComboCent.add(jLNumeroPer);
		
		JButton btnMesas = new JButton("Mesas");
		btnMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMesasExteriror window = new VentanaMesasExteriror();
				window.setVisible(true);
				dispose();
			}
		});
		btnMesas.setBackground(new Color(255, 128, 64));
		panel_ComboCent.add(btnMesas);
		
		
		
		JPanel panel_JCalendar = new JPanel();
		panel_JCalendar.setBackground(new Color(255, 255, 128));
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

		calen = new JDateChooser();
		calen.setMinSelectableDate(fechaActual);
		calen.setMaxSelectableDate(ultimaFecha);
		panel_JCalendar.add(calen);
		calen.setPreferredSize(new Dimension(100,25));
		calen.setDateFormatString("dd-MMMM");
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.setFont(new Font("MV Boli", Font.PLAIN, 11));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int id=0;
					String fecha="11";
					int numPer=0;
					Reserva  res = new Reserva(fecha,numPer,id);
					Reserva  res1 = new Reserva();
					List<Reserva> reservas = new ArrayList <Reserva>();
					reservas.add(res);
					System.out.println("Hola");
					for(int i = 0;i<reservas.size();i++) {
					res1.setIdReserva(i+1);
				
					 String año = Integer.toString(calen.getCalendar().get(java.util.Calendar.YEAR));
//					 String mes = Integer.toString(calen.getCalendar().get(java.util.Calendar.MONTH) + 1);
//					 String dia = Integer.toString(calen.getCalendar().get(java.util.Calendar.DATE));
//					 res1.setFecha(dia+"-"+mes);
					 System.out.println( res1.toString());
					 
					}
					reservas.add(res1);
				 
				bd.insertarDatosReserva(reservas);
				dispose();
				
				
			}
		});
		panel_Sur.add(btnConfirm);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel_Cent.add(panel, BorderLayout.WEST);
	}

}

