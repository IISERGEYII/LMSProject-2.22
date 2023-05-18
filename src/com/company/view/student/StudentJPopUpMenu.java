package com.company.view.student;

import com.company.model.Student;
import com.company.view.course.ChooseCourse;
import com.company.view.repository.StudentRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentJPopUpMenu extends JPopupMenu {
    public static JTable table;

    public StudentJPopUpMenu(JTable table) {
        StudentJPopUpMenu.table = table;
        JMenuItem edit = new JMenuItem("Сохранить");
        JMenuItem enroll = new JMenuItem("Зачислить на курс");
        JMenuItem delete = new JMenuItem("Удалить");

        edit.setActionCommand("save");
        enroll.setActionCommand("enroll");
        delete.setActionCommand("delete");

        MenuItemListener menuItemListener = new MenuItemListener();

        edit.addActionListener(menuItemListener);
        enroll.addActionListener(menuItemListener);
        delete.addActionListener(menuItemListener);


        add(edit);
        add(enroll);
        add(delete);
    }

    static class MenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = table.getSelectedRow();
            int id = (int) table.getValueAt(index,0);
            String name = (String) table.getValueAt(index, 1);
            String surname = (String)  table.getValueAt(index,2);
            switch (e.getActionCommand()) {
                case "save" -> StudentRepository.updateStudent(id,name,surname);
                case "delete" -> StudentRepository.deleteStudent(id);
                case "enroll" -> new ChooseCourse(Student.getStudentById(id));
            }


        }
    }
}
