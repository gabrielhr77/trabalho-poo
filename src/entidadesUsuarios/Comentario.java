package entidadesUsuarios;
import entidadesFilmes.Filme;

public class Comentario extends Publicacao {
	private String conteudo;
	private Filme Filme;
	
	public Comentario(int id, Usuario Usuario, Filme Filme, String conteudo) {
		super(id, Usuario);
		this.Filme = Filme;
		this.conteudo = conteudo;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public Filme getFilme() {
		return Filme;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}