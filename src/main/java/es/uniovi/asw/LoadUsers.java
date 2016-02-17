package es.uniovi.asw;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.dbUpdate.Jdbc;
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
//		LoadUsers runner = new LoadUsers();
//		runner.run(args);
		
		
//		Insert r = new InsertR(new RCensus());
//		r.addVotante(new InsertP() );
//		
		    
	}

	

	
	void run(String... args) {
		System.out.println("TODO");
	}
}
