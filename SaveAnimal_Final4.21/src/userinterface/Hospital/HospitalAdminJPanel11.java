/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Hospital;

import Business.Department.Department;
import Business.Department.DepartmentDirectory;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tools.MyTools;
import userinterface.Organization.CreateOrgEmpJPanel;
import userinterface.Organization.ViewOrgEmpJPanel;

/**
 *
 * @author wang
 */
public class HospitalAdminJPanel11 extends JPanel implements ActionListener{
    JPanel jp1, jp2, jp2_1, jp2_2, jp2_3, jp3, jp3_1, jp3_2, jp3_3;
    JLabel jl1, jl2,jl3, jl4, jl5,jl6;
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
    JTable jt1, jt2;
    JScrollPane jsp1, jsp2;
    JTextField jtf1, jtf2;
    JPanel userProcessContainer;
     UserAccount account;
     EcoSystem business;
     Enterprise userEnterprise;
     Department cDepartment;
    
    
    public HospitalAdminJPanel11(JPanel userProcessContainer, UserAccount account, EcoSystem business){
        this.initView();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.business=business;
        userEnterprise = business.getEnterpriseDirectory().findEnterpriseID(account.getRole().getEnterpriseID());
        populateRequestTable();
    }
    
    
    public void populateRequestTable(){

            DefaultTableModel dtm = (DefaultTableModel) jt1.getModel();
            dtm.setRowCount(0);      
            DepartmentDirectory worklist= userEnterprise.getDepartmentDirectory();
          
            if (worklist != null){  
                for(Department request : worklist.getDepartmentDirectory()){
                    Object[] row = new Object[2];
                    row[0]=request.getDepartmentID();
                    row[1]=request.getName();
                    dtm.addRow(row);
                }
            }     
    }
 public void populateEmployeeTable(Department department){

            DefaultTableModel dtm = (DefaultTableModel) jt2.getModel();
            dtm.setRowCount(0);      
            EmployeeDirectory worklist= department.getEmployeeDirectory();       
            if (worklist != null){  
                for(Employee request : worklist.getEmployeeList()){
                    Object[] row = new Object[3];
                    row[0]=request.getId();
                    row[1]=request.getName();    
                    row[2]=request.getRegisterTime();
                    dtm.addRow(row);
                }
            }     
    }
    public void populateResearchTable(Employee request){

            DefaultTableModel dtm = (DefaultTableModel) jt2.getModel();
            dtm.setRowCount(0);          
                    Object[] row = new Object[3];
                    row[0]=request.getId();
                    row[1]=request.getName();
                    row[2]=request.getRegisterTime();
                    dtm.addRow(row);                    
    }
    
    
    public void initView(){
        jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl1 = new JLabel("My Work Area -Adminstrative Role");
        jl1.setFont(MyTools.f2);
        jp1.add(jl1);
        
        //中
        jp2 = new JPanel(new BorderLayout());
        jp2_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jl2 = new JLabel("Department List：");
        jp2_1.add(jl2);
        
        jp2_2 = new JPanel(new BorderLayout());
        jt1 = new JTable();
        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Type"
            }));
        jsp1 = new JScrollPane(jt1);
        jp2_2.add(jsp1);
        
        jp2_3 = new JPanel();
        jl3 = new JLabel("Name");
        jtf1 = new JTextField(10);
        
        jb1 = new JButton("Refresh");
        jb1.setFont(MyTools.f1);
        jb1.addActionListener(this);
        
        jb2 = new JButton("Add Department");
        jb2.setFont(MyTools.f1);
        jb2.addActionListener(this);
        
        jb3 = new JButton("Delete Department");
        jb3.setFont(MyTools.f1);
        jb3.addActionListener(this);
        
        jb4 = new JButton("View EmplopyeeList");
        jb4.setFont(MyTools.f1);
        jb4.addActionListener(this);
        
        jp2_3.add(jb1);
        jp2_3.add(jl3);
        jp2_3.add(jtf1);
        jp2_3.add(jb2);
        jp2_3.add(jb3);
        jp2_3.add(jb4);
        
        jp2.add(jp2_1,"North");
        jp2.add(jp2_2,"Center");
        jp2.add(jp2_3,"South");
        
        //下
        jp3 = new JPanel(new BorderLayout());
        jp3_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jl4 = new JLabel("Employee List：");
        jp3_1.add(jl4);
        
        jp3_2 = new JPanel(new BorderLayout());
        jt2 = new JTable();
        jt2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "RegisterTime"
            }));
        jsp2 = new JScrollPane(jt2);
        jp3_2.add(jsp2);
        
        jp3_3 = new JPanel();
        jb5 = new JButton("Refresh");
        jb5.setFont(MyTools.f1);
        jb5.addActionListener(this);
        
        jl5 = new JLabel("name");
        jtf2 = new JTextField(10);
        
        jb6 = new JButton("Add Employee");
        jb6.setFont(MyTools.f1);
        jb6.addActionListener(this);
        
        jb7 = new JButton("Delete Employee");
        jb7.setFont(MyTools.f1);
        jb7.addActionListener(this);
        
        jb8 = new JButton("View Employee");
        jb8.setFont(MyTools.f1);
        jb8.addActionListener(this);
        
        jp3_3.add(jb5);
        jp3_3.add(jl5);
        jp3_3.add(jtf2);
        jp3_3.add(jb6);
        jp3_3.add(jb7);
        jp3_3.add(jb8);
        
        jp3.add(jp3_1,"North");
        jp3.add(jp3_2,"Center");
        jp3.add(jp3_3,"South");
        
        
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp2,"Center");
        this.add(jp3,"South");
        this.setVisible(true);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            //上刷新
            populateRequestTable(); 
        }else if(e.getSource() == jb2){
            //上Add Department
                    String name = jtf1.getText();
            userEnterprise.getDepartmentDirectory().createOrganization(name);
            populateRequestTable();
        }else if(e.getSource() == jb3){
            //上Delete Department
                    int row = jt1.getSelectedRow();
             if (row<0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            }else{
                String id=(jt1.getValueAt(row, 1).toString());
                Department request =(Department) userEnterprise.getDepartmentDirectory().findDepartment(id);         
                userEnterprise.getDepartmentDirectory().getDepartmentDirectory().remove(request);
                populateRequestTable();
            }
        }else if(e.getSource() == jb4){
            //上View EmplopyeeList
                int row = jt1.getSelectedRow();
            if (row<0) {
               JOptionPane.showMessageDialog(null, "Please select a row");
           }else{
               String id=(jt1.getValueAt(row, 1).toString());
                cDepartment =(Department) userEnterprise.getDepartmentDirectory().findDepartment(id);         
               populateEmployeeTable(cDepartment);
           }   
        }else if(e.getSource() == jb5){
            //下Refresh
            populateEmployeeTable(cDepartment);
        }else if(e.getSource() == jb6){
            //下Add Employee
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new CreateHosEmpJPanel( userProcessContainer ,business ,userEnterprise ,cDepartment));
            layout.next(userProcessContainer);
        }else if(e.getSource() == jb7){
            //下Delete Employee
                int row = jt2.getSelectedRow();
            if (row<0) {
               JOptionPane.showMessageDialog(null, "Please select a row");
           }else{
               String id=(jt2.getValueAt(row, 1).toString());
               Employee request =(Employee) cDepartment.getEmployeeDirectory().findEmployee(id);         
                cDepartment.getEmployeeDirectory().getEmployeeList().remove(request);
                populateEmployeeTable(cDepartment);
           }
        }else if(e.getSource() == jb8){
            //下View Employee
                int row = jt2.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(null,"Please select a row!", "get Request",JOptionPane.ERROR_MESSAGE);
            }else{
                String name = jt2.getValueAt(row,1).toString();
                Employee employee = cDepartment.getEmployeeDirectory().findEmployee(name);       
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new ViewHosEmpJPanel(userProcessContainer, business, employee));
                layout.next(userProcessContainer);

            }
        }
    }
}

