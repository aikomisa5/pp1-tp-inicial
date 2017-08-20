package persistencia.dao.mysql;

import java.util.List;

import dto.LocalidadDTO;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOImpl implements LocalidadDAO{
	
	private static final String insertDomicilio="INSERT INTO localidades(nombreLocalidad) VALUES(?)";
	private static final String delete = "DELETE FROM localidades WHERE idLocalidad = ?";
	private static final String update = "UPDATE localidades " + 
			"SET nombreLocalidad =?" + 
			"WHERE idLocalidad = ?";
	private static final String readAll="select * from domicilios";

	@Override
	public boolean insert(LocalidadDTO localidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LocalidadDTO localidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LocalidadDTO localidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LocalidadDTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
