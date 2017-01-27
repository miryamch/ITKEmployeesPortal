/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author mchaabouni
 */
@Named(value = "menu")
@ViewScoped
public class WeeklyMenu implements Serializable{
    
    private HashMap<String, List<Meal>> mMenuList;
    /**
     * Creates a new instance of Menu
     */
    public WeeklyMenu() {
        mMenuList = new HashMap<>(); 
        generateDefaultMenu();
    }
    
    private void generateDefaultMenu() {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String weekDay : weekDays) {
            ArrayList<Meal> dayMenu = new ArrayList<>(); 
            Meal meal1 = new Meal(); // default meal 
            meal1.setDescription("Basil and garlic");
            dayMenu.add(meal1); 
            Meal meal2 = new Meal(); 
            meal2.setName("Pizza");
            meal2.setDescription("Ham and mushrooms ");
            dayMenu.add(meal2); 
            mMenuList.put(weekDay, dayMenu);
        }
    }
    
    public HashMap<String, List<Meal>> getMenuList() {
        return mMenuList;
    }    
    
    public List<Meal> getMenuByDay(String weekDay){
        return mMenuList.get(weekDay); 
    }
            
}
