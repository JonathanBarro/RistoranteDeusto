package Ventanas;
import Logica.Comida;


import Logica.Producto;

import java.awt.Font;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;

import BD.BD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;


public class VentanaStock extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Producto> listaProductos;
	private JTable tablaComida;
	private JScrollPane scroll;
	private DefaultTableModel modelo;
	private ArrayList<Comida> comidas;
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
				VentanaInicio window= new VentanaInicio();
				window.setVisible(true);
				dispose();
				
				
			}
		});
		
		
		
	
	
	listaProductos=bd.obtenerDatosComidas();
	
		
		

		modelo = new DefaultTableModel();
		
		String [] titulos = {"NOMBRE","ID","PRECIO","STOCK"};
		modelo.setColumnIdentifiers(titulos);
		for (Producto p : listaProductos) {
			String [] datos = {p.getNombre()+"",p.getId()+"", p.getPrecio()+ "", p.getStock()+""};
			modelo.addRow(datos);
		}
		
		
		tablaComida = new JTable(modelo);
		scroll = new JScrollPane(tablaComida);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		btnAniadirComida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombre=JOptionPane.showInputDialog("Introduce un nombre:");
				String Id= JOptionPane.showInputDialog("Introduce un ID:");
				String precio= JOptionPane.showInputDialog("Introduce un precio");
				String Stock=JOptionPane.showInputDialog("Introduce un Stock");
				Comida nuevacomida = new Comida(nombre,Integer.parseInt(Id),Integer.parseInt(precio),Integer.parseInt(Stock), "");
				String [] comidastring= { nombre+"", Id+"", precio+"",Stock+""};
				modelo.addRow(comidastring);
				
				bd.insertarNuevaComida(nuevacomida);
			}
		});
		

		
	
		tablaComida.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		//Empieza el cambio
		int stock = Integer.parseInt((String) modelo.getValueAt(row, 3));
		
		if (stock<=2) {
			c.setBackground(Color.RED);
		} else {
			c.setBackground(Color.GREEN);
		}
		//Si la celda estÃ¡ seleccionada se asocia un color de fondo y letra

	
		return c;
	}
	});
		//Cargamos unos un array en el modelo
		comidas= new ArrayList();
			for(int i=0;i<modelo.getRowCount();i++) {
				String nom = (String)modelo.getValueAt(i, 0);
				int id =Integer.parseInt((String)modelo.getValueAt(i, 1));
				Float precio = Float.parseFloat((String)modelo.getValueAt(i, 2));
				int stock = Integer.parseInt((String)modelo.getValueAt(i, 3));
				Comida c = new Comida(nom, precio, id, stock);
				comidas.add(c);
			}
		

	modelo.addTableModelListener(new TableModelListener() {
		
		@Override
		public void tableChanged(TableModelEvent e) {
			
			int fila = e.getFirstRow();
			String nom = (String) modelo.getValueAt(fila, 0);
			float precio =Float.parseFloat((String) modelo.getValueAt(fila, 2));
			int stock =Integer.parseInt((String) modelo.getValueAt(fila, 3)) ;
			comidas.get(fila).setNombre(nom);;
			comidas.get(fila).setPrecio(precio);;
			comidas.get(fila).setStock(stock);;
			bd.modificarDatoComidas(comidas.get(fila));
				
		}
	});
		
	
	
		
		tablaComida.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				btnCambiarPrecio.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String Nuevoprecio= JOptionPane.showInputDialog("Introduce un nuevo precio:");
						modelo.setValueAt(Nuevoprecio, tablaComida.getSelectedRow(), 2);
						
						bd.cambiarPrecioComida(Integer.parseInt((String)modelo.getValueAt(tablaComida.getSelectedRow(),1)), Integer.parseInt(Nuevoprecio));
						System.out.println("cambio de precio");
					}
				});
				
				btnBorrar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						modelo.removeRow(tablaComida.getSelectedRow());
						//comidas.remove(ABORT);
						bd.borrarComida((int) modelo.getValueAt(tablaComida.getSelectedRow(), 0));
						
						
					}
				});
				
			}
		
		});
		
	}
}



