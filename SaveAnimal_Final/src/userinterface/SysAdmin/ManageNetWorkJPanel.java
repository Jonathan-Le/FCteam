/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SysAdmin;

import Business.EcoSystem;
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
import tools.MyTools;

/**
 *
 * @author wang
 */
public class ManageNetWorkJPanel extends JPanel implements ActionListener{
    JTable jtable;
    JScrollPane jsp;
    JPanel p1, p2, p3, p4, p5;
    JLabel p1_lab1;
    JTextField p1_jtf1;
    JButton p1_jb1,p3_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4;
    EcoSystem system;
    JPanel userProcessContainer;
   
    
    public ManageNetWorkJPanel(JPanel userProcessContainer, EcoSystem system){
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.ShopView();
        populateRequestTable();
    }
    
    public void populateRequestTable(){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);      
            NetworkDirectory worklist= system.getNetworkdirectory();
          
            if (worklist != null){  
                for(Network request : worklist.getNetworkdirectory()){
                    Object[] row = new Object[2];
                    row[0]=request.getId();
                    row[1]=request.getName();            
                    dtm.addRow(row);
                }
            }     
    }
    public void populateResearchTable(Network request){

            DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
            dtm.setRowCount(0);          
                    Object[] row = new Object[2];
                    row[0]=request.getId();
                    row[1]=request.getName();            
                    dtm.addRow(row);                    
    }
    
    
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //查询
        if(e.getSource() == p1_jb1){
            String search = p1_jtf1.getText();
        Network findAccount = system.getNetworkdirectory().findNetWork(search);
        //这里应该返回一个找到用户名字的List  //现在是返回一个网络个体
        populateResearchTable(findAccount);
        
            //返回
        }else if(e.getSource() == p3_jb1){            
            userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
            //刷新信息
        }else if(e.getSource() == p4_jb1){
            populateRequestTable();    
            
            //增加
        }else if(e.getSource() == p4_jb2){
            System.out.println("增加");
            
            addNetWorkName ad = new addNetWorkName(system);
            //system.getNetworkdirectory().getNetworkdirectory().add(new Network(addnamejTextField.getText()));
            populateRequestTable();
            
            
            //修改
        }else if(e.getSource() == p4_jb3){
                int row = jtable.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(null,"Please select a row!", "get Request",JOptionPane.ERROR_MESSAGE);
            } else{
                //需要加入双重确认，并且改成以ID为搜索指引
                String name = jtable.getValueAt(row,1).toString();
                NetworkDirectory worklist= system.getNetworkdirectory();
                Network network = worklist.findNetWork(name);
                System.out.println(network.getName());       
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add(new ManageEnterpriseJPanel(userProcessContainer,system,network));
                layout.next(userProcessContainer);


            }  
            
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
   
    
    public void ShopView(){
        //上
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab1 = new JLabel("Manage NetWork pleaase enter name");
		p1_jtf1 = new JTextField(20);
		p1_jb1 = new JButton("Search");
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
		
                p3_jb1 = new JButton("Back");
                p3_jb1.setFont(MyTools.f1);
                p3_jb1.addActionListener(this);
		p3.add(p3_jb1);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("Refresh");
                p4_jb1.setFont(MyTools.f1);
		p4_jb1.addActionListener(this);
		
		p4_jb2 = new JButton("Add");
                p4_jb2.setFont(MyTools.f1);
		p4_jb2.addActionListener(this);
		
		p4_jb3 = new JButton("Manage Enterprise");
                p4_jb3.setFont(MyTools.f1);
		p4_jb3.addActionListener(this);
		
		p4_jb4 = new JButton("Delete");
                p4_jb4.setFont(MyTools.f1);
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
