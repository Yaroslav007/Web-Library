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
        <h3>Add AUTHOR to list</h3>
        <form action="/addAuthorToAlist" method="post">
        <input id="book-id" type="hidden" name="book-id" value="${book.id}">
            firstname
            <input id="name" type="text" name="name" placeholder="name" value=""><br>
            <br>
            lastname
            <input id="surname" type="text" name="surname" placeholder="surname" value=""><br>
            <br>
            gender
            <input id="gender" type="text" name="gender" placeholder="gender" value=""><br>
            <br>
            birthday
            <input id="birthday" type="text" name="birthday"  placeholder="yyyy-MM-dd"value=""><br>
            <br>
            <button type='submit' name="saveAuthor" >add</button>
        </form>
    </body>
</html>