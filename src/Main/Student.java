package Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Student extends Person implements Serializable {

    private final String studentFileName = "Files/Student.bin";
    private static Hashtable<Integer, Student> student;

    //Attributes


    //Constructors
    public Student() {
        student = new Hashtable<Integer, Student>();
    }

    public Student(String name, int ID, String pass, double SSN, int age) {
        student = new Hashtable<Integer, Student>();
        this.setName(name);
        this.setID(ID);
        this.setPass(pass);
        this.setSSN(SSN);
        this.setAge(age);
    }

    //Files
    public boolean CommitToFile() {

        return (FManger.write(studentFileName, student));

    }

    public void LoadFromFile() {

        student = (Hashtable<Integer, Student>) FManger.read(studentFileName);

    }

    //Setter & Getter


    // Methods
    public boolean AddStudent () {

        LoadFromFile();
        if (student.get(this.getID()) == null) {
            student.put(this.getID(), this);
            CommitToFile();
            return true;
        }
        return false;

    }

    public boolean UpdateStudent (int ID) {

        LoadFromFile();
        if(student.get(ID) != null) {
            student.putIfAbsent(ID, this);
            return CommitToFile();
        }
        return false;

    }

    public boolean DeleteStudent(int ID) {

        LoadFromFile();
        if (student.get(ID) != null) {
            student.remove(ID);
            return CommitToFile();
        }
        return false;
    }
    public Student searchStudent(int   ID) {

        Student temp = new Student();
        LoadFromFile();
        if (student.get(ID) != null) {

            return student.get(ID);

        } else {

            return temp;

        }

    }

    public Hashtable<Integer, Student> ListStudent() {

        LoadFromFile();
        return student;

    }

    @Override
    public boolean Login(int ID, String Pass) {

        LoadFromFile();
        if (student.get(ID) != null && student.get(ID).getPass() == Pass) {
            return true;
        }
        return false;

    }
}
