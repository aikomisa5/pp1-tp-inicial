package modelo;

import java.util.List;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoDeContactoDAO;
import persistencia.dao.mysql.LocalidadDAOImpl;
import persistencia.dao.mysql.PersonaDAOImpl;
import persistencia.dao.mysql.TipoDeContactoDAOImpl;

public class Agenda {
	private PersonaDAO persona;
	private LocalidadDAO localidad;
	private TipoDeContactoDAO tipoDeContacto;

	public Agenda() {
		persona = new PersonaDAOImpl();
		localidad = new LocalidadDAOImpl();
		tipoDeContacto = new TipoDeContactoDAOImpl();
	}

	public void agregarPersona(PersonaDTO nuevaPersona) {
		persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO personaAEliminar) {
		persona.delete(personaAEliminar);
	}

	public List<PersonaDTO> obtenerPersonas() {
		return persona.readAll();
	}

	public void modificarPersona(PersonaDTO personaAModificar) {
		persona.update(personaAModificar);
	}

	public List<LocalidadDTO> getLocalidades() {
		return localidad.readAll(); 
	}

	public List<TipoDeContactoDTO> getTiposDeContacto() {
		return tipoDeContacto.readAll();
	}
	

}
