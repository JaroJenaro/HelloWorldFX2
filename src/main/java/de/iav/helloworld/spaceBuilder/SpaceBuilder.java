package de.iav.helloworld.spaceBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

public class SpaceBuilder extends Application {
    public void start(Stage stage) throws IOException {

        //System.out.println(SpaceBuilder.class.getResource("/de/iav/helloworld/Aufgabe1SceneBuilderBunt.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(SpaceBuilder.class.getResource("/de/iav/helloworld/Aufgabe1SceneBuilderBunt.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(SpaceBuilder.class.getResource("/de/iav/helloworld/StudentenRegister.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);


        stage.setTitle("Hello FX with SpaceBuilder!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
