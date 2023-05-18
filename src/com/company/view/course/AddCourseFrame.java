package com.company.view.course;

import javax.swing.*;
import java.awt.*;

public class AddCourseFrame extends JFrame {

    public AddCourseFrame(){
        setTitle("Добавление курса");
        setSize(500, 300);
        setLocation(720, 280);
        setLayout(new FlowLayout());
        add(new AddCoursePanel());

        setVisible(false);
    }
}
