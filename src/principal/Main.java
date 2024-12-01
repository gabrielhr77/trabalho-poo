package principal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import entidadesFilmes. *;
import entidadesUsuarios. *;
//import entidadesFilmes.Diretor;
//import entidadesFilmes.Filme;
//import entidadesFilmes.FilmeCSV;
//import entidadesFilmes.Pessoa;


import java.util.ArrayList;

public class Main extends Application{
	//variáveis globais que podem ser vistas por qualquer método na main
	public static final String caminhoArquivoFilmes = "./dados/Filmes.csv";
	public static final String caminhoArquivoUsuarios = "./dados/Usuarios.csv";
	//===========================javafx========================================
	private static Stage stage;
	private static Scene loginScene;
	private static Scene paginaInicialScene;
	private static Scene filmeScene;
	private static Scene addFilmeScene;
	private static Scene addListaScene;
	
	private static ArrayList<Filme> todosOsFilmes = new ArrayList<>();
	private static ArrayList<Ator> todosOsAtores = new ArrayList<>();
	private static ArrayList<Diretor> todosOsDiretores = new ArrayList<>();
	private static ArrayList<Usuario> todosOsUsuarios = new ArrayList<>();
	
    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println("Tentando carregar o arquivo FXML...");

            //Carrega o arquivo FXML
            stage = primaryStage;
            
            Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
            loginScene = new Scene(fxmlLogin, 950, 650);
            
            Parent fxmlPaginaInicial = FXMLLoader.load(getClass().getResource("/application/PaginaInicial.fxml"));
            paginaInicialScene = new Scene(fxmlPaginaInicial, 950, 650);
            
            Parent fxmlFilme = FXMLLoader.load(getClass().getResource("/application/Filme.fxml"));
            filmeScene = new Scene(fxmlFilme, 950, 650);
            //Parent root = FXMLLoader.load(getClass().getResource("Filme.fxml"));
            
            Parent fxmlAddFilme = FXMLLoader.load(getClass().getResource("/application/AdicionarFilme.fxml"));
            addFilmeScene = new Scene(fxmlAddFilme, 950, 650);
            
            Parent fxmlAddLista = FXMLLoader.load(getClass().getResource("/application/AdicionarLista.fxml"));
            addListaScene = new Scene(fxmlAddLista, 950, 650);
            
            System.out.println("FXML carregado com sucesso.");

            primaryStage.setResizable(false);
            primaryStage.setScene(loginScene);
            primaryStage.setTitle("ROTTEN POTATOES");
            primaryStage.show();
            
            System.out.println("Aplicação deu certo");
        } catch (Exception e) {
            System.out.println("Erro tentando carregar o FXML:");
            e.printStackTrace();
        }
    }
        
    public static Stage retornaStage() {
    	return stage;
    }
    
    public static ArrayList<Filme> retornaArrayListFilmes(){
    	return todosOsFilmes;
    }
    public static ArrayList<Ator> retornaArrayListAtores(){
    	return todosOsAtores;
    }
    public static ArrayList<Diretor> retornaArrayListDiretores(){
    	return todosOsDiretores;
    }
    public static ArrayList<Usuario> retornaArrayListUsuarios(){
    	return todosOsUsuarios;
    }
    
    public static void mudarPagina(int pagina) {
        	switch(pagina) {
        		case 0:
        			stage.setScene(loginScene);
        			break;
        		case 1:
        			stage.setScene(paginaInicialScene);
        			break;
        		case 2:
        			stage.setScene(filmeScene);
        			break;
        			
//        		case 3:
//        			stage.setScene(perfil);
//        			break;
        		case 4:
        			stage.setScene(addFilmeScene);
        			break;
        		case 5:
        			stage.setScene(addListaScene);
        			break;
        		default: 
        			stage.setScene(paginaInicialScene);
        			break;
        		
        	}
        }
        
        
        
    public static ArrayList<Filme> retorna4Filmes(int pagina) {
    	  ArrayList<Filme> arrayComFilmes=new ArrayList<>();
    	  switch(pagina) {
    	  	case 0:
    	  		for(int i=0;i<4;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));//o SET é para atualizar os elementos do arraylist
    	  		}
    	  		return arrayComFilmes;
    	  	case 1:
    	  		for(int i=4;i<8;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 2:
    	  		for(int i=8;i<12;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 3:
    	  		for(int i=12;i<16;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 4:
    	  		for(int i=16;i<20;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 5:
    	  		for(int i=20;i<24;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 6:
    	  		for(int i=24;i<28;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 7:
    	  		for(int i=28;i<32;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 8:
    	  		for(int i=32;i<36;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 9:
    	  		for(int i=36;i<40;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	case 10:
    	  		for(int i=40;i<44;i++) {
    	  			arrayComFilmes.set(i,todosOsFilmes.get(i));
    	  		}
    	  		return arrayComFilmes;
    	  	default:
    	  		return arrayComFilmes;
    	  }
      }
        
        
    //===========================aplicação========================================
   
        
	public static void main(String[] args)  {
		try {
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
			
//			ArrayList<Filme> todosOsFilmes = new ArrayList<>();
//			ArrayList<Ator> todosOsAtores = new ArrayList<>();
//			ArrayList<Diretor> todosOsDiretores = new ArrayList<>();
			
			//*************************************************************************************
			//copiar os dados dos arquivos para os arraylists 
			//*************************************************************************************
			
			//Arquivos.copiaDadosDoArquivo(caminhoArquivoFilmes,Arquivos.getLeitorFilmesAtoresDiretores(),todosOsFilmes,todosOsAtores,todosOsDiretores);
			
			
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
			
//			FilmeCSV filmeCSV = new FilmeCSV(); 
//	//		Catalogo catalogo = new Catalogo();
//			ManipulacaoDados.adicionaFilme(filme1,todosOsFilmes);
//			ManipulacaoDados.adicionaFilme(filme2,todosOsFilmes);
//			ManipulacaoDados.adicionaFilme(filme3,todosOsFilmes);
//			filmeCSV.imprimirFilme(20003);
//			Arquivos.salvaDadosNoArquivo(caminhoArquivoFilmes, arquivoFilmes, todosOsFilmes);
			
			launch(args);
		} catch (IOException e) {
	        e.printStackTrace();
	    }
	}

/*
import entidadesFilmes.Ator;
import entidadesFilmes.Diretor;
import entidadesFilmes.Filme;
import entidadesFilmes.FilmeCSV;
import entidadesFilmes.Pessoa;

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
		
		Arquivos.copiaDadosDoArquivo(caminhoArquivoFilmes,Arquivos.getLeitorFilmesAtoresDiretores(),todosOsFilmes,todosOsAtores,todosOsDiretores);
		
		
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
		ManipulacaoDados.adicionaFilme(filme1,todosOsFilmes);
		ManipulacaoDados.adicionaFilme(filme2,todosOsFilmes);
		ManipulacaoDados.adicionaFilme(filme3,todosOsFilmes);
		filmeCSV.imprimirFilme(20003);
		//Arquivos.salvaDadosNoArquivo(caminhoArquivoFilmes, arquivoFilmes, todosOsFilmes);
		
		
		
	}

	*/
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
