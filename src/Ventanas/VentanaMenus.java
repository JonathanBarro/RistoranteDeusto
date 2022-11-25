package Ventanas;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;

import Logica.Bebida;
import Logica.Comida;
import Logica.Menu;
import Logica.Menu_Degustacion;
import Logica.Menu_EntreSemana;
import Logica.Menu_FinDeSemana;
import Logica.Menu_Infantil;
import Logica.Producto;


import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JList;

public class VentanaMenus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setSize(800, 400);

		aMenus = new JList<>();
		modeloCarrito = new DefaultListModel<>();
		
		JComboBox <Menu> cbMenu = new JComboBox<>();
		cbMenu.setPreferredSize(new Dimension(120, 20));
		
		
		ArrayList<Producto> aComida = new ArrayList<>();
		ArrayList<Producto> aBebdia = new ArrayList<>();
		Comida p1 = new Comida("Plato1", 10.1,01,1);
		Comida p2 = new Comida("Plato2", 10.1,02,1);
		Comida p3 = new Comida("Plato3", 10.1,03,1);
		Bebida b1 = new Bebida("Bebida1", 10.1,3,1,true);
		Bebida b2 = new Bebida("Bebida2", 10.1,3,1,true);
		
		aComida.add(p1);
		aComida.add(p2);
		aComida.add(p3);
		
		aBebdia.add(b1);
		
		HashMap<String, List<Producto>> hmProds = new HashMap<>();
		
		hmProds.putIfAbsent("Bebida", aBebdia);
		hmProds.putIfAbsent("Comida", aComida);
		
		double precioTot=0;
		
		
		Menu_Degustacion m1 = new Menu_Degustacion("Menu_Degustacion", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot);
		Menu_EntreSemana m2 = new Menu_EntreSemana("Menu_EntreSemana", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(), precioTot,false);
		Menu_Infantil m3 = new Menu_Infantil("Menu_Infantil", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot);
		Menu_FinDeSemana m4 = new Menu_FinDeSemana("Menu_FinDeSemana", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(), precioTot,8);
		
		m1.setPrecioTotal(m1.obtenerPreciototal(hmProds));
		m2.setPrecioTotal(m2.obtenerPreciototal(hmProds));
		m3.setPrecioTotal(m3.obtenerPreciototal(hmProds));
		m4.setPrecioTotal(m4.obtenerPreciototal(hmProds));
		
		cbMenu.addItem(m1);
		cbMenu.addItem(m2);
		cbMenu.addItem(m3);
		cbMenu.addItem(m4);
		
		JPanel pcbx = new JPanel(new FlowLayout());
		JPanel pMedio2 = new JPanel(new FlowLayout());
		JPanel pNorth = new JPanel(new GridLayout(2, 1));
		
		
		JPanel pBtnsAnadir = new JPanel(new FlowLayout());
		JPanel pMedio = new JPanel(new FlowLayout());
		JPanel pBtnJL = new JPanel(new GridLayout(3,1));
		
		JPanel pTicket = new JPanel(new GridLayout(1,2));
		
		
		menusPane = new JScrollPane(aMenus);
		menusPane.setBorder(BorderFactory.createTitledBorder("Menus"));
		JButton btnAnadir = new JButton("+1");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnVaciar = new JButton("Vaciar");
		JButton btnTicket = new JButton("Ticket"); 
		JButton btnBebida = new JButton("Bebida"); 
		JLabel lblCB = new JLabel("Seleccione el menú :");
		JButton btnVerMenus = new JButton("Ver Menus");
		
		pcbx.add(lblCB);
		pcbx.add(cbMenu);
		pMedio.add(btnVerMenus);
		
		pNorth.add(pMedio2);
		pNorth.add(pcbx);
		
		pBtnsAnadir.add(btnAnadir);
		pBtnsAnadir.add(btnEliminar);
		pBtnsAnadir.add(btnVaciar);

		
		pBtnJL.add(pMedio);
		pBtnJL.add(pBtnsAnadir);
		pBtnJL.add(menusPane);
		
		pTicket.add(btnTicket);
		pTicket.add(btnBebida);
		
		btnBebida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaBebidas v = new VentanaBebidas();
				v.setVisible(true);
			}
		});
		
		btnVerMenus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaVerMenus();
			}
		});
		
		cbMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object ob = cbMenu.getSelectedItem();
				Menu menu = (Menu) ob;
				modeloCarrito.addElement(menu);
				aMenus.setModel(modeloCarrito);
			}
		});

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
