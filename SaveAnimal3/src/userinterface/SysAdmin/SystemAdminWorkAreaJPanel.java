/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SysAdmin;

import Business.EcoSystem;

import Business.Organization;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;





/**
 *
 * @author wang
 */
public class SystemAdminWorkAreaJPanel extends JPanel implements ActionListener{
    JPanel jp1,jp2;
    JButton jb1, jb2, jb3,jb4;
    JLabel jl;
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer,EcoSystem ecosystem){
        this.userProcessContainer=userProcessContainer;
        this.ecosystem=ecosystem;
        this.sysView();     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb2){
            hospital h = new hospital(userProcessContainer, ecosystem);
            userProcessContainer.add("manageCustomersJPanel",h);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }else if(e.getSource() == jb3){
            shop s = new shop(userProcessContainer, ecosystem);
            userProcessContainer.add("manageCustomersJPanel",s);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }
            
    public void sysView(){
        jp1 = new JPanel();
        jp2 = new JPanel();
        
        jb1 = new JButton("返回");
        jb1.setSize(112,29);
        
        jb2 = new JButton("管理医院");
        jb2.setSize(112,29);
        jb2.addActionListener(this);
        
        jb3 = new JButton("管理商店");
        jb3.addActionListener(this);
        jb3.setSize(112,29);
        
        jb4 = new JButton("管理客户");
        
        jl = new JLabel(new ImageIcon("image/dog.gif"));
        
        
        jp1.add(jl);
        
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        
        //设置整个布局为border
	this.setLayout(new BorderLayout());
	this.add(jp1,"North");
	this.add(jp2,"South");
        
	this.setVisible(true);
    }
}
    
   
    
  
   
    

    
    

