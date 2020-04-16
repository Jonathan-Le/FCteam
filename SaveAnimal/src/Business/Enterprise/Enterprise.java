/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Department.DepartmentDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Pet.Pet;
import Business.Pet.PetDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author junyaoli
 */
public class Enterprise {

    private String enterpriseName;
    private int enterpriseID;
    private UserAccountDirectory userAccountDirectory;
    private EmployeeDirectory employeeDirectory;
    private DepartmentDirectory DepartmentDirectory;
    private EnterpriseType enterpriseType;
    private WorkQueue WorkQueue;
    private PetDirectory petDirectory;


    public enum EnterpriseType {
        RescuOrganization("RescuOrganization Enterprise"),
        hospital("hospital Enterprise");
        private String value;
        private EnterpriseType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    

    public Enterprise(String name) {
        this.enterpriseName = name;
        DepartmentDirectory = new DepartmentDirectory();
        userAccountDirectory = new UserAccountDirectory();
        employeeDirectory = new EmployeeDirectory();
        this.WorkQueue = new WorkQueue();
        petDirectory=new PetDirectory();
        enterpriseID=getUUID();
    }

    public PetDirectory getPetDirectory() {
        return petDirectory;
    }

    public void setPetDirectory(PetDirectory petDirectory) {
        this.petDirectory = petDirectory;
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
    public WorkQueue getWorkQueue() {
        return WorkQueue;
    }

    public void setWorkQueue(WorkQueue WorkQueue) {
        this.WorkQueue = WorkQueue;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public int getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(int enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public DepartmentDirectory getDepartmentDirectory() {
        return DepartmentDirectory;
    }

    public void setOrganizationDirectory(DepartmentDirectory AppartmentDirectory) {
        this.DepartmentDirectory = AppartmentDirectory;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
//    public abstract ArrayList<Department.DepartmentType> getSupportedOrganization();

    @Override
    public String toString(){
        return this.enterpriseName + " (" + this.enterpriseType + ")";
    }



}
