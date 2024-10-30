package entidades;

public class Critica extends Publicacao {
	private String titulo;
	private String conteudo;
	private String idFilme;
	private float nota;
	
	public Critica(String id, String idUsuario, String titulo, String conteudo, String idFilme, float nota) {
		super(id, idUsuario);
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.idFilme = idFilme;
		this.nota = nota;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public String getIDFilme() {
		return idFilme;
	}
	
	public float getNota() {
		return nota;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}
	
}
