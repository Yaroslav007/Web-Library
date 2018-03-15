<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Book</title>
    </head>
    <body>
    <h1>Update AUTHOR</h1>
          <form action="/updateAuthor" method="post">
             <input id="id" type="hidden" name="id" value="${author.id}">
             firstname
             <input id="name" type="text" name="name" placeholder="name" value="${author.authorName}"><br>
             <br>
             lastname
             <input id="surname" type="text" name="surname" placeholder="surname" value="${author.authorSurname}"><br>
             <br>
             gender
             <input id="gender" type="text" name="gender" placeholder="gender" value="${author.gender}"><br>
             <br>
             birthday
             <input id="birthday" type="text" name="birthday"  placeholder="yyyy-MM-dd"value="${author.birthday}"><br>
             <br>
             <button type='submit'>Update</button>
          </form>

    </body>
</html>