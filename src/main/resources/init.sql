-- Создание таблицы Users
CREATE TABLE IF NOT EXISTS Users (
                                     id INT PRIMARY KEY AUTO_INCREMENT,
                                     name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
    );

-- Создание таблицы Artworks
CREATE TABLE IF NOT EXISTS Artworks (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        title VARCHAR(255) NOT NULL,
    description TEXT,
    artist VARCHAR(255),
    creation_date DATE,
    type ENUM('painting', 'sculpture', 'other') NOT NULL
    );

-- Создание таблицы Paintings
CREATE TABLE IF NOT EXISTS Paintings (
                                         id INT PRIMARY KEY AUTO_INCREMENT,
                                         artwork_id INT UNIQUE NOT NULL,
                                         surface VARCHAR(100), -- Холст, дерево, и т.д.
    style VARCHAR(100), -- Реализм, импрессионизм, и т.д.
    FOREIGN KEY (artwork_id) REFERENCES Artworks(id) ON DELETE CASCADE
    );
