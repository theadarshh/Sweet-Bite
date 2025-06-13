package com.tap.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/tapfoods";
        String USERNAME = "root";
        String PASSWORD = "root";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            if (conn != null) {
                System.out.println("✅ Database connected successfully!");
            } else {
                System.out.println("❌ Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection error:");
            e.printStackTrace();
        }
    }
}
