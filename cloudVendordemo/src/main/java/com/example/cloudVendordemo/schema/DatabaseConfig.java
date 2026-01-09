package com.example.cloudVendordemo.schema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    public  static final String URL = "jdbc:postgresql://localhost:5432/CloudVendor_db";
    public  static final String USERNAME = "postgres";
    public  static final String PASSWORD = "Neoza";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
