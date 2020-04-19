/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrganizationRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdoptionRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wang
 */
public class AdoptionProcess extends JPanel implements ActionListener{
    UserAccount account; 
    EcoSystem business;
    Enterprise userEnterprise;
    JTable jtable;
    JScrollPane jsp;
    JPanel p1, p2, p3, p4, p5,userProcessContainer;
    JLabel p1_lab1;
    JTextField p1_jtf1;
    JButton p1_jb1,p3_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4;
    
    
    public AdoptionProcess(JPanel userProcessContainer,Enterprise userEnterprise){
        
        this.userProcessContainer=userProcessContainer;
        this.userEnterprise=userEnterprise;
        this.account=account;
        this.business=business;
        this.hosptialView();
            try {
            populateRequestTable();
           
            } catch (Exception e) {
            }
    }
    
    public void populateRequestTable(){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);  
            ArrayList<AdoptionRequest> worklist = userEnterprise.getWorkQueue().getAdoptionkRequestList();          
            if (worklist != null){               
                for(WorkRequest apl : worklist){
                    Object[] row = new Object[8];
                    row[0]= apl.getID();
                    row[1]= apl.getTitle();
                    row[2]= apl.getSender();
                    row[3]=apl.getReceiver();
                    row[4]=apl.getRequestDate();
                    row[5]=apl.getResolveDate();
                    row[6]=apl.getStatus();
                    row[7]=apl.getResult();
                    dtm.addRow(row);
                }
            }    
    } 
    
    
    public void hosptialView(){
        //上
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab1 = new JLabel("Adoption Application List 请输入姓名（员工号或职位）");
		p1_jtf1 = new JTextField(20);
		p1_jb1 = new JButton("查询");
		p1_jb1.addActionListener(this);
		p1.add(p1_lab1);
		p1.add(p1_jtf1);
		p1.add(p1_jb1);
		
		//中
		p2 = new JPanel(new BorderLayout());
                jtable = new JTable();
                jtable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null}
                        },
                        new String [] {
                            "ID", "Ttile", "Sender", "Reciever", "SendDate", "ResolveDate", "Status", "Result"
                        }));
		jsp = new JScrollPane(jtable);
		p2.add(jsp);
		
		
		//下
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
                p3_jb1 = new JButton("返回");
                p3_jb1.addActionListener(this);
		p3.add(p3_jb1);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("预留");
		p4_jb1.addActionListener(this);
		
		p4_jb2 = new JButton("预留");
		p4_jb2.addActionListener(this);
		
		p4_jb3 = new JButton("预留");
		p4_jb3.addActionListener(this);
		
		p4_jb4 = new JButton("enter");
		p4_jb4.addActionListener(this);
		
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
		
		p5 = new JPanel(new BorderLayout());
		p5.add(p3,"West");
		
		p5.add(p4,"East");
		
		//设置整个布局为border
		this.setLayout(new BorderLayout());
		this.add(p1,"North");
		this.add(p2,"Center");
		this.add(p5,"South");
		this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == p1_jb1){
            
        }else if(e.getSource() == p3_jb1){
                userProcessContainer.remove(this);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }else if(e.getSource() == p4_jb1){
            
        }else if(e.getSource() == p4_jb2){
            
        }else if(e.getSource() == p4_jb3){
            
        }else if(e.getSource() == p4_jb4){
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());    
                AdoptionRequest adoptionRequest =(AdoptionRequest) userEnterprise.getWorkQueue().findRequestbyID(requestID);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new ReviewApplicationJPanel(userProcessContainer, adoptionRequest));
                layout.next(userProcessContainer);    
            }
        }
    }
}
