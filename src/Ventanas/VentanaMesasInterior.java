package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.BD;
import Logica.Mesa;
import Logica.Reserva;
import Logica.RistoranteMain;

public class VentanaMesasInterior extends JFrame {
	private JPanel contentPane;
	private JPanel pSur;	
	private JTable tabla;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JButton btnVolver;
	private JButton btnMesa;
	private JPanel pNorte;
	private JLabel lblNombre;
	private Reserva res;
	private JFrame ventanaAnterior;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VentanaMesasInterior(Reserva res, JFrame va) {
		this.res = res;
		this.ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Creamos la conexiÃ³n con la BBDD
		
		//Obtenemos el ArrayList de Persona
		List<Mesa> aMesas = new ArrayList();
		aMesas = RistoranteMain.bd.obtenerDatosMesas();
		//Creamos el modelo de la tabla
		modelo = new DefaultTableModel();
		//Le asignamos al modelo la fila con los tÃ­tulos
		String [] titulos = {"NOMBRE DE MESA","LUGAR","OCUPADA","NUMERO DE PERSONAS"};
		modelo.setColumnIdentifiers(titulos);
		//Rellenamos el modelo con los datos de la lista de personas
		for(Mesa p: aMesas) {
			//Con cada persona creamos una fila de datos
			String [] datos = {p.getIdMesa()+"",p.getLugar()+"", p.isOcupada()+"", p.getNumPersonas()+""};
			//AÃ±ado la fila al modelo
			modelo.addRow(datos);
		}
		
		
		

		
		//Creamos la JTable a partir del modelo
		tabla = new JTable(modelo);
		
		//Creamos el panel con el scroll y le aÃ±adimos la tabla
		scroll = new JScrollPane(tabla);
		
		//AÃ±adimos el scroll a la ventana
		contentPane.add(scroll, BorderLayout.CENTER);
		
		pSur = new JPanel();
		pSur.setBackground(new Color(255, 128, 64));
		contentPane.add(pSur, BorderLayout.SOUTH);
		
		btnVolver = new JButton("<-");
		btnVolver.setBackground(new Color(255, 255, 255));
		btnVolver.setForeground(new Color(0, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				dispose();
			}
		});
		pSur.add(btnVolver);
		
		
		btnMesa = new JButton("Seleccione Mesa");
		btnMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Mesa> aMesa = new ArrayList<>();
				Mesa mes = new Mesa((String)modelo.getValueAt(tabla.getSelectedRow(), 0) , Integer.valueOf((String) modelo.getValueAt(tabla.getSelectedRow(), 1)) , Boolean.valueOf((String) modelo.getValueAt(tabla.getSelectedRow(), 2)), Integer.valueOf((String) modelo.getValueAt(tabla.getSelectedRow(), 3)));
				aMesa.add(mes);
				res.setaMesa(aMesa);
				res.setNumPersonas(mes.getNumPersonas());
				modelo.removeRow(tabla.getSelectedRow());
				RistoranteMain.bd.borrarMesa(mes.getIdMesa());
				JOptionPane.showMessageDialog(null,"Mesa seleccionada correctamente");
				
			}

			private void removeRow(int selectedRow) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMesa.setBackground(new Color(255, 255, 128));
		btnMesa.setForeground(new Color(255, 128, 64));
		
	
		

		pSur.add(btnMesa);
		
		pNorte = new JPanel();
		pNorte.setBackground(new Color(255, 128, 64));
		pNorte.setForeground(new Color(255, 128, 64));
		contentPane.add(pNorte, BorderLayout.NORTH);
		
		lblNombre = new JLabel("Mesas permitidas");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("Freestyle Script", Font.BOLD, 26));
		pNorte.add(lblNombre);
	}
	
}
