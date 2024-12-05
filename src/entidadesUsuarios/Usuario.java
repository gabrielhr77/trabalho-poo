package entidadesUsuarios;


import java.io.Serializable;
import java.util.Date;

public class Usuario extends Pessoa implements Serializable {

    private String senha;
    private boolean flagSuspenso;
    private float pesoClassificacao;
    private boolean critico,gerenciador;
    public boolean pediuParaSerCritico;
    private Date dataDeAprovacao;
    public int quantidadeComentarios,quantidadeCriticas,quantidadeListas;

    public Usuario() {
    	
    }
    public Usuario(String nome, int id, String senha, float pesoClassificacao){
        super (nome, id);
        this.senha = senha;
        this.flagSuspenso = false;
        this.pesoClassificacao = pesoClassificacao;
        this.critico = false;
        this.pediuParaSerCritico=false;
        this.quantidadeComentarios=0;
        this.quantidadeCriticas=0;
        this.quantidadeListas=0;
        this.gerenciador=false;
    }
    
    public void aumentaUmaCritica() {
    	this.quantidadeCriticas++;
    }
    
    public int getQuantidadeCriticas() {
    	return this.quantidadeCriticas;
    }
    
    public void aumentaUmComentario() {
    	this.quantidadeComentarios++;
    }
   
    public int getQuantidadeComentarios() {
    	return this.quantidadeComentarios;
    }
    
    public void aumentaUmaLista() {
    	this.quantidadeListas++;
    }
    
    public int getQuantidadeListas() {
    	return this.quantidadeListas;
    }

    
    public void pediuParaSerCritico() {
    	this.pediuParaSerCritico=true;
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
    
    public void setGerenciador() {
    	this.gerenciador=true;
    }

    public void setCritico(){
        this.critico = true;
        pesoClassificacao *= 5;
    }

    public Date getDataAprovacao() {
		return dataDeAprovacao;
	}

    public boolean isCritico(){
        return critico;
    }


}



