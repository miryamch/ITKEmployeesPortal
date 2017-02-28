/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.itk.chaabouni.dto.Employee;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author mchaabouni
 */
@Named(value = "employeeService")
@ViewScoped
public class EmployeeService implements Serializable{
    
    /* 
    Retrive list of employees from database using Hibernate Session 
    */
    public List<Employee> getEmployeeList(){
        Session session = SessionService.getSessionFactory().openSession();
        session.beginTransaction();
        List<Employee> employeeList = session.createCriteria(Employee.class).list();
        session.close();
        return employeeList;
    }
    
    /*
    Add an employee to the data base
    returns true if operation succeeds
    */
    public void addEmployee(Employee employee){
        
        Session session = SessionService.getSessionFactory().openSession();
        
        session.beginTransaction();
        session.save(employee);
        
        session.getTransaction().commit();
        session.close();
    }
        
    /**
     * Fills the emplyee list with two simple objects
     */
    @Deprecated
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
}
