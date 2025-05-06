package org.example.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String createUsersTable = "CREATE TABLE IF NOT EXISTS Users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL" +
                    ");";

            String createArtworksTable = "CREATE TABLE IF NOT EXISTS Artworks (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "title VARCHAR(255) NOT NULL, "
                    + "description TEXT," +
                    "artist VARCHAR(255), " +
                    "creation_date DATE, " +
                    "type ENUM('painting', 'sculpture', 'other') NOT NULL" +
                    ");";

            String createPaintingsTable = "CREATE TABLE IF NOT EXISTS Paintings (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "artwork_id INT UNIQUE NOT NULL, " +
                    "surface VARCHAR(100), " + //Холст, дерево, и т.д.
                    "style VARCHAR(100), " +//Реализм, импрессионизм, и т.д.
                    "FOREIGN KEY (artwork_id) REFERENCES Artworks(id) ON DELETE CASCADE" +
                    ");";

            String createSculpturesTable = "CREATE TABLE IF NOT EXISTS Sculptures (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "artwork_id INT UNIQUE NOT NULL, " +
                    "material VARCHAR(100) NOT NULL, " +
                    "height DECIMAL(10, 2), " +
                    "weight DECIMAL(10, 2), " +
                    "FOREIGN KEY (artwork_id) REFERENCES Artworks(id) ON DELETE CASCADE" +
                    ");";

            String createSensorsTable = "CREATE TABLE IF NOT EXISTS Sensors (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "type VARCHAR(50) NOT NULL, " +
                    "location VARCHAR(100) NOT NULL" +
                    ");";

            String createGuardiansTable = "CREATE TABLE IF NOT EXISTS Guardians (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255) NOT NULL," +
                    "schedule VARCHAR(255)," +
                    "FOREIGN KEY (id) REFERENCES Users(id)" +
                    ");";

            // Выполняем SQL-запросы
            statement.execute(createUsersTable);
            statement.execute(createArtworksTable);
            statement.execute(createPaintingsTable);
            statement.execute(createSculpturesTable);
            statement.execute(createSensorsTable);
            statement.execute(createGuardiansTable);

            System.out.println("Таблицы успешно созданы или уже существуют.");
        } catch (SQLException e) {
            System.err.println("Ошибка при создании таблиц: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
    }
}
