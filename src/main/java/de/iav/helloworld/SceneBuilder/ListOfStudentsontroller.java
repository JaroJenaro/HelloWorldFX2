package de.iav.helloworld.SceneBuilder;

import de.iav.helloworld.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListOfStudentsontroller {



    @FXML
    public TextField e_email;

    @FXML
    public TextField tf_showInLabel;
    @FXML
    public Label l_viewTextField;
    @FXML
    public ListView<Student> lv_ListViewOfStudents;



    private Stage stage;
    private Scene scene;
    private Parent root;
    public void initialize() {
        System.out.println("ListOfStudentsController initialize");

    }



/*
    public void getStudenten() {
        Student student = new Student(e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
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
*/
    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/helloworld/welcome.fxml"));
        root = loader.load();

        //WelcomeController welcomeController = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {


        // Ich bin in der 3 zen Ansicht
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/helloworld/StudentenRegister.fxml"));
        root = loader.load();

        StudentRegisterController studentRegisterController = loader.getController();

        studentRegisterController.setStudentRegister(lv_ListViewOfStudents.getSelectionModel().getSelectedItem(), lv_ListViewOfStudents.getItems());



        //lv_ListViewOfStudents.getSelectionModel().selectedItemProperty().addListener(
        //        (observableValue, s, t1) -> text.setText(listView.getSelectionModel().getSelectedItem())

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void setStudentInTheList(Student fromRegisterStudent, List<Student> students) {

        System.out.println(fromRegisterStudent);
        // Fügt initiale Elemente zur Liste hinzu
        lv_ListViewOfStudents.getItems().addAll(students);
        lv_ListViewOfStudents.getItems().add(fromRegisterStudent);

        /*
        // Fügt ein Event-Handler hinzu, der den Button deaktiviert, wenn das Textfeld leer ist
        textField.addEventHandler(EventType.ROOT, event -> {
            addButton.setDisable(textField.getText().isEmpty());
        });

        // Fügt ein Event-Handler hinzu, der den Text des ausgewählten Elements in die Textansicht schreibt
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, s, t1) -> text.setText(listView.getSelectionModel().getSelectedItem())
        );

         */
    }
}
