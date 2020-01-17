<%-- 
    Document   : showListBooks
    Created on : Jan 14, 2020, 11:02:29 AM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список читателей</title>
  </head>
  <body>
    <h1>Список читателей:</h1>
    <c:forEach var="reader" items="${listReaders}">
        <p>${reader}</p>
    </c:forEach>
  </body>
</html>
