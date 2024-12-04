package application;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.File;

public class UploadDeImagens {

    public Image uploadImage(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione uma Imagem");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens Suportadas", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try {
                return new Image(file.toURI().toString());//devolve uma instancia de image,
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro ao carregar a imagem.");
            }
        }
        return null;
    }
}
