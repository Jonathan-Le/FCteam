/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<commentrequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }
    public commentrequest findrequest(int orderID){
        
        for (commentrequest object : workRequestList) {
            if (object.getOrderID()==orderID) {
                return object;
            }
        }
        return null;
        
}
    public ArrayList<commentrequest> getWorkRequestList() {
        return workRequestList;
    }

    public void removeorder(int orderID) {
         
        for (commentrequest object : workRequestList) {
            if (object.getOrderID()==orderID) {
                workRequestList.remove(object);
            }
        }
    }
}