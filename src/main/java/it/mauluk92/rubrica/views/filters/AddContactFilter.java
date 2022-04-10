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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import it.mauluk92.rubrica.models.contact.ContactDao;
import it.mauluk92.rubrica.views.validators.ContactValidatorForm;
import java.util.List;

/**
 *
 * @author nikolaj
 */
public class AddContactFilter implements Filter {
    
    @Override
    public void init(FilterConfig config){
       
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpSession session = hRequest.getSession(); 
        String username = (String) session.getAttribute("username");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        
        
        List<String> errorLog = ContactValidatorForm.errorForm(name, surname, phone);
        try {
            String errorContactAlreadyExist = !ContactDao.
                    checkContact(username,
                    name,
                    surname
            ) ? "Contact already exists!" : "";
            errorLog.add(errorContactAlreadyExist);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegisterFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("errors", errorLog);
        
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {        
    }
    
}
