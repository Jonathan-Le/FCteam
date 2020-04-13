/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Role.HospitalAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */
public class HospitalAdminOrg extends Department {

     public HospitalAdminOrg(DepartmentType depType, int enterpriseID) {
        super(depType.getValue(), depType.HospitalAdminOrg,enterpriseID);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        final int depID = this.getOrganizationID();
        final int enterpriseID = this.getEnterpriseID();
         return new ArrayList<Role>() {
            {
                add(new HospitalAdminRole(Role.RoleType.Worker.getValue(),  enterpriseID));
            }
        };
    }
    
}
