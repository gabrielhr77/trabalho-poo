package entidadesUsuarios;

import java.io.Serializable;

public class Publicacao implements Serializable {
	private int id;
	private Usuario Usuario;
	
	public Publicacao(int id, Usuario Usuario) {
		this.id = id;
		this.Usuario = Usuario;
	}
	
	public int getID() {
		return id;
	}
	
	public Usuario getUsuario() {
		return Usuario;
	}
}