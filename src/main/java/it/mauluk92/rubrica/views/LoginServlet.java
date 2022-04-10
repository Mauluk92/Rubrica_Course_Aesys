/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.mauluk92.rubrica.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.mauluk92.rubrica.models.contact.Contact;
import it.mauluk92.rubrica.models.contact.ContactDao;


public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        if(session.getAttribute("errors") == null){
        try {
            ArrayList<Contact> contactList = ContactDao.getContactList(username);
            session.setAttribute("contactList", contactList);
            response.sendRedirect("welcome.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }else{
            response.sendRedirect("index.jsp");
        }
        
        
        

    }
}
