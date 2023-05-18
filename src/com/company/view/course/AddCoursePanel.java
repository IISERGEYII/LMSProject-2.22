package com.company.view.course;

import com.company.model.Course;
import com.company.view.MainFrame;
import com.company.view.repository.CourseRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCoursePanel extends JPanel {

    public AddCoursePanel(){
        JTextField title = new JTextField(10);
        JTextField description = new JTextField(10);
        JButton addCourse = new JButton("Добавить");
        add(title);
        add(description);
        add(addCourse);

        addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Course(title.getText(), description.getText());
                CourseRepository.insertCourse(title.getText(), description.getText());
                title.setText("");
                description.setText("");
                MainFrame.addCourseFrame.setVisible(false);
                System.out.println(Course.list);
            }
        });
        setVisible(true);
    }
}
