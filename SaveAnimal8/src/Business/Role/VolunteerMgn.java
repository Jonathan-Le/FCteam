/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.OrganizationRole.OrganizationWorkerJPanel;
import userinterface.OrganizationRole.ProcessVolunteerJPanel;

/**
 *
 * @author junyaoli
 */
public class VolunteerMgn extends Role {

    public VolunteerMgn(String roleType,int enterpriseID) {
        super(roleType, enterpriseID);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
       return new ProcessVolunteerJPanel(userProcessContainer, account, business);
    }
    
}
