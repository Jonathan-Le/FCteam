/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.Organization;
import Business.UserAccount.UserAccount;
import userinterface.Hospital.HospitalAdminJPanel;
import javax.swing.JPanel;
import userinterface.Organization.OrganizationManagementJPanel;
import userinterface.Organization.OrganizationManagementJPanel11;

/**
 *
 * @author raunak
 */
public class OrganizationAdminRole extends Role{
     public OrganizationAdminRole(String roleType, int enterpriseID) {
        super(roleType, enterpriseID);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new OrganizationManagementJPanel11( userProcessContainer,  account,  business);
    }

    
    
}
