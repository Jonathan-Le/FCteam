/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Employee.EmployeeDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.UUID;

/**
 *
 * @author junyaoli
 */
public class Department {
    private int departmentID;
    private String name;
    private String description;
    private int enterpriseID;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private WorkQueue workQueue;
    

//    public enum DepartmentType {
//        HospitalAdminOrg("HospitalAdminOrg"), 
//        OrganizationAdminOrg("OrganizationAdminOrg"),
//        SystemOrg("SystemOrg"),
//        DoctorOrg("DoctorOrg"),
//        CustomerOrg("CustomerOrg"),
//        WorkerOrg("WorkerOrg");
//     
//        private String value;
//
//        private DepartmentType(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }  
    public Department(String name) {
        this.name = name;
        this.departmentID = getUUID();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        workQueue = new WorkQueue();
    }
 public int getUUID(){
        String id = null;
        UUID uuid = UUID.randomUUID();
        id=uuid.toString();
        
        id=id.replace("-", "");
        int num= id.hashCode();
        num=Math.abs(num);
        return  num;      
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



}
