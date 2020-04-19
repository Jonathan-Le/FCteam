/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pet;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author junyaoli
 */
public class ExaminationResult {
    
    private Date Testdate;
    private String EyeNoseThroat="";
    private String Lymph="";
    private String Heart="";
    private String Breath="";
    private String Skin="";
    private String BodyTemperature="";
    private String MentalHealth="";

    public ExaminationResult() {
   
        Testdate=new Date();
    }

    
    public String getEyeNoseThroat() {
        return EyeNoseThroat;
    }

    public void setEyeNoseThroat(String EyeNoseThroat) {
        this.EyeNoseThroat = EyeNoseThroat;
    }

    public String getLymph() {
        return Lymph;
    }

    public void setLymph(String Lymph) {
        this.Lymph = Lymph;
    }

    public String getHeart() {
        return Heart;
    }

    public void setHeart(String Heart) {
        this.Heart = Heart;
    }

    public String getBreath() {
        return Breath;
    }

    public void setBreath(String Breath) {
        this.Breath = Breath;
    }

    public String getSkin() {
        return Skin;
    }

    public void setSkin(String Skin) {
        this.Skin = Skin;
    }

    public String getBodyTemperature() {
        return BodyTemperature;
    }

    public void setBodyTemperature(String BodyTemperature) {
        this.BodyTemperature = BodyTemperature;
    }

    public String getMentalHealth() {
        return MentalHealth;
    }

    public void setMentalHealth(String MentalHealth) {
        this.MentalHealth = MentalHealth;
    }
    
    
}
