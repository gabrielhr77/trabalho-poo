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

public class Catalogo {
	
	ArrayList<Filme> todosOsFilmes = new ArrayList<>();
	ArrayList<Ator> todosOsAtores = new ArrayList<>();
	ArrayList<Diretor> todosOsDiretores = new ArrayList<>();
	
	boolean flagLeitorFilmes = false;
//	boolean flagLeitorAtores = false;
//	boolean flagLeitorDiretores = false;

	String caminhoArquivoFilmes = Main.retornaCaminhoArquivo("filme");
//	String caminhoArquivoAtores = Main.retornaCaminhoArquivo("ator");
//	String caminhoArquivoDiretores = Main.retornaCaminhoArquivo("diretor");
	
	BufferedReader leitorFilmes;// = new BufferedReader(new FileReader(caminhoArquivoFilmes));
//	BufferedReader leitorAtores;// = new BufferedReader(new FileReader(caminhoArquivoAtores));
//	BufferedReader leitorDiretores;// = new BufferedReader(new FileReader(caminhoArquivoDiretores));
	
	String linha;
	
//	aqui vou aplicar uma "técnica" que um usuário do stack overflow recomendou, que é a LAZY LOADING,
//	ou seja, só inicializar o leitor quando for usá-lo, não diretamente no corpo principal da classe
	
	public BufferedReader getLeitorFilmes() {
		try {
			leitorFilmes = new BufferedReader(new FileReader(caminhoArquivoFilmes));	
			flagLeitorFilmes = false;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return leitorFilmes;
	}
//	public BufferedReader getLeitorAtores() {
//		try {
//			leitorAtores = new BufferedReader(new FileReader(caminhoArquivoAtores));	
//			flagLeitorAtores = false;
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return leitorAtores;
//	}
//	public BufferedReader getLeitorDiretores() {
//		try {
//			leitorDiretores = new BufferedReader(new FileReader(caminhoArquivoDiretores));	
//			flagLeitorDiretores = true;
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return leitorDiretores;
//	}
	
	//função para fechar os leitores após o uso
	public void fechaLeitores() throws IOException {
		if(flagLeitorFilmes) {
			leitorFilmes.close();
		}
//		if(flagLeitorAtores) {
//			leitorAtores.close();
//		}
//		if(flagLeitorDiretores) {
//			leitorDiretores.close();
//		}
	}
	
	

	//função que recebe o caminho do arquivo e um arraylist de tipo, como visto em aula, genérico
	public <T> void copiaDadosDoArquivo(String caminho, BufferedReader leitor, ArrayList<T> arraylist, Class<T> classe) throws IOException{
		boolean primeiraLinha = true;
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
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataAtor1 = LocalDate.parse(partesDaLinha[9]);
				LocalDate dataAtor2 = LocalDate.parse(partesDaLinha[12]);
				LocalDate dataAtor3 = LocalDate.parse(partesDaLinha[15]);
				LocalDate dataDiretor = LocalDate.parse(partesDaLinha[6]);
				
				Ator ator1 = new Ator(Integer.parseInt(partesDaLinha[7]),partesDaLinha[8],dataAtor1);
				Ator ator2 = new Ator(Integer.parseInt(partesDaLinha[10]),partesDaLinha[11],dataAtor2);
				Ator ator3 = new Ator(Integer.parseInt(partesDaLinha[13]),partesDaLinha[14],dataAtor3);
				
				Diretor diretor = new Diretor(Integer.parseInt(partesDaLinha[4]),partesDaLinha[5],dataDiretor);
				
				Filme filme = new Filme(Integer.parseInt(partesDaLinha[0]),partesDaLinha[1],partesDaLinha[2],diretor,Integer.parseInt(partesDaLinha[3]),ator1,ator2,ator3);
				
				todosOsFilmes.add(filme);
			}
		//pego o arquivo aberto, pego as infos e crio as instancias para colocar nos arrays, tudo isso dentro de um método
		}
	}
}
	


