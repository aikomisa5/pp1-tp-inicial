package dto;

import java.sql.Date;

public class PersonaJasperDTO extends PersonaDTO {
	
	Signo signo=null;
	
	//Se puede hacer con herencia o tambien utilizando composicion (creando este objeto con variables
	//persona y signo
	public PersonaJasperDTO(String nombre, String telefono, String mail, Date fechaCumpleaños,
			TipoDeContactoDTO tipoDeContacto, DomicilioDTO domicilio) {
		///usamos el constructor de PersonaDTO
		super(nombre, telefono, mail, fechaCumpleaños, tipoDeContacto, domicilio);
		//Usamos el metodo para calcular su signo
		signo = calcularSigno(this.getFechaCumpleaños());
	}
	
	public static Signo calcularSigno(Date fechaNacimiento) {
		//TODO hardcodear y poner todos los casos
		Signo ret=null;
		//Tener en cuenta los bordes (CompareTo == 0)
		if(fechaNacimiento.compareTo(Date.valueOf("06-02-1993"))== -1 
				&& fechaNacimiento.compareTo(Date.valueOf("06-01-1993")) == 1 )
				ret = Signo.Acuario;
		return ret;
	}

	
	
	
}
