/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;



import Business.Employee.EmployeeDirectory;
import Business.Network.NetworkDirectory;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author MyPC1
 */
public class EcoSystem {
    
    private static EcoSystem business;
    private NetworkDirectory networkdirectory;
    private UserAccountDirectory userAccountDirectory;
    private EmployeeDirectory employeeDirectory;
    

    public EcoSystem() {

        this.networkdirectory = new NetworkDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.employeeDirectory= new EmployeeDirectory();
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
}
