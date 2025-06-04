package org.example;

import org.example.db.DatabaseConnection;
import org.example.db.DatabaseInitializer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Сначала инициализируем базу данных
        DatabaseInitializer.initializeDatabase();
        
        // Затем загружаем тестовые данные
        String generateDataPath = "C:/Users/agapo/IdeaProjects/Java_Vanilla/src/main/resources/generate_test_data.sql";
        try (Connection connection = DatabaseConnection.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                String genSql = new String(Files.readAllBytes(Paths.get(generateDataPath)));
                statement.execute(genSql);

                System.out.println("Тестовые данные успешно загружены.");
            }
        } catch (SQLException | IOException e) {
            System.err.println("Ошибка при генерации тестовых данных: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
