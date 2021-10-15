package edu.isu.cs2263.hw02;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads and stores the list of student and their classes
 *
 * @author Michael Collier
 *
 * @since 2.0.0
 */
public class Loader {

    List<Student> students;
    private final String FILE_NAME = "src/main/resources/studentFile.txt";

    public Loader(){
        this.students = new ArrayList<Student>();
    }

    /**
     * gives the list of students in the system
     *
     * @return a list of student objects
     */
    public List getStudents(){
        return students;
    }

    /**
     * used to create some students and their classes
     */
    private void generateStudents(){
        Student bob = new Student("Bob", "Jones");
        bob.addCourse(new Course(2269, "Math", "Counting to ten"));
        bob.addCourse(new Course(1234, "English", "Reading Lit"));
        students.add(bob);
        Student ron = new Student("Ron", "Willis");
        ron.addCourse(new Course(3355, "Physics", "Stuff that moves"));
        students.add(ron);
    }

    /**
     * loads the students from a file in the resource folder
     */
    public void loadStudents(){
        try {
            File file = new File(FILE_NAME);

            BufferedReader br = new BufferedReader(new FileReader(file));

            Gson gson = new Gson();

            String student;

            while((student = br.readLine()) != null){
                Student s = gson.fromJson(student, Student.class);
                students.add(s);
            }
        }catch(IOException e){
            System.out.println("problems with reading in file");
            e.printStackTrace();
        }
    }

    /**
     * writes the current student list to a file in the resource folder
     * uses gson to store object data
     */
    private void saveStudents(){
        try{
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            Gson gson = new Gson();
            for(Student s : students){
                String json = gson.toJson(s);
                fileWriter.write(json + "\n");
            }
            fileWriter.close();
        }catch(IOException e){
            System.out.println("error in trying to save students");
            e.printStackTrace();
        }
    }

    /**
     * used to create the file to save the students data to
     */
    private void createFile(){
        try{
            File saveFile = new File(FILE_NAME);
            System.out.println("file created" + saveFile.createNewFile());
        }catch(Exception e){
            System.out.println("couldn't create file");
        }
    }


}
