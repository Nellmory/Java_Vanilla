package org.example.servlets;

import org.example.dao.ArtworkDAO;
import org.example.model.Artwork;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

public class ArtworkActionServlet extends HttpServlet {


    private ArtworkDAO artworkDAO;

    @Override
    public void init() {
        artworkDAO = new ArtworkDAO();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if ("delete".equals(action)) {
            // Удаление
            artworkDAO.deleteArtwork(id);
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
                artworkDAO.insertArtwork(artwork);
            } else {
                // Обновление существующего
                artworkDAO.updateArtwork(artwork);
            }
        }

        // Перенаправление обратно на список
        response.sendRedirect("artworks");
    }
}
