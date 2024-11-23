package principal;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;

import principal.Main;
import entidades.Ator;
import entidades.Diretor;
import entidades.Filme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
	
	public static <T> void salvaLista(String caminho, ArrayList<T> lista) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho)))
	    {
	        oos.writeObject(lista);
	        System.out.println("Lista salva no arquivo com sucesso.");
	    }
	    catch (IOException e)
	    {
	        System.err.println("Erro ao salvar a lista: " + e.getMessage());
	    }
	}
	
	//Teste para serialização
	/*public static void salva2(String caminho, ArrayList<Filme> arraylistFilmes) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho));
			oos.writeObject(arraylistFilmes);
			oos.close();
		}catch(FileNotFoundException fnfe) {
			System.err.println("Não foi possível abrir o arquivo");
			System.err.println(fnfe);
		}catch(InvalidClassException ice) {
			System.err.println(ice);
		}catch(NotSerializableException nse) {
			System.err.println(nse);
		}catch(IOException ioe) {
			System.err.println(ioe);
		}
		
		
	}*/
	public static <T> ArrayList<T> carregaLista(String caminho){
		ArrayList<T> listaCarregada = null;
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho)))
	    {
	        listaCarregada = (ArrayList<T>) ois.readObject(); // faz um cast para ArrayList<Pessoa>, lembrando que Pessoa implementa Serializable
	    }
	    catch (IOException | ClassNotFoundException e)
	    {
	        System.err.println("Erro ao carregar a lista: " + e.getMessage());
	    }	
	    return listaCarregada;
	}
	
	//TENHO QUE TER UMA FUNÇÃO IGUAL A ESSA NA CLASSE DE MEIO-CAMPO DOS USUÁRIOS
	//função que copia os dados do arquivo CSV e os coloca dentro do arraylist	
	public static void copiaDadosDoArquivo(String caminho, BufferedReader leitor, ArrayList<Filme> arraylistFilmes, ArrayList<Ator> arraylistAtores, ArrayList<Diretor> arraylistDiretores) throws IOException{
		boolean primeiraLinha = true;
		boolean primeiroCicloFilmes = true;
		boolean primeiroCicloAtores = true;
		boolean primeiroCicloDiretores = true;
		
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
				
			flagLeitorFilmes = true;
			LocalDate dataAtor1 = LocalDate.parse(partesDaLinha[9]);
			LocalDate dataAtor2 = LocalDate.parse(partesDaLinha[12]);
			LocalDate dataAtor3 = LocalDate.parse(partesDaLinha[15]);
			LocalDate dataDiretor = LocalDate.parse(partesDaLinha[6]);
			
			Ator ator1 = new Ator(Integer.parseInt(partesDaLinha[7]),partesDaLinha[8],dataAtor1);
			Ator ator2 = new Ator(Integer.parseInt(partesDaLinha[10]),partesDaLinha[11],dataAtor2);
			Ator ator3 = new Ator(Integer.parseInt(partesDaLinha[13]),partesDaLinha[14],dataAtor3);
			
			if(!primeiroCicloAtores) {
				for(int i=0;i<arraylistAtores.size();i++) {
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
			}else {
				arraylistAtores.add(ator1);
				arraylistAtores.add(ator2);
				arraylistAtores.add(ator3);
			}
			primeiroCicloAtores = false;
			jaExisteAtor1=false;
			jaExisteAtor2=false;
			jaExisteAtor3=false;
			
			
			Diretor diretor = new Diretor(Integer.parseInt(partesDaLinha[4]),partesDaLinha[5],dataDiretor);
			if(!primeiroCicloDiretores)	{
				for(int i=0;i<arraylistDiretores.size();i++) {
					if(arraylistDiretores.get(i).getIDDiretor()==diretor.getIDDiretor()) {
						jaExiste=true;
					}
				}
				if(!jaExiste) {
					arraylistDiretores.add(diretor);
				}
				jaExiste=false;	
			}else {
				arraylistDiretores.add(diretor);
			}
			
			//verifica se o filme já existe, se não existir ele adiciona ao arraylist
			Filme filme = new Filme(Integer.parseInt(partesDaLinha[0]),partesDaLinha[1],partesDaLinha[2],diretor,Integer.parseInt(partesDaLinha[3]),ator1,ator2,ator3);
			
			if(!primeiroCicloFilmes) {
				for(int i=0;i<arraylistFilmes.size();i++) {
					if(arraylistFilmes.get(i).getIDFilme()==filme.getIDFilme()) {
						jaExiste=true;
					}
				}
				if(!jaExiste) {
					arraylistFilmes.add(filme);
				}
			
				jaExiste=false;
			}else {
				arraylistFilmes.add(filme);
			}
			
		}
		fechaLeitores();

	}
	
	
	//função que salva os dados do arraylist no arquivo CSV ao finalizar o programa
	public static <T> void salvaDadosNoArquivo(String caminho, File arquivo, ArrayList<Filme> lista) throws IOException {
		boolean existe = arquivo.exists();
		//abro o escritor com o Charset de símbolos do português
		FileWriter escritor = new FileWriter(caminho, StandardCharsets.ISO_8859_1,existe);
		if(!existe) {
			escritor.write("FILME_ID;FILME_NOME;GENERO;ANO_LANCAMENTO;DIRETOR_ID;DIRETOR_NOME;DIR_DATA_NASC;ATOR1_ID;ATOR1_NOME;ATOR1_DATA_NASC;ATOR2_ID;ATOR2_NOME;ATOR2_DATA_NASC;ATOR3_ID;ATOR3_NOME;ATOR3_DATA_NASC\n");
		}
		//escrevo os dados no arquivo
		for(int i=0;i<lista.size();i++) {
			escritor.write(lista.get(i).getIDFilme()+";"+lista.get(i).getNomeFilme()+";"+lista.get(i).getGeneroFilme()+";"+lista.get(i).getAnoLancamento()+";"+lista.get(i).getDiretor().getIDDiretor()+";"+lista.get(i).getDiretor().getNomeDiretor()+";"+lista.get(i).getDiretor().getDataNascimentoDiretor()+";"+lista.get(i).getAtor1().getIDAtor()+";"+lista.get(i).getAtor1().getNomeAtor()+";"+lista.get(i).getAtor1().getDataNascimentoAtor()+";"+lista.get(i).getAtor2().getIDAtor()+";"+lista.get(i).getAtor2().getNomeAtor()+";"+lista.get(i).getAtor2().getDataNascimentoAtor()+";"+lista.get(i).getAtor3().getIDAtor()+";"+lista.get(i).getAtor3().getNomeAtor()+";"+lista.get(i).getAtor3().getDataNascimentoAtor()+"\n");
			escritor.flush();
		}
		escritor.close();
	
	
	}
	
	
	
	//funções para filme
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
			if(arraylistFilmes.get(i).getNomeFilme().equals(nome)) {
				return i;
			}
        }
		return -1;
	}

	
	//funções para diretor
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
			if(arraylistDiretores.get(i).getNomeDiretor().equals(nome)) {
				return i;
			}
        }
		return -1;
	}
	
	
	//funções para ator
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
			if(arraylistAtores.get(i).getNomeAtor().equals(nome)) {
				return i;
			}
        }
		return -1;
	}

}
	

