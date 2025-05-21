package org.example.services;

import org.example.dao.ArtworkDAO;
import org.example.model.Artwork;

import java.util.List;

public class ArtworkService {
    private static ArtworkService instance;
    private final ArtworkDAO artworkDAO;

    private ArtworkService() {
        this.artworkDAO = ArtworkDAO.getInstance();
    }

    public static ArtworkService getInstance() {
        if (instance == null) {
            instance = new ArtworkService();
        }
        return instance;
    }

    public List<Artwork> getAllArtworks() {
        return artworkDAO.getAllArtworks();
    }

    public Artwork getArtworkById(int id) {
        return artworkDAO.getArtworkById(id);
    }

    public void insertArtwork(Artwork artwork) {
        artworkDAO.insertArtwork(artwork);
    }

    public void updateArtwork(Artwork artwork) {
        artworkDAO.updateArtwork(artwork);
    }

    public void deleteArtwork(int id) {
        artworkDAO.deleteArtwork(id);
    }

    public int getArtworksCount() { return artworkDAO.getArtworksCount();}
}