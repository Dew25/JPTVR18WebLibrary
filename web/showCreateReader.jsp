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
    <title>Новый читатель</title>
  </head>
  <body>
    <h1>Добавление нового читателя</h1>
    <p>${info}</p>
    Заполните поля:
    <br>
      <form action="сreateReader" method="POST">
        Имя: <input type="text" name="firstname" value="${firstname}"><br>
        Фамилия: <input type="text" name="lastname" value="${lastname}"><br>
        Телефон: <input type="text" name="phone" value="${phone}"><br>
        Родился:<br>
        день: <input type="text" name="day" value="${day}"><br>
        месяц: <input type="text" name="month" value="${month}"><br>
        год: <input type="text" name="year" value="${year}"><br>
        <input type="submit" value="Добавить">
    </form>
  </body>
  
</html>
