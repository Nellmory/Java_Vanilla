package org.example.dao;

import org.example.db.DatabaseConnection;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Создание таблицы Users, если её нет
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(100)," +
                "email VARCHAR(100) UNIQUE" +
            ")";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица Users проверена/создана.");
        } catch (SQLException e) {
            System.err.println("Ошибка при создании таблицы Users: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Добавление пользователя
    public static void addUser(String name, String email) {
        String sql = "INSERT INTO Users (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Пользователь добавлен: " + name);
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении пользователя: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Получение списка пользователей
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении пользователей: " + e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    // Вывод пользователей в консоль
    public static void printUsers() {
        List<User> users = getUsers();
        if (users.isEmpty()) {
            System.out.println("В базе нет пользователей.");
        } else {
            users.forEach(user ->
                    System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail())
            );
        }
    }
}
