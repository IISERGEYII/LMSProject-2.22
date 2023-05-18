package com.company.view.repository;

import com.company.model.Course;

import java.sql.*;

public class CourseRepository {
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String user = "postgres";
    static String password = "Pl34xr32cw";

    public static void getAll() {


        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from courses");

            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                new Course(id, title, description);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }

    }


    public static void insertCourse(String title, String description) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "insert into courses(title, description) values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);


            statement.setString(1, title);
            statement.setString(2, description);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }
        public static void deleteCourse ( int id){

            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                String query = "delete from course where id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Не удалось подключиться к базе данных");
                System.out.println(e.getMessage());
            }
        }
    public static void updateCourse(int id, String title, String description) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "update courses set title = ?, description = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }


}
