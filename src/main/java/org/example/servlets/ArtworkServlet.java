package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Artwork;
import org.example.services.ArtworkService;

import java.io.IOException;
import java.util.List;

public class ArtworkServlet extends HttpServlet {

    private final ArtworkService artworkService = ArtworkService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Artwork> artworks = artworkService.getAllArtworks();
        System.out.println("artworks in JSP: " + artworks);

        request.setAttribute("artworks", artworks);
        request.getRequestDispatcher("/artworks.jsp").forward(request, response);
    }
}
