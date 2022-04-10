/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package it.mauluk92.rubrica.views.filters;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import it.mauluk92.rubrica.models.contact.ContactDao;
import it.mauluk92.rubrica.views.validators.ContactValidatorForm;
import java.util.List;

/**
 *
 * @author nikolaj
 */
@WebFilter(filterName = "UpdateContactFilter", urlPatterns = {"/update"})
public class UpdateContactFilter implements Filter {
    
   @Override
    public void init(FilterConfig config){
       
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpSession session = hRequest.getSession(); 
        
        String name = request.getParameter("nameUpdate");
        String surname = request.getParameter("surnameUpdate");
        String phone = request.getParameter("phoneUpdate");
        String username = (String) session.getAttribute("username");
        
        List<String> errorLog = ContactValidatorForm.errorFormUpdate(name, surname, phone);
        
       try {
           errorLog.add(ContactDao.
                   checkContact(username, name, surname) ? 
                   "Contact does not exist" : "");
       } catch (SQLException | ClassNotFoundException ex) {
           Logger.getLogger(UpdateContactFilter.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        session.setAttribute("errors", errorLog);
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {        
    }
    
}
