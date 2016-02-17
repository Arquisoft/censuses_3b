package es.uniovi.asw.ReportWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class WReportP implements WriteReport{
	
	@Override
	public void setLog(String datos) {
		FileWriter archivo;
		try{
			if (new File("log.txt").exists()==false){
		    	   archivo = new FileWriter(new File("log.txt"),false);
		       }
		           archivo = new FileWriter(new File("log.txt"), true);
		            Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar    
		            //Empieza a escribir en el archivo
		            archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
		                 +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
		                 +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
		                 +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
		                 +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
		                 +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";"+datos+"\r\n");
		            archivo.close(); //Se cierra el archivo
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
