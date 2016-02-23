package es.uniovi.asw.dbUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.uniovi.asw.parser.Votante;

public class Persistence {

	
	public void insertar(Votante v, WReportR reportR) {
		Connection c ;
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
	
	public Votante findVotante(String NIF) {
		Connection c;
		Votante v = null;
		ResultSet rs = null;
		
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM CENSOS WHERE NIF = '" + NIF + "'");
			rs = ps.executeQuery();

			if (rs.next()) {
				v = new Votante(rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6));
			}
			
			
			ps.close();
			rs.close();
			c.close();
			
		} catch (SQLException e) {
			System.out.println("ERROR al buscar el votante con NIF " + NIF );
		}
		
		return v;
		
	}

	public void delete() {
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


}
