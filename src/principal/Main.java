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
	public static final String caminhoArquivoDiretores = "./dados/Diretores.csv";
	public static final String caminhoArquivoAtores = "./dados/Atores.csv";
	
	public static void main(String[] args) throws IOException {
		
		//*************************************************************************************
		//abrir os 3 arquivos 
		//*************************************************************************************
		//FILMES
		File arquivoFilmes = new File(caminhoArquivoFilmes);
		boolean existeArquivoFilmes = arquivoFilmes.exists();
		FileWriter escritorFilmes = new FileWriter(caminhoArquivoFilmes, StandardCharsets.ISO_8859_1, existeArquivoFilmes);
		if(!existeArquivoFilmes) {
			escritorFilmes.write("FILME_ID;NOME;GENERO;DIRETOR;ANO_LANCAMENTO;ATOR1;ATOR2;ATOR3;novacoluna\n");
		}
		escritorFilmes.close();
		//*************************************************************************************
		//FILMES
		File arquivoDiretores = new File(caminhoArquivoDiretores);
		boolean existeArquivoDiretores = arquivoDiretores.exists();
		FileWriter escritorDiretores = new FileWriter(caminhoArquivoDiretores, StandardCharsets.ISO_8859_1, existeArquivoDiretores);
		if(!existeArquivoDiretores) {
			escritorDiretores.write("FILME_ID;NOME;GENERO;DIRETOR;ANO_LANCAMENTO;ATOR1;ATOR2;ATOR3;novacoluna\n");
		}
		escritorDiretores.close();
		//*************************************************************************************		
		//FILMES
		File arquivoAtores = new File(caminhoArquivoAtores);
		boolean existeArquivoAtores = arquivoAtores.exists();
		FileWriter escritorAtores = new FileWriter(caminhoArquivoAtores, StandardCharsets.ISO_8859_1, existeArquivoAtores);
		if(!existeArquivoAtores) {
			escritorAtores.write("FILME_ID;NOME;GENERO;DIRETOR;ANO_LANCAMENTO;ATOR1;ATOR2;ATOR3;novacoluna\n");
		}
		escritorAtores.close();
		//*************************************************************************************	
		
		
		
		
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
		Filme filme2 = new Filme(20002,"21 milhas","terror",Peter_Berg ,2021, ator1, ator2, ator3);
		Filme filme3 = new Filme(20003,"Norbit","terror",Peter_Berg ,2010, ator1, ator2, ator3);
		
		FilmeCSV filmeCSV = new FilmeCSV(); 
		filmeCSV.adicionaFilme(filme1);
		filmeCSV.adicionaFilme(filme2);
		filmeCSV.adicionaFilme(filme3);
		filmeCSV.imprimirFilme(20003);
		
		
		
		
	}

	
	
	public static void show(String a) {
		System.out.println(a);
	}
	//função que permite enviar o caminho dos arquivos à classe Catalogo
	public static final String retornaCaminhoArquivo(String entidadeDoArquivo) {
		switch(entidadeDoArquivo) {
		case "filme":
			return caminhoArquivoFilmes;
		case "diretor":
			return caminhoArquivoDiretores;
		case "ator":
			return caminhoArquivoAtores;
		default: 
			return "-1";
		}
	}
}
