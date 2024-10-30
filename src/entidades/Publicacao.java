package entidades;

public class Publicacao {
	private String id;
	private String idUsuario;
	
	public Publicacao(String id, String idUsuario) {
		this.id = id;
		this.idUsuario = idUsuario;
	}
	
	public String getID() {
		return id;
	}
	
	public String getIDUsuario() {
		return idUsuario;
	}
}
