package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.LoaderConfiguracion;
import presentacion.vista.VistaConfiguracion;

public class ControladorConfiguracion implements ActionListener {

	private static ControladorConfiguracion instancia;
	private LoaderConfiguracion loaderConfiguracion;
	private VistaConfiguracion vistaConfiguracion;

	private ControladorConfiguracion() {
		loaderConfiguracion = LoaderConfiguracion.getInstance();
		vistaConfiguracion = VistaConfiguracion.getIntance();
	}

	public static ControladorConfiguracion getInstance() {
		if (instancia == null)
			instancia = new ControladorConfiguracion();
		return instancia;
	}
	
	public void inicializar() {
		if (loaderConfiguracion.cargarConfiguracion()) {
			if(loaderConfiguracion.probarConexion() ==  false) {
				JOptionPane.showMessageDialog(null, "Error, los datos de conexión no son válidos.");
				vistaConfiguracion.mostrarVentana();
			}				
		}else if(loaderConfiguracion.crearConfiguracionPorDefecto()) {
			inicializar();
			}
		else {
			JOptionPane.showMessageDialog(null, "Error, No se pudo cargar la configuración por defecto");
			vistaConfiguracion.mostrarVentana();			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
