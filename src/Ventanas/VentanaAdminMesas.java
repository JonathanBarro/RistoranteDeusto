package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Logica.Mesa;
import Logica.Reserva;
import Logica.RistoranteMain;

public class VentanaAdminMesas extends JFrame{
	private static boolean multiselect = false;
	private static ArrayList<Mesa> reserva;
	public static HashMap<String, Reserva> mapaReservas = new HashMap<>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VentanaAdminMesas() {
		List<Mesa> mesas = RistoranteMain.bd.obtenerDatosMesas();
		JPanel panelMesas = new JPanel(new GridLayout(0, 1));
		JScrollPane scroll = new JScrollPane(panelMesas);
		JPanel actual = new JPanel(new FlowLayout());
		for(Mesa v : mesas) {
			if(actual.getComponentCount() >= 5) {
				panelMesas.add(actual);
				actual = new JPanel(new FlowLayout());
			}
			JButton boton = new JButton("Mesa " + v.getIdMesa());
			boton.addActionListener(new TableActionListener(v, boton));
			actual.add(boton);
		}
		panelMesas.add(actual);
		for(int i = 11 - panelMesas.getComponentCount(); i >= 0; i--)
			panelMesas.add(new JLabel(" "));
		
		JPanel panelBotones = new JPanel(new FlowLayout());
		JButton btnMultiSeleccion = new JButton("Multi-Seleccion");
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin vA = new VentanaAdmin();
				vA.setVisible(true);
				dispose();
				
			}
		});
		panelBotones.add(btnMultiSeleccion);
		panelBotones.add(btnVolver);
		
		btnMultiSeleccion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!multiselect) {
					reserva = new ArrayList<>();
					multiselect = true;
				}else {
					SimpleDateFormat fecha = new SimpleDateFormat("yyyy-mm-dd");
					SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
					Reserva res = new Reserva(
						fecha.format(
								Date.valueOf(
										LocalDate.now()
								)
							), 
							0, 
							-1, 
							hora.format(Date.valueOf(LocalDate.now())));
					String personas = JOptionPane.showInputDialog("Numero de personas");
					if(personas == null)return;
					res.setNumPersonas(Integer.parseInt(personas));
					res.setaMesa(reserva);
					VentanaMenusAdmin vm = new VentanaMenusAdmin(res);
					multiselect = false;
				}
				
			}
			
		});
		
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		setSize(460, 500);
		getContentPane().add(scroll, BorderLayout.CENTER);
	}
	private class TableActionListener implements ActionListener {
		
		private Reserva res;
		private Mesa mesa;
		private JButton btn;
		public TableActionListener(Mesa mesa, JButton btn) {
			if(mapaReservas.containsKey(mesa.getIdMesa())){
				btn.setBackground(Color.RED);
			}
			this.btn = btn;
			this.mesa = mesa;
			SimpleDateFormat fecha = new SimpleDateFormat("yyyy-mm-dd");
			SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
			this.res = new Reserva(
					fecha.format(
						Date.valueOf(
								LocalDate.now()
						)
					), 
					mesa.getNumPersonas(), 
					-1, 
					hora.format(Date.valueOf(LocalDate.now())));
			this.res.setaMesa(new ArrayList<>(Arrays.asList(mesa)));
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(mapaReservas.containsKey(mesa.getIdMesa())) {
				if(multiselect) {
					reserva.remove(mesa);
					btn.setBackground(null);
				}else {
					VentanaImprimirPedido ventana = new VentanaImprimirPedido(mapaReservas.get(mesa.getIdMesa()));
				}
			}else {
				if(multiselect) {
					reserva.add(mesa);
					btn.setBackground(Color.GREEN);
				}else {
					String personas = JOptionPane.showInputDialog("Numero de personas");
					if(personas == null)return;
					res.setNumPersonas(Integer.parseInt(personas));
					VentanaMenusAdmin vm = new VentanaMenusAdmin(res);
					dispose();
				}
			}
		}
		
	}
}
