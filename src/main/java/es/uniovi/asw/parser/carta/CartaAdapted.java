package es.uniovi.asw.parser.carta;

import es.uniovi.asw.parser.Votante;

public class CartaAdapted {
	
	private static String RUTA = "cartas/";
	
	/**
	 * Método que devuelve la ruta de la carpeta en la que se almacenarán todas las cartas
	 * @return	ruta
	 */
	public String getRuta(){
		return RUTA;
	}
	
	/**
	 * Método que devuelve el contenido de la carta
	 * @param v	 Votante al que va destinado la carta
	 * @return	el contenido de la carta
	 */
	public String contenidoCarta(Votante v){
		String carta = "Buenos días " + v.getNombre() 
		+ ", le informamos de que su usuario para poder votar en las elecciones ya ha sido creado.\n" 
		+ "Usuario: " + v.getEmail() + "\n"
		+ "Contraseña: " + v.getPassword() + "\n"
		+ "Un saludo.";
		return carta;
	}

}
