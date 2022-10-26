package Ventanas;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Logica.Cliente;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;

public class VentanaReservaInteriror extends JFrame {

	private JPanel contentPane;
	private JDateChooser calen; 



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReservaInteriror frame = new VentanaReservaInteriror();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaReservaInteriror() {
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
		
		JLabel jLNumeroPersonas = new JLabel("Seleccion el numero de personas:");
		panel_ComboCent.add(jLNumeroPersonas);
		
		JComboBox<Integer> comboBox_NPersonas = new JComboBox();
		panel_ComboCent.add(comboBox_NPersonas);
		
		for(int i=0;i<=12;i++) {
			comboBox_NPersonas.addItem(i);
		}
		
		
		
		
		JPanel panel_JCalendar = new JPanel();
		panel_JCalendar.setBackground(new Color(255, 0, 128));
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
			}
		});
		panel_Sur.add(btnConfirm);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel_Cent.add(panel, BorderLayout.WEST);
	}

}
