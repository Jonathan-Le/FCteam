/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SysAdmin;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wang
 */
public class ManageUserJPanel extends JPanel implements ActionListener{
    JTable jtable;
    JScrollPane jsp;
    JPanel p1, p2, p3, p4, p5,userProcessContainer;;
    JLabel p1_lab1;
    JTextField p1_jtf1;
    JButton p1_jb1,p3_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4;

    
    EcoSystem system;
    UserAccount account;
        
    public ManageUserJPanel(JPanel userProcessContainer, EcoSystem system){
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.hosptialView();
        populateRequestTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //查询按钮
        if(e.getSource() == p1_jb1){
             String search = p1_jtf1.getText();
        UserAccount findAccount = system.getUserAccountDirectory().findUser(search);
        //这里应该返回一个找到用户名字的List
        populateSearchTable(findAccount);
        
        //返回按钮
        }else if(e.getSource() == p3_jb1){
            userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        //详细信息按钮
        }else if(e.getSource() == p4_jb1){
            populateRequestTable();
        //添加按钮
        }else if(e.getSource() == p4_jb2){
            System.out.println("asdf");
            
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(new CreateAccountJPane(userProcessContainer, system));
            layout.next(userProcessContainer);
        //修改按钮
        }else if(e.getSource() == p4_jb3){
                int row = jtable.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(null,"Please select a row!", "get Request",JOptionPane.ERROR_MESSAGE);
            }else{
                String name = jtable.getValueAt(row,1).toString();
                UserAccount account = system.getUserAccountDirectory().findUser(name);    

                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new ViewAccountJPanel(userProcessContainer, system, account));
                layout.next(userProcessContainer);
            }
            populateRequestTable();
        //删除按钮
        }else if(e.getSource() == p4_jb4){
            int row = jtable.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(null,"Please select a row!", "get Request",JOptionPane.ERROR_MESSAGE);
            } else{
                //需要加入双重确认，并且改成以ID为搜索指引
                String name = jtable.getValueAt(row,1).toString();
                UserAccountDirectory worklist= system.getUserAccountDirectory();
                UserAccount man = worklist.findUser(name);
                worklist.getUserAccountList().remove(man);
                populateRequestTable();
        }}
    }
    
    public void populateRequestTable(){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);      
            UserAccountDirectory worklist= system.getUserAccountDirectory();
            
            if (worklist != null){  
                for(UserAccount request : worklist.getUserAccountList()){
                    Object[] row = new Object[4];
                    row[0]=request.getId();
                    row[1]=request.getUsername();  
                    row[2]=request.getRole();
                    row[3]=request.getEmployee();
                    dtm.addRow(row);
                }
            }
          
    }
    public void populateSearchTable(UserAccount account){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);   
             Object[] row = new Object[4];
                    row[0]=account.getId();
                    row[1]=account.getUsername();  
                    row[2]=account.getRole();
                    row[3]=account.getEmployee();
                    dtm.addRow(row);                               
    }
    
    
    
    
    
    public void hosptialView(){
        //上
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab1 = new JLabel("Manage User 请输入姓名（员工号或职位）");
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
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    new String [] {
                        "ID", "Name", "Role", "Employee"
                    }));
		jsp = new JScrollPane(jtable);
		p2.add(jsp);
		
		
		//下
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
                p3_jb1 = new JButton("返回");
                p3_jb1.addActionListener(this);
		p3.add(p3_jb1);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("刷新");
		p4_jb1.addActionListener(this);
		
		p4_jb2 = new JButton("添加");
		p4_jb2.addActionListener(this);
		
		p4_jb3 = new JButton("修改");
		p4_jb3.addActionListener(this);
		
		p4_jb4 = new JButton("删除");
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
}
