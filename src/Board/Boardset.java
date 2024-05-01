package Board;
//보드 프레임 클래스
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Boardset  extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JButton np,search2,before,after,logo,click;
	private JLabel board,writer,writing,date,recommend,check,page,writer2,writing2,date2,recommend2,check2;
	private TextField search;
	private JPanel main;
	private Choice category;
	
	public Boardset(){
		f = new JFrame("1o0");
		logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));
		logo.setBorderPainted(false);
		logo.setFocusPainted(false);
		logo.setContentAreaFilled(false);
		
		Font font = new Font("맑은 고딕",Font.BOLD,50);  //게시판 
		Font font2 = new Font("맑은 고딕",Font.BOLD,20); //작성자 내용 날짜 추천수 조회수 카테고리
		
		np = new JButton("새글작성");
	
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
		
		writer = new JLabel("작성자");  //보여지는거
		writer.setFont(font2);
		writer2 = new JLabel();  //겉에 테두리
		writer2.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		
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
		category.add("B");
		category.add("C");
		category.add("D");
		category.add("E");
		category.setFont(font2);
		
		
		main = new JPanel(); 
		main.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		
		search = new TextField();
		search.setFont(font2);
		
		f.setLayout(null);
}
	
	
	public void startFrame() {
		List userlist = new List();
		f.addWindowListener(this);
		f.setSize(800,800);
		f.addWindowListener(this);   // 이거 없으면 창닫기도 안된다.
		f.setLocationRelativeTo(null);
		
		board.setSize(200,100);     //x 클수록 오른쪽 y 클수록 아래로 
		board.setLocation(320,10);   //게시판 라벨
		
		logo.setSize(100,100);   //로고
		logo.setLocation(10,10);
		
		np.setSize(85,30);     //새글작성
		np.setLocation(7,700);
		 
		writer.setSize(100,100);      //작성자
		writer.setLocation(20,115);
		writer2.setSize(100,30);
		writer2.setLocation(0,150);
		
		
		writing.setSize(100,100); 	//내용   
		writing.setLocation(300,115);
		writing2.setSize(450,30);
		writing2.setLocation(100,150);
		
		date.setSize(100,100);  	//날짜
		date.setLocation(570,115);
		date2.setSize(80,30);
		date2.setLocation(550,150);
		
		recommend.setSize(100,100);   //추천수
		recommend.setLocation(640,115);
		recommend2.setSize(80,30);
		recommend2.setLocation(630,150);
		
		check.setSize(100,100);   //조회수
		check.setLocation(722,115);
		check2.setSize(74,30);
		check2.setLocation(710,150);
		
		main.setSize(784,550);       //내용들어갈 예정
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
					Connection conn = null;
					
					ConnectionB cb = new ConnectionB();  //연결
			
					java.sql.Statement st = null;
					ResultSet rs = null;
					List userList = new List();
					st = conn.createStatement();
					st.execute("use xe;");
					rs = st.executeQuery("select user_id,content,dates,recommend,checks " + "from USERS");
				while(rs.next()) {
					String str = rs.getString(1);
					userList.add(str);
				}			
				}catch(SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		});
		
		f.add(click);
		//f.add(userList);
		f.add(click);
		f.add(check2);
		f.add(recommend2);
		f.add(date2);
		f.add(writing2);
		f.add(writer2);
		f.add(after);
		f.add(before);
		f.add(page);
		f.add(category);
		f.add(check);
		f.add(recommend);
		f.add(writer);
		f.add(writing);
		f.add(date);
		f.add(search2);
		f.add(search);
		f.add(np);
		f.add(main);
		f.add(logo);
		f.add(board);
		f.setVisible(true);
		
				
	}
	
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);  //닫기 눌러서 창닫기
	}

	@Override
	public void actionPerformed(ActionEvent e) {    
		// TODO Auto-generated method stub
		
		
	}
	public static void main(String[ ]args ) {
		
		Boardset bs = new Boardset();
		bs.startFrame();
		
	}
}