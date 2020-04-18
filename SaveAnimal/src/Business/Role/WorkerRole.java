/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Organization.OrganizationManagementJPanel;
import userinterface.OrganizationRole.OrganizationWorkerJPanel;

/**
 *
 * @author junyaoli
 */
public class WorkerRole extends Role {
     public WorkerRole(String roleType, int enterpriseID) {
        super(roleType,  enterpriseID);
    }
        public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new OrganizationWorkerJPanel(userProcessContainer, account, business);
    }
    
    
}
