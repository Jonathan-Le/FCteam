/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import tools.MyTools;

/**
 *
 * @author wang
 */
public class ApplyVolunteerJPanel11 extends JPanel implements ActionListener{
    JPanel jp1, jp2, jp3;
    JTable jt1;
    JScrollPane jsp;
    JButton jb1, jb2, jb3;
    JLabel jl1;
    JPanel userProcessContainer;
     UserAccount account;
     EcoSystem business;
     Enterprise org;
    
    public ApplyVolunteerJPanel11(JPanel userProcessContainer, UserAccount account, EcoSystem business){
        this.initView();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.business=business;
        populateOrgTable();
    }
    
    public void populateOrgTable(){

            DefaultTableModel dtm = (DefaultTableModel) jt1.getModel();
            dtm.setRowCount(0);          
            ArrayList<Enterprise> entlist = business.getEnterpriseDirectory().getEnterpriseList();          
            if (entlist != null){               
                for(Enterprise ent : entlist){
                    if (ent.getEnterpriseType().equals(Enterprise.EnterpriseType.RescuOrganization)) {
                    Object[] row = new Object[2];
                    row[0]=ent.getEnterpriseID();
                    row[1]=ent.getEnterpriseName();
                    dtm.addRow(row);
                    }
                    
                }
            }    
    } 
    
    
    public void initView(){
        jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl1 = new JLabel("Rescue Organiztion List");
        jl1.setFont(MyTools.f2);
        jp1.add(jl1);
        
        jp2 = new JPanel(new BorderLayout());
        jt1 = new JTable();
        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }));
        jsp = new JScrollPane();
        jp2.add(jsp);
        
        jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jb1 = new JButton("Back");
        jb1.setFont(MyTools.f1);
        jb1.addActionListener(this);
        
        
        jb2 = new JButton("Refresh");
        jb2.setFont(MyTools.f1);
        jb2.addActionListener(this);
        
        jb3 = new JButton("Send Application");
        jb3.setFont(MyTools.f1);
        jb3.addActionListener(this);
        
        
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        
        
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp2,"Center");
        this.add(jp3,"South");
        this.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            //Back
                userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            CustomerWorkAreaJPanel11 dwjp = (CustomerWorkAreaJPanel11) component;
            dwjp.populateApplicationTable();
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }else if(e.getSource() == jb2){
            //Refresh
            populateOrgTable();
        }else if(e.getSource() == jb3){
            //Send Application
                int row = jt1.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null,"Selev a row");
                return;
            }else{
                String ID = jt1.getValueAt(row, 1).toString();
                Enterprise org =business.getEnterpriseDirectory().findEnterprise(ID);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new FillVolunteerJPanel(userProcessContainer, account, business,org));
                layout.next(userProcessContainer);
            }
        }
    }
    
}
