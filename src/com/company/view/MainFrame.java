package com.company.view;

import com.company.view.course.AddCourseFrame;
import com.company.view.course.CourseListPanel;
import com.company.view.student.AddStudentFrame;
import com.company.view.student.StudentListPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static AddStudentFrame addStudentFrame = new AddStudentFrame();
    public static AddCourseFrame addCourseFrame = new AddCourseFrame();
    public static StudentListPanel studentListPanel = new StudentListPanel();
    public static CourseListPanel courseListPanel = new CourseListPanel();

    public MainFrame() {
        setTitle("Окно");
        setSize(500, 500);
        setLocation(720, 200);
        setLayout(new FlowLayout());
        setJMenuBar(new MainMenuBar());
        add(studentListPanel);

        setVisible(true);
    }
}
