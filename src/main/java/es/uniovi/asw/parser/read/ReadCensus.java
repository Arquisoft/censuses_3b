package es.uniovi.asw.parser.read;

import java.util.ArrayList;
import java.util.Map;

public interface ReadCensus {
	
	public Map<Integer, ArrayList<String>> leerFichero(String nombreFichero);

}
