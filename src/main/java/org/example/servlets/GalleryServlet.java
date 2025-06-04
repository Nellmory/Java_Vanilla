package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.services.ArtworkService;

import java.io.IOException;

public class GalleryServlet extends HttpServlet {
    private final ArtworkService artworkService = ArtworkService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("artworks", artworkService.getAllArtworks());
        request.getRequestDispatcher("/gallery.jsp").forward(request, response);
    }
} 