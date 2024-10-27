package entidades;

import java.util.Date;

public class Critico extends Usuario {
	
	private Date dataDeAprovacao;

	public Critico(String nome, int id, Date dataDeNascimento, String senha, float pesoClassificacao, Date dataDeAprovacao) {
		super(nome, id, dataDeNascimento, senha, pesoClassificacao);
		this.dataDeAprovacao = dataDeAprovacao;
	}
	
	public Date getDataAprovacao() {
		return dataDeAprovacao;
	}
	

}