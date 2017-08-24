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
	
	public AlgoritmoPersonasOrdenadas (){
		
	}
	
	public void llenarListaPersonasDTO(){
		lista = personaDAO.readAll();
	}
	
	
	public void llenarListaPersonas(List <PersonaDTO> listaPersonasDTO){
		for (PersonaDTO p : listaPersonasDTO){
			listaPersonas.add(new PersonaDTOJasper (p.getNombre(),p.getTelefono(),p.getMail()
					,p.getFechaCumpleaños(),p.getTipoDeContacto(),p.getDomicilio(),null));
		}
	}
	
	public void getListaPersonasOrdenadasPorDia(){
		
		llenarListaPersonasDTO();
		llenarListaPersonas(lista);
		
		Collections.sort(listaPersonas, new OrdenarPorDia());
		
	for (int i=0; i < listaPersonas.size(); i++){
		System.out.println(listaPersonas.get(i).getFechaCumpleaños()); 
		}
		
		}

	}

