package Main;

import java.util.ArrayList;

public class Courses {
    
    FileManger FManger = new FileManger();
    private final String courseFileName = "Courses.bin";
    private static ArrayList<Courses> courses;

    //Attributes
    public String name;
    public int code;
    private Double price;
    private Double grade;


    //Constructors
    public Courses() {
        
    }
    
    public Courses(String name, int code) {
        this.setName(name);
        this.setCode(code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //Files
    public boolean CommitToFile() {

        return (FManger.write(courseFileName, courses));

    }

    public void LoadFromFile() {

        courses = (ArrayList<Courses>) FManger.read(courseFileName);

    }

    //Methods
    public int GetCourses(int ID) {

        for (int i = 0; i < courses.size(); i++)
        {
            if(courses.get(i).getCode() == (ID)) {
                return i;
            }
        }

        return -1;

    }

    public boolean AddCourses() {

        LoadFromFile();
        int index = GetCourses(this.getCode());
        Exception myex = new Exception();
        if(index == -1) {
            courses.add(this);
            return CommitToFile();
        }
        return false;

    }

    public boolean UpdateCourses (int ID) {

        LoadFromFile();
        int index = GetCourses(ID);
        if(index != -1) {
            courses.set(index, this);
            return CommitToFile();
        }
        return false;

    }

    public boolean DeleteCourses(int ID) {

        LoadFromFile();
        int index = GetCourses(ID);
        if (index != -1) {
            courses.remove(index);
            return CommitToFile();
        }
        return false;
    }
    public Courses searchCourses(int   ID) {

        Courses temp = new Courses();
        LoadFromFile();
        int index = GetCourses(ID);
        if (index != -1) {

            return courses.get(index);

        } else {

            return temp;

        }

    }

    public ArrayList<Courses> ListCourses() {

        LoadFromFile();
        return courses;

    }

}
