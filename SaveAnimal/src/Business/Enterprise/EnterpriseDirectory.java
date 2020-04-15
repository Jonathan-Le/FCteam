package Business.Enterprise;


import com.db4o.cs.internal.messages.Message;
import java.awt.TrayIcon;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    public Enterprise addEnterprise(String name) {
        
         Enterprise enterprise = new Enterprise(name) ;          
         enterpriseList.add(enterprise);
         return enterprise;
    }
    
    public Enterprise findEnterprise(String name){
        for (Enterprise enterprise : enterpriseList) {
            if (enterprise.getEnterpriseName().equals(name)) {
                return enterprise;
            }  
        }
        return null;
    }
    
    public void deleteEnterprise(Enterprise enterprise){
        this.enterpriseList.remove(enterprise);
    }
}
