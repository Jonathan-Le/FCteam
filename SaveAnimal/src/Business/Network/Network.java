/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import java.util.UUID;

/**
 *
 * @author junyaoli
 */
public class Network {
     private String name;
    private int id;
    private EnterpriseDirectory enterpriseDirectory;
    

//    private static int count = 1;

    public Network(String name) {
        this.name = name;
        this.id = getUUID();
        enterpriseDirectory = new EnterpriseDirectory();
        
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

  
    
}
