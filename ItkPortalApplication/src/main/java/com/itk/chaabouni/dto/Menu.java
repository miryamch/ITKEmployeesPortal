/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dto;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.view.ViewScoped;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author mchaabouni
 */
@Entity(name = "weekmenu")
@ViewScoped
public class Menu implements Serializable {
    @Id @GeneratedValue
    private int id;
    private String weekDay ;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="name", column=@Column(name="name_meal1")),
        @AttributeOverride(name="description", column=@Column(name="description_meal1")),
        @AttributeOverride(name="price", column=@Column(name="price_meal1")),
        @AttributeOverride(name="vegetarian", column=@Column(name="vegetarian_meal1"))
    })
    private Meal meal1 ;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="name", column=@Column(name="name_meal2")),
        @AttributeOverride(name="description", column=@Column(name="description_meal2")),
        @AttributeOverride(name="price", column=@Column(name="price_meal2")),
        @AttributeOverride(name="vegetarian", column=@Column(name="vegetarian_meal2"))
    })
    private Meal meal2 ;
    
    public Menu(){
        this.weekDay = "";
        this.meal1 = new Meal();
        this.meal2 = new Meal();
    }
    
    public Menu(String day, Meal meal1, Meal meal2) {
        this.weekDay = day;
        this.meal1 = meal1;
        this.meal2 = meal2;
    }
    
    public int getId() {
        return id;
    }
    
    public String getWeekDay() {
        return weekDay;
    }
    
    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
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
