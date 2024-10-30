package principal;

import principal.Main;
import entidades.Ator;
import entidades.Diretor;
import entidades.Filme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	
//	ArrayList<Filme> todosOsFilmes = new ArrayList<>();
//	ArrayList<Ator> todosOsAtores = new ArrayList<>();
//	ArrayList<Diretor> todosOsDiretores = new ArrayList<>();
	
	static boolean flagLeitorFilmes = false;
//	boolean flagLeitorUsuarios = false;

	static String caminhoArquivoFilmes = Main.retornaCaminhoArquivo("filme");
//	String caminhoArquivoUsuarios = Main.retornaCaminhoArquivo("usuario");
	
	static BufferedReader leitorFilmes;// = new BufferedReader(new FileReader(caminhoArquivoFilmes));
//	BufferedReader leitorUsuarios;// = new BufferedReader(new FileReader(caminhoArquivoUsuarios));

	static String linha;
	
//	aqui vou aplicar uma "técnica" que um usuário do stack overflow recomendou, que é a LAZY LOADING,
//	ou seja, só inicializar o leitor quando for usá-lo, não diretamente no corpo principal da classe
	
	public static BufferedReader getLeitorFilmesAtoresDiretores() {
		try {
			leitorFilmes = new BufferedReader(new FileReader(caminhoArquivoFilmes));	
			flagLeitorFilmes = false;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return leitorFilmes;
	}
//	public BufferedReader getLeitorUsuarios() {
//		try {
//			leitorUsuarios = new BufferedReader(new FileReader(caminhoArquivoUsuarios));	
//			flagLeitorUsuarios = false;
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return leitorUsuarios;
//	}

	
	
	//função para fechar os leitores após o uso
	public static void fechaLeitores() throws IOException {
		if(flagLeitorFilmes) {
			leitorFilmes.close();
		}
//		else if(flagLeitorUsuarios) {
//			leitorUsuarios.close();
//		}
	}
	
	//função que copia os dados do arquivo CSV e os coloca dentro do arraylist	
	public static <T>  void copiaDadosDoArquivo(String caminho, BufferedReader leitor, ArrayList<Filme> arraylistFilmes, ArrayList<Ator> arraylistAtores, ArrayList<Diretor> arraylistDiretores, Class<T> classe) throws IOException{
		boolean primeiraLinha = true;
		boolean jaExiste = false;
		boolean jaExisteAtor1 = false;
		boolean jaExisteAtor2= false;
		boolean jaExisteAtor3 = false;
		while((linha = leitor.readLine())!=null) {
			//ignoramos o cabecalho
			if(primeiraLinha) {
				primeiraLinha = false;
				continue;
			}
			//agora pego o ; para separar as frases da linha para achar qual a linha do filme em questão
			String[] partesDaLinha = linha.split(";");
			//esse ".class" vai retornar um objeto da classe correnspondente em TEMPO DE EXECUÇÃO, ou seja, a classe genérica terá seu tipo explicitado durante o programa
			if(classe == Filme.class) {
				flagLeitorFilmes = true;
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataAtor1 = LocalDate.parse(partesDaLinha[9]);
				LocalDate dataAtor2 = LocalDate.parse(partesDaLinha[12]);
				LocalDate dataAtor3 = LocalDate.parse(partesDaLinha[15]);
				LocalDate dataDiretor = LocalDate.parse(partesDaLinha[6]);
				
				Ator ator1 = new Ator(Integer.parseInt(partesDaLinha[7]),partesDaLinha[8],dataAtor1);
				Ator ator2 = new Ator(Integer.parseInt(partesDaLinha[10]),partesDaLinha[11],dataAtor2);
				Ator ator3 = new Ator(Integer.parseInt(partesDaLinha[13]),partesDaLinha[14],dataAtor3);
				
				for(int i=0;i<=arraylistAtores.size();i++) {
					if(arraylistAtores.get(i).getIDAtor()==ator1.getIDAtor()) {
						jaExisteAtor1=true;
					}
					if(arraylistAtores.get(i).getIDAtor()==ator2.getIDAtor()) {
						jaExisteAtor2=true;
					}
					if(arraylistAtores.get(i).getIDAtor()==ator3.getIDAtor()) {
						jaExisteAtor3=true;
					}
				}
				if(!jaExisteAtor1) {
					arraylistAtores.add(ator1);
				}
				if(!jaExisteAtor2) {
					arraylistAtores.add(ator2);
				}
				if(!jaExisteAtor3) {
					arraylistAtores.add(ator3);
				}
				jaExisteAtor1=false;
				jaExisteAtor2=false;
				jaExisteAtor3=false;
				
				
				Diretor diretor = new Diretor(Integer.parseInt(partesDaLinha[4]),partesDaLinha[5],dataDiretor);
				
				for(int i=0;i<=arraylistDiretores.size();i++) {
					if(arraylistDiretores.get(i).getIDDiretor()==diretor.getIDDiretor()) {
						jaExiste=true;
					}
				}
				if(!jaExiste) {
					arraylistDiretores.add(diretor);
				}
				jaExiste=false;
				
				
				//verifica se o filme já existe, se não existir ele adiciona ao arraylist
				Filme filme = new Filme(Integer.parseInt(partesDaLinha[0]),partesDaLinha[1],partesDaLinha[2],diretor,Integer.parseInt(partesDaLinha[3]),ator1,ator2,ator3);
				
				for(int i=0;i<=arraylistFilmes.size();i++) {
					if(arraylistFilmes.get(i).getIDFilme()==filme.getIDFilme()) {
						jaExiste=true;
					}
				}
				if(!jaExiste) {
					arraylistFilmes.add(filme);
				}
				jaExiste=false;
			}
		}
		fechaLeitores();
	}
	
	
	
	//função para adicionar filme
	public static void adicionaFilme(Filme filme, ArrayList<Filme> arraylistFilmes) {
		arraylistFilmes.add(filme);
	}
	
	//função para remover filme
	public static void removeFilme(String nomeFilme, ArrayList<Filme> arraylistFilmes) {
		int i = buscaFilmePorNome(nomeFilme,arraylistFilmes);
		arraylistFilmes.remove(i);
	}
	
	//função para encontrar a posição do filme dentro do arraylist com todos os filmes
	private static int buscaFilmePorNome(String nome, ArrayList<Filme> arraylistFilmes) {
		for(int i=0;i<arraylistFilmes.size();i++) {
			if(arraylistFilmes.get(i).getNomeFilme()==nome) {
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
	
	//função para encontrar a posição do diretor dentro do arraylist com todos os diretores
	private static int buscaDiretorPorNome(String nome, ArrayList<Diretor> arraylistDiretores) {
		for(int i=0;i<arraylistDiretores.size();i++) {
			if(arraylistDiretores.get(i).getNomeDiretor()==nome) {
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
	
	//função para encontrar a posição do ator dentro do arraylist com todos os atores
	private static int buscaAtorPorNome(String nome, ArrayList<Ator> arraylistAtores) {
		for(int i=0;i<arraylistAtores.size();i++) {
			if(arraylistAtores.get(i).getNomeAtor()==nome) {
				return i;
			}
        }
		return -1;
	}

}
	


