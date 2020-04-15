package Business;

import Business.Customer.Customer;
import Business.Department.Department;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Pet.Pet;
import Business.Role.CustomerRole;
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
        Network network = system.getNetworkdirectory().CreaNetwork("Saving Animals");
        Network network1 = system.getNetworkdirectory().CreaNetwork(" aaa");
        //create an enterprise  
        Enterprise hospital= network.getEnterpriseDirectory().addEnterprise("国际宠物医院");
        Enterprise organization =network.getEnterpriseDirectory().addEnterprise("国际宠物救助组织");
//        system.getEnterpriseDirectory().addEnterprise("国际宠物救助", Enterprise.EnterpriseType.hospital);
//        system.getEnterpriseDirectory().addEnterprise("国际宠物医院", Enterprise.EnterpriseType.RescuOrganization);
                
        //Pets
        organization.getPetDirectory().AddPet(new Pet("Dog", "1 Month"));
        organization.getPetDirectory().AddPet(new Pet("Dog", "12 Month"));
        organization.getPetDirectory().AddPet(new Pet("Cat", "1 Year"));
        organization.getPetDirectory().AddPet(new Pet("Cat", "8 Month"));
        organization.getPetDirectory().AddPet(new Pet("Puppy", "7 Month"));

        //initialize some organizations
  
        Department systemOrg  = organization.getDepartmentDirectory().createOrganization("systemOrg");     
        Department organizationAdminOrg = organization.getDepartmentDirectory().createOrganization("organizationAdminOrg");
        Department workerOrg  = organization.getDepartmentDirectory().createOrganization("workerOrg");
        Department doctorOrg = hospital.getDepartmentDirectory().createOrganization("doctorOrg");
        Department hospitalAdminOrg  = hospital.getDepartmentDirectory().createOrganization("hospitalAdminOrg");
        //have some employees 
        Employee sysEmp = systemOrg.getEmployeeDirectory().createEmployee("sysEmp");   
        Employee orgadminEmp = organizationAdminOrg.getEmployeeDirectory().createEmployee("orgadminEmp");
        Employee workerEmp = workerOrg.getEmployeeDirectory().createEmployee("workerEmp");
        Employee doctorEmp = doctorOrg.getEmployeeDirectory().createEmployee("doctorEmp");
        Employee hospitaladminEmp = hospitalAdminOrg.getEmployeeDirectory().createEmployee("hospitaladminEmp");
        
        organization.getEmployeeDirectory().getEmployeeList().add(orgadminEmp);
        organization.getEmployeeDirectory().getEmployeeList().add(workerEmp);
        hospital.getEmployeeDirectory().getEmployeeList().add(doctorEmp);
        hospital.getEmployeeDirectory().getEmployeeList().add(hospitaladminEmp);
        //create user account
        UserAccount orgadminAccount= system.getUserAccountDirectory().createUserAccount("orgadmin", "123", orgadminEmp, new OrganizationAdminRole(Role.RoleType.OrganizationAdmin.getValue(),organization.getEnterpriseID()));
        UserAccount workerAccount= system.getUserAccountDirectory().createUserAccount("worker", "123", workerEmp, new WorkerRole(Role.RoleType.Worker.getValue(),organization.getEnterpriseID()));
        UserAccount doctorAccount= system.getUserAccountDirectory().createUserAccount("doctor", "123", doctorEmp, new DoctorRole(Role.RoleType.Doctor.getValue(),hospital.getEnterpriseID()));
        UserAccount hospitaladminAccount= system.getUserAccountDirectory().createUserAccount("hosadmin", "123", hospitaladminEmp, new HospitalAdminRole(Role.RoleType.HospitalAdmin.getValue(),hospital.getEnterpriseID()));
        //create user account
        
        Employee CusEmployee = systemOrg.getEmployeeDirectory().createEmployee("cusEmp"); 
        UserAccount userAccount= system.getUserAccountDirectory().createUserAccount("user", "123", CusEmployee, new CustomerRole(Role.RoleType.Customer.getValue(),organization.getEnterpriseID()));
        userAccount.getPetlist().add(new Pet("dog", "12 year"));// 
        userAccount.getPetlist().add(new Pet("cat", "10 month"));
         
       Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        
       UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "123", employee, new SystemAdminRole("admin",1));
        
       return system;
    }
    
}
