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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.util.*;

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

    //List<String> firstNamesList = new ArrayList<>(){"Erum", "frrf"};
    List<String> firstNamesList = new ArrayList<>(Arrays.asList("Erum", "Matthias", "Sergej", "Tobias", "Jaro", "Gerd", "Ziyang", "Muslim", "Marcell", "Houman", "Ziad", "Dirk"));
    List<String> lastNamesList = new ArrayList<>(Arrays.asList("Schaukat", "Romankiewitsch", "Grilborzer", "Hengelbrock", "Placzek", "Lödige", "Song", "Kerem", "Dechant", "Mohammadi", "Laribi", "Dirk"));
    ObservableList<String> coursesList = FXCollections.observableArrayList("BioTechnology", "Computer Science", "Computer Networks", "Electrical Engineering", "Mechanical Engineering", "Aerospace Engineering", "Medical Ethics", "Clinical Skills", "Internal Medicine"," Surgery");

    //List<String> mailsList = new ArrayList<>(Arrays.asList("Erum", "Matthias", "Sergej", "Tobias", "Jaro", "Gerd", "Ziyang", "Muslim", "Marcell", "Houmane", "Ziad", "Dirk"));
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

        comboBox.setItems(coursesList);
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
        e_Uuid.clear();
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

        listOfStudentsController.addStudentInTheList(student, studentList);
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
    public void setStudentRegister(List<Student> studentListfromScene3) {

        studentList = studentListfromScene3;
    }

    public void switchToScene3WithUpdate(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/helloworld/ListOfStudents.fxml"));
        root = loader.load();

        Student student = new Student(UUID.fromString(e_Uuid.getText()), e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
        ListOfStudentsontroller listOfStudentsController = loader.getController();

        listOfStudentsController.updateStudentInTheList(student, studentList);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void generateOneStudent(ActionEvent event) {




        Student student = new Student(
                UUID.randomUUID(),
                generateFirstName(),
                generateLastName(),
                generateEmail(),
                generateCoursesList());

        e_firstName.setText(student.firstName());
        e_lastName.setText(student.lastName());
        e_email.setText(student.email());
        lv_ListView.getItems().addAll(student.courseOfStudies());



    }

    private int getNumber(int number) {

        int min = 0;
        // Create a new instance of Random
        Random random = new Random();
        int randomNumber = random.nextInt(number - min + 1) + min;
        // Generate a random number between min and max (inclusive)

        System.out.println("Random: " + randomNumber);

        return randomNumber;
    }

    private int getNumber(int min, int number) {


        // Create a new instance of Random
        Random random = new Random();
        int randomNumber = random.nextInt(number - min + 1) + min;
        // Generate a random number between min and max (inclusive)

        System.out.println("Random: " + randomNumber);

        return randomNumber;
    }
    private String generateFirstName(){
        return firstNamesList.get(getNumber(12));
    }

    private String generateLastName(){
        return lastNamesList.get(getNumber(12));
    }
    private String generateEmail(){
        return firstNamesList.get(getNumber(12)) +"." +lastNamesList.get(getNumber(12)) +"@mail.de";
    }
    private List<String> generateCoursesList(){


        int random = getNumber(1, 5);
        List<String> courses = new ArrayList<>();
        for (int i = 0; i < random; i++)
        {
            courses.add(coursesList.get(getNumber(10)));
        }
        return courses;
    }

}