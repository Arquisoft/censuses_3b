package es.uniovi.asw.dbUpdate;

import es.uniovi.asw.dbUpdate.persistence.PersistenceFactory;
import es.uniovi.asw.parser.Votante;

public class InsertP implements Insert {
	
	WReportR reportR;
	
	public InsertP(WReportR report) {
		reportR = report;
	}
	
	/**
	 * Método que inserta un nuevo votante en la base de datos
	 * Si se produce un error se enviará a ReportWriter
	 * para que sea almacenado en el fichero de LOG
	 */
	@Override
	public void insertar(Votante v) {
		if(reportR.validarVotante(v)){
			PersistenceFactory.getVotantesPers().insert(v, reportR);
		}
	}
}
