/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.mauluk92.rubrica.views;


import it.mauluk92.rubrica.models.contact.ContactDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikolaj
 */
public class RemoveContactServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        HttpSession session = request.getSession();
        String name = request.getParameter("nameRemove");
        String surname = request.getParameter("surnameRemove");
        String username =(String)  session.getAttribute("username");
        
        List<String> errorLog = (List<String>) session.getAttribute("errors");
          
        if(errorLog.stream().allMatch(String::isEmpty)){
            try {
                ContactDao.removeContact(username, name, surname);
                session.setAttribute("contactList", ContactDao.getContactList(username));
                session.setAttribute("contactRemoved", name + " " + surname + " Removed from Address Book");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RemoveContactServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
        
        response.sendRedirect("removecontact.jsp");
    }
}
