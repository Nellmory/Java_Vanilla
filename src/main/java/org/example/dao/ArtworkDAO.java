package org.example.dao;

import org.example.db.DatabaseConnection;
import org.example.model.Artwork;
import org.example.util.EntityMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtworkDAO {

    private static ArtworkDAO instance;

    private ArtworkDAO() {}

    public static synchronized ArtworkDAO getInstance() {
        if (instance == null) {
            instance = new ArtworkDAO();
        }
        return instance;
    }

    // Получить список всех экспонатов
    public List<Artwork> getAllArtworks() {
        List<Artwork> artworks = new ArrayList<>();
        String sql = "SELECT * FROM artworks";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                artworks.add(mapResultSetToEntity(rs, this::mapResultSetToArtwork));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // TODO: Replace with proper logging
        }
        return artworks;
    }

    // Получить один экспонат по ID
    public Artwork getArtworkById(int id) {
        String sql = "SELECT * FROM artworks WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs, this::mapResultSetToArtwork);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // TODO: Replace with proper logging
        }
        return null;
    }

    // Вставить новый экспонат
    public void insertArtwork(Artwork artwork) {
        String sql = "INSERT INTO artworks (title, description, artist, creation_date, type) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, artwork.getTitle());
            stmt.setString(2, artwork.getDescription());
            stmt.setString(3, artwork.getArtist());
            stmt.setDate(4, new java.sql.Date(artwork.getCreationDate().getTime()));
            stmt.setString(5, artwork.getType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // TODO: Replace with proper logging
        }
    }

    // Обновить экспонат
    public void updateArtwork(Artwork artwork) {
        String sql = "UPDATE artworks SET title = ?, description = ?, artist = ?, creation_date = ?, type = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, artwork.getTitle());
            stmt.setString(2, artwork.getDescription());
            stmt.setString(3, artwork.getArtist());
            stmt.setDate(4, new java.sql.Date(artwork.getCreationDate().getTime()));
            stmt.setString(5, artwork.getType());
            stmt.setInt(6, artwork.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // TODO: Replace with proper logging
        }
    }

    // Удалить экспонат
    public void deleteArtwork(int id) {
        String sql = "DELETE FROM artworks WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // TODO: Replace with proper logging
        }
    }

    // Получить количество записей в таблице (Этот метод лучше перенести в другое место)
    public int getArtworksCount() {
        String sql = "SELECT COUNT(*) FROM artworks";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // TODO: Replace with proper logging
        }
        return 0; // Or throw an exception if appropriate
    }

    //Метод для преобразования ResultSet в объект Artwork
    private Artwork mapResultSetToArtwork(ResultSet rs) throws SQLException {
        return new Artwork(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("artist"),
                rs.getDate("creation_date"),
                rs.getString("type")
        );
    }

    //Generic mapResultSetToEntity
    private <T> T mapResultSetToEntity(ResultSet rs, EntityMapper<T> mapper) throws SQLException {
        return mapper.map(rs);
    }
}