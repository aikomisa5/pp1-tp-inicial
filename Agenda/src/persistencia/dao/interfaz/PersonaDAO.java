package persistencia.dao.interfaz;

import java.util.List;

import dto.PersonaDTO;

public interface PersonaDAO 
{
	
	public boolean insert(PersonaDTO persona);

	public boolean delete(PersonaDTO persona_a_eliminar);
	
	public boolean edit(PersonaDTO personaOriginal, PersonaDTO personaEditada);
	
	public List<PersonaDTO> readAll();
}
