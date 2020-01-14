<%-- 
    Document   : showCreateBook
    Created on : Jan 14, 2020, 10:26:46 AM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Новая книга</title>
  </head>
  <body>
    <h1>Добавление новой книги</h1>
    <p>${info}</p>
    Заполните поля:
    <br>
      <form action="createBook" method="POST">
        Название книги: <input type="text" name="name"><br>
        Автор книги: <input type="text" name="author"><br>
        Год издания книги: <input type="text" name="publishedYear"><br>
        ISBN книги: <input type="text" name="isbn"><br>
        <input type="submit" value="Добавить">
    </form>
  </body>
  
</html>
