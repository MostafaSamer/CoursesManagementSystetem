package Main;

import java.io.Serializable;

public class Person implements Serializable, ILogin {

    private String Name;
    private int ID;
    private String Pass;
    private double SSN;
    private int age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public double getSSN() {
        return SSN;
    }

    public void setSSN(double SSN) {
        this.SSN = SSN;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {

    }

    public Person(String name, int ID, String pass, double SSN, int age) {
        this.setName(name);
        this.setID(ID);
        this.setPass(pass);
        this.setSSN(SSN);
        this.setAge(age);
    }

    @Override
    public boolean Login(String name, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
