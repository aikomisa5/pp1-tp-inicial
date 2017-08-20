package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadDTO;

public interface LocalidadDAO {

	public boolean insert(LocalidadDTO localidad);
	
	public boolean delete(LocalidadDTO localidad);
	
	public boolean update(LocalidadDTO localidad);
	
	public List<LocalidadDTO> readAll();
}
