package org.example.servlets;

import org.example.model.Artwork;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.services.ArtworkService;

import java.io.IOException;
import java.sql.Date;

public class ArtworkActionServlet extends HttpServlet {

    private final ArtworkService artworkService = ArtworkService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if ("delete".equals(action)) {
            // Удаление
            artworkService.deleteArtwork(id);
        } else {
            // Получаем остальные параметры
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String artist = request.getParameter("artist");
            Date creationDate = Date.valueOf(request.getParameter("creationDate"));
            String type = request.getParameter("type");

            Artwork artwork = new Artwork(id, title, description, artist, creationDate, type);

            if (id == 0) {
                // Добавление нового экспоната
                artworkService.insertArtwork(artwork);
            } else {
                // Обновление существующего
                artworkService.updateArtwork(artwork);
            }
        }

        // Перенаправление обратно на список
        response.sendRedirect("artworks");
    }
}
