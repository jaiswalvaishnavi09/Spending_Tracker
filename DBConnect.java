/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DBConnect {
   
    public static Connection conn ;
    public static Statement st ;
    
    static{
        try{
            conn =  DriverManager.getConnection("jdbc:mysql:///spendingdb"+"?useSSL=false", "root", "V@ishnavi09");
            st = conn.createStatement();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/expense_tracker";
        String user = "root";
        String password = "password";
        return DriverManager.getConnection("jdbc:mysql:///spendingdb"+"?useSSL=false", "root", "V@ishnavi09");
    }
}

