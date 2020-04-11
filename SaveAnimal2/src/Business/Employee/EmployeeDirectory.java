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

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name, Department.DepartmentType dep){
        Employee employee = new Employee(name,dep);
        employeeList.add(employee);
        return employee;
    }
}