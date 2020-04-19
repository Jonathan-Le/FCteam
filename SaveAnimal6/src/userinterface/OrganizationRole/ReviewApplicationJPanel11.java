/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrganizationRole;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author wang
 */
public class ReviewApplicationJPanel11 extends JPanel{
    JPanel jp1, jp2, jp3;
    JLabel jl1,jl2,jl3,jl4;
    JTextField jtf1, jtf2, jtf3;
    JButton jb1,jb2;
    
    
    
    public ReviewApplicationJPanel11(){
        
        this.initView();
    }
    
    public void initView(){
        jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl1 = new JLabel("Please fill in your information !");
        jp1.add(jl1);
        
        jp2 = new JPanel(new GridLayout(3,2));
        jl2 = new JLabel("Annual Budget");
        jl3 = new JLabel("Personal Description");
        jl4 = new JLabel("Result");
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        
        jp2.add(jl2);
        jp2.add(jtf1);
        jp2.add(jl3);
        jp2.add(jtf2);
        jp2.add(jl4);
        jp2.add(jtf3);
        
        jp3 = new JPanel();
        jb1 = new JButton();
        jb2 = new JButton();
        jp3.add(jb1);
        jp3.add(jb2);
        
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp2,"Center");
        this.add(jp3,"South");
        
        this.setVisible(true);
    
    
    }
}
