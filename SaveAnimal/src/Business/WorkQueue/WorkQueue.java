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
    
    private ArrayList<WorkRequest> WorkRequestList;

    public WorkQueue() {        
            WorkRequestList= new ArrayList();            
    }
    
    public WorkRequest findRequestbyname(String title) {
           
        for (WorkRequest request : WorkRequestList)
            if (request.getTitle()==title){
                return request;       
        }
        
        return null;
    }
     public WorkRequest findRequestbyID(int ID) {
           
        for (WorkRequest request : WorkRequestList)
            if (request.getID()==ID){
                return request;       
        }
         
        return null;
    }
    

    public ArrayList<WorkRequest> getWorkRequestList() {
        return WorkRequestList;
    }
}