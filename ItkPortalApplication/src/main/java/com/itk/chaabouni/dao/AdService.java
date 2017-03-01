/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import com.itk.chaabouni.dto.ClassifiedAd;
import com.itk.chaabouni.dto.Employee;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author mchaabouni
 */
@Named(value = "adService")
@SessionScoped
public class AdService implements Serializable {
 
    private static final String TABLE_NAME = "ads";
    /* Retrive list of employees from database
    If fail to connect to the database return a default list of employees
    source : http://www.javaknowledge.info/display-datatable-from-mysql-db-in-primefaces/
    */
    
    public List<ClassifiedAd> getListOfAds() {
          Session session = SessionService.getSessionFactory().openSession();
        session.beginTransaction();
        List<ClassifiedAd> adList = session.createCriteria(ClassifiedAd.class).list();
        session.close();
        
        if (adList.isEmpty()){
            adList = defaultAdsTable(); 
             System.out.println("Error In getEmployeeList() -->" + 
                     "Table 'itkportaldb.employee' doesn't exist" +
                    " Returning default table");
        }
        return adList;
    }
    
    public void addAd(ClassifiedAd newAd){
       Session session = SessionService.getSessionFactory().openSession();
        
        session.beginTransaction();
        session.save(newAd);
        
        session.getTransaction().commit();
        session.close();
    }

    private List<ClassifiedAd> defaultAdsTable() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = sdf.parse("27/02/2017");

        } catch (ParseException ex) {
            Logger.getLogger(AdService.class.getName()).log(Level.SEVERE, null, ex);
        }

        ClassifiedAd ad = new ClassifiedAd("John Doe", date, "Used iPhone 4", "Good condition. With Charger.");
        ArrayList<ClassifiedAd> outList = new ArrayList<>(); 
        outList.add(ad);
        return outList;
    }
}
