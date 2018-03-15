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
    <h1>Update BOOK</h1>
          <form action="/updateBook" method="post">
               <input id="id" type="hidden" name="id" value="${book.id}">

               Name<br>
              <input id="name" type="text" name="name" placeholder="" value="${book.bookName}"><br><br>

              Genre<br>
              <input id="genre" type="text" name="genre" placeholder="" value="${book.genre}"><br><br>

              Publication date<br>
              <input id="publicationDate" type="text" name="publicationDate"
              placeholder="" value="${book.publicationDate}"><br><br>

              <button type='submit' name="updateBook">update</button>
          </form>

    </body>
</html>