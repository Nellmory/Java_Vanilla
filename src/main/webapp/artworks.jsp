<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список экспонатов</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 30px;
            color: #f8f9fa;
            position: relative;
            min-height: 100vh;
            z-index: 1;
            background-color: #121212;
        }

        body::before {
            content: "";
            position: fixed;
            top: 0; left: 0;
            width: 100%; height: 100%;
            background-image: url("https://www.takieng.com/wp-content/uploads/2017/01/national-gallery-washington-2.jpg");
            background-size: cover;
            background-position: center;
            opacity: 0.2;
            z-index: -1;
        }

        h1, h2 {
            color: #ffffff;
            text-align: center;
            margin-bottom: 25px;
            font-weight: 300;
            letter-spacing: 1px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 30px;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
        }

        th, td {
            padding: 16px;
            text-align: left;
            color: #f8f9fa;
            border-bottom: 1px solid #333;
        }

        th {
            background-color: #b37766;
            color: white;
            font-weight: 500;
        }

        tr:hover {
            background-color: rgba(179, 119, 102, 0.1);
        }

        input[type="text"], input[type="date"], input[type="number"] {
            padding: 12px;
            margin: 8px 0;
            width: 250px;
            background-color: transparent;
            border: none;
            border-bottom: 2px solid #b37766;
            color: #f8f9fa;
            border-radius: 4px;
            transition: all 0.3s;
        }

        input[type="text"]:focus, input[type="date"]:focus, input[type="number"]:focus {
            outline: none;
            border-bottom-color: #c48b7a;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        input[type="submit"], input[type="button"] {
            background-color: #b37766;
            color: white;
            border: none;
            padding: 12px 24px;
            margin-top: 15px;
            border-radius: 4px;
            cursor: pointer;
            font-weight: 500;
            transition: all 0.3s;
        }

        input[type="submit"]:hover, input[type="button"]:hover {
            background-color: #c48b7a;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .back-button {
            background-color: #95a5a6;
        }

        .back-button:hover {
            background-color: #7f8c8d;
        }

        form {
            margin-bottom: 30px;
            padding: 25px;
            background-color: transparent;
            border-radius: 8px;
        }

        ::placeholder {
            color: #aaa;
        }
    </style>
</head>
<body>

<h1>Список экспонатов</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Автор</th>
        <th>Дата создания</th>
        <th>Тип</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="artwork" items="${artworks}">
        <tr>
            <td>${artwork.id}</td>
            <td>${artwork.title}</td>
            <td>${artwork.description}</td>
            <td>${artwork.artist}</td>
            <td>${artwork.creationDate}</td>
            <td>${artwork.type}</td>
            <td>
                <input type="button" value="Редактировать"
                       onclick="fillEditForm('${artwork.id}', '${artwork.title}', '${artwork.description}', '${artwork.artist}', '${artwork.creationDate}', '${artwork.type}')"/>

                <form method="post" action="artworkAction" style="display:inline">
                    <input type="hidden" name="id" value="${artwork.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <input type="submit" value="Удалить"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- ===== Добавление нового экспоната ===== -->
<h2>Добавить новый экспонат</h2>
<form method="post" action="artworkAction">
    <input type="hidden" name="id" value="0"/>
    Название: <input type="text" name="title"/><br>
    Описание: <input type="text" name="description"/><br>
    Автор: <input type="text" name="artist"/><br>
    Дата создания: <input type="date" name="creationDate"/><br>
    Тип: <input type="text" name="type"/><br>
    <input type="submit" value="Добавить"/>
</form>

<!-- ===== Редактирование экспоната ===== -->
<h2>Редактировать экспонат</h2>
<form method="post" action="artworkAction">
    ID: <input type="number" name="id" id="edit-id" readonly/><br>
    Название: <input type="text" name="title" id="edit-title"/><br>
    Описание: <input type="text" name="description" id="edit-description"/><br>
    Автор: <input type="text" name="artist" id="edit-artist"/><br>
    Дата создания: <input type="date" name="creationDate" id="edit-creationDate"/><br>
    Тип: <input type="text" name="type" id="edit-type"/><br>
    <input type="submit" value="Обновить"/>
</form>

<form action="index.jsp" method="get">
    <input type="submit" class="back-button" value="Назад на главную">
</form>

<!-- ===== JavaScript для заполнения формы редактирования ===== -->
<script>
    function fillEditForm(id, title, description, artist, creationDate, type) {
        document.getElementById('edit-id').value = id;
        document.getElementById('edit-title').value = title;
        document.getElementById('edit-description').value = description;
        document.getElementById('edit-artist').value = artist;
        document.getElementById('edit-creationDate').value = creationDate;
        document.getElementById('edit-type').value = type;
        window.scrollTo(0, document.body.scrollHeight);
    }
</script>

</body>
</html>
