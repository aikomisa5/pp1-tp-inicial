package presentacion.reportes.signos;
public enum SignoZodiaco {
	CAPRICORNIO,ACUARIO,PISCIS,ARIES,TAURO,G�MINIS,C�NCER,LEO,VIRGO,
	LIBRA,ESCORPI�N,SAGITARIO;
	
	@Override
	public String toString() {
		String palabraFormateada =  super.toString().substring(0, 1) +super.toString().toLowerCase().substring(1);
		return palabraFormateada;
	}
	}

