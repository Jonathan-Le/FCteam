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
    
    private ArrayList<WorkRequest> adoptionkRequestList;
    private ArrayList<WorkRequest> treatmentRequestList;

    public WorkQueue() {
        adoptionkRequestList = new ArrayList();
        treatmentRequestList= new ArrayList();
    }
    
    public WorkRequest findAdoptionRequest(int ID) {
           
        for (WorkRequest request : adoptionkRequestList)
            if (request.getID()==ID){
                return request;       
        }
        return null;
    }
    
     public WorkRequest findTreatmentRequest(int ID) {
           
        for (WorkRequest request : treatmentRequestList)
            if (request.getID()==ID){
                return request;       
        }
        return null;
    }

    public ArrayList<WorkRequest> getTreatmentRequestList() {
        return treatmentRequestList;
    }

    public void setTreatmentRequestList(ArrayList<WorkRequest> treatmentRequestList) {
        this.treatmentRequestList = treatmentRequestList;
    }
    

    public ArrayList<WorkRequest> getAdoptionkRequestList() {
        return adoptionkRequestList;
    }
}