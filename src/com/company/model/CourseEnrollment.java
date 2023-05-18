package com.company.model;

import com.company.view.repository.CourseEnrollmentRepository;

import java.util.ArrayList;

public class CourseEnrollment {
    int id;
    Student student;
    Course course;
    static int lastID = 0;
    static ArrayList<CourseEnrollment> list = new ArrayList<>();

    public CourseEnrollment(Student student, Course course) {
        this.id = lastID++;
        this.student = student;
        this.course = course;
        list.add(this);
        CourseEnrollmentRepository.insertEnrollment(student.getId(),course.getId());
    }

    public CourseEnrollment(int id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
        list.add(this);
    }

    public static ArrayList<Course> getCoursesByStudent(Student student) {
        ArrayList<Course> courses = new ArrayList<>();

        for (CourseEnrollment courseEnrollment : list) {
            if (courseEnrollment.student.getId() == student.getId())
                courses.add(courseEnrollment.course);
        }
        return courses;
    }

    public static ArrayList<Student> getStudentsByCourse(Course course) {
        ArrayList<Student> students = new ArrayList<>();
        for (CourseEnrollment courseEnrollment : list) {
            if (courseEnrollment.course.getId() == course.getId())
                students.add(courseEnrollment.student);
        }
        return students;
    }

    @Override
    public String toString() {
        return id + ". (" + student.getId() + " " + student.getName() + " " + student.getSurname() + ") (" + course.getId() +" " + course.getTitle() + " " + course.getDescription() + " )";
    }

    public static ArrayList<CourseEnrollment> getAllEnrollments(){
        return list;
    }
}
