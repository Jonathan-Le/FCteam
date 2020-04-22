/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrganizationRole.Pet;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ExaminationRequest;
import Business.WorkQueue.VaccineRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
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
public class InteractionwithHospitalJPanel11 extends JPanel implements ActionListener{
    JTable jtable;
    JScrollPane jsp;
    JPanel p1, p2, p3, p4, p5,userProcessContainer;
    JLabel p1_lab1;
    JTextField p1_jtf1;
    JButton p1_jb1,p3_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4, p4_jb5, p4_jb6, p4_jb7;
     UserAccount account; 
     EcoSystem business;
     Enterprise userEnterprise;
     
    public InteractionwithHospitalJPanel11(JPanel userProcessContainer,EcoSystem business,UserAccount account){
        this.initView();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.business=business;
        userEnterprise = business.getEnterpriseDirectory().findEnterpriseID(account.getRole().getEnterpriseID());
        populateRequestTable();
    }
    
    public void populateRequestTable(){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);  
            ArrayList<WorkRequest> worklist = userEnterprise.getWorkQueue().getWorkRequestList();          
            if (worklist != null){               
                for(WorkRequest apl : worklist){
                    if ((apl.getRequestType().equals("ExaminationRequest"))||(apl.getRequestType().equals("EuthanasiaRequest"))||(apl.getRequestType().equals("VaccineRequest"))) {
                    Object[] row = new Object[10];
                    row[0]= apl.getID();
                    row[1]= apl.getRequestType();
                    row[2]= apl.getTitle();
                    row[3]= apl.getRequestType();
                    row[4]= apl.getSender();
                    row[5]=apl.getReceiver();
                    row[6]=apl.getRequestDate();
                    row[7]=apl.getResolveDate();
                    row[8]=apl.getStatus();
                    row[9]=apl.getResult();
                    dtm.addRow(row);
                    }
                   
                }
            }    
    } 
    public void populateSearchTable(WorkRequest apl){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);      
                    Object[] row = new Object[10];
                    row[0]= apl.getID();
                    row[1]= apl.getRequestType();
                    row[2]= apl.getTitle();
                    row[3]= apl.getRequestType();
                    row[4]= apl.getSender();
                    row[5]=apl.getReceiver();
                    row[6]=apl.getRequestDate();
                    row[7]=apl.getResolveDate();
                    row[8]=apl.getStatus();
                    row[9]=apl.getResult();
                    dtm.addRow(row);
    } 
    
    
    public void initView(){
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
                            {null, null, null, null, null, null, null,null, null},
                            {null, null, null, null, null, null, null,null, null},
                            {null, null, null, null, null, null, null,null, null},
                            {null, null, null, null, null, null, null,null, null}
                        },
                        new String [] {
                            "ID","Type", "Ttile", "Sender", "Reciever", "SendDate", "ResolveDate", "Status", "Result"
                        }));
		jsp = new JScrollPane(jtable);
		p2.add(jsp);
		
		
		//下
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
                p3_jb1 = new JButton("Back");
                p3_jb1.addActionListener(this);
		p3.add(p3_jb1);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("Refresh");
		p4_jb1.addActionListener(this);
		
		p4_jb2 = new JButton("Examination Application");
		p4_jb2.addActionListener(this);
		
		p4_jb3 = new JButton("Euthanasia Application");
		p4_jb3.addActionListener(this);
		
		p4_jb4 = new JButton("Vaccine Application");
		p4_jb4.addActionListener(this);
                
                p4_jb5 = new JButton("View Application");
		p4_jb5.addActionListener(this);
		
		p4_jb6 = new JButton("Delete Application");
		p4_jb6.addActionListener(this);
		
		p4_jb7 = new JButton("Cancel Application");
		p4_jb7.addActionListener(this);
		
		
		
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
                p4.add(p4_jb5);
                p4.add(p4_jb6);
                p4.add(p4_jb7);
                
		
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
            // 查询
                
        }else if(e.getSource() == p3_jb1){
            //返回
            userProcessContainer.remove(this);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }else if(e.getSource() == p4_jb1){
            //刷新
            populateRequestTable();
        }else if(e.getSource() == p4_jb2){
            //Examination Application
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new ApplyExaminationJPanel(userProcessContainer,business,account,userEnterprise));
            layout.next(userProcessContainer);
        }else if(e.getSource() == p4_jb3){
            //Euthanasia Application
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new ApplyEuthanasiaJPanel(userProcessContainer,business,account,userEnterprise));
            layout.next(userProcessContainer);  
        }else if(e.getSource() == p4_jb4){
            //Vaccine Application
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    userProcessContainer.add(new ApplyVaccineJPanel(userProcessContainer,business,account,userEnterprise));
                    layout.next(userProcessContainer);
                }else if(e.getSource() == p4_jb5){
                    //View Application
                    int row = jtable.getSelectedRow();
                if (row<0) {
                    JOptionPane.showMessageDialog(null, "Please select a row");
                }else{
                    int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                    WorkRequest request =(WorkRequest) userEnterprise.getWorkQueue().findRequestbyID(requestID);  

                      if (request.getRequestType().equals("ExaminationRequest")) {
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                        userProcessContainer.add(new ViewExamResultPanel(userProcessContainer,account,business, (ExaminationRequest)request));
                        layout.next(userProcessContainer);
                    } if (request.getRequestType().equals("VaccineRequest")) {
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                        userProcessContainer.add(new ViewVaccineJPanel(userProcessContainer,account,business,(VaccineRequest) request));
                        layout.next(userProcessContainer);
                    }

                }
        }else if(e.getSource() == p4_jb6){
            //Delete Application
                    int row = jtable.getSelectedRow();
                if (row<0) {
                    JOptionPane.showMessageDialog(null, "Please select a row");
                }else{
                    int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                    WorkRequest request = userEnterprise.getWorkQueue().findRequestbyID(requestID);
                    userEnterprise.getWorkQueue().getWorkRequestList().remove(request);
                    populateRequestTable();
                }
            }else if(e.getSource() == p4_jb7){
                //Cancel Application
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                String requestEnterprise= (jtable.getValueAt(row,3).toString());
                WorkRequest request =(WorkRequest) userEnterprise.getWorkQueue().findRequestbyID(requestID);
                //            ExaminationRequest request1 = (ExaminationRequest)business.getEnterpriseDirectory().findEnterprise(requestEnterprise).getWorkQueue().findRequestbyID(requestID);
                //            request1.setStatus("Canceled");
                request.setStatus("Canceled");
                request.setResolveDate(new Date());
                populateRequestTable();
            }
        }
    }
}
