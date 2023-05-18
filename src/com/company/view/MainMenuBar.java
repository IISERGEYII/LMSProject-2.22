package com.company.view;


import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar() {
        add(fileMenu());
        add(listMenu());
        add(helpMenu());
    }

    public JMenu listMenu() {
        JMenu lists = new JMenu("Списки");

        JMenuItem students = new JMenuItem("Студенты");
        JMenuItem courses = new JMenuItem("Курсы");

        lists.add(students);
        lists.add(courses);

        courses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainFrame.remove(MainFrame.studentListPanel);
                Main.mainFrame.add(MainFrame.courseListPanel);
                Main.mainFrame.pack();
            }
        });

        students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.mainFrame.remove(MainFrame.courseListPanel);
                Main.mainFrame.add(MainFrame.studentListPanel);
                Main.mainFrame.pack();
            }
        });

        return lists;
    }

    public JMenu helpMenu() {
        JMenu help = new JMenu("Помощь");

        JMenuItem about = new JMenuItem("О программе");
        JMenuItem reference = new JMenuItem("Справка");

        help.add(about);
        help.add(reference);

        return help;
    }


    private JMenu fileMenu() {
        JMenu file = new JMenu("Файл");
        JMenu newItem = new JMenu("Новый");

        JMenuItem newStudent = new JMenuItem("Студент");
        JMenuItem newCourse = new JMenuItem("Курс");

        JMenuItem settings = new JMenuItem("Настройки");
        JMenuItem exit = new JMenuItem("Выйти");

        file.add(newItem);
        newItem.add(newStudent);
        newItem.add(newCourse);
        file.add(settings);
        file.add(exit);

        newStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addStudentFrame.setVisible(true);
            }
        });

        newCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addCourseFrame.setVisible(true);
            }
        });

        return file;
    }
}
