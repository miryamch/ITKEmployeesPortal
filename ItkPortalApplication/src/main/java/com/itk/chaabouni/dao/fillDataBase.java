/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import com.itk.chaabouni.dto.ClassifiedAd;
import com.itk.chaabouni.dto.Employee;
import com.itk.chaabouni.dto.Meal;
import com.itk.chaabouni.dto.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author mchaabouni
 */
public class fillDataBase {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        //********************************************************************        
        Employee employee1 = new Employee("Daniel Wasserbar",
                "daniel.wasserbar@itk-engineering.com", "55500003");
        session.save(employee1);
        
        Employee employee2 = new Employee("Alexander Pahrl",
                "alex.pahrl@itk-engineering.com", "55500004");
        session.save(employee2);
        
        Employee employee3 = new Employee("Michael Tengler",
                "michael.tengler@itk-engineering.com", "55500005");
        session.save(employee3);
        
        Employee employee4 = new Employee("Miryam Bouchaani",
                "miryam.bouchaani@itk-engineering.com", "55500006");
        session.save(employee4);
        
        session.getTransaction().commit();
        //********************************************************************
        
        session.beginTransaction();
      
        // Monday menu
        Meal meal1 = new Meal("Pizza", "with ham and mushrooms", 5., false);
        Meal meal2 = new Meal("Pesto Pasta", "with basil and garlic", 5., true);
        Menu mondayMenu = new Menu("Monday", meal1, meal2);
        session.save(mondayMenu);
        
        // Tuesday menu
        meal1 = new Meal("Salmon", "with side vegetables", 10., false);
        meal2 = new Meal("Lentils soup ", "with carrots and cottage cheese", 5., true);
        Menu tuesdayMenu = new Menu("Tuesday", meal1, meal2);
        session.save(tuesdayMenu);
        
        // Wednesday's menu
        meal1 = new Meal("Cheese burger ", "with fried potatoes", 8., false);
        meal2 = new Meal("Spinach Lasagna", "with cream sauce and Grana Padano", 5., true);
        Menu wednesdayMenu = new Menu("Wednesday", meal1, meal2);
        session.save(wednesdayMenu);
      
        session.getTransaction().commit();
        
        //********************************************************************
        
        session.close();
    }
    
}
