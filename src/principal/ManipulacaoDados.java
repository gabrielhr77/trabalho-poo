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
		for(int i=0;i<Main.retornaArrayListUsuarios().size();i++) {
			if(Main.retornaArrayListUsuarios().get(i).getNome().equals(usuario)) {
				if(Main.retornaArrayListUsuarios().get(i).getSenha().equals(senha));
				return true;
			}
		}
		return false;
	}

	public static boolean verificaNomeExistente(String usuario) {
        ArrayList<Usuario> usuarios = Main.retornaArrayListUsuarios(); 
        for(int i=0;i<usuarios.size();i++) {
            if(usuarios.get(i).getNome().equals(usuario)){
                return true;
            }
        }
        return false;
    }
    
    public static Usuario buscaUsuarioPorNome(String nomeUsuario) {
        ArrayList<Usuario> usuarios = Main.retornaArrayListUsuarios(); 
        for(int i=0;i<usuarios.size();i++) {
            if(usuarios.get(i).getNome().equalsIgnoreCase(nomeUsuario)){
                return usuarios.get(i);
            }
        }
        return null;
    }
	
	
    public static void adicionaComentario(Usuario Usuario, Filme Filme, String conteudo, ArrayList<Comentario> comentarios) {
        int id = 2000000 + comentarios.size();
        Comentario comment = new Comentario(id, Usuario, Filme, conteudo);
        comentarios.add(comment);
    }
    
    public static void adicionaCritica(Usuario Usuario, Filme Filme, String titulo, String conteudo, float nota, ArrayList<Critica> criticas) {
        int id = 3000000 + criticas.size();
        Critica review = new Critica(id, Usuario, titulo, conteudo, Filme, nota);
        criticas.add(review);
    }
    
    public static void removeComentario(int id, ArrayList<Comentario> comentarios) {
        int i = buscaComentario(id, comentarios);
        comentarios.remove(i);
    }
    
    public static void removeCritica(int id, ArrayList<Critica> criticas) {
        int i = buscaCritica(id, criticas);
        criticas.remove(i);
    }
    
    public static int buscaComentario(int id, ArrayList<Comentario> comentarios) {
        for(int i=0;i<comentarios.size();i++) {
            if(comentarios.get(i).getID() == id){
                return i;
            }
        }
        return -1;
    }
    
    public static int buscaCritica(int id, ArrayList<Critica> criticas) {
        for(int i=0;i<criticas.size();i++) {
            if(criticas.get(i).getID() == id){
                return i;
            }
        }
        return -1;
    }
    
    
    
//função para buscar todos os comentários sobre um filme
    public static ArrayList<Comentario> buscaComentariosFilme(int idFilme, ArrayList<Comentario> comentarios){
        ArrayList<Comentario> lista = new ArrayList<>();
        for(int i=0; i<comentarios.size(); i++) {
            if(comentarios.get(i).getFilme().getIDFilme() == idFilme) {
                lista.add(comentarios.get(i));
            }
        }
        return lista;
    }
    
    //função para buscar todas as críticas sobre um filme
    public static ArrayList<Critica> buscaCriticasFilme(int idFilme, ArrayList<Critica> criticas){
        ArrayList<Critica> lista = new ArrayList<>();
        for(int i=0; i<criticas.size(); i++) {
            if(criticas.get(i).getFilme().getIDFilme() == idFilme) {
                lista.add(criticas.get(i));
            }
        }
        return lista;
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