package Ventanas;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Menu;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

public class VentanaMenus extends JFrame {

	private JList<Menu> aMenus;
	
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
		setSize(600, 200);
		
		JComboBox <Menu> cbMenu = new JComboBox<>();
		
		JPanel pcbx = new JPanel();
		
		JPanel pBtnsAE = new JPanel(new FlowLayout());
		JPanel pBtnJL = new JPanel(new GridLayout(2,1));
		
		JPanel pTicket = new JPanel();
		
		JScrollPane menusPane = new JScrollPane(aMenus);
		menusPane.setBorder(BorderFactory.createTitledBorder("Menus"));
		JButton btnAnadir = new JButton("Añadir");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnTicket = new JButton("Ticket"); 
		
		pcbx.add(cbMenu);
		
		pBtnsAE.add(btnAnadir);
		pBtnsAE.add(btnEliminar);
		
		pBtnJL.add(pBtnsAE);
		pBtnJL.add(menusPane);
		
		pTicket.add(btnTicket);
		
		
		btnAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				}
		});
		
		getContentPane().add(cbMenu, BorderLayout.NORTH);
		getContentPane().add(pBtnJL, BorderLayout.CENTER);
		getContentPane().add(pTicket, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
	}

}
