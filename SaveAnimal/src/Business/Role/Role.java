/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    private String roleType;
    private int orgID;
    private int enterpriseID;
    
    public enum RoleType{
        HospitalAdmin("HospitalAdmin"),
        OrganizationAdmin("OrganizationAdmin"),
        Customer("Customer"),
        Doctor("Doctor"),
        Worker("Worker"),
        SysAdmin("Sysadmin");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
        public Role(String roleType,  int enterpriseID) {
        this.roleType = roleType;
//        this.orgID = orgID;
        this.enterpriseID = enterpriseID;
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account,  
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}