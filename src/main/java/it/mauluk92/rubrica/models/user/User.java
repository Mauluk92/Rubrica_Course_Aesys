/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.mauluk92.rubrica.models.user;

/**
 *
 * @author nikolaj
 */
public class User {
    
    private String username;
    private String password;
    private Boolean active;
    
    public User(String username, String password, Boolean active) {
        
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public Boolean getActive() {
        return active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setActive(Boolean active){
        this.active = active;
    }
    
    @Override
    public String toString(){
        return username;
    }
    
}
