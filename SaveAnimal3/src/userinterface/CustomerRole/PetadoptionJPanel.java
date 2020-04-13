/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

/**
 *
 * @author wang
 */
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.RescueAnimalOrganization.RescueAnimalOrganization;
import Business.Pet.Pet;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PetadoptionJPanel extends JPanel implements ActionListener{
	JPanel jp1, jp1_1, jp1_2, jp2, jp3, jp3_1, jp3_2, jp3_3, jp4, jp4_1, jp4_2, jp4_3;
	JScrollPane jsp1, jsp2, jsp3;
	JTable jt1, jt2, jt3;
	JLabel jl1, jl2, jl3;
	JButton jb1, jb2,jb3;
	JPanel userProcessContainer;
        UserAccount account;
        EcoSystem business;
        RescueAnimalOrganization org;
	
	
	
	public PetadoptionJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
		this.userProcessContainer=userProcessContainer;
                this.account=account;
                this.business=business;
                this.initView();
                populateOrgTable();
                populateApplicationTable();	
	}

        public void populateOrgTable(){
            DefaultTableModel dtm = (DefaultTableModel) jt2.getModel();
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
        
        
        public void populateApplicationTable(){
            
            DefaultTableModel dtm = (DefaultTableModel) jt1.getModel();
            dtm.setRowCount(0);                 
            
            ArrayList<WorkRequest> worklist = account.getWorkQueue().getAdoptionkRequestList();          
            if (worklist != null){               
                for(WorkRequest apl : worklist){
                    Object[] row = new Object[7];
                    row[0]= apl.getID();
                    row[1]= apl.getSender();
                    row[2]=apl.getReceiver();
                    row[3]=apl.getRequestDate();
                    row[4]=apl.getResolveDate();
                    row[5]=apl.getStatus();
                    row[6]=apl.getResult();
                    dtm.addRow(row);
                }
            }
        }
        
        
        public void populatePetTable(RescueAnimalOrganization org){

            DefaultTableModel dtm = (DefaultTableModel) jt3.getModel();
            dtm.setRowCount(0);           
            ArrayList<Pet> petlist = org.getPetDirectory().getPetlist();           
            if (petlist != null){                 
                for(Pet pet : petlist){
                    Object[] row = new Object[3];
                    row[0] = pet.getID();
                    row[1]=pet.getSpecies();
                    row[2]= pet.getAge();
                    dtm.addRow(row);
                }
            }     
        }
        
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //返回
        if(e.getSource() == jb1){
            userProcessContainer.remove(this);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        //选择
        }else if(e.getSource() == jb2){
            int row = jt2.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null,"Selev a row");
                return;
            }
            String Name = (String)jt2.getValueAt(row, 1);
            org =(RescueAnimalOrganization)business.getEnterpriseDirectory().findEnterprise(Name);
            populatePetTable(org);
        //发送    
        }else if(e.getSource() == jb3){
            int row = jt3.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null,"Selev a row");
                return;
            }
            int ID = Integer.valueOf(jt3.getValueAt(row, 0).toString());       
            Pet pet =(Pet)org.getPetDirectory().findPet(ID);       
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new fillinformationJPanel(userProcessContainer, account, business,pet,org));
            layout.next(userProcessContainer);
        }
    }
     
    
    
    
    public void initView(){
        
        jp1 = new JPanel(new BorderLayout());
	jp1_1 = new JPanel();
	jl1 = new JLabel("My Application");
	jp1_1.add(jl1);
		
	jp1_2 = new JPanel(new BorderLayout());
	jt1 = new JTable();
        jt1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sender", "Reciever", "SendDate", "ResolveDate", "Status", "Result"
            }
        ));
	jsp1 = new JScrollPane(jt1);
	jp1_2.add(jsp1);
	jp1.add(jp1_1,"North");
	jp1.add(jp1_2,"South");
		
		
		
	//下
	jp2 = new JPanel();
	//下左
	jp3 = new JPanel(new BorderLayout());
	jp3_1 = new JPanel();
	jl2 = new JLabel("Rescue Organiztion List");
	jp3_1.add(jl2);
            
		
	jp3_2 = new JPanel(new BorderLayout());
	jt2 = new JTable();
        jt2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
        new String [] {
                "ID", "Name"
            }
        ));
	jsp2 = new JScrollPane(jt2);
	jp3_2.add(jsp2);
                
		
	jp3_3 = new JPanel();
	jb1 = new JButton("返回");
        jb1.addActionListener(this);
	jb2 = new JButton("选择");
        jb2.addActionListener(this);
	jp3_3.add(jb1);
	jp3_3.add(jb2);
		
	jp3.add(jp3_1,"North");
	jp3.add(jp3_2,"Center");
	jp3.add(jp3_3,"South");
		
                
                
	//下右
	jp4 = new JPanel(new BorderLayout());
		
	jp4_1 = new JPanel();
	jl3 = new JLabel("Pet List");
	jp4_1.add(jl3);
		
	jp4_2 = new JPanel(new BorderLayout());
	jt3 = new JTable();
        jt3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
             new String [] {
                 "ID", "Species", "Age"
            }
        ));
	jsp3 = new JScrollPane(jt3);
	jp4_2.add(jsp3);
		
		
	jp4_3 = new JPanel();
	jb3 = new JButton("发送");
        jb3.addActionListener(this);
	jp4_3.add(jb3);
		
	jp4.add(jp4_1,"North");
	jp4.add(jp4_2,"Center");
	jp4.add(jp4_3,"South");
		
		
	jp2.add(jp3,"West");
	jp2.add(jp4,"East");
	this.setLayout(new BorderLayout());
	this.add(jp1,"North");
	this.add(jp2,"South");
	this.setVisible(true);
    }
    
        
        
}