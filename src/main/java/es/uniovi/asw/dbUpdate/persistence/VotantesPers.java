package es.uniovi.asw.dbUpdate.persistence;

import java.util.List;

import es.uniovi.asw.dbUpdate.WReportR;
import es.uniovi.asw.parser.Votante;


public interface VotantesPers {

	public void insert(Votante v, WReportR reportR);
	
	public void delete();

	public Votante findVotante(String NIF);
	
	public List<Votante> find();

}
