package es.uniovi.asw.parser;

public class Votante {
	
	private String nombre;
	private String NIF;
	private String email;
	private int codColegioElectoral;
	private String password;
	
	
	public Votante(String nombre, String nIF, String email,
			int codColegioElectoral, String password) {
		super();
		this.nombre = nombre;
		NIF = nIF;
		this.email = email;
		this.codColegioElectoral = codColegioElectoral;
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNIF() {
		return NIF;
	}


	public void setNIF(String nIF) {
		NIF = nIF;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getCodColegioElectoral() {
		return codColegioElectoral;
	}


	public void setCodColegioElectoral(int codColegioElectoral) {
		this.codColegioElectoral = codColegioElectoral;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
