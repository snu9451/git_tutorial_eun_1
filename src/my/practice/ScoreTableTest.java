package my.practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MainPanel extends JPanel {
	
}



public class ScoreTableTest extends JFrame {
	
	JTextField jtf_input = new JTextField();
	JButton jbtn_create = new JButton("만들기");
	JPanel jp_center = new JPanel();
	
	
	public ScoreTableTest() {
		initDisplay();
	}
	
	public void initDisplay() {
		setLayout(new BorderLayout(100, 100));
//		jp_center.setLayout();
		jp_center.setLayout(new FlowLayout());
		jp_center.setBackground(Color.orange);
		jtf_input.setPreferredSize(new Dimension(200,25));
		jbtn_create.setPreferredSize(new Dimension(80,25));
//		jtf_input.setAlignmentX(CENTER_ALIGNMENT);
//		jbtn_create.setAlignmentX(CENTER_ALIGNMENT);
//		jp_center.setAlignmentY(CENTER_ALIGNMENT);
		
		jp_center.add(jtf_input);
		jp_center.add(jbtn_create);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add("Center", jp_center);
		setTitle("성적조회-검색창");
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ScoreTableTest();
	}

}
