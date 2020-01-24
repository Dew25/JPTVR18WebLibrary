<%-- 
    Document   : index
    Created on : Jan 14, 2020, 9:42:59 AM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Наша библиотека</title>
  </head>
  <body>
    <h1>Добро пожаловать в нашу библиотеку!</h1>
    <p>${info}</p>
    <a href="showLogin">Вход</a><br>
    <a href="logout">Выход</a><br>
    <a href="showCreateBook">Создать книгу</a><br>
    <a href="showListBooks">Список книг</a><br>
    <a href="showCreateReader">Новый читатель</a><br>
    <a href="showListReaders">Список читателей</a><br>
  </body>
</html>
