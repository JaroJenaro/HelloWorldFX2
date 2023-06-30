package de.iav.helloworld.SceneBuilder;

import de.iav.helloworld.model.Student;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.util.UUID;

public class SceneBuilderController {
    @FXML
    public ListView lv_ListView;
    @FXML
    public ComboBox comboBox;
    @FXML
    public TextField e_email;

    @FXML
    public TextField tf_showInLabel;
    @FXML
    public Label l_viewTextField;
    @FXML
    public Label l_errorMessage;


    @FXML
    private Label welcomeText;
    @FXML
    private Button b_courseUpdate;
    @FXML
    private TextField e_firstName;
    @FXML
    private TextField e_lastName;

/*
    public void initialize() {
        System.out.println("This method is executed on initialization of the controller");
        //label.textProperty().bind(textField.textProperty());
        // oder
        tf_showInLabel.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length()>=3) {
                l_viewTextField.setText(newValue);
            }
            else {l_viewTextField.setText("Länge 3 nicht erreicht");

            }
        });
    }
*/
    public void initialize() {
        System.out.println("Scene Builder This method is executed on initialization of the controller");
        //label.textProperty().bind(textField.textProperty());
        // oder
        tf_showInLabel.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length()>=3) {
                System.out.println("if newValue: " +  newValue + "neValue-length() " +newValue.length() + " oldValue: " +  oldValue);
                //l_viewTextField.setText(newValue);
                //label.setText("Started");
                final IntegerProperty i = new SimpleIntegerProperty(0);
                Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.seconds(3),
                                event -> {
                                    i.set(i.get() + 1);
                                    l_viewTextField.setText(newValue);
                                    l_errorMessage.setText("");
                                    welcomeText.setText("Elapsed time: " + i.get() + " seconds");
                                }
                        )
                );
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
            }
            else {
                System.out.println("else newValue: " +  newValue + " oldValue: " +  oldValue);
                l_errorMessage.setText("Länge 3 nicht erreicht");
                l_viewTextField.setText("");

            }
        });
    }

    public void curseUpdate() {
        lv_ListView.getItems().add(comboBox.getValue());

       // welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void getStudenten() {
        Student student = new Student(UUID.randomUUID(), e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
        System.out.println("hier ist der Student: " + e_firstName.getText()  + " " + e_lastName.getText()  + " " + e_email.getText() + " " +  lv_ListView.getItems());

        System.out.println("hier ist der Student als record: " + student);
    }

    public void clearForm() {
        e_firstName.clear();
        e_lastName.clear();
        e_email.clear();
        lv_ListView.getItems().clear();
        tf_showInLabel.clear();
        l_viewTextField.setText("");


    }
}