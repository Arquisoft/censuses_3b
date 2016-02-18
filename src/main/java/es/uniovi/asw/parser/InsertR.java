package es.uniovi.asw.parser;

import java.util.ArrayList;
import java.util.Map;

import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.parser.carta.CartaCensuses;
import es.uniovi.asw.parser.read.ReadCensus;


public class InsertR implements Insert {
	
	
	private ReadCensus reader;
	private CartaCensuses carta;
	private String ruta;	//ruta del fichero en el que se encuentra la lista de votantes

	public InsertR(ReadCensus reader, CartaCensuses carta, String ruta) {
		super();
		this.reader = reader;
		this.carta = carta;
		this.ruta = ruta;
	}
	

	/**
	 * Método que añade todos los votantes a la base de datos
	 */
	@Override
	public void addVotante(InsertP database) {
		Map<Integer, ArrayList<String>> map = reader.leerFichero(ruta);
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
			
			carta.crearCarta(v);
			
		}
		
	}
	
}
