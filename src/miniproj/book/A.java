package miniproj.book;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import miniproj.book.CusView.MyPanel;

public class A extends JDialog {
	//배경 이미지
	ImageIcon			bg_img			= new ImageIcon("src\\miniproj\\book\\grass_bg.png");
	public A() {
		this.setContentPane(new MyPanel());
		this.setLayout(null);
		this.setSize(1300,1000);
		
	}
	//배경설정(inner Class)
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(bg_img.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}	
	public static void main(String[] args) {
		new A();
	}

}
