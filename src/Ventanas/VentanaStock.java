package Ventanas;
import Logica.Bebida;
import Logica.Comida;


import Logica.Producto;
import Logica.Producto.TipoProducto;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import BD.BD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;


public class VentanaStock extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaComida;
	private JTable tablaBebida;
	private JScrollPane scrollComida;
	private JScrollPane scrollBebida;
	private DefaultTableModel modeloComida;
	private DefaultTableModel modeloBebida;
	private List<Comida> comidas;
	private List<Bebida> bebidas;
	BD bd = new BD();
	
	/**
	 * Create the application.
	 */

	public VentanaStock() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		panelNorte.add(lblStock);
		
	
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		JLabel txtAreaStock= new JLabel();
		txtAreaStock.setFont(new Font("Times New Roman" , Font.BOLD, 28));
		txtAreaStock.setBounds(10, 10, 200, 30);
		JButton btnCambiarPrecio = new JButton("Cambiar Precio");
		
		JButton btnAniadirComida = new JButton("Aniadir");
		panelSur.add(btnAniadirComida);
		
		JButton btnBorrar = new JButton("Borrar");
		panelSur.add(btnBorrar);
		panelSur.add(btnCambiarPrecio);
		
		JButton btnVolver= new JButton("Volver");
		panelSur.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAdmin window= new VentanaAdmin();
				window.setVisible(true);
				dispose();
				
				
			}
		});
		
		comidas=bd.obtenerDatosComidas();
		modeloComida = new DefaultTableModel();
			
		String [] titulos = {"NOMBRE","ID","PRECIO","STOCK"};
		modeloComida.setColumnIdentifiers(titulos);
		for (Comida p : comidas) {
			String [] datos = {p.getNombre()+"",p.getId()+"", p.getPrecio()+ "", p.getStock()+""};
			modeloComida.addRow(datos);
		}
		
		JPanel panelTablas = new JPanel(new GridLayout(2,1));
		contentPane.add(panelTablas, BorderLayout.CENTER);
		
		tablaComida = new JTable(modeloComida);
		scrollComida = new JScrollPane(tablaComida);
		panelTablas.add(scrollComida);
		
		bebidas = bd.obtenerDatosBebidas();
		modeloBebida = new DefaultTableModel();
		
		modeloBebida.setColumnIdentifiers(titulos);
		for (Bebida p : bebidas) {
			String [] datos = {p.getNombre()+"",p.getId()+"", p.getPrecio()+ "", p.getStock()+""};
			modeloBebida.addRow(datos);
		}
		
		tablaBebida = new JTable(modeloBebida);
		scrollBebida = new JScrollPane(tablaBebida);
		panelTablas.add(scrollBebida);
		
		btnAniadirComida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombre=JOptionPane.showInputDialog("Introduce un nombre:");
				String Id= JOptionPane.showInputDialog("Introduce un ID:");
				String precio= JOptionPane.showInputDialog("Introduce un precio");
				String Stock=JOptionPane.showInputDialog("Introduce un Stock");
				int tipo = JOptionPane.showOptionDialog(null, "Seleccione tipo de producto:", "", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Producto.TipoProducto.values(), TipoProducto.Comida);
				switch(tipo) {
					case 0:
						Comida nuevacomida = new Comida(nombre,Integer.parseInt(Id),Integer.parseInt(precio),Integer.parseInt(Stock), "");
						String [] comidastring= { nombre+"", Id+"", precio+"",Stock+""};
						modeloComida.addRow(comidastring);
						comidas.add(nuevacomida);
						bd.insertarNuevaComida(nuevacomida);
						break;
					case 1:
						int fria = JOptionPane.showOptionDialog(null, "¿Es fria?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Si", "No"}, "No");
						Bebida nuevabebida = new Bebida(nombre,Integer.parseInt(Id),Integer.parseInt(precio),Integer.parseInt(Stock), fria == 0);
						String [] bebidastring= { nombre+"", Id+"", precio+"",Stock+""};
						modeloBebida.addRow(bebidastring);
						bebidas.add(nuevabebida);
						bd.insertarNuevaBebida(nuevabebida);
				}
				
			}
		});
		
		tablaComida.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
		
			private static final long serialVersionUID = 3352994971614263504L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
						int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				//Empieza el cambio
				int stock = Integer.parseInt((String) modeloComida.getValueAt(row, 3));
				
				if (stock<=2) {
					c.setBackground(Color.RED);
				} else {
					c.setBackground(Color.GREEN);
				}
				
				return c;
			}
		});
		tablaBebida.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			private static final long serialVersionUID = 3352994971614263504L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
						int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				//Empieza el cambio
				int stock = Integer.parseInt((String) modeloBebida.getValueAt(row, 3));
				
				if (stock<=2) {
					c.setBackground(Color.RED);
				} else {
					c.setBackground(Color.GREEN);
				}
				
				return c;
			}
		});
	
		modeloComida.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				
				int fila = e.getFirstRow();
				if(fila >= comidas.size())return;
				String nom = (String) modeloComida.getValueAt(fila, 0);
				float precio =Float.parseFloat((String) modeloComida.getValueAt(fila, 2));
				int stock =Integer.parseInt((String) modeloComida.getValueAt(fila, 3)) ;
				comidas.get(fila).setNombre(nom);
				comidas.get(fila).setPrecio(precio);
				comidas.get(fila).setStock(stock);
				bd.modificarDatoComidas(comidas.get(fila));
					
			}
		});
		modeloBebida.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				
				int fila = e.getFirstRow();
				if(fila >= bebidas.size() || modeloBebida.getRowCount() == 0)return;
				String nom = (String) modeloBebida.getValueAt(fila, 0);
				float precio =Float.parseFloat((String) modeloBebida.getValueAt(fila, 2));
				int stock =Integer.parseInt((String) modeloBebida.getValueAt(fila, 3)) ;
				bebidas.get(fila).setNombre(nom);
				bebidas.get(fila).setPrecio(precio);
				bebidas.get(fila).setStock(stock);
				bd.modificarDatoBebidas(bebidas.get(fila));
					
			}
		});	
		StringBuilder selectedTable = new StringBuilder();
		tablaComida.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				selectedTable.setLength(0);
				selectedTable.append("Comida");
			}
			
		});
		tablaBebida.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				selectedTable.setLength(0);
				selectedTable.append("Bebida");
			}
			
		});
		
		
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(selectedTable.toString().equals("Comida")) {
					bd.borrarComida(Integer.parseInt((String)modeloComida.getValueAt(tablaComida.getSelectedRow(), 1)));
					comidas.remove(tablaComida.getSelectedRow());
					modeloComida.removeRow(tablaComida.getSelectedRow());
				}else {
					bd.borrarBebida(Integer.parseInt((String)modeloBebida.getValueAt(tablaBebida.getSelectedRow(), 1)));
					bebidas.remove(tablaBebida.getSelectedRow());
					modeloBebida.removeRow(tablaBebida.getSelectedRow());
				}
				
				
			}
		});
		
	}
}



