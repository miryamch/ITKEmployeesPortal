/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.itk.chaabouni.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Singelton design pattern, lazy initialization with double checked-lock
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * @author mchaabouni
 */
public class SessionService {
    private static SessionFactory sessionFactory = null;
    
    private SessionService(){
        
    }
    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            synchronized(SessionService.class){
                if (sessionFactory==null){
                    Configuration configuration = new Configuration();
                    configuration.configure();
                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                            configuration.getProperties()).build();
                    sessionFactory =  configuration.buildSessionFactory(serviceRegistry);
                }
            }
        }
        return sessionFactory;
    }
}
