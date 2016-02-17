package es.uniovi.asw.dbUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.uniovi.asw.parser.Votante;

public class InsertP implements Insert {
	


	public boolean validarVotante(Votante v) {
		if (!v.getNombre().isEmpty() && !v.getNIF().isEmpty()
				&& !v.getEmail().isEmpty() && v.getCodColegioElectoral() >= 0
				&& !v.getPassword().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void insertar(Votante v) {
		
		if(!validarVotante(v)){
			throw new IllegalArgumentException("El votante tiene alguún atributo con un valor invalido");
		}
		
		Connection c;
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("INSERT INTO CENSOS VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, v.getNombre());
			ps.setString(2, v.getNIF());
			ps.setString(3, v.getEmail());
			ps.setInt(4, v.getCodColegioElectoral());
			ps.setString(5, v.getPassword());
			ps.execute();
			
			System.out.println("El usuario del cliente +" + v.getNombre() + " es " 
			+ " y su contraseña es " + v.getPassword());
			
			ps.close();
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
