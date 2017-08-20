package persistencia.dao.mysql;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.LocalidadDTO;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOImplTest {
	LocalidadDAO dao = new LocalidadDAOImpl();
	
	@Test
	public void test() {
		ArrayList<LocalidadDTO> localidades = (ArrayList<LocalidadDTO>) dao.readAll();
		localidades.forEach(l -> System.out.println(l.getNombre()));
	}

}
