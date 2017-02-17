/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model.dao;

import java.sql.SQLException;
import model.dto.Employee;
import model.dto.Meal;
import model.dto.Menu;

/**
 *
 * @author mchaabouni
 */
public class fillDataBase {
    public static void main(String[] args){
        
        EmployeeService service  = new EmployeeService();
        
        Employee employee = new Employee("Daniel Wasserbar",
                "daniel.wasserbar@itk-engineering.com", "55500003");
        service.addEmployee(employee);
        
        employee = new Employee("Alexander Pahrl",
                "alex.pahrl@itk-engineering.com", "55500004");
        service.addEmployee(employee);
        
        employee = new Employee("Michael Tengler",
                "michael.tengler@itk-engineering.com", "55500005");
        service.addEmployee(employee);
        
        employee = new Employee("Miryam Bouchaani",
                "miryam.bouchaani@itk-engineering.com", "55500006");
        service.addEmployee(employee);
        
        //********************************************************************
        MealService ms = new MealService(); 
        Meal meal1 = new Meal();
        meal1.setId(100);
        meal1.setName("Pizza");
        meal1.setDescription("Ham and mushrooms ");
        meal1.setVegetarian(false);
        Meal meal2 = new Meal(); // default meal
        meal2.setId(101);
        meal2.setDescription("Basil and garlic");

        Menu menu = new Menu("Monday", meal1, meal2); 
        ms.addMenu(menu);
        
    }
    
}
