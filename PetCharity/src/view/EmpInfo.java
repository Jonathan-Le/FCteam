package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;





public class EmpInfo extends JPanel implements ActionListener{
	JTable jtable;
	JScrollPane jsp;
	JPanel p1, p2, p3, p4, p5;
	JLabel p1_lab1, p3_lab1;
	JTextField p1_jtf1;
	JButton p1_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4;
	
	
	public EmpInfo() {
		//上
				p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
				p1_lab1 = new JLabel("请输入姓名（员工号或职位）");
				p1_jtf1 = new JTextField(20);
				p1_jb1 = new JButton("查询");
				p1_jb1.addActionListener(this);
				p1.add(p1_lab1);
				p1.add(p1_jtf1);
				p1.add(p1_jb1);
				
				//中
				//EmpModel em = new EmpModel();
				String paras[] = {"1"};
				//em.query("select empid,empname,sex,zw from rszl where 1 = ?", paras);
				p2 = new JPanel(new BorderLayout());
				//jtable = new JTable(em);
				jsp = new JScrollPane(jtable);
				p2.add(jsp);
				
				
				//下
				p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				p3_lab1 = new JLabel("总记录是**条");
				p3.add(p3_lab1);
				
				p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				p4_jb1 = new JButton("详细信息");
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
