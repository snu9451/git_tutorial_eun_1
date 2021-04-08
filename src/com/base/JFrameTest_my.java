package com.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

	public class JFrameTest_my extends JFrame implements ActionListener {
	
	 // Frame을 구현하는 JFrame을 상속받음
	
	 
	 /*
	 - JFrame은 Container클래스의 객체를 만들어서 add()메소드로 element를 추가했다면,
	 - JPanel은 JFrame안에 Pane을 추가해서, 그 Pane 안에 element를 add()메소드로 추가하는 방식이다.
	 */
	 
		JPanel panel1, panel2;	//전역변수로 선언만 하였음
		JTextField id;	//아이디를 입력받을 텍스트 입력창 선언(공개됨)
		JPasswordField password;	//비밀번호를 입력받을 텍스트 입력창 선언(***으로 암호화됨)
		JButton confirm, cancel;	//확인, 취소를 담을 버튼 두 개 선언
		
		public JFrameTest_my(){	//생성자를 이용한 초기화
		
			panel1=new JPanel();  // pane 1을 Frame에 추가.
			panel1.setLayout(new GridLayout(2,2)); //2행 2열로 pane의 화면을 분할. //로그인과 입력창, 패스워드와 입력창 ?
		
			id=new JTextField(10);	//columns이 10인게 무슨 의미가 있지?	//API 참고하면 JTextField는 생성자인듯.
			password=new JPasswordField(10);
	
			panel1.add(new JLabel("아이디", JLabel.LEFT));
			panel1.add(id);
			id.setToolTipText("ID를 입력하세요");	//마우스 가져다 대면 나오는 문구(tip)
			
			panel1.add(new JLabel("비밀번호",JLabel.LEFT));
			panel1.add(password);
			password.setToolTipText("비밀번호를 입력하세요");
		
			panel2=new JPanel(); // pane 2를 Frame에 추가.
			confirm=new JButton("확인");
			cancel=new JButton("취소");
			
			confirm.addActionListener(this);	//
			cancel.addActionListener(this);	//	★★★this : 클래스 자체를 가리킴★★★
			panel2.add(confirm);
			panel2.add(cancel); 
	
			getContentPane().add(panel1, "Center");
			getContentPane().add(panel2, "South");
			/* 	★★★JFrame을 상속★★★받았으므로, getContentPane()앞에 JFrame 객체가 ★생략★된 것이다.
			ex- JFrame e;	//	JFrame을 e로 선언
			    e.getContentPane();
			*/
			
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(500,150);
			this.setVisible(true);	//	★★★this : 클래스 자체를 가리킴★★★
	
	
		} //end LoginForm()
	 
	
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object o=ae.getSource();
			/*어떤 클래스로 받아야 할 지 모를때
			: 최상위클래스인 java.lang.Object를 상위클래스 객체로 놓으면 편하다.
			*/
	
			String db_id="eunyoung";
			String db_pwd="abcd11";
		 
			if(o==confirm)
			{// 로컬변수 db_id와 db_pwd가 문자값 1로 코딩내부적으로 정의되었고, id와 password에 1을 입력해야지만 참이 나온다.
				if(db_id.equals( id.getText().trim() ) && db_pwd.equals(password.getText().trim()) )
				{// trim() : 문자열에 존재하는 space를 제거.
					id.setText("로그인 성공");	//getText, setText: getter Setter?
					password.setText("");
				}
				else
				{
					id.setText("잘못된 접근");
					password.setText("");
					id.requestFocus();
				} //end if(db_id, db_pwd)
			}
			else if(o==cancel)
			{
				id.setText("");
				password.setText("");
				id.requestFocus();
			} /////////end of if(confirm) else if (cancel)
		}//////////////end of actionPerformed
	 
		public static void main(String[] args) {
			new JFrameTest_my();
		}///////////end of main
	
	} 