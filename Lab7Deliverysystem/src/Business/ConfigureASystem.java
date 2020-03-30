package Business;


import Business.Customer.Customer;
import Business.DeliveryMan.DeliveryMan;
import Business.Employee.Employee;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.DeliverManRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
       //Create a Restauran
       Restaurant res = new Restaurant("restaurant", "Boston", "110");
       system.getRestaurantDirectory().addRestaurant(res);
       //添加顾客
        Customer cus = new Customer("customer");
        system.getCustomerDirectory().addCustomer(cus);
//        
//      //添加快递员
        DeliveryMan del = new DeliveryMan("deliveryman");
        system.getDeliveryManDirectory().addDeliveryMan(del);
        
        
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");    
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        Role sysadminRole= new SystemAdminRole();   
        system.getUserAccountDirectory().createUserAccount("sadmin", "sadmin",new Employee(), sysadminRole);
        
        Role resadminRole= new AdminRole();
        system.getUserAccountDirectory().createUserAccount("restaurant", "restaurant", new Employee(), resadminRole);
        
        Role customerRole= new CustomerRole();
        system.getUserAccountDirectory().createUserAccount("customer", "customer",new Employee(),  customerRole);
        
        Role delivermanRole= new DeliverManRole();
        system.getUserAccountDirectory().createUserAccount("deliveryman", "deliveryman", new Employee(), delivermanRole);
        
        system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", new Employee(), new SystemAdminRole());
        
        return system;
    }
    
}
