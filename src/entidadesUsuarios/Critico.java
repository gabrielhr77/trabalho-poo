package entidadesUsuarios;

/*Essa classe provavelmente não será mais usada. Lembrar de apagar antes de ser concluída a versão definitiva do projeto*/



import java.util.Date;

public class Critico extends Usuario {
	
	private Date dataDeAprovacao;

	public Critico(String nome, int id, String senha, float pesoClassificacao, Date dataDeAprovacao) {
		super(nome, id, senha, pesoClassificacao);
		this.dataDeAprovacao = dataDeAprovacao;
	}
	
	public Date getDataAprovacao() {
		return dataDeAprovacao;
	}
	

}