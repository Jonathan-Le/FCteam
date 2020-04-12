package Business.Enterprise;


import Business.Enterprise.RescueAnimalOrganization.RescueAnimalOrganization;
import Business.Enterprise.hospital.Hospital;
import java.util.ArrayList;

/**
 *
 * @author lhm
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public Enterprise addEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.hospital) {
            enterprise = new Hospital(name);          
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.RescuOrganization) {
            enterprise = new RescueAnimalOrganization(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
    public void deleteEnterprise(Enterprise enterprise){
        this.enterpriseList.remove(enterprise);
    }
}
