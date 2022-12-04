package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import BD.BD;
import Logica.Menu;
import Logica.Reserva;

public class VentanaTicket extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JList<Menu> aMenus;
	private DefaultListModel <Menu> modeloCarrito;
	private JScrollPane menusPane;
	
	private JTextArea taResumen;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy kk.mm.ss");
	private VentanaMenus vM;
	private BD bd = new BD();
	

	public VentanaTicket(VentanaMenus vM) {
		
		this.vM = vM;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 200);
		taResumen = new JTextArea();
		taResumen.setEditable(false);
		JScrollPane scrollAreaResumen = new JScrollPane(taResumen);
		getContentPane().add(scrollAreaResumen, BorderLayout.CENTER);
		taResumen.setText("");
		cargarCarritoEnTextArea();
		
		JPanel pPagar = new JPanel(new FlowLayout());
		
		JButton btnPagar = new JButton("Pagar");
		pPagar.add(btnPagar);
		
		JButton btnVolver = new JButton("Volver");
		pPagar.add(btnVolver);
		
		JButton btnCancelar = new JButton("Cancelar");
		pPagar.add(btnCancelar);
		
		
		btnPagar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaImprimir(vM);
				dispose();
				
			}
			
		});
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vM.vaciarCarrito();
				dispose();
				}
		});
		
		setLocationRelativeTo(null);
		getContentPane().add(pPagar, BorderLayout.SOUTH);
		setVisible(true);
}

	private void cargarCarritoEnTextArea() {

		Date d = new Date(System.currentTimeMillis());
		String texto = ""
				+ "Factura de la compra del dia: " + sdf.format(d) + "\n";
		double total = 0;
		List<Reserva> aReserva = bd.obtenerDatosReservas();
		ArrayList<Menu> aMenu = vM.obtenerCarrito();
		aReserva.get(aReserva.size()-1).setaMenu(aMenu);
		for(Menu m: aMenu) {
			texto = texto + "	" + m.toString().replace("\n", "") + "\n";
			total += m.obtenerPreciototal(m.getpL());
		}
		texto = texto + "	" + aReserva.get(aReserva.size()-1).toString().replace("\n", "") + "\n";
		texto = texto + "TOTAL: "+total+" €";
		taResumen.setText(texto);
	}
}
