/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Pet.Pet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author harold
 */
public class Customer {
    int ID;
    String name;
    ArrayList<Pet> PetList;

    public Customer(String name) {
        PetList=new ArrayList();
        this.name=name;
        ID=getUUID();
    }
    public int getUUID(){
        String id = null;
        UUID uuid = UUID.randomUUID();
        id=uuid.toString();
        
        id=id.replace("-", "");
        int num= id.hashCode();
        num=Math.abs(num);
        return  num;      
    }
    
    public ArrayList<Pet> getPetList() {
        return PetList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
