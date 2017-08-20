package dto;

public class TipoDeContactoDTO {
	private int id;
	private String nombre;
	
	public TipoDeContactoDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public TipoDeContactoDTO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
