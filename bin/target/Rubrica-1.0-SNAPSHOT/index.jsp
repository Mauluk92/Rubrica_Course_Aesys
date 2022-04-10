<%-- 
    Document   : index
    Created on : 6 apr 2022, 23:13:20
    Author     : nikolaj
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <%  
            if(session.getAttribute("username") == null){
                out.println("<form action='login' method='post'>");
                out.println("<input type='text' name='username'>");
                out.println("<input type='password' name='password'>");
                out.println("<input type='submit' value='login'>");
                out.println("</form>");
                out.println("<br>");
                out.println("<a href='register.jsp'>Register</a>");
            }else {
                out.println("Welcome: " + session.getAttribute("username"));
                out.println("<a href='welcome.jsp'> Go back to welcome page! </a>");
            }
            %>
            ${errors}
            <c:set var="errors" scope="session"></c:set>
            
    </body>
</html>
