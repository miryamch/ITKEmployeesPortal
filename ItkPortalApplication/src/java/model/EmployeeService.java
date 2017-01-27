/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author mchaabouni
 */
@Named(value = "employeeService")
@ViewScoped
public class EmployeeService implements Serializable{
private ArrayList<Employee> employeeList;
    
    /**
     * Creates a new instance of EmployeeService
     */
    public EmployeeService() {
        employeeList = new ArrayList<>();
        initEmployeeList();
    }
    
    /**
     * Fills the emplyee list with two dummy objects
     */
    private void initEmployeeList(){
        Employee employee1 = new Employee("John Doe",
                "john.doe@itk-engineering.com", "5550001");
        employeeList.add(employee1);
        Employee employee2 = new Employee("Jane Doe",
                "jane.doe@itk-engineering.com", "5550002");
        employeeList.add(employee2);
    }
    
    public boolean addEmployee(Employee employee){
        boolean success=  employeeList.add(employee);
        return success;
    }
    
    /**
     * @param id  unique identfier of the employee in the data base   
     * @return an Employee object with the same id as the argument or 
     *          null if not found 
    */
    public Employee getEmployeeById (Long id ){
        // TODO: implement proper search  
        if (employeeList.isEmpty()){
            return null; 
        }
        return  employeeList.get(0); 
    }
    
    public ArrayList<Employee> getEmployeeList(){
        return employeeList; 
    }
    
}
