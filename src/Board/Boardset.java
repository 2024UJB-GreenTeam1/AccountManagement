package Board;

//보드 프레임 클래스
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Boardset extends ConnectionB implements ActionListener, WindowListener {
	private JFrame f;
	private JButton np, search2, before, after, logo, click;
	private JLabel board, writer, writing, date, recommend, check, page, writer2, writing2, date2, recommend2, check2;
	private TextField search;
	private JPanel main;
	private Choice category;
	private JLabel writingno_1,writingno_2,writingno_3,writingno_4,writingno_5,writingno_6,writingno_7,writingno_8,writingno_9,writingno_10,
	dateno_1, dateno_2, dateno_3, dateno_4, dateno_5,
	dateno_6, dateno_7, dateno_8, dateno_9, dateno_10, blikes_1, blikes_2,
	blikes_3, blikes_4, blikes_5, blikes_6, blikes_7, blikes_8,
	blikes_9, blikes_10, clickno_1, clickno_2, clickno_3, clickno_4,
	clickno_5, clickno_6, clickno_7, clickno_8, clickno_9, clickno_10;
	private JButton titleno_1,titleno_2, titleno_3,titleno_4,titleno_5,titleno_6,titleno_7,titleno_8,titleno_9,titleno_10;

	public Boardset() {
		f = new JFrame("1o0");
		f.addWindowListener(this);
		logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));
		logo.setBorderPainted(false);
		logo.setFocusPainted(false);
		logo.setContentAreaFilled(false);

		Font font = new Font("맑은 고딕", Font.BOLD, 50); // 게시판
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20); // 작성자 내용 날짜 추천수 조회수 카테고리

		np = new JButton("새글작성");
		np.addActionListener(this);
		
		ImageIcon search3 = new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/test/search2.jpg");
		search2 = new JButton(search3);// 검색 버튼
		search2.setBorderPainted(false);
		search2.setFocusPainted(false);
		search2.setContentAreaFilled(false);
		
		ImageIcon before1 = new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/test/before.jpg");
		before = new JButton(before1);
		before.addActionListener(this);
		before.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		before.setVisible(false);
	//	before.setBorderPainted(false);		//내부
	//	before.setFocusPainted(false);      //초점 잡히냐
	//	before.setContentAreaFilled(false); //테두리
		
		ImageIcon after1 = new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/test/after.jpg");
		after = new JButton(after1);
		after.addActionListener(this);
		after.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
	//	after.setBorderPainted(false);
	//	after.setFocusPainted(false);
	//  after.setContentAreaFilled(false);

		click = new JButton("조회");

		board = new JLabel("게시판");
		board.setFont(font);
		page = new JLabel("페이지");
		page.setFont(font2);
		page.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		page.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬

		writing = new JLabel("제목");
		writing.setFont(font2);
		writing2 = new JLabel();
		writing2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));

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
		category.add("카테고리");
		category.add("B");
		category.add("C");
		category.add("D");
		category.add("E");
		category.setFont(font2);

		main = new JPanel();
		main.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));

		search = new TextField();
		search.setFont(font2);
		// search.setEditable(false); 텍스트창 편집불가능하게 바꿔

		f.getContentPane().setLayout(null);
		f.setSize(800, 800);
		f.addWindowListener(this); // 이거 없으면 창닫기도 안된다.
		f.setLocationRelativeTo(null);
		np.addActionListener(this);

		board.setSize(200, 100); // x 클수록 오른쪽 y 클수록 아래로
		board.setLocation(320, 10); // 게시판 라벨

		logo.setSize(100, 100); // 로고
		logo.setLocation(10, 10);

		np.setSize(85, 30); // 새글작성
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

		click.setSize(100, 50); // 조회버튼
		click.setLocation(650, 700);
		click.addActionListener(this);
		click.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String sql = "" + "select user_id,btitle,bdate,blikes,bviews " + "from post " + "order by bdate DESC" ;
					ConnectionB cb = new ConnectionB(); // 연결
					Connection conn = DriverManager.getConnection(URL, USERID, USERPWD);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					setRs(pstmt.executeQuery());
					
					BoardCommand bc = new BoardCommand();
					bc.count();
					String[] show = new String[10];  //내용 제외 나머지
					String[] show2 = new String[10]; //내용
					int i=0;
					while (getRs().next()) {
						String user_id = getRs().getString("user_id");
						String btitle = getRs().getString("btitle");
						String bdate = getRs().getString("bdate");
						int blikes = getRs().getInt("blikes");
						int bviews = getRs().getInt("bviews");
						show[i] =(user_id+" "+" "+bdate+" "+blikes+" "+bviews);
						show2[i]= (btitle);
						//System.out.print(btitle+" "+bmain+" "+bdate+" "+busy+ "\n");					
					i++;
						
					}
					if(i+1>10) {
						before.setVisible(false);
					}
					if(show[0] != null) {
						writingno_1.setText(show[0].split(" ")[0]);
						titleno_1.setText(show2[0]);
						dateno_1.setText(show[0].split(" ")[2]);  //데이트가 2,3번을 먹음
						blikes_1.setText(show[0].split(" ")[4]);
						clickno_1.setText(show[0].split(" ")[5]);
						
					}
					if(show[1] != null) {
						writingno_2.setText(show[1].split(" ")[0]);
						titleno_2.setText(show2[1]);
						dateno_2.setText(show[1].split(" ")[2]); 
						blikes_2.setText(show[1].split(" ")[4]);
						clickno_2.setText(show[1].split(" ")[5]);
						}

					if(show[2] != null) {
						writingno_3.setText(show[2].split(" ")[0]);
						titleno_3.setText(show2[2]);
						dateno_3.setText(show[2].split(" ")[2]);
						blikes_3.setText(show[2].split(" ")[4]);
						clickno_3.setText(show[2].split(" ")[5]);
						}

					if(show[3] != null) {
						writingno_4.setText(show[3].split(" ")[0]);
						titleno_4.setText(show2[3]);
						dateno_4.setText(show[3].split(" ")[2]);
						blikes_4.setText(show[3].split(" ")[4]);
						clickno_4.setText(show[3].split(" ")[5]);
						}

					if(show[4] != null) {
						writingno_5.setText(show[4].split(" ")[0]);
						titleno_5.setText(show2[4]);
						dateno_5.setText(show[4].split(" ")[2]);
						blikes_5.setText(show[4].split(" ")[4]);
						clickno_5.setText(show[4].split(" ")[5]);
					}

					if(show[5] != null) {
						writingno_6.setText(show[5].split(" ")[0]);
						titleno_6.setText(show2[5]);
						dateno_6.setText(show[5].split(" ")[2]);
						blikes_6.setText(show[5].split(" ")[4]);
						clickno_6.setText(show[5].split(" ")[5]);
						}

					if(show[6] != null) {
						writingno_7.setText(show[6].split(" ")[0]);
						titleno_7.setText(show2[6]);
						dateno_7.setText(show[6].split(" ")[2]);
						blikes_7.setText(show[6].split(" ")[4]);
						clickno_7.setText(show[6].split(" ")[5]);
						}

					if(show[7] != null) {
						writingno_8.setText(show[7].split(" ")[0]);
						titleno_8.setText(show2[7]);
						dateno_8.setText(show[7].split(" ")[2]);
						blikes_8.setText(show[7].split(" ")[4]);
						clickno_8.setText(show[7].split(" ")[5]);
						}

					if(show[8] != null) {
						writingno_9.setText(show[8].split(" ")[0]);
						titleno_9.setText(show2[8]);
						dateno_9.setText(show[8].split(" ")[2]);
						blikes_9.setText(show[8].split(" ")[4]);
						clickno_9.setText(show[8].split(" ")[5]);
						}

					if(show[9] != null) {
						writingno_10.setText(show[9].split(" ")[0]);
						titleno_10.setText(show2[9]);
						dateno_10.setText(show[9].split(" ")[2]);
						blikes_10.setText(show[9].split(" ")[4]);
						clickno_10.setText(show[9].split(" ")[5]);
						}

				//System.out.print(Arrays.toString(show));
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		});

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
		writingno_1 = new JLabel("");  //1번글
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

		writingno_4= new JLabel("");
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

		writingno_8  = new JLabel("");
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

		dateno_1= new JLabel("");    //1번글 날짜
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

		blikes_1 = new JLabel(""); //1번글 추천수
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

		clickno_1 = new JLabel(""); //1번글 조회수
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

		titleno_1 = new JButton(""); //1번글 내용
		titleno_1.setBounds(98, 28, 450, 52);
		titleno_1.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		main.add(titleno_1);

		titleno_2 = new JButton("");
		titleno_2.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_2.setBounds(98, 78, 450, 52);
		main.add(titleno_2);

		titleno_3 = new JButton("");
		titleno_3.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_3.setBounds(98, 128, 450, 52);
		main.add(titleno_3);

		titleno_4 = new JButton("");
		titleno_4.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_4.setBounds(98, 178, 450, 52);
		main.add(titleno_4);

		titleno_5 = new JButton("");
		titleno_5.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_5.setBounds(98, 228, 450, 52);
		main.add(titleno_5);

		titleno_6 = new JButton("");
		titleno_6.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_6.setBounds(98, 278, 450, 52);
		main.add(titleno_6);

		titleno_7 = new JButton("");
		titleno_7.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_7.setBounds(98, 328, 450, 52);
		main.add(titleno_7);

		titleno_8 = new JButton("");
		titleno_8.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_8.setBounds(98, 378, 450, 52);
		main.add(titleno_8);

		titleno_9 = new JButton("");
		titleno_9.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_9.setBounds(98, 428, 450, 52);
		main.add(titleno_9);

		titleno_10 = new JButton("");
		titleno_10.setBorder(new TitledBorder(new LineBorder(Color.black, 2)));
		titleno_10.setBounds(98, 478, 450, 52);
		main.add(titleno_10);
		f.getContentPane().add(logo);
		f.getContentPane().add(board);
		f.setVisible(true);
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

	}

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

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("새글작성")) {
			BoardWrite bw = new BoardWrite();
		}else if(e.getSource()==before) {
			System.out.print("이전");
		}else if(e.getSource()==after) {
			before.setVisible(true);
		}
	}

	public static void main(String[] args) {
		Boardset bs = new Boardset();

	}
}