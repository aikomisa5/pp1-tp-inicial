package presentacion.reportes.signos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import dto.PersonaDTO;
import modelo.Agenda;

public class PersonaReporteSigno extends PersonaDTO implements Comparable<PersonaReporteSigno> {
	String signo;

	public PersonaReporteSigno(String nombre, String telefono, String mail, Date fechaCumpleaños) {
		super(nombre, telefono, mail, fechaCumpleaños, null, null);

		this.signo = this.calcularSigno();
	}

	public PersonaReporteSigno(PersonaDTO p) {
		super(p.getNombre(),p.getTelefono(),p.getMail(),p.getFechaCumpleaños(),null,null);
		this.signo = this.calcularSigno();
	}

	public String getSigno() {
		return signo;
	}

	private String calcularSigno() {

		Calendar calFecha = Calendar.getInstance();
		calFecha.setTime(this.getFechaCumpleaños());
		int mesFecha = calFecha.get(Calendar.MONTH) + 1; // +1 porque si es mes 8, trae 7
		int diaFecha = calFecha.get(Calendar.DATE);

		if (diaFecha >= 21 && mesFecha == 3 || diaFecha <= 20 && mesFecha == 4)
			return SignoZodiaco.ARIES.toString();
		if (diaFecha >= 21 && mesFecha == 4 || diaFecha <= 21 && mesFecha == 5)
			return SignoZodiaco.TAURO.toString();
		if (diaFecha >= 22 && mesFecha == 5 || diaFecha <= 21 && mesFecha == 6)
			return SignoZodiaco.GÉMINIS.toString();
		if (diaFecha >= 22 && mesFecha == 6 || diaFecha <= 22 && mesFecha == 7)
			return SignoZodiaco.CÁNCER.toString();
		if (diaFecha >= 23 && mesFecha == 7 || diaFecha <= 23 && mesFecha == 8)
			return SignoZodiaco.LEO.toString();
		if (diaFecha >= 24 && mesFecha == 8 || diaFecha <= 23 && mesFecha == 9)
			return SignoZodiaco.VIRGO.toString();
		if (diaFecha >= 24 && mesFecha == 9 || diaFecha <= 23 && mesFecha == 10)
			return SignoZodiaco.LIBRA.toString();
		if (diaFecha >= 24 && mesFecha == 10 || diaFecha <= 22 && mesFecha == 11)
			return SignoZodiaco.ESCORPIÓN.toString();
		if (diaFecha >= 23 && mesFecha == 11 || diaFecha <= 21 && mesFecha == 12)
			return SignoZodiaco.SAGITARIO.toString();
		if (diaFecha >= 22 && mesFecha == 12 || diaFecha <= 20 && mesFecha == 1)
			return SignoZodiaco.CAPRICORNIO.toString();
		if (diaFecha >= 21 && mesFecha == 1 || diaFecha <= 18 && mesFecha == 2)
			return SignoZodiaco.ACUARIO.toString();
		// if (diaFecha >= 19 && mesFecha == 2 || diaFecha <= 20 && mesFecha == 3)
		else
			return SignoZodiaco.PISCIS.toString();

	}

	@Override
	public int compareTo(PersonaReporteSigno o) {
		Calendar fecha1 = Calendar.getInstance();
		fecha1.setTime(this.getFechaCumpleaños());
		fecha1.set(Calendar.YEAR, 1000);

		Calendar fecha2 = Calendar.getInstance();
		fecha2.setTime(o.getFechaCumpleaños());
		fecha2.set(Calendar.YEAR, 1000);

		if (fecha1.get(Calendar.MONTH) > fecha2.get(Calendar.MONTH))
			return 1;
		else if (fecha1.get(Calendar.MONTH) < fecha2.get(Calendar.MONTH))
			return -1;
		else if (fecha1.get(Calendar.DAY_OF_MONTH) > fecha2.get(Calendar.DAY_OF_MONTH))
			return 1;
		else if (fecha1.get(Calendar.DAY_OF_MONTH) < fecha2.get(Calendar.DAY_OF_MONTH))
			return -1;
		else
			return 0;

	}

	public static List<PersonaReporteSigno> getListaPersonasOrdenadasPorDia(List<PersonaDTO> personas) {
		List<PersonaReporteSigno>personasJasper=new ArrayList<>();
		personas.forEach(p -> personasJasper.add(new PersonaReporteSigno(p)));
		Collections.sort(personasJasper);
		return personasJasper;
	}
	
	public static Collection<?> getListaPersonasOrdenadasPorDia2() {
		List <PersonaDTO> personas = Agenda.getInstance().obtenerPersonas();
		List<PersonaReporteSigno>personasJasper=new ArrayList<>();
		personas.forEach(p -> personasJasper.add(new PersonaReporteSigno(p)));
		Collections.sort(personasJasper);
		return personasJasper;
	}

}
