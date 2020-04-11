/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;

import Business.Organization;
import Business.UserAccount.UserAccount;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;




/**
 *
 * @author wang
 */
public class MainJFrame extends JFrame implements ActionListener{
    
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7;
    JSplitPane jsp;
    JLabel jl1, jl2, jl3, jl4;
    JTextField userNameJTextField;
    JPasswordField passwordField;
    JButton jb1,jb2;
    CardLayout cardP3;
    
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
   
    public static void main(String[] args) {
        //运行程序
        MainJFrame mj = new MainJFrame();
    }
    
    public MainJFrame(){
        //调用创造界面函数
        this.initMainView();
        
        
    }
    //登陆和取消按钮的响应
    @Override
    public void actionPerformed(ActionEvent e) {
        //登陆按钮响应
        if(e.getSource() == jb1){
            // Get user name
        String username = userNameJTextField.getText();
       char[] passwordCharArray = passwordField.getPassword();
       String password = String.valueOf(passwordCharArray);
       
       UserAccount useraccount = system.getUserAccountDirectory().authenticateUser(username, password);
       
     
       if (useraccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid User", "LOGIN", JOptionPane.ERROR_MESSAGE);
            return;
        }
       CardLayout cardLayout= (CardLayout) container.getLayout();
       container.add(useraccount.getRole().createWorkArea(container, useraccount, system));
       cardLayout.next(container);
       
       loginJButton.setEnabled(false);
       logoutJButton.setEnabled(true);
       userNameJTextField.setEnabled(false);
       passwordField.setEnabled(false);
            
            
       
       //取消按钮响应
        }else if(e.getSource() == jb2){
            this.dispose();
            
        }
    
    }
    
    //界面
    public void initMainView(){
        
        jp1 = new JPanel(new GridLayout(4, 1));
	jp2= new JPanel();
	jp3= new JPanel();
        jp4= new JPanel();
        jp5= new JPanel();
	jp6= new JPanel();
        
        
//        Icon icon=new ImageIcon("image/logo.png");
//        jl3 = new JLabel();
//        jl3.setIcon(icon);
//        jl3.setSize(246,246);

        jl3 = new JLabel(new ImageIcon("image/logo.png"));
        jl4 = new JLabel(new ImageIcon("image/jp3_bg.jpg"));

		
	jl1 = new JLabel("用户名：");
	jl2 = new JLabel("密码：");
		
	userNameJTextField =new JTextField(13);
	passwordField =new JPasswordField(14);
		
        jp2.add(jl3);        
	jp3.add(jl1);
	jp3.add(userNameJTextField);
		
	jp4.add(jl2);
	jp4.add(passwordField);
		
		
	jb1 = new JButton("登录");
	jb1.addActionListener(this);
        
	jb2 = new JButton("退出");
	jb2.addActionListener(this);
        
	jp5.add(jb1);
	jp5.add(jb2);
        
        
        jp1.add(jp2);
        jp1.add(jp3);
        jp1.add(jp4);
        jp1.add(jp5);
         
        
        this.cardP3 = new CardLayout();
	jp6 = new JPanel(this.cardP3);
        jp6.add(jl4,"0");
        //sa = new SystemAdminWorkAreaJPanel();
       // ManageCustomersJPanel mc = new ManageCustomersJPanel();
        jp6.add(mc,"1");
        
        
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jsp.setLeftComponent(jp1);
	jsp.setRightComponent(jp6);
	jsp.setDividerSize(1);
	jsp.setDividerLocation(300);
 
        Container ct = this.getContentPane();
	ct.add(jsp);
                
                
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	this.setSize(width, height-25);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
}
