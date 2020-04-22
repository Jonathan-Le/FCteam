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
public class VaccineRequest extends WorkRequest {
    private String vaccinename ; 
    private String vaccineintroduction;
    private Pet pet;

   
 
    public VaccineRequest(String title, String requestType,Pet pet) {
        super(title, requestType);
        this.pet=pet;
    }
    
    public String getVaccinename() {
        return vaccinename;
    }

    public void setVaccinename(String vaccinename) {
        this.vaccinename = vaccinename;
    }

    public String getVaccineintroduction() {
        return vaccineintroduction;
    }

    public void setVaccineintroduction(String vaccineintroduction) {
        this.vaccineintroduction = vaccineintroduction;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
   
    
}
