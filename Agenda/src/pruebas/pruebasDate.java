package pruebas;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class pruebasDate {
	
	public static void main(String[] args) {
		Date date  = Date.valueOf("2017-02-06");
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// FOrmat in This Format or you change Change as well 
//		String Format= format.format(date);
		System.out.println(date.toString());

	}

}
