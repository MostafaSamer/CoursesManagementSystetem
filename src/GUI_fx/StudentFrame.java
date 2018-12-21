package GUI_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentFrame extends Application {

    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        launchWindow();
    }
    public void launchWindow() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("StudentFrame.fxml"));
            Scene scene = new Scene(root, 600, 400);
            stage = new Stage();
            stage.setTitle("Student");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error some file not found");
            alert.showAndWait();
            //System.out.println("File Not Found");
        }
    }
}
