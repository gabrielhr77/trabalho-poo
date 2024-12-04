package entidadesUsuarios;

import java.io.Serializable;

//import java.util.Date;

public abstract class Pessoa implements Serializable {
    private String nome;
    private int id;
    
    public Pessoa() {
    	
    }
    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getID() {
        return this.id;
    }
    
    public abstract boolean isGerenciador();
    
}