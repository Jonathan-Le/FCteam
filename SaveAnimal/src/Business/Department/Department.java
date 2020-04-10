/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */

public abstract class Department {
    
    private int organizationID;
    private String name;
    private DepartmentType DepartmentType;
    private String description;
    private int enterpriseID;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private WorkQueue workQueue;
    private static int counter = 0;
    

    public enum DepartmentType {
        HospitalAdminOrg("HospitalAdmin Org"), 
        OrganizationAdminOrg("OrganizationAdmin Org"),
        SystemOrg("System Org"),
        WorkerOrg("Worker Org");
        
//        PurchasingAgent("PurchasingAgent Org"), 
//        StoreOrg("StoreManage Org"),
//        OrderOrg("Order Org"), 
//        FinancialOrg("Financial Org"),
//        GenerateOrg("Generate Org") ;
        
        private String value;

        private DepartmentType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public Department(String name, Department.DepartmentType DepartmentType, int enterpriseID) {
        this.name = name;
        this.DepartmentType = DepartmentType;
        this.enterpriseID = enterpriseID;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        workQueue = new WorkQueue();
        organizationID = ++counter;
    }
    
    public abstract ArrayList<Role> getSupportedRole();

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentType getDepartmentType() {
        return DepartmentType;
    }

    public void setDepartmentType(DepartmentType DepartmentType) {
        this.DepartmentType = DepartmentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(int enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Department.counter = counter;
    }

}