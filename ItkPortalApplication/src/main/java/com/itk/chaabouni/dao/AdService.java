/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itk.chaabouni.dao;

import com.itk.chaabouni.dto.ClassifiedAd;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mchaabouni
 */
@Named(value = "adService")
@SessionScoped
public class AdService implements Serializable {

    /**
     * Creates a new instance of AdService
     */
    public AdService() {
    }
    
    public List<ClassifiedAd> getListOfAds() {
        ArrayList<ClassifiedAd> outList = new ArrayList<>(); 
        Date date = new Date(2017, 2, 27);
        ClassifiedAd ad = new ClassifiedAd("John Doe", date, "Used iPhone 4", "Good condition. With Charger."); 
        outList.add(ad); 
        return outList; 
    }
    
    public void addAd(ClassifiedAd newAd){
        
    }
    
    
}
