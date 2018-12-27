package Main;

public class Admin extends Person {
    @Override
    public boolean Login (int ID , String pass) {

       
        return (ID == 123 && pass.equals("123"));

    }
}
