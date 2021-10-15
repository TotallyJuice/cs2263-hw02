package edu.isu.cs2263.hw02;

/**
 * Represents a course that students can have in their course list
 *
 * @author Michael Collier
 *
 * @since 2.0.0
 */
public class Course {

    int number;
    String subject;
    String title;

    public Course(int number, String subject, String title){
        this.number = number;
        this.subject = subject;
        this.title = title;
    }

    /**
     * gets the course number
     *
     * @return this course's number
     */
    public int getNumber() {
        return number;
    }

    /**
     * sets the course number
     *
     * @param number This is the new number for the course
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * gets the subject the course is filed under
     *
     * @return the subject of the course
     */
    public String getSubject() {
        return subject;
    }

    /**
     * sets the subject of the course
     *
     * @param subject the new subject of the course
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * gets the title of the course
     *
     * @return the course's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title for the course
     *
     * @param title the new title for the course
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * returns the info of the course if the format Subject Number Title
     *
     * @return a string with the details of the class
     */
    public String toString(){
        return subject + " " + Integer.toString(number) + " " + title;
    }
}
