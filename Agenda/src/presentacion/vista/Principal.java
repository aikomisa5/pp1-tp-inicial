package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;

public class Principal {
	private JFrame frmAgendaGrupo;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	private JButton btnReporte;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = { "Nombre y apellido", "Tel�fono", "Calle", "Altura", "Piso", "Depto",
			"Localidad", "Mail", "FechaNac", "TipoContacto" };
	private JButton btnGestionDeTipos;
	private JButton btnGestionLocalidades;
	private JButton btnEditarConexion;

	public Principal() {
		super();
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		frmAgendaGrupo = new JFrame();
		frmAgendaGrupo.setTitle("Agenda - Grupo 2");
		frmAgendaGrupo.setResizable(false);
		frmAgendaGrupo.setBounds(100, 100, 1340, 425);
		frmAgendaGrupo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgendaGrupo.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1334, 385);
		frmAgendaGrupo.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 1309, 300);
		panel.add(spPersonas);

		modelPersonas = new DefaultTableModel(null, nombreColumnas) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaPersonas = new JTable(modelPersonas);

		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);

		spPersonas.setViewportView(tablaPersonas);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(15, 327, 89, 42);
		panel.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(114, 327, 89, 42);
		panel.add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(213, 327, 89, 42);
		panel.add(btnBorrar);

		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(312, 327, 89, 42);
		panel.add(btnReporte);

		btnGestionLocalidades = new JButton("Gesti\u00F3n de Localidades");
		btnGestionLocalidades.setBounds(477, 327, 281, 42);
		panel.add(btnGestionLocalidades);

		btnGestionDeTipos = new JButton("Gesti\u00F3n de Tipos de Contacto");
		btnGestionDeTipos.setBounds(773, 327, 272, 42);
		panel.add(btnGestionDeTipos);
		
		btnEditarConexion = new JButton("Editar conexi\u00F3n");
		btnEditarConexion.setBounds(1127, 327, 192, 42);
		panel.add(btnEditarConexion);
	}

	public void show() {
		this.frmAgendaGrupo.setLocationRelativeTo(null);
		this.frmAgendaGrupo.setVisible(true);
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnReporte() {
		return btnReporte;
	}

	public JButton getBtnGestionDeTipos() {
		return btnGestionDeTipos;
	}

	public JButton getBtnGestionLocalidades() {
		return btnGestionLocalidades;
	}

	public JButton getBtnEditarConexion() {
		return btnEditarConexion;
	}

	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public JTable getTablaPersonas() {
		return tablaPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}
}
