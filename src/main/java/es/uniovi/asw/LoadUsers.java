package es.uniovi.asw;


import java.sql.SQLException;

import es.uniovi.asw.reportWriter.WReportP;
import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.dbUpdate.WReportR;
import es.uniovi.asw.parser.Insert;
import es.uniovi.asw.parser.InsertR;
import es.uniovi.asw.parser.carta.CartaCensuses;
import es.uniovi.asw.parser.carta.CartaTextoPlano;
import es.uniovi.asw.parser.read.RCensus;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {
	

	public static void main(String... args) throws SQLException {
		
		LoadUsers runner = new LoadUsers();
		runner.run(args);
		    
	}

	
	public void run(String... args) {

		String ruta;
		if(args.length >0)
			ruta =  args[0].toString();	//Ruta pasada por argumentos
		else
			ruta = "src/test/resources/test.xlsx";	//Ruta por defecto
		System.out.println("Ruta del fichero: " + ruta);
		
		WReportR report = new WReportR(new WReportP());
		
		/*
		 * Se puede elegir entre generar las cartas en texto plano o en PDF 
		 */
		CartaCensuses carta = new CartaTextoPlano();
		//CartaCensuses carta = new CartaPDF();
		
		Insert r = new InsertR(new RCensus(), carta, ruta);
		r.addVotante(new InsertP(report) );
	}
}
