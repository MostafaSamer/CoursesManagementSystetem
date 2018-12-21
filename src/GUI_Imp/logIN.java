package GUI_Imp;
import GUI_fx.AdminFrame;
import GUI_fx.InstractorFrame;
import GUI_fx.LogIn;
import GUI_fx.StudentFrame;
import Main.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class logIN {

    Admin x = new Admin();
    Student y = new Student();
    Instractor z = new Instractor();

    public boolean ILOGIN (int ID, String pass) {

        if (x.Login(ID, pass)){
            // Start Admin
            //System.out.println("Admin Entered");
            new AdminFrame().launchWindow();
            return true;
        } else if (y.Login(ID, pass)) {
            // Start Student
            //System.out.println("Student Entered");
            new StudentFrame().launchWindow();
            return true;
        } else if (z.Login(ID, pass)) {
            //Start Instractor
            //System.out.println("Instractor Entered");
            new InstractorFrame().launchWindow();
            return true;
        }
        return false;
        //TODo Close the Log in Class after Loging in
    }

}
