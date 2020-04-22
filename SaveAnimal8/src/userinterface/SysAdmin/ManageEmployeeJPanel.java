/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SysAdmin;

import Business.Department.Department;
import Business.Department.DepartmentDirectory;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Network.NetworkDirectory;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
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

/**
 *
 * @author wang
 */
public class ManageEmployeeJPanel extends JPanel implements ActionListener{
     Department department;
     JPanel userProcessContainer;
     EcoSystem system;
     Network network;
      Enterprise enterprise;
      JTable jtable;
    JScrollPane jsp;
    JPanel p1, p2, p3, p4, p5;
    JLabel p1_lab1;
    JTextField p1_jtf1;
    JButton p1_jb1,p3_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4;
      
      public ManageEmployeeJPanel(JPanel userProcessContainer,EcoSystem system,Network network , Enterprise enterprise ,Department department){
          this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.network=network;
        this.enterprise=enterprise;
        this.department=department;
        this.ShopView();
        populateRequestTable();
      }
      
      public void populateRequestTable(){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
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

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);          
                    Object[] row = new Object[3];
                    row[0]=request.getId();
                    row[1]=request.getName();
                    row[2]=request.getRegisterTime();
                    dtm.addRow(row);                    
    }
    
    public void ShopView(){
        //上
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab1 = new JLabel("Manage Employee 请输入姓名（员工号或职位）");
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
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                    },
                    new String [] {
                        "ID", "Name"
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
		
		//p4_jb3 = new JButton("Manage Network");
		//p4_jb3.addActionListener(this);
		
		p4_jb4 = new JButton("删除");
		p4_jb4.addActionListener(this);
		
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		//p4.add(p4_jb3);
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
        //查询
        if(e.getSource() == p1_jb1){
            String search = p1_jtf1.getText();
        Enterprise findAccount = network.getEnterpriseDirectory().findEnterprise(search);
        //这里应该返回一个找到用户名字的List  //现在是返回一个网络个体
        //populateResearchTable(findAccount);
        
            //返回
        }else if(e.getSource() == p3_jb1){            
                userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageDepartmentJPanel dwjp = (ManageDepartmentJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
            //刷新信息
        }else if(e.getSource() == p4_jb1){
            populateRequestTable();    
            
            //增加
        }else if(e.getSource() == p4_jb2){
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
             userProcessContainer.add(new CreateEmployeeJPanel( userProcessContainer, system, network ,enterprise ,department));
             layout.next(userProcessContainer);
            
            
            //修改
        }else if(e.getSource() == p4_jb3){
//                int row = jtable.getSelectedRow();
//        if (row < 0) {
//            JOptionPane.showMessageDialog(null,"Please select a row!", "get Request",JOptionPane.ERROR_MESSAGE);
//        } else{
//            //需要加入双重确认，并且改成以ID为搜索指引
//            String name = jtable.getValueAt(row,1).toString();
//            DepartmentDirectory worklist= enterprise.getDepartmentDirectory();
//            Department department = worklist.findDepartment(name);
//                   
//            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//            userProcessContainer.add(new ManageEmployeeJPanel(userProcessContainer,system,network , enterprise ,department));
//            layout.next(userProcessContainer);
//        }
            
            //删除
        }else if(e.getSource() == p4_jb4){
                int row = jtable.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null,"Please select a row!", "get Request",JOptionPane.ERROR_MESSAGE);
                } else{
                    //需要加入双重确认，并且改成以ID为搜索指引
                    String name = jtable.getValueAt(row,1).toString();
                    NetworkDirectory worklist= system.getNetworkdirectory();
                    Network network = worklist.findNetWork(name);
                    worklist.getNetworkdirectory().remove(network);          
                }         
                  populateRequestTable();    
            }              
   
        }
}
