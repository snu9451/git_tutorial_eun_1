package my.practice;

import java.awt.PopupMenu;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class My_HakJum {
	
	int		jumsu;
	char	hakjum;
	
	public void HakJumView() {
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		PopupMenu pm = new PopupMenu("호출성공");
		jp.add(pm);
		jf.add("Center",jp);
		jf.setSize(100, 100);
		jf.setVisible(true);
	}
	
	public My_HakJum() {
		String	sc_jumsu	= JOptionPane.showInputDialog("점수를 입력하세요.");
		jumsu = Integer.parseInt(sc_jumsu);
		System.out.println("당신의 학점은 "+HakjumSanchul(jumsu)+"입니다.");
	}
	
	
	
	public char HakjumSanchul(int jumsu){
		switch(jumsu/10){
			case 10: case 9:	//(같은 처리에 대해서는) 이렇게도 쓸 수 있다.
				hakjum = 'A';
				break;
			case 8:
				hakjum = 'B';
				break;
			case 7:
				hakjum = 'C';
				break;
			default:
				hakjum = 'F';
				break;
		}
		return hakjum;
	}
	
	
	public static void main(String[] args) {
		//new My_HakJum();
		My_HakJum mh = new My_HakJum();
		mh.HakJumView();
	}
}
