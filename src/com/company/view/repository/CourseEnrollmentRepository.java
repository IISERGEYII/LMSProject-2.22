package com.company.view.repository;

import com.company.model.Course;
import com.company.model.Student;
import com.company.model.CourseEnrollment;

import java.sql.*;

public class CourseEnrollmentRepository {
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String user = "postgres";
    static String password = "Pl34xr32cw";

    public static void getAll() {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from course-enrollment");

            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                int studentId = resultSet.getInt("studentid");
                int courseId = resultSet.getInt("courseid");
                new CourseEnrollment(id, Student.getStudentById(id),Course.getCourseById(id));

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }

    public static void insertEnrollment(int studentId,int courseId) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "insert into enrollments(studentid, courseid) values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);


            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }
}
