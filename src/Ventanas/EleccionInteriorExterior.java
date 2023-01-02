package Ventanas;




import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EleccionInteriorExterior extends JFrame{

	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public EleccionInteriorExterior() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelIzq, BorderLayout.WEST);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ristorante");
		lblNewLabel.setFont(new Font("Freestyle Script", Font.BOLD, 27));
		panelNorth.add(lblNewLabel);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelDer = new JPanel();
		panelDer.setBackground(new Color(255, 128, 64));
		getContentPane().add(panelDer, BorderLayout.EAST);
		
		JPanel panelCent = new JPanel();
		panelCent.setBackground(new Color(255, 255, 128));
		getContentPane().add(panelCent, BorderLayout.CENTER);
		panelCent.setLayout(null);
		
		JButton btnInterior = new JButton("Interior");
		btnInterior.setBackground(new Color(128, 255, 128));
		btnInterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaReservaInteriror window = new VentanaReservaInteriror();
				window.setVisible(true);
				dispose();
			}
		});
		btnInterior.setBounds(99, 75, 89, 23);
		panelCent.add(btnInterior);
		
		JButton btnExteriror = new JButton("Exteriror");
		btnExteriror.setBackground(new Color(255, 128, 64));
		btnExteriror.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaReservaExteriror window = new VentanaReservaExteriror();
				window.setVisible(true);
				dispose();
			}
		});
		btnExteriror.setBounds(223, 75, 89, 23);
		panelCent.add(btnExteriror);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione donde quiere comer:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(118, 35, 194, 14);
		panelCent.add(lblNewLabel_1);
	}
}
