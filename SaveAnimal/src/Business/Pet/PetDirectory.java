/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pet;

import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */
public class PetDirectory {
    private ArrayList<Pet> petlist;

    public PetDirectory() {
        petlist = new ArrayList();
    }

    public ArrayList<Pet> getPetlist() {
        return petlist;
    }

    public void setPetlist(ArrayList<Pet> petlist) {
        this.petlist = petlist;
    }
    
    public Pet AddPet(Pet pet){
        petlist.add(pet);
        return pet;
    }
    
    public void CreatePet(String species, String Age){   
        petlist.add(new Pet( species,  Age));
    }
    
}
