package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Logica.Merch;
import Logica.Merch.Tipo;
import Logica.RistoranteMain;

public class VentanaCamisetas extends JFrame{
	private static final long serialVersionUID = 6656531196319599435L;
	List<Merch> listaMerch = RistoranteMain.bd.obtenerDatosMerch();
	List<Merch> listaMerchMostrar = new ArrayList<>(listaMerch);
	JPanel panelCentral = new JPanel(new GridLayout(0, 5));
	JComboBox<Merch> comboPedido;
	Map<Merch, Integer> mapaPedido;
	public VentanaCamisetas() {
		mapaPedido = cargarCarrito();
		updateFiltros(Filtro.Color, null);
		JPanel panelArriba = new JPanel(new FlowLayout());
		HashSet<String> colores = new HashSet<>();
		HashSet<Integer> tallas = new HashSet<>();
		for(Merch m : listaMerch) {
			colores.add(m.getColor());
			tallas.add(m.getTalla());
		}
		
		JComboBox<String> comboColores = new JComboBox<>(new String[]{"--Seleccione color--"});
		comboColores.addActionListener(new FilterListener(Filtro.Color));
		for(String s : colores)
			comboColores.addItem(s);
		panelArriba.add(comboColores);
		
		JComboBox<String> comboTallas = new JComboBox<>(new String[] {"--Seleccione talla--"});
		comboTallas.addActionListener(new FilterListener(Filtro.Talla));
		for(Integer i : tallas)
			comboTallas.addItem(i.toString());
		panelArriba.add(comboTallas);
		
		JComboBox<String> comboTipos = new JComboBox<>(new String[] {"--Seleccione producto--"});
		comboTipos.addActionListener(new FilterListener(Filtro.Tipo));
		for(Merch.Tipo t : Merch.Tipo.values())
			comboTipos.addItem(t.toString());
		panelArriba.add(comboTipos);
		
		JComboBox<String> comboOrden = new JComboBox<>(new String[] {"--Ordenar--"});
		comboOrden.addActionListener(new FilterListener(Filtro.ORDEN));
		for(Filtro f : Filtro.values())
			if(f != Filtro.ORDEN) {
				comboOrden.addItem(f.toString() +" ASC");
				comboOrden.addItem(f.toString() +" DESC");
			}
		panelArriba.add(comboOrden);
		comboPedido = new JComboBox<>();
		comboPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboPedido.getSelectedIndex() != -1 && isVisible()) {
					int i = JOptionPane.showConfirmDialog(null, "¿Deseas quitar" + comboPedido.getSelectedItem().toString()+" del carrito?");
					if(i == JOptionPane.OK_OPTION) {
						Merch m = (Merch) comboPedido.getSelectedItem();
						comboPedido.removeItem(m);
						int q = mapaPedido.get(m);
						if(q == 1)
							mapaPedido.remove(m);
						else
							mapaPedido.put(m, q - 1);
					}
				}
			}
			
		});
		mapaPedido.forEach((k, v) -> {
			for(int i = 0; i < v; i++)
				comboPedido.addItem(k);
		});
		panelArriba.add(comboPedido);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				guardarCarrito(mapaPedido);
				
			}
			
		});
		JButton btnComprar = new JButton("Pagar");
		btnComprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
				frame.add(new JLabel("Factura"));
				String stringPedido = "";
				float total = 0;
				for(Entry<Merch, Integer> m : mapaPedido.entrySet()) {
					stringPedido += m.getValue() + ": "+m.getKey().getTipo()+" talla: "+m.getKey().getTalla()+" color: "+m.getKey().getColor()+" "+m.getKey().getPrecio()+"€/u\n";
					total += m.getKey().getPrecio() * m.getValue();
				}
				
				frame.add(new JTextArea(stringPedido));
				JPanel panelInf = new JPanel(new FlowLayout());
				JButton btnImprimir = new JButton("Imprimir");
				final String str = stringPedido;
				final float pr = total;
				btnImprimir.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						generarFicheroFactura(str +"\n\n\nTOTAL: "+pr+"€");
					}
					
				});
				panelInf.add(btnImprimir);
				panelInf.add(new JLabel("Total: "+total+"€"));
				frame.add(panelInf);
				frame.setVisible(true);
				frame.setSize(new Dimension(300, 350));
				dispose();
			}
		});
		panelArriba.add(btnComprar);
		
		setSize(1300, 850);
		getContentPane().add(panelArriba, BorderLayout.NORTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(panelCentral, BorderLayout.CENTER);
	}
	private enum Filtro{
		Color,
		Tipo,
		Talla,
		Precio,
		ORDEN
	}
	HashMap<Filtro, String>filtros = new HashMap<>();
	private JPanel getPanelMerch(Merch m) {
		JPanel front = new JPanel(new BorderLayout());
		front.setBackground(new Color(0xf2f2f2ff));
		front.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 64)));
		front.add(new JLabel(m.getIcono()), BorderLayout.CENTER);
		JPanel panelInf = new JPanel(new FlowLayout());
		panelInf.add(new JLabel(String.format("%.2f€", m.getPrecio())));
		JButton btnComprar = new JButton("Comprar");
		panelInf.add(btnComprar);
		btnComprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboPedido.addItem(m);
				mapaPedido.putIfAbsent(m, 0);
				mapaPedido.put(m, mapaPedido.get(m) + 1);
			}
			
		});
		front.add(panelInf, BorderLayout.SOUTH);
		return front;
	}
	private void updateFiltros(Filtro f, String valor) {
		panelCentral.removeAll();
		listaMerchMostrar.clear();
		listaMerchMostrar.addAll(listaMerch);
		if (valor == null)
			filtros.remove(f);
		else
			filtros.put(f, valor);
		for(Entry<Filtro, String> e : filtros.entrySet()) {
			for(Merch m : new ArrayList<>(listaMerchMostrar)) {
				switch(e.getKey()) {
					case Color:
						if(!m.getColor().equals(e.getValue()))
							listaMerchMostrar.remove(m);
						break;
					case Tipo:
						if(!m.getTipo().equals(Tipo.valueOf(e.getValue())))
							listaMerchMostrar.remove(m);
						break;
					case Talla:
						if(!((Integer)m.getTalla()).toString().equals(e.getValue()))
							listaMerchMostrar.remove(m);
						break;
					case Precio:
						if(!((Float)m.getPrecio()).toString().equals(e.getValue()))
							listaMerchMostrar.remove(m);
						break;
					case ORDEN:
						switch(Filtro.valueOf(e.getValue().split(" ")[0])) {
							case Color:
								if(e.getValue().split(" ")[1].equals("ASC")) Collections.sort(listaMerchMostrar, (d1, d2)->{return d1.getColor().compareTo(d2.getColor());});
								else Collections.sort(listaMerchMostrar, (d1, d2)->{return d2.getColor().compareTo(d1.getColor());});
								break;
							case Tipo:
								if(e.getValue().split(" ")[1].equals("ASC")) Collections.sort(listaMerchMostrar, (d1, d2)->{return d1.getTipo().compareTo(d2.getTipo());});
								else Collections.sort(listaMerchMostrar, (d1, d2)->{return d2.getTipo().compareTo(d1.getTipo());});
								break;
							case Talla:
								if(e.getValue().split(" ")[1].equals("ASC")) Collections.sort(listaMerchMostrar, (d1, d2)->{return ((Integer)d1.getTalla()).compareTo(d2.getTalla());});
								else Collections.sort(listaMerchMostrar, (d1, d2)->{return ((Integer)d2.getTalla()).compareTo(d1.getTalla());});
								break;
							case Precio:
								if(e.getValue().split(" ")[1].equals("ASC")) Collections.sort(listaMerchMostrar, (d1, d2)->{return ((Float)d1.getPrecio()).compareTo(d2.getPrecio());});
								else Collections.sort(listaMerchMostrar, (d1, d2)->{return ((Float)d2.getPrecio()).compareTo(d1.getPrecio());});
								break;
							default:
								
						}
						break;
				}
				if(e.getKey() == Filtro.ORDEN)
					break;
			}
		}
		for(Merch m : listaMerchMostrar) {
			System.out.println(m.getTipo() + " " + m.getColor());
			panelCentral.add(getPanelMerch(m));
		}
		repaint();
		revalidate();
		
	}
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy kk.mm.ss");
	private void generarFicheroFactura(String text) {
		Date d = new Date(System.currentTimeMillis());
		String nomfich = sdf.format(d) +".txt";
		PrintWriter pw = null;
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Guardar factura en");
		jfc.setCurrentDirectory(new File("."));
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setAcceptAllFileFilterUsed(false);
		String dir;
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
		      dir = jfc.getSelectedFile().toString();
		}else {
			dir = "facturas";
		}
	
		try {
			System.out.println(dir + "/" + nomfich);
			pw = new PrintWriter(dir + "/" + nomfich);
			pw.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(pw!=null) {
				pw.flush();
				pw.close();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public Map<Merch, Integer> cargarCarrito() {
		Map<Merch, Integer> ret = new HashMap<>();//Valor si la carga falla
	    try(FileInputStream in = new FileInputStream("carrito.dat");
	    ObjectInputStream s = new ObjectInputStream(in)) {
	         ret = (Map<Merch, Integer>) s.readObject();
	    } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	    } catch (FileNotFoundException e1) {
	    	e1.printStackTrace();
	    } catch (IOException e1) {
	    	e1.printStackTrace();
		}	
		return ret;
	}
	
	public void guardarCarrito(Map<Merch, Integer> valorAGuardar) {
		try (FileOutputStream f = new FileOutputStream("carrito.dat");
				ObjectOutputStream s = new ObjectOutputStream(f)) {
				     s.writeObject(valorAGuardar);
				} catch (IOException error) {
				     error.printStackTrace();
				}
	}
	private class FilterListener implements ActionListener{
		private Filtro f;
		public FilterListener(Filtro f) {
			this.f = f;
		}
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			String valor = (String)((JComboBox<String>)e.getSource()).getSelectedItem();
			if(valor.startsWith("--"))
				updateFiltros(f, null);
			else
				updateFiltros(f, valor);
			
		}
		
	}
}
