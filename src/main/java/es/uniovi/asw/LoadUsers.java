package es.uniovi.asw;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import es.uniovi.asw.reportWriter.WReportP;
import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.dbUpdate.Jdbc;
import es.uniovi.asw.dbUpdate.WReportR;
import es.uniovi.asw.parser.Insert;
import es.uniovi.asw.parser.InsertR;
import es.uniovi.asw.parser.carta.CartaCensuses;
import es.uniovi.asw.parser.carta.CartaPDF;
import es.uniovi.asw.parser.carta.CartaTextoPlano;
import es.uniovi.asw.parser.read.RCensus;

/**
 * Main application
 */
public class LoadUsers {
	static Scanner scanner = new Scanner(System.in); //Recojo texto por consola
	static int select = -1; //opción elegida por el usuario
	static CartaCensuses carta;

	public static void main(String... args) throws SQLException {
		
		arrancarConsola();
		    
	}
	
	public static void arrancarConsola(){
		String ruta = "";
		
				while(select != 0){
					
					try{
						System.out.println("Elige opción: \n"+ 
								"1.- Leer de fichero. Indicar una ruta tal que : ejemplo.xlsx\n" +
								"2.- Carta en formato PDF e inserción de ususarios\n" +
								"3.- Carta en formato txt e inserción de usuarios\n" +
								"4.- Ver contenido de la base de datos\n" +
								"5.- Borrar la base de datos\n" +
								"0.- Salir");
						select = Integer.parseInt(scanner.next()); 
			
						switch(select){
						case 1: 
							ruta = asignarRutaFichero(); 
							break;
						case 2: 
							formatearCartaPdf(ruta);
							break;
						case 3: 
							formatearCartaTxt(ruta);
							break;
						case 4:
							verContenidoBase();
							break;
						case 5:
							borrarCamposBD();
							break;
						case 0: 
							System.out.println("Ha elegido la opcion de salir");
							System.exit(0);
							break;
						default:
							System.out.println("Opción no reconocida");
							break;
						}
						
						System.out.println("\n"); 
						
					}catch(Exception e){
						System.out.println("Error, no ha elegido ninguna opcion");
					}
				}

			}

	private static void verContenidoBase() {
		Connection c = null;
		
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM CENSOS");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println("ID: " +rs.getLong(1) + " NOMBRE: " + rs.getString(2) + " NIF: " + rs.getString(3) + " EMAIL: " + rs.getString(4) + " CÓDIGO COLEGIO ELECTORAL: " + rs.getString(5) + " CONTRASEÑA " + rs.getString(6) );
			}
			c.close();

		} catch (Throwable e) {
			System.out.println("Error, fallado el borrado de datos");
			e.printStackTrace();
		}

	}

	private static void borrarCamposBD() {
		Connection c = null;
		try {
			  c = Jdbc.getConnection();
			  Statement st = c.createStatement();
			  // borra toda la información de la tabla censos
			  st.execute("DELETE FROM PUBLIC.CENSOS");
			  st.close();
			  c.close();

			} catch (Throwable e)  {
			  System.out.println("Error, fallado el borrado de datos");
			  e.printStackTrace();
			}
		
	}

	private static void formatearCartaTxt(String ruta) {
		carta = new CartaTextoPlano();
		WReportR report1 = new WReportR(new WReportP());
		Insert r1 = new InsertR(new RCensus(), carta, ruta);
		r1.addVotante(new InsertP(report1) );
	}

	private static void formatearCartaPdf(String ruta) {
		carta = new CartaPDF();
		WReportR report = new WReportR(new WReportP());
		Insert r = new InsertR(new RCensus(), carta, ruta);
		r.addVotante(new InsertP(report) );
	}

	private static String asignarRutaFichero() {
		String ruta;
		String fichero;
		fichero = scanner.next();
		if (fichero.contains(".")) {
			ruta = "src/test/resources/" + fichero;
			System.out.println("La ruta es " + ruta);
			return ruta;
		}
		
		return "src/test/resources/test.xlsx";
	}
	
}
