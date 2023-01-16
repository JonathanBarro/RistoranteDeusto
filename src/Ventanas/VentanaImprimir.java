package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import BD.BD;
import Logica.Menu;
import Logica.Reserva;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentanaImprimir extends JFrame{
	private static final long serialVersionUID = -4174990565436263519L;
	private VentanaMenus vM;
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy kk.mm.ss");
	protected JTextArea taResumen;
	private JScrollPane scrollAreaResumen;
	private BD bd = new BD();
	
	public VentanaImprimir(VentanaMenus vM) {
		
		this.vM = vM;
		JPanel pImprimir = new JPanel(new FlowLayout());
		JButton btnImprimir = new JButton("Imprimir");
		pImprimir.add(btnImprimir);
		setSize(500,300);
		getContentPane().add(pImprimir, BorderLayout.SOUTH);
		taResumen = new JTextArea();
		taResumen.setEditable(false);
		scrollAreaResumen = new JScrollPane(taResumen);
		getContentPane().add(scrollAreaResumen, BorderLayout.CENTER);
		taResumen.setText("");
		try {
			cargarCarritoEnTextArea();
		}catch(NullPointerException e) {}
		
		setVisible(true);
		
		btnImprimir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				generarFicheroFactura();
				JOptionPane.showMessageDialog(null, "Gracias por su compra, esperemos que vuelva pronto");
				dispose();
				VentanaAdminCliente vIA = new VentanaAdminCliente();
				vIA.setVisible(true);
			}
		});
		setLocationRelativeTo(null);
	}
	protected void cargarCarritoEnTextArea() {

		Date d = new Date(System.currentTimeMillis());
		String texto = ""
				+ "Factura de la compra del dia: " + sdf.format(d) + "\n";
		double total = 0;
		ArrayList<Menu> aMenu = vM.obtenerCarrito();
		for(Menu m: aMenu) {
			texto = texto + "	" + m.toString().replace("\n", "") + "\n";
			total += m.obtenerPreciototal(m.getpL());
		}
		List<Reserva> aReserva = bd.obtenerDatosReservas();
		texto = texto + "	" + aReserva.get(aReserva.size()-1).toString().replace("\n", "") + "\n";
		texto = texto + "TOTAL: " + total + " €";
		taResumen.setText(texto);
	}


	private void generarFicheroFactura() {
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
			pw.println(taResumen.getText());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pw!=null) {
				pw.flush();
				pw.close();
			}
		}
}

}
