package presentacion.vista;

import javax.swing.JFrame;
import dto.ConfiguracionDTO;
import presentacion.controlador.ControladorConfiguracion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class VistaConfiguracion extends JDialog {
	private static VistaConfiguracion instancia;
	private JTextField txtUrlServer;
	private JTextField txtPuerto;
	private JTextField txtNombreBD;
	private JTextField txtNombreUsuario;
	private JTextField txtPasswordUsuario;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JPanel contentPane;

	private VistaConfiguracion() {
		super();
		setModal(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 230);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblUrlServidor = new JLabel("URL servidor");
		lblUrlServidor.setBounds(29, 9, 61, 14);
		getContentPane().add(lblUrlServidor);

		txtUrlServer = new JTextField();
		txtUrlServer.setBounds(96, 6, 207, 20);
		getContentPane().add(txtUrlServer);
		txtUrlServer.setColumns(10);

		JLabel lblPuertoServidor = new JLabel("Puerto servidor");
		lblPuertoServidor.setBounds(16, 35, 74, 14);
		getContentPane().add(lblPuertoServidor);

		txtPuerto = new JTextField();
		txtPuerto.setBounds(96, 32, 207, 20);
		getContentPane().add(txtPuerto);
		txtPuerto.setColumns(10);

		JLabel lblNombreBd = new JLabel("Nombre bd");
		lblNombreBd.setBounds(38, 61, 52, 14);
		getContentPane().add(lblNombreBd);

		txtNombreBD = new JTextField();
		txtNombreBD.setBounds(96, 58, 207, 20);
		getContentPane().add(txtNombreBD);
		txtNombreBD.setColumns(10);

		JLabel lblNombreUsuario = new JLabel("Nombre usuario");
		lblNombreUsuario.setBounds(15, 87, 75, 14);
		getContentPane().add(lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(96, 84, 207, 20);
		getContentPane().add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		JLabel lblPasswordUsuario = new JLabel("Password usuario");
		lblPasswordUsuario.setBounds(6, 113, 84, 14);
		getContentPane().add(lblPasswordUsuario);

		txtPasswordUsuario = new JTextField();
		txtPasswordUsuario.setBounds(96, 110, 207, 20);
		getContentPane().add(txtPasswordUsuario);
		txtPasswordUsuario.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(96, 141, 74, 23);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(180, 141, 75, 23);
		getContentPane().add(btnCancelar);
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public static VistaConfiguracion getIntance() {
		if (instancia == null)
			instancia = new VistaConfiguracion();
		return instancia;
	}

	public ConfiguracionDTO getConfiguracion() {
		ConfiguracionDTO configuracion = new ConfiguracionDTO(txtUrlServer.getText(), txtPuerto.getText(),
				txtNombreBD.getText(), txtNombreUsuario.getText(), txtPasswordUsuario.getText());
		return configuracion;
	}

	public void mostrarVentana() {
		this.setVisible(true);
	}
}
