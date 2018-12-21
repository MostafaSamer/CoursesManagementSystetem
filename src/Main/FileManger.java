package Main;
import java.io.*;

public class FileManger implements Serializable {

    public boolean write(String FilePath, Object data) {

        try {

            try (ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath))) {

                writter.writeObject(data);

            }
            return true;

        } catch (IOException e) {
            System.out.println("Can't write ...!\n" + e);
        }

        return false;
    }

    public Object read(String FilePath) {

        Object Result = null;

        try {

            try (ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath))) {
                Result = Reader.readObject();
            }
        } catch (IOException e) {
            System.out.println(e);
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Result;

    }

}
