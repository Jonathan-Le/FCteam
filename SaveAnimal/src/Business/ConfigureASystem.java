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
import com.sun.xml.internal.ws.util.JAXWSUtils;
import java.util.ArrayList;
import java.util.UUID;

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
        system.getEnterpriseDirectory().getEnterpriseList().add(organization);
        system.getEnterpriseDirectory().getEnterpriseList().add(hospital);
        
        organization.setEnterpriseType(Enterprise.EnterpriseType.RescuOrganization);
        hospital.setEnterpriseType(Enterprise.EnterpriseType.hospital);
//        system.getEnterpriseDirectory().addEnterprise("国际宠物救助", Enterprise.EnterpriseType.hospital);
//        system.getEnterpriseDirectory().addEnterprise("国际宠物医院", Enterprise.EnterpriseType.RescuOrganization);
                
        //Pets
        organization.getPetDirectory().AddPet(new Pet("1","Dog", "1 Month"));
        organization.getPetDirectory().AddPet(new Pet("2","Dog", "12 Month"));
        organization.getPetDirectory().AddPet(new Pet("3","Cat", "1 Year"));
        organization.getPetDirectory().AddPet(new Pet("4","Cat", "8 Month"));
        organization.getPetDirectory().AddPet(new Pet("5","Puppy", "7 Month"));

        //initialize some organizations
  
        
        Department organizationAdminOrg = organization.getDepartmentDirectory().createOrganization("organizationAdminOrg");
        Department workerOrg  = organization.getDepartmentDirectory().createOrganization("workerOrg");
        Department doctorOrg = hospital.getDepartmentDirectory().createOrganization("doctorOrg");
        Department hospitalAdminOrg  = hospital.getDepartmentDirectory().createOrganization("hospitalAdminOrg");
        //have some employees 
        
        Employee orgadminEmp = organizationAdminOrg.getEmployeeDirectory().createEmployee("orgadminEmp");
        Employee workerEmp = workerOrg.getEmployeeDirectory().createEmployee("workerEmp");
        Employee doctorEmp = doctorOrg.getEmployeeDirectory().createEmployee("doctorEmp");
        Employee hospitaladminEmp = hospitalAdminOrg.getEmployeeDirectory().createEmployee("hospitaladminEmp");
        
//        organization.getEmployeeDirectory().getEmployeeList().add(orgadminEmp);
//        organization.getEmployeeDirectory().getEmployeeList().add(workerEmp);
//        hospital.getEmployeeDirectory().getEmployeeList().add(doctorEmp);
//        hospital.getEmployeeDirectory().getEmployeeList().add(hospitaladminEmp);
        //create user account
        UserAccount orgadminAccount= system.getUserAccountDirectory().createUserAccount("orgadmin", "123", orgadminEmp, new OrganizationAdminRole(Role.RoleType.OrganizationAdmin.getValue(),organization.getEnterpriseID()));        
        UserAccount workerAccount= system.getUserAccountDirectory().createUserAccount("worker", "123", workerEmp, new WorkerRole(Role.RoleType.Worker.getValue(),organization.getEnterpriseID()));       
        UserAccount doctorAccount= system.getUserAccountDirectory().createUserAccount("doctor", "123", doctorEmp, new DoctorRole(Role.RoleType.Doctor.getValue(),hospital.getEnterpriseID()));       
        UserAccount hospitaladminAccount= system.getUserAccountDirectory().createUserAccount("hosadmin", "123", hospitaladminEmp, new HospitalAdminRole(Role.RoleType.HospitalAdmin.getValue(),hospital.getEnterpriseID()));
        //create user account      
        UserAccount userAccount= system.getUserAccountDirectory().createCusUserAccount("user", "123", new CustomerRole(Role.RoleType.Customer.getValue()));
        userAccount.getPetlist().add(new Pet("a","dog", "12 year"));// 
        userAccount.getPetlist().add(new Pet("b","cat", "10 month"));
         
       //ID统一
       orgadminAccount.setId(orgadminEmp.getId());
       workerAccount.setId(workerEmp.getId());
       doctorAccount.setId(doctorEmp.getId());
       hospitaladminAccount.setId(hospitaladminEmp.getId());
           
       UserAccount ua = system.getUserAccountDirectory().createCusUserAccount("sysadmin", "123", new SystemAdminRole("RRH"));
        
       return system;
    }
     
}
