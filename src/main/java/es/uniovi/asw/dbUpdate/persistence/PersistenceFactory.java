package es.uniovi.asw.dbUpdate.persistence;

public class PersistenceFactory {
	
	public static VotantesPers getVotantesPers(){
		return new VotantesPersImpl();
	}

}
