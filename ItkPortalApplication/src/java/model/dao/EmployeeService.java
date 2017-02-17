/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.dto.Employee;

/**
 *
 * @author mchaabouni
 */
@Named(value = "employeeService")
@ViewScoped
public class EmployeeService implements Serializable{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/itkportaldb";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASSWORD = "nbuser";
    
    private static final String tableName = "employee";
    /* Retrive list of employees from database
    If fail to connect to the database return a default list of employees
    source : http://www.javaknowledge.info/display-datatable-from-mysql-db-in-primefaces/
    */
    public ArrayList<Employee> getEmployeeList(){
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL,USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                Employee e = new Employee();
                e.setName(rs.getString("name"));
                e.setPhoneNumber(rs.getString("phone_number"));
                e.setEmail(rs.getString("email"));
                employeeList.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return employeeList;
            } else {
                System.out.println("Employee list not found. Using default list.");
                return defaultEmployeeList();
            }
        } catch (Exception e) {
            System.out.println("Error In getEmployee() -->" + e.getMessage());
            return (null);
        }
    }
    
    /**
     * Fills the emplyee list with two dummy objects
     */
    private ArrayList<Employee> defaultEmployeeList(){
        ArrayList<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee("John Doe",
                "john.doe@itk-engineering.com", "5550001");
        employeeList.add(employee1);
        Employee employee2 = new Employee("Jane Doe",
                "jane.doe@itk-engineering.com", "5550002");
        employeeList.add(employee2);
        return employeeList;
    }
    
    /*
    Add an employee to the data base 
    returns true if operation succeeds 
    */
    public boolean addEmployee(Employee employee){
        boolean success = true;
        Connection conn = null;
        Statement stmt = null;
     
        try{

            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected database successfully...");
            
            //STEP 4: Execute a query
            System.out.println("Create table if it doesn't exist...");
            createTable(conn);

            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO employee " +
                    "VALUES ('"+ employee.getId() +"', '" + 
                    employee.getName() + "', '" +
                    employee.getEmail() +"', '" +
                    employee.getPhoneNumber() +"')";
            stmt.executeUpdate(sql);
            
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
    
 
    /*
    Adds a table of employees to the database if it doesn't exist
    */
    private void createTable(Connection conn) throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + this.tableName
                + "  (id            INTEGER,"
                + "   name           VARCHAR(50),"
                + "   email          VARCHAR(50),"
                + "   phone_number   VARCHAR(50))";
        
        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }
    
}
