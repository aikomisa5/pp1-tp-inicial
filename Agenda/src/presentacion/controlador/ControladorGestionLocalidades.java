package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.LocalidadDTO;
import modelo.Agenda;
import presentacion.vista.VistaLocalidades;

public class ControladorGestionLocalidades implements ActionListener {
	
	private static ControladorGestionLocalidades controlador=null;
	private Agenda agenda;
	private VistaLocalidades vistaLocalidades;
	private List<LocalidadDTO>localidadesEnTabla;

	private ControladorGestionLocalidades() {// TODO hacer singleton de agenda/modelo.
		this.agenda = new Agenda();
		this.vistaLocalidades= new VistaLocalidades();
		this.vistaLocalidades.getBtnAgregar().addActionListener(this);
		this.vistaLocalidades.getBtnEditar().addActionListener(this);
		this.vistaLocalidades.getBtnEliminar().addActionListener(this);
	}

	public static ControladorGestionLocalidades getInstance() {
		if(controlador==null)
			controlador=new ControladorGestionLocalidades();
		return controlador;
	}

	public void abrirVentana() {
		vistaLocalidades.setVisible(true);
	}
	
	private void updateTabla() {
		this.vistaLocalidades.getModelLocalidades().setRowCount(0); // Para vaciar la tabla
		this.vistaLocalidades.getModelLocalidades().setColumnCount(0);
		this.vistaLocalidades.getModelLocalidades().setColumnIdentifiers(this.vistaLocalidades.getNombreColumnas());

		this.localidadesEnTabla = agenda.getLocalidades();
		localidadesEnTabla.forEach(this::añadirLocalidadATabla);

		this.vistaLocalidades.show();
	}
	
	private void añadirLocalidadATabla(LocalidadDTO localidad) {
		Object[] fila = { localidad.getNombre()};
		vistaLocalidades.getModelLocalidades().addRow(fila);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}