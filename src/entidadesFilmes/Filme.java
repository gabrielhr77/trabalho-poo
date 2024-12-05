
package entidadesFilmes;

import java.io.Serializable;

public class Filme implements Serializable {
	
	private String nomeFilme,horas,minutos;
	private int _IDFilme, anoLancamento, numeroDeEstrelas=0, numeroAvaliacoes=0,faixaEtaria;
	private float mediaNumeroDeEstrelas;
//	private Ator ator1, ator2, ator3;
//	private Diretor diretor;
	private String diretor,ator1,ator2,ator3,sinopse;
	
	public Filme() {
	}

	
	public Filme(int _IDFilme, String nomeFilme, String diretor, int anoLancamento, String ator1, String ator2, String ator3, String horas, String minutos, int faixaEtaria, String sinopse) {
		this._IDFilme=_IDFilme;
		this.nomeFilme=nomeFilme;
		this.diretor=diretor;
		this.anoLancamento=anoLancamento;
		this.ator1=ator1;
		this.ator2=ator2;
		this.ator3=ator3;
		this.numeroDeEstrelas=0;
		int numeroAvaliacoes=0;
		float mediaNumeroDeEstrelas= numeroDeEstrelas/(float)numeroAvaliacoes;
		this.horas=horas;
		this.minutos=minutos;
		this.faixaEtaria=faixaEtaria;
		this.sinopse=sinopse;
	}
	
	
	
	
	// métodos getters
	public int getFaixaEtaria() {
		return faixaEtaria;
	}
	public String getSinopse() {
		return sinopse;
	}
	public int getIDFilme() {
		return _IDFilme;
	}
	public String getNomeFilme() {
		return nomeFilme;
	}
	public String getHorasFilme() {
		return horas;
	}
	public String getMinutosFilme() {
		return minutos;
	}

//	public Diretor getDiretor() {
//		return diretor;
//	}
//	public Ator getAtor1() {
//		return ator1;
//	}
//	public Ator getAtor2() {
//		return ator2;
//	}
//	public Ator getAtor3() {
//		return ator3;
//	}
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
	public void setSinopse(String sinopse) {
		this.sinopse=sinopse;
	}
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme=nomeFilme;
	}

//	public void setDiretor(Diretor diretor) {
//		this.diretor=diretor;
//	}
//	public void setAtor1(Ator ator1) {
//		this.ator1=ator1;
//	}
//	public void setAtor2(Ator ator2) {
//		this.ator2=ator2;
//	}
//	public void setAtor3(Ator ator3) {
//		this.ator3=ator3;
//	}
	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria=faixaEtaria;
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
	public void setHoras(String horas) {
		this.horas=horas;
	}
	public void setMinutos(String minutos) {
		this.minutos=minutos;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento=anoLancamento;
	}
	public void adicionaEstrelas(Filme filme, int numeroDeEstrelas) {
		filme.numeroDeEstrelas+=numeroDeEstrelas;
	}
	
	
	
}

