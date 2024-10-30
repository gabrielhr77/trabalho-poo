package entidades;

import java.util.ArrayList;

public class Lista extends Publicacao {
	private String titulo;
	private ArrayList<String> idFilmes;
		
	
	public Lista(String id, String idUsuario, String nome) {
		super(id, idUsuario);
		this.titulo = nome;
		idFilmes = new ArrayList<>();
	}
	
	public void setNome(String nome) {
		this.titulo = nome;
	}
	
	public String getNome() {
		return titulo;
	}
	
	public void addFilme(String idFilme) {
		idFilmes.add(idFilme);
	}

	public boolean contemFilme(String idFilme) {
		for (String s : idFilmes) {
			if(s.equals(idFilme)) 
				return true;
		}
		return false;
	}
	
	public int indiceFilme(String idFilme) {
		return idFilmes.indexOf(idFilme);
	}
	
	public void removeFilme(String idFilme) {
		idFilmes.remove(idFilmes.indexOf(idFilme));
	}
}
