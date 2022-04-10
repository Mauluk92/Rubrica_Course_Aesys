/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.mauluk92.rubrica.views;


import it.mauluk92.rubrica.models.contact.Contact;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.mauluk92.rubrica.models.contact.ContactDao;
import it.mauluk92.rubrica.models.user.UserDao;
import java.util.List;


/**
 *
 * @author nikolaj
 */
public class UpdateContactServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String name = request.getParameter("nameUpdate");
        String surname = request.getParameter("surnameUpdate");
        String phone = request.getParameter("phoneUpdate");
        
        List<String> errorLog = (List<String>) session.getAttribute("errors");
        
        Contact contactUpdated = new Contact(name, surname, phone);
        
        if(errorLog.stream().allMatch(String::isEmpty)){
            try {
            ContactDao.updateContact(username, name, surname, phone);
            session.setAttribute(
                    "contactUpdated",
                    contactUpdated.toString() 
                    + " Succesfully Updated!");
            session.setAttribute("contactList", ContactDao.getContactList(username));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        response.sendRedirect("updatecontact.jsp");
        }
}
