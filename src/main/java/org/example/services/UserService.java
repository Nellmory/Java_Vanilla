package org.example.services;

import org.example.dao.UserDAO;
import org.example.model.User;

import java.util.List;

public class UserService {

    private static UserService instance;
    private final UserDAO userDAO;

    private UserService() {
        this.userDAO = UserDAO.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void addUser(String name, String email) {
        userDAO.addUser(name, email);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    // Можно добавить метод для вывода пользователей в консоль, если это требуется.
    public void printUsers() {
        List<User> users = getUsers();
        if (users.isEmpty()) {
            System.out.println("В базе нет пользователей.");
        } else {
            users.forEach(user ->
                    System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail())
            );
        }
    }
}