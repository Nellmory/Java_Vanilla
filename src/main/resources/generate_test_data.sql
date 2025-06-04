-- Очистка таблиц
DELETE FROM Users;
ALTER TABLE Users ALTER COLUMN id RESTART WITH 1;

DELETE FROM Artworks;
ALTER TABLE Artworks ALTER COLUMN id RESTART WITH 1;

-- Заполнение таблицы Users
INSERT INTO Users (name, email) VALUES ('Неля', 'agapova.nelli@example.com');
INSERT INTO Users (name, email) VALUES ('Дарья', 'dar.huisan@example.com');

-- Заполнение таблицы Artworks
INSERT INTO Artworks (title, description, artist, creation_date, type, image_url) VALUES
    ('Звездная ночь', 'Картина, изображающая ночное небо над деревней.', 'Винсент Ван Гог', '1889-06-01', 'painting', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg/1280px-Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg'),
    ('Давид', 'Мраморная статуя Давида.', 'Микеланджело', '1504-09-08', 'sculpture', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/%27David%27_by_Michelangelo_Fir_JBU002.jpg/500px-%27David%27_by_Michelangelo_Fir_JBU002.jpg'),
    ('Мона Лиза', 'Портрет женщины с загадочной улыбкой.', 'Леонардо да Винчи', '1503-01-01', 'painting', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/687px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg'),
    ('Рождение Венеры', 'Картина, изображающая богиню Венеру, стоящую на раковине.', 'Сандро Боттичелли', '1486-04-01', 'painting', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Sandro_Botticelli_-_La_nascita_di_Venere_-_Google_Art_Project_-_edited.jpg/2560px-Sandro_Botticelli_-_La_nascita_di_Venere_-_Google_Art_Project_-_edited.jpg'),
    ('Поцелуй', 'Картина, изображающая влюбленную пару.', 'Густав Климт', '1908-07-01', 'painting', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/The_Kiss_-_Gustav_Klimt_-_Google_Cultural_Institute.jpg/1280px-The_Kiss_-_Gustav_Klimt_-_Google_Cultural_Institute.jpg'),
    ('Сотворение Адама', 'Фреска, изображающая Бога, создающего Адама.', 'Микеланджело', '1512-09-01', 'painting', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Michelangelo_-_Creation_of_Adam_%28cropped%29.jpg/2560px-Michelangelo_-_Creation_of_Adam_%28cropped%29.jpg'),
    ('Герника', 'Картина, изображающая ужасы войны.', 'Пабло Пикассо', '1937-05-26', 'painting', 'https://upload.wikimedia.org/wikipedia/en/7/74/PicassoGuernica.jpg'),
    ('Девочка с жемчужной сережкой', 'Портрет девочки с жемчужной сережкой.', 'Ян Вермеер', '1665-11-01', 'painting', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/1665_Girl_with_a_Pearl_Earring.jpg/800px-1665_Girl_with_a_Pearl_Earring.jpg'),
    ('Крик', 'Картина, изображающая человека, кричащего на мосту.', 'Эдвард Мунк', '1893-01-01', 'painting', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Edvard_Munch%2C_1893%2C_The_Scream%2C_oil%2C_tempera_and_pastel_on_cardboard%2C_91_x_73_cm%2C_National_Gallery_of_Norway.jpg/1280px-Edvard_Munch%2C_1893%2C_The_Scream%2C_oil%2C_tempera_and_pastel_on_cardboard%2C_91_x_73_cm%2C_National_Gallery_of_Norway.jpg'),
    ('Мыслитель', 'Знаменитая бронзовая скульптура задумчивого человека.', 'Огюст Роден', '1902-01-01', 'sculpture', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/The_Thinker%2C_Rodin.jpg/800px-The_Thinker%2C_Rodin.jpg');
