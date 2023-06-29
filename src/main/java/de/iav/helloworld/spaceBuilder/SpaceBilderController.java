package de.iav.helloworld.spaceBuilder;

import de.iav.helloworld.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SpaceBilderController {
    @FXML
    public ListView lv_ListView;
    @FXML
    public ComboBox comboBox;
    @FXML
    public TextField e_email;

    @FXML
    private Label welcomeText;
    @FXML
    private Button b_courseUpdate;
    @FXML
    private TextField e_firstName;
    @FXML
    private TextField e_lastName;


    public void curseUpdate() {
        lv_ListView.getItems().add(comboBox.getValue());

       // welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void getStudenten() {
        Student student = new Student(e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
        System.out.println("hier ist der Student: " + e_firstName.getText()  + " " + e_lastName.getText()  + " " + e_email.getText() + " " +  lv_ListView.getItems());

        System.out.println("hier ist der Student als record: " + student);
    }
}