package Main;

import Controlador.Controlador;
import Modelo.Conexion;
import Vista.*;

public class Main {

	public static void main(String[] args) {

		// co nfiguracion configuracion = new configuracion();
		// Conexion conn = null;
		Conexion conn = new Conexion();
		Controlador controlador = new Controlador();
		Mantenimiento mantenimiento = new Mantenimiento();
		Principal principal = new Principal();
		Registro registro = new Registro();
 
		Bienvenida bienvenida = new Bienvenida();
		ini ini = new ini();

		conn.setmantenimiento(mantenimiento);
		controlador.setconexionymantenimiento(conn, mantenimiento);

		// desde singin se accede a principal y al material
		principal.setconexionymantenimientoyregistroyiniycontrolador(conn, mantenimiento, registro, ini, controlador);
		// desde registro se accede a principal y al mantenimiento
		registro.setprincipalymantenimiento(principal, mantenimiento);
		// desde el material se accede al principal, a la nueva propiedad, a la
		// nuevo formato y nuevo material.
		mantenimiento.settodo(principal , conn, controlador);
		bienvenida.setprincipal(principal);
		// desde la pagina nueva propiedad se accede a mantenimiento

		ini.setprincipal(principal);
		// mantenimiento.setVisible(true);
		bienvenida.setVisible(true);

	}

}