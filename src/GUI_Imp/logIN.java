package GUI_Imp;
import Main.*;

public class logIN {

    Admin x = new Admin();
    Student y = new Student();
    Instractor z = new Instractor();

    public boolean ILOGIN (int ID, String pass) {

        if (x.Login(ID, pass)){
            // Start Admin
            System.out.println("Admin Entered");
            return true;
        } else if (y.Login(ID, pass)) {
            // Start Student
            System.out.println("Student Entered");
            return true;
        } else if (z.Login(ID, pass)) {
            //Start Instractor
            System.out.println("Instractor Entered");
            return true;
        }
        return false;

    }

}
