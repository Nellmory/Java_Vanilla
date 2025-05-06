package org.example;

import org.example.dao.UserDAO;
import org.example.dao.ArtworkDAO;
import org.example.db.DatabaseConnection;
import org.example.model.Artwork;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getConnection();
        UserDAO.addUser("Неля", "agapova.nelli@example.com");
        UserDAO.addUser("Дарья", "dar.huisan@example.com");
        ArtworkDAO artworkDAO = new ArtworkDAO();
        Artwork artwork1 = new Artwork(
                0,
                "Звездная ночь",
                "Картина, изображающая ночное небо над деревней.",
                "Винсент Ван Гог",
                new Date(1889 - 1900, 5, 1), // 1889-06-01
                "painting"
        );
        artworkDAO.insertArtwork(artwork1);

        Artwork artwork2 = new Artwork(
                0,
                "Давид",
                "Мраморная статуя Давида.",
                "Микеланджело",
                new Date(1504 - 1900, 8, 8), // 1504-09-08
                "sculpture"
        );
        artworkDAO.insertArtwork(artwork2);

        Artwork artwork3 = new Artwork(
                0,
                "Мона Лиза",
                "Портрет женщины с загадочной улыбкой.",
                "Леонардо да Винчи",
                new Date(1503 - 1900, 0, 1), // 1503-01-01
                "painting"
        );
        artworkDAO.insertArtwork(artwork3);

        Artwork artwork4 = new Artwork(
                0,
                "Рождение Венеры",
                "Картина, изображающая богиню Венеру, стоящую на раковине.",
                "Сандро Боттичелли",
                new Date(1486 - 1900, 3, 1), // 1486-04-01
                "painting"
        );
        artworkDAO.insertArtwork(artwork4);

        Artwork artwork5 = new Artwork(
                0,
                "Поцелуй",
                "Картина, изображающая влюбленную пару.",
                "Густав Климт",
                new Date(1908 - 1900, 6, 1), // 1908-07-01
                "painting"
        );
        artworkDAO.insertArtwork(artwork5);

        Artwork artwork6 = new Artwork(
                0,
                "Сотворение Адама",
                "Фреска, изображающая Бога, создающего Адама.",
                "Микеланджело",
                new Date(1512 - 1900, 8, 1), // 1512-09-01
                "painting"
        );
        artworkDAO.insertArtwork(artwork6);

        Artwork artwork7 = new Artwork(
                0,
                "Герника",
                "Картина, изображающая ужасы войны.",
                "Пабло Пикассо",
                new Date(1937 - 1900, 4, 26), // 1937-05-26
                "painting"
        );
        artworkDAO.insertArtwork(artwork7);

        Artwork artwork8 = new Artwork(
                0,
                "Девочка с жемчужной сережкой",
                "Портрет девочки с жемчужной сережкой.",
                "Ян Вермеер",
                new Date(1665 - 1900, 10, 1), // 1665-11-01
                "painting"
        );
        artworkDAO.insertArtwork(artwork8);

        Artwork artwork9 = new Artwork(
                0,
                "Крик",
                "Картина, изображающая человека, кричащего на мосту.",
                "Эдвард Мунк",
                new Date(1893 - 1900, 0, 1), // 1893-01-01
                "painting"
        );
        artworkDAO.insertArtwork(artwork9);

        Artwork artwork10 = new Artwork(
                0,
                "Святой Себастьян",
                "Скульптура святого Себастьяна.",
                "Антонио Канова",
                new Date(1800 - 1900, 0, 1), // 1800-01-01
                "sculpture"
        );
        artworkDAO.insertArtwork(artwork10);

        System.out.println("Users:");
        UserDAO.printUsers();
        System.out.println("Artworks:");
        artworkDAO.printArtworksCount();

    }
}
