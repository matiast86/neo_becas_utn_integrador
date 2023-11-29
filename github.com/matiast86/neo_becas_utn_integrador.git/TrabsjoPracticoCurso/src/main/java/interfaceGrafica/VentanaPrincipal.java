package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;



	public class VentanaPrincipal extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JLabel lblEquipo;
		private JButton btnClickHere;



		public VentanaPrincipal(String [] parametrosArrayArgs) {
			setTitle("Calculador de apuestas - Equipo 7");
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
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\tp\\neo_becas_utn_integrador\\github.com\\matiast86\\neo_becas_utn_integrador.git\\TrabsjoPracticoCurso\\src\\main\\archivos\\img-neo.JPG"));
			lblNewLabel.setBounds(306, 52, 239, 65);
			contentPane.add(lblNewLabel);
			
			JButton btnSentenciaSql = new JButton("Leer datos por CSV");
			btnSentenciaSql.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent eventoira2) {
					ventana1 frame2 = new ventana1(parametrosArrayArgs,true);
					frame2.setVisible(true);
					dispose();
				}
			});
			btnSentenciaSql.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSentenciaSql.setBounds(539, 298, 196, 47);
			contentPane.add(btnSentenciaSql);
			
			btnClickHere = new JButton("Leer datos por SQL");
			btnClickHere.setToolTipText("asd");
			btnClickHere.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnClickHere.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent eventoira1) {
					ventana1 frame2 = new ventana1(parametrosArrayArgs,false);
					frame2.setVisible(true);
					dispose();
				}
			});
			btnClickHere.setBounds(130, 298, 189, 47);
			contentPane.add(btnClickHere);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(new Color(75, 0, 130));
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(419, 271, 12, 173);
			contentPane.add(separator);
		}
	}
