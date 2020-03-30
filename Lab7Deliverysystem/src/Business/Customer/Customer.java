/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;



/**
 *
 * @author harold
 */
public class Customer {
    private String name;
    private int count=0;
    private int ID ;

    public Customer(String name) {
        this.name = name;
        ID=count;
        count++;
    }

    public int getID() {
        return ID;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
