package GUI_Imp;
import Main.*;

import java.util.Date;

public class Admin_Imp {

    public boolean addStudent(int id, String name, String pass, int age, double ssn) {
        if (cheackID(id) && new Student(name, id, pass, ssn, age).AddStudent()) {
            return true;
        }
        return false;
    }

    public boolean addInstractor(int id, String name, String pass, int age, double ssn, double salary) {
        if (cheackID(id) && new Instractor(name, id, pass, ssn, age, salary).AddInstractor()) {
            return true;
        }
        return false;
    }

    public boolean cheackID(int id) {
        if(new Student().searchStudent(id).getAge() == 0 && new Instractor().searchInstractor(id).getAge() == 0) {
            return true;
        } return false;
    }

    public boolean cheackCode(int code) {
        if(new Courses().searchCourses(code).getGrade() == 0) {
            return true;
        } return false;
    }

    public boolean addCourse(String name, int code, Double price, Double grade, Date startDate, Date endDate) {
        if (cheackCode(code) && new Courses(name, code , price, grade, startDate, endDate).AddCourses()) {
            return true;
        }
        return false;
    }

    public boolean addCourseToInstractor(int code, int id) {
        return false;
    }

}
