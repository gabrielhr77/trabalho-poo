
package entidades;

import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private int id;
    private Date dataDeNascimento;
    
    public Pessoa(String nome, int id, Date dataDeNascimento) {
        this.nome = nome;
        this.id = id;
        this.dataDeNascimento = dataDeNascimento;
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
    
    public void setData(Date data) {
        this.dataDeNascimento = data;
    }
    
    public Date getData() {
        return this.dataDeNascimento;
    }
    
}

