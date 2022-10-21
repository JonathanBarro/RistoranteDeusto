package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

public class VentanaReservaInteriror extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReservaInteriror frame = new VentanaReservaInteriror();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaReservaInteriror() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Izquirda = new JPanel();
		contentPane.add(panel_Izquirda, BorderLayout.WEST);
		
		JPanel panel_Norte = new JPanel();
		contentPane.add(panel_Norte, BorderLayout.NORTH);
		
		JLabel jLRistorante = new JLabel("Ristorante");
		jLRistorante.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		panel_Norte.add(jLRistorante);
		
		JPanel panel_Sur = new JPanel();
		contentPane.add(panel_Sur, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_Sur.add(btnConfirm);
		
		JPanel panel_Dercha = new JPanel();
		contentPane.add(panel_Dercha, BorderLayout.EAST);
		
		JPanel panel_Cent = new JPanel();
		contentPane.add(panel_Cent, BorderLayout.CENTER);
		panel_Cent.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_ComboCent = new JPanel();
		panel_Cent.add(panel_ComboCent, BorderLayout.NORTH);
		
		JComboBox comboBox_NPersonas = new JComboBox();
		panel_ComboCent.add(comboBox_NPersonas);
		
		JPanel panel_JCalendar = new JPanel();
		panel_Cent.add(panel_JCalendar, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel_Cent.add(panel, BorderLayout.WEST);
	}

}
