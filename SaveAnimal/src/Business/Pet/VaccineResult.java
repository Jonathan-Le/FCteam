/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pet;

import java.util.Date;

/**
 *
 * @author junyaoli
 */
public class VaccineResult {
    private String vaccinename =""; 
    private String vaccineintroduction="";
    private Date injectDate;

    public VaccineResult() {
        injectDate=new Date();
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

    public Date getInjectDate() {
        return injectDate;
    }

    public void setInjectDate(Date injectDate) {
        this.injectDate = injectDate;
    }
    
}
