package entidadesUsuarios;

import java.util.Date;

public class Gerenciador extends Pessoa {

	private String senha;
	
	public Gerenciador(String nome, int id, Date dataDeNascimento, String senha) {
		super(nome, id, dataDeNascimento);
		this.senha = senha;
	}
	
	public String getSenha(){
		return senha;
	}

	public boolean verificaSenha(String senha){
		return senha.equals(this.senha);
	}
	
	public boolean isGerenciador() {
		return true;
	}
}