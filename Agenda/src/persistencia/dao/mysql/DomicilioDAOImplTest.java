package persistencia.dao.mysql;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.DomicilioDTO;
import persistencia.dao.interfaz.DomicilioDAO;

public class DomicilioDAOImplTest {
	DomicilioDAO dao = new DomicilioDAOImpl();
	
	
	@Test
	public void test() {
		ArrayList<DomicilioDTO>domicilios = (ArrayList<DomicilioDTO>) dao.readAll();
		
		domicilios.forEach(d -> System.out.println(d.getLocalidad().getNombre()+" "+d.getIdDomicilio()));
	}

}
