/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import java.sql.Connection;

/**
 *
 * @author Ariel
 */
public class ConnectionFactory {
   
    public Connection getConnection(){
    Connection conn = null; try {
    conn = DriverManager.getConnection("jdbc:postgresql:/localhost:5432/postgre", postgres, 123); } catch (SQLException e) { e.printStackTrace(); } 
    return conn;
     
    
    }

    
    }
