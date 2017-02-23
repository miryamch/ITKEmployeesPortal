/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import com.itk.chaabouni.dto.Meal;
import com.itk.chaabouni.dto.Menu;

/**
 *
 * @author mchaabouni
 */
public class fillDataBase {
    public static void main(String[] args){
        
//        EmployeeService service  = new EmployeeService();
//        
//        Employee employee = new Employee("Daniel Wasserbar",
//                "daniel.wasserbar@itk-engineering.com", "55500003");
//        service.addEmployee(employee);
//        
//        employee = new Employee("Alexander Pahrl",
//                "alex.pahrl@itk-engineering.com", "55500004");
//        service.addEmployee(employee);
//        
//        employee = new Employee("Michael Tengler",
//                "michael.tengler@itk-engineering.com", "55500005");
//        service.addEmployee(employee);
//        
//        employee = new Employee("Miryam Bouchaani",
//                "miryam.bouchaani@itk-engineering.com", "55500006");
//        service.addEmployee(employee);
//        
        //********************************************************************
        MealService ms = new MealService(); 
        Meal meal1 = new Meal();
        Meal meal2 = new Meal(); // default meal

        // Monday menu 
        meal1.setId(100);
        
        meal2.setId(101);
        meal2.setName("Pizza");
        meal2.setDescription("with ham and mushrooms");
        meal2.setVegetarian(false);
        
        ms.addMenu(new Menu("Monday", meal1, meal2));
        
        // Tuesday menu 
        meal1.setId(102);
        meal1.setName("Salmon ");
        meal1.setDescription("with side vegetables");
        meal1.setVegetarian(false);
        meal1.setPrice(10.0);
        
        meal2.setId(103);
        meal2.setName("Lentils soup ");
        meal2.setDescription(" with carrots and cottage cheese");
        meal2.setVegetarian(true);
        
        ms.addMenu(new Menu("Tuesday", meal1, meal2));
        
        // Wednesday's menu 
        meal1.setId(104);
        meal1.setName("Cheese burger ");
        meal1.setDescription("with fried potatoes");
        meal1.setVegetarian(false);
        meal1.setPrice(8.0);
        
        meal2.setId(105);
        meal2.setName("Spinach Lasagna");
        meal2.setDescription("with cream sauce and Grana Padano");
        meal2.setVegetarian(true);
        
        ms.addMenu(new Menu("Wednesday", meal1, meal2));
    }
    
}
