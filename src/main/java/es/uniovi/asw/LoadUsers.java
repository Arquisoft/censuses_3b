package es.uniovi.asw;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.dbUpdate.WReportR;
import es.uniovi.asw.dbUpdate.persistence.PersistenceFactory;
import es.uniovi.asw.parser.Insert;
import es.uniovi.asw.parser.InsertR;
import es.uniovi.asw.parser.Votante;
import es.uniovi.asw.parser.carta.CartaCensuses;
import es.uniovi.asw.parser.carta.CartaPDF;
import es.uniovi.asw.parser.carta.CartaTextoPlano;
import es.uniovi.asw.parser.read.RCensus;
import es.uniovi.asw.reportWriter.WReportP;

/**
 * Main application
 */
public class LoadUsers {
	static Scanner scanner = new Scanner(System.in); //Recojo texto por consola
	static int select = -1; //opción elegida por el usuario
	static CartaCensuses carta;

	public static void main(String... args) throws SQLException {
		
		String ruta = ("src/test/resources/test.xlsx");
		formatearCartaPdf(ruta);
		formatearCartaTxt(ruta);
		System.out.println("Datos cargados en la base.");
		    
	}
	


	static void verContenidoBase() {
		List<Votante> votantes = PersistenceFactory.getVotantesPers().find();
		if(votantes.isEmpty()) 
			System.out.println("La base de datos está vacía");
		for(Votante v: votantes){
			System.out.println(v.toString());
		}
	}

	static void borrarCamposBD() {
		PersistenceFactory.getVotantesPers().delete();
	}

	static void formatearCartaTxt(String ruta) {
		carta = new CartaTextoPlano();
		WReportR report1 = new WReportR(new WReportP());
		Insert r1 = new InsertR(new RCensus(), carta, ruta);
		r1.addVotante(new InsertP(report1) );
	}

	static void formatearCartaPdf(String ruta) {
		carta = new CartaPDF();
		WReportR report = new WReportR(new WReportP());
		Insert r = new InsertR(new RCensus(), carta, ruta);
		r.addVotante(new InsertP(report) );
	}

	
	
}
