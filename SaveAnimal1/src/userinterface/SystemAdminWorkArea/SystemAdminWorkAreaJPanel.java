/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.*;
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
    
    
    public SystemAdminWorkAreaJPanel(){
        jp1 = new JPanel();
        jp2 = new JPanel();
        
        jb1 = new JButton("返回");
        jb1.setSize(112,29);
        
        jb2 = new JButton("管理医院");
        jb2.setSize(112,29);
        jb2.addActionListener(this);
        
        jb3 = new JButton("管理商店");
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

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb2){
            System.out.println("1");
            ManageCustomersJPanel mcj = new ManageCustomersJPanel();
            CardLayout ct=new CardLayout();
            System.out.println("2");
            //ct.addLayoutComponent(mcj, SOMEBITS);
            ct.addLayoutComponent("manageCustomersJPanel",mcj);
            System.out.println("3");
            
            CardLayout layout=(CardLayout)ct.
            layout.next(ManageCustomersJPanel);
        }
   
    }
    
}
