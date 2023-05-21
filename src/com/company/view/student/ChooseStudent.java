package com.company.view.student;

import com.company.model.Course;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseStudent extends JFrame {
    StudentListPanel panel;
    public ChooseStudent(Course course){
      setTitle("Выбор студента");
      setSize(500,500);
      setLocation(650, 150);
      setLayout(new FlowLayout());
      panel = new StudentListPanel();
      add(panel);

      JButton button = new JButton("Зачислить");
      add(button);

      button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
              int index = panel.table.getSelectedRow();
              int id = (int) panel.table.getValueAt(index,0);
              course.addStudent(Student.getStudentById(id));
          }
      });
      setVisible(true);
    }
}
