/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrganizationRole.PetManage;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Pet.Pet;
import Business.UserAccount.UserAccount;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class ManagePetJPanel11 extends JPanel implements ActionListener{
    JPanel jp1, jp2, jp3, jp4, jp5,jp6,jp6_1, jp6_2, jp6_3, jp6_4, jp7, userProcessContainer;
    JLabel jl1, jl2, jl3, jl4, jl5,jl6;
    JTable jtable;
    JScrollPane jsp;
    JTextField jtf1, jtf2,jtf3,jtf5;
    JComboBox jcb1, jcb2;
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
    UserAccount account;
     EcoSystem business;
     Enterprise userEnterprise;
    
    public ManagePetJPanel11(JPanel userProcessContainer,UserAccount account,EcoSystem business){
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
            ArrayList<Pet> worklist = userEnterprise.getPetDirectory().getPetlist();          
            if (worklist != null){               
                for(Pet apl : worklist){
                    Object[] row = new Object[4];
                    row[0]= apl.getID();
                    row[1]= apl.getName();
                    row[2]= apl.getSpecies();
                    row[3]=apl.getAge();       
                    dtm.addRow(row);
                   
                }
            }    
    } 
    
    public void initView(){
        //上
        jp1 = new JPanel(new BorderLayout());
        jp2 = new JPanel();
        jl1 = new JLabel("Pet List");
        jl1.setFont(MyTools.f2);
        jp2.add(jl1);
//        jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        jl2 = new JLabel("请输入title");
//        jl2.setFont(MyTools.f1);
//        jtf1 = new JTextField(10);
//        jb1 = new JButton("search");
//        jb1.addActionListener(this);
//        jb1.setFont(MyTools.f1);
//        jp3.add(jl2);
//        jp3.add(jtf1);
//        jp3.add(jb1);
        
        jp4 = new JPanel(new BorderLayout());
        jtable = new JTable();
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "ID", "Name", "Species", "Age"
        }));
        jsp = new JScrollPane(jtable);
        jp4.add(jsp);
        
        jp1.add(jp2,"North");
        //jp1.add(jp3,"Center");
        jp1.add(jp4,"South");
        
        //下
        jp5 = new JPanel(new BorderLayout());
        jp6 = new JPanel(new GridLayout(4,1));
        jp6_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl3 = new JLabel("Name");
        jl3.setFont(MyTools.f1);
        jtf2 = new JTextField(20);
        jp6_1.add(jl3);
        jp6_1.add(jtf2);
        
//        jp6_2 = new JPanel();
//        jl4 = new JLabel("Hospital");
//        jl4.setFont(MyTools.f1);
//        jcb1 = new JComboBox();
//        jp6_2.add(jl4);
//        jp6_2.add(jcb1);
        
//        jp6_3 = new JPanel();
//        jl5 = new JLabel("My Pets");
//        jl5.setFont(MyTools.f1);
//        jcb2 = new JComboBox();
//        jp6_3.add(jl5);
//        jp6_3.add(jcb2);


          jp6_2 = new JPanel();
          jl4 = new JLabel("Species");
          jl4.setFont(MyTools.f1);
          jtf5 = new JTextField(20);
        jp6_2.add(jl4);
        jp6_2.add(jtf5);

        
        jp6_4 = new JPanel();       
        jl6 = new JLabel("Age");   
        jl6.setFont(MyTools.f1);
        jtf3 = new JTextField(20);
        jp6_4.add(jl6);
        jp6_4.add(jtf3);
        
        
        jp6.add(jp6_1);
        jp6.add(jp6_2);
        
        //jp6.add(jp6_3);
        jp6.add(jp6_4);

        
        
        jp7 = new JPanel();
        jb2 = new JButton("back");
        jb2.addActionListener(this);
        jb2.setFont(MyTools.f1);
        
        jb3 = new JButton("refresh");
        jb3.addActionListener(this);
        jb3.setFont(MyTools.f1);
        
        jb4 = new JButton("Add");
        jb4.addActionListener(this);
        jb4.setFont(MyTools.f1);
        
        jb5 = new JButton("Delete");
        jb5.addActionListener(this);
        jb5.setFont(MyTools.f1);
        
        
        
        jp7.add(jb2);
        jp7.add(jb3);
        jp7.add(jb4);
        jp7.add(jb5);
        
        
        jp5.add(jp6,"North");
        jp5.add(jp7,"South");
        
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp5);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb2){
            //back
                userProcessContainer.remove(this);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }else if(e.getSource() == jb3){
            //refresh
            populateRequestTable();
        }else if(e.getSource() == jb4){
            //add
                String name = jtf2.getText();
            String species = jtf5.getText();
            String age = jtf3.getText();
            Pet pet = new Pet(name, species,age);

            userEnterprise.getPetDirectory().getPetlist().add(pet);
            JOptionPane.showMessageDialog(null, "Success");
            populateRequestTable();
        }else if(e.getSource() == jb5){
            //delete
                int row = jtable.getSelectedRow();
            if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                int ID= Integer.valueOf(jtable.getValueAt(row,0).toString());
                Pet pet =(Pet) userEnterprise.getPetDirectory().findPetbyID(ID);
                userEnterprise.getPetDirectory().getPetlist().remove(pet);
                populateRequestTable();
            }
        }
    }
}
