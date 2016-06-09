package Vista;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bienvenida extends JFrame {

	private Principal principal;

	public void setprincipal(Principal principal) {
		this.principal = principal;
	}

	public Bienvenida() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				principal.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(Bienvenida.class.getResource("/imagenes/inicio.jpg")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel,
				GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel,
				GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE));
		getContentPane().setLayout(groupLayout);

		setBounds(100, 100, 760, 422);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
