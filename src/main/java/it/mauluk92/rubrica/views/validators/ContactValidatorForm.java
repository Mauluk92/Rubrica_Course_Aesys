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
public class ContactValidatorForm {
    
    private final static String ERROR_INPUT_NULL = "Some fields are empty!";
    private final static String ERROR_NAME = "Name must contain only characters";
    private final static String ERROR_SURNAME = "Surname must contain only characters!";
    private final static String ERROR_PHONE = "Phone number must have the following format: xxx xxx xx xx";
    
    
    private static boolean isInputNull(
            String name,
            String surname,
            String phone
    ){
        
        List<String> credentials = new ArrayList<>();
        
        credentials.add(name);
        credentials.add(surname);
        credentials.add(phone);
        
        return credentials.
                stream().
                anyMatch(credential ->
                { 
                    return credential == null || credential.isEmpty();
                });
                
    }
    
    private static boolean isNameSurnameCorrect(String name){
        return !name.matches("[[A-Z][a-z]\\'\\s]+");
    }
    
    private static boolean isPhoneCorrect(String phone){
        return !phone.matches("\\d{10}");
    }
    
    public static List<String> errorForm(
            String name,
            String surname,
            String phone){
        
        List<String> errorLog = new ArrayList<>();
        
        errorLog.add(isInputNull(name, surname, phone) ? ERROR_INPUT_NULL : "");
        errorLog.add(isNameSurnameCorrect(name) ? ERROR_NAME : "");
        errorLog.add(isNameSurnameCorrect(surname) ? ERROR_SURNAME : "");
        errorLog.add(isPhoneCorrect(phone) ? ERROR_PHONE : "");
        
        return errorLog;
        
    }
    
    
    public static List<String> errorFormUpdate(
            String name, 
            String surname, 
            String phone){
        
        List<String> errorLog = new ArrayList<>();
        
        errorLog.add(isInputNull(name, surname, phone) ? ERROR_INPUT_NULL : "");
        errorLog.add(isPhoneCorrect(phone) ? ERROR_PHONE : "");
        
        return errorLog;
    }
    
    public static List<String> errorFormRemove(
            String name, 
            String surname){
        
        List<String> errorLog = new ArrayList<>();
        
        errorLog.add(name== null || surname == null ? ERROR_INPUT_NULL : "");
        
        return errorLog;
    }
}
