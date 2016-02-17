package es.uniovi.asw.parser.carta;

import es.uniovi.asw.parser.Votante;

public class CartaAdapted {
	
	private static String RUTA = "src/main/resources/";
	
	public String getRuta(){
		return RUTA;
	}
	
	public String contenidoCarta(Votante v){
		String carta = "Buenos días " + v.getNombre() 
		+ ", le informamos de que su usuario para poder votar en las elecciones ya ha sido creado.\n" 
		+ "Usuario: " + v.getEmail() + "\n"
		+ "Contraseña: " + v.getPassword() + "\n"
		+ "Un saludo.";
		return carta;
	}

}
