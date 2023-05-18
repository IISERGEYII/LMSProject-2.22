package com.company.model;

import java.util.ArrayList;

public class AcademicPerformance {
    int id;
    int mark;
    CourseEnrollment courseEnrollment;

    static int lastID = 0;
    static ArrayList<AcademicPerformance> list = new ArrayList<>();

    public AcademicPerformance(int mark, CourseEnrollment courseEnrollment) {
        this.id = lastID++;
        this.mark = mark;
        this.courseEnrollment = courseEnrollment;
        list.add(this);
    }

    public String toString() {
        return courseEnrollment.student + " - " + courseEnrollment.course + " " + mark;
    }

    public static ArrayList<Integer> getMarksByStudentAndCourse(Student student, Course course) {
        ArrayList<Integer> marks = new ArrayList<>();

        for (AcademicPerformance ac : list) {
            if (ac.courseEnrollment.student.getId() == student.getId() && ac.courseEnrollment.course.getId() == course.getId()) {
                marks.add(ac.mark);
            }
        }
        return marks;
    }
}
