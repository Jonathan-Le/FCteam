/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrganizationRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Pet.Pet;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EuthanasiaRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class ApplyEuthanasiaJPanel11 extends JPanel implements ActionListener{
    JPanel jp1, jp2, jp3, jp4, jp5,jp6,jp6_1, jp6_2, jp6_3, jp6_4, jp7,  userProcessContainer;
    JLabel jl1, jl2, jl3, jl4, jl5,jl6;
    JTable jtable;
    JScrollPane jsp;
    JTextField jtf1, jtf2,jtf3;
    JComboBox jcb1, jcb2;
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
     UserAccount account; 
     EcoSystem business;
     Enterprise userEnterprise;
    
    
    public ApplyEuthanasiaJPanel11(JPanel userProcessContainer,EcoSystem business,UserAccount account,Enterprise userEnterprise){
        this.initView();
        this.userProcessContainer=userProcessContainer;
        this.userEnterprise=userEnterprise;
        this.account=account;
        this.business=business; 
        initPetBox();
        initcompanyBox();
        populateRequestTable();  
        
    }
    
    
    public void populateRequestTable(){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);  
            ArrayList<EuthanasiaRequest> worklist = userEnterprise.getWorkQueue().getEutRequestList();          
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
public void populateSearchTable(WorkRequest apl){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);      
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
    public void initPetBox(){
            jcb1.removeAllItems();
            List<Pet> petlist = userEnterprise.getPetDirectory().getPetlist();
            for (Pet object : petlist) {
                jcb1.addItem(object.getName());
        }
    }
      public void initcompanyBox(){
            jcb2.removeAllItems();
            List<Enterprise> petlist = business.getEnterpriseDirectory().getEnterpriseList();
            for (Enterprise object : petlist) {
                if (!object.getEnterpriseType().equals(Enterprise.EnterpriseType.RescuOrganization)) {
                    jcb2.addItem(object.getEnterpriseName());
                }
                
        }
    }
    
    public void initView(){
        //Font f = new Font("",Font.PLAIN,20);
        //Font f1 = new Font("",Font.PLAIN,25);
        //上
        jp1 = new JPanel(new BorderLayout());
        jp2 = new JPanel();
        jl1 = new JLabel("Application to Hospital");
        jl1.setFont(MyTools.f2);
        jp2.add(jl1);
        jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl2 = new JLabel("请输入title");
        jl2.setFont(MyTools.f1);
        jtf1 = new JTextField(10);
        jb1 = new JButton("search");
        jb1.addActionListener(this);
        jb1.setFont(MyTools.f1);
        jp3.add(jl2);
        jp3.add(jtf1);
        jp3.add(jb1);
        
        jp4 = new JPanel(new BorderLayout());
        jtable = new JTable();
                jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Title", "Sender", "Reciever", "SendDate", "ExecuteDate", "Status", "Result"
            }));
        jsp = new JScrollPane(jtable);
        jp4.add(jsp);
        
        jp1.add(jp2,"North");
        jp1.add(jp3,"Center");
        jp1.add(jp4,"South");
        
        //下
        jp5 = new JPanel(new BorderLayout());
        jp6 = new JPanel(new GridLayout(4,1));
        jp6_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl3 = new JLabel("Title");
        jl3.setFont(MyTools.f1);
        jtf2 = new JTextField(20);
        jp6_1.add(jl3);
        jp6_1.add(jtf2);
        
        jp6_2 = new JPanel();
        jl4 = new JLabel("pet");
        jl4.setFont(MyTools.f1);
        jcb1 = new JComboBox();
        jp6_2.add(jl4);
        jp6_2.add(jcb1);
        
        jp6_3 = new JPanel();
        jl5 = new JLabel("Enterprise");
        jl5.setFont(MyTools.f1);
        jcb2 = new JComboBox();
        jp6_3.add(jl5);
        jp6_3.add(jcb2);
        
        jp6_4 = new JPanel();       
        jl6 = new JLabel("Reason");   
        jl6.setFont(MyTools.f1);
        jtf3 = new JTextField(20);
        jp6_4.add(jl6);
        jp6_4.add(jtf3);
        
        
        jp6.add(jp6_1);
        jp6.add(jp6_2);
        
        jp6.add(jp6_3);
        jp6.add(jp6_4);

        
        
        jp7 = new JPanel();
        jb2 = new JButton("back");
        jb2.addActionListener(this);
        jb2.setFont(MyTools.f1);
        
        jb3 = new JButton("refresh");
        jb3.addActionListener(this);
        jb3.setFont(MyTools.f1);
        
        jb4 = new JButton("Delete Application");
        jb4.addActionListener(this);
        jb4.setFont(MyTools.f1);
        
        jb5 = new JButton("Cancel Application");
        jb5.addActionListener(this);
        jb5.setFont(MyTools.f1);
        
        jb6 = new JButton("Send new Application");
        jb6.addActionListener(this);
        jb6.setFont(MyTools.f1);
        
        jp7.add(jb2);
        jp7.add(jb3);
        jp7.add(jb4);
        jp7.add(jb5);
        jp7.add(jb6);
        
        jp5.add(jp6,"North");
        jp5.add(jp7,"South");
        
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp5);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            //搜索
            String search = jtf1.getText();
        WorkRequest findAccount = userEnterprise.getWorkQueue().findRequestbyname(search);
        //这里应该返回一个找到用户名字的List  //现在是返回一个网络个体
        populateSearchTable(findAccount);
        }else if(e.getSource() == jb2){
            //返回
                userProcessContainer.remove(this);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }else if(e.getSource() == jb2){
            //刷新
            populateRequestTable();
        }else if(e.getSource() == jb2){
            //delete Application
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                EuthanasiaRequest request =(EuthanasiaRequest) userEnterprise.getWorkQueue().findRequestbyID(requestID);
                userEnterprise.getWorkQueue().getExaminationRequestList().remove(request);
                populateRequestTable();
            }
        }else if(e.getSource() == jb2){
            //Cancel Application
                    int row = jtable.getSelectedRow();
                if (row<0) {
                    JOptionPane.showMessageDialog(null, "Please select a row");
                }else{
                    int requestID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                    String requestEnterprise= (jtable.getValueAt(row,3).toString());
                    EuthanasiaRequest request =(EuthanasiaRequest) userEnterprise.getWorkQueue().findRequestbyID(requestID);
                    //            ExaminationRequest request1 = (ExaminationRequest)business.getEnterpriseDirectory().findEnterprise(requestEnterprise).getWorkQueue().findRequestbyID(requestID);
                    //            request1.setStatus("Canceled");
                    request.setStatus("Canceled");
                    request.setResolveDate(new Date());
                    populateRequestTable();
                }
        }else if(e.getSource() == jb2){
            //Send new Application
                if (!jtf3.getText().isEmpty()) {
            Enterprise euEnterprise = business.getEnterpriseDirectory().findEnterprise(jcb2.getSelectedItem().toString());
            String reason = jtf3.getText();
            Pet pet = userEnterprise.getPetDirectory().findPet(jcb1.getSelectedItem().toString());
            String title = jtf2.getText();

            EuthanasiaRequest euthunisiaRequest= new EuthanasiaRequest(title,reason, pet);
            euthunisiaRequest.setReceiver(euEnterprise.getEnterpriseName());
            euthunisiaRequest.setSender(userEnterprise.getEnterpriseName());
            euthunisiaRequest.setStatus("pending");


            euEnterprise.getWorkQueue().getEutRequestList().add(euthunisiaRequest);
            userEnterprise.getWorkQueue().getEutRequestList().add(euthunisiaRequest);
             JOptionPane.showMessageDialog(null, "Send successfully");
             populateRequestTable();
            }else
                JOptionPane.showMessageDialog(null, "Please add a Reason");
        }
    }
}
