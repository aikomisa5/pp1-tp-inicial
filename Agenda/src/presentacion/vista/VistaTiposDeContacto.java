package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class VistaTiposDeContacto extends JFrame {

	private JPanel panel;
	private JTable tablaTiposDeContacto;
	private String[] nombreColumnas = { "Etiqueta" };
	private DefaultTableModel modelTiposDeContacto;
	JButton btnAgregar = new JButton("Agregar");
	JButton btnEditar = new JButton("Editar");
	JButton btnEliminar = new JButton("Eliminar");

	public VistaTiposDeContacto() {
		initialize();
	}

	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		this.setBounds(100, 100, 497, 324);
		

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(15, 16, 446, 180);
		panel.add(spLocalidades);

		modelTiposDeContacto = new DefaultTableModel(null, nombreColumnas) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaTiposDeContacto = new JTable(modelTiposDeContacto);
		tablaTiposDeContacto.setBounds(503, 312, -376, -257);

		spLocalidades.setViewportView(tablaTiposDeContacto);

		btnAgregar.setBounds(81, 212, 91, 42);
		panel.add(btnAgregar);

		btnEditar.setBounds(187, 212, 91, 42);
		panel.add(btnEditar);

		btnEliminar.setBounds(293, 212, 91, 42);
		panel.add(btnEliminar);

	}

	public JPanel getPanel() {
		return panel;
	}

	public JTable getTablaTipoDeContacto() {
		return tablaTiposDeContacto;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public DefaultTableModel getModelTipoDeContacto() {
		return modelTiposDeContacto;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void mostrar() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
