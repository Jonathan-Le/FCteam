/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pet;

import Business.WorkQueue.VaccineRequest;
import java.util.UUID;
import java.util.jar.Attributes;

/**
 *
 * @author junyaoli
 */
public class Pet {
//    private String Weight;
    private int ID;
    private String name ;
    private String Age;
    private String species;
    final static int count= 0 ;
    private ExaminationResult examinationResult;
    private VaccineResult vaccineResult;

    public Pet(String name,String species, String Age ) {
        this.name=name;
        this.Age = Age;
        this.species = species;
        ID=getUUID();
        examinationResult=new ExaminationResult();
        vaccineResult=new VaccineResult();
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

    public VaccineResult getVaccineResult() {
        return vaccineResult;
    }

    public void setVaccineResult(VaccineResult vaccineResult) {
        this.vaccineResult = vaccineResult;
    }

   

    public ExaminationResult getExaminationResult() {
        return examinationResult;
    }

    public void setExaminationResult(ExaminationResult examinationResult) {
        this.examinationResult = examinationResult;
    }
     

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
  
}
