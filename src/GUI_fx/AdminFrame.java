package GUI_fx;

import GUI_Imp.Admin_Imp;
import Main.*;
import Main.Student;
import javafx.application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import java.io.IOException;

public class AdminFrame extends Application {

    public static Stage stage;

    @FXML
    //BOXES
    public VBox addStudentBox;
    public VBox addInstractorBox;
    public VBox addCoursesBox;
    public VBox searchStudentBox;
    public VBox searchInstractorBox;
    public VBox searchCoursesBox;
    public VBox displayStudentBox;
    public VBox displayInstractorBox;
    public VBox displayCoursesBox;

    //Slider
    public Button addStudent;
    public void addStudentClicked() {
        addStudentBox.setVisible(true);
        addInstractorBox.setVisible(false);
        addCoursesBox.setVisible(false);
        searchStudentBox.setVisible(false);
        searchInstractorBox.setVisible(false);
        searchCoursesBox.setVisible(false);
        displayStudentBox.setVisible(false);
        displayInstractorBox.setVisible(false);
        displayCoursesBox.setVisible(false);
    }
    public Button addInstractor;
    public void addInstractorClicked() {
        addStudentBox.setVisible(false);
        addInstractorBox.setVisible(true);
        addCoursesBox.setVisible(false);
        searchStudentBox.setVisible(false);
        searchInstractorBox.setVisible(false);
        searchCoursesBox.setVisible(false);
        displayStudentBox.setVisible(false);
        displayInstractorBox.setVisible(false);
        displayCoursesBox.setVisible(false);
    }
    public Button addCourse;
    public void addCourseClicked() {
        addStudentBox.setVisible(false);
        addInstractorBox.setVisible(false);
        addCoursesBox.setVisible(true);
        searchStudentBox.setVisible(false);
        searchInstractorBox.setVisible(false);
        searchCoursesBox.setVisible(false);
        displayStudentBox.setVisible(false);
        displayInstractorBox.setVisible(false);
        displayCoursesBox.setVisible(false);
    }
    public Button searchSudent;
    public void searchStudentClicked() {
        addStudentBox.setVisible(false);
        addInstractorBox.setVisible(false);
        addCoursesBox.setVisible(false);
        searchStudentBox.setVisible(true);
        searchInstractorBox.setVisible(false);
        searchCoursesBox.setVisible(false);
        displayStudentBox.setVisible(false);
        displayInstractorBox.setVisible(false);
        displayCoursesBox.setVisible(false);
    }
    public Button searchInstractor;
    public void searchInstractorClicked() {
        addStudentBox.setVisible(false);
        addInstractorBox.setVisible(false);
        addCoursesBox.setVisible(false);
        searchStudentBox.setVisible(false);
        searchInstractorBox.setVisible(true);
        searchCoursesBox.setVisible(false);
        displayStudentBox.setVisible(false);
        displayInstractorBox.setVisible(false);
        displayCoursesBox.setVisible(false);
    }
    public Button searchCourse;
    public void searchCourseClicked() {
        addStudentBox.setVisible(false);
        addInstractorBox.setVisible(false);
        addCoursesBox.setVisible(false);
        searchStudentBox.setVisible(false);
        searchInstractorBox.setVisible(false);
        searchCoursesBox.setVisible(true);
        displayStudentBox.setVisible(false);
        displayInstractorBox.setVisible(false);
        displayCoursesBox.setVisible(false);
    }
    public Button displayStudent;
    public void  displayStudentClicked() {
        addStudentBox.setVisible(false);
        addInstractorBox.setVisible(false);
        addCoursesBox.setVisible(false);
        searchStudentBox.setVisible(false);
        searchInstractorBox.setVisible(false);
        searchCoursesBox.setVisible(false);
        displayStudentBox.setVisible(true);
        displayInstractorBox.setVisible(false);
        displayCoursesBox.setVisible(false);
    }
    public Button displayInstactor;
    public void  displayInstactorClicked() {
        addStudentBox.setVisible(false);
        addInstractorBox.setVisible(false);
        addCoursesBox.setVisible(false);
        searchStudentBox.setVisible(false);
        searchInstractorBox.setVisible(false);
        searchCoursesBox.setVisible(false);
        displayStudentBox.setVisible(false);
        displayInstractorBox.setVisible(true);
        displayCoursesBox.setVisible(false);
    }
    public Button displayCourses;
    public void  displayCoursesClicked() {
        addStudentBox.setVisible(false);
        addInstractorBox.setVisible(false);
        addCoursesBox.setVisible(false);
        searchStudentBox.setVisible(false);
        searchInstractorBox.setVisible(false);
        searchCoursesBox.setVisible(false);
        displayStudentBox.setVisible(false);
        displayInstractorBox.setVisible(false);
        displayCoursesBox.setVisible(true);
    }

    //Add Student
    @FXML
    public TextField idSAdd;
    public TextField nameSAdd;
    public TextField ssnSAdd;
    public TextField ageSAdd;
    public TextField passSAdd;
    public void BtnAddStudentClicked() {
        try {
            if (new Admin_Imp().addStudent(Integer.parseInt(idSAdd.getText()), nameSAdd.getText(), passSAdd.getText(), Integer.parseInt(ageSAdd.getText()), Double.parseDouble(ssnSAdd.getText()))) {
                showinfoMess("Added Successfully");
            } else {
                showErrMess("ID is Taken");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID, Age and SSN must be Numbers");
        }
    }
    public void BtnCancelStudentClicked() {
        idSAdd.setText("");
        nameSAdd.setText("");
        ssnSAdd.setText("");
        ageSAdd.setText("");
        passSAdd.setText("");
    }

    //Add Instractor
    @FXML
    public TextField idIAdd;
    public TextField nameIAdd;
    public TextField ssnIAdd;
    public TextField ageIAdd;
    public TextField passIAdd;
    public TextField salaryIAdd;
    public void BtnAddInstractorClicked() {
        try {
            if (new Admin_Imp().addInstractor(Integer.parseInt(idIAdd.getText()), nameIAdd.getText(), passIAdd.getText(), Integer.parseInt(ageIAdd.getText()), Double.parseDouble(ssnIAdd.getText()), Double.parseDouble(salaryIAdd.getText()))) {
                showinfoMess("Added Successfully");
            } else {
                showErrMess("ID is Taken");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID, Age and SSN must be Numbers");
        }
    }
    public void BtnCancelInstractorClicked() {
        idIAdd.setText("");
        nameIAdd.setText("");
        ssnIAdd.setText("");
        ageIAdd.setText("");
        passIAdd.setText("");
    }

    //Add Courses
    //ToDo Stoped Here

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        launchWindow();
    }

    public void launchWindow() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminFrame.fxml"));
            Scene scene = new Scene(root, 600, 400);
            stage = new Stage();
            stage.setTitle("Admin");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            showErrMess("Error some file not found");
            //System.out.println("File Not Found");
        }
    }

    public void showErrMess(String mess) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(mess);
        alert.showAndWait();
    }

    public void showinfoMess(String mess) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(mess);
        alert.showAndWait();
    }

}
