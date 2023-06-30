package de.iav.helloworld.SceneBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {
    @FXML
    public Label l_welcome;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onRegiserButtonClick(ActionEvent event) throws IOException {
        // wechseln zur Registermaske

        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/de/iav/helloworld/StudentenRegister.fxml"));

        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        l_welcome.setText("Welcome to JavaFX Application!");
    }



}