<%-- 
    Document   : register
    Created on : 7 apr 2022, 03:25:42
    Author     : nikolaj
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register Here</h1>
        <form action="register", method="post">
            Username : <input type="text" name="usernameRegister">
            Password : <input type="password" name="passwordRegister">
            Confirm Password : <input type="password" name="passwordConfirm">
            <input type="submit" value="Register!"> 
            <a href="index.jps">Home</a>
        </form>
        <ul>
        <c:forEach items="${errors}" var="error">
            <c:if test="${not empty error}">
            <li>${error}</li>
            </c:if>   
        </c:forEach>
        <c:set var="errors" scope="session">     
        </c:set>
    </body>
</html>
