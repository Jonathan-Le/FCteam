/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Role.CustomerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */
public class CustomerOrg extends Department{
    
     public CustomerOrg( DepartmentType depType, int enterpriseID) {
        super(depType.getValue(), depType.CustomerOrg,enterpriseID);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        final int depID = this.getOrganizationID();
        final int enterpriseID = this.getEnterpriseID();
         return new ArrayList<Role>() {
            {
                add(new CustomerRole(Role.RoleType.Customer.getValue(),  enterpriseID));
            }
        };
    }
}
