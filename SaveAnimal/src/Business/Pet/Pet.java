/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pet;

/**
 *
 * @author junyaoli
 */
public class Pet {
//    private String Weight;
    private int ID;
    private String Age;
    private String species;
    final static int count= 0 ;

    public Pet(String species, String Age ) {
        
        this.Age = Age;
        this.species = species;
 
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
