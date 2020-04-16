/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Pet.Pet;

/**
 *
 * @author junyaoli
 */
public class AdoptionRequest extends WorkRequest {
    private String selfeDes;
    private int budget;
    private Pet pet;

    
    public AdoptionRequest(String selfeDes, int budget,Pet pet) {
        this.selfeDes = selfeDes;
        this.budget = budget;
        this.pet=pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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
