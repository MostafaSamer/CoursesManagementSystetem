package GUI_fx;

import GUI_Imp.Admin_Imp;
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
    public TextField idAdd;
    public TextField nameAdd;
    public TextField ssnAdd;
    public TextField ageAdd;
    public PasswordField passAdd;
    public Button btnStudentAdd;
    public Button btnStudentCancel;
    public VBox AddBox;

    //Slide Button
    @FXML
    public void btnAddStudentClicked() {
        AddBox.setVisible(true);
    }
    @FXML
    public void BtnAddStudentClicked() {
        //public boolean addStudent(int id, String name, String pass, int age, double ssn)
        try {
            if (new Admin_Imp().addStudent(Integer.parseInt(idAdd.getText()), nameAdd.getText(), passAdd.getText(), Integer.parseInt(ageAdd.getText()), Double.parseDouble(ssnAdd.getText()))) {
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
        idAdd.setText("");
        nameAdd.setText("");
        ssnAdd.setText("");
        ageAdd.setText("");
        passAdd.setText("");
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
