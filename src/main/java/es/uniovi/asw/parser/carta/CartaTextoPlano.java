package es.uniovi.asw.parser.carta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import es.uniovi.asw.parser.Votante;

public class CartaTextoPlano implements CartaCensuses{
	
	CartaAdapted cartaAdapted;
	
	public CartaTextoPlano() {
		cartaAdapted = new CartaAdapted();
	}

	/**
	 * Método que crea una carta en formato TXT (Texto plano)
	 */
	@Override
	public void crearCarta(Votante v) {
		String ruta = cartaAdapted.getRuta() + v.getNIF() +".txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
       try{
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(cartaAdapted.contenidoCarta(v));
        }
        bw.close();
       }catch (Exception e) {
			e.printStackTrace();
		}
	}

}
