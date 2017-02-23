/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model.dto;

import java.io.Serializable;
import java.util.Random;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author mchaabouni
 */
@ViewScoped
@Named("employee")
public class Employee implements Serializable {
    @Id long id;
    private String mName;
    private String mEmail;
    private String mPhoneNumber ;
    @Transient
    private final String DEFAULT_NAME = "John Doe";
    @Transient
    private final String DEFAULT_EMAIL = "john.doe@itk-engineering.com";
    @Transient
    private final String DEFAULT_PHONE = "5550001";
    
    public Employee() {
        Random randomGenerator = new Random();
        this.id = randomGenerator.nextInt(1000);
        this.mName = DEFAULT_NAME;
        this.mEmail = DEFAULT_EMAIL;
        this.mPhoneNumber = DEFAULT_PHONE;
    }
    
    
    /**
     * Creates a new instance of Employee
     * @param name full name of the employee
     * @param email company E-mail adress of the employee
     * @param phoneNumber direct line in the company or mobile
     */
    public Employee(String name, String email, String phoneNumber) {
        Random randomGenerator = new Random();
        id = randomGenerator.nextInt(1000);
        mName = name;
        mEmail = email;
        mPhoneNumber = phoneNumber;
    }
    
    
    public String getName() {
        return mName;
    }
    
    public void setName(String name) {
        this.mName = name;
    }
    
    public String getEmail() {
        return mEmail;
    }
    
    public void setEmail(String email) {
        this.mEmail = email;
    }
    
    public String getPhoneNumber() {
        return mPhoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }
    
    public long getId() {
        return id;
    }
    
}
