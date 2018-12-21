package Main;
import GUI_fx.*;
import java.io.*;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        String projectpath = System.getProperty("user.dir");
        projectpath += "/Files";
        File currentDir = new File(projectpath);
        System.out.println(projectpath);
        checkDirectoryContents(currentDir);
        checkDirectoryContents(currentDir);
        Application.launch(LogIn.class, args);
    }

    private static void checkDirectoryContents(File dir) {

        File[] files = dir.listFiles();
        boolean studentFileName = true;
        boolean instractorFileName = true;
        boolean coursesFileName = true;

        for (File file : files) {

            if (file.getName().equals("Student.bin")) {
                studentFileName = false;
            } else if (file.getName().equals("Instractor.bin")) {
                instractorFileName = false;
            } else if (file.getName().equals("Courses.bin")) {
                coursesFileName = false;
            }

        }

        if (studentFileName) {
            new Student().CommitToFile();
        }
        if (instractorFileName) {
            new Instractor().CommitToFile();
        }
        if (coursesFileName) {
            new Courses().CommitToFile();
        }

    }

}
