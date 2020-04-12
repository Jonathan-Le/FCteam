/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author junyaoli
 */
public class AdoptionRequest extends WorkRequest {
    private String selfeDes;
    private int budget;

    
    public AdoptionRequest(String selfeDes, int budget) {
        this.selfeDes = selfeDes;
        this.budget = budget;
    }

    public String getSelfeDes() {
        return selfeDes;
    }

    public void setSelfeDes(String selfeDes) {
        this.selfeDes = selfeDes;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    
    
}
