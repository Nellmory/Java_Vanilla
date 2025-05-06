package org.example.dao;

import org.example.db.DatabaseConnection;
import org.example.model.Artwork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtworkDAO {

    // Получить список всех экспонатов
    public List<Artwork> getAllArtworks() {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT * FROM artworks";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Artwork artwork = new Artwork(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("artist"),
                        resultSet.getDate("creation_date"),
                        resultSet.getString("type")
                );
                artworks.add(artwork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }

    // Получить один экспонат по ID
    public Artwork getArtworkById(int id) {
        String query = "SELECT * FROM artworks WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Artwork(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("artist"),
                        resultSet.getDate("creation_date"),
                        resultSet.getString("type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Вставить новый экспонат
    public void insertArtwork(Artwork artwork) {
        String query = "INSERT INTO artworks (title, description, artist, creation_date, type) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, artwork.getTitle());
            statement.setString(2, artwork.getDescription());
            statement.setString(3, artwork.getArtist());
            statement.setDate(4, new java.sql.Date(artwork.getCreationDate().getTime()));
            statement.setString(5, artwork.getType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Обновить экспонат
    public void updateArtwork(Artwork artwork) {
        String query = "UPDATE artworks SET title = ?, description = ?, artist = ?, creation_date = ?, type = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, artwork.getTitle());
            statement.setString(2, artwork.getDescription());
            statement.setString(3, artwork.getArtist());
            statement.setDate(4, new java.sql.Date(artwork.getCreationDate().getTime()));
            statement.setString(5, artwork.getType());
            statement.setInt(6, artwork.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удалить экспонат
    public void deleteArtwork(int id) {
        String query = "DELETE FROM artworks WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Получить количество записей в таблице
    public void printArtworksCount() {
        ArtworkDAO dao = new ArtworkDAO();
        List<Artwork> artworks = dao.getAllArtworks();
        if (artworks.isEmpty()) {
            System.out.println("В базе нет экспонатов.");
        } else {
            System.out.println("Количество экспонатов в базе: " + artworks.size());
        }
    }

}