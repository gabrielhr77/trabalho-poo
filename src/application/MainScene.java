package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

//public class MainScene extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        try {
//            // Carrega o arquivo FXML
//            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
//            
//            // Define a cena e configura o palco
//            Scene scene = new Scene(root);
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("Minha Aplicação");
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Método main que inicia a aplicação JavaFX
//    public static void main(String[] args) {
//        Application.launch(MainScene.class,args);
//    }
//}
//
public class MainScene extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println("Tentando carregar o arquivo FXML...");

            //Carrega o arquivo FXML
            //Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
            
            System.out.println("FXML carregado com sucesso.");

            // Define a cena e configura o palco
            Scene scene = new Scene(root, 950, 650);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ROTTEN POTATOES");
            primaryStage.show();
            
            System.out.println("Aplicação deu certo");
        } catch (Exception e) {
            System.out.println("Erro tentando carregar o FXML:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(MainScene.class, args);
        //Controlador.escolhaLoginRegistro();
    }
}

