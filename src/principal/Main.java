package principal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
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
	public static final String caminhoArquivoFilmes = "./dados/Filmes.ser";
	public static final String caminhoArquivoListas = "./dados/Listas.ser";
	public static final String caminhoArquivoUsuarios = "./dados/Usuarios.ser";
	//===========================javafx========================================
	private static Stage stage;
	private static Scene loginScene;
	private static Scene paginaInicialScene;
	private static Scene filmeScene;
	private static Scene addFilmeScene;
	private static Scene addListaScene;
	private static Scene relatoriosScene;
	private static Scene perfilScene;
	
	private static ArrayList<Filme> todosOsFilmes = new ArrayList<>();
	private static ArrayList<Lista> todasAsListas = new ArrayList<>();
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
            
            Parent fxmlAddFilme = FXMLLoader.load(getClass().getResource("/application/AdicionarFilme.fxml"));
            addFilmeScene = new Scene(fxmlAddFilme, 950, 650);
            
            Parent fxmlAddLista = FXMLLoader.load(getClass().getResource("/application/AdicionarLista.fxml"));
            addListaScene = new Scene(fxmlAddLista, 950, 650);
            
            Parent fxmlRelatorios = FXMLLoader.load(getClass().getResource("/application/Relatorios.fxml"));
            relatoriosScene = new Scene(fxmlRelatorios, 950, 650);
            
            Parent fxmlPerfil = FXMLLoader.load(getClass().getResource("/application/Perfil.fxml"));
            perfilScene = new Scene(fxmlPerfil, 950, 650);
            
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
    public static ArrayList<Usuario> retornaArrayListUsuarios(){
    	return todosOsUsuarios;
    }
    public static ArrayList<Lista> retornaArrayListListas(){
    	return todasAsListas;
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
        		case 3:
        			stage.setScene(perfilScene);
        			break;
        		case 4:
        			stage.setScene(addFilmeScene);
        			break;
        		case 5:
        			stage.setScene(addListaScene);
        			break;
        		case 6:
        			stage.setScene(relatoriosScene);
        			break;
        		default: 
        			stage.setScene(paginaInicialScene);
        			break;
        		
        	}
        }
        
        
        
      public static ArrayList<Lista> retorna4Listas(int pagina) {
    	  ArrayList<Lista> arrayComListas=new ArrayList<>();
    	  for(int i=pagina*4;i<todasAsListas.size();i++){
    		arrayComListas.set(i,todasAsListas.get(i));
    	  }
    	  return arrayComListas;
      }
       
      
      
    
      public Image uploadDeImagem(Stage primaryStage) {
          FileChooser fileChooser = new FileChooser();
          fileChooser.setTitle("Selecione uma Imagem");
          fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens Suportadas", "*.png", "*.jpg", "*.jpeg"));

          File file = fileChooser.showOpenDialog(primaryStage);

          if (file != null) {
              try {
                  // Retorna uma instância da imagem
                  return new Image(file.toURI().toString());
              } catch (Exception e) {
                  e.printStackTrace();
                  System.out.println("Erro ao carregar a imagem.");
              }
          }
          return null; // Retorna null se nenhum arquivo foi selecionado
      }
      
      
        
    //===========================aplicação========================================
   
    
    //função que carrega os dados serializados
      
      public static <T> ArrayList<T> carregaLista(String caminho){
          ArrayList<T> listaCarregada = null;
          try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho)))
          {
              listaCarregada = (ArrayList<T>) ois.readObject();
          }
          catch (IOException | ClassNotFoundException e)
          {
              System.err.println("Erro ao carregar a lista: " + e.getMessage());
          }    
          return listaCarregada;
      }
      
      //função que salva os dados serializados
      
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
	public static void main(String[] args)  {
		

		carregaLista(caminhoArquivoFilmes);
		salvaLista(caminhoArquivoFilmes,todosOsFilmes);
		carregaLista(caminhoArquivoListas);
		salvaLista(caminhoArquivoListas,todasAsListas);
		carregaLista(caminhoArquivoUsuarios);
		salvaLista(caminhoArquivoUsuarios,todosOsUsuarios);
		launch(args);
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


//try {
////*************************************************************************************
////abrir os 2 arquivos 
////*************************************************************************************
////FILMES
//File arquivoFilmes = new File(caminhoArquivoFilmes);
//boolean existeArquivoFilmes = arquivoFilmes.exists();
//FileWriter escritorFilmes = new FileWriter(caminhoArquivoFilmes, StandardCharsets.ISO_8859_1, existeArquivoFilmes);
//if(!existeArquivoFilmes) {
//	escritorFilmes.write("FILME_ID;FILME_NOME;GENERO;ANO_LANCAMENTO;DIRETOR_ID;DIRETOR_NOME;DIR_DATA_NASC;ATOR1_ID;ATOR1_NOME;ATOR1_DATA_NASC;ATOR2_ID;ATOR2_NOME;ATOR2_DATA_NASC;ATOR3_ID;ATOR3_NOME;ATOR3_DATA_NASC\n");
//	escritorFilmes.close();
//}
////*************************************************************************************
////USUARIOS
//File arquivoUsuarios = new File(caminhoArquivoUsuarios);
//boolean existeArquivoUsuarios = arquivoUsuarios.exists();
//FileWriter escritorDiretores = new FileWriter(caminhoArquivoUsuarios, StandardCharsets.ISO_8859_1, existeArquivoUsuarios);
//if(!existeArquivoUsuarios) {
//	escritorDiretores.write("FILME_ID;NOME;GENERO;DIRETOR;ANO_LANCAMENTO;ATOR1;ATOR2;ATOR3;novacoluna\n");
//	escritorDiretores.close();
//}
////*************************************************************************************	
////*************************************************************************************
////criação dos arraylists
//
////ArrayList<Filme> todosOsFilmes = new ArrayList<>();
////ArrayList<Ator> todosOsAtores = new ArrayList<>();
////ArrayList<Diretor> todosOsDiretores = new ArrayList<>();
//
////*************************************************************************************
////copiar os dados dos arquivos para os arraylists 
////*************************************************************************************
//
////Arquivos.copiaDadosDoArquivo(caminhoArquivoFilmes,Arquivos.getLeitorFilmesAtoresDiretores(),todosOsFilmes,todosOsAtores,todosOsDiretores);
//
//
//Scanner scanner = new Scanner(System.in);
//LocalDate dateAtor1 = LocalDate.of(1971,6,5);
//Ator ator1 = new Ator(60001,"Mark Wahlberg",dateAtor1);
//
//LocalDate dateAtor2 = LocalDate.of(1982,1,7);
//Ator ator2 = new Ator(60002,"Lauren Cohan",dateAtor2);
//
//LocalDate dateAtor3 = LocalDate.of(1983,2,12);
//Ator ator3 = new Ator(60003,"Iko Uwais",dateAtor3);
//
//LocalDate dateDiretor1 = LocalDate.of(1964,3,11);
//Diretor Peter_Berg = new Diretor(50001,"Peter Berg", dateDiretor1);
//
//Filme filme1 = new Filme(20001,"22 milhas","acao",Peter_Berg ,2021, ator1, ator2, ator3);
//Filme filme2 = new Filme(20002,"King Kong","acao",Peter_Berg ,2016, ator1, ator2, ator3);
//Filme filme3 = new Filme(20003,"Norbit","terror",Peter_Berg ,2010, ator1, ator2, ator3);
//
////FilmeCSV filmeCSV = new FilmeCSV(); 
//////	Catalogo catalogo = new Catalogo();
////ManipulacaoDados.adicionaFilme(filme1,todosOsFilmes);
////ManipulacaoDados.adicionaFilme(filme2,todosOsFilmes);
////ManipulacaoDados.adicionaFilme(filme3,todosOsFilmes);
////filmeCSV.imprimirFilme(20003);
////Arquivos.salvaDadosNoArquivo(caminhoArquivoFilmes, arquivoFilmes, todosOsFilmes);
//
//launch(args);
//} catch (IOException e) {
//e.printStackTrace();
//}

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
//	Catalogo catalogo = new Catalogo();
	ManipulacaoDados.adicionaFilme(filme1,todosOsFilmes);
	ManipulacaoDados.adicionaFilme(filme2,todosOsFilmes);
	ManipulacaoDados.adicionaFilme(filme3,todosOsFilmes);
	filmeCSV.imprimirFilme(20003);
	//Arquivos.salvaDadosNoArquivo(caminhoArquivoFilmes, arquivoFilmes, todosOsFilmes);
	
	
	
}

*/