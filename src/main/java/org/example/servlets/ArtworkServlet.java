package org.example.servlets;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.ArtworkDAO;
import org.example.model.Artwork;
import java.sql.Date;

import java.io.IOException;
import java.util.List;

public class ArtworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        ArtworkDAO dao = new ArtworkDAO();
        List<Artwork> artworks = dao.getAllArtworks();
        System.out.println("artworks in JSP: " + artworks);

        request.setAttribute("artworks", artworks);
        request.getRequestDispatcher("/artworks.jsp").forward(request, response);
    }
}
