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
import javax.swing.SwingConstants;

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
	private JButton btnProbarConexion;

	private VistaConfiguracion() {
		super();
		setUndecorated(true);
		setTitle("Configuraci\u00F3n de conexi\u00F3n");
		setModal(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}		
		
		setResizable(false);
		setBounds(100, 100, 476, 318);
			
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblUrlServidor = new JLabel("URL servidor");
		lblUrlServidor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUrlServidor.setBounds(20, 64, 131, 26);
		getContentPane().add(lblUrlServidor);

		txtUrlServer = new JTextField();
		txtUrlServer.setBounds(166, 64, 295, 26);
		getContentPane().add(txtUrlServer);
		txtUrlServer.setColumns(10);

		JLabel lblPuertoServidor = new JLabel("Puerto servidor");
		lblPuertoServidor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuertoServidor.setBounds(20, 100, 131, 26);
		getContentPane().add(lblPuertoServidor);

		txtPuerto = new JTextField();
		txtPuerto.setBounds(166, 100, 295, 26);
		getContentPane().add(txtPuerto);
		txtPuerto.setColumns(10);

		JLabel lblNombreBd = new JLabel("Nombre bd");
		lblNombreBd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreBd.setBounds(20, 136, 131, 26);
		getContentPane().add(lblNombreBd);

		txtNombreBD = new JTextField();
		txtNombreBD.setBounds(166, 136, 295, 26);
		getContentPane().add(txtNombreBD);
		txtNombreBD.setColumns(10);

		JLabel lblNombreUsuario = new JLabel("Nombre usuario");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreUsuario.setBounds(20, 172, 131, 26);
		getContentPane().add(lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(166, 172, 295, 26);
		getContentPane().add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		JLabel lblPasswordUsuario = new JLabel("Password usuario");
		lblPasswordUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordUsuario.setBounds(20, 208, 131, 26);
		getContentPane().add(lblPasswordUsuario);

		txtPasswordUsuario = new JTextField();
		txtPasswordUsuario.setBounds(166, 208, 295, 26);
		getContentPane().add(txtPasswordUsuario);
		txtPasswordUsuario.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(195, 261, 121, 42);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(331, 261, 130, 42);
		getContentPane().add(btnCancelar);

		btnProbarConexion = new JButton("Probar Conexi\u00F3n");
		btnProbarConexion.setBounds(20, 261, 160, 42);
		contentPane.add(btnProbarConexion);

		JLabel lblConfiguracinDeConexin = new JLabel("Configuraci\u00F3n de Conexi\u00F3n a base de datos");
		lblConfiguracinDeConexin.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguracinDeConexin.setBounds(10, 11, 451, 37);
		contentPane.add(lblConfiguracinDeConexin);
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnProbarConexion() {
		return btnProbarConexion;
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
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void setConfiguracion(ConfiguracionDTO configuracion) {
		txtNombreBD.setText(configuracion.getBdNombre());
		txtNombreUsuario.setText(configuracion.getUserName());
		txtPasswordUsuario.setText(configuracion.getUserPass());
		txtPuerto.setText(configuracion.getServerPuerto());
		txtUrlServer.setText(configuracion.getServerUrl());

	}
}
