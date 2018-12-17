package Main;

public class Admin extends Person {
    @Override
    public boolean Login (int ID , String pass) {

        if (ID == 123 && pass.equals("123")) {

            return  true;
        }

        return false;

    }
}
