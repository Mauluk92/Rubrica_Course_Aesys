<%-- 
    Document   : remove
    Created on : 10 apr 2022, 22:58:53
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Contact</title>
    </head>
    <body>
        <% if(session.getAttribute("username") == null){
                response.sendRedirect("index.jsp");
            }
        %>
        
        
        <form action="remove" method="post">
            Name : <input type="text" name="nameRemove">
            Surname : <input type="text" name="surnameRemove">
            <input type="submit" value="Remove Contact!">
        </form>
        
        <h1>${contactRemoved}</h1>   
        
        <c:forEach items="${errors}" var="error">
            <c:if test="${not empty error}">
            <li>${error}</li>
            </c:if>   
        </c:forEach>
            
        <a href="welcome.jsp">Back to Home</a>
        <c:set var="errors" scope="session"></c:set>
        <c:set var="contactRemoved" scope="session"></c:set>
    </body>
</html>
