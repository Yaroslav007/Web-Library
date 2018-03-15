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
        <h3>Add BOOK to list</h3>
        <form action="/addBookToAList" method="post">
        <input id="author-id" type="hidden" name="author-id" value="${author.id}">

            Name<br>
            <input id="name" type="text" name="name" placeholder="name" value=""><br>
            Genre<br>
            <input id="genre" type="text" name="genre" placeholder="genre" value=""><br>
            Publication<br>
            <input id="publicationDate" type="text" name="publicationDate"
            placeholder="publication (yyyy-MM-dd)"value=""><br><br>
            <button type='submit'>add</button>
        </form>
    </body>
</html>