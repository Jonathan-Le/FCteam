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
        CustomerDirectory= new ArrayList();
    }
    
    public Customer addRestaurant(Customer customer) {
        Customer cus = new Customer();
        cus=customer;
        CustomerDirectory.add(cus);
        return customer;
    }   
    public ArrayList<Customer> getRestaurantDirectory() {
        return CustomerDirectory;
    }

    public void deleteRestaurant(Customer account){
        this.CustomerDirectory.remove(account);
    }
    public void setRestaurantDirectory(ArrayList<Customer> CustomerDirectory) {
        this.CustomerDirectory = CustomerDirectory;
    }

    public Customer findRestaurant(String username) {
           
        for (Customer cus : CustomerDirectory)
            if (cus.getName().equals(username)){
                return cus;     
        }
        return null;
    }
    
}
