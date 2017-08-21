package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.LocalidadDTO;
import dto.TipoDeContactoDTO;
import modelo.Agenda;
import presentacion.vista.VistaLocalidades;
import presentacion.vista.VistaTiposDeContacto;

public class ControladorGestionDeTiposContacto implements ActionListener {
	
	private static ControladorGestionDeTiposContacto controlador=null;
	private Agenda agenda;
	private VistaTiposDeContacto vistaTipoDeContacto;
	private List<TipoDeContactoDTO>tiposDeContactoEnTabla;

	private ControladorGestionDeTiposContacto() {// TODO hacer singleton de agenda/modelo.
		this.agenda = new Agenda();
		this.vistaTipoDeContacto= new VistaTiposDeContacto();
		this.vistaTipoDeContacto.getBtnAgregar().addActionListener(this);
		this.vistaTipoDeContacto.getBtnEditar().addActionListener(this);
		this.vistaTipoDeContacto.getBtnEliminar().addActionListener(this);
	}

	public static ControladorGestionDeTiposContacto getInstance() {
		if(controlador==null)
			controlador=new ControladorGestionDeTiposContacto();
		return controlador;
	}

	public void abrirVentana() {
		vistaTipoDeContacto.mostrar();
		inicializar();
	}
	
	public void inicializar() {
		updateTabla();
	}
	
	private void updateTabla() {
		this.vistaTipoDeContacto.getModelTipoDeContacto().setRowCount(0); // Para vaciar la tabla
		this.vistaTipoDeContacto.getModelTipoDeContacto().setColumnCount(0);
		this.vistaTipoDeContacto.getModelTipoDeContacto().setColumnIdentifiers(this.vistaTipoDeContacto.getNombreColumnas());

		this.tiposDeContactoEnTabla = agenda.getTiposDeContacto();
		tiposDeContactoEnTabla.forEach(this::añadirTipoDeContacto);

		vistaTipoDeContacto.mostrar();
	}
	
	private void añadirTipoDeContacto(TipoDeContactoDTO tipoDeContactoDTO) {
		Object[] fila = { tipoDeContactoDTO.getNombre()};
		vistaTipoDeContacto.getModelTipoDeContacto().addRow(fila);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vistaTipoDeContacto.getBtnAgregar()) {
			String nombre=JOptionPane.showInputDialog("Ingrese el nombre de la localidad que desea ingresar ");
			this.agenda.agregarTipoDeContacto(new TipoDeContactoDTO(nombre));
			updateTabla();
		} else if(e.getSource() == vistaTipoDeContacto.getBtnEditar()) {
			int indexFilaSeleccionada = vistaTipoDeContacto.getTablaTipoDeContacto().getSelectedRow();
			if(indexFilaSeleccionada != -1) {
				String nombre=JOptionPane.showInputDialog("Ingrese el nuevo nombre ");
				this.agenda.modificarTipoDeContacto(new TipoDeContactoDTO(tiposDeContactoEnTabla.get(indexFilaSeleccionada).getId(), nombre));
				updateTabla();
			}
			
		} else if(e.getSource() == vistaTipoDeContacto.getBtnEliminar()) {
			int indexFilaSeleccionada = vistaTipoDeContacto.getTablaTipoDeContacto().getSelectedRow();
			if(indexFilaSeleccionada != -1) {
				this.agenda.borrarTipoDeContacto(new TipoDeContactoDTO(tiposDeContactoEnTabla.get(indexFilaSeleccionada).getId()));
				updateTabla();
			}
		}
		
	}

}
