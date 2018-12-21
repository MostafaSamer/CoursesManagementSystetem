package GUI_Imp;
import Main.*;

public class Admin_Imp {

    public boolean addStudent(int id, String name, String pass, int age, double ssn) {
        if (new Student(name, id, pass, ssn, age).AddStudent()) {
            return true;
        }
        return false;
    }
}
