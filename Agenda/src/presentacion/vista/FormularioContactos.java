
package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;
import presentacion.controlador.ControladorContactos;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class FormularioContactos extends JFrame {

	private PersonaDTO persona = null;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnGuardarPersona;
	private ControladorContactos controlador;
	private JTextField tfNombre;
	private JTextField tfTelefono;
	private JTextField tfCalle;
	private JTextField tfAltura;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JTextField tfEmail;
	private JXDatePicker datePicker;
	private JComboBox<LocalidadDTO> comboLocalidad;
	private JComboBox<TipoDeContactoDTO> comboTipoDeContacto;

	private List<LocalidadDTO> localidades = null;
	private List<TipoDeContactoDTO> tiposDeContacto = null;

	private JPanel panel;

	public FormularioContactos(ControladorContactos controlador) {
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 503);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 449, 422);
		contentPane.add(panel);
		panel.setLayout(null);

		datePicker = new JXDatePicker();
		datePicker.setBounds(193, 266, 235, 26);
		datePicker.setVisible(true);
		panel.add(datePicker);

		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreYApellido.setBounds(15, 14, 163, 26);
		panel.add(lblNombreYApellido);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelfono.setBounds(15, 50, 163, 26);
		panel.add(lblTelfono);

		tfNombre = new JTextField();
		tfNombre.setBounds(193, 14, 235, 26);
		panel.add(tfNombre);
		tfNombre.setColumns(10);

		tfTelefono = new JTextField();
		tfTelefono.setBounds(193, 50, 235, 26);
		panel.add(tfTelefono);
		tfTelefono.setColumns(10);

		btnGuardarPersona = new JButton("Guardar");
		btnGuardarPersona.addActionListener(this.controlador);
		btnGuardarPersona.setBounds(339, 364, 89, 42);
		panel.add(btnGuardarPersona);

		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		tfCalle.setBounds(193, 86, 235, 26);
		panel.add(tfCalle);

		tfAltura = new JTextField();
		tfAltura.setColumns(10);
		tfAltura.setBounds(193, 122, 235, 26);
		panel.add(tfAltura);

		tfPiso = new JTextField();
		tfPiso.setColumns(10);
		tfPiso.setBounds(193, 158, 235, 26);
		panel.add(tfPiso);

		tfDepto = new JTextField();
		tfDepto.setColumns(10);
		tfDepto.setBounds(193, 194, 235, 26);
		panel.add(tfDepto);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCalle.setBounds(15, 86, 163, 26);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAltura.setBounds(15, 122, 163, 26);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPiso.setBounds(15, 158, 163, 26);
		panel.add(lblPiso);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setBounds(15, 194, 163, 26);
		panel.add(lblDepartamento);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(193, 230, 235, 26);
		panel.add(tfEmail);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(15, 230, 163, 26);
		panel.add(lblEmail);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFechaDeNacimiento.setBounds(15, 266, 163, 26);
		panel.add(lblFechaDeNacimiento);

		JLabel label_2 = new JLabel("Localidad");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setBounds(15, 302, 163, 26);
		panel.add(label_2);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipoDeContacto.setBounds(15, 338, 163, 26);
		panel.add(lblTipoDeContacto);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JComboBox<LocalidadDTO> getComboLocalidad() {
		return comboLocalidad;
	}

	public JComboBox<TipoDeContactoDTO> getComboTipoDeContacto() {
		return comboTipoDeContacto;
	}

	public JXDatePicker getDatePicker() {
		return datePicker;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public JTextField getTfTelefono() {
		return tfTelefono;
	}

	public JTextField getTfCalle() {
		return tfCalle;
	}

	public JTextField getTfAltura() {
		return tfAltura;
	}

	public JTextField getTfPiso() {
		return tfPiso;
	}

	public JTextField getTfDepto() {
		return tfDepto;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public JButton getBtnGuardarPersona() {
		return btnGuardarPersona;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	public void cargarDatosEnDTO() {
		if (persona == null)
			persona = new PersonaDTO(0);

		persona.setDomicilio(new DomicilioDTO(tfCalle.getText(), Integer.parseInt(tfAltura.getText()),
				Integer.parseInt(tfPiso.getText()), tfDepto.getText(), getLocalidadSeleccionada()));

		java.util.Date date = datePicker.getDate();
		LocalDate ldate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		persona.setFechaCumpleaños(java.sql.Date.valueOf(ldate));
		persona.setMail(tfEmail.getText());
		persona.setNombre(tfNombre.getText());
		persona.setTelefono(tfTelefono.getText());
		persona.setTipoDeContacto(getTipoDeContactoSeleccionado());
	}

	private LocalidadDTO getLocalidadSeleccionada() {
		LocalidadDTO localidadSeleccionada = comboLocalidad.getItemAt(comboLocalidad.getSelectedIndex());
		return localidadSeleccionada;
	}

	private TipoDeContactoDTO getTipoDeContactoSeleccionado() {
		TipoDeContactoDTO tipoDeContactoSeleccionado = (TipoDeContactoDTO) comboTipoDeContacto.getSelectedItem();
		return tipoDeContactoSeleccionado;
	}

	public void setLocalidades(List<LocalidadDTO> localidades) {
		this.localidades = localidades;
	}

	public void setTiposDeContacto(List<TipoDeContactoDTO> tiposDeContacto) {
		this.tiposDeContacto = tiposDeContacto;
	}

	public void cargarCombos() {

		comboLocalidad = new JComboBox<>();
		localidades.forEach(l -> comboLocalidad.addItem(l));
		comboLocalidad.setBounds(193, 299, 235, 26);
		panel.add(comboLocalidad);

		comboTipoDeContacto = new JComboBox<>();
		tiposDeContacto.forEach(t -> comboTipoDeContacto.addItem(t));
		comboTipoDeContacto.setBounds(193, 335, 235, 26);
		panel.add(comboTipoDeContacto);
	}

	public void resetCombos() {
		comboLocalidad.setSelectedItem(localidades.get(0));
		comboTipoDeContacto.setSelectedItem(localidades.get(0));
	}

	public void setCombos() {
		comboLocalidad.setSelectedIndex(getIndexLocalidad(persona.getDomicilio().getLocalidad()));
		comboTipoDeContacto.setSelectedIndex(getIndexTipoDeContacto(persona.getTipoDeContacto()));
	}

	private int getIndexLocalidad(LocalidadDTO localidad) {
		int index = 0;
		boolean encontrado = false;
		for (int i = 0; !encontrado && i < localidades.size(); i++) {
			if (localidad.equals(localidades.get(i))) {
				encontrado = true;
				index = i;
			}
		}
		return index;
	}
	
	private int getIndexTipoDeContacto(TipoDeContactoDTO contacto) {
		int index = 0;
		boolean encontrado = false;
		for (int i = 0; !encontrado && i < tiposDeContacto.size(); i++) {
			if (contacto.equals(tiposDeContacto.get(i))) {
				encontrado = true;
				index = i;
			}
		}
		return index;
	}


}
