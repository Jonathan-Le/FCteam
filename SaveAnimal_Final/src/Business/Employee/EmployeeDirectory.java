/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;
    

    public EmployeeDirectory() {
        employeeList = new ArrayList();
        
    }
    
    public Employee findEmployee(String name){
         
        for (Employee network1 : employeeList) {
            if (network1.getName().equals(name)) {
                return network1;
            }
        }
        return null;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee(name);
        employeeList.add(employee);
        return employee;
    }
}