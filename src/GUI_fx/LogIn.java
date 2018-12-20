package GUI_fx;

import javafx.application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.*;
import java.io.IOException;
import GUI_Imp.*;

public class LogIn extends Application {

    @FXML
    public TextField idEnter;
    public PasswordField passEnter;
    public Button btnEnter;

    public void logInClicked() {
        try {
            if(!new logIN().ILOGIN(Integer.parseInt(idEnter.getText()), passEnter.getText().toString())) {
                //User Not Found
                System.out.println("User Not Found");
            } else {

                System.out.println("Log in out");
            }
        } catch (NumberFormatException e) {
            // IF ID Was not a Number
            System.out.println("Number Error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        launchWindow();
    }
    //TODO change the mouse curse when it hover on a button
    //TODO change the button color when te mouse hover on it

    public void launchWindow() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
            Scene scene = new Scene(root, 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Log In");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

}