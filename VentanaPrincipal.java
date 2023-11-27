package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import java.awt.Canvas;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblEquipo;
	private JButton btnClickHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(UIManager.getBorder("Tree.editorBorder"));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEquipo = new JLabel("Equipo 7");
		lblEquipo.setToolTipText("");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setForeground(new Color(245, 245, 245));
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEquipo.setBounds(339, 141, 170, 32);
		contentPane.add(lblEquipo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\s.png"));
		lblNewLabel.setBounds(291, 53, 263, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnSentenciaSql = new JButton("Clickea aquí");
		btnSentenciaSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoira2) {
				ventana2 frame2 = new ventana2();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnSentenciaSql.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSentenciaSql.setBounds(563, 318, 131, 47);
		contentPane.add(btnSentenciaSql);
		
		btnClickHere = new JButton("Clickea aquí");
		btnClickHere.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoira1) {
				ventana1 frame2 = new ventana1();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnClickHere.setBounds(137, 318, 131, 47);
		contentPane.add(btnClickHere);
		
		JLabel lblNewLabel_1 = new JLabel("¿Ingresar con datos de manera manual?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(61, 241, 303, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("¿Ingresar con datos ya cargados?");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(489, 238, 303, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(75, 0, 130));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(419, 271, 12, 173);
		contentPane.add(separator);
	}
}
