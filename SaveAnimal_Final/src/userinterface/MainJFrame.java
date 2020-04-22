/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.ConfigureASystem;
import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;

import Business.Organization;
import Business.UserAccount.UserAccount;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import tools.MyTools;




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
    JButton loginJButton,logoutJButton;
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
//        system=ConfigureASystem.configure();
//        dB4OUtil.storeSystem(system);
        system = dB4OUtil.retrieveSystem();
        
        
    }
    //登陆和取消按钮的响应
    @Override
    public void actionPerformed(ActionEvent e) {
        //登陆按钮响应
        if(e.getSource() == loginJButton){
            // Get user name
        String username = userNameJTextField.getText();
       char[] passwordCharArray = passwordField.getPassword();
       String password = String.valueOf(passwordCharArray);
            System.out.println("test");
       UserAccount useraccount = system.getUserAccountDirectory().authenticateUser(username, password);
       
     
       if (useraccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid User", "LOGIN", JOptionPane.ERROR_MESSAGE);
            return;
        }
       CardLayout cardLayout= (CardLayout) jp6.getLayout();
       jp6.add(useraccount.getRole().createWorkArea(jp6, useraccount, system));
       cardLayout.next(jp6);
       
       loginJButton.setEnabled(false);
       logoutJButton.setEnabled(true);
       userNameJTextField.setEnabled(false);
       passwordField.setEnabled(false);
            
            
       
       //取消按钮响应
        }else if(e.getSource() == logoutJButton){
            logoutJButton.setEnabled(false);
            userNameJTextField.setEnabled(true);
            passwordField.setEnabled(true);
            loginJButton.setEnabled(true);

            userNameJTextField.setText("");
            passwordField.setText("");

            jp6.removeAll();
            JPanel blankJP = new JPanel();
            jp6.add("blank", blankJP);
            CardLayout crdLyt = (CardLayout)jp6.getLayout();
            crdLyt.next(jp6);
            dB4OUtil.storeSystem(system);
            
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

		
	jl1 = new JLabel("Username：");
	jl2 = new JLabel("Password：");
		
	userNameJTextField =new JTextField(13);
	passwordField =new JPasswordField(14);
		
        jp2.add(jl3);        
	jp3.add(jl1);
	jp3.add(userNameJTextField);
		
	jp4.add(jl2);
	jp4.add(passwordField);
		
		
	loginJButton = new JButton("Log in");
        loginJButton.setFont(MyTools.f1);
	loginJButton.addActionListener(this);
        
	logoutJButton = new JButton("Log out");
        logoutJButton.setFont(MyTools.f1);
	logoutJButton.addActionListener(this);
        
	jp5.add(loginJButton);
	jp5.add(logoutJButton);
        
        
        jp1.add(jp2);
        jp1.add(jp3);
        jp1.add(jp4);
        jp1.add(jp5);

       
        jp6 = new JPanel(new CardLayout());
        jp6.add(jl4,"0");
        
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jsp.setLeftComponent(jp1);
	jsp.setRightComponent(jp6);
	jsp.setDividerSize(1);
	jsp.setDividerLocation(300);
 
        Container ct = this.getContentPane();
	ct.add(jsp);
                
                
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        System.out.println(width);
        System.out.println(height);
	this.setSize(width, height);
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
}
