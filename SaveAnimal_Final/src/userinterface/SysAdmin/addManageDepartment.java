/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SysAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import tools.MyTools;

/**
 *
 * @author wang
 */
public class addManageDepartment extends JDialog implements ActionListener{
    JLabel jl1,jl2,jl3;
    JButton jCon,jCancel;
    JTextField jname;
    JPasswordField jpassword;
    JPanel jp1, jp2, jp3;
    EcoSystem system;
    Enterprise enterprise;
    
    public addManageDepartment(Enterprise enterprise){
        this.enterprise = enterprise;
        this.system=system; 
        this.setTitle("Add Manage Department");
		this.setLayout(new GridLayout(2, 1));
		this.setSize(300, 200);
		this.setLocation(550, 200);	
		
		jp1 = new JPanel();
		
		jp3= new JPanel();
		
		
		jl1 = new JLabel("name：");
		jl1.setFont(MyTools.f1);
		
		jname =new JTextField(13);
		
		
		jp1.add(jl1);
		jp1.add(jname);
		
		
		
		
		
		jCon =new JButton("Comfirm");
                jCon.setFont(MyTools.f1);
		jCon.addActionListener(this);
		
		jp3.add(jCon);
		
		
		this.add(jp1);
		
		this.add(jp3,BorderLayout.SOUTH);
                
		
		this.setVisible(true);

    }
    
    

        @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == jCon){
                    String name = jname.getText();
                   enterprise.getDepartmentDirectory().createOrganization(name);

                    this.dispose();

                }

            }
}
