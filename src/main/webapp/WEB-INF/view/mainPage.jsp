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
        <a href="createBook">Create BOOK</a><br>
        <a href="findBook">Find BOOK</a><br>

        <br>
        <a href="createAuthor">Create AUTHOR</a><br>
        <a href="findAuthor">Find AUTHOR</a><br>
        <br><br><br>
        <a href="task2">Task-2  - Show authors which are older 55 years old and sort them by `born` column</a><br>
        <a href="task3">Task-3 - Return books whose author has more than 1 written books</a><br>
        <a href="task4">Task-4 - Find out author which has most books</a><br>
        <a href="task5">Task-5 - Calculate number of books by genre</a><br><br>

        <c:forEach items="${numbersOfGenre}" var="nb">
          Number:_${nb.number},_Genre: ${nb.genre}
           <br>
        </c:forEach>


</body>
</html>