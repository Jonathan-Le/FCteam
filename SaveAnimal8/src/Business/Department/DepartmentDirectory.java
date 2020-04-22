/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */
public class DepartmentDirectory {
    private ArrayList<Department> DepartmentDirectory;

    public DepartmentDirectory() {
        this.DepartmentDirectory = new ArrayList();
    }

    public ArrayList<Department> getDepartmentDirectory() {
        return DepartmentDirectory;
    }
    
    public Department findDepartment(String name){
        
        for (Department network1 : DepartmentDirectory) {
            if (network1.getName().equals(name)) {
                return network1;
            }
        }
        return null;
    }
    
   public Department createOrganization( String name ) {
        Department department = null;
        department = new Department(name);
        DepartmentDirectory.add(department);
//            DepartmentDirectory.add(department);
//        if (type.getValue().equals(Department.DepartmentType.OrganizationAdminOrg.getValue())) {
//            department = new OrganizationAdminOrg(Department.DepartmentType.OrganizationAdminOrg, enterpriseID);
//            DepartmentDirectory.add(department);
//        } else if (type.getValue().equals(Department.DepartmentType.HospitalAdminOrg.getValue())) {
//            department = new HospitalAdminOrg(Department.DepartmentType.HospitalAdminOrg, enterpriseID);
//            DepartmentDirectory.add(department);
//        } else if (type.getValue().equals(Department.DepartmentType.SystemOrg.getValue())) {
//            department = new SystemOrg(Department.DepartmentType.SystemOrg, enterpriseID);
//            DepartmentDirectory.add(department);
//        } else if (type.getValue().equals(Department.DepartmentType.WorkerOrg.getValue())) {
//            department = new WorkerOrg(Department.DepartmentType.WorkerOrg, enterpriseID);
//            DepartmentDirectory.add(department);
//        }
        
        return department;
    }
   
    
}
