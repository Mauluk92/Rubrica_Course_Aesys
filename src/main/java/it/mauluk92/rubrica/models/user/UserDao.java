/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.mauluk92.rubrica.models.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.mauluk92.rubrica.models.Connection;

/**
 *
 * @author nikolaj
 */
public class UserDao {
    
    public static Boolean checkUser(String username, String password) throws ClassNotFoundException, SQLException{
        
        java.sql.Connection con = Connection.getConnection();
        
        String query = "SELECT * FROM users WHERE username=? AND password=? AND active=true";
        PreparedStatement stat = con.prepareStatement(query);
        stat.setString(1, username);
        stat.setString(2, password);
   
        
        
        ResultSet res = stat.executeQuery();
        
        return res.next();
        
    }
    public static Boolean checkUser(String username) throws SQLException, ClassNotFoundException{
        java.sql.Connection con = Connection.getConnection();
        String query = "SELECT * FROM users WHERE username=?";
        PreparedStatement stat = con.prepareStatement(query);
        stat.setString(1, username);
        
        ResultSet res = stat.executeQuery();
        
        return !res.next();
        
    }
    public static void registerUser(String username, String password) throws ClassNotFoundException, SQLException{
        
        java.sql.Connection con = Connection.getConnection();
        String query = "INSERT INTO users(username, password, active) VALUES(?,?,?)";
        PreparedStatement stat = con.prepareStatement(query);
        stat.setString(1, username);
        stat.setString(2, password);
        stat.setBoolean(3, true);
        
        stat.executeUpdate();
    }
}
