package Main;

import java.util.ArrayList;

public class Instractor extends Person {

    private final String insteractorFileName = "Instractor.bin";
    private static ArrayList<Instractor> instractors;

    //Attributes
    public Double Salary;

    //Constructors
    public Instractor() {
        instractors = new ArrayList<>();
    }

    public Instractor(String name, int ID, String pass, double SSN, int age, Double salary) {
        instractors = new ArrayList<>();
        this.setName(name);
        this.setID(ID);
        this.setPass(pass);
        this.setSSN(SSN);
        this.setAge(age);
        this.setSalary(salary);
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

        instractors = (ArrayList<Instractor>) FManger.read(insteractorFileName);

    }

    //Methods
    public int GetInstractor(int ID) {

        for (int i = 0; i < instractors.size(); i++)
        {
            if(instractors.get(i).getID() == (ID)) {
                return i;
            }
        }

        return -1;

    }

    public boolean AddInstractor () {

        LoadFromFile();
        int index = GetInstractor(this.getID());
        Exception myex = new Exception();
        if(index == -1) {
            instractors.add(this);
            return CommitToFile();
        }
        return false;

    }

    public boolean UpdateInstractor (int ID) {

        LoadFromFile();
        int index = GetInstractor(ID);
        if(index != -1) {
            instractors.set(index, this);
            return CommitToFile();
        }
        return false;

    }

    public boolean DeleteInstractor(int ID) {

        LoadFromFile();
        int index = GetInstractor(ID);
        if (index != -1) {
            instractors.remove(index);
            return CommitToFile();
        }
        return false;
    }
    public Instractor searchInstractor(int   ID) {

        Instractor temp = new Instractor();
        LoadFromFile();
        int index = GetInstractor(ID);
        if (index != -1) {

            return instractors.get(index);

        } else {

            return temp;

        }

    }

    public ArrayList<Instractor> ListInstractor() {

        LoadFromFile();
        return instractors;

    }

    @Override
    public boolean Login(int ID, String Pass) {
        LoadFromFile();
        for (Instractor x : instractors) {
            if (ID == x.getID() && Pass.equals(x.getPass())) {
                return true;
            }
        }
        return false;
    }

}
