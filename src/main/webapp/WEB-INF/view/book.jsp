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
    <h1>BOOK</h1>
            <input id="book-id" type="hidden" name="book-id" value="${book.id}">
            <span>Name:  ${book.bookName},   publication date:  ${book.publicationDate},  genre:   ${book.genre}.</span><br><br>
            Author(s):<br>
          <c:forEach items="${authors}" var="author">
                 <form action="/deleteFromAuthorsList" >
                 <input id="book-id" type="hidden" name="book-id" value="${book.id}">
                 <input id="author-id" type="hidden" name="author-id" value="${author.id}">
                      <span>Name:  ${author.authorName},   Surname:  ${author.authorSurname},  Gender:   ${author.gender}
                      bitrhday:  ${author.birthday}.</span> Delete from Authors list:
                      <button type='submit' >Submit</button>
               </form>
          </c:forEach>
            <br><br>
              Delete Book - press delete <br>
          <form action="/deleteBook">
              <input id="book-id" type="hidden" name="book-id" value="${book.id}">
              <button type='submit' name="saveBook">delete Book</button><br><br>
          </form>

            Update Book<br>
          <form action="/updateB" method="post">
              <input id="book-id" type="hidden" name="book-id" value="${book.id}">
                <button type='submit' >Update Book</button><br><br>
          </form>

            Add author to list of authors<br>
          <form action="/addAuthorToList" method="post">
              <input id="book-id" type="hidden" name="book-id" value="${book.id}">
              <button type='submit' >Add author</button><br><br>
          </form>
    </body>
</html>