package Board;

//보드 프레임 클래스
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Mains1.Mainscreen;
import Post.Read;

// 실행시켜서 가운데 아래 검색기능 오류 고치기 
// 왜 뜨는지 납득이 안됨 
// 이거만 고치고 인터페이스 수정만 하면 얼추 게시판 게시글은 다 될듯
// 해결 빨리 되면 추천수랑 조회수 바로 업데이트 되게 

public class Boardset extends ConnectionB implements ActionListener, WindowListener {
	public JFrame f;
	private JButton np, search2, before, after, logo, click;
	private JLabel board, writer, writing, date, recommend, check, page, writer2, writing2, date2, recommend2, check2;
	private TextField search;
	private JPanel main;
	private Choice category;
	private JLabel writingno_1, writingno_2, writingno_3, writingno_4, writingno_5, writingno_6, writingno_7,
			writingno_8, writingno_9, writingno_10, dateno_1, dateno_2, dateno_3, dateno_4, dateno_5, dateno_6,
			dateno_7, dateno_8, dateno_9, dateno_10, blikes_1, blikes_2, blikes_3, blikes_4, blikes_5, blikes_6,
			blikes_7, blikes_8, blikes_9, blikes_10, clickno_1, clickno_2, clickno_3, clickno_4, clickno_5, clickno_6,
			clickno_7, clickno_8, clickno_9, clickno_10, bcno_1, bcno_2, bcno_3, bcno_4, bcno_5, bcno_6, bcno_7, bcno_8,			bcno_9, bcno_10;
	private JButton titleno_1, titleno_2, titleno_3, titleno_4, titleno_5, titleno_6, titleno_7, titleno_8, titleno_9,
			titleno_10;
	private int pageno = 1, pageplus = 0;
	private String[] show; // 카테고리 혹은
	private String[] show2;
	private String[] look;
	private String[] look2;
	private String[] search4;
	private String[] search5;
	private String[] research4;
	private String[] research5;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	String want3, backwant=null, want=null,num=null;
	int plz = 0;
	int list = 0;
	int bcno;
	int cnt = 0;
	
	// 이미지크기조절셋업
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	public Boardset() {
		 Color gr = new Color(205, 250, 219);
			
			Font font = new Font("MD아롱체", Font.BOLD, 50); // 게시판
			Font font2 = new Font("맑은 고딕", Font.ITALIC, 20); // 작성자 내용 날짜 추천수 조회수 카테고리
			Font font3 = new Font("MD아롱체", Font.BOLD, 20);
			Font font4 = new Font("맑은 고딕", Font.BOLD, 20);
			
		f = new JFrame("게시판");
		f.getContentPane().setBackground(Color.white);

		f.setFont(font);
// 		logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));

//		JLabel jLabel = new JLabel();
//		java.net.URL imageUrl1 = getClass().getResource("/img/logo.jpg");
//		jLabel.setIcon(new ImageIcon(getClass().getResource("/img/logo1.jpg")));// bin폴더 넘어가면 안되는듯?
		
		ImageIcon imgTest = new ImageIcon(getClass().getResource("../img/logo1.jpg"));
		imgTest = imageSetSize(imgTest, 99, 99);
		logo = new JButton(imgTest);

		logo.setBorderPainted(false);
		logo.setFocusPainted(false);
		logo.setContentAreaFilled(false);
		logo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Mainscreen main = new Mainscreen();
				main.excute();
			}
		});


		
		
		np = new JButton("새글작성");
		np.addActionListener(this);
		np.setFont(font3);
		np.setContentAreaFilled(false);
		
		//ImageIcon search3 = new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/test/search2.jpg");
		search2 = new JButton("★");// 검색 버튼
		search2.setContentAreaFilled(false);
		search2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		search2.addActionListener(this);

		//ImageIcon before1 = new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/test/before.jpg");
		before = new JButton("◀");
		before.setContentAreaFilled(false);
		before.addActionListener(this);
		before.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		before.setVisible(false);
		// before.setBorderPainted(false); //내부
		// before.setFocusPainted(false); //초점 잡히냐
		// before.setContentAreaFilled(false); //테두리

		//ImageIcon after1 = new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/test/after.jpg");
		after = new JButton("▶");
		after.setContentAreaFilled(false);
		after.addActionListener(this);
		after.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		// after.setBorderPainted(false);
		// after.setFocusPainted(false);
		// after.setContentAreaFilled(false);

		click = new JButton("조회");
		click.setFont(font2);

		board = new JLabel("게시판");
		board.setFont(font);
		page = new JLabel("페이지");
		page.setFont(font3);
		page.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		page.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬

		writing = new JLabel("제목");
		writing.setFont(font2);
		
		writing2 = new JLabel();
		writing2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
//		writing2.setFont(font4);
		
		date = new JLabel("날짜");
		date.setFont(font2);
		date2 = new JLabel();
		date2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));

		recommend = new JLabel("추천수");
		recommend.setFont(font2);
		recommend2 = new JLabel();
		recommend2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));

		check = new JLabel("조회수");
		check.setFont(font2);
		check2 = new JLabel();
		check2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));

		category = new Choice();
		category.add("Total");
		category.add("Exercise");
		category.add("Food");
		category.add("Sleep");
		category.setFont(font2);

		main = new JPanel();
		main.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));

		search = new TextField();
		search.setFont(font2);
		// search.setEditable(false); 텍스트창 편집불가능하게 바꿔

		f.getContentPane().setLayout(null);
		f.setSize(800, 800);

		// 창닫기
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				int resp = JOptionPane.showConfirmDialog(f, "정말 로그아웃 하시겠습니까?", "Exit?", JOptionPane.YES_NO_OPTION);

				if (resp == JOptionPane.YES_OPTION) {
//               f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} else {
					f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		f.setLocationRelativeTo(null);
		np.addActionListener(this);

		board.setSize(200, 100); // x 클수록 오른쪽 y 클수록 아래로
		board.setLocation(320, 10); // 게시판 라벨

		logo.setSize(100, 100); // 로고
		logo.setLocation(650, 10);

		np.setSize(120, 30); // 새글작성
		np.setLocation(7, 700);

		writing.setSize(100, 100); // 내용
		writing.setLocation(300, 115);
		writing2.setSize(450, 30);
		writing2.setLocation(98, 150);

		date.setSize(100, 100); // 날짜
		date.setLocation(564, 115);
		date2.setSize(80, 30);
		date2.setLocation(546, 150);

		recommend.setSize(100, 100); // 추천수
		recommend.setLocation(634, 115);
		recommend2.setSize(85, 30);
		recommend2.setLocation(624, 150);

		check.setSize(100, 100); // 조회수
		check.setLocation(717, 115);
		check2.setSize(76, 30);
		check2.setLocation(707, 150);

		main.setSize(784, 530); // 내용들어갈 예정
		main.setLocation(0, 150);
		main.setBackground(gr);
		
		search.setSize(200, 30); // 검색창
		search.setLocation(285, 730);

		search2.setSize(50, 30); // 검색버튼
		search2.setLocation(485, 730);

		category.setSize(200, 100); // 카테고리
		category.setLocation(10, 100);

		page.setSize(70, 30); // 페이지 라벨
		page.setLocation(350, 685);

		before.setSize(50, 30); // 이전
		before.setLocation(300, 685);

		after.setSize(50, 30); // 다음
		after.setLocation(420, 685);
		after.setVisible(false);

		click.setSize(100, 50); // 조회버튼
		
		click.setLocation(650, 700);
		click.addActionListener(this);
		click.setContentAreaFilled(false);
		click.setFont(font3);

		f.getContentPane().add(click);
		// f.add(userList);
		f.getContentPane().add(click);
		f.getContentPane().add(check2);
		f.getContentPane().add(recommend2);
		f.getContentPane().add(date2);
		f.getContentPane().add(writing2);
		f.getContentPane().add(after);
		f.getContentPane().add(before);
		f.getContentPane().add(page);
		f.getContentPane().add(category);
		f.getContentPane().add(check);
		f.getContentPane().add(recommend);
		f.getContentPane().add(writing);
		f.getContentPane().add(date);
		f.getContentPane().add(search2);
		f.getContentPane().add(search);
		f.getContentPane().add(np);
		f.getContentPane().add(main);
		main.setLayout(null);

		// 여기부터
		writingno_1 = new JLabel(""); // 1번글
		writingno_1.setBounds(0, 28, 100, 52);
		writingno_1.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_1.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_1);

		writer = new JLabel("작성자"); // 보여지는거
		writer.setBounds(12, -38, 100, 100);
		main.add(writer);
		writer.setFont(font2);
		writer2 = new JLabel(); // 겉에 테두리
		writer2.setBounds(0, 0, 100, 30);
		main.add(writer2);
		writer2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));

		writingno_2 = new JLabel("");
		writingno_2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_2.setBounds(0, 78, 100, 52);
		writingno_2.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_2);

		writingno_3 = new JLabel("");
		writingno_3.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_3.setBounds(0, 128, 100, 52);
		writingno_3.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_3);

		writingno_4 = new JLabel("");
		writingno_4.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_4.setBounds(0, 178, 100, 52);
		writingno_4.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_4);

		writingno_5 = new JLabel("");
		writingno_5.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_5.setBounds(0, 228, 100, 52);
		writingno_5.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_5);

		writingno_6 = new JLabel("");
		writingno_6.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_6.setBounds(0, 278, 100, 52);
		writingno_6.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_6);

		writingno_7 = new JLabel("");
		writingno_7.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_7.setBounds(0, 328, 100, 52);
		writingno_7.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_7);

		writingno_8 = new JLabel("");
		writingno_8.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_8.setBounds(0, 378, 100, 52);
		writingno_8.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_8);

		writingno_9 = new JLabel("");
		writingno_9.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_9.setBounds(0, 428, 100, 52);
		writingno_9.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_9);

		writingno_10 = new JLabel("");
		writingno_10.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		writingno_10.setBounds(0, 478, 100, 52);
		writingno_10.setHorizontalAlignment(JLabel.CENTER);
		main.add(writingno_10);

		dateno_1 = new JLabel(""); // 1번글 날짜
		dateno_1.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_1.setBounds(546, 28, 80, 52);
		main.add(dateno_1);

		dateno_2 = new JLabel("");
		dateno_2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_2.setBounds(546, 78, 80, 52);
		main.add(dateno_2);

		dateno_3 = new JLabel("");
		dateno_3.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_3.setBounds(546, 128, 80, 52);
		main.add(dateno_3);

		dateno_4 = new JLabel("");
		dateno_4.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_4.setBounds(546, 178, 80, 52);
		main.add(dateno_4);

		dateno_5 = new JLabel("");
		dateno_5.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_5.setBounds(546, 228, 80, 52);
		main.add(dateno_5);

		dateno_6 = new JLabel("");
		dateno_6.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_6.setBounds(546, 278, 80, 52);
		main.add(dateno_6);

		dateno_7 = new JLabel("");
		dateno_7.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_7.setBounds(546, 328, 80, 52);
		main.add(dateno_7);

		dateno_8 = new JLabel("");
		dateno_8.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_8.setBounds(546, 378, 80, 52);
		main.add(dateno_8);

		dateno_9 = new JLabel("");
		dateno_9.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_9.setBounds(546, 428, 80, 52);
		main.add(dateno_9);

		dateno_10 = new JLabel("");
		dateno_10.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		dateno_10.setBounds(546, 478, 80, 52);
		main.add(dateno_10);

		blikes_1 = new JLabel(""); // 1번글 추천수
		blikes_1.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_1.setBounds(624, 28, 85, 52);
		blikes_1.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_1);

		blikes_2 = new JLabel("");
		blikes_2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_2.setBounds(624, 78, 85, 52);
		blikes_2.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_2);

		blikes_3 = new JLabel("");
		blikes_3.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_3.setBounds(624, 128, 85, 52);
		blikes_3.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_3);

		blikes_4 = new JLabel("");
		blikes_4.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_4.setBounds(624, 178, 85, 52);
		blikes_4.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_4);

		blikes_5 = new JLabel("");
		blikes_5.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_5.setBounds(624, 228, 85, 52);
		blikes_5.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_5);

		blikes_6 = new JLabel("");
		blikes_6.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_6.setBounds(624, 278, 85, 52);
		blikes_6.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_6);

		blikes_7 = new JLabel("");
		blikes_7.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_7.setBounds(624, 328, 85, 52);
		blikes_7.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_7);

		blikes_8 = new JLabel("");
		blikes_8.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_8.setBounds(624, 378, 85, 52);
		blikes_8.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_8);

		blikes_9 = new JLabel("");
		blikes_9.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_9.setBounds(624, 428, 85, 52);
		blikes_9.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_9);

		blikes_10 = new JLabel("");
		blikes_10.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		blikes_10.setBounds(624, 478, 85, 52);
		blikes_10.setHorizontalAlignment(JLabel.CENTER);
		main.add(blikes_10);

		clickno_1 = new JLabel(""); // 1번글 조회수
		clickno_1.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_1.setBounds(707, 28, 76, 52);
		clickno_1.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_1);

		clickno_2 = new JLabel("");
		clickno_2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_2.setBounds(707, 78, 76, 52);
		clickno_2.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_2);

		clickno_3 = new JLabel("");
		clickno_3.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_3.setBounds(707, 128, 76, 52);
		clickno_3.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_3);

		clickno_4 = new JLabel("");
		clickno_4.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_4.setBounds(707, 178, 76, 52);
		clickno_4.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_4);

		clickno_5 = new JLabel("");
		clickno_5.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_5.setBounds(707, 228, 76, 52);
		clickno_5.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_5);

		clickno_6 = new JLabel("");
		clickno_6.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_6.setBounds(707, 278, 76, 52);
		clickno_6.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_6);

		clickno_7 = new JLabel("");
		clickno_7.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_7.setBounds(707, 328, 76, 52);
		clickno_7.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_7);

		clickno_8 = new JLabel("");
		clickno_8.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_8.setBounds(707, 378, 76, 52);
		clickno_8.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_8);

		clickno_9 = new JLabel("");
		clickno_9.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_9.setBounds(707, 428, 76, 52);
		clickno_9.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_9);

		clickno_10 = new JLabel("");
		clickno_10.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		clickno_10.setBounds(707, 478, 76, 52);
		clickno_10.setHorizontalAlignment(JLabel.CENTER);
		main.add(clickno_10);

		titleno_1 = new JButton(""); // 1번글 내용
		titleno_1.setBounds(98, 28, 450, 52);
		titleno_1.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_1.setContentAreaFilled(false);
		titleno_1.setFont(font4);
		main.add(titleno_1);
		titleno_1.addActionListener(new ActionListener() { // 1번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_1.getText()==null) {
					
				}else {
			
				plz = Integer.parseInt(bcno_1.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					// System.out.println(getRs());
					f.dispose();
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}});

		titleno_2 = new JButton("");
		titleno_2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_2.setBounds(98, 78, 450, 52);
		titleno_2.setContentAreaFilled(false);
		titleno_2.setFont(font4);
		main.add(titleno_2);
		titleno_2.addActionListener(new ActionListener() { // 2번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_2.getText().equals(null)) {
					
				}else {
			
				plz = Integer.parseInt(bcno_2.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					f.dispose();
					// System.out.println(getRs());
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}});

		titleno_3 = new JButton("");
		titleno_3.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_3.setBounds(98, 128, 450, 52);
		titleno_3.setContentAreaFilled(false);
		titleno_3.setFont(font4);
		main.add(titleno_3);
		titleno_3.addActionListener(new ActionListener() { // 3번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_3.getText().equals(null)) {
					
				}else {
			
				plz = Integer.parseInt(bcno_3.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					f.dispose();
					// System.out.println(getRs());
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}});

		titleno_4 = new JButton("");
		titleno_4.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_4.setBounds(98, 178, 450, 52);
		titleno_4.setContentAreaFilled(false);
		titleno_4.setFont(font4);
		main.add(titleno_4);
		titleno_4.addActionListener(new ActionListener() { // 4번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_4.getText()==null) {
					
				}else {
				plz = Integer.parseInt(bcno_4.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					
					// System.out.println(getRs());
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					f.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}});

		titleno_5 = new JButton("");
		titleno_5.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_5.setBounds(98, 228, 450, 52);
		titleno_5.setContentAreaFilled(false);
		titleno_5.setFont(font4);
		main.add(titleno_5);
		titleno_5.addActionListener(new ActionListener() { // 5번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_5.getText()==null) {
					
				}else {
				plz = Integer.parseInt(bcno_5.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					// System.out.println(getRs());
					f.dispose();
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}});
		titleno_6 = new JButton("");
		titleno_6.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_6.setBounds(98, 278, 450, 52);
		titleno_6.setContentAreaFilled(false);
		titleno_6.setFont(font4);
		main.add(titleno_6);
		titleno_6.addActionListener(new ActionListener() { // 6번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_6.getText()==null) {
					
				}else {
				plz = Integer.parseInt(bcno_6.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					f.dispose();
					// System.out.println(getRs());
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}})	;

		titleno_7 = new JButton("");
		titleno_7.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_7.setBounds(98, 328, 450, 52);
		titleno_7.setContentAreaFilled(false);
		titleno_7.setFont(font4);
		main.add(titleno_7);
		titleno_7.addActionListener(new ActionListener() { // 7번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_7.getText()==null) {
					
				}else {
				plz = Integer.parseInt(bcno_7.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					f.dispose();
					// System.out.println(getRs());
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}});

		titleno_8 = new JButton("");
		titleno_8.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_8.setBounds(98, 378, 450, 52);
		titleno_8.setContentAreaFilled(false);
		titleno_8.setFont(font4);
		main.add(titleno_8);
		titleno_8.addActionListener(new ActionListener() { // 8번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_8.getText()==null) {
					
				}else {
				plz = Integer.parseInt(bcno_8.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					// System.out.println(getRs());
					f.dispose();
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}});

		titleno_9 = new JButton("");
		titleno_9.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_9.setBounds(98, 428, 450, 52);
		titleno_9.setContentAreaFilled(false);
		titleno_9.setFont(font4);
		main.add(titleno_9);
		titleno_9.addActionListener(new ActionListener() { // 9번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_9.getText()==null) {
					
				}else {
				plz = Integer.parseInt(bcno_9.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					// System.out.println(getRs());
					f.dispose();
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}});

		titleno_10 = new JButton("");
		titleno_10.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_10.setBounds(98, 478, 450, 52);
		titleno_10.setContentAreaFilled(false);
		titleno_10.setFont(font4);
		main.add(titleno_10);
		titleno_10.addActionListener(new ActionListener() { // 10번글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleno_10.getText()==null) {
					
				}else {
				plz = Integer.parseInt(bcno_10.getText());

				try {
					String sql = "" + "select bcno,bctitle,bcviews " + "from BCONTENTS " + "where BCTITLE = " + "'"
							+ plz + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					// System.out.println(getRs());
					f.dispose();
					Read read = new Read(plz);
					read.showFrame(plz);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					String sql = "" + "update bcontents " + "set BCVIEWS = BCVIEWS +1 " + "where BCNO = " + "'" + plz
							+ "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
				f.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}});

		bcno_1 = new JLabel("");
		f.add(bcno_1);
		bcno_1.setBounds(100, 100, 50, 50);
		bcno_2 = new JLabel("");
		f.add(bcno_2);
		bcno_3 = new JLabel("");
		f.add(bcno_3);
		bcno_4 = new JLabel("");
		f.add(bcno_4);
		bcno_5 = new JLabel("");
		f.add(bcno_5);
		bcno_6 = new JLabel("");
		f.add(bcno_6);
		bcno_7 = new JLabel("");
		f.add(bcno_7);
		bcno_8 = new JLabel("");
		f.add(bcno_8);
		bcno_9 = new JLabel("");
		f.add(bcno_9);
		bcno_10 = new JLabel("");
		f.add(bcno_10);

		f.getContentPane().add(logo);
		f.getContentPane().add(board);
if (f.isVisible()) {
           f.setVisible(false);
       } else {
		f.setVisible(true);
		list();
	}
       
 }
	public void list() { // 카테고리 없을때(전체)
		if(pageno<0) {
			pageno=0;
		}
		if(pageplus <0) {
			pageplus =0;
		}
		
		list = 1;
		num = category.getSelectedItem();
		int a = 0;
		String b = "";
		if (num.equals("Total")) {
			a = 0;
			b = Integer.toString(a);

			try {
				String sql = "" + "select user_id,bctitle,bcdate,bclikes,bcviews,bcno " + "from BCONTENTS "
						+ "order by bcdate DESC";
				ConnectionB cb = new ConnectionB(); // 연결
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				setRs(pstmt.executeQuery());

				int i = 0;
				int cnt = 0;
				show = new String[1000]; // 할때마다 초기화
				show2 = new String[1000];
				while (getRs().next()) {
					String user_id = getRs().getString("user_id");
					String bctitle = getRs().getString("bctitle");
					String bcdate = getRs().getString("bcdate");
					int bclikes = getRs().getInt("bclikes");
					int bcviews = getRs().getInt("bcviews");
					bcno = getRs().getInt("bcno");
					show[i] = (user_id + " " + bcdate + " " + bclikes + " " + bcviews + " " + bcno);
					show2[i] = (bctitle);
					// System.out.print(btitle+" "+bmain+" "+bdate+" "+busy+ "\n");
					i++;
				}
				if (i > 9) {
					after.setVisible(true);
				}
				if (pageno == 1) {
					before.setVisible(false);
				}
				// 0 1 2 3 4 5 6 7 8 9
				// 10 11 12
				if (show[0 + pageplus] != null) {
					writingno_1.setText(show[0 + pageplus].split(" ")[0]);
					titleno_1.setText(show2[0 + pageplus]);
					dateno_1.setText(show[0 + pageplus].split(" ")[1]); // 데이트가 2,3번을 먹음
					blikes_1.setText(show[0 + pageplus].split(" ")[3]);
					clickno_1.setText(show[0 + pageplus].split(" ")[4]);
					bcno_1.setText(show[0 + pageplus].split(" ")[5]);
					// System.out.println(bcno_1.getText());
				} else {
					writingno_1.setText("");
					titleno_1.setText("");
					dateno_1.setText(""); // 데이트가 2,3번을 먹음
					blikes_1.setText("");
					clickno_1.setText("");
					after.setVisible(false);
				}
				if (show[1 + pageplus] != null) {
					writingno_2.setText(show[1 + pageplus].split(" ")[0]);
					titleno_2.setText(show2[1 + pageplus]);
					dateno_2.setText(show[1 + pageplus].split(" ")[1]);
					blikes_2.setText(show[1 + pageplus].split(" ")[3]);
					clickno_2.setText(show[1 + pageplus].split(" ")[4]);
					bcno_2.setText(show[1 + pageplus].split(" ")[5]);
					// System.out.println(bcno_2.getText());
				} else {
					writingno_2.setText("");
					titleno_2.setText("");
					dateno_2.setText(""); // 데이트가 2,3번을 먹음
					blikes_2.setText("");
					clickno_2.setText("");
					after.setVisible(false);
				}

				if (show[2 + pageplus] != null) {
					writingno_3.setText(show[2 + pageplus].split(" ")[0]);
					titleno_3.setText(show2[2 + pageplus]);
					dateno_3.setText(show[2 + pageplus].split(" ")[1]);
					blikes_3.setText(show[2 + pageplus].split(" ")[3]);
					clickno_3.setText(show[2 + pageplus].split(" ")[4]);
					bcno_3.setText(show[2 + pageplus].split(" ")[5]);
					// System.out.println(bcno_3.getText());
				} else {
					writingno_3.setText("");
					titleno_3.setText("");
					dateno_3.setText(""); // 데이트가 2,3번을 먹음
					blikes_3.setText("");
					clickno_3.setText("");
					after.setVisible(false);
				}

				if (show[3 + pageplus] != null) {
					writingno_4.setText(show[3 + pageplus].split(" ")[0]);
					titleno_4.setText(show2[3 + pageplus]);
					dateno_4.setText(show[3 + pageplus].split(" ")[1]);
					blikes_4.setText(show[3 + pageplus].split(" ")[3]);
					clickno_4.setText(show[3 + pageplus].split(" ")[4]);
					bcno_4.setText(show[3 + pageplus].split(" ")[5]);
					// System.out.println(bcno_4.getText());
				} else {
					writingno_4.setText("");
					titleno_4.setText("");
					dateno_4.setText(""); // 데이트가 2,3번을 먹음
					blikes_4.setText("");
					clickno_4.setText("");
					after.setVisible(false);
				}

				if (show[4 + pageplus] != null) {
					writingno_5.setText(show[4 + pageplus].split(" ")[0]);
					titleno_5.setText(show2[4 + pageplus]);
					dateno_5.setText(show[4 + pageplus].split(" ")[1]);
					blikes_5.setText(show[4 + pageplus].split(" ")[3]);
					clickno_5.setText(show[4 + pageplus].split(" ")[4]);
					bcno_5.setText(show[4 + pageplus].split(" ")[5]);
					// System.out.println(bcno_5.getText());
				} else {
					writingno_5.setText("");
					titleno_5.setText("");
					dateno_5.setText(""); // 데이트가 2,3번을 먹음
					blikes_5.setText("");
					clickno_5.setText("");
					after.setVisible(false);
				}

				if (show[5 + pageplus] != null) {
					writingno_6.setText(show[5 + pageplus].split(" ")[0]);
					titleno_6.setText(show2[5 + pageplus]);
					dateno_6.setText(show[5 + pageplus].split(" ")[1]);
					blikes_6.setText(show[5 + pageplus].split(" ")[3]);
					clickno_6.setText(show[5 + pageplus].split(" ")[4]);
					bcno_6.setText(show[5 + pageplus].split(" ")[5]);
					// System.out.println(bcno_6.getText());
				} else {
					writingno_6.setText("");
					titleno_6.setText("");
					dateno_6.setText(""); // 데이트가 2,3번을 먹음
					blikes_6.setText("");
					clickno_6.setText("");
					after.setVisible(false);
				}

				if (show[6 + pageplus] != null) {
					writingno_7.setText(show[6 + pageplus].split(" ")[0]);
					titleno_7.setText(show2[6 + pageplus]);
					dateno_7.setText(show[6 + pageplus].split(" ")[1]);
					blikes_7.setText(show[6 + pageplus].split(" ")[3]);
					clickno_7.setText(show[6 + pageplus].split(" ")[4]);
					bcno_7.setText(show[6 + pageplus].split(" ")[5]);
					// System.out.println(bcno_7.getText());
				} else {
					writingno_7.setText("");
					titleno_7.setText("");
					dateno_7.setText(""); // 데이트가 2,3번을 먹음
					blikes_7.setText("");
					clickno_7.setText("");
					after.setVisible(false);
				}

				if (show[7 + pageplus] != null) {
					writingno_8.setText(show[7 + pageplus].split(" ")[0]);
					titleno_8.setText(show2[7 + pageplus]);
					dateno_8.setText(show[7 + pageplus].split(" ")[1]);
					blikes_8.setText(show[7 + pageplus].split(" ")[3]);
					clickno_8.setText(show[7 + pageplus].split(" ")[4]);
					bcno_8.setText(show[7 + pageplus].split(" ")[5]);
					// System.out.println(bcno_8.getText());
				} else {
					writingno_8.setText("");
					titleno_8.setText("");
					dateno_8.setText(""); // 데이트가 2,3번을 먹음
					blikes_8.setText("");
					clickno_8.setText("");
					after.setVisible(false);
				}

				if (show[8 + pageplus] != null) {
					writingno_9.setText(show[8 + pageplus].split(" ")[0]);
					titleno_9.setText(show2[8 + pageplus]);
					dateno_9.setText(show[8 + pageplus].split(" ")[1]);
					blikes_9.setText(show[8 + pageplus].split(" ")[3]);
					clickno_9.setText(show[8 + pageplus].split(" ")[4]);
					bcno_9.setText(show[8 + pageplus].split(" ")[5]);
					// System.out.println(bcno_9.getText());
				} else {
					writingno_9.setText("");
					titleno_9.setText("");
					dateno_9.setText(""); // 데이트가 2,3번을 먹음
					blikes_9.setText("");
					clickno_9.setText("");
					after.setVisible(false);
				}

				if (show[9 + pageplus] != null) {
					writingno_10.setText(show[9 + pageplus].split(" ")[0]);
					titleno_10.setText(show2[9 + pageplus]);
					dateno_10.setText(show[9 + pageplus].split(" ")[1]);
					blikes_10.setText(show[9 + pageplus].split(" ")[3]);
					clickno_10.setText(show[9 + pageplus].split(" ")[4]);
					bcno_10.setText(show[9 + pageplus].split(" ")[5]);
					// System.out.println(bcno_10.getText());
				} else {
					writingno_10.setText("");
					titleno_10.setText("");
					dateno_10.setText(""); // 데이트가 2,3번을 먹음
					blikes_10.setText("");
					clickno_10.setText("");
					after.setVisible(false);
				}

				// System.out.print(Arrays.toString(show));
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}

		} else {
			list2();
		}

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0); // 닫기 눌러서 창닫기
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

// <<<<<<< read_write
// // import Mains1.Mainscreen;

// =======
// 	}

// 	@Override
// 	public void windowIconified(WindowEvent e) {
// 		// TODO Auto-generated method stub
// >>>>>>> master

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	BoardWrite bw;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("새글작성")) {
			if (bw == null) {
				bw = new BoardWrite();
				f.dispose();
			} else {
				bw =null;
			}

		} else if (e.getSource() == click) { // 조회
			list();
		} else if (e.getSource() == before) {
			pageno = pageno - 1;
			pageplus = pageplus - 10;
			if (list == 1) {
				list();
			} else if (list == 2) {
				list2();
			}else if(list ==3) {
				list3();
			}

		} else if (e.getSource() == after) {
			before.setVisible(true);
			pageno = pageno + 1;
			pageplus = pageplus + 10;
			if (list == 1) {
				list();
			} else if (list == 2) {
				list2();
			} else if(list ==3) {
				list3();
			}

		} else if (e.getSource() == search2) { // 검색버튼---------------------------------------------------------------------------------------------------
		if(backwant==null) {
		backwant = search.getText();
		}else {
			backwant=null;
		}
		list3();
		}
	}
	
	
	
	
	
	
	
	
		public void list3() { //
			
			
			if(pageno<0) {
				pageno=0;
			}
			if(pageplus <0) {
				pageplus =0;
			}
			list=3;
			if(backwant==null) {
				want = search.getText(); // 텍스트필드
			}else {
				want = backwant;
			}
			String num = category.getSelectedItem();
			int a = 0;
			String b = "0";

			if (want.equals("")) {
				list2();
			} else if (num.equals("Total")) {
				search.setText("");
				try { // total 검색
					String sql = "" + "select user_id,bctitle,bcdate,bclikes,bcviews,bcno " + "from BCONTENTS "
							+ "where bctitle like " + "'" + "%" + want + "%" + "'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());

					int i = 0;
					search4 = new String[1000]; // 바꿀때마다 기존값 초기화
					search5 = new String[1000];

					while (getRs().next()) {
						String user_id = getRs().getString("user_id");
						String bctitle = getRs().getString("bctitle");
						String bcdate = getRs().getString("bcdate");
						int bclikes = getRs().getInt("bclikes");
						int bcviews = getRs().getInt("bcviews");
						int bano = getRs().getInt("bcno");
						search4[i] = (user_id + " " + bcdate + " " + bclikes + " " + bcviews + " "+ bcno);
						search5[i] = (bctitle);

						i++;
					}
					if (search4[i] == null) {
						after.setVisible(false);
					}
					if (pageno == 1) {
						before.setVisible(false);
					}
					if (i > 9) {
						after.setVisible(true);
					}
					if (search4[0 + pageplus] != null) {
						writingno_1.setText(search4[0 + pageplus].split(" ")[0]);
						titleno_1.setText(search5[0 + pageplus]);
						dateno_1.setText(search4[0 + pageplus].split(" ")[1]); // 데이트가 2,3번을 먹음
						blikes_1.setText(search4[0 + pageplus].split(" ")[3]);
						clickno_1.setText(search4[0 + pageplus].split(" ")[4]);
						bcno_1.setText(search4[0 + pageplus].split(" ")[5]);
					} else {
						writingno_1.setText("");
						titleno_1.setText("");
						dateno_1.setText(""); // 데이트가 2,3번을 먹음
						blikes_1.setText("");
						clickno_1.setText("");
						after.setVisible(false);
					}
					if (search4[1 + pageplus] != null) {
						writingno_2.setText(search4[1 + pageplus].split(" ")[0]);
						titleno_2.setText(search5[1 + pageplus]);
						dateno_2.setText(search4[1 + pageplus].split(" ")[1]);
						blikes_2.setText(search4[1 + pageplus].split(" ")[3]);
						clickno_2.setText(search4[1 + pageplus].split(" ")[4]);
						bcno_2.setText(search4[1 + pageplus].split(" ")[5]);
					} else {
						writingno_2.setText("");
						titleno_2.setText("");
						dateno_2.setText(""); // 데이트가 2,3번을 먹음
						blikes_2.setText("");
						clickno_2.setText("");
						after.setVisible(false);
					}

					if (search4[2 + pageplus] != null) {
						writingno_3.setText(search4[2 + pageplus].split(" ")[0]);
						titleno_3.setText(search5[2 + pageplus]);
						dateno_3.setText(search4[2 + pageplus].split(" ")[1]);
						blikes_3.setText(search4[2 + pageplus].split(" ")[3]);
						clickno_3.setText(search4[2 + pageplus].split(" ")[4]);
						bcno_3.setText(search4[2 + pageplus].split(" ")[5]);
					} else {
						writingno_3.setText("");
						titleno_3.setText("");
						dateno_3.setText(""); // 데이트가 2,3번을 먹음
						blikes_3.setText("");
						clickno_3.setText("");
						after.setVisible(false);
					}

					if (search4[3 + pageplus] != null) {
						writingno_4.setText(search4[3 + pageplus].split(" ")[0]);
						titleno_4.setText(search5[3 + pageplus]);
						dateno_4.setText(search4[3 + pageplus].split(" ")[1]);
						blikes_4.setText(search4[3 + pageplus].split(" ")[3]);
						clickno_4.setText(search4[3 + pageplus].split(" ")[4]);
						bcno_4.setText(search4[3 + pageplus].split(" ")[5]);
					} else {
						writingno_4.setText("");
						titleno_4.setText("");
						dateno_4.setText(""); // 데이트가 2,3번을 먹음
						blikes_4.setText("");
						clickno_4.setText("");
						after.setVisible(false);
					}

					if (search4[4 + pageplus] != null) {
						writingno_5.setText(search4[4 + pageplus].split(" ")[0]);
						titleno_5.setText(search5[4 + pageplus]);
						dateno_5.setText(search4[4 + pageplus].split(" ")[1]);
						blikes_5.setText(search4[4 + pageplus].split(" ")[3]);
						clickno_5.setText(search4[4 + pageplus].split(" ")[4]);
						bcno_5.setText(search4[4 + pageplus].split(" ")[5]);
					} else {
						writingno_5.setText("");
						titleno_5.setText("");
						dateno_5.setText(""); // 데이트가 2,3번을 먹음
						blikes_5.setText("");
						clickno_5.setText("");
						after.setVisible(false);
					}

					if (search4[5 + pageplus] != null) {
						writingno_6.setText(search4[5 + pageplus].split(" ")[0]);
						titleno_6.setText(search5[5 + pageplus]);
						dateno_6.setText(search4[5 + pageplus].split(" ")[1]);
						blikes_6.setText(search4[5 + pageplus].split(" ")[3]);
						clickno_6.setText(search4[5 + pageplus].split(" ")[4]);
						bcno_6.setText(search4[5 + pageplus].split(" ")[5]);
					} else {
						
						writingno_6.setText("");
						titleno_6.setText("");
						dateno_6.setText(""); // 데이트가 2,3번을 먹음
						blikes_6.setText("");
						clickno_6.setText("");
						after.setVisible(false);
					}

					if (search4[6 + pageplus] != null) {
						writingno_7.setText(search4[6 + pageplus].split(" ")[0]);
						titleno_7.setText(search5[6 + pageplus]);
						dateno_7.setText(search4[6 + pageplus].split(" ")[1]);
						blikes_7.setText(search4[6 + pageplus].split(" ")[3]);
						clickno_7.setText(search4[6 + pageplus].split(" ")[4]);
						bcno_7.setText(search4[6 + pageplus].split(" ")[5]);
					} else {
						writingno_7.setText("");
						titleno_7.setText("");
						dateno_7.setText(""); // 데이트가 2,3번을 먹음
						blikes_7.setText("");
						clickno_7.setText("");
						after.setVisible(false);
					}

					if (search4[7 + pageplus] != null) {
						writingno_8.setText(search4[7 + pageplus].split(" ")[0]);
						titleno_8.setText(search5[7 + pageplus]);
						dateno_8.setText(search4[7 + pageplus].split(" ")[1]);
						blikes_8.setText(search4[7 + pageplus].split(" ")[3]);
						clickno_8.setText(search4[7 + pageplus].split(" ")[4]);
						bcno_8.setText(search4[7 + pageplus].split(" ")[5]);
					} else {
						writingno_8.setText("");
						titleno_8.setText("");
						dateno_8.setText(""); // 데이트가 2,3번을 먹음
						blikes_8.setText("");
						clickno_8.setText("");
						after.setVisible(false);
					}

					if (search4[8 + pageplus] != null) {
						writingno_9.setText(search4[8 + pageplus].split(" ")[0]);
						titleno_9.setText(search5[8 + pageplus]);
						dateno_9.setText(search4[8 + pageplus].split(" ")[1]);
						blikes_9.setText(search4[8 + pageplus].split(" ")[3]);
						clickno_9.setText(search4[8 + pageplus].split(" ")[4]);
						bcno_9.setText(search4[8 + pageplus].split(" ")[5]);
					} else {
						writingno_9.setText("");
						titleno_9.setText("");
						dateno_9.setText(""); // 데이트가 2,3번을 먹음
						blikes_9.setText("");
						clickno_9.setText("");
						after.setVisible(false);
					}

					if (search4[9 + pageplus] != null) {
						writingno_10.setText(search4[9 + pageplus].split(" ")[0]);
						titleno_10.setText(search5[9 + pageplus]);
						dateno_10.setText(search4[9 + pageplus].split(" ")[1]);
						blikes_10.setText(search4[9 + pageplus].split(" ")[3]);
						clickno_10.setText(search4[9 + pageplus].split(" ")[4]);
						bcno_10.setText(search4[9 + pageplus].split(" ")[5]);
					} else {
						writingno_10.setText("");
						titleno_10.setText("");
						dateno_10.setText(""); // 데이트가 2,3번을 먹음
						blikes_10.setText("");
						clickno_10.setText("");
						after.setVisible(false);
					}

				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			} else { // 카테고리 +검색
				list=3;
				 if (num.equals("Exercise")) {
					a = 1;
					b = Integer.toString(a);
				} else if (num.equals("Food")) {
					a = 2;
					b = Integer.toString(a);
				} else if (num.equals("Sleep")) {
					a = 3;
					b = Integer.toString(a);
				}
				try { // 카테고리 검색
					String sql = " select user_id,bctitle,bcdate,bclikes,bcviews " + "from BCONTENTS " + "where bno = "
							+ b + " and bctitle like " + "'%" + want + "%'";
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					int i = 0;
					research4 = new String[1000]; // 바꿀때마다 기존값 초기화
					research5 = new String[1000];
					while (getRs().next()) {
						String user_id = getRs().getString("user_id");
						String bcdate = getRs().getString("bcdate");
						int bclikes = getRs().getInt("bclikes");
						int bcviews = getRs().getInt("bcviews");
						String bctitle = getRs().getString("bctitle");
						research4[i] = (user_id + " " + " " + bcdate + " " + bclikes + " " + bcviews);
						research5[i] = (bctitle);
						i++;
					}
					if (research4[i] == null) {
						after.setVisible(false);
					}
					if (pageno == 1) {
						before.setVisible(false);
					}
					if (i > 9) {
						after.setVisible(true);
					}
					if (research4[0 + pageplus] != null) {
						writingno_1.setText(research4[0 + pageplus].split(" ")[0]);
						titleno_1.setText(research5[0 + pageplus]);
						dateno_1.setText(research4[0 + pageplus].split(" ")[2]); // 데이트가 2,3번을 먹음
						blikes_1.setText(research4[0 + pageplus].split(" ")[4]);
						clickno_1.setText(research4[0 + pageplus].split(" ")[5]);
					} else {
						writingno_1.setText("");
						titleno_1.setText("");
						dateno_1.setText(""); // 데이트가 2,3번을 먹음
						blikes_1.setText("");
						clickno_1.setText("");
						after.setVisible(false);
					}
					if (research4[1 + pageplus] != null) {
						writingno_2.setText(research4[1 + pageplus].split(" ")[0]);
						titleno_2.setText(research5[1 + pageplus]);
						dateno_2.setText(research4[1 + pageplus].split(" ")[2]);
						blikes_2.setText(research4[1 + pageplus].split(" ")[4]);
						clickno_2.setText(research4[1 + pageplus].split(" ")[5]);
					} else {
						writingno_2.setText("");
						titleno_2.setText("");
						dateno_2.setText(""); // 데이트가 2,3번을 먹음
						blikes_2.setText("");
						clickno_2.setText("");
						after.setVisible(false);
					}

					if (research4[2 + pageplus] != null) {
						writingno_3.setText(research4[2 + pageplus].split(" ")[0]);
						titleno_3.setText(research5[2 + pageplus]);
						dateno_3.setText(research4[2 + pageplus].split(" ")[2]);
						blikes_3.setText(research4[2 + pageplus].split(" ")[4]);
						clickno_3.setText(research4[2 + pageplus].split(" ")[5]);
					} else {
						writingno_3.setText("");
						titleno_3.setText("");
						dateno_3.setText(""); // 데이트가 2,3번을 먹음
						blikes_3.setText("");
						clickno_3.setText("");
						after.setVisible(false);
					}

					if (research4[3 + pageplus] != null) {
						writingno_4.setText(research4[3 + pageplus].split(" ")[0]);
						titleno_4.setText(research5[3 + pageplus]);
						dateno_4.setText(research4[3 + pageplus].split(" ")[2]);
						blikes_4.setText(research4[3 + pageplus].split(" ")[4]);
						clickno_4.setText(research4[3 + pageplus].split(" ")[5]);
					} else {
						writingno_4.setText("");
						titleno_4.setText("");
						dateno_4.setText(""); // 데이트가 2,3번을 먹음
						blikes_4.setText("");
						clickno_4.setText("");
						after.setVisible(false);
					}

					if (research4[4 + pageplus] != null) {
						writingno_5.setText(research4[4 + pageplus].split(" ")[0]);
						titleno_5.setText(research5[4 + pageplus]);
						dateno_5.setText(research4[4 + pageplus].split(" ")[2]);
						blikes_5.setText(research4[4 + pageplus].split(" ")[4]);
						clickno_5.setText(research4[4 + pageplus].split(" ")[5]);
					} else {
						writingno_5.setText("");
						titleno_5.setText("");
						dateno_5.setText(""); // 데이트가 2,3번을 먹음
						blikes_5.setText("");
						clickno_5.setText("");
						after.setVisible(false);
					}

					if (research4[5 + pageplus] != null) {
						writingno_6.setText(research4[5 + pageplus].split(" ")[0]);
						titleno_6.setText(research5[5 + pageplus]);
						dateno_6.setText(research4[5 + pageplus].split(" ")[2]);
						blikes_6.setText(research4[5 + pageplus].split(" ")[4]);
						clickno_6.setText(research4[5 + pageplus].split(" ")[5]);
					} else {
						writingno_6.setText("");
						titleno_6.setText("");
						dateno_6.setText(""); // 데이트가 2,3번을 먹음
						blikes_6.setText("");
						clickno_6.setText("");
						after.setVisible(false);
					}

					if (research4[6 + pageplus] != null) {
						writingno_7.setText(research4[6 + pageplus].split(" ")[0]);
						titleno_7.setText(research5[6 + pageplus]);
						dateno_7.setText(research4[6 + pageplus].split(" ")[2]);
						blikes_7.setText(research4[6 + pageplus].split(" ")[4]);
						clickno_7.setText(research4[6 + pageplus].split(" ")[5]);
					} else {
						writingno_7.setText("");
						titleno_7.setText("");
						dateno_7.setText(""); // 데이트가 2,3번을 먹음
						blikes_7.setText("");
						clickno_7.setText("");
						after.setVisible(false);
					}

					if (research4[7 + pageplus] != null) {
						writingno_8.setText(research4[7 + pageplus].split(" ")[0]);
						titleno_8.setText(research5[7 + pageplus]);
						dateno_8.setText(research4[7 + pageplus].split(" ")[2]);
						blikes_8.setText(research4[7 + pageplus].split(" ")[4]);
						clickno_8.setText(research4[7 + pageplus].split(" ")[5]);
					} else {
						writingno_8.setText("");
						titleno_8.setText("");
						dateno_8.setText(""); // 데이트가 2,3번을 먹음
						blikes_8.setText("");
						clickno_8.setText("");
						after.setVisible(false);
					}

					if (research4[8 + pageplus] != null) {
						writingno_9.setText(research4[8 + pageplus].split(" ")[0]);
						titleno_9.setText(research5[8 + pageplus]);
						dateno_9.setText(research4[8 + pageplus].split(" ")[2]);
						blikes_9.setText(research4[8 + pageplus].split(" ")[4]);
						clickno_9.setText(research4[8 + pageplus].split(" ")[5]);
					} else {
						writingno_9.setText("");
						titleno_9.setText("");
						dateno_9.setText(""); // 데이트가 2,3번을 먹음
						blikes_9.setText("");
						clickno_9.setText("");
						after.setVisible(false);
					}

					if (research4[9 + pageplus] != null) {
						writingno_10.setText(research4[9 + pageplus].split(" ")[0]);
						titleno_10.setText(research5[9 + pageplus]);
						dateno_10.setText(research4[9 + pageplus].split(" ")[2]);
						blikes_10.setText(research4[9 + pageplus].split(" ")[4]);
						clickno_10.setText(research4[9 + pageplus].split(" ")[5]);
					} else {
						writingno_10.setText("");
						titleno_10.setText("");
						dateno_10.setText(""); // 데이트가 2,3번을 먹음
						blikes_10.setText("");
						clickno_10.setText("");
						after.setVisible(false);
					}

				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}

			}
		
	}
	

	public void list2() { // 카테고리 있을때
		if(pageplus <0) {
			pageplus =0;
		}
		if(pageno<0) {
			pageno=0;
		}
		list = 2;
		String num = category.getSelectedItem();
		int a = 0;
		String b = "0";
		if (num.equals("Total")) {
		} else if (num.equals("Exercise")) {
			a = 1;
			b = Integer.toString(a);
		} else if (num.equals("Food")) {
			a = 2;
			b = Integer.toString(a);
		} else if (num.equals("Sleep")) {
			a = 3;
			b = Integer.toString(a);
		}

		try {
			String sql = "" + "select user_id,bctitle,bcdate,bclikes,bcviews,bcno " + "from bcontents " + "where bno = " + b
					+ " order by bcdate DESC";
			ConnectionB cb = new ConnectionB(); // 연결
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			setRs(pstmt.executeQuery());

			int i = 0;
			int cnt = 0;
			look = new String[1000];
			look2 = new String[1000]; // 카테고리 선택할때마다 칸 비워줘야 기존꺼 사라짐

			while (getRs().next()) {
				String user_id = getRs().getString("user_id");
				String bctitle = getRs().getString("bctitle");
				String bcdate = getRs().getString("bcdate");
				int bclikes = getRs().getInt("bclikes");
				int bcviews = getRs().getInt("bcviews");
				int bcno = getRs().getInt("bcno");
				look[i] = (user_id + " " + " " + bcdate + " " + bclikes + " " + bcviews + " " + bcno);
				look2[i] = (bctitle);
				// System.out.print(btitle+" "+bmain+" "+bdate+" "+busy+ "\n");
				i++;
			}
			if (i > 9) {
				after.setVisible(true);
			}
			if (pageno == 1) {
				before.setVisible(false);
			}

			if (look[0 + pageplus] != null) {
				writingno_1.setText(look[0 + pageplus].split(" ")[0]);
				titleno_1.setText(look2[0 + pageplus]);
				dateno_1.setText(look[0 + pageplus].split(" ")[2]); // 데이트가 2,3번을 먹음
				blikes_1.setText(look[0 + pageplus].split(" ")[4]);
				clickno_1.setText(look[0 + pageplus].split(" ")[5]);
				bcno_1.setText(look[0 + pageplus].split(" ")[6]);
			} else {
				writingno_1.setText("");
				titleno_1.setText("");
				dateno_1.setText(""); // 데이트가 2,3번을 먹음
				blikes_1.setText("");
				clickno_1.setText("");

			}
			if (look[1 + pageplus] != null) {
				writingno_2.setText(look[1 + pageplus].split(" ")[0]);
				titleno_2.setText(look2[1 + pageplus]);
				dateno_2.setText(look[1 + pageplus].split(" ")[2]);
				blikes_2.setText(look[1 + pageplus].split(" ")[4]);
				clickno_2.setText(look[1 + pageplus].split(" ")[5]);
				bcno_2.setText(look[1 + pageplus].split(" ")[6]);
			} else {
				writingno_2.setText("");
				titleno_2.setText("");
				dateno_2.setText(""); // 데이트가 2,3번을 먹음
				blikes_2.setText("");
				clickno_2.setText("");
				after.setVisible(false);
			}

			if (look[2 + pageplus] != null) {
				writingno_3.setText(look[2 + pageplus].split(" ")[0]);
				titleno_3.setText(look2[2 + pageplus]);
				dateno_3.setText(look[2 + pageplus].split(" ")[2]);
				blikes_3.setText(look[2 + pageplus].split(" ")[4]);
				clickno_3.setText(look[2 + pageplus].split(" ")[5]);
				bcno_3.setText(look[2 + pageplus].split(" ")[6]);
			} else {
				writingno_3.setText("");
				titleno_3.setText("");
				dateno_3.setText(""); // 데이트가 2,3번을 먹음
				blikes_3.setText("");
				clickno_3.setText("");
				after.setVisible(false);
			}

			if (look[3 + pageplus] != null) {
				writingno_4.setText(look[3 + pageplus].split(" ")[0]);
				titleno_4.setText(look2[3 + pageplus]);
				dateno_4.setText(look[3 + pageplus].split(" ")[2]);
				blikes_4.setText(look[3 + pageplus].split(" ")[4]);
				clickno_4.setText(look[3 + pageplus].split(" ")[5]);
				bcno_4.setText(look[3 + pageplus].split(" ")[6]);
			} else {
				writingno_4.setText("");
				titleno_4.setText("");
				dateno_4.setText(""); // 데이트가 2,3번을 먹음
				blikes_4.setText("");
				clickno_4.setText("");
				after.setVisible(false);
			}

			if (look[4 + pageplus] != null) {
				writingno_5.setText(look[4 + pageplus].split(" ")[0]);
				titleno_5.setText(look2[4 + pageplus]);
				dateno_5.setText(look[4 + pageplus].split(" ")[2]);
				blikes_5.setText(look[4 + pageplus].split(" ")[4]);
				clickno_5.setText(look[4 + pageplus].split(" ")[5]);
				bcno_5.setText(look[4 + pageplus].split(" ")[6]);
			} else {
				writingno_5.setText("");
				titleno_5.setText("");
				dateno_5.setText(""); // 데이트가 2,3번을 먹음
				blikes_5.setText("");
				clickno_5.setText("");
				after.setVisible(false);
			}

			if (look[5 + pageplus] != null) {
				writingno_6.setText(look[5 + pageplus].split(" ")[0]);
				titleno_6.setText(look2[5 + pageplus]);
				dateno_6.setText(look[5 + pageplus].split(" ")[2]);
				blikes_6.setText(look[5 + pageplus].split(" ")[4]);
				clickno_6.setText(look[5 + pageplus].split(" ")[5]);
				bcno_6.setText(look[5 + pageplus].split(" ")[6]);
			} else {
				writingno_6.setText("");
				titleno_6.setText("");
				dateno_6.setText(""); // 데이트가 2,3번을 먹음
				blikes_6.setText("");
				clickno_6.setText("");
				after.setVisible(false);
			}

			if (look[6 + pageplus] != null) {
				writingno_7.setText(look[6 + pageplus].split(" ")[0]);
				titleno_7.setText(look2[6 + pageplus]);
				dateno_7.setText(look[6 + pageplus].split(" ")[2]);
				blikes_7.setText(look[6 + pageplus].split(" ")[4]);
				clickno_7.setText(look[6 + pageplus].split(" ")[5]);
				bcno_7.setText(look[6 + pageplus].split(" ")[6]);
			} else {
				writingno_7.setText("");
				titleno_7.setText("");
				dateno_7.setText(""); // 데이트가 2,3번을 먹음
				blikes_7.setText("");
				clickno_7.setText("");
				after.setVisible(false);
			}

			if (look[7 + pageplus] != null) {
				writingno_8.setText(look[7 + pageplus].split(" ")[0]);
				titleno_8.setText(look2[7 + pageplus]);
				dateno_8.setText(look[7 + pageplus].split(" ")[2]);
				blikes_8.setText(look[7 + pageplus].split(" ")[4]);
				clickno_8.setText(look[7 + pageplus].split(" ")[5]);
				bcno_8.setText(look[7 + pageplus].split(" ")[6]);
			} else {
				writingno_8.setText("");
				titleno_8.setText("");
				dateno_8.setText(""); // 데이트가 2,3번을 먹음
				blikes_8.setText("");
				clickno_8.setText("");
				after.setVisible(false);
			}

			if (look[8 + pageplus] != null) {
				writingno_9.setText(look[8 + pageplus].split(" ")[0]);
				titleno_9.setText(look2[8 + pageplus]);
				dateno_9.setText(look[8 + pageplus].split(" ")[2]);
				blikes_9.setText(look[8 + pageplus].split(" ")[4]);
				clickno_9.setText(look[8 + pageplus].split(" ")[5]);
				bcno_9.setText(look[8 + pageplus].split(" ")[6]);
			} else {
				writingno_9.setText("");
				titleno_9.setText("");
				dateno_9.setText(""); // 데이트가 2,3번을 먹음
				blikes_9.setText("");
				clickno_9.setText("");
				after.setVisible(false);
			}

			if (look[9 + pageplus] != null) {
				writingno_10.setText(look[9 + pageplus].split(" ")[0]);
				titleno_10.setText(look2[9 + pageplus]);
				dateno_10.setText(look[9 + pageplus].split(" ")[2]);
				blikes_10.setText(look[9 + pageplus].split(" ")[4]);
				clickno_10.setText(look[9 + pageplus].split(" ")[5]);
				bcno_10.setText(look[9 + pageplus].split(" ")[6]);
			} else {
				writingno_10.setText("");
				titleno_10.setText("");
				dateno_10.setText(""); // 데이트가 2,3번을 먹음
				blikes_10.setText("");
				clickno_10.setText("");
				after.setVisible(false);
			}

			// System.out.print(Arrays.toString(show));
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Boardset bs = new Boardset();

	}
// <<<<<<< read_write

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

// =======
// >>>>>>> master
}
