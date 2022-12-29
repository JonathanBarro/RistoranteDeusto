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
import Logica.Reserva;
import Logica.RistoranteMain;

import javax.swing.JScrollPane;

import BD.BD;

import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private Reserva res;
	private static final long serialVersionUID = 1L;
	private JList<Menu> aMenus;
	private DefaultListModel <Menu> modeloCarrito;
	private JScrollPane menusPane;

	public VentanaMenus(Reserva res) {
		this.res = res;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 400);
		aMenus = new JList<>();
		modeloCarrito = new DefaultListModel<>();
		
		JComboBox <Menu> cbMenu = new JComboBox<>();
		JComboBox <Producto> cbBebida = new JComboBox<>();
		cbMenu.setPreferredSize(new Dimension(140, 20));
		cbBebida.setPreferredSize(new Dimension(140, 20));
		
		ArrayList<Producto> aComida = new ArrayList<>();
		ArrayList<Producto> aBebdia = new ArrayList<>();
		List<Producto> aComida1 = RistoranteMain.bd.obtenerDatosComidas();
		List<Producto> aBebdia1 =  RistoranteMain.bd.obtenerDatosBebidas();
		Comida p1 = new Comida("Plato1", 10.1,01,1,"1A");
		Comida p2 = new Comida("Plato2", 10.1,02,1,"1A");
		Comida p3 = new Comida("Plato3", 10.1,03,1,"1A");
		Bebida b1 = new Bebida("Bebida1", 10.1,3,1,true);
		Bebida b2 = new Bebida("Bebida2", 12,3,1,false);
		
		aComida.add(p1);
		aComida.add(p2);
		aComida.add(p3);
		
		aBebdia.add(b1);
		aBebdia.add(b2);
		
		HashMap<String, List<Producto>> hmProdsBd = RistoranteMain.bd.obtenerProductos();
		HashMap<String, List<Producto>> hmProds = new HashMap<>();
		
		List<Menu> lMenus = RistoranteMain.bd.obtenerMenus();
		for (Menu menu : lMenus) {
			menu.setpL(hmProdsBd);
		}
		
		
		hmProds.putIfAbsent("Bebida", aBebdia1);
		hmProds.putIfAbsent("Comida", aComida1);
		
		double precioTot=0;
		
		Menu_Degustacion m1 = new Menu_Degustacion("Menu_Degustacion", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot);
		Menu_EntreSemana m2 = new Menu_EntreSemana("Menu_EntreSemana", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(), precioTot,false);
		Menu_Infantil m3 = new Menu_Infantil("Menu_Infantil", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot);
		Menu_FinDeSemana m4 = new Menu_FinDeSemana("Menu_FinDeSemana", hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(), precioTot,8);
		
		m1.setPrecioTotal(m1.obtenerPreciototal(hmProds));
		m2.setPrecioTotal(m2.obtenerPreciototal(hmProds));
		m3.setPrecioTotal(m3.obtenerPreciototal(hmProds));
		m4.setPrecioTotal(m4.obtenerPreciototal(hmProds));
		
		for (String prod : hmProds.keySet()) {
			for (Producto producto : hmProds.get(prod)) {
				if(prod.equals("Bebida")) 
					cbBebida.addItem(producto);
			}
		}
//		for (Menu menu : lMenus) {
//			cbMenu.addItem(menu);
//		}
		
		cbMenu.addItem(m1);
		cbMenu.addItem(m2);
		cbMenu.addItem(m3);
		cbMenu.addItem(m4);
//		cbBebida.addItem(b1);
//		cbBebida.addItem(b2);
		
		JPanel pcbx = new JPanel(new FlowLayout());
		JPanel pMedio2 = new JPanel(new FlowLayout());
		JPanel pNorth = new JPanel(new GridLayout(2, 1));
		
		JPanel pBtnsAnadir = new JPanel(new FlowLayout());
		JPanel pMedio = new JPanel(new FlowLayout());
		JPanel pBtnJL = new JPanel(new GridLayout(3,1));
		
		JPanel pTicket = new JPanel(new FlowLayout());
		
		menusPane = new JScrollPane(aMenus);
		menusPane.setBorder(BorderFactory.createTitledBorder("Menus"));
		JButton btnAnadir = new JButton("+1");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnVaciar = new JButton("Vaciar");
		JButton btnTicket = new JButton("Ticket"); 
		JLabel lblCB = new JLabel("Seleccione el menú :");
		JLabel lblCBB = new JLabel("Seleccione bebida :");
		JButton btnVerMenus = new JButton("Ver Menus");
		
		pcbx.add(lblCB);
		pcbx.add(cbMenu);
		pcbx.add(lblCBB);
		pcbx.add(cbBebida);
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
				menu = (Menu) ob;
//				HashMap<String, List<Producto>> hmPords = RistoranteMain.bd.obtenerProductos();
//				menu.setpL(hmPords);
//				menu.setPrecioTotal(menu.obtenerPreciototal(menu.getpL()));
				Menu mn = new Menu();
				List<Producto> aComida1 = RistoranteMain.bd.obtenerDatosComidas();
				List<Producto> aBebdia1 =  RistoranteMain.bd.obtenerDatosBebidas();
				HashMap<String, List<Producto>> hmProds1 = new HashMap<>();
				hmProds1 .putIfAbsent("Bebida", aBebdia1);
				hmProds1.putIfAbsent("Comida", aComida1);
				mn.setpL(hmProds1);
				mn.setId(menu.getId());
				mn.setPrecioTotal(mn.obtenerPreciototal(mn.getpL()));
				mn.setNumProductos(2);
				
				modeloCarrito.addElement(mn);
				aMenus.setModel(modeloCarrito);
			}

		});
		
		cbBebida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object ob = cbBebida.getSelectedItem();
				Bebida bebida = (Bebida) ob;
				Menu menu = modeloCarrito.get(modeloCarrito.size()-1);
				menu.getpL().get("Bebida").add(bebida);
				menu.setPrecioTotal(menu.obtenerPreciototal(menu.getpL()));
			}
		});

		btnAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob = cbMenu.getSelectedItem();
				Menu menu = (Menu) ob;
//				HashMap<String, List<Producto>> hmPords = RistoranteMain.bd.obtenerProductos();
//				menu.setpL(hmPords);
//				menu.setPrecioTotal(menu.obtenerPreciototal(menu.getpL()));
				List<Producto> aComida1 = RistoranteMain.bd.obtenerDatosComidas();
				List<Producto> aBebdia1 =  RistoranteMain.bd.obtenerDatosBebidas();
				HashMap<String, List<Producto>> hmProds1 = new HashMap<>();
				hmProds1 .putIfAbsent("Bebida", aBebdia1);
				hmProds1.putIfAbsent("Comida", aComida1);
				menu.setpL(hmProds1);
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
		VentanaMenus vM = this;
		btnTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<modeloCarrito.getSize();i++) {
					Menu m = modeloCarrito.getElementAt(i);
					res.getaMenu().add(m);
				}
				
				RistoranteMain.bd.insertarDatosReserva(res);
				VentanaTicket vt = new VentanaTicket(vM);
				vt.setVisible(true);
			}
		});
		
		getContentPane().add(pNorth, BorderLayout.NORTH);
		getContentPane().add(pBtnJL, BorderLayout.CENTER);
		getContentPane().add(pTicket, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public ArrayList<Menu> obtenerCarrito() {
		ArrayList<Menu> aMenu = new ArrayList<>();
		if(modeloCarrito.getSize() > 0) {
			for (int i = 0; i < modeloCarrito.getSize(); i++) {
			aMenu.add(modeloCarrito.get(i));
			}
			System.out.println(aMenu);
		}
		return aMenu;
	}
	public void vaciarCarrito() {
		modeloCarrito.removeAllElements();
	}
}
