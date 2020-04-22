/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrganizationRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tools.MyTools;
import userinterface.OrganizationRole.Pet.InteractionwithHospitalJPanel11;
import userinterface.OrganizationRole.PetManage.ManagePetJPanel11;


/**
 *
 * @author wang
 */
public class OrganizationWorkerJPanel extends JPanel implements ActionListener{
    JPanel jp1,jp2;
    JButton jb1, jb2, jb3,jb4;
    JLabel jl;
    JPanel userProcessContainer;
    EcoSystem business;
    UserAccount account; 
    Enterprise userEnterprise;
    
    public OrganizationWorkerJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business){
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.business=business;
        this.initview();
        
        System.out.println(account.getEmployee().getName());
        userEnterprise = business.getEnterpriseDirectory().findEnterpriseID(account.getRole().getEnterpriseID());
    
    }
    
    
    public void initview(){
        jp1 = new JPanel();
        jp2 = new JPanel();
        
        
        
        jb1 = new JButton("Processing Pet Adoption");
        jb1.setFont(MyTools.f1);
        jb1.addActionListener(this);
        
        jb2 = new JButton("Processing Volunteer");
        jb2.setFont(MyTools.f1);
        jb2.addActionListener(this);
        
        
        jb3 = new JButton("Apply Medical Application");
        jb3.setFont(MyTools.f1);
        jb3.addActionListener(this);
        
        jb4 = new JButton("Manage Pets");
        jb4.setFont(MyTools.f1);
        jb4.addActionListener(this);
        
        
        
        jl = new JLabel(new ImageIcon("image/Hug.gif"));
        
        
        jp1.add(jl);
        
        
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        
        //设置整个布局为border
	this.setLayout(new BorderLayout());
	this.add(jp1,"North");
	this.add(jp2,"South");
        this.setSize(1200, 1100);
	this.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new AdoptionProcess(userProcessContainer, userEnterprise));
            layout.next(userProcessContainer);  
        }else if(e.getSource() == jb2){
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new ProcessVolunteerJPanel11(userProcessContainer,account,business));
            layout.next(userProcessContainer); 
        }else if(e.getSource() == jb3){
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new InteractionwithHospitalJPanel11(userProcessContainer,business,account));
            layout.next(userProcessContainer);   
        }else if(e.getSource() == jb4){
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(new ManagePetJPanel11(userProcessContainer,account,business));
        layout.next(userProcessContainer); 
        }
    }
}
