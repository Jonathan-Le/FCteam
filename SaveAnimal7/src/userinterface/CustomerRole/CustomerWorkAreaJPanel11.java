/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdoptionRequest;
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
import javax.swing.table.DefaultTableModel;
import tools.MyTools;


/**
 *
 * @author wang
 */
public class CustomerWorkAreaJPanel11 extends JPanel implements ActionListener{
    JPanel jp1, jp2, jp3;
    JLabel jl1;
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
    JTable jtable;
    JScrollPane jsp;
    JPanel userProcessContainer;
     UserAccount account;
     EcoSystem business;
     Enterprise org;
    
    public CustomerWorkAreaJPanel11(JPanel userProcessContainer, UserAccount account, EcoSystem business){
        this.initView();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.business=business;
        
        populateApplicationTable();
    }
    
    public void populateApplicationTable(){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);                 
            
            ArrayList<WorkRequest> worklist = account.getWorkQueue().getWorkRequestList();   
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
    
    
    public void initView(){
        jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl1 = new JLabel("My Application");
        jl1.setFont(MyTools.f2);
        jp1.add(jl1);
        
        jp2 = new JPanel(new BorderLayout());
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
        jp2.add(jsp);
        
        jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jb1 = new JButton("Refresh");
        jb1.setFont(MyTools.f1);
        jb1.addActionListener(this);
        
        jb2 = new JButton("Apply an adoption");
        jb2.setFont(MyTools.f1);
        jb2.addActionListener(this);
        
        jb3 = new JButton("To be a volunteer");
        jb3.setFont(MyTools.f1);
        jb3.addActionListener(this);
        
        jb4 = new JButton("View");
        jb4.setFont(MyTools.f1);
        jb4.addActionListener(this);
        
        jb5 = new JButton("Delete");
        jb5.setFont(MyTools.f1);
        jb5.addActionListener(this);
        
        jb6 = new JButton("Cancel");
        jb6.setFont(MyTools.f1);
        jb6.addActionListener(this);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        jp3.add(jb4);
        jp3.add(jb5);
        jp3.add(jb6);
        
        
          this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp2,"Center");
        this.add(jp3,"South");
      
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            //Refresh
            populateApplicationTable();
        }else if(e.getSource() == jb2){
            //Apply an adoption
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new ApplyPetAdoptionJPanel11(userProcessContainer,account,business));
            layout.next(userProcessContainer);
        }else if(e.getSource() == jb3){
            //To be a volunteer
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new ApplyVolunteerJPanel11(userProcessContainer,account,business));
            layout.next(userProcessContainer);
        }else if(e.getSource() == jb4){
            //View
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int id=Integer.valueOf(jtable.getValueAt(row, 0).toString());
                String type = account.getWorkQueue().findRequestbyID(id).getClass().getSimpleName();
                 if (type.equals("AdoptionRequest")) {
                AdoptionRequest request =(AdoptionRequest) account.getWorkQueue().findRequestbyID(id);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new ViewAdoptionJPanel(userProcessContainer,account,business,request));
                layout.next(userProcessContainer);          
                 }else if (type.equals("ApplicationOfVolunteer")) {
                 ApplicationOfVolunteer request =(ApplicationOfVolunteer) account.getWorkQueue().findRequestbyID(id);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new ViewVolunteerJPanel(userProcessContainer,account,business,request));
                layout.next(userProcessContainer);
                } else
                     System.out.println(type);
            }
        }else if(e.getSource() == jb5){
            //Delete
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                WorkRequest request =(WorkRequest) account.getWorkQueue().findRequestbyID(requestID);
                account.getWorkQueue().getWorkRequestList().remove(request);
                populateApplicationTable();
            }
        }else if(e.getSource() == jb6){
            //Cancel
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                WorkRequest request =(WorkRequest) account.getWorkQueue().findRequestbyID(requestID);

                request.setStatus("Canceled");
                request.setResolveDate(new Date());
                populateApplicationTable();
            }
        }
    }
}
