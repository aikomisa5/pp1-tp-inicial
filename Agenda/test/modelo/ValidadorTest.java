package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidadorTest {

	// Validar longitud
	@Test(expected = NullPointerException.class)
	public void validarRangoStringNulo() {
		String nulo = null;
		Validador.esLongitudValida(nulo, 0, 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validarRangoRangosInvalidos() {
		String algo = "";
		Validador.esLongitudValida(algo, -2, -3);
		Validador.esLongitudValida(algo, 2, 1);
	}

	@Test
	public void validarRangoExtremosIguales() {
		String longCero = "";
		assertTrue(Validador.esLongitudValida(longCero, 0, 0));
	}

	@Test
	public void validarCasosValidos() {
		
		
		String longMinima = "1";
		String longMaxima = "123";
		String longIntermedia = "12";
		
		assertTrue(Validador.esLongitudValida(longMinima, 1, 3));
		assertTrue(Validador.esLongitudValida(longMaxima, 1, 3));
		assertTrue(Validador.esLongitudValida(longIntermedia, 1, 3));		
		assertFalse(Validador.esLongitudValida(longIntermedia, 3, 4));		
		assertFalse(Validador.esLongitudValida(longIntermedia, 0, 1));		
	}	

	@Test
	public void validarString() {
		assertTrue(Validador.StringNoEmpezadoEnEspacioPattern.matcher("asd").matches());
		assertFalse(Validador.StringNoEmpezadoEnEspacioPattern.matcher(" asd").matches());
		assertTrue(Validador.StringNoEmpezadoEnEspacioPattern.matcher("asd 234").matches());
	}
	
}
