package miniproj.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import miniproj.book.MainView.MyPanel;
//부속창(자녀창)은 JDialog로 해라!
public class CusView extends JFrame implements MouseListener, KeyListener, ActionListener{
	//[선언부]//////////////////////////////////////////////////////////////////
	//상단 타이틀
	JLabel				lbl				= new JLabel("K O S M O");
	Cursor				csr				= new Cursor(Cursor.HAND_CURSOR);
	//하단 문구
	JLabel				lbl_advice		= new JLabel("※더블클릭하면 자세한 정보(재고수량, 위치 등)를 확인하실 수 있습니다.");
	JLabel 				jlb_bname		= new JLabel();
	JLabel 				jlb_bprice		= new JLabel();
	JLabel 				jlb_bname_sel	= new JLabel();
	JLabel 				jlb_bprice_sel	= new JLabel();
	//콤보박스
	String				combo_list[]	= {"도서명","도서번호","저자","출판사"};
	JComboBox<String> 	combo			= new JComboBox<String>(combo_list);
	//텍스트field
	JTextField			jtf				= new JTextField();
	//검색버튼
	JButton				jbtn_search		= new JButton("검색");
	//창닫기 버튼
	JButton				jbtn_this_close	= new JButton("이전");
	//구매버튼
	JButton				jbtn_purchase	= new JButton("구매 확정");
	//표를 담을 공간 구성
	String				cols[]	 		= {"도서번호","분류","도서명","저자","출판사","출판일","판매가격"};
	String				data[][] 		= new String[0][7];
	//이게뭘까.....★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	DefaultTableModel 	dtm_book 		= new DefaultTableModel(data,cols) {
												public boolean isCellEditable(int rowindex, int colindex) {
													return false;
												}
										  };
	JTable				jtb_book 		= new JTable(dtm_book);
	JScrollPane			jsp_book 		= new JScrollPane(jtb_book);
	DefaultTableCellRenderer dtcr 		= new DefaultTableCellRenderer();
	TableColumnModel	tcm				= jtb_book.getColumnModel();
	
	//데이터 연결을 위한 선언
	DBConnectionMgr		dbMgr			= DBConnectionMgr.getInstance();
	Connection			con				= null;
	PreparedStatement	pstmt			= null;
	ResultSet			rs				= null;
	
	//검색기능 구현
	String				search			= null;
	
	//테이블 요소를 담을 VO선언
	BookVO				bVO				= null;
	
	//불러온 데이터를 담을 VOS
	Vector<BookVO>		vecBVO			= null;
	
	//배경 이미지
	ImageIcon			bg_img			= new ImageIcon("src\\miniproj\\book\\grass_bg.png");
	
	//[생성자]//////////////////////////////////////////////////////////////////
	public CusView() {
		tableYOSO();
		initDisplay();
	}
	
	//배경설정(inner Class)
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(bg_img.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	
	
	public void tableYOSO() {
		//sql문을 담는 변수 선언
		String				sql_sel			= "SELECT b.booknum, b.class, b.bookname"
											+ ", b.author, b.publisher, b.pdate, b.sprice"
											+ ", i.inventory, i.loc FROM BOOKMGR b, INVENTORYTBL i"
											+ " WHERE b.booknum = i.booknum";
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql_sel);
			rs = pstmt.executeQuery();
			vecBVO = new Vector<BookVO>();
			
			while(rs.next()) {
				bVO = new BookVO();
				bVO.setBooknum(rs.getString("BOOKNUM"));
				bVO.setParti(rs.getString("CLASS"));
				bVO.setBookname(rs.getString("BOOKNAME"));
				bVO.setAuthor(rs.getString("AUTHOR"));
				bVO.setPublisher(rs.getString("PUBLISHER"));
				bVO.setPdate(rs.getInt("PDATE"));
				bVO.setSprice(rs.getInt("SPRICE"));
				bVO.setInven(rs.getInt("INVENTORY"));
				bVO.setLoc(rs.getString("LOC"));
				vecBVO.add(bVO);
			}
			for (int i = 0; i < vecBVO.size(); i++) {
				Vector<Object> oneRow = new Vector<Object>();
				oneRow.add(vecBVO.get(i).getBooknum());
				oneRow.add(vecBVO.get(i).getParti());
				oneRow.add(vecBVO.get(i).getBookname());
				oneRow.add(vecBVO.get(i).getAuthor());
				oneRow.add(vecBVO.get(i).getPublisher());
				oneRow.add(vecBVO.get(i).getPdate());
				oneRow.add(vecBVO.get(i).getSprice()+" 원");
				dtm_book.addRow(oneRow);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		dbMgr.freeConnection(con, pstmt, rs);	
	}
	
	
	
	//[화면처리부]///////////////////////////////////////////////////////////////
	public void initDisplay() {
		this.setTitle("KOSMO문고에 오신 것을 환영합니다.");					//JFrame 인스턴스 생성 및 창 제목 설정
		this.setContentPane(new MyPanel());
		this.setLayout(null);
		this.setSize(1300,1000);
		
		//타이틀 설정
		lbl.setHorizontalAlignment(JLabel.CENTER);					//타이틀 가운데 정렬
		lbl.setFont(new Font("Bauhaus 93",Font.BOLD,60));			//폰트 설정
		lbl.setBounds(400, 50, 500, 60);							//타이틀 배치
		lbl.addMouseListener(this);
		lbl.setCursor(csr);
		this.getContentPane().add(lbl);								//프레임에 추가
		
		//하단 안내문구 설정
		lbl_advice.setFont(new Font("바탕체",Font.PLAIN,12));
		lbl_advice.setBounds(50, 805, 1000, 15);
		this.getContentPane().add(lbl_advice);
		jlb_bname.setFont(new Font("바탕체",Font.PLAIN,16));
		jlb_bname.setBounds(50, 830, 150, 20);
		jlb_bprice.setFont(new Font("바탕체",Font.PLAIN,16));
		jlb_bprice.setBounds(50, 860, 150, 20);
		jlb_bname_sel.setFont(new Font("바탕체",Font.BOLD,16));
		jlb_bname_sel.setBounds(170, 830, 800, 20);
		jlb_bprice_sel.setFont(new Font("바탕체",Font.BOLD,16));
		jlb_bprice_sel.setBounds(185, 860, 800, 20);
		this.getContentPane().add(jlb_bname);
		this.getContentPane().add(jlb_bprice);
		this.getContentPane().add(jlb_bname_sel);
		this.getContentPane().add(jlb_bprice_sel);
		
		//프레임에 콤보박스 넣기
		combo.setBounds(50, 140, 100, 20);
		combo.setBackground(Color.WHITE);
		this.add(combo);
		
		//텍스트필드 넣기
		jtf.setBounds(160, 140, 980, 20);
		jtf.setText("이곳에 검색하고자 하는 키워드를 입력하세요.");
		jtf.addKeyListener(this);
		jtf.addMouseListener(this);
		this.add(jtf);
		
		//버튼 설정 및 삽입
		jbtn_search.setBounds(1150, 140, 100, 20);
		jbtn_search.setBackground(Color.WHITE);
		jbtn_search.addActionListener(this);
		this.add(jbtn_search);
		jbtn_this_close.setBounds(1050, 805, 200, 20);
		jbtn_this_close.setBackground(Color.WHITE);
		jbtn_this_close.addActionListener(this);
		this.add(jbtn_this_close);
		
		//table이 들어갈 공간
		jtb_book.addMouseListener(this);
		jtb_book.addKeyListener(this);
//		jtb_book.setEnabled(false);		//select row가 안됨. 테이블이 아예 비활성화됨.
		jtb_book.getTableHeader().setReorderingAllowed(false);
		jsp_book.setBounds(50, 170, 1200, 630);
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		resizeColumnWidth(jtb_book);
		this.add("Center", jsp_book);
		
		//구입버튼
		jbtn_purchase.setBackground(Color.WHITE);
		jbtn_purchase.setBounds(1050, 835, 200, 80);
		this.add(jbtn_purchase);
		
		//테이블 더블클릭 시 DetailView 호출
		jtb_book.addMouseListener(new MouseAdapter() {
		});
		
		this.setVisible(true);
	}
	
	//테이블 column의 너비 자동조절
	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 50; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width +1 , width); 
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
	
	//검색어와 테이블의 값을 비교하는 메소드
	public void search() {
		if(combo.getSelectedItem().toString() == "도서명") {
			
			String	sql_search 	= "SELECT b.booknum, b.class, b.bookname"
								+ ", b.author, b.publisher, b.pdate, b.sprice"
								+ ", i.inventory, i.loc FROM BOOKMGR b, INVENTORYTBL i"
								+ " WHERE b.booknum = i.booknum"
								+ " AND b.bookname LIKE \'%\'||?||\'%\'";
			
			try {
				con 	= dbMgr.getConnection();
				pstmt 	= con.prepareStatement(sql_search);
				pstmt.setString(1, jtf.getText());
				rs 		= pstmt.executeQuery();
				
				while(dtm_book.getRowCount()>0) {
					dtm_book.removeRow(0);
				}
				
				vecBVO = new Vector<BookVO>();
				
				while(rs.next()) {
					bVO = new BookVO();
					bVO.setBooknum(rs.getString("BOOKNUM"));
					bVO.setParti(rs.getString("CLASS"));
					bVO.setBookname(rs.getString("BOOKNAME"));
					bVO.setAuthor(rs.getString("AUTHOR"));
					bVO.setPublisher(rs.getString("PUBLISHER"));
					bVO.setPdate(rs.getInt("PDATE"));
					bVO.setSprice(rs.getInt("SPRICE"));
					bVO.setInven(rs.getInt("INVENTORY"));
					bVO.setLoc(rs.getString("LOC"));
					vecBVO.add(bVO);
				}
				for (int i = 0; i < vecBVO.size(); i++) {
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(vecBVO.get(i).getBooknum());
					oneRow.add(vecBVO.get(i).getParti());
					oneRow.add(vecBVO.get(i).getBookname());
					oneRow.add(vecBVO.get(i).getAuthor());
					oneRow.add(vecBVO.get(i).getPublisher());
					oneRow.add(vecBVO.get(i).getPdate());
					oneRow.add(vecBVO.get(i).getSprice()+" 원");
					dtm_book.addRow(oneRow);
				}
			} catch (Exception e) {
			}
			dbMgr.freeConnection(con, pstmt, rs);
		}
		else if(combo.getSelectedItem().toString() == "도서번호") {
			
			String	sql_search 	= "SELECT b.booknum, b.class, b.bookname"
								+ ", b.author, b.publisher, b.pdate, b.sprice"
								+ ", i.inventory, i.loc FROM BOOKMGR b, INVENTORYTBL i"
								+ " WHERE b.booknum = i.booknum"
								+ " AND b.booknum LIKE \'%\'||?||\'%\'";
			
			try {
				con 	= dbMgr.getConnection();
				pstmt 	= con.prepareStatement(sql_search);
				pstmt.setString(1, jtf.getText());
				rs 		= pstmt.executeQuery();		//이 부분에서 실행이 안되고 catch로 넘어감. WHY?////////////////////////////////////////////////////////////////
				while(dtm_book.getRowCount()>0) {
					dtm_book.removeRow(0);
				}
				vecBVO = new Vector<BookVO>();
				
				while(rs.next()) {
					bVO = new BookVO();
					bVO.setBooknum(rs.getString("BOOKNUM"));
					bVO.setParti(rs.getString("CLASS"));
					bVO.setBookname(rs.getString("BOOKNAME"));
					bVO.setAuthor(rs.getString("AUTHOR"));
					bVO.setPublisher(rs.getString("PUBLISHER"));
					bVO.setPdate(rs.getInt("PDATE"));
					bVO.setSprice(rs.getInt("SPRICE"));
					bVO.setInven(rs.getInt("INVENTORY"));
					bVO.setLoc(rs.getString("LOC"));
					vecBVO.add(bVO);
				}
				for (int i = 0; i < vecBVO.size(); i++) {
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(vecBVO.get(i).getBooknum());
					oneRow.add(vecBVO.get(i).getParti());
					oneRow.add(vecBVO.get(i).getBookname());
					oneRow.add(vecBVO.get(i).getAuthor());
					oneRow.add(vecBVO.get(i).getPublisher());
					oneRow.add(vecBVO.get(i).getPdate());
					oneRow.add(vecBVO.get(i).getSprice()+" 원");
					dtm_book.addRow(oneRow);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "숫자만 입력하세요.");
			}
			dbMgr.freeConnection(con, pstmt, rs);
		}
		else if(combo.getSelectedItem().toString() == "저자") {
			
			String	sql_search 	= "SELECT b.booknum, b.class, b.bookname"
								+ ", b.author, b.publisher, b.pdate, b.sprice"
								+ ", i.inventory, i.loc FROM BOOKMGR b, INVENTORYTBL i"
								+ " WHERE b.booknum = i.booknum"
								+ " AND b.author LIKE \'%\'||?||\'%\'";
			
			try {
				con 	= dbMgr.getConnection();
				pstmt 	= con.prepareStatement(sql_search);
				pstmt.setString(1, jtf.getText());
				rs 		= pstmt.executeQuery();
				
				while(dtm_book.getRowCount()>0) {
					dtm_book.removeRow(0);
				}
				
				vecBVO = new Vector<BookVO>();
				
				while(rs.next()) {
					bVO = new BookVO();
					bVO.setBooknum(rs.getString("BOOKNUM"));
					bVO.setParti(rs.getString("CLASS"));
					bVO.setBookname(rs.getString("BOOKNAME"));
					bVO.setAuthor(rs.getString("AUTHOR"));
					bVO.setPublisher(rs.getString("PUBLISHER"));
					bVO.setPdate(rs.getInt("PDATE"));
					bVO.setSprice(rs.getInt("SPRICE"));
					bVO.setInven(rs.getInt("INVENTORY"));
					bVO.setLoc(rs.getString("LOC"));
					vecBVO.add(bVO);
				}
				for (int i = 0; i < vecBVO.size(); i++) {
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(vecBVO.get(i).getBooknum());
					oneRow.add(vecBVO.get(i).getParti());
					oneRow.add(vecBVO.get(i).getBookname());
					oneRow.add(vecBVO.get(i).getAuthor());
					oneRow.add(vecBVO.get(i).getPublisher());
					oneRow.add(vecBVO.get(i).getPdate());
					oneRow.add(vecBVO.get(i).getSprice()+" 원");
					dtm_book.addRow(oneRow);
				}
			} catch (Exception e) {
			}
			dbMgr.freeConnection(con, pstmt, rs);
		}
		else if(combo.getSelectedItem().toString() == "출판사") {
			
			String	sql_search 	= "SELECT b.booknum, b.class, b.bookname"
								+ ", b.author, b.publisher, b.pdate, b.sprice"
								+ ", i.inventory, i.loc FROM BOOKMGR b, INVENTORYTBL i"
								+ " WHERE b.booknum = i.booknum"
								+ " AND b.publisher LIKE \'%\'||?||\'%\'";
			
			try {
				con 	= dbMgr.getConnection();
				pstmt 	= con.prepareStatement(sql_search);
				pstmt.setString(1, jtf.getText());
				rs 		= pstmt.executeQuery();
				
				while(dtm_book.getRowCount()>0) {
					dtm_book.removeRow(0);
				}
				
				vecBVO = new Vector<BookVO>();
				
				while(rs.next()) {
					bVO = new BookVO();
					bVO.setBooknum(rs.getString("BOOKNUM"));
					bVO.setParti(rs.getString("CLASS"));
					bVO.setBookname(rs.getString("BOOKNAME"));
					bVO.setAuthor(rs.getString("AUTHOR"));
					bVO.setPublisher(rs.getString("PUBLISHER"));
					bVO.setPdate(rs.getInt("PDATE"));
					bVO.setSprice(rs.getInt("SPRICE"));
					bVO.setInven(rs.getInt("INVENTORY"));
					bVO.setLoc(rs.getString("LOC"));
					vecBVO.add(bVO);
				}
				for (int i = 0; i < vecBVO.size(); i++) {
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(vecBVO.get(i).getBooknum());
					oneRow.add(vecBVO.get(i).getParti());
					oneRow.add(vecBVO.get(i).getBookname());
					oneRow.add(vecBVO.get(i).getAuthor());
					oneRow.add(vecBVO.get(i).getPublisher());
					oneRow.add(vecBVO.get(i).getPdate());
					oneRow.add(vecBVO.get(i).getSprice()+" 원");
					dtm_book.addRow(oneRow);
				}
			} catch (Exception e) {
			}
			dbMgr.freeConnection(con, pstmt, rs);
		}
	}
	
	
	//row 선택 시, 해당 도서명과 가격을 보여주는 메소드
	public void clickShowInfo(int sel_row) {
		jlb_bname.setText("선택한 도서명: ");
		jlb_bprice.setText("선택한 도서가격: ");
		jlb_bname_sel.setText(vecBVO.get(sel_row).getBookname());
		jlb_bprice_sel.setText(Integer.toString(vecBVO.get(sel_row).getSprice())+"원");
	}
	
	/////////////////////////////////////////이하 MouseListener 인터페이스의 메소드 오버라이딩//////////////////////////////////////
	@Override
	public void mouseClicked(MouseEvent me) {
		Object obj = me.getSource();
		if(me.getClickCount()==2 && obj==jtb_book) {
			new DetailView().set(vecBVO, jtb_book.getSelectedRow());
		}
		else if(me.getClickCount()==1 && obj==jtb_book) {
			clickShowInfo(jtb_book.getSelectedRow());
		}
		else if(me.getClickCount()==1 && obj==jtf) {
			jtf.setText("");
		}
		else if(obj == lbl) {
			while(dtm_book.getRowCount()>0) {
				dtm_book.removeRow(0);
			}
			tableYOSO();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent pe) {
		//아래 방향키로 행을 옮겨 선택했을 때
		if(pe.getKeyCode()==KeyEvent.VK_DOWN) {
			if(jtb_book.getSelectedRow()+2 > vecBVO.size()) {
				JOptionPane.showMessageDialog(this, "마지막 자료입니다.");
			}
			else {
				clickShowInfo(jtb_book.getSelectedRow()+1);
			}
		}
		//위 방향키로 행을 옮겨 선택했을 때
		else if(pe.getKeyCode()==KeyEvent.VK_UP) {
			if(jtb_book.getSelectedRow() >= 1) {
				clickShowInfo(jtb_book.getSelectedRow()-1);
			}
			else {
				JOptionPane.showMessageDialog(this, "첫 번째 자료입니다.");
			}
		}
		else if(pe.getKeyCode()==KeyEvent.VK_ENTER) {
			search();
		}
	}

	@Override
	public void keyReleased(KeyEvent re) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == jbtn_search) {
			search();
		}
		else if(obj == jbtn_this_close) {
			this.dispose();
			new MainView();
		}
	}
}
