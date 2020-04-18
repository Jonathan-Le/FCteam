/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.RescueAnimalOrganization;

import Business.Enterprise.Enterprise;
import Business.Department.Department;
import Business.Pet.Pet;
import Business.Pet.PetDirectory;
import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */
public class RescueAnimalOrganization extends Enterprise {
   
    PetDirectory petDirectory;
    
    public RescueAnimalOrganization(String name) {
        super(name, EnterpriseType.RescuOrganization);
        petDirectory= new PetDirectory();
    }

    @Override
    public ArrayList<Department.DepartmentType> getSupportedOrganization() {
        return new ArrayList<Department.DepartmentType>() {
            {
                add(Department.DepartmentType.WorkerOrg);               
            }
        };
    }

    public PetDirectory getPetDirectory() {
        return petDirectory;
    }

    public void setPetDirectory(PetDirectory petDirectory) {
        this.petDirectory = petDirectory;
    }
    
    

}
