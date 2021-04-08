package my.practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewTest_1 implements ActionListener{
	JButton		jbtn_yes	= new JButton();
	JButton		jbtn_no		= new JButton();
	
	
	
	//생성자
	public ViewTest_1() {
		initDisplay();
	}
	
	
	//화면처리부
	public int yesORno(){
		JFrame		jf			= new JFrame();
		int			reSult		= 0;
		Object[]	options 	= {"네", "아니오"};
		reSult = JOptionPane.showOptionDialog(jf
											, "정말로 삭제하시겠습니까?"
											, "삭제 확인창"
											, JOptionPane.YES_NO_OPTION
											, JOptionPane.QUESTION_MESSAGE
											, null
											, options
											, options[0]);
		System.out.println(reSult);	//네: 0을 반환, 아니오: 1을 반환
		jf.setVisible(false);
		return reSult;
	}
	public static void main(String[] args) {
		new ViewTest_1();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}

