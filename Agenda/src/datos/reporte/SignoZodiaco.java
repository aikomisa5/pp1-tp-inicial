package datos.reporte;
import java.sql.Date;
import java.util.Calendar;

public enum SignoZodiaco {
	ARIES,LEO,SAGITARIO,TAURO,VIRGO,CAPRICORNIO,GÉMINIS,
	LIBRA,ACUARIO,CÁNCER,ESCORPIÓN,PISCIS;


public SignoZodiaco getSigno(Date fechaDeNacimiento){
	
	Calendar calFecha = Calendar.getInstance();
    calFecha.setTime(fechaDeNacimiento);
    int añoFecha = calFecha.get(Calendar.YEAR);
    int mesFecha = calFecha.get(Calendar.MONTH);
    int diaFecha = calFecha.get(Calendar.DATE);
	
	if (diaFecha >= 21 && mesFecha == 3 || diaFecha <= 20 && mesFecha == 4)
		return SignoZodiaco.ARIES;
	if (diaFecha >= 21 && mesFecha == 4 || diaFecha <= 21 && mesFecha == 5)
		return SignoZodiaco.TAURO;
	if (diaFecha >= 22 && mesFecha == 5 || diaFecha <= 21 && mesFecha == 6)
		return SignoZodiaco.GÉMINIS;
	if (diaFecha >= 22 && mesFecha == 6 || diaFecha <= 22 && mesFecha == 7)
		return SignoZodiaco.CÁNCER;
	if (diaFecha >= 23 && mesFecha == 7 || diaFecha <= 23 && mesFecha == 8)
		return SignoZodiaco.LEO;
	if (diaFecha >= 24 && mesFecha == 8 || diaFecha <= 23 && mesFecha == 9)
		return SignoZodiaco.VIRGO;
	if (diaFecha >= 24 && mesFecha == 9 || diaFecha <= 23 && mesFecha == 10)
		return SignoZodiaco.LIBRA;
	if (diaFecha >= 24 && mesFecha == 10 || diaFecha <= 22 && mesFecha == 11)
		return SignoZodiaco.ESCORPIÓN;
	if (diaFecha >= 23 && mesFecha == 11 || diaFecha <= 21 && mesFecha == 12)
		return SignoZodiaco.SAGITARIO;
	if (diaFecha >= 22 && mesFecha == 12 || diaFecha <= 20 && mesFecha == 1)
		return SignoZodiaco.CAPRICORNIO;
	if (diaFecha >= 21 && mesFecha == 1 || diaFecha <= 18 && mesFecha == 2)
		return SignoZodiaco.ACUARIO;
	if (diaFecha >= 19 && mesFecha == 2 || diaFecha <= 20 && mesFecha == 3)
		return SignoZodiaco.PISCIS;
		
		
		
		
		
	
				
			
			
			//fechaDeNacimiento.compareTo(Date.valueOf("06-02-1993"))==1 &&
			
			
	
	return null;
	}

}