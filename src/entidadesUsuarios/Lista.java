package entidadesUsuarios;


import entidadesFilmes.Filme;

import java.io.Serializable;
import java.util.ArrayList;

public class Lista extends Publicacao implements Serializable {
	private String titulo;
	private ArrayList<Filme> Filmes;
		
	
	public Lista(int id, Usuario Usuario, String nome) {
		super(id, Usuario);
		this.titulo = nome;
		Filmes = new ArrayList<>();
	}
	
	public ArrayList<Filme> retornaFilmesDaLista(){
		return Filmes;
	}
	
	public void setFilmesDaLista(ArrayList<Filme> lista) {
		this.Filmes=lista;
	}
	
	public void setNome(String nome) {
		this.titulo = nome;
	}
	
	public String getNome() {
		return titulo;
	}
	
	public void addFilme(Filme Filme) {
		Filmes.add(Filme);
	}

	public boolean contemFilme(Filme Filme) {
		for (Filme f : Filmes) {
			if(f == Filme) 
				return true;
		}
		return false;
	}
	
	public int indiceFilme(Filme Filme) {
		return Filmes.indexOf(Filme);
	}
	
	public void removeFilme(Filme Filme) {
		Filmes.remove(Filmes.indexOf(Filme));
	}
}