<%-- 
    Document   : welcome
    Created on : 6 apr 2022, 23:28:34
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <%  
            if(session.getAttribute("username") == null){
                response.sendRedirect("index.jsp");
            }
            out.println("Welcome back : " + session.getAttribute("username") + "!");
        %>
        <ul>
        <c:forEach items="${contactList}" var="contact">
            <li>${contact};</li>
        </c:forEach>
        </ul>
        <h1> Here's a list of your contacts! </h1>
        <a href="addcontact.jsp">Add Contact</a>
        <br>
        <a href="updatecontact.jsp">Update Contact Information!</a>
        <br>
        <a href="removecontact.jsp">Remove Contact</a>
        <br>
        <form action="logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
