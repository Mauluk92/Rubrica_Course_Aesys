/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.mauluk92.rubrica.views;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.mauluk92.rubrica.models.contact.Contact;
import it.mauluk92.rubrica.models.contact.ContactDao;
import java.util.List;

/**
 *
 * @author nikolaj
 */
public class AddContactServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        HttpSession session = request.getSession();
        String user_proprietary = (String) session.getAttribute("username");
        Contact contactAdded = new Contact(name, surname, phone);
        List<String> errorLog = (List<String>)session.getAttribute("errors");
        
        if(errorLog.stream().allMatch(String::isEmpty)){
            try {
            ContactDao.insertContact(user_proprietary, name, surname, phone);
            session.setAttribute("contactAdded", contactAdded.toString() + " Succesfully Added!");
            session.setAttribute("contactList", ContactDao.getContactList(user_proprietary)); // Refresh Session Parameter
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        response.sendRedirect("addcontact.jsp");
    }
}
