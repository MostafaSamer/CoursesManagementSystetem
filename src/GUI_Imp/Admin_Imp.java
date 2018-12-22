package GUI_Imp;
import Main.*;

public class Admin_Imp {

    public boolean addStudent(int id, String name, String pass, int age, double ssn) {
        if (new Student(name, id, pass, ssn, age).AddStudent()) {
            return true;
        }
        return false;
    }

    public boolean addInstractor(int id, String name, String pass, int age, double ssn, double salary) {
        if (new Instractor(name, id, pass, ssn, age, salary).AddInstractor()) {
            return true;
        }
        return false;
    }

    //TODO make sure that the id of the new person is not used in the other modeuel

}
