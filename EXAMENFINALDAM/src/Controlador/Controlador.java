package Controlador;

import Modelo.Conexion;
import Vista.Mantenimiento;

public class Controlador {
	private Conexion conexion;
	private Mantenimiento mantenimiento;

	public void setconexionymantenimiento(Conexion conexion, Mantenimiento mantenimiento) {
		this.conexion = conexion;
		this.mantenimiento = mantenimiento;
	}

	public void cargarMateriales() {
		conexion.consultaMateriales();
	}

	public void establecerini() {
		conexion.establecerini();
	}

	public void comprobacion(String text, String contra) {
		conexion.comprobacion(text, contra);
	 

	}
}