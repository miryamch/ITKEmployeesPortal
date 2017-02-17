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
import java.util.ArrayList;
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
    
    public boolean addEmployee(Employee employee){
//        boolean success=  employeeList.add(employee);
//        return success;
        return false  ; 
    }
    
    /*
    source : http://www.javaknowledge.info/display-datatable-from-mysql-db-in-primefaces/
    */
    public ArrayList<Employee> getEmployeeList(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itkportaldb","root", "nbuser");
            PreparedStatement ps = connection.prepareStatement("select * from employee");
            ArrayList<Employee> employeeList = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                Employee e = new Employee();
                e.setName(rs.getString("mName"));
                e.setPhoneNumber(rs.getString("mPhoneNumber"));
                e.setEmail(rs.getString("mEmail"));
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
    
}
