package edu.isu.cs2263.hw02;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a student and stores their name and a list of courses on their schedule
 *
 * @author Michael Collier
 *
 * @since 2.0.0
 */
public class Student {

    String firstName, lastName;
    List<Course> courseList;

    public Student(String firstName, String lastName, List courseList){
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseList = courseList;
    }

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseList = new ArrayList<>();
    }

    public String getCourseList(){
        String courses = "";
        for(Course c : this.courseList){
            courses += c.toString() + "\n ";
        }
        return courses;
    }

    /**
     * adds a course to the student's list
     *
     * @param course the course to be added
     */
    public void addCourse(Course course){
        this.courseList.add(course);
    }

    /**
     * gets the first name of the student
     *
     * @return student's first name
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * sets the first name of the student
     *
     * @param firstName This the new first name for the student
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * gets the last name of the student
     *
     * @return student's last name
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * sets the last name of the student
     *
     * @param lastName This the new last name for the student
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * converts the first and last name into a single string
     *
     * @return the name of the student in the form lastname, firstname
     */
    public String toString(){
        return this.lastName + ", " + this.firstName;
    }
}
