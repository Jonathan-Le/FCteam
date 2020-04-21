/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Pet.Pet;
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
public class ApplyPetAdoptionJPanel11 extends JPanel implements ActionListener{
    JPanel jp1, jp1_1, jp1_2, jp1_3, jp2, jp2_1, jp2_2, jp2_3;
    JLabel jl1, jl2;
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
    JTable jt1, jt2;
    JScrollPane jsp1, jsp2;
    JPanel userProcessContainer;
     UserAccount account;
     EcoSystem business;
     Enterprise org;
     ApplyPetAdoptionJPanel11(JPanel userProcessContainer, UserAccount account, EcoSystem business){
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
    public void populatePetTable(Enterprise org){

            DefaultTableModel dtm = (DefaultTableModel) jt2.getModel();
            dtm.setRowCount(0);           
            ArrayList<Pet> petlist = org.getPetDirectory().getPetlist();           
            if (petlist != null){                 
                for(Pet pet : petlist){
                    Object[] row = new Object[4];
                    row[0] = pet.getID();
                    row[1] = pet.getName();
                    row[2]=pet.getSpecies();
                    row[3]= pet.getAge();
                    dtm.addRow(row);
                }
            }     
    }
     
    public void initView(){
        jp1 = new JPanel(new BorderLayout());
        jp1_1 = new JPanel();
        jl1 = new JLabel("Rescue Organiztion List");
        jl1.setFont(MyTools.f2);    
        jp1_1.add(jl1);
        
        jp1_2 = new JPanel(new BorderLayout());
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
        jsp1 = new JScrollPane(jt1);
        jp1_2.add(jsp1);
        
        jp1_3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jb1 = new JButton("Refresh");
        jb1.setFont(MyTools.f1);    
        jb1.addActionListener(this);
        
        jb2 = new JButton("Choose");
        jb2.setFont(MyTools.f1);  
        jb2.addActionListener(this);
        
        jp1_3.add(jb1);
        jp1_3.add(jb2);
        
        jp1.add(jp1_1,"North");
        jp1.add(jp1_2,"Center");
        jp1.add(jp1_3,"South");
        
        
        //下
        jp2 = new JPanel(new BorderLayout());
        jp2_1 = new JPanel();
        jl2 = new JLabel("Pet List");
        jl2.setFont(MyTools.f2);    
        jp2_1.add(jl2);
        
        jp2_2 = new JPanel(new BorderLayout());
        jt2 = new JTable();
        jt2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Species", "Age"
            }));
        jsp2 = new JScrollPane(jt2);
        jp2_2.add(jsp2);
        
        jp2_3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jb3 = new JButton("Back");
        jb3.setFont(MyTools.f1);    
        jb3.addActionListener(this);
        
        jb4 = new JButton("Refresh");
        jb4.setFont(MyTools.f1);    
        jb4.addActionListener(this);
        
        jb5 = new JButton("Send Application");
        jb5.setFont(MyTools.f1);    
        jb5.addActionListener(this);
        
        jb6 = new JButton("View Pet Examination");
        jb6.setFont(MyTools.f1);    
        jb6.addActionListener(this);
        
        jb7 = new JButton("View Pet Vaccine");
        jb7.setFont(MyTools.f1);    
        jb7.addActionListener(this);
        
        jp2_3.add(jb3);
        jp2_3.add(jb4);
        jp2_3.add(jb5);
        jp2_3.add(jb6);
        jp2_3.add(jb7);
        
        jp2.add(jp2_1,"North");
        jp2.add(jp2_2,"Center");
        jp2.add(jp2_3,"South");
        
        
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp2,"South");
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            //上Refresh
            populateOrgTable();
        }else if(e.getSource() == jb2){
            //上Choose
                int row = jt1.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null,"Selev a row");
                return;
            }else {
                String Name = (String)jt1.getValueAt(row, 1);
                org =business.getEnterpriseDirectory().findEnterprise(Name);
                populatePetTable(org);
            }
        }else if(e.getSource() == jb3){
            //下Back
                userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            CustomerWorkAreaJPanel dwjp = (CustomerWorkAreaJPanel) component;
            dwjp.populateApplicationTable();
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }else if(e.getSource() == jb4){
            //下Refresh
            
        }else if(e.getSource() == jb5){
            //下Send Application
                int row = jt2.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null,"Selev a row");
                return;
            }else{
                String ID = jt2.getValueAt(row, 1).toString();
                Pet pet =(Pet)org.getPetDirectory().findPetbyName(ID);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new FillAdoptionJPanel(userProcessContainer, account, business,pet,org));
                layout.next(userProcessContainer);
            }
        }else if(e.getSource() == jb6){
            //下View Pet Examination
                int row = jt2.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null,"Selev a row");
                return;
            }else {
                String name = jt2.getValueAt(row,1).toString();
                Pet pet = org.getPetDirectory().findPetbyName(name);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new ViewPetExaJPanel(userProcessContainer,pet));
                layout.next(userProcessContainer);
            }
        }else if(e.getSource() == jb7){
            //下View Pet Vaccine
                int row = jt2.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null,"Selev a row");
                return;
            }else {
                String name = jt2.getValueAt(row,1).toString();
                Pet pet = org.getPetDirectory().findPetbyName(name);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new ViewPetVacJPanel(userProcessContainer,pet));
                layout.next(userProcessContainer);
            }
        }
        
    }
}
