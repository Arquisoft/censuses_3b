package es.uniovi.asw.reportWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class WReportP implements WriteReport {

	private static String RUTA_LOG = "log.txt";

	/**
	 * Método que recibe el error producido al cargar un usuario y lo escribe en
	 * el fichero log junto a la fecha exacta en la que se ha producido dicho
	 * error.
	 */
	@Override
	public void setLog(String datos) {
		FileWriter archivo = null;
		try {

			archivo = new FileWriter(new File(RUTA_LOG), true);
			Calendar fechaActual = Calendar.getInstance();

			archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH)) + "/"
					+ String.valueOf(fechaActual.get(Calendar.MONTH) + 1) + "/"
					+ String.valueOf(fechaActual.get(Calendar.YEAR)) + ";"
					+ String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY)) + ":"
					+ String.valueOf(fechaActual.get(Calendar.MINUTE)) + ":"
					+ String.valueOf(fechaActual.get(Calendar.SECOND))) + ";" + datos + "\r\n");

			archivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
