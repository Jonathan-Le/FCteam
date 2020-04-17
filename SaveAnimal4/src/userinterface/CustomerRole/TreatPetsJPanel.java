/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdoptionRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wang
 */
public class TreatPetsJPanel extends JPanel implements ActionListener{
    JPanel jp1, jp2, jp3, jp4, jp5, jp6;
    JLabel jl1, jl2, jl3, jl4, jl5;
    JTable jt1;
    JScrollPane jsp;
    JComboBox jcb1, jcb2;
    JCheckBox jc1, jc2;
    JButton jb1, jb2;
    JPanel userProcessContainer;
    UserAccount account;
    EcoSystem business;
    public TreatPetsJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business){
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.business=business; 
        this.initView();
        populateApplicationTable();
        initHosbox();
        initPetbox();
    }
    
    public void initView(){
        jp1 = new JPanel();
        jl1 = new JLabel("Treatment Application");
        jp1.add(jl1);
        
        jp2 = new JPanel(new BorderLayout());
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
            }));
        jsp = new JScrollPane(jt1);
        jp2.add(jsp);
        
        jp3 = new JPanel(new GridLayout(3,1));
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp3.add(jp4);
        jp3.add(jp5);
        jp3.add(jp6);
        
        
        jl2 = new JLabel("Hospital");
        jl3 = new JLabel("My Pets");
        
        
        jcb1 = new JComboBox();
        jcb2 = new JComboBox();
        
        jc1 = new JCheckBox("Treatment");
        jc2 = new JCheckBox("Pet Chechup");
        
        jb1 = new JButton("back");
        jb1.addActionListener(this);
        jb2 = new JButton("send");
        jb2.addActionListener(this);
        
        jp4.add(jl2);
        jp4.add(jcb1);
        jp4.add(jl3);
        jp4.add(jcb2);
        
        jp5.add(jc1);
        jp5.add(jc2);
        
        jp6.add(jb1);
        jp6.add(jb2);
        
        jp3.add(jp4,"North");
        jp3.add(jp5,"Center");
        jp3.add(jp6,"South");
        
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp2,"Center");
        this.add(jp3,"South");
        
        
        this.setVisible(true);
        
    }
    
    
    private void initHosbox() {
       jcb1.removeAllItems();
       List Hos = business.getEnterpriseDirectory().getEnterpriseList();
        for (Object hospital : Hos) {
            jcb1.addItem(hospital.toString());
        }
    }
    private void initPetbox() {
       jcb2.removeAllItems();
       List petlist = account.getPetlist();
        for (Object pet : petlist) {
            jcb2.addItem(pet.toString());
        }
    }
    public void populateApplicationTable(){

            DefaultTableModel dtm = (DefaultTableModel) jt1.getModel();
            dtm.setRowCount(0);                 
            
            ArrayList<AdoptionRequest> worklist = account.getWorkQueue().getAdoptionkRequestList();         
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        }else if(e.getSource() == jb2){
            
        }
    }
}
