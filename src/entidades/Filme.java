 package entidades;
 
import java.io.Serializable;

public class Filme implements Serializable{
	
	private String nomeFilme, generoFilme;//instancia aqui as caracteristicas dos filmes
	private int anoLancamento, numeroDeEstrelas=0, numeroAvaliacoes=0;
	private float mediaNumeroDeEstrelas;
	private int _IDAtor1, _IDAtor2, _IDAtor3;
	private int _IDDiretor;
	private int _IDFilme;
	
	
	public Filme() {
	}

	
	public Filme(int _IDFilme, String nomeFilme, String generoFilme, int diretor, int anoLancamento, int ator1, int ator2, int ator3) {
		this._IDFilme=_IDFilme;
		this.nomeFilme=nomeFilme;
		this.generoFilme=generoFilme;
		this._IDDiretor=diretor;
		this.anoLancamento = anoLancamento;
		this._IDAtor1=ator1;
		this._IDAtor2=ator2;
		this._IDAtor3=ator3;
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
	public int getDiretor() {
		return _IDDiretor;
	}
	public int getAtor1() {
		return _IDAtor1;
	}
	public int  getAtor2() {
		return _IDAtor2;
	}
	public int getAtor3() {
		return _IDAtor3;
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
	public void setDiretor(int  diretor) {
		this._IDDiretor=diretor;
	}
	public void setAtor1(int  ator1) {
		this._IDAtor1=ator1;
	}
	public void setAtor2(int ator2) {
		this._IDAtor2=ator2;
	}
	public void setAtor3(int ator3) {
		this._IDAtor3=ator3;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento=anoLancamento;
	}
	public void adicionaEstrelas(Filme filme, int numeroDeEstrelas) {
		filme.numeroDeEstrelas+=numeroDeEstrelas;
	}
	
	
	
}
