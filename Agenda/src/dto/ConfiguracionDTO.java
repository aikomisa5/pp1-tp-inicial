package dto;

public class ConfiguracionDTO {
	private String serverUrl;
	private String serverPuerto;
	private String bdNombre;
	private String userName;
	private String userPass;
	private String firstTime;

		
	public ConfiguracionDTO(String serverUrl, String serverPuerto, String bdNombre, String userName, String userPass) {
		this.serverUrl = serverUrl;
		this.serverPuerto = serverPuerto;
		this.bdNombre = bdNombre;
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public ConfiguracionDTO(String serverUrl, String serverPuerto, String bdNombre, String userName, String userPass, String ft) {
		this.serverUrl = serverUrl;
		this.serverPuerto = serverPuerto;
		this.bdNombre = bdNombre;
		this.userName = userName;
		this.userPass = userPass;
		this.firstTime = ft;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getServerPuerto() {
		return serverPuerto;
	}

	public void setServerPuerto(String serverPuerto) {
		this.serverPuerto = serverPuerto;
	}

	public String getBdNombre() {
		return bdNombre;
	}

	public void setBdNombre(String bdNombre) {
		this.bdNombre = bdNombre;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	
	

}
