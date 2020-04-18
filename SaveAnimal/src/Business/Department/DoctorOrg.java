/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Department.Department.DepartmentType;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */
public class DoctorOrg extends Department {
    
    public DoctorOrg( DepartmentType depType, int enterpriseID) {
        super(depType.getValue(), depType.HospitalAdminOrg,enterpriseID);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        final int depID = this.getOrganizationID();
        final int enterpriseID = this.getEnterpriseID();
         return new ArrayList<Role>() {
            {
                add(new DoctorRole(Role.RoleType.Doctor.getValue(),  enterpriseID));
            }
        };
    }
}
