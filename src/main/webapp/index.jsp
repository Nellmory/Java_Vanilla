<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Онлайн Музей</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url("https://www.takieng.com/wp-content/uploads/2017/01/national-gallery-washington-2.jpg");
            background-size: cover;
            background-position: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-shadow: 1px 1px 4px #000;
        }
        h1 {
            font-size: 3em;
            margin-bottom: 30px;
        }
        .enter-button {
            padding: 15px 30px;
            font-size: 1.2em;
            background-color: #b37766;
            color: white;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-decoration: none;
        }
        .enter-button:hover {
            background-color: #b37766;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            background: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 10px;
        }
        input[type="text"], input[type="email"] {
            padding: 10px;
            margin: 5px 0;
            width: 250px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
        }
        input[type="submit"] {
            padding: 12px 25px;
            font-size: 1.1em;
            background-color: #b37766;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 15px;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #c48b7a;
        }
    </style>
</head>
<body>
<h1>Онлайн Музей</h1>

<form action="userAction" method="post">
    <input type="text" name="name" placeholder="Ваше имя" required>
    <input type="email" name="email" placeholder="Ваш email" required>
    <input type="hidden" name="redirect" value="gallery.jsp">
    <input type="submit" value="Войти в галерею">
</form>

</body>
</html>
