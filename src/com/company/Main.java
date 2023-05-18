package com.company;


import com.company.view.MainFrame;
import com.company.view.repository.CourseRepository;
import com.company.view.repository.StudentRepository;
public class Main {
    public static MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        StudentRepository.getAll();
        CourseRepository.getAll();
    }
}

