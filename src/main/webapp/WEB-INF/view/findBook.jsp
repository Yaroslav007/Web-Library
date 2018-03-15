<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Hello</title>
    </head>
    <body>
    Enter the name of book:<br>
          <form action="/searchBook" method="post">
              <input id="name" type="text" name="name" placeholder="name" value="">
              <button type='submit'>search</button>
          </form>
        <br>
        <br>
        Found books:<br>
        <c:forEach items="${books}" var="book">
           <li>
           <a href="book-${book.id}">${book.id}</a>
               Name: ${book.bookName},   publication date: ${book.publicationDate},  genre:  ${book.genre},<br>
               <br>
        </c:forEach>
    </body>
</html>