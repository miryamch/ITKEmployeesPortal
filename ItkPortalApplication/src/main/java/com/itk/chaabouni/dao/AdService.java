/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import com.itk.chaabouni.dto.ClassifiedAd;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mchaabouni
 */
@Named(value = "adService")
@SessionScoped
public class AdService implements Serializable {
 
    private static final String TABLE_NAME = "ads";
    /* Retrive list of employees from database
    If fail to connect to the database return a default list of employees
    source : http://www.javaknowledge.info/display-datatable-from-mysql-db-in-primefaces/
    */
    
    public List<ClassifiedAd> getListOfAds() {
        ArrayList<ClassifiedAd> outList = new ArrayList<>();
        
        try {
            Connection connection = ConnectionService.getConnetion();
            PreparedStatement ps = connection.prepareStatement("select * from ads");
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                ClassifiedAd  ad = new ClassifiedAd();
                ad.setCreator(rs.getString("creator"));
                ad.setTitle(rs.getString("title"));
                ad.setDescription(rs.getString("description"));
                ad.setCreationDate(rs.getDate("creationdate"));
                outList.add(ad);
                found = true;
            }
            rs.close();
            if (found) {
                return outList;
            } else {
                System.out.println("List of ads not found. Returning default table");
                return defaultTable();
            }
        } catch (Exception e) {
            System.out.println("Error In getListOfAds() -->" + e.getMessage()+ 
                    " Returning default table");
            return defaultTable();
//        }
//
        }
    }
    
    public boolean addAd(ClassifiedAd newAd){
        boolean success = true;
        Connection conn = null;
        Statement stmt = null;
     
        try{

            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = ConnectionService.getConnetion();
            System.out.println("Connected database successfully...");
            
            //STEP 4: Execute a query
            System.out.println("Create table if it doesn't exist...");
            createTable(conn);

            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO ads " +
                    "VALUES ('"+ newAd.getId() +"', '" + 
                    newAd.getCreator()+ "', '" +
                    newAd.getTitle()+"', '" +
                    newAd.getDescription()+"', '" +
                    newAd.getCreationDate()+"')";
            stmt.executeUpdate(sql);
            
            System.out.println("Inserted records into the table...");
            
        }catch(SQLException se){
            //Handle errors for JDBC
            Logger.getLogger(AdService.class.getName()).log(Level.SEVERE, null, se);
            se.printStackTrace();
            success= false;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            success= false;
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
            //end finally try
        }//end try
        return success;
    }
    
     /*
    Adds a table of employees to the database if it doesn't exist
    */
    private void createTable(Connection conn) throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + this.TABLE_NAME
                + "  (id            INTEGER,"
                + "   creator       VARCHAR(50),"
                + "   title         VARCHAR(50),"
                + "   description   VARCHAR(255),"
                + "   creationdate  TIMESTAMP)";
        
        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }

    private List<ClassifiedAd> defaultTable() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = sdf.parse("27/02/2017");

        } catch (ParseException ex) {
            Logger.getLogger(AdService.class.getName()).log(Level.SEVERE, null, ex);
        }

        ClassifiedAd ad = new ClassifiedAd("John Doe", date, "Used iPhone 4", "Good condition. With Charger.");
        ArrayList<ClassifiedAd> outList = new ArrayList<>(); 
        outList.add(ad);
        return outList;
    }
}
