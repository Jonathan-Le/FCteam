/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pet;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public Pet findPet(String ID) {
       for (Pet pet : petlist) {
            if (pet.getName()==ID) {
                return pet;
            }
        }
        return null;
    }
    
    public Pet AddPet(Pet pet){
        petlist.add(pet);
        return pet;
    }
    
    public void CreatePet(String name,String species, String Age){   
        petlist.add(new Pet( name, species,  Age));
    }
    
}
