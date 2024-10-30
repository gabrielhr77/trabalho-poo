package entidades;

public class Comentario extends Publicacao {
	private String conteudo;
	private String idFilme;
	
	public Comentario(String id, String idUsuario, String idFilme, String conteudo) {
		super(id, idUsuario);
		this.idFilme = idFilme;
		this.conteudo = conteudo;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public String getIDFilme() {
		return idFilme;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
