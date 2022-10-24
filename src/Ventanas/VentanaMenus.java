package Ventanas;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Comida;
import Logica.Menu;
import Logica.Menu_Degustacion;
import Logica.Menu_EntreSemana;
import Logica.Menu_Infantil;
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
import javax.swing.SwingConstants;
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
		Comida p1 = new Comida("Plato1", 10.1,01);
		Comida p2 = new Comida("Plato2", 10.1,02);
		Comida p3 = new Comida("Plato3", 10.1,03);
		
		aComida.add(p1);
		aComida.add(p2);
		aComida.add(p3);
		
		Menu_Degustacion m1 = new Menu_Degustacion("Menu_Degustacion", aComida, aComida.size());
		Menu_EntreSemana m2 = new Menu_EntreSemana("Menu_EntreSemana", aComida, aComida.size());
		Menu_Infantil m3 = new Menu_Infantil("Menu_Infantil", aComida, aComida.size());
		Menu_Infantil m4 = new Menu_Infantil("Menu_FinDeSemana", aComida, aComida.size());
		cbMenu.addItem(m1);
		cbMenu.addItem(m2);
		cbMenu.addItem(m3);
		cbMenu.addItem(m4);
		
		JPanel pcbx = new JPanel(new FlowLayout());
		JPanel pMedio2 = new JPanel(new FlowLayout());
		JPanel pNorth = new JPanel(new GridLayout(2, 1));
		
		JPanel pBtnsVerM = new JPanel(new FlowLayout());
		JPanel pBtnsAnadir = new JPanel(new FlowLayout());
		JPanel pMedio = new JPanel(new FlowLayout());
		JPanel pBtnJL = new JPanel(new GridLayout(3,1));
		
		JPanel pTicket = new JPanel();
		
		
		menusPane = new JScrollPane(aMenus);
		menusPane.setBorder(BorderFactory.createTitledBorder("Menus"));
		JButton btnAnadir = new JButton("+1");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnVaciar = new JButton("Vaciar");
		JButton btnTicket = new JButton("Ticket"); 
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