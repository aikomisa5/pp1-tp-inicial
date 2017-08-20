package persistencia.dao.interfaz;

import dto.DomicilioDTO;

public interface DomicilioDAO {
	
	public int agregarDomicilio();
	
	public boolean editarDomicilio(DomicilioDTO domicilio);
		
	public boolean borrarDomicilio(DomicilioDTO domicilio); 

}
