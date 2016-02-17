package es.uniovi.asw.dbUpdate;

import es.uniovi.asw.ReportWriter.WriteReport;
import es.uniovi.asw.parser.Votante;

public class WReportR {
	
	WriteReport report;
	
	public WReportR(WriteReport report) {
		this.report = report;
	}
	
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
	
	public void setLog(String datos){
		report.setLog(datos);
	}

}
