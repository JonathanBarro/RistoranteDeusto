package Ventanas;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Menu;
import Logica.Producto;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

public class VentanaMenus extends JFrame {

	private JList<Menu> aMenus;
	private DefaultListModel <Menu> modeloCarrito;
	private JScrollPane menusPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenus frame = new VentanaMenus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaMenus() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);

		aMenus = new JList<>();
		modeloCarrito = new DefaultListModel<>();
		
		JComboBox <Menu> cbMenu = new JComboBox<>();
		cbMenu.setSelectedItem(null);
		cbMenu.setPreferredSize(new Dimension(200, 20));
		
		
		ArrayList<Producto> aProductos = new ArrayList<>();
		Producto p1 = new Producto("Pato1", 10.1,01);
		Producto p2 = new Producto("Pato2", 10.1,02);
		Producto p3 = new Producto("Pato3", 10.1,03);
		
		aProductos.add(p1);
		aProductos.add(p2);
		aProductos.add(p3);
		
		Menu m1 = new Menu("Burger", aProductos, aProductos.size());
		Menu m2 = new Menu("Pizza", null, 5);
		Menu m3 = new Menu();
		cbMenu.addItem(m1);
		cbMenu.addItem(m2);
		
		JLabel lblCB = new JLabel("Seleccione el menú :");
		
		JPanel pcbx = new JPanel(new FlowLayout());
		JPanel pMedio2 = new JPanel();
		JPanel pNorth = new JPanel(new GridLayout(2, 1));
		
		JPanel pBtnsAE = new JPanel(new FlowLayout());
		JPanel pMedio = new JPanel(new FlowLayout());
		JPanel pBtnJL = new JPanel(new GridLayout(3,1));
		
		JPanel pTicket = new JPanel();
		
		menusPane = new JScrollPane(aMenus);
		menusPane.setBorder(BorderFactory.createTitledBorder("Menus"));
		JButton btnAnadir = new JButton("Añadir");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnVaciar = new JButton("Vaciar");
		JButton btnTicket = new JButton("Ticket"); 
		
		pcbx.add(lblCB);
		pcbx.add(cbMenu);
		
		pNorth.add(pMedio2);
		pNorth.add(pcbx);
		
		pBtnsAE.add(btnAnadir);
		pBtnsAE.add(btnEliminar);
		pBtnsAE.add(btnVaciar);
		
		pBtnJL.add(pMedio);
		pBtnJL.add(pBtnsAE);
		pBtnJL.add(menusPane);
		
		pTicket.add(btnTicket);
		
		
		btnAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob = cbMenu.getSelectedItem();
				Menu menu = (Menu) ob;
				modeloCarrito.addElement(menu);
				aMenus.setModel(modeloCarrito);
			}
			
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modeloCarrito.removeElement(aMenus.getSelectedValue());
			}
		});
		
		btnVaciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modeloCarrito.clear();
			}
		});
		
		getContentPane().add(pNorth, BorderLayout.NORTH);
		getContentPane().add(pBtnJL, BorderLayout.CENTER);
		getContentPane().add(pTicket, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
	}

}
