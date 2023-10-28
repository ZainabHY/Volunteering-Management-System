package com.Volunteering.VolunteeringManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/volunteeringTest";
        String username = "root";
        String password = "295459-Zhy";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}

//        Compile and run this Java program, and it will attempt to connect to the MySQL database using the provided connection details. If the connection is successful, it will print "Database connection successful!" in the console.
//
//        If the connection fails, it will display an error message indicating the reason for the failure.