package es.uniovi.asw;


import java.sql.SQLException;

import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.parser.Insert;
import es.uniovi.asw.parser.InsertR;
import es.uniovi.asw.parser.RCensus;

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
		
		
		Insert r = new InsertR(new RCensus());
		r.addVotante(new InsertP() );
		
		    
	}

	

	
	void run(String... args) {
		System.out.println("TODO");
	}
}
