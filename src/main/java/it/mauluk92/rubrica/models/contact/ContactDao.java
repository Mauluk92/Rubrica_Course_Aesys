/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.mauluk92.rubrica.models.contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import it.mauluk92.rubrica.models.Connection;

/**
 *
 * @author nikolaj
 */
public class ContactDao {
    
    public static void updateContact(String user_proprietary, String name, String surname, String phoneNew) throws SQLException, ClassNotFoundException{
        System.out.println("Enter");
        java.sql.Connection con = Connection.getConnection();
        String query = "UPDATE contacts SET phone="+phoneNew+" WHERE name=? AND surname=? AND user_proprietary=?";
        PreparedStatement stat = con.prepareStatement(query);
        stat.setString(1, name);
        stat.setString(2, surname);
        stat.setString(3, user_proprietary);
        
        stat.executeUpdate();
        System.out.println("Success");
    }
    
    
    public static Boolean checkContact(String user_proprietary, String name, String surname) throws SQLException, ClassNotFoundException{
        java.sql.Connection con = Connection.getConnection();
        String query = "SELECT * FROM contacts WHERE name=? AND surname=? AND user_proprietary=?";
        PreparedStatement stat = con.prepareStatement(query);
        stat.setString(1, name);
        stat.setString(2, surname);
        stat.setString(3, user_proprietary);
        
        ResultSet res = stat.executeQuery();
        return !res.next();
    }   
    
    
    public static void insertContact(String user_proprietary, String name, String surname, String phone) throws SQLException, ClassNotFoundException{
        
        java.sql.Connection con = Connection.getConnection();
        String query = "INSERT INTO contacts(name, surname, phone, user_proprietary) VALUES(?,?,?,?) RETURNING *";
        PreparedStatement stat = con.prepareStatement(query);
        stat.setString(1, name);
        stat.setString(2, surname);
        stat.setString(3, phone);
        stat.setString(4, user_proprietary);
        
        stat.execute();
        
        
        
    }
    public static ArrayList<Contact> getContactList(String username) throws ClassNotFoundException, SQLException{
        
        ArrayList<Contact> contactList = new ArrayList<>();
        
        java.sql.Connection con = Connection.getConnection();
        
        String query = "SELECT * FROM contacts WHERE user_proprietary=?";
        PreparedStatement stat = con.prepareStatement(query);
        
        stat.setString(1, username);
        ResultSet res = stat.executeQuery();
        
        while(res.next()){
            String name = res.getString("name");
            String surname = res.getString("surname");
            String phone = res.getString("phone");
            
            contactList.add(new Contact(name, surname, phone));
        }
        
        return contactList;
    }
    
    public static void removeContact(String username, String name, String surname) throws SQLException, ClassNotFoundException{
        
        java.sql.Connection con = Connection.getConnection();
        String query = "DELETE FROM contacts WHERE user_proprietary=? AND name=? AND surname=?";
        PreparedStatement stat = con.prepareStatement(query);
        
        stat.setString(1, username);
        stat.setString(2, name);
        stat.setString(3, surname);
        
        stat.execute();
    }
    
}
