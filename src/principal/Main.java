package principal;
import entidades.Filme;
import entidades.FilmeCSV;
import entidades.Pessoa;
import entidades.Diretor;
import entidades.Ator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	//variáveis globais que podem ser vistas por qualquer método na main
	public static final String caminhoArquivoFilmes = "./dados/Filmes.csv";
	public static final String caminhoArquivoUsuarios = "./dados/Usuarios.csv";
	
	public static void main(String[] args) throws IOException {
		
		//*************************************************************************************
		//abrir os 2 arquivos 
		//*************************************************************************************
		//FILMES
		File arquivoFilmes = new File(caminhoArquivoFilmes);
		boolean existeArquivoFilmes = arquivoFilmes.exists();
		FileWriter escritorFilmes = new FileWriter(caminhoArquivoFilmes, StandardCharsets.ISO_8859_1, existeArquivoFilmes);
		if(!existeArquivoFilmes) {
			escritorFilmes.write("FILME_ID;FILME_NOME;GENERO;ANO_LANCAMENTO;DIRETOR_ID;DIRETOR_NOME;DIR_DATA_NASC;ATOR1_ID;ATOR1_NOME;ATOR1_DATA_NASC;ATOR2_ID;ATOR2_NOME;ATOR2_DATA_NASC;ATOR3_ID;ATOR3_NOME;ATOR3_DATA_NASC\n");
			escritorFilmes.close();
		}
		//*************************************************************************************
		//USUARIOS
		File arquivoUsuarios = new File(caminhoArquivoUsuarios);
		boolean existeArquivoUsuarios = arquivoUsuarios.exists();
		FileWriter escritorDiretores = new FileWriter(caminhoArquivoUsuarios, StandardCharsets.ISO_8859_1, existeArquivoUsuarios);
		if(!existeArquivoUsuarios) {
			escritorDiretores.write("FILME_ID;NOME;GENERO;DIRETOR;ANO_LANCAMENTO;ATOR1;ATOR2;ATOR3;novacoluna\n");
			escritorDiretores.close();
		}
		//*************************************************************************************	
		//*************************************************************************************
		//criação dos arraylists
		
		ArrayList<Filme> todosOsFilmes = new ArrayList<>();
		ArrayList<Ator> todosOsAtores = new ArrayList<>();
		ArrayList<Diretor> todosOsDiretores = new ArrayList<>();
		
		//*************************************************************************************
		//copiar os dados dos arquivos para os arraylists 
		//*************************************************************************************
		
		Catalogo.copiaDadosDoArquivo(caminhoArquivoFilmes,Catalogo.getLeitorFilmesAtoresDiretores(),todosOsFilmes,todosOsAtores,todosOsDiretores);
		
		
		Scanner scanner = new Scanner(System.in);
		LocalDate dateAtor1 = LocalDate.of(1971,6,5);
		Ator ator1 = new Ator(60001,"Mark Wahlberg",dateAtor1);
		
		LocalDate dateAtor2 = LocalDate.of(1982,1,7);
		Ator ator2 = new Ator(60002,"Lauren Cohan",dateAtor2);
		
		LocalDate dateAtor3 = LocalDate.of(1983,2,12);
		Ator ator3 = new Ator(60003,"Iko Uwais",dateAtor3);
		
		LocalDate dateDiretor1 = LocalDate.of(1964,3,11);
		Diretor Peter_Berg = new Diretor(50001,"Peter Berg", dateDiretor1);
		
		Filme filme1 = new Filme(20001,"22 milhas","acao",Peter_Berg ,2021, ator1, ator2, ator3);
		Filme filme2 = new Filme(20002,"King Kong","acao",Peter_Berg ,2016, ator1, ator2, ator3);
		Filme filme3 = new Filme(20003,"Norbit","terror",Peter_Berg ,2010, ator1, ator2, ator3);
		
		FilmeCSV filmeCSV = new FilmeCSV(); 
//		Catalogo catalogo = new Catalogo();
		Catalogo.adicionaFilme(filme1,todosOsFilmes);
		Catalogo.adicionaFilme(filme2,todosOsFilmes);
		Catalogo.adicionaFilme(filme3,todosOsFilmes);
		filmeCSV.imprimirFilme(20003);
		Catalogo.salvaDadosNoArquivo(caminhoArquivoFilmes, arquivoFilmes, todosOsFilmes);
		
		
		
	}

	
	//função que permite enviar o caminho dos arquivos à classe Catalogo
	public static final String retornaCaminhoArquivo(String entidadeDoArquivo) {
		switch(entidadeDoArquivo) {
		case "filme":
			return caminhoArquivoFilmes;
		case "diretor":
			return caminhoArquivoUsuarios;
		default: 
			return "-1";
		}
	}
}
