package es.uniovi.asw.dbUpdate;

import es.uniovi.asw.ReportWriter.WriteReport;
import es.uniovi.asw.parser.Votante;

public class WReportR {
	
	WriteReport report;
	
	public WReportR(WriteReport report) {
		this.report = report;
	}
	
	/**
	 * Método que comprueba que todos los datos del votante son correctos.
	 * Si hay algún problema, este error se almacena en el fichero de LOG
	 * @param v		Votante que se quiere cargar en la BBDD
	 * @return	true si los datos son válidos | false si hay algún error
	 */
	public boolean validarVotante(Votante v) {
		String datos = "ERROR: En el votante ";
		if (!v.getNombre().isEmpty() && !v.getNIF().isEmpty()
				&& !v.getEmail().isEmpty() && v.getCodColegioElectoral() >= 0
				&& !v.getPassword().isEmpty()) {		
			return true;
		} else {
			if (!v.getNombre().isEmpty()) 
				datos = datos + " con Nombre: " + v.getNombre() + ";";
			if (!v.getNIF().isEmpty()) 
				datos = datos + " con NIF: " + v.getNIF() + ";";
			if (v.getNombre().isEmpty()) 
				datos = datos + "Nombre incorrecto;";
			if (v.getNIF().isEmpty()) 
				datos = datos + "NIF incorrecto;";
			if (v.getEmail().isEmpty()) 
				datos = datos + "Email incorrecto;";
			if (v.getPassword().isEmpty()) 
				datos = datos + "Contraseña incorrecta;";
			if (v.getCodColegioElectoral() < 0) 
				datos = datos + "Cod Colegio electoral incorrecto;";	
			report.setLog(datos);
			return false;
		}
	}
	
	/**
	 * Método que pasa un informe de error a ReportWriter 
	 * para que este error quede almacenado en el fichero LOG
	 * @param datos		Cadena que explica el error
	 */
	public void setLog(String datos){
		report.setLog(datos);
	}

}
