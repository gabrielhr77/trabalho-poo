package entidades;
public class Filme {
	
	private String nomeFilme, generoFilme, diretor, ator1, ator2, ator3;//instancia aqui as caracteristicas dos filmes
	private int anoLancamento, numeroDeEstrelas=0, auxNumeroDeEstrelas=0, numeroAvaliacoes;
	private float mediaNumeroDeEstrelas;
	
	
	
	
	public Filme() {
	}
	public Filme(String nomeFilme, String generoFilme, String diretor, int anoLancamento, String ator1, String ator2, String ator3) {
		this.nomeFilme=nomeFilme;
		this.generoFilme=generoFilme;
		this.diretor=diretor;
		this.anoLancamento=anoLancamento;
		this.ator1=ator1;
		this.ator2=ator2;
		this.ator3=ator3;
		int numeroDeEstrelas=0;
		auxNumeroDeEstrelas+=numeroDeEstrelas;
		numeroDeEstrelas=0;
		//float mediaNumeroDeEstrelas = auxNumeroDeEstrelas/numeroAvaliacoes;
	}
	
	
	
	
	
	// métodos getters
	
	public String getNomeFilme() {
		return nomeFilme;
	}
	public String getGeneroFilme() {
		return generoFilme;
	}
	public String getDiretor() {
		return diretor;
	}
	public String getAtor1() {
		return ator1;
	}
	public String getAtor2() {
		return ator2;
	}
	public String getAtor3() {
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
	public void setDiretor(String diretor) {
		this.diretor=diretor;
	}
	public void setAtor1(String ator1) {
		this.ator1=ator1;
	}
	public void setAtor2(String ator2) {
		this.ator2=ator2;
	}
	public void setAtor3(String ator3) {
		this.ator3=ator3;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento=anoLancamento;
	}
	public void setNumeroDeEstrelas(int numeroDeEstrelas) {
		this.numeroDeEstrelas=numeroDeEstrelas;
	}
	public void setMediaNumeroDeEstrelas(float mediaNumeroDeEstrelas) {
		this.mediaNumeroDeEstrelas=mediaNumeroDeEstrelas;
	}
	
	
}
