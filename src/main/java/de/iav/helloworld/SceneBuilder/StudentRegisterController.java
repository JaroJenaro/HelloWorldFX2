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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentRegisterController {
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
    public TextField e_Uuid;


    @FXML
    private Label welcomeText;
    @FXML
    private Button b_courseUpdate;
    @FXML
    private TextField e_firstName;
    @FXML
    private TextField e_lastName;

    public List<Student> studentList = new ArrayList<>();

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void initialize() {
        System.out.println("StudentenRegister initialize");
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


    public void curseUpdate() {
        lv_ListView.getItems().add(comboBox.getValue());

       // welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void getStudenten() {
        Student student = new Student( UUID.randomUUID(), e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
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

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/helloworld/welcome.fxml"));
        root = loader.load();

        WelcomeController welcomeController = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void switchToScene3(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/helloworld/ListOfStudents.fxml"));
        root = loader.load();

        Student student = new Student(UUID.randomUUID(), e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
        ListOfStudentsontroller listOfStudentsController = loader.getController();

        listOfStudentsController.setStudentInTheList(student, studentList);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void setStudentRegister(Student student, List<Student> studentListfromScene3
    ) {
        e_firstName.setText(student.firstName());
        e_lastName.setText(student.lastName());
        e_email.setText(student.email());
        e_Uuid.setText(student.uuid().toString());
        lv_ListView.getItems().addAll(student.courseOfStudies());
        studentList = studentListfromScene3;
    }
}