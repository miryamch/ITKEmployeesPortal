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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        //********************************************************************
        session.beginTransaction();
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
        meal1 = new Meal("Wiener Schnitzel", "with fried potatoes", 10., false);
        meal2 = new Meal("Lentils soup ", "with carrots and cottage cheese", 5., true);
        Menu tuesdayMenu = new Menu("Tuesday", meal1, meal2);
        session.save(tuesdayMenu);
        
        // Wednesday's menu
        meal1 = new Meal("Cheese burger ", "with potatoe wedges", 8., false);
        meal2 = new Meal("Spinach Lasagna", "with cream sauce and Grana Padano", 5., true);
        Menu wednesdayMenu = new Menu("Wednesday", meal1, meal2);
        session.save(wednesdayMenu);
        
        // Thursday's menu
        meal1 = new Meal("Spaghetti Bolognese ", "", 8., false);
        meal2 = new Meal("Vegetable Curry", "with Basmati rice", 5., true);
        Menu thursdayMenu = new Menu("Thursday", meal1, meal2);
        session.save(thursdayMenu);
        
        // Friday's menu
        meal1 = new Meal("Salmon", "with side vegetables", 8., false);
        meal2 = new Meal("Penne Allarabiata", "spicy", 5., true);
        Menu fridayMenu = new Menu("Friday", meal1, meal2);
        session.save(fridayMenu);
        
        session.getTransaction().commit();
        //********************************************************************
        session.beginTransaction();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = sdf.parse("27/02/2017");
            
        } catch (ParseException ex) {
            Logger.getLogger(AdService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ClassifiedAd ad1 = new ClassifiedAd("John Doe", date, "Used iPhone 4", "Good condition. With Charger.");
        session.save(ad1);
        
        ClassifiedAd ad2 = new ClassifiedAd("Jane Doe", date, "3 Bedrooms appartment to rent in Sendling-Westpark",
                "Looking for someone to take over the contract. Rent is 1600,-€/month charges included.");
        session.save(ad2);
        session.getTransaction().commit();
        //********************************************************************
        session.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
    
}
