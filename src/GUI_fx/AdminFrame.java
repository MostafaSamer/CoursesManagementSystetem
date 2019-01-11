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
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminFrame extends Application {

    public static Stage stage;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

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
        resetAll();
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
        resetAll();
        // ToDo Think for a way to Add All Instractor to the menu after clicking/
        // ToDo Think for a way to Store the instractor and the Student of the single Course
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
        resetAll();
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
        resetAll();
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
    resetAll();
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
    resetAll();
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
    resetAll();
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
    resetAll();
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
    resetAll();
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
                resetAll();
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
                resetAll();
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
    @FXML
    public TextField nameCAdd;
    public TextField codeCAdd;
    public TextField priceCAdd;
    public TextField gradeCAdd;
    public MenuButton startDateCAdd;
    public MenuButton endDateCAdd;
    public Button btnCourseAdd;
    public void btnCourseAddClicked() {
        try {
            //public Courses(String name, int code, Double price, Double grade, Date startDate, Date endDate) {
            if (new Admin_Imp().addCourse(nameCAdd.getText(), Integer.parseInt(codeCAdd.getText()), Double.parseDouble(priceCAdd.getText()), Double.parseDouble(gradeCAdd.getText()), format.parse(startDateCAdd.getText()), format.parse(endDateCAdd.getText()))) {
                showinfoMess("Added Successfully");
                resetAll();
            } else {
                showErrMess("ID is Taken");
            }
        } catch (NumberFormatException e) {
            showErrMess("Price, Grade and Code must be Numbers");
        } catch (Exception e) {
            showErrMess("Date Error");
        }
    }
    public Button btnCourseCancel;
    public void btnCourseCancelClicked() {

    }

    //SearchStudent
    public TextField idSSearch;
    public TextField nameSSearch;
    public TextField ssnSSearch;
    public TextField ageSSearch;
    public TextField courseSSearch;
    public Button btnStudentSearch;
    public void btnStudentSearchClicked() {
        try {
            if (!(new Admin_Imp().searchStudent(Integer.parseInt(idSSearch.getText())).getAge() == 0)) {
                Student s = new Admin_Imp().searchStudent(Integer.parseInt(idSSearch.getText()));
                nameSSearch.setText(s.getName());
                ssnSSearch.setText(Double.toString(s.getSSN()));
                ageSSearch.setText((Integer.toString(s.getAge())));
               // nameSSearch.setText(s.getName());
            } else {
                showErrMess("User Not Found");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID must be a Number");
        }
    }
    public Button btnStudentUpdate;
    public void btnStudentUpdateClicked() {
        try {
            if (!(new Admin_Imp().searchStudent(Integer.parseInt(idSSearch.getText())).getAge() == 0)) {
                Student s = new Admin_Imp().searchStudent(Integer.parseInt(idSSearch.getText()));
                s.setName(nameSSearch.getText());
                s.setAge(Integer.parseInt(ageSSearch.getText()));
                s.setSSN(Double.parseDouble(ssnSSearch.getText()));
                s.UpdateStudent(Integer.parseInt(idSSearch.getText()));
                showinfoMess("Updated");
                resetAll();
                // nameSSearch.setText(s.getName());
            } else {
                showErrMess("User Not Found");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID must be a Number");
        }
    }
    public Button btnStudentDelete;
    public void btnStudentDeleteClicked() {
        try {
            if (new Student().DeleteStudent(Integer.parseInt(idSSearch.getText()))) {
                showinfoMess("Deleted");
                resetAll();
                // nameSSearch.setText(s.getName());
            } else {
                showErrMess("User Not Found");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID must be a Number");
        }
    }

    //SearchInstractor
    public TextField idISearch;
    public TextField nameISearch;
    public TextField ssnISearch;
    public TextField ageISearch;
    public TextField salaryISearch;
    public Button btnInstractorSearch;
    public void btnInstractorSearchClicked() {
        try {
            if (!(new Admin_Imp().searchInstractor(Integer.parseInt(idISearch.getText())).getAge() == 0)) {
                Instractor s = new Admin_Imp().searchInstractor(Integer.parseInt(idISearch.getText()));
                nameISearch.setText(s.getName());
                ssnISearch.setText(Double.toString(s.getSSN()));
                ageISearch.setText((Integer.toString(s.getAge())));
                // nameSSearch.setText(s.getName());
            } else {
                showErrMess("User Not Found");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID must be a Number");
        }
    }
    public Button btnInstractorUpdate;
    public void btnInstractorUpdateClicked() {
        try {
            if (!(new Admin_Imp().searchInstractor(Integer.parseInt(idISearch.getText())).getAge() == 0)) {
                Instractor s = new Admin_Imp().searchInstractor(Integer.parseInt(idISearch.getText()));
                s.setName(nameISearch.getText());
                s.setAge(Integer.parseInt(ageISearch.getText()));
                s.setSSN(Double.parseDouble(ssnISearch.getText()));
                s.UpdateInstractor(Integer.parseInt(idISearch.getText()));
                showinfoMess("Updated");
                resetAll();
                // nameSSearch.setText(s.getName());
            } else {
                showErrMess("User Not Found");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID must be a Number");
        }
    }
    public Button btnInstractorDelete;
    public void btnInstractorDeleteClicked() {
        try {
            if (new Student().DeleteStudent(Integer.parseInt(idISearch.getText()))) {
                showinfoMess("Deleted");
                resetAll();
                // nameSSearch.setText(s.getName());
            } else {
                showErrMess("User Not Found");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID must be a Number");
        }
    }
    //Search Courses
    public TextField idCSearch;
    public TextField nameCSearch;
    public TextField priceCSearch;
    public TextField gradeCSearch;
    public Button btnCoursesSearch;
    public void btnCoursesSearchClicked() {
        //ToDo CheckPoint :)
    }
    public Button btnCoursesUpdate;
    public void btnCoursesUpdateClicked() {

    }
    public Button btnCoursesDelete;
    public void btnCoursesDeleteClicked() {
        try {
            if (new Courses().DeleteCourses(Integer.parseInt(idCSearch.getText()))) {
                showinfoMess("Deleted");
                resetAll();
                // nameSSearch.setText(s.getName());
            } else {
                showErrMess("User Not Found");
            }
        } catch (NumberFormatException e) {
            showErrMess("ID must be a Number");
        }
    }


    public void resetAll() {
        idSAdd.setText("");
        nameSAdd.setText("");
        ssnSAdd.setText("");
        ageSAdd.setText("");
        passSAdd.setText("");
        idIAdd.setText("");
        nameIAdd.setText("");
        ssnIAdd.setText("");
        ageIAdd.setText("");
        passIAdd.setText("");
        salaryIAdd.setText("");
        nameCAdd.setText("");
        codeCAdd.setText("");
        priceCAdd.setText("");
        gradeCAdd.setText("");
        idSSearch.setText("");
        nameSSearch.setText("");
        ssnSSearch.setText("");
        ageSSearch.setText("");
        courseSSearch.setText("");
        idISearch.setText("");
        nameISearch.setText("");
        ssnISearch.setText("");
        ageISearch.setText("");
        salaryISearch.setText("");
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
        alert.setHeaderText(mess + " :(");
        alert.showAndWait();
    }

    public void showinfoMess(String mess) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(mess + " :)");
        alert.showAndWait();
    }

}
