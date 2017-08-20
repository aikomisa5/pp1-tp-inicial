package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;
import java.awt.Color;
import javax.swing.JComboBox;

public class VentanaPersona extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfTelefono;
	private JButton btnAgregarPersona;
	private Controlador controlador;
	private JTextField tfCalle;
	private JTextField tfAltura;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JTextField tfLocalidad;
	private JTextField tfEmail;
	private JTextField tfFechaNac;

	public VentanaPersona(Controlador controlador) {
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 558);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 498);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);

		tfNombre = new JTextField();
		tfNombre.setBounds(133, 8, 164, 20);
		panel.add(tfNombre);
		tfNombre.setColumns(10);

		tfTelefono = new JTextField();
		tfTelefono.setBounds(133, 49, 164, 20);
		panel.add(tfTelefono);
		tfTelefono.setColumns(10);

		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(208, 451, 89, 23);
		panel.add(btnAgregarPersona);

		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		tfCalle.setBounds(133, 95, 164, 20);
		panel.add(tfCalle);

		tfAltura = new JTextField();
		tfAltura.setColumns(10);
		tfAltura.setBounds(133, 140, 164, 20);
		panel.add(tfAltura);

		tfPiso = new JTextField();
		tfPiso.setColumns(10);
		tfPiso.setBounds(133, 185, 164, 20);
		panel.add(tfPiso);

		tfDepto = new JTextField();
		tfDepto.setColumns(10);
		tfDepto.setBounds(133, 227, 164, 20);
		panel.add(tfDepto);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 98, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 143, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 188, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(10, 230, 113, 14);
		panel.add(lblDepartamento);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 267, 113, 14);
		panel.add(lblLocalidad);

		tfLocalidad = new JTextField();
		tfLocalidad.setColumns(10);
		tfLocalidad.setBounds(133, 264, 164, 20);
		panel.add(tfLocalidad);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(133, 307, 164, 20);
		panel.add(tfEmail);

		tfFechaNac = new JTextField();
		tfFechaNac.setColumns(10);
		tfFechaNac.setBounds(133, 345, 164, 20);
		panel.add(tfFechaNac);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 310, 113, 14);
		panel.add(lblEmail);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(10, 348, 113, 14);
		panel.add(lblFechaDeNacimiento);

		JLabel label_2 = new JLabel("Localidad");
		label_2.setBounds(10, 381, 113, 14);
		panel.add(label_2);

		JComboBox comboLocalidad = new JComboBox();
		comboLocalidad.setBounds(133, 376, 164, 20);
		panel.add(comboLocalidad);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 410, 113, 14);
		panel.add(lblTipoDeContacto);

		JComboBox comboTipoDeContacto = new JComboBox();
		comboTipoDeContacto.setBounds(133, 407, 164, 20);
		panel.add(comboTipoDeContacto);

		this.setVisible(true);
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public JTextField getTfTelefono() {
		return tfTelefono;
	}

	public void setTfTelefono(JTextField tfTelefono) {
		this.tfTelefono = tfTelefono;
	}

	public JTextField getTfCalle() {
		return tfCalle;
	}

	public void setTfCalle(JTextField tfCalle) {
		this.tfCalle = tfCalle;
	}

	public JTextField getTfAltura() {
		return tfAltura;
	}

	public void setTfAltura(JTextField tfAltura) {
		this.tfAltura = tfAltura;
	}

	public JTextField getTfPiso() {
		return tfPiso;
	}

	public void setTfPiso(JTextField tfPiso) {
		this.tfPiso = tfPiso;
	}

	public JTextField getTfDepto() {
		return tfDepto;
	}

	public void setTfDepto(JTextField tfDepto) {
		this.tfDepto = tfDepto;
	}

	public JTextField getTfLocalidad() {
		return tfLocalidad;
	}

	public void setTfLocalidad(JTextField tfLocalidad) {
		this.tfLocalidad = tfLocalidad;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JTextField getTfFechaNac() {
		return tfFechaNac;
	}

	public void setTfFechaNac(JTextField tfFechaNac) {
		this.tfFechaNac = tfFechaNac;
	}

	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}
}
