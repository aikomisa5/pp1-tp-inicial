package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.LocalidadDTO;
import modelo.Agenda;
import presentacion.vista.VistaLocalidades;
import presentacion.vista.VistaTiposDeContacto;

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
		vistaLocalidades.mostrar();
		inicializar();
	}
	
	public void inicializar() {
		updateTabla();
	}
	
	private void updateTabla() {
		this.vistaLocalidades.getModelLocalidades().setRowCount(0); // Para vaciar la tabla
		this.vistaLocalidades.getModelLocalidades().setColumnCount(0);
		this.vistaLocalidades.getModelLocalidades().setColumnIdentifiers(this.vistaLocalidades.getNombreColumnas());

		this.localidadesEnTabla = agenda.getLocalidades();
		localidadesEnTabla.forEach(this::añadirLocalidadATabla);

		vistaLocalidades.mostrar();
	}
	
	private void añadirLocalidadATabla(LocalidadDTO localidad) {
		Object[] fila = { localidad.getNombre()};
		vistaLocalidades.getModelLocalidades().addRow(fila);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vistaLocalidades.getBtnAgregar()) {
			String nombre=JOptionPane.showInputDialog("Ingrese el nombre de la localidad que desea ingresar ");
			this.agenda.agregarLocalidad(new LocalidadDTO(nombre));
			updateTabla();
		} else if(e.getSource() == vistaLocalidades.getBtnEditar()) {
			int indexFilaSeleccionada = vistaLocalidades.getTablaLocalidades().getSelectedRow();
			if(indexFilaSeleccionada != -1) {
				String nombre=JOptionPane.showInputDialog("Ingrese el nuevo nombre ");
				this.agenda.modificarLocalidad(new LocalidadDTO(localidadesEnTabla.get(indexFilaSeleccionada).getId(), nombre));
				updateTabla();
			}
			
		} else if(e.getSource() == vistaLocalidades.getBtnEliminar()) {
			int indexFilaSeleccionada = vistaLocalidades.getTablaLocalidades().getSelectedRow();
			if(indexFilaSeleccionada != -1) {
				this.agenda.borrarLocalidad(new LocalidadDTO(localidadesEnTabla.get(indexFilaSeleccionada).getId()));
				updateTabla();
			}
		}
		
	}
	
	

}