package org.example;

import org.example.dao.UserDAO;
import org.example.db.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getConnection();
        UserDAO.addUser("Неля", "agapova.nelli@example.com");
        UserDAO.addUser("Дарья", "dar.huisan@example.com");

        System.out.println("Users:");
        UserDAO.printUsers();

    }
}
