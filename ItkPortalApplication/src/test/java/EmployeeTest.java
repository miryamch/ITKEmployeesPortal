/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itk.chaabouni.dto.Employee;
import static org.junit.Assert.assertEquals;
import org.junit.Test; 
/**
 *
 * @author mchaabouni
 */
public class EmployeeTest {
    
    private Employee mInstance ; 
    private final String testName1 = "John Doe"; 
    private final String testName2 = "John Doe"; 
    private final String testEmail1 = "john.doe@itk-engineering.com"; 
    private final String testEmail2 = "john.doe@itk-engineering.com"; 
    private final String testPhone1 = "5550001"; 
    private final String testPhone2 = "5550002"; 
    
    
    public EmployeeTest() {
        mInstance = new Employee(testName1, testEmail1, testPhone1);  
    }
    
    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = testName1;
        String result = mInstance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Employee.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = testName2;
        mInstance.setName(name);
        assertEquals(name, mInstance.getName());

    }

    /**
     * Test of getEmail method, of class Employee.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = testEmail1;
        String result = mInstance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Employee.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = testEmail2;
        mInstance.setEmail(email);
        assertEquals(email, mInstance.getEmail());
    }

    /**
     * Test of getPhoneNumber method, of class Employee.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        String expResult = testPhone1;
        String result = mInstance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoneNumber method, of class Employee.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = testPhone2;
        mInstance.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, mInstance.getPhoneNumber());
    }
    
}
