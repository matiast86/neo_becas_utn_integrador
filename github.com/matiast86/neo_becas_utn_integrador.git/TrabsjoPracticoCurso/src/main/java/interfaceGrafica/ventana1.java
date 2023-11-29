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

import Logica.Apostador;
import Logica.Logica;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class ventana1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton btnGenerar;
	private JTable table_2;
	private JTable table_3;
	private JComboBox puntosAlGanar;
	private JComboBox puntosAlPerder;
	private ArrayList<Apostador> apostadores;

	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
*/
	/**
	 * Create the frame.
	 */
	public ventana1(String [] arrayArgs,boolean lectura) {
		setTitle("Calculador de apuestas - Equipo 7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1183, 771);
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
		table.setBounds(251, 355, 696, 160);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ronda", "Equipo 1", "Cant. goles 1", "Cant. goels 2", "Equipo 2"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
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
		table_1.setBounds(286, 544, 624, 160);
		contentPane.add(table_1);
		
		JLabel lblEquipo = new JLabel("Equipo 7");
		lblEquipo.setToolTipText("");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setForeground(new Color(245, 245, 245));
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEquipo.setBounds(468, 88, 170, 32);
		contentPane.add(lblEquipo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\tp\\neo_becas_utn_integrador\\github.com\\matiast86\\neo_becas_utn_integrador.git\\TrabsjoPracticoCurso\\src\\main\\archivos\\img-neo.JPG"));
		lblNewLabel.setBounds(433, 12, 231, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoirmenu) {
				VentanaPrincipal frame2 = new VentanaPrincipal(arrayArgs);
				frame2.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVolver.setBounds(1075, 689, 82, 32);
		contentPane.add(btnVolver);
		
		
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Apostadores"},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(91);
		table_2.setToolTipText("");
		table_2.setSurrendersFocusOnKeystroke(true);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setForeground(Color.WHITE);
		table_2.setFont(new Font("Cascadia Mono", Font.BOLD, 14));
		table_2.setFillsViewportHeight(true);
		table_2.setColumnSelectionAllowed(true);
		table_2.setCellSelectionEnabled(true);
		table_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 102, 204), new Color(51, 51, 204), new Color(102, 51, 204), new Color(153, 51, 204)));
		table_2.setBackground(new Color(51, 51, 51));
		table_2.setBounds(10, 150, 123, 160);
		contentPane.add(table_2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{"Pts. obtenidos"},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table_3.setToolTipText("");
		table_3.setSurrendersFocusOnKeystroke(true);
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_3.setForeground(Color.WHITE);
		table_3.setFont(new Font("Cascadia Mono", Font.BOLD, 14));
		table_3.setFillsViewportHeight(true);
		table_3.setColumnSelectionAllowed(true);
		table_3.setCellSelectionEnabled(true);
		table_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 102, 204), new Color(51, 51, 204), new Color(102, 51, 204), new Color(153, 51, 204)));
		table_3.setBackground(new Color(51, 51, 51));
		table_3.setBounds(180, 150, 129, 160);
		contentPane.add(table_3);
		
		JLabel preguntaPuntosGanar = new JLabel("¿Cuántos puntos querés que gane al acertar?");
		preguntaPuntosGanar.setForeground(Color.WHITE);
		preguntaPuntosGanar.setFont(new Font("Cascadia Mono", Font.BOLD, 12));
		preguntaPuntosGanar.setBounds(732, 152, 315, 32);
		contentPane.add(preguntaPuntosGanar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(51, 0, 153));
		panel.setBounds(712, 145, 411, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		puntosAlGanar = new JComboBox();
		puntosAlGanar.setBounds(362, 11, 39, 22);
		panel.add(puntosAlGanar);
		puntosAlGanar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		puntosAlGanar.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(51, 0, 153));
		panel_1.setBounds(712, 228, 411, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel preguntaPuntosPerder = new JLabel("¿Cuántos puntos querés que pierda al errar?");
		preguntaPuntosPerder.setBounds(22, 11, 315, 15);
		preguntaPuntosPerder.setForeground(Color.WHITE);
		preguntaPuntosPerder.setFont(new Font("Cascadia Mono", Font.BOLD, 12));
		panel_1.add(preguntaPuntosPerder);
		
		puntosAlPerder = new JComboBox();
		puntosAlPerder.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		puntosAlPerder.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		puntosAlPerder.setBounds(362, 7, 39, 22);
		panel_1.add(puntosAlPerder);
		
		btnGenerar = new JButton("Calcular puntos");
		
		btnGenerar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent eventoCalcularPuntos) {
				
				
				int puntosGanar = Integer.parseInt((String) puntosAlGanar.getSelectedItem()); 
				int puntosPerder = Integer.parseInt((String) puntosAlPerder.getSelectedItem()); ; 
				
				apostadores = Logica.IniciarLogica(arrayArgs,lectura,puntosGanar,puntosPerder);
				
				Apostador.ordenarApostadores(apostadores);
				
			    // Actualizar el modelo de la tabla_2
			    DefaultTableModel tableModel2 = new DefaultTableModel();
			    tableModel2.addColumn("Apostadores");
			    
			    tableModel2.addRow(new Object[]{"Apostadores"});

			    for (Apostador apostador : apostadores) {
			        tableModel2.addRow(new Object[]{apostador.getNombre()}); // Reemplaza "getNombre()" con el método apropiado para obtener el nombre del apostador
			    }

			    table_2.setModel(tableModel2);

			    // Actualizar el modelo de la tabla_3
			    DefaultTableModel tableModel3 = new DefaultTableModel();
			    tableModel3.addColumn("Pts. obtenidos");
			    
			    tableModel3.addRow(new Object[]{"Pts. obtenidos"});

			    for (Apostador apostador : apostadores) {
			        tableModel3.addRow(new Object[]{apostador.getPuntos()}); // Reemplaza "getPuntosObtenidos()" con el método apropiado para obtener los puntos del apostador
			    }

			    table_3.setModel(tableModel3);
				 
				
				
				
			}
			



		});
		

		
		btnGenerar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerar.setBounds(841, 278, 173, 32);
		contentPane.add(btnGenerar);
		
		
		
		
		
		
	}
}