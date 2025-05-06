package org.example.model;

import java.util.Date;

public class Artwork {
    private int id;
    private String title;
    private String description;
    private String artist;
    private Date creationDate;
    private String type;

    // Конструктор без id (для добавления нового произведения искусства)
    public Artwork(String title, String description, String artist, Date creationDate, String type) {
        this.title = title;
        this.description = description;
        this.artist = artist;
        this.creationDate = creationDate;
        this.type = type;
    }

    // Конструктор с id (для работы с существующими произведениями искусства)
    public Artwork(int id, String title, String description, String artist, Date creationDate, String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.artist = artist;
        this.creationDate = creationDate;
        this.type = type;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Метод для удобного вывода
    @Override
    public String toString() {
        return "Artwork{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", artist='" + artist + '\'' +
                ", creationDate=" + creationDate +
                ", type='" + type + '\'' +
                '}';
    }
}