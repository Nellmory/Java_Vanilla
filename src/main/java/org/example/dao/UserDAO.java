package org.example.dao;

import org.example.db.DatabaseConnection;
import org.example.model.User;
import org.example.util.EntityMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static UserDAO instance;

    private UserDAO() {}

    public static synchronized UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    // Добавление пользователя
    public void addUser(String name, String email) {
        String sql = "INSERT INTO Users (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            //System.out.println("Пользователь добавлен: " + name); // Logging should be handled elsewhere
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении пользователя: " + e.getMessage());
            e.printStackTrace(); // TODO: Replace with proper logging
        }
    }

    // Получение списка пользователей
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(mapResultSetToEntity(rs, this::mapResultSetToUser));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении пользователей: " + e.getMessage());
            e.printStackTrace(); // TODO: Replace with proper logging
        }
        return users;
    }

    //Вывод пользователей в консоль - УДАЛЕН. Этот метод не относится к DAO

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email")
        );
    }

    //Получение пользователя по id
    public User getUserById(int id) {
        String sql = "SELECT * FROM Users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs, this::mapResultSetToUser);
                }
            }


        } catch (SQLException e) {
            System.err.println("Ошибка при получении пользователя: " + e.getMessage());
            e.printStackTrace(); // TODO: Replace with proper logging
        }
        return null;
    }

    //Обновление пользователя
    public void updateUser(User user) {
        String sql = "UPDATE Users SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
            //System.out.println("Пользователь обновлен: " + name); // Logging should be handled elsewhere
        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении пользователя: " + e.getMessage());
            e.printStackTrace(); // TODO: Replace with proper logging
        }
    }

    //Удаление пользователя
    public void deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            //System.out.println("Пользователь удален: " + name); // Logging should be handled elsewhere
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении пользователя: " + e.getMessage());
            e.printStackTrace(); // TODO: Replace with proper logging
        }
    }

    //Generic mapResultSetToEntity
    private <T> T mapResultSetToEntity(ResultSet rs, EntityMapper<T> mapper) throws SQLException {
        return mapper.map(rs);
    }
}