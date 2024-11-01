package entidades;

public class Critica extends Publicacao {
	private String titulo;
	private String conteudo;
	private Filme Filme;
	private float nota;
	
	public Critica(String id, Usuario Usuario, String titulo, String conteudo, Filme Filme, float nota) {
		super(id, Usuario);
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.Filme = Filme;
		this.nota = nota;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public Filme getFilme() {
		return Filme;
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
