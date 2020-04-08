package view;

import java.awt.*;
import java.awt.event.*;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.*;


import model.UserModel;

public class UserLogin extends JFrame implements ActionListener{
	//定义组件
		JLabel jl1,jl2,jl3;
		JButton jCon,jCancel;
		JTextField jname;
		JPasswordField jpassword;
		JPanel jp1, jp2, jp3;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserLogin ul = new UserLogin();
		
	}
	public UserLogin() {
		
		this.setTitle("登录");
		this.setLayout(new GridLayout(3, 1));
		this.setSize(300, 200);
		this.setLocation(550, 200);	
		
		jp1 = new JPanel();
		jp2= new JPanel();
		jp3= new JPanel();
		
		
		jl1 = new JLabel("用户名：");
		jl2 = new JLabel("密码：");
		
		jname =new JTextField(13);
		jpassword =new JPasswordField(14);
		
		jp1.add(jl1);
		jp1.add(jname);
		
		jp2.add(jl2);
		jp2.add(jpassword);
		
		
		jCon =new JButton("登录");
		jCon.addActionListener(this);
		jCancel  =new JButton("退出");
		jCancel.addActionListener(this);
		jp3.add(jCon);
		jp3.add(jCancel);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3,BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jCon) {
			System.out.println("qwe");
			String id = this.jname.getText();
			String pd = new String(this.jpassword.getPassword());
			UserModel um = new UserModel();
			String a = um.CheckUser(id, pd);
			if(a.equals("manager")) {
				new managervView();
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败，请输入正确数据类型!");
			}
			
		}else if(e.getSource() == jCancel) {
			this.dispose();
		}
	}
	
	
}
