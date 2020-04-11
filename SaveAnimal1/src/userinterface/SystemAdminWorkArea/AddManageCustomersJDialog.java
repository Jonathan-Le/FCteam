/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author wang
 */
public class AddManageCustomersJDialog extends JDialog implements ActionListener{
    //添加组件
	JPanel jp1, jp2,jp3;
	JButton jb1,jb2;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5,jtf6;
        
        
    public AddManageCustomersJDialog(){
        //上
		jl1 = new JLabel("学号");
		jl2 = new JLabel("姓名");
		jl3 = new JLabel("性别");
		jl4 = new JLabel("年龄");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		
		jb1 = new JButton("添加");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(4,1));
		jp2.setLayout(new GridLayout(4,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		
		this.setSize(400,300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
    }
    
}
