package com.company.view.repository;

import com.company.model.Course;
import com.company.model.Student;
import com.company.view.course.ChooseCourse;

import java.sql.*;

public class StudentRepository {
    static String url = "jdbc:postgresql://localhost:5432/postgres";

    static String user = "postgres";

    static String password = "Pl34xr32cw";

    public static void getAll() {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from students");

            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                new Student(id,name,surname);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }

    }

    public static void insertStudent(String name, String surname) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "insert into students(name, surname) values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);


            statement.setString(1, name);
            statement.setString(2, surname);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }


    public static void deleteStudent(int id) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "delete from students where id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }

    public static void updateStudent(int id, String name, String surname) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "update students set name = ?, surname = ?, where id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }
}
