package com.company.view.course;

import com.company.model.Course;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseCourse extends JFrame {
    CourseListPanel panel;
    public ChooseCourse(Student student){
        setTitle("Выбор курса");
        setSize(500,500);
        setLocation(650,150);
        setLayout(new FlowLayout());
        panel = new  CourseListPanel();
        add(panel);

        JButton button = new JButton("Заччислить");
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = panel.table.getSelectedRow();
                int id = (int) panel.table.getValueAt(index,0);
                student.addCourse(Course.getCourseById(id));
            }
        });
        setVisible(true);
    }


}
