package Main;

import java.util.ArrayList;

public class Student extends Person {

    private final String studentFileName = "Student.bin";
    private static ArrayList<Student> student;

    //Attributes


    //Constructors
    public Student() {
        student = new ArrayList<>();
    }

    public Student(String name, int ID, String pass, double SSN, int age) {
        student = new ArrayList<>();
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

        student = (ArrayList<Student>) FManger.read(studentFileName);

    }

    //Setter & Getter
    public int GetStudent(int ID) {

        for (int i = 0; i < student.size(); i++)
        {
            if(student.get(i).getID() == (ID)) {
                return i;
            }
        }

        return -1;

    }

    // Methods
    public boolean AddStudent () {

        LoadFromFile();
        int index = GetStudent(this.getID());
        
        if(index == -1) {
            student.add(this);
            return CommitToFile();
        }
        return false;

    }

    public boolean UpdateStudent (int ID) {

        LoadFromFile();
        int index = GetStudent(ID);
        if(index != -1) {
            student.set(index, this);
            return CommitToFile();
        }
        return false;

    }

    public boolean DeleteStudent(int ID) {

        LoadFromFile();
        int index = GetStudent(ID);
        if (index != -1) {
            student.remove(index);
            return CommitToFile();
        }
        return false;
    }
    public Student searchStudent(int   ID) {

        Student temp = new Student();
        LoadFromFile();
        int index = GetStudent(ID);
        if (index != -1) {

            return student.get(index);

        } else {

            return temp;

        }

    }

    public ArrayList<Student> ListStudent() {

        LoadFromFile();
        return student;

    }

    @Override
    public boolean Login(int ID, String Pass) {
        LoadFromFile();
        for (Student x : student) {
            if (ID == x.getID() && Pass.equals(x.getPass())) {
                return true;
            }
        }
        return false;
    }
}
