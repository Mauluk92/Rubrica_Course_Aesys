<%-- 
    Document   : updatecontact
    Created on : 9 apr 2022, 22:42:18
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Contact</title>
    </head>
    <body>
        <h1>Update your contact!</h1>
        <form action="update" method="post">
            Name in Address Book : <input type="text" name="nameUpdate">
            Surname in Addess Book : <input type="text" name="surnameUpdate">
            Phone to Update : <input type="text" name="phoneUpdate">
            
            <input type="submit" value="Update Contact Information!">
        </form>
        
        <% if(session.getAttribute("username") == null){
                response.sendRedirect("index.jsp");
            }
        %>
            
            

        <h1>${contactUpdated}</h1>   
       
        <c:forEach items="${errors}" var="error">
            <c:if test="${not empty error}">
            <li>${error}</li>
            </c:if>   
        </c:forEach>
        <a href="welcome.jsp">Back to Home</a>
        <c:set var="errors" scope="session"></c:set>
        <c:set var="contactUpdated" scope="session"></c:set>
    </body>
</html>
