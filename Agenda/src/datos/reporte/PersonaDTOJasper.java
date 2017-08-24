package datos.reporte;

import java.sql.Date;

import dto.DomicilioDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

public class PersonaDTOJasper extends PersonaDTO{

	SignoZodiaco signo;

	
	public PersonaDTOJasper(String nombre, String telefono, String mail, Date fechaCumpleaños,
			TipoDeContactoDTO tipoDeContacto, DomicilioDTO domicilio, SignoZodiaco SignoZodiaco) {
		super(nombre, telefono, mail, fechaCumpleaños, tipoDeContacto, domicilio);
		// TODO Auto-generated constructor stub
	}
	
	public SignoZodiaco getSigno() {
			return signo;
	}

	public void setSigno(SignoZodiaco signo) {
			this.signo = signo;
	}



}
