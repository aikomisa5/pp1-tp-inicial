package persistencia.dao.mysql;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.PersonaDTO;
import persistencia.dao.interfaz.PersonaDAO;

public class PersonaDAOImplTest {
	PersonaDAO dao = new PersonaDAOImpl();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void pruebaJoin() {
		ArrayList<PersonaDTO>resultado = (ArrayList<PersonaDTO>) dao.readAll();
		for(PersonaDTO p : resultado) {
			System.out.println(p.getNombre()+" de "+p.getDomicilio().getLocalidad()+" tipo de contacto: "+p.getTipoDeContacto());
		}
	}

}
