package tool;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/*
 * 动态加载一个图片做背景的jpanel
 */
public class ImagePanel extends JPanel{
	Image im;
	
	//构造函数去指定该panel大小
	public ImagePanel(Image im) {
		this.im = im;
		//自适应
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w,h);
	}
	
	//画出背景
	public void paintComponent(Graphics g) {
		//清屏
		super.paintComponent(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}
