/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;



import Business.Customer.CustomerDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.Network.NetworkDirectory;
import Business.Pet.PetDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author MyPC1
 */
public class EcoSystem {
    
    private static EcoSystem business;
    private NetworkDirectory networkdirectory;
    private UserAccountDirectory userAccountDirectory;
    private EmployeeDirectory employeeDirectory;
    private EnterpriseDirectory enterpriseDirectory;
    private PetDirectory petDirectory;
    private CustomerDirectory customerDirectory;
    
    
    private WorkQueue adoptionQueue;
    
    public EcoSystem() {

        this.networkdirectory = new NetworkDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.employeeDirectory= new EmployeeDirectory();
        this.enterpriseDirectory= new EnterpriseDirectory();
        this.petDirectory = new PetDirectory();
        this.adoptionQueue = new WorkQueue();
        customerDirectory=new CustomerDirectory();
        
    }
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public boolean checkIfUserIsUnique(String userName){
      
       if (!this.userAccountDirectory.checkIfUsernameIsUnique(userName)) {
            return false;
        }
//        for (Network network : this.networkDirectory.getNetworkMap().values()) {
//            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
//                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
//                    if (!organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
//                        return false;
//                    }
//                }
//            }
//        }
        return true;
      
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    

    public WorkQueue getAdoptionQueue() {
        return adoptionQueue;
    }

    public void setAdoptionQueue(WorkQueue adoptionQueue) {
        this.adoptionQueue = adoptionQueue;
    }

    public PetDirectory getPetDirectory() {
        return petDirectory;
    }

    public void setPetDirectory(PetDirectory petDirectory) {
        this.petDirectory = petDirectory;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public NetworkDirectory getNetworkdirectory() {
        return networkdirectory;
    }

    public void setNetworkdirectory(NetworkDirectory networkdirectory) {
        this.networkdirectory = networkdirectory;
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
    
    
}
