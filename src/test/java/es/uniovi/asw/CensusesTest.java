package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import es.uniovi.asw.ReportWriter.WReportP;
import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.dbUpdate.WReportR;
import es.uniovi.asw.parser.Votante;
import es.uniovi.asw.parser.read.RCensus;
import es.uniovi.asw.parser.read.ReadCensus;

public class CensusesTest {

@Test
public void DBUpdate1() {
		
		WReportR report = new WReportR(new WReportP());
		InsertP insertP = new InsertP(report);
		
		//Creamos un nuevo votante
		Votante v = new Votante("Pedro Garcia", "56982104R", "pedro@gmail.com", 5698, "ghyts52?");
		//Lo insertamos en la base de datos
		insertP.insertar(v);
		Votante v2 = insertP.findVotante(v.getNIF());
		//Comprobamos que todos los datos se han añadido correctamente
		assertEquals(v.getNombre(), v2.getNombre());
		assertEquals(v.getNIF(), v2.getNIF());
		assertEquals(v.getEmail(), v2.getEmail());
		assertEquals(v.getCodColegioElectoral(), v2.getCodColegioElectoral());
		assertEquals(v.getPassword(), v2.getPassword());		
}

@Test
public void DBUpdate2() {
	
	WReportR report = new WReportR(new WReportP());
	InsertP insertP = new InsertP(report);
	
	//Creamos varios votantes con errores
	ArrayList<Votante> list = new ArrayList<Votante>();
	list.add(new Votante("", "56933104R", "pedro@gmail.com", 54, "ghyts52?"));
	list.add(new Votante("Carmen", "", "carmen@gmail.com", 54, "alsjd85?"));
	list.add(new Votante("Pablo", "89641208G", "", 54, "alsjd85?"));
	list.add(new Votante("Javi", "85214236T", "javi@gmail.com", -8, "liksj67("));
	
	Votante v3;
	for(Votante vot: list){
		insertP.insertar(vot);
		 v3= insertP.findVotante(vot.getNIF());
		//Comprobamos que no se han añadido a la base de datos
		assertEquals(v3, null);
	}
	
}


@Test
public void RCensusTest() {
	
	ReadCensus read = new RCensus();
	Map<Integer, ArrayList<String>> mapa = read.leerFichero("src/test/resources/test.xlsx");
	
	assertEquals(mapa.get(0).get(0), "Juan Torres Pardo");
	assertEquals(mapa.get(0).get(1), "90500084Y");
	assertEquals(mapa.get(1).get(0), "Luis López Fernando");
	assertEquals(mapa.get(1).get(3), "345.0");
	assertEquals(mapa.get(2).get(0), "Ana Torres Pardo");
}
@Test
public void Carta() {
	
	
}



}
