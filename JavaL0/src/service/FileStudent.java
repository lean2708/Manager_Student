package service;

import fact.Student;

import java.io.*;
import java.util.ArrayList;

public class FileStudent {
    private static final String FILE_NAME = "student.txt";
    public static void SaveFile(ArrayList<Student> students) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        for(Student student : students){
            bw.write(student.toString());
            bw.newLine();
        }
        bw.close();
        osw.close();
        fos.close();
    }
}
