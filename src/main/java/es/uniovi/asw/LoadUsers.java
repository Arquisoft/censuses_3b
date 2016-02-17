package es.uniovi.asw;


import java.sql.SQLException;

import es.uniovi.asw.ReportWriter.WReportP;
import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.dbUpdate.WReportR;
import es.uniovi.asw.parser.Insert;
import es.uniovi.asw.parser.InsertR;
import es.uniovi.asw.parser.read.RCensus;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {
	

	public static void main(String... args) throws SQLException {
		//LoadUsers runner = new LoadUsers();
		//runner.run(args);
		
		WReportR report = new WReportR(new WReportP());
		
		Insert r = new InsertR(new RCensus());
		r.addVotante(new InsertP(report) );
		    
	}

	
	void run(String... args) {
		System.out.println("TODO");
	}
}
