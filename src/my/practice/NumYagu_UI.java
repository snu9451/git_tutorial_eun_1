package my.practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



//랜덤게임을 이용한 화면구성을 통해 ★클래스 쪼개기★에 대해 학습하자!
public class NumYagu_UI {
	//선언부
	JPanel jp_center = new JPanel();	//속지 생성1
	JPanel jp_south	 = new JPanel();	//속지 생성2
	JPanel jp_east	 = new JPanel();
	JButton jbtns[]	 = new JButton[10];	//버튼 10칸 생성	//아직은 '방(room)'만 있음
	JButton jbtn	 = null;			//초기화는 null로 한다.
	JButton jbtns2[] = new JButton[4];
	JButton jbtn2	 = null;
	String nums_label[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	String nums_bttn[]	= {"replay", "exit", "erase", "enter"};
	//생성자
	
	//화면처리부
	public void initDisplay() {
		JFrame jf = new JFrame();
		
		jp_center.setBackground(Color.cyan);
		jp_south.setBackground(Color.yellow);
		jp_south.setLayout(new GridLayout(1,10));
		jp_east.setLayout(new GridLayout(4,1));
		//
		for(int i=0;i<jbtns.length;i++) {		//jbtns.length 대신에 nums_label.length 해도 똑같음
			jbtn = new JButton(nums_label[i]);	//★★★여기 생각해보기!
			jp_south.add(jbtn);
		}
		for(int i=0;i<jbtns2.length;i++) {
			jbtn2 = new JButton(nums_bttn[i]);
			jp_east.add(jbtn2);
		}
		
		jf.setLayout(new BorderLayout());
		
		jf.add("Center", jp_center);
		jf.add("South", jp_south);
		jf.add("East", jp_east);
		
		jf.setSize(500,400);
		jf.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
				//insert here 버튼 눌렀을 떄의 action
			}			
		}
	}
	
	
	//main메소드
	public static void main(String[] args) {
		//내 안에 있다고 하더라도 메인 안에서 호출하려면 인스턴스화를 해야 한다.
		NumYagu_UI rgView = new NumYagu_UI();
		rgView.initDisplay();
		
	}

}
