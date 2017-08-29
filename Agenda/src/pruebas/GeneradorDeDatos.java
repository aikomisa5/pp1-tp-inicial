package pruebas;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;
import modelo.Agenda;

public class GeneradorDeDatos {
	private static String[] nombres = { "Elliott", "Albertha", "Wilburn", "Marquita", "Merrilee", "Rosy", "Williemae",
			"Loma", "Raymond", "Ardis", "Patrice", "Julie", "Maryjane", "Giselle", "Irena", "Hang", "Margarita",
			"Raymundo", "Zachariah", "Stephenie", "Freddy", "Natividad", "Tequila", "Ron", "Sunni", "Verlie", "Dennis",
			"Nathan", "Tania", "Lory", "Eladia", "Kitty", "Elyse", "Kandice", "Charlene", "Isobel", "Morris",
			"Rosalina", "Narcisa", "Eun", "Alda", "Marilou", "Beatrice", "Marcy", "Margery", "Bradley			",
			"Raeann", "Katheryn", "Brandy", "Hulda" };
	private static String[] calles = { "lima", "buenos aires", "gaspar campos", "ecuador", "colombia", "san martín",
			"quito", "calle 1", "calle2", "calle 3" };
	private static String[] localidades = { "17 de Agosto", "25 de Mayo", "9 de Julio / La Niña", "Acassuso", "Aguas Verdes",
  			"Alberti", "Arenas Verdes", "Arrecifes", "Avellaneda", "Ayacucho", "Azul", "Bahía Blanca", "Bahía San Blas",
  			"Balcarce", "Balneario Marisol", "Balneario Orense", "Balneario Reta", "Balneario San Cayetano", "Baradero",
 			"Bella Vista", "Benito Juárez", "Berazategui", "Berisso", "Boulogne", "Bragado", "Brandsen", "Campana",
 			"Capilla del Señor", "Capital Federal", "Capitán Sarmiento", "Carapachay", "Carhue", "Carhué",
 			"Carlos Keen", "Carmen de Areco", "Carmen de Patagones", "Caseros", "Castelar", "Castelli", "Chacabuco",
 			"Chascomús", "Chivilcoy", "City Bell", "Ciudadela", "Claromecó", "Colón", "Coronel Dorrego",
 			"Coronel Pringles", "Coronel Suárez", "Darregueira", "Dunamar", "Escobar", "Ezeiza", "Florencio Varela",
 			"Florida", "Fortín Mercedes", "Garin", "General Arenales", "General Belgrano", "General Madariaga",
 			"General Villegas", "Gral. Daniel Cerri", "Gran Buenos Aires", "Guaminí", "Haedo", "Huanguelen",
 			"Hurlingham", "Isla Martín García", "Ituzaingo", "Junín", "La Plata", "La Tablada", "Laferrere", "Lanus",
 			"Laprida", "Las Flores", "Las Gaviotas", "Las Toninas", "Lima", "Lisandro Olmos", "Llavallol", "Lobos",
 			"Lomas de Zamora", "Los Toldos - Gral. Viamonte", "Los Polvorines", "Lucila del Mar", "Luis Guillón",
 			"Luján", "Magdalena", "Maipú", "Mar Azul", "Mar Chiquita", "Mar de Ajó", "Mar de Cobo", "Mar del Plata",
 			"Mar del Sud", "Mar del Tuyú", "Martinez", "Médanos / Laguna Chasicó", "Mercedes", "Merlo", "Miramar",
 			"Monte Hermoso", "Moreno", "Morón", "Munro", "Navarro", "Necochea", "Nueva Atlantis", "Olavarría", "Olivos",
 			"Open Door", "Ostende", "Pedro Luro", "Pehuajó", "Pehuen Có", "Pergamino", "Pigüé", "Pilar", "Pinamar",
 			"Provincia de Buenos Aires", "Puan", "Punta Alta", "Punta Indio", "Punta Lara", "Quequén", "Quilmes",
 			"Ramallo", "Ramos Mejía", "Ranchos", "Rauch", "Rivadavia", "Rojas", "Roque Pérez", "Saenz Peña",
 			"Saladillo", "Salto", "San Antonio de Areco", "San Bernardo", "San Cayetano", "San Clemente del Tuyú",
 			"San Fernando", "San Isidro", "San Justo", "San Martin", "San Miguel del Monte", "San Nicolás", "San Pedro",
 			"San Vicente", "Santa Clara del Mar", "Santa Teresita", "Sarandí", "Sierra de la Ventana",
 			"Sierra de los Padres", "Sierras de los Padres", "Tandil", "Tapalqué", "Temperley", "Tigre",
 			"Tornquist / Ruta Prov. 76", "Trenque Lauquen", "Tres Arroyos", "Turdera", "Valentin Alsina",
 			"Vicente Lopez", "Victoria", "Villa Ballester", "Villa Gesell", "Villa Lynch", "Villa Serrana La Gruta",
 			"Villa Ventana", "Villalonga", "Wilde", "Zárate" };
	private static Random random = new Random();
	private static Agenda agenda = Agenda.getInstance();

	private static String getTelefeno() {
		return Integer.toString(
				random.nextInt(10) * 1000 + random.nextInt(10) + 100 + random.nextInt(10) * 10 + random.nextInt(10))
				+ " " + Integer.toString(random.nextInt(10) * 1000 + random.nextInt(10) + 100 + random.nextInt(10) * 10
						+ random.nextInt(10));

	}

	private static int getAltura() {
		return random.nextInt(3000);
	}

	private static int getPiso() {
		return random.nextInt(16);
	}

	private static String getDepto() {
		return Character.toString((char) (65 + random.nextInt(11)));
	}

	private static String getMail() {
		return nombres[random.nextInt(nombres.length)] + "@" + "mail.com";
	}

	private static Date getFechaNac() {
		return Date.valueOf(Integer.toString(1970 + random.nextInt(48)) + "-" + Integer.toString(1 + random.nextInt(12))
				+ "-" + Integer.toString(1 + random.nextInt(28)));
	}

	public static void generarDatos(int cantidad) {
		for (int i = 0; i < localidades.length; i++) {
			agenda.agregarLocalidad(new LocalidadDTO(localidades[i]));
		}

		List<LocalidadDTO> listaLocalidades = agenda.getLocalidades();
		List<TipoDeContactoDTO> listaContactos = agenda.getTiposDeContacto();

		for (int i = 0; i < cantidad; i++) {
			DomicilioDTO d = new DomicilioDTO(calles[random.nextInt(calles.length)], getAltura(), getPiso(), getDepto(),listaLocalidades.get(random.nextInt(listaLocalidades.size())));
			int idDomicilio= agenda.agregarDomicilio(d);
			d.setIdDomicilio(idDomicilio);
			
			PersonaDTO p = new PersonaDTO(nombres[random.nextInt(nombres.length)], getTelefeno(), getMail(),
					getFechaNac(), listaContactos.get(random.nextInt(listaContactos.size())),d);
			
			agenda.agregarPersona(p);
		}
		System.out.println("Agregadas " + cantidad +" personas a la base de datos.");
	}

}