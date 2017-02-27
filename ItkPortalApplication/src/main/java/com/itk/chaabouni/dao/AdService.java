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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(); 
        try {
            date = sdf.parse("27/02/2017");
            
        } catch (ParseException ex) {
            Logger.getLogger(AdService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ClassifiedAd ad = new ClassifiedAd("John Doe", date, "Used iPhone 4", "Good condition. With Charger.");
        outList.add(ad);
        return outList;
    }
    
    public void addAd(ClassifiedAd newAd){
        
    }
    
    
}
