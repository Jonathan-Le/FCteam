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
    private ArrayList<ExaminationRequest> examinationRequestList;
    private ArrayList<EuthanasiaRequest> EutRequestList;

    public WorkQueue() {
        
        if (EutRequestList==null) {
            EutRequestList= new ArrayList();
        }
        if (adoptionkRequestList==null) {
            adoptionkRequestList= new ArrayList();
        }
        if (examinationRequestList==null) {
            examinationRequestList= new ArrayList();
        }

    }
    
    public WorkRequest findRequestbyname(String title) {
           
        for (WorkRequest request : adoptionkRequestList)
            if (request.getTitle()==title){
                return request;       
        }
         for (WorkRequest request : examinationRequestList)
            if (request.getTitle()==title){
                return request;       
        }
          for (WorkRequest request : EutRequestList)
            if (request.getTitle()==title){
                return request;       
        }
        return null;
    }
    public WorkRequest findRequestbyID(int ID) {
           
        for (WorkRequest request : adoptionkRequestList)
            if (request.getID()==ID){
                return request;       
        }
         for (WorkRequest request : examinationRequestList)
            if (request.getID()==ID){
                return request;       
        }
          for (WorkRequest request : EutRequestList)
            if (request.getID()==ID){
                return request;       
        }
        return null;
    }

    public ArrayList<EuthanasiaRequest> getEutRequestList() {
        return EutRequestList;
    }

    public void setEutRequestList(ArrayList<EuthanasiaRequest> EutRequestList) {
        this.EutRequestList = EutRequestList;
    }
    

    public ArrayList<ExaminationRequest> getExaminationRequestList() {
        if (examinationRequestList==null) {
          examinationRequestList=new ArrayList<>();
          return examinationRequestList;
        }
        return examinationRequestList;
    }

    public void setExaminationRequestList(ArrayList<ExaminationRequest> examinationRequestList) {
        this.examinationRequestList = examinationRequestList;
    }
    

    public ArrayList<AdoptionRequest> getAdoptionkRequestList() {
        return adoptionkRequestList;
    }
}