package Vista;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Modelo.Conexion;
import Vista.Mantenimiento;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Component;

public class Registro extends JFrame {

	private Principal login;
	private Mantenimiento mantenimiento;
	private JLabel lblNick;
	private JLabel lblRepetircontrasena;
	private JLabel lblEmail;
	private JLabel lblApellidos;
	private JLabel lblNombre;
	private JLabel lblContrasena;
	private JButton btnCnacelar;
	private JButton btnregistrar;
	private JPasswordField txtpass;
	private JPasswordField txtpass2;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;

	public void setprincipalymantenimiento(Principal login, Mantenimiento mantenimiento) {
		this.login = login;
		this.mantenimiento = mantenimiento;

	}

	public void controlregistrar() {
		if (((!txt1.getText().trim().equals("")) && (!txt2.getText().trim().equals(""))
				&& (!txt3.getText().trim().equals("")) && (!txt4.getText().trim().equals(""))
				&& (!((new String(txtpass.getPassword())).trim().equals(""))
						&& (!(((new String(txtpass2.getPassword())).trim().equals("")))))))
			btnregistrar.setEnabled(true);
		else
			btnregistrar.setEnabled(false);

	}

	public Registro() {

		setTitle("REGISTRO");
		getContentPane().setBackground(new Color(173, 216, 230));
		lblNick = new JLabel("Nick");
		lblNombre = new JLabel("Nombre");
		lblApellidos = new JLabel("Apellidos");
		lblEmail = new JLabel("Email");
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblRepetircontrasena = new JLabel("Repetir Contrase\u00F1a");
		btnCnacelar = new JButton("Cancelar");
		btnCnacelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login.setVisible(true);
			}
		});
		btnregistrar = new JButton("Registrar");
		btnregistrar.addActionListener(new ActionListener() {
			private Component panel;

			public void actionPerformed(ActionEvent e) {

				String contrauno = new String(txtpass.getPassword());
				String contrados = new String(txtpass2.getPassword());
//				conexion.comprobaciones(contrauno, contrados);

				if (contrauno.equals(contrados) && compruebaUsuario() == false && comprubeaEmail() == true) {
					setVisible(false);

					mantenimiento.setVisible(true);
					nuevoUsuario(txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(), contrauno);

				} else if (compruebaUsuario() == true) {

					JOptionPane.showMessageDialog(panel, "El usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!contrauno.equals(contrados)) {
					JOptionPane.showMessageDialog(panel, "Las contraseñas no coinciden.", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else if (comprubeaEmail() == false) {
					JOptionPane.showMessageDialog(panel, "El Email no tinene una estructura correcta.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnregistrar.setEnabled(false);

		txtpass = new JPasswordField();
		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlregistrar();
			}
		});
		txtpass2 = new JPasswordField();
		txtpass2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlregistrar();
			}
		});
		txt1 = new JTextField();
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlregistrar();
			}
		});
		txt1.setColumns(10);
		txt2 = new JTextField();
		txt2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlregistrar();
			}
		});
		txt2.setColumns(10);
		txt3 = new JTextField();
		txt3.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				controlregistrar();
			}
		});
		txt3.setColumns(10);
		txt4 = new JTextField();
		txt4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlregistrar();

			}
		});
		txt4.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup()
						.addGroup(
								groupLayout
										.createParallelGroup(
												Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup().addGap(28)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblNick).addComponent(lblRepetircontrasena)
														.addComponent(lblEmail).addComponent(lblApellidos)
														.addComponent(lblNombre).addComponent(lblContrasena))
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(txtpass, GroupLayout.DEFAULT_SIZE, 107,
																Short.MAX_VALUE)
														.addComponent(txtpass2, GroupLayout.DEFAULT_SIZE, 107,
																Short.MAX_VALUE)
														.addComponent(txt4, GroupLayout.DEFAULT_SIZE, 107,
																Short.MAX_VALUE)
														.addComponent(txt3, GroupLayout.DEFAULT_SIZE, 107,
																Short.MAX_VALUE)
														.addComponent(txt2, GroupLayout.DEFAULT_SIZE, 107,
																Short.MAX_VALUE)
														.addComponent(txt1, GroupLayout.DEFAULT_SIZE, 107,
																Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup().addGap(20)
												.addComponent(btnCnacelar, GroupLayout.DEFAULT_SIZE, 108,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
														btnregistrar, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
						.addGap(102)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(48)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNick).addComponent(txt1,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNombre).addComponent(txt2,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblApellidos).addComponent(
						txt3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail).addComponent(txt4,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasena)
						.addComponent(txtpass, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblRepetircontrasena)
						.addComponent(txtpass2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnCnacelar)
						.addComponent(btnregistrar))
				.addContainerGap(113, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 476, 404);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void nuevoUsuario(String Nick, String Nombre, String Apellido, String Email, String Password) {

		Conexion con = new Conexion();

		int numero = con.numeroUsuarios("SELECT * FROM DBMA.usuarios");
		numero = numero + 1;

		con.insertInto("INSERT INTO DBMA.usuarios (Cod_usuario, Nick, Nombre, Apellidos, Email, Password) VALUES ('" + numero
				+ "','" + Nick + "','" + Nombre + "','" + Apellido + "','" + Email + "','" + Password + "')");

	}

	public boolean compruebaUsuario() {
																	
		String usuario = txt1.getText();
		Conexion con = new Conexion();
		String nickDb = con.getNick("select * from  DBMA.usuarios where nick='" + usuario + "'");

		try {
			if (nickDb.equals(usuario)) {
				return true;

			} else {

			}
		} catch (Exception e) {
			return false;
		}

		return false;

	}

	public boolean comprubeaEmail() {
		String email = txt4.getText();
		int contadorE = 0;
		boolean finalE = false;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@' || email.charAt(i) == '.') {
				contadorE++;
			}
		}
		if (contadorE >= 2) {
			finalE = true;
		}

		return finalE;
	}
}
