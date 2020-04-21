/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrganizationRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ApplicationOfVolunteer;
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
import tools.MyTools;

/**
 *
 * @author wang
 */
public class ProcessVolunteerJPanel11 extends JPanel implements ActionListener{
    JTable jtable;
    JScrollPane jsp;
    JPanel p1, p2, p3, p4, p5,userProcessContainer;
    JLabel p1_lab1;
    JTextField p1_jtf1;
    JButton p1_jb1,p3_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4, p4_jb5;
     UserAccount account;
     EcoSystem business;
     Enterprise userEnterprise;
    
    public ProcessVolunteerJPanel11(JPanel userProcessContainer,UserAccount account,EcoSystem business){
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
                    if (apl.getRequestType().equals("ApplicationOfVolunteer")) {
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
    } 
    
    public void initView(){
        //上
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab1 = new JLabel("My Application");
                p1_lab1.setFont(MyTools.f2);
		p1.add(p1_lab1);
		
		
		
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
                        "ID", "Title", "Sender", "Reciever", "SendDate", "ResolveDate", "Status", "Result"
                    }));
		jsp = new JScrollPane(jtable);
		p2.add(jsp);
		
		
		//下
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
                p3_jb1 = new JButton("Back");
                p3_jb1.setFont(MyTools.f1);
                p3_jb1.addActionListener(this);
		p3.add(p3_jb1);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("Refresh");
                p4_jb1.setFont(MyTools.f1);
		p4_jb1.addActionListener(this);
		
		p4_jb2 = new JButton("View");
                p4_jb2.setFont(MyTools.f1);
		p4_jb2.addActionListener(this);
		
		p4_jb3 = new JButton("Delete");
                p4_jb3.setFont(MyTools.f1);
		p4_jb3.addActionListener(this);
		
		p4_jb4 = new JButton("Cancel");
                p4_jb4.setFont(MyTools.f1);
		p4_jb4.addActionListener(this);
                
                p4_jb5 = new JButton("Agree");
                p4_jb5.setFont(MyTools.f1);
		p4_jb5.addActionListener(this);
		
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
                p4.add(p4_jb5);
		
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
        if(e.getSource() == p3_jb1){
            //返回
                userProcessContainer.remove(this);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }else if(e.getSource() == p4_jb1){
            //刷新
            populateRequestTable();
        }else if(e.getSource() == p4_jb2){
            //view
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                    int id=Integer.valueOf(jtable.getValueAt(row, 0).toString());       
                    ApplicationOfVolunteer request =(ApplicationOfVolunteer) userEnterprise.getWorkQueue().findRequestbyID(id);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    userProcessContainer.add(new ViewVolunteerJPanel(userProcessContainer,account,business,request));
                    layout.next(userProcessContainer);             
            }
        }else if(e.getSource() == p4_jb3){
            //delete
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                WorkRequest request =(WorkRequest) userEnterprise.getWorkQueue().findRequestbyID(requestID);
                account.getWorkQueue().getWorkRequestList().remove(request);
                populateRequestTable();
            }
        }else if(e.getSource() == p4_jb4){
            //cancel
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                WorkRequest request =(WorkRequest) userEnterprise.getWorkQueue().findRequestbyID(requestID);

                request.setStatus("Finished");
                request.setResult("Canceled");
                request.setResolveDate(new Date());
                populateRequestTable();
            }
        }else if(e.getSource() == p4_jb5){
            //agree
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                WorkRequest request =(WorkRequest) userEnterprise.getWorkQueue().findRequestbyID(requestID);
                request.setResult("Approve");
                request.setResolveDate(new Date());
                request.setStatus("Finished");
                populateRequestTable();
            }
        }
    }
}
