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
    public Button addStudent;
    public Button addInstractor;
    public TextField idSAdd;
    public TextField nameSAdd;
    public TextField ssnSAdd;
    public TextField ageSAdd;
    public PasswordField passSAdd;
    public TextField idIAdd;
    public TextField nameIAdd;
    public TextField ssnIAdd;
    public TextField ageIAdd;
    public TextField salaryIAdd;
    public PasswordField passIAdd;
    public Button btnStudentAdd;
    public Button btnStudentCancel;
    public VBox AddStudentBox;
    public VBox AddInstractorBox;
    public VBox SearchPepoleBox;
    public Button btnInstractorAdd;
    public Button btnInstractorCancel;
    public Button searchPersonbtn;
    public TextField idSearchID;
    public Button logOut;
    public TextField nameSeachStudent;
    public TextField ssnSeachStudent;
    public TextField ageSeachStudent;
    public TextField coursesSeachStudent;

    //Add Student
    @FXML
    public void btnAddStudentClicked() {
        AddStudentBox.setVisible(true);
        AddInstractorBox.setVisible(false);
        SearchPepoleBox.setVisible(false);
    }
    @FXML
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
    @FXML
    public void BtnCancelStudentClicked() {
        idSAdd.setText("");
        nameSAdd.setText("");
        ssnSAdd.setText("");
        ageSAdd.setText("");
        passSAdd.setText("");
    }

    //Add Instractor
    @FXML
    public void btnAddInterstractorClicked() {
        AddStudentBox.setVisible(false);
        AddInstractorBox.setVisible(true);
        SearchPepoleBox.setVisible(false);
    }
    @FXML
    public void BtnAddInstractorClicked() {
        //public boolean addStudent(int id, String name, String pass, int age, double ssn)
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
    @FXML
    public void BtnCancelInstractorClicked() {
        idIAdd.setText("");
        nameIAdd.setText("");
        ssnIAdd.setText("");
        ageIAdd.setText("");
        passIAdd.setText("");
    }

    //Search Person
    @FXML
    public void searchPersonClicked() {
        AddStudentBox.setVisible(false);
        AddInstractorBox.setVisible(false);
        SearchPepoleBox.setVisible(true);
    }
    public void searchPersonbtnClicked() {
        Student s = new Student().searchStudent(Integer.parseInt(idSearchID.getText()));
        if (!(s.getAge() == 0)) {
            nameSeachStudent.setText(s.getName());
            ssnSeachStudent.setText(Double.toString(s.getSSN()));
            ageSeachStudent.setText(Integer.toString(s.getAge()));
            // ToDo SSN issue in casting to String
            // ToDo coursesSeachStudent.setText();
        } else {
            showErrMess("Student Not Found");
        }
    }

    //LogOut
    public void logOutClicked() {
        //ToDo Close This Frame, and Open Th Login Frame
    }

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
