package miniproj.book;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproj.book.MainView.MyPanel;

public class DetailView extends JFrame implements ActionListener{
	//선언 및 초기화
	JLabel	lbl_booknum		= new JLabel("도 서 번 호:");
	JLabel	lbl_class		= new JLabel("분      류:");
	JLabel	lbl_bookname	= new JLabel("도  서  명:");
	JLabel	lbl_author		= new JLabel("저      자:");
	JLabel	lbl_pub			= new JLabel("출  판  사:");
	JLabel	lbl_pubDate		= new JLabel("출  간  일:");
	JLabel	lbl_sprice		= new JLabel("판 매 가 격:");
	JLabel	lbl_stock		= new JLabel("재 고 수 량:");
	JLabel	lbl_loc			= new JLabel("위      치:");
	//선택된 책의 상세정보를 담을 label 생성
	JLabel	lbl_booknum_detail		= new JLabel();
	JLabel	lbl_class_detail		= new JLabel();
	JLabel	lbl_bookname_detail		= new JLabel();
	JLabel	lbl_author_detail		= new JLabel();
	JLabel	lbl_pub_detail			= new JLabel();
	JLabel	lbl_pubDate_detail		= new JLabel();
	JLabel	lbl_sprice_detail		= new JLabel();
	JLabel	lbl_stock_detail		= new JLabel();
	JLabel	lbl_loc_detail			= new JLabel();
	//상세정보 VO
	Vector<BookVO>	vecBVO			= null;
	int		rownum					= 0;
	//닫기버튼
	JButton	jbtn_close				= new JButton("닫기");
	//배경이미지
	ImageIcon	bg_img				= new ImageIcon("src\\miniproj\\book\\bookshelves.png");		
	
	//생성자
	public DetailView() {
		initDisplay();
	}

	//배경처리
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(bg_img.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	
	
	//화면처리부
	public void initDisplay() {
		this.setTitle("상세조회");
		this.setContentPane(new MyPanel());
		this.getContentPane().setLayout(null);
		lbl_booknum.setBounds(50, 50, 100, 60);
		lbl_booknum.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_booknum);
		lbl_bookname.setBounds(50, 110, 100, 60);
		lbl_bookname.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_bookname);
		lbl_class.setBounds(50, 170, 100, 60);
		lbl_class.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_class);
		lbl_author.setBounds(50, 230, 100, 60);
		lbl_author.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_author);
		lbl_pub.setBounds(50, 290, 100, 60);
		lbl_pub.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_pub);
		lbl_pubDate.setBounds(50, 350, 100, 60);
		lbl_pubDate.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_pubDate);
		lbl_sprice.setBounds(50, 410, 100, 60);
		lbl_sprice.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_sprice);
		lbl_stock.setBounds(50, 470, 100, 60);
		lbl_stock.setFont(new Font("휴먼모음T",Font.BOLD,16));
		this.add(lbl_stock);
		lbl_loc.setBounds(50, 530, 100, 60);
		lbl_loc.setFont(new Font("휴먼모음T",Font.BOLD,16));
		this.add(lbl_loc);
				
		//버튼 설정
		jbtn_close.setBounds(250, 650, 100, 30);
		jbtn_close.setBackground(Color.getHSBColor(30,0,30));
		jbtn_close.setBackground(Color.WHITE);
		jbtn_close.addActionListener(this);
		this.add(jbtn_close);

		
		this.setSize(600, 800);
		this.setVisible(true);
	}

	public void set(Vector<BookVO> vecBVO, int rownum) {
		this.vecBVO = vecBVO;
		this.rownum = rownum;
		//라벨에 테이블 상세요소 넣기
		lbl_booknum_detail.setText(vecBVO.get(rownum).getBooknum().toString());
		lbl_booknum_detail.setBounds(150, 50, 400, 60);
		lbl_booknum_detail.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_booknum_detail);
		lbl_bookname_detail.setText(vecBVO.get(rownum).getBookname());
		lbl_bookname_detail.setBounds(150, 110, 400, 60);
		lbl_bookname_detail.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_bookname_detail);
		lbl_class_detail.setText(vecBVO.get(rownum).getParti());
		lbl_class_detail.setBounds(150, 170, 400, 60);
		lbl_class_detail.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_class_detail);
		lbl_author_detail.setText(vecBVO.get(rownum).getAuthor());
		lbl_author_detail.setBounds(150, 230, 400, 60);
		lbl_author_detail.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_author_detail);
		lbl_pub_detail.setText(vecBVO.get(rownum).getPublisher());
		lbl_pub_detail.setBounds(150, 290, 400, 60);
		lbl_pub_detail.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_pub_detail);
		lbl_pubDate_detail.setText(Integer.toString(vecBVO.get(rownum).getPdate()));
		lbl_pubDate_detail.setBounds(150, 350, 400, 60);
		lbl_pubDate_detail.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_pubDate_detail);
		lbl_sprice_detail.setText(Integer.toString(vecBVO.get(rownum).getSprice()));
		lbl_sprice_detail.setBounds(150, 410, 400, 60);
		lbl_sprice_detail.setFont(new Font("휴먼모음T",Font.PLAIN,16));
		this.add(lbl_sprice_detail);
		lbl_stock_detail.setText(Integer.toString(vecBVO.get(rownum).getInven()));
		lbl_stock_detail.setBounds(150, 470, 400, 60);
		lbl_stock_detail.setFont(new Font("휴먼모음T",Font.BOLD,16));
		this.add(lbl_stock_detail);
		lbl_loc_detail.setText(vecBVO.get(rownum).getLoc());
		lbl_loc_detail.setBounds(150, 530, 400, 60);
		lbl_loc_detail.setFont(new Font("휴먼모음T",Font.BOLD,16));
		this.add(lbl_loc_detail);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == jbtn_close) {
			this.dispose();
		}
	}

}
