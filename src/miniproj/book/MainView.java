package miniproj.book;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView implements ActionListener{
	//선언부
	JFrame		jf 				= null;
	ImageIcon	kosmo_img		= new ImageIcon("src\\miniproj\\book\\kosmo_bg.png");
	JLabel		imglbl			= new JLabel();
	JButton		jbtn_customer	= new JButton("고객으로 입장하기");
	JButton		jbtn_manager	= new JButton("관리자로 입장하기");
	JButton		jbtn_close		= new JButton("종료");
//	이미지 절대경로
//	ImageIcon	kosmo_img		= new ImageIcon("C:\\Users\\김은영\\Desktop\\MiniProjectWithHT\\MainView\\kosmobook_icon.png");

	
	//배경 이미지를 처리하는 내부클래스
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(kosmo_img.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	
	
	
	private static MainView	mv	= null; 
	CusView		cv				= null;
	//생성자
	public MainView() {
		initDisplay();
	}
	
	public static MainView getMVInstance() {
		if(mv == null) {
			mv = new MainView();
		}
		return mv;
	}
	
	//화면처리부
	public void initDisplay() {
		jf = new JFrame("KOSMO문고");						//JFrame 인스턴스 생성 및 창 제목 설정
		jf.setContentPane(new MyPanel());
		jf.getContentPane().setLayout(null);
		jf.setSize(500,500);
		
//		//이미지 설정
//		imglbl.setIcon(kosmo_img);
//		imglbl.setHorizontalAlignment(JLabel.CENTER);
//		jf.getContentPane().add(imglbl);

		//버튼의 배치
		jbtn_customer.setBounds(125,250,250,30);
		jbtn_customer.addActionListener(this);
		jbtn_customer.setBackground(Color.white);
		jbtn_manager.setBounds(125,300,250,30);
		jbtn_manager.addActionListener(this);
		jbtn_manager.setBackground(Color.white);
		jbtn_close.setBackground(Color.white);
		jbtn_close.setBounds(210, 350, 80, 30);
		jbtn_close.addActionListener(this);
		
		
		//프레임에 버튼 추가하기
		jf.getContentPane().add(jbtn_customer);                                                                                                                                                                                                                                    
		jf.getContentPane().add(jbtn_manager);
		jf.add(jbtn_close);

		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainView.getMVInstance();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		//'고객으로 입장하기 버튼'을 눌렀을 때 CusView창 띄우기
		if(obj == jbtn_customer) {
			jf.setVisible(false);
			new CusView();
		}
		else if(obj == jbtn_manager) {
			jf.setVisible(false);
			new LoginView();
		}
		//[종료]버튼 눌렀을 때 event처리
		else if(obj == jbtn_close) {
			System.exit(0);
		}
	}

}
