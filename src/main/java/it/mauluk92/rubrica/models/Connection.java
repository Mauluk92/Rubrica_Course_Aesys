/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.mauluk92.rubrica.models;

import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author nikolaj
 */
public class Connection {
    
    public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException{
    String dbUrl = System.getenv("JDBC_DATABASE_URL");
    return DriverManager.getConnection(dbUrl);
    }
            
    
}
