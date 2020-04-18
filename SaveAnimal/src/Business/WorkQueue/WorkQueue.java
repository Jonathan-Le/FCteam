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
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }
    
    public WorkRequest findWorkRequest(int ID) {
           
        for (WorkRequest request : workRequestList)
            if (request.getID()==ID){
                return request;       
        }
        return null;
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}