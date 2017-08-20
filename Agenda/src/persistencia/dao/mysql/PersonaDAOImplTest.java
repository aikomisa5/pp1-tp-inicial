package persistencia.dao.mysql;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dto.DomicilioDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.PersonaDAO;

public class PersonaDAOImplTest {
	PersonaDAOImpl dao = new PersonaDAOImpl();
	
	//	@Test
	//	public void pruebaJoin() {
	//		ArrayList<PersonaDTO>resultado = (ArrayList<PersonaDTO>) dao.readAll();
	//		for(PersonaDTO p : resultado) {
	//			System.out.println(p.getNombre()+" de "+p.getDomicilio().getLocalidad()+" tipo de contacto: "+p.getTipoDeContacto()+ " Fecha cumpleaños "+p.getFechaCumpleaños().toString());
	//		}
	//	}
	//	
	//	@Test
	//	public void insertDomicilio() {
	//		dao.insertDomicilio(new DomicilioDTO(0, "RAFAELA",5104, 0, "0", "Buenos aires"));
	//	}
		
	//	@Test 
	//	public void insertPersona() {
	//		DomicilioDTO dom = new DomicilioDTO("Rio neuquen", 13, 0, "1a", "San patricio del chañar");
	//		
	//		PersonaDTO p = new PersonaDTO(0, "danilo Ultimo", "15 15151", "dsadas@dasd", Date.valueOf("1993-02-06"), "Amigos", dom);
	//		dao.insert(p);
	//	}
	
		@Test
		public void updateTest() {
			List<PersonaDTO>personas = (ArrayList<PersonaDTO>) dao.readAll();
			System.out.println("Personas antes de modificar");
			personas.forEach(p -> System.out.println(p.getNombre()));
			personas.forEach(p ->{
				p.setNombre("Modificado1");
				dao.update(p);
				});
			personas = dao.readAll();
			System.out.println("Personas luego de modificar");
			personas.forEach( p -> System.out.println(p.getNombre()));		
		}

}
