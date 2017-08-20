package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.DomicilioDTO;
import dto.PersonaDTO;

public class PersonaDAOImpl implements PersonaDAO
{
	private static final String insertPersona = "INSERT INTO personas(nombre, telefono, mail, cumpleanios, tipo, domicilio) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String insertDomicilio="INSERT INTO domicilios(calle, altura, piso, departamento, localidad) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String personasJoinDomicilios = "SELECT * FROM personas inner join domicilios on personas.Domicilio = domicilios.idDomicilio";
	private static final Conexion conexion = Conexion.getConexion();
	private static final String update = "UPDATE personas " + 
						"SET Nombre = ?, telefono = ?, mail = ?, cumpleanios = ?, tipo =?, domicilio =? " + 
						"WHERE idPersona = ?";
	
	public boolean insert(PersonaDTO persona)
	{
		int pkDomicilio=insertDomicilio(persona.getDomicilio());
		persona.getDomicilio().setIdDomicilio(pkDomicilio);
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insertPersona);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getMail());
			statement.setDate(4, persona.getFechaCumpleaños());
			statement.setString(5, persona.getTipoDeContacto());
			statement.setInt(6, persona.getDomicilio().getIdDomicilio());
			if(statement.executeUpdate() > 0) //Si se ejecutÃ³ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}
	
	private int insertDomicilio(DomicilioDTO domicilio)
	{
		PreparedStatement statement;
		ResultSet rs;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insertDomicilio, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, domicilio.getCalle());
			statement.setInt(2, domicilio.getAltura());
			statement.setInt(3, domicilio.getPiso());
			statement.setString(4, domicilio.getDepartamento());
			statement.setString(5, domicilio.getLocalidad());
			
			
			
			if(statement.executeUpdate() > 0) //Si se ejecutÃ³ devuelvo true
			{	
				//con esto obtengo el numero autogenerado por mysql, luego lo uso para setearselo a la persona
				rs=statement.getGeneratedKeys();
				if(rs.next())
					return rs.getInt(1);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return -1;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutÃ³ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(personasJoinDomicilios);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"),
						resultSet.getString("Mail"), resultSet.getDate("Cumpleanios"), resultSet.getString("Tipo"), 
						new DomicilioDTO(resultSet.getInt("idDomicilio"), resultSet.getString("calle"), resultSet.getInt("altura"), resultSet.getInt("piso"),
								resultSet.getString("departamento"), resultSet.getString("localidad") ) ) );
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return personas;
	}

	@Override
	public boolean update(PersonaDTO persona) 
	{
		PreparedStatement statement;
		try 
 		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getMail());
			statement.setDate(4, persona.getFechaCumpleaños());
			statement.setString(5, persona.getTipoDeContacto());
			statement.setInt(6, persona.getDomicilio().getIdDomicilio());
			statement.setInt(7, persona.getIdPersona());
						
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				 				return true;
 		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

}
