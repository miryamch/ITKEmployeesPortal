/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dto;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 *
 * @author mchaabouni
 */
@Embeddable
public class Meal implements Serializable{
    private String name ;
    private String description;
    private Double price;
    private boolean vegetarian ;
    @Transient
    private final String DEFAULT_NAME = "Pesto Pasta";
    @Transient
    private final Double DEFAULT_PRICE = 4.5;
    @Transient
    private final boolean DEFAULT_VEGETARIAN = true;
    
    /**
     * Creates a new instance of Meal
     */
    public Meal() {
        this.name = DEFAULT_NAME;
        this.description = "";
        this.price = DEFAULT_PRICE;
        this.vegetarian = DEFAULT_VEGETARIAN;
    }
    
    public Meal(String name, String description, Double price, boolean isVegetarian) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetarian = isVegetarian;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String Name) {
        this.name = Name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String Description) {
        this.description = Description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}
