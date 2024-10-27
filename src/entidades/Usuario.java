package entidades;

import java.util.Date;

public class Usuario extends Pessoa{

    private String senha;
    private boolean flagSuspenso;
    private float pesoClassificacao;

    public Usuario(String nome, int id, Date dataDeNascimento, String senha, float pesoClassificacao){
        super (nome, id, dataDeNascimento);
        this.senha = senha;
        this.flagSuspenso = false;
        this.pesoClassificacao = pesoClassificacao;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }


    public void setPesoClassificacao(float peso){
        this.pesoClassificacao = peso;
    }


    public void suspender(boolean suspender){
        this.flagSuspenso = suspender;
    }

    public boolean isSuspenso(){
        return flagSuspenso;
    }

    public boolean verificaSenha(String senha){
        if(senha.equals(this.senha))
            return true;
        return false;
    }

}
