package com.company.model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Course {
    private int id;
    private String title;
    private String description;
    static int lastID = 0;
    public static ArrayList<Course> list = new ArrayList<>();

    static String[] headers = {"ID", "Title", "Description"};
    public static DefaultTableModel model = new DefaultTableModel(headers, 0);


    public Course(String title, String description) {
        this.id = lastID++;
        setProperties(title, description);
    }
    public Course(int id, String title, String description) {
        this.id = id;
        setProperties(title, description);
    }


    public void setProperties(String title, String description) {
        this.title = title;
        this.description = description;
        list.add(this);
        addRow(this);
    }

    public static void addRow(Course course) {
        model.addRow(
                new Object[]{
                        course.id,
                        course.title,
                        course.description
                }
        );
    }

    public static Course getCourseById(int id){
        for (Course course: list) {
            if (course.id == id){
                return course;
            }
        }
        return null;
    }

    public CourseEnrollment addStudent(Student student){
        return new CourseEnrollment(student, this);
    }


    public ArrayList<Student> getStudents(){
        return CourseEnrollment.getStudentsByCourse(this);
    }
    @Override
    public String toString() {
        return id + ". " + title + " " + description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
