package com.myorganisation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/campusconnectdb?createDatabaseIfNotExist=true";
            String dbUser = "root";
            String dbPassword = "root";
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch(ClassNotFoundException e) {
            System.out.println("An exception occurred (ClassNotFoundException): " + e.getMessage());
        } catch(SQLException e) {
            System.out.println("An exception occurred (SQLException): " + e.getMessage());
        }

        return null;
    }
}
