/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model.dao;

import java.sql.SQLException;
import model.dto.Employee;

/**
 *
 * @author mchaabouni
 */
public class fillDataBase {
    public static void main(String[] args){
        
        EmployeeService service  = new EmployeeService();
        
        Employee employee = new Employee("Daniel Basserraw",
                "daniel.basserraw@itk-engineering.com", "55500003");
        service.addEmployee(employee);
        
        employee = new Employee("Alexander Lrahp",
                "alex.lrahp@itk-engineering.com", "55500004");
        service.addEmployee(employee);
        
        employee = new Employee("Michael Tengler",
                "michael.tengler@itk-engineering.com", "55500005");
        service.addEmployee(employee);
        
        employee = new Employee("Miryam Bouchaani",
                "miryam.bouchaani@itk-engineering.com", "55500006");
        service.addEmployee(employee);
    }
 
}
