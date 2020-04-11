/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Department.Department.DepartmentType;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */
public class SystemOrg extends Department {
     public SystemOrg(DepartmentType depType, int enterpriseID) {
        super(depType.getValue(), depType.SystemOrg,enterpriseID);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        final int depID = this.getOrganizationID();
        final int enterpriseID = this.getEnterpriseID();
         return new ArrayList<Role>() {
            {
                add(new SystemAdminRole(Role.RoleType.Worker.getValue(),  enterpriseID));
            }
        };
    }
}
