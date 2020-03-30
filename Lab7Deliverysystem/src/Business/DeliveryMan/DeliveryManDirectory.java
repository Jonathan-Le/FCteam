/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {
      private ArrayList<DeliveryMan> DeliveryManDirectory;

    public DeliveryManDirectory() {
        DeliveryManDirectory=new ArrayList();
    }

    public ArrayList<DeliveryMan> getDeliveryManDirectory() {
        return DeliveryManDirectory;
    }
    
     public DeliveryMan findDeliveryMan(String username) {
           
        for (DeliveryMan res : DeliveryManDirectory)
            if (res.getName().equals(username)){
                return res;
        }
        return null;
    }
    
    public void deleteUserAccount(DeliveryMan account){
        this.DeliveryManDirectory.remove(account);
    }
    public DeliveryMan  addDeliveryMan(DeliveryMan deliveryman){
        DeliveryManDirectory.add(deliveryman);
        return deliveryman;
    }
    
}
