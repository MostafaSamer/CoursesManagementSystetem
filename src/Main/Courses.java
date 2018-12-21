package Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class Courses implements Serializable {
    
    FileManger FManger = new FileManger();
    private final String courseFileName = "Files/Courses.bin";
    private static Hashtable<Integer, Courses> courses;

    //Attributes
    private String name;
    private int code;
    private Double price;
    private Double grade;
    private Date startDate;
    private Date endDate;

    //Constructors
    public Courses() {
        courses = new Hashtable<Integer, Courses>();
    }

    public Courses(String name, int code, Double price, Double grade, Date startDate, Date endDate) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.grade = grade;
        this.startDate = startDate;
        this.endDate = endDate;
        courses = new Hashtable<Integer, Courses>();
    }

    //Setter & Getter
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //Files
    public boolean CommitToFile() {

        return (FManger.write(courseFileName, courses));

    }

    public void LoadFromFile() {

        courses = (Hashtable<Integer, Courses>) FManger.read(courseFileName);

    }

    //Methods
    public boolean AddCourses() {

        LoadFromFile();
        if (courses.get(this.getCode()) == null) {
            courses.put(this.code, this);
            CommitToFile();
            return true;
        }
        return false;

    }

    public boolean UpdateCourses (int ID) {

        LoadFromFile();
        if(courses.get(ID) != null) {
            courses.putIfAbsent(ID, this);
            return CommitToFile();
        }
        return false;

    }

    public boolean DeleteCourses(int ID) {

        LoadFromFile();
        if (courses.get(ID) != null) {
            courses.remove(ID);
            return CommitToFile();
        }
        return false;
    }
    public Courses searchCourses(int   ID) {

        Courses temp = new Courses();
        LoadFromFile();
        if (courses.get(ID) != null) {

            return courses.get(ID);

        } else {

            return temp;

        }

    }

    public Hashtable<Integer, Courses>ListCourses() {

        LoadFromFile();
        return courses;

    }

}
