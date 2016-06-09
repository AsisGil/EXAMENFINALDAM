package Vista;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controlador.Controlador;
import Modelo.Conexion;
import Vista.Bienvenida;
import Vista.Mantenimiento;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;

public class Principal extends JFrame {

	private JTextField txtusuario;
	private Mantenimiento mantenimiento;
	private Registro registro;
	private JPasswordField passcontra;
	private JButton btnusuario;
	private Bienvenida bienvenida;
	private String usuario;
	private String contrasena;
	int contador;
	private Component panel;
	private ini ini;
	private Conexion conexion;
	private Controlador controlador;

	

	public Principal() {

		setTitle("PANTALLA PRINCIPAL");
		getContentPane().setBackground(new Color(173, 216, 230));
		setVisible(false);
		txtusuario = new JTextField();
		txtusuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controllogin();
			}
		});
		txtusuario.setColumns(10);

		JLabel lblusuario = new JLabel("USER:");
		lblusuario.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/4.png")));
		lblusuario.setFont(new Font("Stencil", Font.PLAIN, 15));
		JLabel lblcontrasena = new JLabel("PASSWORD:");
		lblcontrasena.setIcon(null);
		lblcontrasena.setFont(new Font("Stencil", Font.PLAIN, 15));
		JButton btnlogout = new JButton("LOGOUT");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnusuario = new JButton("LOGIN");
		btnusuario.setEnabled(false);
		btnusuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
//				conexion = new Conexion();			
				char[] pass = passcontra.getPassword();// Array de char
				String contra = new String(pass);// Pasa el Array de char a un
				controlador.comprobacion(txtusuario.getText(), contra);

 
			}
		});

		JLabel label = new JLabel("");
		passcontra = new JPasswordField();
		passcontra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controllogin();

			}
		});

		JButton button = new JButton("SING IN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				registro.setVisible(true);
			}
		});

		JButton btnConfiguracionIni = new JButton("Configuracion INI");
		btnConfiguracionIni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setVisible(true);
 				ini.cargaContenidoDeFichero();;
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(btnConfiguracionIni))
						.addGroup(groupLayout.createSequentialGroup().addGap(20).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(button, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnusuario, GroupLayout.PREFERRED_SIZE, 116,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(btnlogout, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addComponent(label)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblcontrasena).addComponent(lblusuario,
														GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(txtusuario, GroupLayout.PREFERRED_SIZE, 111,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(passcontra, GroupLayout.PREFERRED_SIZE, 112,
														GroupLayout.PREFERRED_SIZE))))))
						.addGap(107)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(23)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblusuario, GroupLayout.PREFERRED_SIZE, 35,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtusuario, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblcontrasena).addComponent(passcontra,
												GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))))
				.addGap(11)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(btnusuario)
						.addComponent(button)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnlogout)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnConfiguracionIni).addGap(44)));
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 337, 272);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setconexionymantenimientoyregistroyiniycontrolador(Conexion conexion, Mantenimiento mantenimiento,
			Registro registro, ini ini, Controlador controlador) {
		this.mantenimiento = mantenimiento;
		this.registro = registro;
		this.ini = ini;
		this.conexion = conexion;
		this.controlador = controlador;
	}
	public void autenticar(boolean accion){
		if(accion){
			mantenimiento.setVisible(true);
			setVisible(false);
		}
		else{
			JOptionPane.showMessageDialog(panel, "El usuario o contraseña son incorrectos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void controllogin() {

		String contrauno = new String(passcontra.getPassword());

		if ((txtusuario.getText().length() >= 1 || contrauno.length() >= 1)) {
			btnusuario.setEnabled(true);
		}

		if (!txtusuario.getText().trim().equals("") && (!(((new String(passcontra.getPassword())).trim().equals("")))))
			btnusuario.setEnabled(true);
		else
			btnusuario.setEnabled(false);
	}
	
}