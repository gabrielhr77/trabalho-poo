package entidades;

public class Publicacao {
	private String id;
	private Usuario Usuario;
	
	public Publicacao(String id, Usuario Usuario) {
		this.id = id;
		this.Usuario = Usuario;
	}
	
	public String getID() {
		return id;
	}
	
	public Usuario getUsuario() {
		return Usuario;
	}
}
