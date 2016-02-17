package es.uniovi.asw.parser;

import java.util.ArrayList;
import java.util.Map;

import es.uniovi.asw.dbUpdate.InsertP;


public class InsertR implements Insert {
	private ReadCensus reader;

	public InsertR(ReadCensus reader) {
		super();
		this.reader = new RCensus();
	}
	

	@Override
	public void addVotante(InsertP database) {
		Map<Integer, ArrayList<String>> map = reader.leerFichero("test.xlsx");
		Votante v;
		
		for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet())
		{
		    System.out.println(entry.getKey() + " ");
			for(String s: entry.getValue()){
				System.out.println(s);
				
			}
			
			v = new Votante(entry.getValue().get(0), entry.getValue().get(1),
					entry.getValue().get(2), (int) Double.parseDouble(entry.getValue().get(3)),
					entry.getValue().get(4));
			
			

			database.insertar(v);

			System.out.println("\n");
			
			
		}
		
	}
	
	
	
	
}
