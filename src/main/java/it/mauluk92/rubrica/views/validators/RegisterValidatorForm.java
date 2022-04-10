/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.mauluk92.rubrica.views.validators;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikolaj
 */
public class RegisterValidatorForm {
    
    private final static String ERROR_INPUT_NULL = "Some fields are empty!"; 
    private final static String ERROR_USERNAME = 
            "Username must contain only alphanumerical characters" +
            "and at least 6 characters!";
    private final static String ERROR_PASSWORD = 
            "Password must contain one special character (@#$%^&+=)\n" +
            "Must contain at least one lowercase letter and one uppercase letter.\n" +
            "Must be 8 at least character long.\n" +
            "Must contain at least one digit";
    private final static String ERROR_MISMATCH = "Passwords must match!";
    
    private static boolean isInputNull(
            String username,
            String password,
            String passwordConfirm
    ){
        
        List<String> credentials = new ArrayList<>();
        
        credentials.add(username);
        credentials.add(password);
        credentials.add(passwordConfirm);
        
        return credentials.
                stream().
                anyMatch(credential ->
                { 
                    return credential == null || credential.isEmpty();
                });
                
    }
    
    private static boolean isUsernameCorrect(String username){
        return !username.matches("{6,100}[\\w_]+");
    }
    
    private static boolean isPasswordCorrect(String password){
        return!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[@#$%^&+=])(?=.*[A-Z])(?=\\S+$).{8,}$");
    }
    
    private static boolean passwordMatching(String password, String passwordConfirm){
        return !password.equals(passwordConfirm);
    }
            
    public static List<String> errorForm(
            String username,
            String password,
            String passwordConfirm){
        
        List<String> errorLog = new ArrayList<>();
        
        errorLog.add(isInputNull(username, password, passwordConfirm) ? ERROR_INPUT_NULL : "");
        errorLog.add(isUsernameCorrect(username) ? ERROR_USERNAME : "");
        errorLog.add(isPasswordCorrect(password) ? ERROR_PASSWORD : "");
        errorLog.add(passwordMatching(password, passwordConfirm) ? ERROR_MISMATCH : "");
        
        return errorLog;
    }
    
}
