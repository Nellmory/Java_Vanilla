package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.model.User;
import com.google.gson.Gson;
import org.example.services.UserService;
import org.example.services.ArtworkService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private final ArtworkService artworkService = ArtworkService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<User> users = userService.getUsers();

        System.out.println("Пользователи получены: " + users);
        String json = new Gson().toJson(users);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (name != null && email != null && !name.isEmpty() && !email.isEmpty()) {
            userService.addUser(name, email);
        }

        // Перенаправляем на сервлет галереи
        response.sendRedirect("gallery");
    }
}
