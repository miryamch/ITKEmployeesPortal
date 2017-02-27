/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mchaabouni
 */
public class ConnectionService {
    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/itkportaldb";
    
    //  Database credentials
    public static final String USER = "root";
    public static final String PASSWORD = "nbuser";
    
    public static Connection getConnetion() throws SQLException{
        Connection connection = DriverManager.getConnection(DB_URL,USER, PASSWORD);
        return connection ; 
    }
    
}
