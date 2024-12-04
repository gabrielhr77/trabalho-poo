package principal;

import principal.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;

import entidadesFilmes. *;
import entidadesUsuarios. *;

public class ManipulacaoDados {
	
	//-----------------------------------------------USUÁRIOS-----------------------------------------------
	
	public static boolean verificaLoginESenha(String usuario, String senha) {
		ArrayList<Usuario> usuarios = Main.retornaArrayListUsuarios(); 
		for(int i=0;i<usuarios.size();i++) {
			if(usuarios.get(i).getNome()==usuario) {
				if(usuarios.get(i).getSenha()==senha);
				return true;
			}
		}
		return false;
	}

	
	
	
	
	
	
	//-------------------------------------FILMES, ATORES E DIRETORES----------------------------------------
	
	//função para adicionar filme
	public static void adicionaFilme(Filme filme, ArrayList<Filme> arraylistFilmes) {
		arraylistFilmes.add(filme);
	}
	
	//função para remover filme
	public static void removeFilme(String nomeFilme, ArrayList<Filme> arraylistFilmes) {
		int i = buscaFilmePorNome(nomeFilme,arraylistFilmes);
		arraylistFilmes.remove(i);
	}
	
	//função para encontrar a posição do filme no arraylist/ver se ele já existe (se nao existe retorna um valor negativo)
	private static int buscaFilmePorNome(String nome, ArrayList<Filme> arraylistFilmes) {

		for(int i=0;i<arraylistFilmes.size();i++) {
			if(arraylistFilmes.get(i).getNomeFilme().equals(nome)) {
				return i;
			}
	    }
		return -1;
	}
	
	
	//função para adicionar diretor
	public static void adicionaDiretor(Diretor diretor, ArrayList<Diretor> arraylistDiretores) {
		arraylistDiretores.add(diretor);
	}
	
	//função para remover diretor
	public static void removeDiretor(String nomeDiretor, ArrayList<Diretor> arraylistDiretores) {
		int i = buscaDiretorPorNome(nomeDiretor,arraylistDiretores);
		arraylistDiretores.remove(i);
	}
	
	//função para encontrar a posição do diretor no arraylist/ver se ele já existe (se nao existe retorna um valor negativo)
	private static int buscaDiretorPorNome(String nome, ArrayList<Diretor> arraylistDiretores) {
		for(int i=0;i<arraylistDiretores.size();i++) {
			if(arraylistDiretores.get(i).getNomeDiretor().equals(nome)) {
				return i;
			}
	    }
		return -1;
	}
	
	
	//função para adicionar ator
	public static void adicionaAtor(Ator ator, ArrayList<Ator> arraylistAtores) {
			arraylistAtores.add(ator);
		}
		
	//função para remover ator
	public static void removeAtor(String nomeAtor, ArrayList<Ator> arraylistAtores) {
		int i = buscaAtorPorNome(nomeAtor,arraylistAtores);
		arraylistAtores.remove(i);
	}
	
	//função para encontrar a posição do ator no arraylist/ver se ele já existe (se nao existe retorna um valor negativo)
	private static int buscaAtorPorNome(String nome, ArrayList<Ator> arraylistAtores) {
		for(int i=0;i<arraylistAtores.size();i++) {
			if(arraylistAtores.get(i).getNomeAtor().equals(nome)) {
				return i;
			}
	       }
		return -1;
	}	
	
	
}