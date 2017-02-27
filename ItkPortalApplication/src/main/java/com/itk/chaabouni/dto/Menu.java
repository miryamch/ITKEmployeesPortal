/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itk.chaabouni.dto;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.view.ViewScoped;
import javax.persistence.Entity;

/**
 *
 * @author mchaabouni
 */
@Entity(name = "menu")
@ViewScoped
public class Menu implements Serializable {
    private String day ;
    private Meal meal1 ;
    private Meal meal2 ; 
    
    public Menu(){
        this.day = ""; 
        this.meal1 = new Meal(); 
        this.meal2 = new Meal(); 
    }

    public Menu(String day, Meal meal1, Meal meal2) {
        this.day = day;
        this.meal1 = meal1;
        this.meal2 = meal2;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Meal getMeal1() {
        return meal1;
    }

    public void setMeal1(Meal meal1) {
        this.meal1 = meal1;
    }

    public Meal getMeal2() {
        return meal2;
    }

    public void setMeal2(Meal meal2) {
        this.meal2 = meal2;
    }
    
   public ArrayList<Meal> getMeals(){
        ArrayList<Meal> meals = new ArrayList<>(); 
        meals.add(meal1); 
        meals.add(meal2); 
        return meals; 
   }
}
