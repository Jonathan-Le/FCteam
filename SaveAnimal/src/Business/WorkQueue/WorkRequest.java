/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String title;
    private String sender;
    private String receiver;
    private String status;
    private String result;
    private Date requestDate;
    private Date resolveDate;
    private int ID;
    private String requestType ; 
   
    
    public WorkRequest(String title,String requestType){
        requestDate = new Date();
        ID=getUUID();
        this.title=title;
        this.requestType=requestType;
    }
    public enum RequestType{
        
        AdoptionRequest("AdoptionRequest"),
        ApplicationOfVolunteer("ApplicationOfVolunteer"),
        ExaminationRequest("ExaminationRequest"),
        VaccineRequest("VaccineRequest"),
        EuthanasiaRequest("EuthanasiaRequest");
        
        private String value;
        private RequestType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
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
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
    
    

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
}
