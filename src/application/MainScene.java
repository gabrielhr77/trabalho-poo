//package application;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.Parent;
//
////public class MainScene extends Application {
////
////    @Override
////    public void start(Stage primaryStage) {
////        try {
////            // Carrega o arquivo FXML
////            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
////            
////            // Define a cena e configura o palco
////            Scene scene = new Scene(root);
////            primaryStage.setScene(scene);
////            primaryStage.setTitle("Minha Aplicação");
////            primaryStage.show();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
////
////    // Método main que inicia a aplicação JavaFX
////    public static void main(String[] args) {
////        Application.launch(MainScene.class,args);
////    }
////}
////
//public class MainScene extends Application {
//
//	private static Stage stage;
//	private static Scene loginScene;
//	private static Scene paginaInicialScene;
//	private static Scene filmeScene;
//	
//    @Override
//    public void start(Stage primaryStage) {
//        try {
//            System.out.println("Tentando carregar o arquivo FXML...");
//
//            //Carrega o arquivo FXML
//            stage = primaryStage;
//            
//            Parent fxmlLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
//            loginScene = new Scene(fxmlLogin, 950, 650);
//            
//            Parent fxmlPaginaInicial = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
//            paginaInicialScene = new Scene(fxmlPaginaInicial, 950, 650);
//            
//            Parent fxmlFilme = FXMLLoader.load(getClass().getResource("Filme.fxml"));
//            filmeScene = new Scene(fxmlFilme, 950, 650);
//            //Parent root = FXMLLoader.load(getClass().getResource("Filme.fxml"));
//            
//            System.out.println("FXML carregado com sucesso.");
//
//            primaryStage.setResizable(false);
//            primaryStage.setScene(loginScene);
//            primaryStage.setTitle("ROTTEN POTATOES");
//            primaryStage.show();
//            
//            System.out.println("Aplicação deu certo");
//        } catch (Exception e) {
//            System.out.println("Erro tentando carregar o FXML:");
//            e.printStackTrace();
//        }
//    }
//        
//        public static void mudarPagina(int pagina) {
//        	switch(pagina) {
//        		case 0:
//        			stage.setScene(loginScene);
//        			break;
//        		case 1:
//        			stage.setScene(paginaInicialScene);
//        			break;
//        		case 2:
//        			stage.setScene(filmeScene);
//        			break;
//        	}
//        
//    
//    }
//
//    public static void main(String[] args) {
//        Application.launch(MainScene.class, args);
//        //Controlador.escolhaLoginRegistro();
//        
//      
//    }
//}
//
