package GUI_fx;

import javafx.application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
            new logIN().ILOGIN(Integer.parseInt(idEnter.getText()), passEnter.getText().toString());
        } catch (NumberFormatException e) {
            // IF ID Was not a Number
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Log In");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}
