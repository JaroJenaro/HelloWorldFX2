package de.iav.helloworld.SceneBuilder;

import de.iav.helloworld.model.SecureRandomString;
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
    public ListView<String> lv_ListView;
    @FXML
    public ComboBox<String> comboBox;
    @FXML
    public TextField e_email;

    @FXML
    public TextField tf_showInLabel;
    @FXML
    public Label l_viewTextField;
    @FXML
    public Label l_errorMessage;
    @FXML
   public TextField e_secureID;


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
    List<String> lastNamesList = new ArrayList<>(Arrays.asList("Schaukat", "Romankiewitsch", "Grilborzer", "Hengelbrock", "Placzek", "Lödige", "Song", "Kerem", "Dechant", "Mohammadi", "Laribi", "Müller"));
    ObservableList<String> coursesList = FXCollections.observableArrayList("BioTechnology", "Computer Science", "Computer Networks", "Electrical Engineering", "Mechanical Engineering", "Aerospace Engineering", "Medical Ethics", "Clinical Skills", "Internal Medicine"," Surgery");

    List<String> mailEndingList = new ArrayList<>(Arrays.asList("gmail.de", "gmx.de", "web.com", "yahoo.de", "onet.pl", "t-online.de", "education.org", "iav.de", "volkswagen.ru", "tesla.us", "toastmasters.com", "vodafone.de"));
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
        Student student = new Student(SecureRandomString.generate(), e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
        System.out.println("hier ist der Student: " + e_firstName.getText()  + " " + e_lastName.getText()  + " " + e_email.getText() + " " +  lv_ListView.getItems());

        System.out.println("hier ist der Student als record: " + student);
    }

    public void clearForm() {
        e_firstName.clear();
        e_lastName.clear();
        e_email.clear();
        lv_ListView.getItems().clear();
        tf_showInLabel.clear();
        e_secureID.clear();
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

        Student student = new Student(SecureRandomString.generate(), e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
        ListOfStudentsController listOfStudentsController = loader.getController();

        listOfStudentsController.addStudentInTheList(student, studentList);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void setStudentRegister(Student student, List<Student> studentListFromScene3
    ) {
        e_firstName.setText(student.firstName());
        e_lastName.setText(student.lastName());
        e_email.setText(student.email());
        e_secureID.setText(student.secureID());
        lv_ListView.getItems().addAll(student.courseOfStudies());
        studentList = studentListFromScene3;
    }
    public void setStudentRegister(List<Student> studentListFromScene3) {

        studentList = studentListFromScene3;
    }

    public void switchToScene3WithUpdate(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/helloworld/ListOfStudents.fxml"));
        root = loader.load();

        Student student = new Student(e_secureID.getText(), e_firstName.getText(), e_lastName.getText(), e_email.getText(), lv_ListView.getItems());
        ListOfStudentsController listOfStudentsController = loader.getController();

        listOfStudentsController.updateStudentInTheList(student, studentList);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void generateOneStudent(ActionEvent event) {
        System.out.println("generateOneStudent");
        Student student = new Student(
                SecureRandomString.generate(),
                generateFirstName(),
                generateLastName(),
                generateEmail(),
                generateCoursesList());

        e_firstName.setText(student.firstName());
        e_lastName.setText(student.lastName());
        e_email.setText(student.email());
        lv_ListView.getItems().clear();
        lv_ListView.getItems().addAll(student.courseOfStudies());
        System.out.println(student);



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
        System.out.println("generateFirstName");
        return firstNamesList.get(getNumber(firstNamesList.size()-1));
        //System.out.println("generateFirstName: ");
    }

    private String generateLastName(){
        return lastNamesList.get(getNumber(lastNamesList.size()-1));
    }
    private String generateEmail(){
        return firstNamesList.get(getNumber(firstNamesList.size()-1)) +"." + lastNamesList.get(getNumber(lastNamesList.size()-1)) +"@" + mailEndingList.get(getNumber(mailEndingList.size()-1));
    }
    private List<String> generateCoursesList(){

        int random = getNumber(1, 5);
        List<String> courses = new ArrayList<>();
        for (int i = 0; i < random; i++)
        {
            String randomCourse = coursesList.get(getNumber(coursesList.size()-1));
            if(!courses.contains(randomCourse))
                courses.add(randomCourse);
        }
        return courses;
    }

}