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
    
    private ArrayList<AdoptionRequest> adoptionkRequestList;
    private ArrayList<WorkRequest> treatmentRequestList;
    private ArrayList<EuthunisiaRequest> EutRequestList;

    public WorkQueue() {
        adoptionkRequestList = new ArrayList();
        treatmentRequestList= new ArrayList();
        EutRequestList= new ArrayList();
    }
    
    public WorkRequest findRequest(int ID) {
           
        for (WorkRequest request : adoptionkRequestList)
            if (request.getID()==ID){
                return request;       
        }
         for (WorkRequest request : treatmentRequestList)
            if (request.getID()==ID){
                return request;       
        }
          for (WorkRequest request : EutRequestList)
            if (request.getID()==ID){
                return request;       
        }
        return null;
    }

    public ArrayList<EuthunisiaRequest> getEutRequestList() {
        return EutRequestList;
    }

    public void setEutRequestList(ArrayList<EuthunisiaRequest> EutRequestList) {
        this.EutRequestList = EutRequestList;
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
    

    public ArrayList<AdoptionRequest> getAdoptionkRequestList() {
        return adoptionkRequestList;
    }
}