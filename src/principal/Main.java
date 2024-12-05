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

import application.Controlador;
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
	public static final String caminhoArquivoCriticas = "./dados/Criticas.ser";
	public static final String caminhoArquivoComentarios = "./dados/Comentarios.ser";
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
	private static ArrayList<Comentario> todosOsComentarios = new ArrayList<>();
	private static ArrayList<Critica> todasAsCriticas = new ArrayList<>();
	
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
            
            primaryStage.setOnCloseRequest(event -> {
                event.consume();//vai impedir o fechamento instantaneo e abaixo vai salvar os dados
                if (salvaLista(caminhoArquivoFilmes,todosOsFilmes)&&salvaLista(caminhoArquivoListas,todasAsListas)&&salvaLista(caminhoArquivoUsuarios,todosOsUsuarios)) {
                    primaryStage.close();//fecha o app apos ter salvo
                }
            });
            
            
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
    public static ArrayList<Critica> retornaArrayListCriticas(){
    	return todasAsCriticas;
    }
    public static ArrayList<Comentario> retornaArrayListComentarios(){
    	return todosOsComentarios;
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
          if (listaCarregada == null) {
              listaCarregada = new ArrayList<>();
          }
          return listaCarregada;
      }
      
      public static <T> boolean salvaLista(String caminho, ArrayList<T> lista) {
    	  verificarOuCriarArquivo(caminho);
    	  try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
              oos.writeObject(lista); //escreve a lista
              System.out.println("Lista foi salva no arquivo.");
              return true;
          } catch (IOException e) {
              System.err.println("Erro: " + e.getMessage());
              return false;
          }
      }
      
      public static void verificarOuCriarArquivo(String caminhoArquivo) {
          File arquivo = new File(caminhoArquivo);
          try {
              if (!arquivo.exists()) {
            	  arquivo.createNewFile();                     
              }
          } catch (IOException e) {
              System.err.println("Erro ao verificar/criar arquivo: " + e.getMessage());
              e.printStackTrace();
          }
      }

      public static void main(String[] args) {
    	    verificarOuCriarArquivo(caminhoArquivoFilmes);
    	    verificarOuCriarArquivo(caminhoArquivoListas);
    	    verificarOuCriarArquivo(caminhoArquivoUsuarios); 
    	    verificarOuCriarArquivo(caminhoArquivoCriticas);
    	    verificarOuCriarArquivo(caminhoArquivoComentarios);
    	    
    	    
    	    
    	    todosOsFilmes = carregaLista(caminhoArquivoFilmes);
    	    todasAsListas = carregaLista(caminhoArquivoListas);
    	    todosOsUsuarios = carregaLista(caminhoArquivoUsuarios);
    	    todasAsCriticas = carregaLista(caminhoArquivoCriticas);
    	    todosOsComentarios = carregaLista(caminhoArquivoComentarios);
    	    
    	    launch(args);
    	}

}