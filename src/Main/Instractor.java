package Main;

import java.io.Serializable;
import java.util.Hashtable;

public class Instractor extends Person implements Serializable {

    private final String insteractorFileName = "Files/Instractor.bin";
    private static Hashtable<Integer, Instractor>  instractors;

    //Attributes
    public Double Salary;

    //Constructors
    public Instractor() {
        instractors = new Hashtable<Integer, Instractor>();
    }

    public Instractor(String name, int ID, String pass, double SSN, int age, Double salary) {
        this.setName(name);
        this.setID(ID);
        this.setPass(pass);
        this.setSSN(SSN);
        this.setAge(age);
        this.setSalary(salary);
        instractors = new Hashtable<Integer, Instractor>();
    }

    //Setter & Getter
    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    //Files
    public boolean CommitToFile() {

        return (FManger.write(insteractorFileName, instractors));

    }

    public void LoadFromFile() {

        instractors = (Hashtable<Integer, Instractor> ) FManger.read(insteractorFileName);

    }

    //Methods
    public boolean AddInstractor () {

        LoadFromFile();
        if (instractors.get(this.getID()) == null) {
            instractors.put(this.getID(), this);
            CommitToFile();
            return true;
        }
        return false;

    }

    public boolean UpdateInstractor (int ID) {

        LoadFromFile();
        if(instractors.get(ID) != null) {
            instractors.replace(ID, this);
            return CommitToFile();
        }
        return false;

    }

    public boolean DeleteInstractor(int ID) {

        LoadFromFile();
        if (instractors.get(ID) != null) {
            instractors.remove(ID);
            return CommitToFile();
        }
        return false;

    }
    public Instractor searchInstractor(int   ID) {

        Instractor temp = new Instractor();
        LoadFromFile();
        if (instractors.get(ID) != null) {

            return instractors.get(ID);

        } else {

            return temp;

        }

    }

    public Hashtable<Integer, Instractor>  ListInstractor() {

        LoadFromFile();
        return instractors;

    }

    @Override
    public boolean Login(int ID, String Pass) {

        LoadFromFile();
        if (instractors.get(ID) != null && instractors.get(ID).getPass() == Pass) {
            return true;
        }
        return false;

    }

}
