package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventana1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton btnGenerar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana1 frame = new ventana1();
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
	public ventana1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Participante", "Equipo 1", "Gana 1", "Empata", "Gana 2", "Equipo 2"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setToolTipText("");
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Cascadia Mono", Font.BOLD, 14));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 102, 204), new Color(51, 51, 204), new Color(102, 51, 204), new Color(153, 51, 204)));
		table.setBackground(new Color(51, 51, 51));
		table.setBounds(99, 299, 696, 129);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ronda", "Equipo 1", "Cant. goles 1", "Cant. goels 2", "Equipo 2"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setToolTipText("");
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setForeground(Color.WHITE);
		table_1.setFont(new Font("Cascadia Mono", Font.BOLD, 14));
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 102, 204), new Color(51, 51, 204), new Color(102, 51, 204), new Color(153, 51, 204)));
		table_1.setBackground(new Color(51, 51, 51));
		table_1.setBounds(134, 166, 624, 80);
		contentPane.add(table_1);
		
		JLabel lblEquipo = new JLabel("Equipo 7");
		lblEquipo.setToolTipText("");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setForeground(new Color(245, 245, 245));
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEquipo.setBounds(340, 85, 170, 32);
		contentPane.add(lblEquipo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\a.JPG"));
		lblNewLabel.setBounds(309, 9, 231, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoirmenu) {
				VentanaPrincipal frame2 = new VentanaPrincipal();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVolver.setBounds(458, 450, 82, 32);
		contentPane.add(btnVolver);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerar.setBounds(319, 450, 97, 32);
		contentPane.add(btnGenerar);
	}

}
