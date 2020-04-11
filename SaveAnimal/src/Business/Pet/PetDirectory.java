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
    
    public Pet findPet(int ID) {
       for (Pet pet : petlist) {
            if (pet.getID()==ID) {
                return pet;
            }
            JOptionPane.showMessageDialog(null, "No enterprise");
        }
        return null;
    }
    
    public Pet AddPet(Pet pet){
        petlist.add(pet);
        return pet;
    }
    
    public void CreatePet(String species, String Age){   
        petlist.add(new Pet( species,  Age));
    }
    
}
