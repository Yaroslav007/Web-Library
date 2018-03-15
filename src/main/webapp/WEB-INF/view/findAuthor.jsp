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
    Enter the name of author:<br>
          <form action="/searchAuthor" method="post">
              <input id="name" type="text" name="name" placeholder="name" value="">
              <button type='submit'>search</button>
          </form>
        <br>
        <br>
        Found authors:<br>
        <c:forEach items="${authors}" var="author">
           <a href="author-${author.id}">${author.id}</a>
                 <span>Name:  ${author.authorName},   Surname:  ${author.authorSurname},  Gender:   ${author.gender},
                  bitrhday:  ${author.birthday} .</span>
           <br>
        </c:forEach>
    </body>
</html>