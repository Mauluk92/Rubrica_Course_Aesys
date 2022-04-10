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
import it.mauluk92.rubrica.models.user.UserDao;
import it.mauluk92.rubrica.views.validators.RegisterValidatorForm;

import java.util.List;


/**
 *
 * @author nikolaj
 */
public class RegisterFilter implements Filter {
    
    
    @Override
    public void init(FilterConfig config){
       
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpSession session = hRequest.getSession(); 
        String username = request.getParameter("usernameRegister");
        String password1 = request.getParameter("passwordRegister");
        String password2 = request.getParameter("passwordConfirm");
        
        List<String> errorLog = RegisterValidatorForm.errorForm(username, password1, password2);
        try {
            errorLog.add(!UserDao.checkUser(username) ? "Username already exist!" : "");
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
