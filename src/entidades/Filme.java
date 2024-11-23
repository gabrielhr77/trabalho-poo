 package entidades;
 
import java.io.Serializable;

public class Filme implements Serializable{
	
	private String nomeFilme, generoFilme;//instancia aqui as caracteristicas dos filmes
	private int _IDFilme, anoLancamento, numeroDeEstrelas=0, numeroAvaliacoes=0;
	private float mediaNumeroDeEstrelas;
	private Ator ator1, ator2, ator3;
	private Diretor diretor;
	
	
	public Filme() {
	}

	
	public Filme(int _IDFilme, String nomeFilme, String generoFilme, Diretor diretor, int anoLancamento, Ator ator1, Ator ator2, Ator ator3) {
		this._IDFilme=_IDFilme;
		this.nomeFilme=nomeFilme;
		this.generoFilme=generoFilme;
		this.diretor=diretor;
		this.anoLancamento=anoLancamento;
		this.ator1=ator1;
		this.ator2=ator2;
		this.ator3=ator3;
		this.numeroDeEstrelas=0;
		int numeroAvaliacoes=0;
		float mediaNumeroDeEstrelas= numeroDeEstrelas/(float)numeroAvaliacoes;
	}
	
	
	
	
	
	// métodos getters
	public int getIDFilme() {
		return _IDFilme;
	}
	public String getNomeFilme() {
		return nomeFilme;
	}
	public String getGeneroFilme() {
		return generoFilme;
	}
	public Diretor getDiretor() {
		return diretor;
	}
	public Ator getAtor1() {
		return ator1;
	}
	public Ator getAtor2() {
		return ator2;
	}
	public Ator getAtor3() {
		return ator3;
	}
	/*public String[] getAtoresPrincipais() {
		return atoresPrincipais[];
	}*/
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public int getNumeroDeEstrelas() {
		return numeroDeEstrelas;
	}
	public float getMediaNumeroDeEstrelas() {
		return mediaNumeroDeEstrelas;
	}
	
	// métodos setters
	
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme=nomeFilme;
	}
	public void setGeneroFilme(String generoFilme) {
		this.generoFilme=generoFilme;
	}
	public void setDiretor(Diretor diretor) {
		this.diretor=diretor;
	}
	public void setAtor1(Ator ator1) {
		this.ator1=ator1;
	}
	public void setAtor2(Ator ator2) {
		this.ator2=ator2;
	}
	public void setAtor3(Ator ator3) {
		this.ator3=ator3;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento=anoLancamento;
	}
	public void adicionaEstrelas(Filme filme, int numeroDeEstrelas) {
		filme.numeroDeEstrelas+=numeroDeEstrelas;
	}
	
	
	
}
