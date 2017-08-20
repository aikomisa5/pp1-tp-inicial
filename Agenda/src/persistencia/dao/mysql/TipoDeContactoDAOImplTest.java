package persistencia.dao.mysql;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.TipoDeContactoDTO;
import persistencia.dao.interfaz.TipoDeContactoDAO;

public class TipoDeContactoDAOImplTest {
	
	TipoDeContactoDAO dao = new TipoDeContactoDAOImpl();
	
	
	@Test
	public void test() {
		ArrayList<TipoDeContactoDTO> tiposDeContacto = (ArrayList<TipoDeContactoDTO>) dao.readAll();
		tiposDeContacto.forEach(t -> System.out.println(t.getNombre()));
	}

}
