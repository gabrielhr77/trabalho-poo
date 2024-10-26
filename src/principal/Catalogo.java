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
import java.util.ArrayList;

public class Catalogo {
	
	ArrayList<Filme> todosOsFilmes = new ArrayList<>();
	ArrayList<Ator> todosOsAtores = new ArrayList<>();
	ArrayList<Diretor> todosOsDiretores = new ArrayList<>();
	
	boolean flagLeitorFilmes = false;
	boolean flagLeitorAtores = false;
	boolean flagLeitorDiretores = false;

	String caminhoArquivoFilmes = Main.retornaCaminhoArquivo("filme");
	String caminhoArquivoAtores = Main.retornaCaminhoArquivo("ator");
	String caminhoArquivoDiretores = Main.retornaCaminhoArquivo("diretor");
	
	BufferedReader leitorFilmes;// = new BufferedReader(new FileReader(caminhoArquivoFilmes));
	BufferedReader leitorAtores;// = new BufferedReader(new FileReader(caminhoArquivoAtores));
	BufferedReader leitorDiretores;// = new BufferedReader(new FileReader(caminhoArquivoDiretores));
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
	public BufferedReader leitorAtores() {
		try {
			leitorAtores = new BufferedReader(new FileReader(caminhoArquivoAtores));	
			flagLeitorAtores = false;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return leitorAtores;
	}
	public BufferedReader leitorDiretores() {
		try {
			leitorDiretores = new BufferedReader(new FileReader(caminhoArquivoDiretores));	
			flagLeitorDiretores = true;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return leitorDiretores;
	}
	//função para fechar os leitores após o uso
	public void fechaLeitores() throws IOException {
		if(flagLeitorFilmes) {
			leitorFilmes.close();
		}
		if(flagLeitorAtores) {
			leitorAtores.close();
		}
		if(flagLeitorDiretores) {
			leitorDiretores.close();
		}
	}
	
	

	//função que recebe o caminho do arquivo e um arraylist de tipo, como visto em aula, genérico
	public <T> void copiaDadosDoArquivo(String caminho, ArrayList<T> arraylist) {
		if(arraylist instanceof ArrayList<Filme>) {
			System.out.println("filme");
		}
		
//		if(caminho = )
//		while((linha = leitor.readLine())!=null) {
//			//ignoramos o cabecalho
//			if(primeiraLinha) {
//				primeiraLinha = false;
//				continue;
//			}
//			//agora pego o ; para separar as frases da linha para achar qual a linha do filme em questão
//			String[] partesDaLinha = linha.split(";");
//		//pego o arquivo aberto, pego as infos e crio as instancias para colocar nos arrays, tudo isso dentro de um método
//		}
	}
}
	


