package dto;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String mail;
	private String fechaCumpleaņos;
	private String tipoDeContacto;

	public PersonaDTO(int idPersona, String nombre, String telefono)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public PersonaDTO(int idPersona, String nombre, String telefono, String mail, String fechaCumpleaņos,
			String tipoDeContacto) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.fechaCumpleaņos = fechaCumpleaņos;
		this.tipoDeContacto = tipoDeContacto;
	}

	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
}
