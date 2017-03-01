/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import com.itk.chaabouni.dto.Meal;
import com.itk.chaabouni.dto.Menu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.hibernate.Session;


/**
 *
 * @author mchaabouni
 */
@Named(value = "mealService")
@ViewScoped
public class MealService implements Serializable{
    
    public List<Menu> getMenuList() {
        Session session = SessionService.getSessionFactory().openSession();
        session.beginTransaction();
        List<Menu> menuList = session.createCriteria(Menu.class).list();
        session.close();
         if (menuList.isEmpty()){
            menuList = defaultMenuList(); 
             System.out.println("Error In getEmployeeList() -->" + 
                     "Table 'itkportaldb.weekmenu' doesn't exist" +
                    " Returning default table");
        }
        return menuList;
    }
    
    /*
    Add an employee to the data base
    returns true if operation succeeds
    */
    public void addMenu(Menu menu){
        
        Session session = SessionService.getSessionFactory().openSession();
        
        session.beginTransaction();
        session.save(menu);
        
        session.getTransaction().commit();
        session.close();
    }
   
    private ArrayList<Menu> defaultMenuList() {
        ArrayList<Menu> menuList = new ArrayList<>();
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String weekDay : weekDays) {
            Menu menu = new Menu();
            menu.setWeekDay(weekDay);
            
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
}
