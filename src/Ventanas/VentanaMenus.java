package Ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;

import Logica.Bebida;
import Logica.Comida;
import Logica.Menu;
import Logica.Producto;
import Logica.Reserva;
import Logica.RistoranteMain;
import recursividad.Recursividad;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;

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
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class VentanaMenus extends JFrame {

	/**
	 * 
	 */
	private Reserva res;
	private static final long serialVersionUID = 1L;
	private JList<Menu> aMenus;
	private DefaultListModel <Menu> modeloCarrito;
	private JScrollPane menusPane;
	int contadorMenus = 0;
	JSpinner spNum = new JSpinner();
	JTable jtMenus = new JTable();
	

	
	public VentanaMenus(Reserva res) {
		this.res = res;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 400);
		aMenus = new JList<>();
		modeloCarrito = new DefaultListModel<>();
		contadorMenus = res.getNumPersonas();
		spNum.setEnabled(false);
		
		JComboBox <Menu> cbMenu = new JComboBox<>();
		JComboBox <Producto> cbBebida = new JComboBox<>();
		cbMenu.setPreferredSize(new Dimension(140, 20));
		cbBebida.setPreferredSize(new Dimension(140, 20));
		
		ArrayList<Producto> aComida = new ArrayList<>();
		ArrayList<Producto> aBebdia = new ArrayList<>();
		List<Comida> aComida1 = RistoranteMain.bd.obtenerDatosComidas();
		List<Bebida> aBebdia1 =  RistoranteMain.bd.obtenerDatosBebidas();
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
		
		HashMap<String, List<? extends Producto>> hmProdsBd = RistoranteMain.bd.obtenerProductos();
		HashMap<String, List<? extends Producto>> hmProds = new HashMap<>();
		
		List<Menu> lMenus = RistoranteMain.bd.obtenerDatosMenu();
		for (Menu menu : lMenus) {
			menu.setpL(hmProdsBd);
		}
		
		
		hmProds.putIfAbsent("Bebida", aBebdia1);
		hmProds.putIfAbsent("Comida", aComida1);
		
		double precioTot=0;
		
		Menu m1 = new Menu(1, hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot, "Menu_Degustacion");
		Menu m2 = new Menu(2, hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot, "Menu_EntreSemana");
		Menu m3 = new Menu(3, hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot,"Menu_Infantil");
		Menu m4 = new Menu(4, hmProds, hmProds.get("Comida").size()+hmProds.get("Bebida").size(),precioTot, "Menu_FinDeSemana");
		
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
		
		JLabel lblDegus = new JLabel(m1.toString());
		JLabel lblEntre = new JLabel(m2.toString());
		JLabel lblFinDe = new JLabel(m4.toString());
		JLabel lblInfant = new JLabel(m3.toString());
		JPanel panel = new JPanel(new FlowLayout());
		
		
		panel.add(lblDegus);
		panel.add(lblEntre);
		panel.add(lblFinDe);
		panel.add(lblInfant);
		
//		cbBebida.addItem(b1);
//		cbBebida.addItem(b2);
		
		JPanel pcbx = new JPanel(new FlowLayout());
		pcbx.setBackground(new Color(255, 128, 0));
		JPanel pMedio2 = new JPanel(new FlowLayout());
		pMedio2.setBackground(new Color(255, 128, 0));
		pMedio2.setForeground(new Color(0, 0, 0));
		JPanel pNorth = new JPanel(new GridLayout(3, 1));
		pNorth.setBackground(new Color(255, 128, 0));
		
		JPanel pBtnsAnadir = new JPanel(new FlowLayout());
		pBtnsAnadir.setBackground(new Color(255, 255, 128));
		JPanel pMedio = new JPanel(new GridLayout(6,1));
		pMedio.setBackground(new Color(255, 255, 128));
		JPanel pBtnJL = new JPanel(new GridLayout(3,1));
		
		JPanel pTicket = new JPanel(new FlowLayout());
		pTicket.setBackground(new Color(255, 128, 0));
		
		menusPane = new JScrollPane(aMenus);
		menusPane.setBorder(BorderFactory.createTitledBorder("Menus"));
		JButton btnAnadir = new JButton("+1");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnVaciar = new JButton("Vaciar");
		JButton btnTicket = new JButton("Ticket"); 
		JLabel lblCB = new JLabel("Seleccione el menú :");
		JLabel lblCBB = new JLabel("Seleccione bebida :");
		JButton btnVerMenus = new JButton("Ver Menus");
		JButton btnQMenus = new JButton("Cerrar");
		JLabel jlMnRes = new JLabel("Menus restantes: ");
		
		
		pcbx.add(lblCB);
		pcbx.add(cbMenu);
		pcbx.add(lblCBB);
		pcbx.add(cbBebida);
		pMedio.add(btnVerMenus);
		pMedio.add(btnQMenus);
		
		pNorth.add(pMedio2);
		
		JLabel lbltit = new JLabel("Menus");
		lbltit.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		pMedio2.add(lbltit);
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
				pMedio.add(lblDegus);
				pMedio.add(lblEntre);
				pMedio.add(lblFinDe);
				pMedio.add(lblInfant);
				
				setSize(1000, 410);
			}
		
		});
		
		btnQMenus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pMedio.remove(lblDegus);
				pMedio.remove(lblEntre);
				pMedio.remove(lblFinDe);
				pMedio.remove(lblInfant);
				
				setSize(1000, 400);
			}
		});
		
		cbMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(contadorMenus == 0) {
					JOptionPane.showMessageDialog(null, "Ya ha saleccionado un menú por persona");
				}else {
					Object ob = cbMenu.getSelectedItem();
					Menu menu = (Menu) ob;
					menu = (Menu) ob;
	//				HashMap<String, List<Producto>> hmPords = RistoranteMain.bd.obtenerProductos();
	//				menu.setpL(hmPords);
	//				menu.setPrecioTotal(menu.obtenerPreciototal(menu.getpL()));
					Menu mn = new Menu();
					List<Comida> aComida1 = RistoranteMain.bd.obtenerDatosComidas();
					List<Bebida> aBebdia1 =  RistoranteMain.bd.obtenerDatosBebidas();
					HashMap<String, List<? extends Producto>> hmProds1 = new HashMap<>();
					hmProds1 .putIfAbsent("Bebida", aBebdia1);
					hmProds1.putIfAbsent("Comida", aComida1);
					mn.setpL(hmProds1);
					mn.setId(menu.getId());
					mn.setCaracteristicas("menuEstudiante");
					mn.setPrecioTotal(mn.obtenerPreciototal((HashMap<String, List<? extends Producto>>) mn.getpL()));
					mn.setNumProductos(2);
					
					modeloCarrito.addElement(mn);
					aMenus.setModel(modeloCarrito);
					contadorMenus --;
					spNum.setValue(contadorMenus);
				}
				
			}

		});
		
		cbBebida.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object ob = cbBebida.getSelectedItem();
				Bebida bebida = (Bebida) ob;
				Menu menu = modeloCarrito.get(modeloCarrito.size()-1);
				((List<Bebida>)menu.getpL().get("Bebida")).add(bebida);
				menu.setPrecioTotal(menu.obtenerPreciototal(menu.getpL()));
				modeloCarrito.remove(modeloCarrito.getSize()-1);
				modeloCarrito.addElement(menu);
				aMenus.setModel(modeloCarrito);
			}
		});

		btnAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contadorMenus == 0) {
					JOptionPane.showMessageDialog(null, "Ya ha saleccionado un menú por persona");
				}else {
					Object ob = cbMenu.getSelectedItem();
					Menu menu = (Menu) ob;
	//				HashMap<String, List<Producto>> hmPords = RistoranteMain.bd.obtenerProductos();
	//				menu.setpL(hmPords);
	//				menu.setPrecioTotal(menu.obtenerPreciototal(menu.getpL()));
					List<Comida> aComida1 = RistoranteMain.bd.obtenerDatosComidas();
					List<Bebida> aBebdia1 =  RistoranteMain.bd.obtenerDatosBebidas();
					HashMap<String, List<? extends Producto>> hmProds1 = new HashMap<>();
					hmProds1 .putIfAbsent("Bebida", aBebdia1);
					hmProds1.putIfAbsent("Comida", aComida1);
					menu.setpL(hmProds1);
					modeloCarrito.addElement(menu);
					aMenus.setModel(modeloCarrito);
					contadorMenus --;
					spNum.setValue(contadorMenus);
				}
			}
			
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				modeloCarrito.removeElement(aMenus.getSelectedValue());
				contadorMenus++;
				spNum.setValue(contadorMenus);
			}
		});
		
		btnVaciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modeloCarrito.clear();
				contadorMenus = res.getNumPersonas();
				spNum.setValue(res.getNumPersonas());
			}
		});
		VentanaMenus vM = this;
		btnTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(contadorMenus != 0) {
					JOptionPane.showMessageDialog(null, "No ha seleccionado un menu por persona");
				}else {
				for(int i=0;i<modeloCarrito.getSize();i++) {
					Menu m = modeloCarrito.getElementAt(i);
					res.getaMenu().add(m);
					vM.setVisible(false);
				}
				List<String> caracteristicasMenus = new ArrayList<>();
				for(Menu mC : res.getaMenu()) {
					caracteristicasMenus.add(mC.getCaracteristicas());
				}
				List<List<String>> rcur =  Recursividad.combinaciones(caracteristicasMenus, res.getNumPersonas());
				for(List<String> m : rcur) {
					System.out.println(m);
				}
				
				RistoranteMain.bd.insertarDatosReserva(res);
				VentanaTicket vt = new VentanaTicket(vM);
				dispose();
				}
			}
		});
		
		getContentPane().add(pNorth, BorderLayout.NORTH);
		pcbx.add(jlMnRes);
		pcbx.add(spNum);
		spNum.setValue(contadorMenus);
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