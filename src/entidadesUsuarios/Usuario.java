package entidadesUsuarios;

import java.util.Date;

public class Usuario extends Pessoa{

    private String senha;
    private boolean flagSuspenso;
    private float pesoClassificacao;
    private boolean critico;
    private Date dataDeAprovacao;

    public Usuario(String nome, int id, Date dataDeNascimento, String senha, float pesoClassificacao){
        super (nome, id, dataDeNascimento);
        this.senha = senha;
        this.flagSuspenso = false;
        this.pesoClassificacao = pesoClassificacao;
        this.critico = false;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha() {
    	return senha;
    }


    public void setPesoClassificacao(float peso){
        this.pesoClassificacao = peso;
    }
    
    public float getPesoClassificacao() {
    	return pesoClassificacao;
    }


    public void suspender(boolean suspender){
        this.flagSuspenso = suspender;
    }

    public boolean isSuspenso(){
        return flagSuspenso;
    }

    public boolean verificaSenha(String senha){
        return senha.equals(this.senha);
    }
    
    public boolean isGerenciador() {
		return false;
	}

    public void setCritico(){
        this.critico = true;
        pesoClassificacao *= 2;
    }

    public Date getDataAprovacao() {
		return dataDeAprovacao;
	}

    public boolean isCritico(){
        return critico;
    }

}
