package edu.isu.cs2263.hw02;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.*;


/**
 * A class that creates and manages the UI of the app
 *
 * @author Michael Collier
 *
 * @since 2.0.0
 */
public class UIHandler extends Application {

    Loader loader;
    List<Student> students;

    public UIHandler(){
        this.loader = new Loader();
        students = loader.getStudents();
    }

    /**
     * sets up the UI for the app
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        TilePane root = new TilePane();


        Button loadButton = new Button("Load");




        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                loader.loadStudents();
                addStudents(root);
                root.getChildren().remove(loadButton);
            }
        });

        Scene scene = new Scene(root, 600, 300);


        root.getChildren().add(loadButton);

        primaryStage.setTitle("Course View");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public void run(){
        launch();
    }

    /**
     * adds the UI elements for displaying the students and their courses
     *
     * @param root the root scene to add the UI to
     */
    private void addStudents(TilePane root){
        students = loader.getStudents();

        String[] names = getStudentNames(students);
        Label courses = new Label("Please select a student");

        ComboBox studentSelect = new ComboBox(FXCollections.observableArrayList(names));

        EventHandler<ActionEvent> selectStudent = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                courses.setText(getStudentCourses(students, (String) studentSelect.getValue()));
            }
        };

        studentSelect.setOnAction(selectStudent);

        root.getChildren().add(studentSelect);
        root.getChildren().add(courses);

    }

    /**
     * turns a list of student objects into an array of thier names
     *
     * @param students A list of students
     * @return an array of the names of the students
     */
    private String[] getStudentNames(List students){
        String[] names = new String[students.size()];
        for(int i = 0; i < students.size(); i++){
            names[i] = students.get(i).toString();
        }
        return names;
    }

    /**
     * Finds the student object from the string version of the student and returns a string of all their courses
     *
     * @param students This is a list of alL of students
     * @param student This is the string form of the student that the courses are needed from
     * @return a string of all the courses that student is taking
     */
    private String getStudentCourses(List<Student> students, String student){
        String courses = "";

        for(Student s : students){
            if(student.equals(s.toString())){
                return s.getCourseList();
            }
        }

        return courses;
    }


}
