package datos.reporte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dto.PersonaDTO;
import persistencia.dao.mysql.PersonaDAOImpl;

public class AlgoritmoPersonasOrdenadas {

	PersonaDAOImpl personaDAO = new PersonaDAOImpl();
	List<PersonaDTO> lista = new ArrayList<>();
	ArrayList<PersonaDTOJasper> listaPersonas = new ArrayList<>();

	public AlgoritmoPersonasOrdenadas() {

	}

	public void llenarListaPersonasDTO() {
		lista = personaDAO.readAll();
		for (PersonaDTO p : lista) {
			listaPersonas.add(new PersonaDTOJasper(p.getNombre(), p.getTelefono(), p.getMail(), p.getFechaCumpleaños(),
					p.getTipoDeContacto(), p.getDomicilio(), null));
		}
	}

	public ArrayList<PersonaDTOJasper> getListaPersonasOrdenadasPorDia() {
		listaPersonas.clear();
		llenarListaPersonasDTO();
		asignarSignoAPersonas(listaPersonas);

		Collections.sort(listaPersonas);

		return listaPersonas;
	}

	public void asignarSignoAPersonas(ArrayList<PersonaDTOJasper> listaPersonas) {
		for (PersonaDTOJasper p : listaPersonas) {
			SignoZodiaco sig = null;
			sig = p.calcularYAsignarSigno(p.getFechaCumpleaños());
			p.setSigno(sig);
		}
	}

}
