package edu.uqtr.exercice2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreationMonstreApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreationMonstreApplication.class.getResource("creation-monstre.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 600);
        stage.setTitle("Création Monstre");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}