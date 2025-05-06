package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
    private static final String DB_URL = getValue("db.url");
    private static final String DB_USER = getValue("db.user");  // H2 по умолчанию использует "sa"
    private static final String DB_PASSWORD = getValue("db.password");
    private static final String DB_DRIVER = getValue("db.driver");

    private static String getValue(String path) {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        return rb.getString(path);
    }

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC драйвер не найден!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Ошибка SQL: " + e.getMessage());
            e.printStackTrace();
        }
        return null;  // Если ошибка, вернуть null
    }
}
