package Main;

public class Admin extends Person {
    @Override
    public boolean Login (String username , String pass) {

        if (username.equals("Admin")&&pass.equals("123")) {

            return  true;
        }

        return false;

    }
}
