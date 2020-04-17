/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author wang
 */
public class CustomerManageJPanel extends JPanel implements ActionListener{
    JPanel jp1,jp2;
    JButton jb2, jb3;
    JLabel jl;
    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem business;
    
    
    public CustomerManageJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business){
        
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.business=business;
        
        jp1 = new JPanel();
        jp2 = new JPanel();
        
        
        jb2 = new JButton("Pet Adoption");
        jb2.setSize(112,29);
        jb2.addActionListener(this);
        
        jb3 = new JButton("Treat Pet");
        jb3.addActionListener(this);
        jb3.setSize(200,100);
        
        
        
        jl = new JLabel(new ImageIcon("image/customManageeview.gif"));
        
        
        jp1.add(jl);
        
        
        jp2.add(jb2);
        jp2.add(jb3);  
        
        //设置整个布局为border
	this.setLayout(new BorderLayout());
	this.add(jp1,"North");
	this.add(jp2,"South");
        
	this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb2){
            System.out.println("1");
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new PetadoptionJPanel(userProcessContainer, account, business));
            layout.next(userProcessContainer);
        }else if(e.getSource() == jb3){
            System.out.println("2");
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new TreatPetsJPanel(userProcessContainer, account, business));
            layout.next(userProcessContainer);
        }
    }
    
    
}
