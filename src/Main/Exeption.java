package Main;

import javafx.scene.*;
import javafx.scene.control.Alert;

public class Exeption {

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
