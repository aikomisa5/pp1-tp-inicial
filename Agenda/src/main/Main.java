package main;

import modelo.Agenda;
import presentacion.controlador.ControladorConfiguracion;
import presentacion.controlador.ControladorPrincipal;
import presentacion.vista.Principal;


public class Main 
{

	public static void main(String[] args) 
	{
		ControladorConfiguracion controladorConfig= ControladorConfiguracion.getInstance();
		controladorConfig.inicializar();
		Principal vista = new Principal();
		Agenda modelo = Agenda.getInstance();
		ControladorPrincipal controlador = new ControladorPrincipal(vista, modelo);
		controlador.inicializar();
	}
}
