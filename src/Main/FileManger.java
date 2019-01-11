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
            new Exception.showErrMess("File Error in FileManger");
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
            new Exception.showErrMess("File Error in FileManger");
        }  catch (ClassNotFoundException e) {
            new Exception.showErrMess("Class Not Found Error in FileManger");
        }

        return Result;

    }

}
