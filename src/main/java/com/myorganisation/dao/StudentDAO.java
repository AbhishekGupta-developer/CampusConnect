package com.myorganisation.dao;

import com.myorganisation.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection connection = DBUtil.getConnection();

    public void createTable() {
        String sql =
                "CREATE TABLE IF NOT EXISTS student (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100)," +
                "email VARCHAR(100)," +
                "course VARCHAR(100)" +
                ")";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch(SQLException e) {
            System.out.println("An exception occurred (SQLException): " + e.getMessage());
        }
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO student (name, email, course) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCourse());

            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            System.out.println("An exception occurred (SQLException): " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setCourse(resultSet.getString("course"));

                studentList.add(student);
            }
        } catch(SQLException e) {
            System.out.println("An exception occurred (SQLException): " + e.getMessage());
        }

        return studentList;
    }

}
