package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class Mantenimiento extends JFrame {

	private Controlador controlador;
	private Conexion conexion;
	private JPanel contentPane;
	private Principal principal;
	private Registro registro;
 
	private JTabbedPane tabbedPane;
	private JPanel panel_materiales;
	private JTable table_material;
	private JButton btnAnadirMaterial;
	private JButton btnSalir;
	private JTextField textFieldModificaMaterial;
	private JTextField textFieldModificaFamilia;
	private JTextField textFieldModificaSubfamilia;
	private JLabel lblNombreAModificar;
	private JLabel lblFamiliaAModificar;
	private JLabel lblSubfamiliaAModificar;
	private DefaultTableModel dtm;
 	private JTextField txtnombre;
	private JLabel lblNewLabel_1;
	private JTextField txtfamilia;
	private JTextField txtsubfamilia;
	private JLabel lblSubfamilia;

	public void rellenarTablaMateriales() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) table_material.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}
	}

 
	 

	// *********************************************
	// *******BRYAN RELLENAR SEGUNDOS COMBOS********
	// *********************************************

	// public void comboSubfamilia(Object family) {
	//
	// DefaultComboBoxModel modelSubFamilia = new DefaultComboBoxModel();
	//
	// try {
	//
	// String url = "jdbc:oracle:thin:@localhost:1521:XE";
	// conexions = DriverManager.getConnection(url, "system", "galego");
	// // Consulta de la tabla
	//
	// Statement stat = conexions.createStatement();
	// ResultSet rslt = stat.executeQuery(
	// "SELECT NOM_SUBFAMILIA FROM dbma.SUBFAMILIA WHERE FAMILIA_COD_FAMILIA =
	// (SELECT COD_FAMILIA FROM dbma.FAMILIA WHERE NOM_FAMILIA = '"
	// + family + "')");
	// while (rslt.next()) {
	// modelSubFamilia.addElement(rslt.getObject(1));
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// comboBox.setModel(modelSubFamilia);
	//
	// }
	//
	// // **************************************************
	public void settodo(Principal principal,  Conexion conexion,
			Controlador controlador) {
		this.principal = principal;
 		this.conexion = conexion;
		this.controlador = controlador;}

	public Mantenimiento() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				controlador.cargarMateriales();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(173, 216, 230));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1067, GroupLayout.PREFERRED_SIZE).addGap(3854)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));

		panel_materiales = new JPanel();
		panel_materiales.setBackground(new Color(245, 222, 179));
		tabbedPane.addTab("Materiales", null, panel_materiales, null);

		btnAnadirMaterial = new JButton("A\u00F1adir Material");
 	 

		JScrollPane scrollPane_material1 = new JScrollPane();

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				principal.setVisible(true);
			}
		});

		textFieldModificaMaterial = new JTextField();
		textFieldModificaMaterial.setColumns(10);

		textFieldModificaFamilia = new JTextField();
		textFieldModificaFamilia.setColumns(10);

		textFieldModificaSubfamilia = new JTextField();
		textFieldModificaSubfamilia.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_material.setValueAt(textFieldModificaMaterial.getText(), table_material.getSelectedRow(), 0);
				table_material.setValueAt(textFieldModificaFamilia.getText(), table_material.getSelectedRow(), 1);
				table_material.setValueAt(textFieldModificaSubfamilia.getText(), table_material.getSelectedRow(), 2);

			}
		});

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm = (DefaultTableModel) table_material.getModel();
				int a = table_material.getSelectedRow();
				dtm.removeRow(a);
				btnModificar.setEnabled(false);
				btnBorrar.setEnabled(false);
				textFieldModificaMaterial.setText("");
				textFieldModificaFamilia.setText("");
				textFieldModificaSubfamilia.setText("");

			}
		});

		lblNombreAModificar = new JLabel("Nombre a modificar");

		lblFamiliaAModificar = new JLabel("Familia a modificar");

		lblSubfamiliaAModificar = new JLabel("Subfamilia a modificar");
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		
		lblNewLabel_1 = new JLabel("FAMILIA:");
		
		txtfamilia = new JTextField();
		txtfamilia.setColumns(10);
		
		txtsubfamilia = new JTextField();
		txtsubfamilia.setColumns(10);
		
		lblSubfamilia = new JLabel("SUBFAMILIA:");

		GroupLayout gl_panel_materiales = new GroupLayout(panel_materiales);
		gl_panel_materiales.setHorizontalGroup(
			gl_panel_materiales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_materiales.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_material1, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_materiales.createSequentialGroup()
							.addComponent(textFieldModificaMaterial, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFamiliaAModificar, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldModificaFamilia, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldModificaSubfamilia, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(lblSubfamiliaAModificar, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_materiales.createSequentialGroup()
							.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombreAModificar)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
							.addGroup(gl_panel_materiales.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel_materiales.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtfamilia, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panel_materiales.createSequentialGroup()
									.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre)
										.addComponent(lblSubfamilia, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
									.addGap(31)
									.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnAnadirMaterial, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtnombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(txtsubfamilia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))))
					.addGap(449))
		);
		gl_panel_materiales.setVerticalGroup(
			gl_panel_materiales.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_materiales.createSequentialGroup()
					.addGap(34)
					.addComponent(scrollPane_material1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel_materiales.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_materiales.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldModificaMaterial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNombreAModificar))
						.addGroup(gl_panel_materiales.createSequentialGroup()
							.addGroup(gl_panel_materiales.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldModificaSubfamilia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldModificaFamilia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_materiales.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSubfamiliaAModificar)
								.addComponent(lblFamiliaAModificar))))
					.addGroup(gl_panel_materiales.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_materiales.createSequentialGroup()
							.addGap(41)
							.addComponent(btnBorrar)
							.addGap(18)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
							.addComponent(btnSalir))
						.addGroup(gl_panel_materiales.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_materiales.createSequentialGroup()
									.addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_panel_materiales.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtfamilia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
									.addGap(18)
									.addGroup(gl_panel_materiales.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtsubfamilia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSubfamilia)))
								.addComponent(lblNombre))
							.addGap(18)
							.addComponent(btnAnadirMaterial)
							.addGap(22)))
					.addGap(20))
		);

		table_material = new JTable();
		table_material.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int filaSelect = table_material.getSelectedRow();
				textFieldModificaMaterial.setText(table_material.getValueAt(filaSelect, 0).toString());
				textFieldModificaFamilia.setText(table_material.getValueAt(filaSelect, 1).toString());
				textFieldModificaSubfamilia.setText(table_material.getValueAt(filaSelect, 2).toString());

			}
		});

		table_material
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Familia", "Subfamilia" }));
		scrollPane_material1.setViewportView(table_material);
		panel_materiales.setLayout(gl_panel_materiales);
		dtm = new DefaultTableModel(new Object[][] {

		}, new String[] { "Codigo", "Noticia" });
		contentPane.setLayout(gl_contentPane);
	}

	public void setCtrl(Controlador ctrl) {
		this.controlador = ctrl;

	}

	public void setBd(Conexion bd) {
		this.conexion = bd;
	}
}