package Business;

import Business.Department.Department;
import Business.Department.DoctorOrg;
import Business.Department.HospitalAdminOrg;
import Business.Department.OrganizationAdminOrg;
import Business.Department.SystemOrg;
import Business.Department.WorkerOrg;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.RescueAnimalOrganization.RescueAnimalOrganization;
import Business.Enterprise.hospital.Hospital;
import Business.Network.Network;
import Business.Role.DoctorRole;
import Business.Role.HospitalAdminRole;
import Business.Role.OrganizationAdminRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Role.WorkerRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        Network network = new Network("Saving Animals");
        system.getNetworkdirectory().getNetworkdirectory().add(network);
        //create an enterprise  
        Hospital hospital= (Hospital)network.getEnterpriseDirectory().addEnterprise("国际第一宠物医院", Enterprise.EnterpriseType.hospital);
        RescueAnimalOrganization organization =(RescueAnimalOrganization)network.getEnterpriseDirectory().addEnterprise("国际第一宠物医院", Enterprise.EnterpriseType.RescuOrganization);
        //initialize some organizations
  
        SystemOrg systemOrg  = (SystemOrg)organization.getDepartmentDirectory().createOrganization(Department.DepartmentType.SystemOrg, 0);     
        OrganizationAdminOrg organizationAdminOrg = (OrganizationAdminOrg)organization.getDepartmentDirectory().createOrganization(Department.DepartmentType.OrganizationAdminOrg, 0);
        WorkerOrg workerOrg  = (WorkerOrg)organization.getDepartmentDirectory().createOrganization(Department.DepartmentType.WorkerOrg, 0);
        DoctorOrg doctorOrg = (DoctorOrg)hospital.getDepartmentDirectory().createOrganization(Department.DepartmentType.DoctorOrg, 0);
        HospitalAdminOrg hospitalAdminOrg  = (HospitalAdminOrg)hospital.getDepartmentDirectory().createOrganization(Department.DepartmentType.HospitalAdminOrg, 0);
        //have some employees 
        Employee sysEmp = systemOrg.getEmployeeDirectory().createEmployee("sysEmp", Department.DepartmentType.SystemOrg);   
        Employee orgadminEmp = systemOrg.getEmployeeDirectory().createEmployee("orgadminEmp", Department.DepartmentType.OrganizationAdminOrg);
        Employee workerEmp = systemOrg.getEmployeeDirectory().createEmployee("workerEmp", Department.DepartmentType.WorkerOrg);
        Employee doctorEmp = systemOrg.getEmployeeDirectory().createEmployee("doctorEmp", Department.DepartmentType.DoctorOrg);
        Employee hospitaladminEmp = systemOrg.getEmployeeDirectory().createEmployee("hospitaladminEmp", Department.DepartmentType.HospitalAdminOrg);
        //create user account
        UserAccount orgadminAccount= system.getUserAccountDirectory().createUserAccount("orgadmin", "123", orgadminEmp, new OrganizationAdminRole(Role.RoleType.OrganizationAdmin.getValue(),organization.getEnterpriseID()));
        UserAccount workerAccount= system.getUserAccountDirectory().createUserAccount("worker", "123", orgadminEmp, new WorkerRole(Role.RoleType.Worker.getValue(),organization.getEnterpriseID()));
        UserAccount doctorAccount= system.getUserAccountDirectory().createUserAccount("doctor", "123", orgadminEmp, new DoctorRole(Role.RoleType.Doctor.getValue(),hospital.getEnterpriseID()));
        UserAccount hospitaladminAccount= system.getUserAccountDirectory().createUserAccount("hosadmin", "123", orgadminEmp, new HospitalAdminRole(Role.RoleType.HospitalAdmin.getValue(),hospital.getEnterpriseID()));
        
         
       Employee employee = system.getEmployeeDirectory().createEmployee("RRH", Department.DepartmentType.SystemOrg);
        
       UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole("admin",1));
        
        return system;
    }
    
}
