/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import com.itk.chaabouni.dto.Meal;
import com.itk.chaabouni.dto.Menu;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


/**
 *
 * @author mchaabouni
 */
@Named(value = "mealService")
@ViewScoped
public class MealService implements Serializable{
    
    private final String menuTableName = "weekmenu";
    private final String mealTableName = "meals";

    
    private ArrayList<Menu> defaultMenuList() {
        ArrayList<Menu> menuList = new ArrayList<>(); 
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String weekDay : weekDays) {
            Menu menu = new Menu(); 
            menu.setDay(weekDay);
            
            Meal meal1 = new Meal(); 
            meal1.setName("Pizza");
            meal1.setDescription("Ham and mushrooms ");
            meal1.setVegetarian(false);
            menu.setMeal1(meal1);
            
            Meal meal2 = new Meal(); // default meal 
            meal2.setDescription("Basil and garlic");
            menu.setMeal2(meal2);
            
            menuList.add(menu);
        }
        return menuList; 
    }
    
    public ArrayList<Menu> getMenuList() {
        ArrayList<Menu> menuList = new ArrayList<>();
        try {
            Connection connection = ConnectionService.getConnetion();
            PreparedStatement ps = connection.prepareStatement("select * from weekmenu");
            ResultSet rsmenu = ps.executeQuery();
            
            boolean found = false;
            while (rsmenu.next()) {          
            
                Menu menu = new Menu();
                menu.setDay(rsmenu.getString("day"));
                
                ps = connection.prepareStatement("select * from meals where ID ="+
                        rsmenu.getInt("meal_1"));
                ResultSet rsmeal1 = ps.executeQuery();
            
                if (rsmeal1.next()){
                    Meal meal1 = new Meal();
                    meal1.setId(rsmeal1.getInt("id"));
                    meal1.setName(rsmeal1.getString("name"));
                    meal1.setDescription(rsmeal1.getString("description"));
                    meal1.setPrice(rsmeal1.getDouble("price"));
                    meal1.setVegetarian(rsmeal1.getBoolean("vegetarian"));
                    menu.setMeal1(meal1);
                } else {
                    System.out.println("Meal1 not found");
                }
                
                
                ps = connection.prepareStatement("select * from meals where ID ="+
                        rsmenu.getInt("meal_2"));
                ResultSet rsmeal2 = ps.executeQuery();
            
                if (rsmeal2.next()){
                    Meal meal2 = new Meal();
                    meal2.setId(rsmeal2.getInt("id"));
                    meal2.setName(rsmeal2.getString("name"));
                    meal2.setDescription(rsmeal2.getString("description"));
                    meal2.setPrice(rsmeal2.getDouble("price"));
                    meal2.setVegetarian(rsmeal2.getBoolean("vegetarian"));
                    menu.setMeal2(meal2);
                }else {
                    System.out.println("Meal2 not found");
                }
                
                menuList.add(menu);
                found = true;
            }
            rsmenu.close();
            if (found) {
                return menuList;
            } else {
                System.out.println("Menu list not found. Using default list.");
                return defaultMenuList();
            }
        } catch (Exception e) {
            System.out.println("Error In getMenu() -->" + e.getMessage());
            return (null);
        }
    }    
              
     /*
    Adds a table for the weekly menu to the database if it doesn't exist
    */
    private void createMenuTable(Connection conn) throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + this.menuTableName
                + "(  day           VARCHAR(10),"
                + "   meal_1        VARCHAR(50),"
                + "   meal_2        VARCHAR(50))";
        
        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }
    
     /*
    Adds a table for the weekly menu to the database if it doesn't exist
    */
    private void createMealTable(Connection conn) throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + this.mealTableName
                + "  (id            INTEGER,"
                + "   name          VARCHAR(50),"
                + "   description   VARCHAR(250),"
                + "   price         FLOAT,"
                + "   vegetarian    BOOLEAN)" ;
        
        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }
    
     /*
    Add an employee to the data base 
    returns true if operation succeeds 
    */
    public boolean addMenu(Menu menu){
        boolean success = true;
        Connection conn = null;
        PreparedStatement stmt = null;
     
        try{

            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = ConnectionService.getConnetion();
            System.out.println("Connected database successfully...");
            
            //STEP 4: Execute a query
            System.out.println("Create tables if they don't exist...");
            createMealTable(conn);
            createMenuTable(conn);
            
            System.out.println("Inserting records into the table...");
            stmt = conn.prepareStatement("INSERT INTO meals VALUES (?,?,?,?,?)");
            
            stmt.setInt(1,menu.getMeal1().getId());
            stmt.setString(2,menu.getMeal1().getName());
            stmt.setString(3, menu.getMeal1().getDescription());
            stmt.setDouble(4,menu.getMeal1().getPrice()); 
            stmt.setBoolean(5, menu.getMeal1().isVegetarian()); 
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("INSERT INTO meals VALUES (?,?,?,?,?) ");
            stmt.setInt(1,menu.getMeal2().getId());
            stmt.setString(2,menu.getMeal2().getName());
            stmt.setString(3, menu.getMeal2().getDescription());
            stmt.setDouble(4,menu.getMeal2().getPrice()); 
            stmt.setBoolean(5, menu.getMeal2().isVegetarian()); 
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("INSERT INTO weekmenu(day, meal_1, meal_2) VALUES (?,?,?) ");
            stmt.setString(1,menu.getDay());
            stmt.setInt(2, menu.getMeal1().getId());
            stmt.setInt(3, menu.getMeal2().getId());
            stmt.executeUpdate();
         
            System.out.println("Inserted records into the table...");
            
        }catch(SQLException se){
            //Handle errors for JDBC
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, se);
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
}
