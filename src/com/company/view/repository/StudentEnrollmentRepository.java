package com.company.view.repository;

import com.company.model.Course;
import com.company.model.CourseEnrollment;
import com.company.model.Student;

import java.sql.*;

public class StudentEnrollmentRepository {
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String user = "postgres";
    static String password = "Pl34xr32cw";

    public static void getAll() {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from ");

            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                int studentId = resultSet.getInt("studentid");
                int courseId = resultSet.getInt("courseid");
                new CourseEnrollment(id, Student.getStudentById(id), Course.getCourseById(id));

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }
}
