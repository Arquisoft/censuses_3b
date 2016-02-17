package es.uniovi.asw.parser.carta;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.uniovi.asw.parser.Votante;

public class CartaPDF implements CartaCensuses{
	
	CartaAdapted cartaAdapted;
	
	public CartaPDF() {
		cartaAdapted = new CartaAdapted();
	}

	@Override
	public void crearCarta(Votante v) {
        try{
    		  FileOutputStream archivo = new FileOutputStream(cartaAdapted.getRuta() + v.getNIF() +".pdf");
    	      Document documento = new Document();
    	      PdfWriter.getInstance(documento, archivo);
    	      documento.open();
    	      documento.add(new Paragraph(cartaAdapted.contenidoCarta(v)));
    	      documento.close();
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
	}

}
