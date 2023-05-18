package com.company.view.course;

import com.company.model.Course;
import com.company.model.Student;
import com.company.view.repository.CourseRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseJPopUpMenu extends JPopupMenu {

    public static JTable table;

    public CourseJPopUpMenu(JTable table) {
        CourseJPopUpMenu.table = table;
        JMenuItem edit = new JMenuItem("Сохранить");
        JMenuItem enroll = new JMenuItem("Зачислить студента");
        JMenuItem delete = new JMenuItem("Удалить");

        edit.setActionCommand("save");
        enroll.setActionCommand("enroll");
        delete.setActionCommand("delete");

        CourseJPopUpMenu.MenuItemListener menuItemListener = new CourseJPopUpMenu.MenuItemListener();

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
            String title = (String) table.getValueAt(index, 1);
            String description = (String)  table.getValueAt(index,2);
            switch (e.getActionCommand()) {
                case "save" -> CourseRepository.updateCourse(id,title,description);
                case "delete" -> CourseRepository.deleteCourse(id);
                case "enroll" -> new ChooseCourse(Student.getStudentById(id));
            }


        }
    }
}
