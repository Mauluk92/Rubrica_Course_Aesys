/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.mauluk92.rubrica.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.mauluk92.rubrica.models.user.UserDao;
import java.util.List;

/**
 *
 * @author nikolaj
 */
public class Register extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        HttpSession session = request.getSession();
        String username = request.getParameter("usernameRegister");
        String password = request.getParameter("passwordRegister");
        List<String> errorLog = (List<String>)session.getAttribute("errors");
        if(errorLog.stream().allMatch(String::isEmpty)){
            try {
            UserDao.registerUser(username, password);
            response.sendRedirect("index.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
        
        response.sendRedirect("register.jsp");
    }
    }  
}
