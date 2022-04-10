<%-- 
    Document   : addcontact
    Created on : 7 apr 2022, 04:32:42
    Author     : nikolaj
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Add</title>
    </head>
    <body>
        <h1>Add Contact here!</h1>
        <form action="add" method="post">
            Name <input type="text" name="name">
            Surname <input type="text" name="surname">
            Phone <input type="text" name="phone">
            <input type="submit" value="Add Contact!">
        </form>
        <% if(session.getAttribute("username") == null){
                response.sendRedirect("index.jsp");
            }
        %>
        
        <h1>${contactAdded}</h1>
           
        <c:forEach items="${errors}" var="error">
            <c:if test="${not empty error}">
            <li>${error}</li>
            </c:if>   
        </c:forEach>
        <c:set var="errors" scope="session"></c:set>
        <c:set var="contactAdded" scope="session"></c:set>
        <a href="welcome.jsp">Back to Home!</a>
    </body>
</html>
