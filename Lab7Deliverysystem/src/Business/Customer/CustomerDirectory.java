/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    
    private ArrayList<Customer> CustomerDirectory;

    public CustomerDirectory() {
        CustomerDirectory=new ArrayList();
    }

    public ArrayList<Customer> getCustomerDirectory() {
        return CustomerDirectory;
    }
    
         public Customer findCustomer(String username) {
           
        for (Customer res : CustomerDirectory)
            if (res.getName().equals(username)){
                return res;
        }
        return null;
    }
    
    public Customer addCustomer(Customer customer){
        CustomerDirectory.add(customer);
        return customer;
    }
}
