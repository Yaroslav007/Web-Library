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
    <h3>Create BOOK page</h3>
        <form action="/saveBook" method="post">
             <input id="book-id" type="hidden" name="book-id" value="${book.id}">

            <input id="name" type="text" name="name" placeholder="name" value="">
            <input id="genre" type="text" name="genre" placeholder="genre" value="">
            <input id="publicationDate" type="text" name="publicationDate"
            placeholder="publication (yyyy-MM-dd)"value="">
            <button type='submit' name="saveBook">Save Book</button>
        </form>
    </body>
</html>