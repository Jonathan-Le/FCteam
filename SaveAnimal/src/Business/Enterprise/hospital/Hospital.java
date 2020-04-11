/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.hospital;

import Business.Enterprise.Enterprise;
import Business.Department.Department;
import Business.Department.Department.DepartmentType;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class Hospital extends Enterprise {

   public Hospital(String name) {
        super(name, EnterpriseType.hospital);
    }

    @Override
    public ArrayList<Department.DepartmentType> getSupportedOrganization() {
        return new ArrayList<Department.DepartmentType>() {
            {
                add(DepartmentType.HospitalAdminOrg);               
            }
        };
    }

    
}
