package inter.face.practice;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Pr_0224_1 {
	//선언부
	JFrame		jf	= null;
	JPanel		jp	= null;
	JScrollPane jsp = null;
	JTextArea	jta	= null;
	//생성자
	public Pr_0224_1() {
		jf	= new JFrame();
		jp	= new JPanel();
		jta	= new JTextArea(10,20);
		jsp = new JScrollPane(jp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
								 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp.add(jsp);
		jf.add(jsp, BorderLayout.CENTER);
		jf.add("Center",jta);
		jf.setSize(400,100);
		jf.setVisible(true);
	}
	//main
	public static void main(String[] args) {
		new Pr_0224_1();
	}
	
	
}
