package Board;
//보드 프레임 클래스
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
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


public class Boardset  extends ConnectionB implements ActionListener, WindowListener {
	private JFrame f;
	private JButton np,search2,before,after,logo,click;
	private JLabel board,writer,writing,date,recommend,check,page,writer2,writing2,date2,recommend2,check2;
	private TextField search;
	private JPanel main;
	private Choice category;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	
	
	
	
	
	public Boardset() {
	f = new JFrame("1o0");
	f.addWindowListener(this);
	logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));
	logo.setBorderPainted(false);
	logo.setFocusPainted(false);
	logo.setContentAreaFilled(false);
	
	Font font = new Font("맑은 고딕",Font.BOLD,50);  //게시판 
	Font font2 = new Font("맑은 고딕",Font.BOLD,20); //작성자 내용 날짜 추천수 조회수 카테고리
	
	np = new JButton("새글작성");
	np.addActionListener(this);

	search2 = new JButton("검색");//검색 버튼
	search2 = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/search2.jpg"));
	search2.setBorderPainted(false);
	search2.setFocusPainted(false);
	search2.setContentAreaFilled(false);
	
	before = new JButton("이전");
	before = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/before.jpg"));
	before.setBorderPainted(false);
	before.setFocusPainted(false);
	before.setContentAreaFilled(false);
	
	after = new JButton("다음");
	after = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/after.jpg"));
	after.setBorderPainted(false);
	after.setFocusPainted(false);
	after.setContentAreaFilled(false);
	
	click = new JButton("조회");
	
	
	board = new JLabel("게시판");
	board.setFont(font);
	page = new JLabel("페이지");
	page.setFont(font2);
	page.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	page.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
	
	writing = new JLabel("내용");
	writing.setFont(font2);
	writing2 = new JLabel();
	writing2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	
	date = new JLabel("날짜");
	date.setFont(font2);
	date2 = new JLabel();
	date2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	
	recommend = new JLabel("추천수");
	recommend.setFont(font2);
	recommend2 = new JLabel();
	recommend2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	
	check = new JLabel("조회수");
	check.setFont(font2);
	check2 = new JLabel();
	check2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	
	
	category = new Choice();
	category.add("카테고리");
	category.add("운동");
	category.add("음식");
	category.add("수면시간");
	category.setFont(font2);
	
	
	main = new JPanel(); 
	main.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	
	search = new TextField();
	search.setFont(font2);
	
	f.getContentPane().setLayout(null);	
	f.setSize(800,800);
	f.addWindowListener(this);   // 이거 없으면 창닫기도 안된다.
	f.setLocationRelativeTo(null);
	np.addActionListener(this);

	
	
	board.setSize(200,100);     //x 클수록 오른쪽 y 클수록 아래로 
	board.setLocation(320,10);   //게시판 라벨
	
	logo.setSize(100,100);   //로고
	logo.setLocation(10,10);
	
	np.setSize(85,30);     //새글작성
	np.setLocation(7,700);
	
	
	writing.setSize(100,100); 	//내용   
	writing.setLocation(300,115);
	writing2.setSize(450,30);
	writing2.setLocation(98,150);
	
	date.setSize(100,100);  	//날짜
	date.setLocation(564,115);
	date2.setSize(80,30);
	date2.setLocation(546,150);
	
	recommend.setSize(100,100);   //추천수
	recommend.setLocation(634,115);
	recommend2.setSize(85,30);
	recommend2.setLocation(624,150);
	
	check.setSize(100,100);   //조회수
	check.setLocation(717,115);
	check2.setSize(76,30);
	check2.setLocation(707,150);
	
	main.setSize(784,530);       //내용들어갈 예정
	main.setLocation(0,150);
	
	search.setSize(200,30);   //검색창
	search.setLocation(285,730);
		
	search2.setSize(50,30);   //검색버튼 
	search2.setLocation(485,750);
	
	category.setSize(200,100);  // 카테고리
	category.setLocation(10,100);
	
	page.setSize(70,30);    //페이지 라벨
	page.setLocation(350,700);
	
	before.setSize(50,30);    //이전
	before.setLocation(300,700);
	
	after.setSize(50,30);	 //다음
	after.setLocation(420,700);
	

	click.setSize(100,50);   //조회버튼
	click.setLocation(650,700);
	click.addActionListener(this);
	click.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		
			
			try {
				String sql = "" + "select bno,btitle,bdate,busy " + "from BOARDS";
				ConnectionB cb = new ConnectionB();  //연결
				Connection conn = DriverManager.getConnection(URL,USERID,USERPWD);
			 	PreparedStatement  pstmt = conn.prepareStatement(sql);
				setRs(pstmt.executeQuery());
			while(getRs().next()) {
				String str = getRs().getString(1);
			}			
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	});
	
	f.getContentPane().add(click);
	//f.add(userList);
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
	
	//여기부터
	lblNewLabel = new JLabel("1번글");
	lblNewLabel.setBounds(0, 28, 100, 52);
	lblNewLabel.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	main.add(lblNewLabel);
	
	writer = new JLabel("작성자");  //보여지는거
	writer.setBounds(12, -38, 100, 100);
	main.add(writer);
	writer.setFont(font2);
	writer2 = new JLabel();  //겉에 테두리
	writer2.setBounds(0, 0, 100, 30);
	main.add(writer2);
	writer2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	
	JLabel lblNewLabel_1 = new JLabel("2번글");
	lblNewLabel_1.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1.setBounds(0, 78, 100, 52);
	main.add(lblNewLabel_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("3번글");
	lblNewLabel_1_1.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1_1.setBounds(0, 128, 100, 52);
	main.add(lblNewLabel_1_1);
	
	JLabel lblNewLabel_1_2 = new JLabel("4번글");
	lblNewLabel_1_2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1_2.setBounds(0, 178, 100, 52);
	main.add(lblNewLabel_1_2);
	
	JLabel lblNewLabel_1_3 = new JLabel("5번글");
	lblNewLabel_1_3.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1_3.setBounds(0, 228, 100, 52);
	main.add(lblNewLabel_1_3);
	
	JLabel lblNewLabel_1_4 = new JLabel("6번글");
	lblNewLabel_1_4.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1_4.setBounds(0, 278, 100, 52);
	main.add(lblNewLabel_1_4);
	
	JLabel lblNewLabel_1_5 = new JLabel("7번글");
	lblNewLabel_1_5.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1_5.setBounds(0, 328, 100, 52);
	main.add(lblNewLabel_1_5);
	
	JLabel lblNewLabel_1_6 = new JLabel("8번글");
	lblNewLabel_1_6.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1_6.setBounds(0, 378, 100, 52);
	main.add(lblNewLabel_1_6);
	
	JLabel lblNewLabel_1_7 = new JLabel("9번글");
	lblNewLabel_1_7.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1_7.setBounds(0, 428, 100, 52);
	main.add(lblNewLabel_1_7);
	
	JLabel lblNewLabel_1_8 = new JLabel("10번글");
	lblNewLabel_1_8.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_1_8.setBounds(0, 478, 100, 52);
	main.add(lblNewLabel_1_8);
	
	lblNewLabel_2 = new JLabel("1번글날짜");
	lblNewLabel_2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_2.setBounds(546, 28, 80, 52);
	main.add(lblNewLabel_2);
	
	lblNewLabel_3 = new JLabel("2번글날짜");
	lblNewLabel_3.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_3.setBounds(546, 78, 80, 52);
	main.add(lblNewLabel_3);
	
	lblNewLabel_4 = new JLabel("3번글날짜");
	lblNewLabel_4.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_4.setBounds(546, 128, 80, 52);
	main.add(lblNewLabel_4);
	
	lblNewLabel_5 = new JLabel("4번글날짜");
	lblNewLabel_5.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_5.setBounds(546, 178, 80, 52);
	main.add(lblNewLabel_5);
	
	lblNewLabel_6 = new JLabel("5번글날짜");
	lblNewLabel_6.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_6.setBounds(546, 228, 80, 52);
	main.add(lblNewLabel_6);
	
	lblNewLabel_7 = new JLabel("6번글날짜");
	lblNewLabel_7.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_7.setBounds(546, 278, 80, 52);
	main.add(lblNewLabel_7);
	
	lblNewLabel_8 = new JLabel("7번글날짜");
	lblNewLabel_8.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_8.setBounds(546, 328, 80, 52);
	main.add(lblNewLabel_8);
	
	lblNewLabel_9 = new JLabel("8번글날짜");
	lblNewLabel_9.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_9.setBounds(546, 378, 80, 52);
	main.add(lblNewLabel_9);
	
	lblNewLabel_10 = new JLabel("9번글날짜");
	lblNewLabel_10.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_10.setBounds(546, 428, 80, 52);
	main.add(lblNewLabel_10);
	
	lblNewLabel_11 = new JLabel("10번글날짜");
	lblNewLabel_11.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_11.setBounds(546, 478, 80, 52);
	main.add(lblNewLabel_11);
	
	lblNewLabel_12 = new JLabel("1번글추천수");
	lblNewLabel_12.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_12.setBounds(624, 28, 85, 52);
	main.add(lblNewLabel_12);
	
	lblNewLabel_13 = new JLabel("2번글추천수");
	lblNewLabel_13.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_13.setBounds(624, 78, 85, 52);
	main.add(lblNewLabel_13);
	
	lblNewLabel_14 = new JLabel("3번글추천수");
	lblNewLabel_14.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_14.setBounds(624, 128, 85, 52);
	main.add(lblNewLabel_14);
	
	lblNewLabel_15 = new JLabel("4번글추천수");
	lblNewLabel_15.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_15.setBounds(624, 178, 85, 52);
	main.add(lblNewLabel_15);
	
	lblNewLabel_16 = new JLabel("5번글추천수");
	lblNewLabel_16.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_16.setBounds(624, 228, 85, 52);
	main.add(lblNewLabel_16);
	
	lblNewLabel_17 = new JLabel("6번글추천수");
	lblNewLabel_17.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_17.setBounds(624, 278, 85, 52);
	main.add(lblNewLabel_17);
	
	lblNewLabel_18 = new JLabel("7번글추천수");
	lblNewLabel_18.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_18.setBounds(624, 328, 85, 52);
	main.add(lblNewLabel_18);
	
	lblNewLabel_19 = new JLabel("8번글추천수");
	lblNewLabel_19.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_19.setBounds(624, 378, 85, 52);
	main.add(lblNewLabel_19);
	
	lblNewLabel_20 = new JLabel("9번글추천수");
	lblNewLabel_20.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_20.setBounds(624, 428, 85, 52);
	main.add(lblNewLabel_20);
	
	lblNewLabel_21 = new JLabel("10번글추천수");
	lblNewLabel_21.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_21.setBounds(624, 478, 85, 52);
	main.add(lblNewLabel_21);
	
	lblNewLabel_22 = new JLabel("1번글조회수");
	lblNewLabel_22.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_22.setBounds(707, 28, 76, 52);
	main.add(lblNewLabel_22);
	
	lblNewLabel_23 = new JLabel("2번글조회수");
	lblNewLabel_23.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_23.setBounds(707, 78, 76, 52);
	main.add(lblNewLabel_23);
	
	lblNewLabel_24 = new JLabel("3번글조회수");
	lblNewLabel_24.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_24.setBounds(707, 128, 76, 52);
	main.add(lblNewLabel_24);
	
	lblNewLabel_25 = new JLabel("4번글조회수");
	lblNewLabel_25.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_25.setBounds(707, 178, 76, 52);
	main.add(lblNewLabel_25);
	
	lblNewLabel_26 = new JLabel("5번글조회수");
	lblNewLabel_26.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_26.setBounds(707, 228, 76, 52);
	main.add(lblNewLabel_26);
	
	lblNewLabel_27 = new JLabel("6번글조회수");
	lblNewLabel_27.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_27.setBounds(707, 278, 76, 52);
	main.add(lblNewLabel_27);
	
	lblNewLabel_28 = new JLabel("7번글조회수");
	lblNewLabel_28.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_28.setBounds(707, 328, 76, 52);
	main.add(lblNewLabel_28);
	
	lblNewLabel_29 = new JLabel("8번글조회수");
	lblNewLabel_29.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_29.setBounds(707, 378, 76, 52);
	main.add(lblNewLabel_29);
	
	lblNewLabel_30 = new JLabel("9번글조회수");
	lblNewLabel_30.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_30.setBounds(707, 428, 76, 52);
	main.add(lblNewLabel_30);
	
	lblNewLabel_31 = new JLabel("10번글조회수");
	lblNewLabel_31.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	lblNewLabel_31.setBounds(707, 478, 76, 52);
	main.add(lblNewLabel_31);
	
	JButton btnNewButton = new JButton("1번글 내용");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton.setBounds(98, 28, 450, 52);
	btnNewButton.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	main.add(btnNewButton);
	
	btnNewButton_1 = new JButton("2번글 내용");
	btnNewButton_1.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_1.setBounds(98, 78, 450, 52);
	main.add(btnNewButton_1);
	
	btnNewButton_2 = new JButton("3번글 내용");
	btnNewButton_2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_2.setBounds(98, 128, 450, 52);
	main.add(btnNewButton_2);
	
	btnNewButton_3 = new JButton("4번글 내용");
	btnNewButton_3.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_3.setBounds(98, 178, 450, 52);
	main.add(btnNewButton_3);
	
	btnNewButton_4 = new JButton("5번글 내용");
	btnNewButton_4.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_4.setBounds(98, 228, 450, 52);
	main.add(btnNewButton_4);
	
	btnNewButton_5 = new JButton("6번글 내용");
	btnNewButton_5.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_5.setBounds(98, 278, 450, 52);
	main.add(btnNewButton_5);
	
	btnNewButton_6 = new JButton("7번글 내용");
	btnNewButton_6.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_6.setBounds(98, 328, 450, 52);
	main.add(btnNewButton_6);
	
	btnNewButton_7 = new JButton("8번글 내용");
	btnNewButton_7.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_7.setBounds(98, 378, 450, 52);
	main.add(btnNewButton_7);

	btnNewButton_8 = new JButton("9번글 내용");
	btnNewButton_8.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_8.setBounds(98, 428, 450, 52);
	main.add(btnNewButton_8);
	
	btnNewButton_9 = new JButton("10번글 내용");
	btnNewButton_9.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
	btnNewButton_9.setBounds(98, 478, 450, 52);
	main.add(btnNewButton_9);
	f.getContentPane().add(logo);
	f.getContentPane().add(board);
	f.setVisible(true);
		
				
	}
	
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);  //닫기 눌러서 창닫기
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
		if(e.getActionCommand().equals("새글작성")) {
			BoardWrite bw = new BoardWrite();
		
		}
	
	}

	public static void main(String[] args) {
		Boardset bs = new Boardset();
		
	}
}