package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.*;


import tool.*;



public class managervView extends JFrame implements ActionListener, MouseListener{
	//定义组件
		Image titleIcon, timeGg;
		JMenuBar jmb;
		//一级菜单
		JMenu jm1,jm2,jm3,jm4,jm5,jm6;
		//二级菜单
		JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5,jmm6,jmm7,jmm8,jmm9,jmm10,jmm11;
		//工具栏
		JToolBar jtb;
		JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
		//定义需要的五个面板
		JPanel jp1,jp2,jp3;
		JSplitPane jsp;
		JLabel TimeNow;
		JLabel p1_lab1, p1_lab2, p1_lab3, p1_lab4, p1_lab5, p1_lab6, p1_lab7, p1_lab8;
		//这个timer可以定时的触发action时间，可以利用它完成一些事情
		javax.swing.Timer t;
		ImagePanel p1_imgPanel;
		CardLayout cardP3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		managervView mv = new managervView();
	}
	
	
	public managervView() {
		
		//菜单栏
		this.initMenu();
		
		//中间面板
		this.initallPanels();
		//时间面板
		this.initTime();
		
		Container ct = this.getContentPane();
		//ct.add(jtb,"North");
		ct.add(jsp);
		ct.add(jp3,"South");
		
		//设置大小
				int width = Toolkit.getDefaultToolkit().getScreenSize().width;
				int height = Toolkit.getDefaultToolkit().getScreenSize().height;
				this.setSize(width, height-25);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//初始化菜单
		public void initMenu() {
			//创建一级菜单1
					jm1 = new JMenu("系统管理");
					//创建二级菜单
					jmm1 = new JMenuItem("切换用户");
					jmm2 = new JMenuItem("日历");
					jmm3 = new JMenuItem("退出");
					//加入一级菜单
					jm1.add(jmm1);
					jm1.add(jmm2);
					jm1.add(jmm3);
					
					//创建一级菜单6
					jm6 = new JMenu("帮助");
					//创建二级菜单
					jmm10 = new JMenuItem("文字帮助");
					jmm11 = new JMenuItem("关于我们");
					jm6.add(jmm11);
					jm6.add(jmm10);
					
					//加入菜单条
					jmb = new JMenuBar();
					jmb.add(jm1);
					jmb.add(jm6);
					
					//菜单条添加主界面
					this.setJMenuBar(jmb);
		}
		
	//初始化中间窗口
		public void initallPanels() {
			///////中间窗口
					jp1 = new JPanel(new BorderLayout());
					Image p1_bg = null;
					try {
						p1_bg = ImageIO.read(new File("image/jp1_bg.jpg"));
						this.p1_imgPanel = new ImagePanel(p1_bg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					p1_lab1 = new JLabel(new ImageIcon("image/logo.png"));
					p1_imgPanel.add(p1_lab1);
					
					p1_lab2 = new JLabel("人事管理",new ImageIcon("image/label_2.jpg"),0);
					p1_lab2.setFont(Mytools.f1);
					//让该label不可用
					p1_lab2.setEnabled(false);
					//注册监听
					p1_lab2.addMouseListener(this);
					p1_imgPanel.add(p1_lab2);
					
					p1_lab3 = new JLabel("登陆管理",new ImageIcon("image/label_3.jpg"),0);
					p1_lab3.setFont(Mytools.f1);
					p1_lab3.setEnabled(false);
					//注册监听
					p1_lab3.addMouseListener(this);
					p1_imgPanel.add(p1_lab3);
					
					p1_lab4 = new JLabel("宠物信息",new ImageIcon("image/label_4.jpg"),0);
					p1_lab4.setFont(Mytools.f1);
					p1_lab4.setEnabled(false);
					//注册监听
					p1_lab4.addMouseListener(this);
					p1_imgPanel.add(p1_lab4);
					
					p1_lab5 = new JLabel("客户信息",new ImageIcon("image/label_5.jpg"),0);
					p1_lab5.setFont(Mytools.f1);
					p1_lab5.setEnabled(false);
					//注册监听
					p1_lab5.addMouseListener(this);
					p1_imgPanel.add(p1_lab5);
					
					p1_lab6 = new JLabel("医生信息",new ImageIcon("image/label_6.jpg"),0);
					p1_lab6.setFont(Mytools.f1);
					p1_lab6.setEnabled(false);
					//注册监听
					p1_lab6.addMouseListener(this);
					p1_imgPanel.add(p1_lab6);
					
					p1_lab7 = new JLabel("系统设置",new ImageIcon("image/label_7.jpg"),0);
					p1_lab7.setFont(Mytools.f1);
					p1_lab7.setEnabled(false);
					//注册监听
					p1_lab7.addMouseListener(this);
					p1_imgPanel.add(p1_lab7);
					
					p1_lab8 = new JLabel("帮助",new ImageIcon("image/label_8.jpg"),0);
					p1_lab8.setFont(Mytools.f1);
					p1_lab8.setEnabled(false);
					//注册监听
					p1_lab8.addMouseListener(this);
					p1_imgPanel.add(p1_lab8);
					
					this.p1_imgPanel.setLayout(new GridLayout(8,1));
					jp1.add(this.p1_imgPanel);
					
					
					this.cardP3 = new CardLayout();
					jp2 = new JPanel(this.cardP3);
					Image zhu_imag = null;
					try {
						zhu_imag = ImageIO.read(new File("image/jp3_bg.jpg"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ImagePanel ip = new ImagePanel(zhu_imag);
					
					jp2.add(ip,"0");
					//创建empinfo对象
					EmpInfo eInfo = new EmpInfo();
					jp2.add(eInfo,"1");
					//jp2.add(eInfo,"1");
					//jp2.add(eInfo,"1");
					//jp2.add(eInfo,"1");
					jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
					jsp.setLeftComponent(jp1);
					jsp.setRightComponent(jp2);
					jsp.setDividerSize(0);
					jsp.setDividerLocation(300);
			}
		
	//初始化时间面板
		public void initTime() {
			//////时间显示
			jp3 = new JPanel(new BorderLayout());
			//创建timer
			t = new Timer(1000, this);//每隔一秒触发一个时间
			//启动定时器
			t.start();
			
			TimeNow = new JLabel(Calendar.getInstance().getTime().toString());
			
			try {
				timeGg = ImageIO.read(new File("image/time_bg.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ImagePanel ip1 = new ImagePanel(timeGg);
			ip1.setLayout(new BorderLayout());
			ip1.add(TimeNow,"East");
			jp3.add(ip1);
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.TimeNow.setText(Calendar.getInstance().getTime().toString());
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.p1_lab2) {
			this.cardP3.show(jp2, "1");
		}//else if()
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.p1_lab2) {
			this.p1_lab2.setEnabled(true);
		}else if(e.getSource() == this.p1_lab3) {
			this.p1_lab3.setEnabled(true);
		}else if(e.getSource() == this.p1_lab4) {
			this.p1_lab4.setEnabled(true);
		}else if(e.getSource() == this.p1_lab5) {
			this.p1_lab5.setEnabled(true);
		}else if(e.getSource() == this.p1_lab6) {
			this.p1_lab6.setEnabled(true);
		}else if(e.getSource() == this.p1_lab7) {
			this.p1_lab7.setEnabled(true);
		}else if(e.getSource() == this.p1_lab8) {
			this.p1_lab8.setEnabled(true);
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.p1_lab2) {
			this.p1_lab2.setEnabled(false);
		}else if(e.getSource() == this.p1_lab3) {
			this.p1_lab3.setEnabled(false);
		}else if(e.getSource() == this.p1_lab4) {
			this.p1_lab4.setEnabled(false);
		}else if(e.getSource() == this.p1_lab5) {
			this.p1_lab5.setEnabled(false);
		}else if(e.getSource() == this.p1_lab6) {
			this.p1_lab6.setEnabled(false);
		}else if(e.getSource() == this.p1_lab7) {
			this.p1_lab7.setEnabled(false);
		}else if(e.getSource() == this.p1_lab8) {
			this.p1_lab8.setEnabled(false);
		}
	}
}
