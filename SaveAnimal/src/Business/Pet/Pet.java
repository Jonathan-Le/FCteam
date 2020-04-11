/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pet;

import com.sun.javafx.scene.traversal.WeightedClosestCorner;

/**
 *
 * @author junyaoli
 */
public class Pet {
//    private String Weight;
    private String Age;
    private String species;

    public Pet(String species, String Age ) {
        
        this.Age = Age;
        this.species = species;
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
