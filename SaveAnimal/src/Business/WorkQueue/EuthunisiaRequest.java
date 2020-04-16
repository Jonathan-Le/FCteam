/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Pet.Pet;
import java.util.Date;

/**
 *
 * @author junyaoli
 */
public class EuthunisiaRequest extends WorkRequest {
    String Reason;
    
    Pet pet;

    public EuthunisiaRequest(String Reason, Pet pet) {
        this.Reason = Reason;
        this.pet = pet;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    
    
}
