package presentacion.vista;

import javax.swing.JFrame;

public class VistaConfiguracion  extends JFrame  {
	private static VistaConfiguracion instancia;
	
	private VistaConfiguracion() {
		super();
	}
	

	public static VistaConfiguracion getIntance() {
		if (instancia == null)
			instancia = new VistaConfiguracion();
		return instancia;
	}


	public void mostrarVentana() {
		// TODO Auto-generated method stub
		
	}
	
	//TODO

}
