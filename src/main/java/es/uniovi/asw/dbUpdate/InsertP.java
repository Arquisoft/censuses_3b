package es.uniovi.asw.dbUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.uniovi.asw.parser.Votante;

public class InsertP implements Insert {
	
	WReportR reportR;
	
	public InsertP(WReportR report) {
		reportR = report;
	}
	
	@Override
	public void insertar(Votante v) {
		Connection c;
		String error = "";
		
		if(reportR.validarVotante(v)){
			try {
				c = Jdbc.getConnection();
				PreparedStatement ps = c
						.prepareStatement("INSERT INTO CENSOS (NOMBRE, NIF, EMAIL, CODCOLEGIOELECTORAL, PASSWORD) VALUES(?, ?, ?, ?, ?)");
				ps.setString(1, v.getNombre());
				ps.setString(2, v.getNIF());
				ps.setString(3, v.getEmail());
				ps.setInt(4, v.getCodColegioElectoral());
				ps.setString(5, v.getPassword());
				ps.execute();
				
				System.out.println("El usuario del cliente " + v.getNombre()
						+ " es " + v.getEmail() + " y su contraseña es "
						+ v.getPassword());
				
				ps.close();
				c.close();
				
			} catch (SQLException e) {
				error = "El votante con nombre: " + v.getNombre() + " y DNI: " + v.getNIF();
				error = error + " no se ha podido cargar correctamente en la base de datos.";
				reportR.setLog("ERROR: " + error);
			}
		}
			
	}

}
