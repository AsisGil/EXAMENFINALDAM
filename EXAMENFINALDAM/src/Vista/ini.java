package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo.Conexion;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class ini extends JFrame {

	private JPanel contentPane;
	private Principal principal;
	private JTextField txtusuario;
	private JTextField txtcontrasena;
	private JTextField txturl;
	private Controlador controlador;
	private Conexion conexion;

	public ini() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");

		txtusuario = new JTextField();
		txtusuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");

		txtcontrasena = new JTextField();
		txtcontrasena.setColumns(10);

		JLabel lblUrl = new JLabel("URL:");

		txturl = new JTextField();
		txturl.setColumns(10);

		JButton btnNewButton = new JButton("Establecer Configuracion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				// controlador.establecerini();
				valoresini();

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(47)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombreDeUsuario)
										.addComponent(lblContrasea).addComponent(lblUrl))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txturl).addComponent(txtcontrasena).addComponent(txtusuario,
												GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
				.addContainerGap(126, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(43)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreDeUsuario).addComponent(txtusuario, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasea)
								.addComponent(txtcontrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblUrl)
								.addComponent(txturl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE).addComponent(btnNewButton)
						.addGap(37)));
		contentPane.setLayout(gl_contentPane);
	}

	public void setprincipal(Principal principal) {
		this.principal = principal;
	}

	public void cargaContenidoDeFichero() {


		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				
				propiedades.load(entrada);
			
				txtusuario.setText(propiedades.getProperty("usuario"));
				txtcontrasena.setText(propiedades.getProperty("clave"));
				txturl.setText(propiedades.getProperty("url"));
				
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void valoresini() {

		String url = txturl.getText();
		String usuario = txtusuario.getText();
		String clave = txtcontrasena.getText();

		FileOutputStream miFichero = null;
		String Configuracion = "[Propieties]" + "\n" + " url = " + url + "\n" + " usuario = " + usuario + "\n"
				+ " clave = " + clave;
		byte[] config = Configuracion.getBytes();
		try {
			miFichero = new FileOutputStream("configuracion.ini");
			for (int i = 0; i < config.length; i++) {
				try {
					miFichero.write(config[i]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error en byte" + config[i]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("fichero");
		}

	}

}