package org.example.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        String initSqlPath = "C:/Users/agapo/IdeaProjects/Java_Vanilla/src/main/resources/init.sql";
        try (Connection connection = DatabaseConnection.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                String initSql = new String(Files.readAllBytes(Paths.get(initSqlPath)));
                statement.execute(initSql);

                System.out.println("Таблицы успешно созданы или уже существуют.");
            }
        } catch (SQLException | IOException e) {
            System.err.println("Ошибка при создании таблиц: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
    }
}
