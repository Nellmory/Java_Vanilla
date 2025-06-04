<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
    if (request.getAttribute("artworks") == null) {
        response.sendRedirect("gallery");
        return;
    }
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Галерея экспонатов</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 30px;
            background-color: #121212;
            color: #ffffff;
            position: relative;
            min-height: 100vh;
            z-index: 1;
        }

        body::before {
            content: "";
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-image: url("https://www.takieng.com/wp-content/uploads/2017/01/national-gallery-washington-2.jpg");
            background-size: cover;
            background-position: center;
            opacity: 0.2;
            z-index: -1;
        }

        h1 {
            text-align: center;
            margin-bottom: 40px;
            color: #ffffff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }

        .gallery {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 30px;
            padding: 20px;
        }

        .artwork-card {
            background: rgba(255, 255, 255, 0.1);
            border-radius: 10px;
            overflow: hidden;
            transition: transform 0.3s ease;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .artwork-card:hover {
            transform: translateY(-5px);
        }

        .artwork-image {
            width: 100%;
            height: 300px;
            object-fit: cover;
        }

        .artwork-info {
            padding: 20px;
        }

        .artwork-title {
            font-size: 1.2em;
            margin: 0 0 10px 0;
            color: #ffffff;
        }

        .artwork-artist {
            color: #b37766;
            margin: 0 0 10px 0;
        }

        .artwork-description {
            color: #cccccc;
            font-size: 0.9em;
            margin: 0;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
            overflow: hidden;
        }

        .button-container {
            text-align: center;
            margin-top: 40px;
        }

        .view-table-button {
            background-color: #b37766;
            color: white;
            border: none;
            padding: 15px 30px;
            border-radius: 5px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-decoration: none;
            display: inline-block;
        }

        .view-table-button:hover {
            background-color: #c48b7a;
        }
    </style>
</head>
<body>
    <h1>Галерея экспонатов</h1>

    <div class="gallery">
        <c:forEach var="artwork" items="${artworks}">
            <div class="artwork-card">
                <img src="${artwork.imageUrl}" alt="${artwork.title}" class="artwork-image">
                <div class="artwork-info">
                    <h3 class="artwork-title">${artwork.title}</h3>
                    <p class="artwork-artist">${artwork.artist}</p>
                    <p class="artwork-description">${artwork.description}</p>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="button-container">
        <a href="artworks.jsp" class="view-table-button">Просмотр таблицы экспонатов</a>
    </div>
</body>
</html> 