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
    <h1>Author</h1>
            <input id="author-id" type="hidden" name="author-id" value="${author.id}">
                 <span>Name:  ${author.authorName},   Surname:  ${author.authorSurname},  Gender:   ${author.gender},
                  bitrhday:  ${author.birthday} .</span><br><br>
            Book(s):<br>
          <c:forEach items="${books}" var="book">
                 <form action="/deleteFromBooksList" >
                 <input id="author-id" type="hidden" name="author-id" value="${author.id}">
                 <input id="book-id" type="hidden" name="book-id" value="${book.id}">
                     <span>Name:  ${book.bookName},publication date:  ${book.publicationDate}, genre:   ${book.genre}.</span>
                      ___Delete from Authors list:
                      <button type='submit' >Submit</button>
               </form>
          </c:forEach>
            <br><br>
              Delete Author - press delete <br>
          <form action="/deleteAuthor">
              <input id="author-id" type="hidden" name="author-id" value="${author.id}">
              <button type='submit' name="saveBook">delete Author</button><br><br>
          </form>

            Update Author<br>
          <form action="/updateA" method="post">
              <input id="author-id" type="hidden" name="author-id" value="${author.id}">
                <button type='submit' >Update Author</button><br><br>
          </form>

            Add book to list of books<br>
          <form action="/addBookToList" method="post">
              <input id="author-id" type="hidden" name="author-id" value="${author.id}">
              <button type='submit' >Add book</button><br><br>
          </form>
    </body>
</html>