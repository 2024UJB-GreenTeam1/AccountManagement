package Post;
// 사용함
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import kakaomap.Correct;
import Board1.Boardset;

public class Read extends Connection2 implements ActionListener, WindowListener{

	public JFrame frame;
	private JButton np,search2,before,after,logo,click;
	private JLabel board,writer,writing,date,recommend,check,page,writer2,writing2,date2,recommend2,check2;
	private TextField search;
	private JPanel main;
	private Choice category;
	static int plz;
	private LineBorder bb = new LineBorder(Color.black, 1, true); 
//	private ReadDao readDao;
	Instant lastLikeTime;
	
//	Scanner sc = new Scanner (System.in);
//	int i = sc.nextInt();
	JLabel lblNewLabel_18;
	String driver = "ora"+ "cle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	
	Object ob[][] = new Object[0][10];
	DefaultTableModel model;
	JTable table;
	String str[] = {"bcno","bno","user_id","bcnickname","bctitle","bcontent","bcdate","bcdelete","bcviews","bcfiledata","bclikes"};
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;	
	
	String bcno;	
	String bno;
	String bctitle;
	String user_id;
	String bcontent ;
	String bcdate ;
	int bcviews;
	int bclikes;
	String bcnickname;
	String bcdelete ;
	String bcfilename;
	Blob bfiledata;
	ImageIcon icon;
	Image image;
	JDialog info5;

	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				
//					Read read = new Read(plz);
//					read.frame.setVisible(true);
////					ReadDao readdao = new ReadDao();
//				//	readdao.iselect();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	

	}

	  public static void showFrame(int plz) {
		  EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
					
						Read read = new Read(plz);
						read.frame.setVisible(true);
//						ReadDao readdao = new ReadDao();
					//	readdao.iselect();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	  }
//		  //	System.out.println("눌러짐");
//		  Read read = new Read(plz);
//		  read.frame.setVisible(true);
	/**
	 * Create the application.
	 */
	public Read(int plz) {
		initialize(plz);
	//readDao = new ReadDao();
		
	}

	public void conDB() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	public int getBclikes() {
		
		return bclikes;
	}

	public void updatebclikes(int newBclikes) {
	this.bclikes = newBclikes;

	try {
	String driver = "ora"+ "cle.jdbc.driver.OracleDriver";
	con=DriverManager.getConnection(url,user,password);
	String sql = "update bcontents set bclikes = bclikes + 1 where bcno = ?"; 
	try (PreparedStatement pstmt = con.prepareStatement(sql)){
		pstmt.setInt(1,plz);
		pstmt.executeUpdate();
		
		lblNewLabel_18.setText(Integer.toString(newBclikes));
	}
	}catch(SQLException e) {
		e.printStackTrace();
	} finally {
		if (con !=null) {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
//	btnNewButton_2.addActionListener(new ActionListener() { // 추천 버튼
//		public void actionPerformed(ActionEvent e) {
//			 Instant currentTime = Instant.now();
//			if(lastLikeTime == null || Duration.between(lastLikeTime, currentTime).getSeconds() >= 60) {
//				
//			
//			int currentBclikes = getBclikes();
//			 int updateBclikes = currentBclikes +1;
//			updatebclikes(updateBclikes);
//			System.out.println(getBclikes());
//	//		System.out.println(currentBclikes);
//			System.out.println("추천수 : "+ updateBclikes);
//			
//			lastLikeTime = currentTime;
	

	private void initialize(int plz) {
		
		
		Font font = new Font("맑은 고딕",Font.BOLD,40);  //게시판 
		Font font2 = new Font("맑은 고딕",Font.BOLD,13); //작성자 내용 날짜 추천수 조회수 카테고리
		
		frame = new JFrame("게시글");
		frame.setBounds(100, 100, 800, 800);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel imageLabel = new JLabel();
		JLabel lblNewLabel = new JLabel("게시글");
		lblNewLabel.setBounds(316, 17, 206, 78);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(font);
		

		
         
		Connection2 con2 = new Connection2();

//		ReadDao readDao = new ReadDao();
	//	ResultSet rs = readDao.iselect();
	
		try {
			pstmt =null;
			con = DriverManager.getConnection(url, user, password);
			String sql = " select * from bcontents where bcno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,plz);
			
			System.out.println("pstmt: " + pstmt);
			rs = pstmt.executeQuery();
			System.out.println("rs : " + rs);

			System.out.println(rs);
			while (rs.next()) {
				bcno = rs.getString("bcno");
				bno = rs.getString("bno");
				user_id = rs.getString("user_id");
				bctitle = rs.getString("bctitle");
				bcontent = rs.getString("bcontent");
				bcdate = rs.getString("bcdate");
				bcdelete = rs.getString("bcdelete");
				bcfilename = rs.getString("bcfilename");
				bfiledata = rs.getBlob("bfiledata");
				bcviews = rs.getInt("bcviews");
				bclikes = rs.getInt("bclikes");
		

	//	System.out.println(bcno);
//				icon = new ImageIcon(image);
			}
			System.out.println(bcno + " , " + bno + " , " + user_id + " , " + bcnickname + " , " + bctitle + " , "
					+ bcontent + " , "+ bfiledata+ " , "+ bcdate + " , " + bcdelete + " , " + bcviews  + " , "	+ bclikes);
	
		
		
		
			
		model = new DefaultTableModel(ob,str);
		table = new JTable(model);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(0, 116, 101, 23); 	//작성자 칸
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setBorder(bb);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBounds(100, 116, 457, 23); // 제목 칸
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setBorder(bb);
		
		JLabel lblNewLabel_1 = new JLabel("작성자");
		lblNewLabel_1.setBounds(25, 120, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(font2);
		
		JLabel lblNewLabel_5 = new JLabel("제목");
		lblNewLabel_5.setBounds(292, 120, 57, 15);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setFont(font2);
		
		JLabel lblNewLabel_9 = new JLabel("작성일자");
		lblNewLabel_9.setBounds(581, 120, 57, 15);
		frame.getContentPane().add(lblNewLabel_9);
		lblNewLabel_9.setFont(font2);
		
		JLabel lblNewLabel_10 = new JLabel("조회수");
		lblNewLabel_10.setBounds(677, 115, 57, 26);
		frame.getContentPane().add(lblNewLabel_10);
		lblNewLabel_10.setFont(font2);
		
		JLabel lblNewLabel_11 = new JLabel("추천수");
		lblNewLabel_11.setBounds(735, 109, 49, 36);
		frame.getContentPane().add(lblNewLabel_11);
		lblNewLabel_11.setFont(font2);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {
					rs.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
//	 catch (IOException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setBounds(556, 116, 104, 23);	//작성일자 칸
		frame.getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setBorder(bb);
		
		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setBounds(658, 116, 69, 23);	// 조회수 칸
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setBorder(bb);
		
		JLabel lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setBounds(727, 116, 57, 23);	// 추천수 칸
		frame.getContentPane().add(lblNewLabel_8);
		lblNewLabel_8.setBorder(bb);
		
		JLabel lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setBounds(1, 139, 100, 23);
		frame.getContentPane().add(lblNewLabel_12);
		lblNewLabel_12.setBorder(bb);
		
		JLabel lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setBounds(99, 139, 459, 23);
		frame.getContentPane().add(lblNewLabel_13);
		lblNewLabel_13.setBorder(bb);
		
		JLabel lblNewLabel_14 = new JLabel(user_id); // 작성자
		lblNewLabel_14.setBounds(16, 139, 79, 21);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel(bctitle); // 제목
		lblNewLabel_15.setBounds(104, 143, 442, 15);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel(bcdate); // 작성일자
		lblNewLabel_16.setBounds(558, 139, 102, 23);
		frame.getContentPane().add(lblNewLabel_16);
		lblNewLabel_16.setBorder(bb);
		
		String bviews = Integer.toString(bcviews);
		JLabel lblNewLabel_17 = new JLabel(bviews); // 조회수 
		lblNewLabel_17.setBounds(658, 139, 69, 23);
		frame.getContentPane().add(lblNewLabel_17);
		lblNewLabel_17.setBorder(bb);
		
	
	//	int currentBclikes;
		
		JButton btnNewButton_2 = new JButton("추천 버튼");
		btnNewButton_2.setBounds(352, 700, 97, 36);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() { // 추천 버튼
			public void actionPerformed(ActionEvent e) {
				 Instant currentTime = Instant.now();
				if(lastLikeTime == null || Duration.between(lastLikeTime, currentTime).getSeconds() >= 60) {
					
					try {
						pstmt =null;
						con = DriverManager.getConnection(url, user, password);
						String sql = "update bcontents set bclikes = bclikes + 1 where bcno = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1,plz);
						
						System.out.println("pstmt: " + pstmt);
						rs = pstmt.executeQuery();
						System.out.println("rs : " + rs);
						}catch (Exception e3) {
						e3.printStackTrace();
						}
					
						
				
				int currentBclikes = getBclikes();
				 int updateBclikes = currentBclikes +1;
				updatebclikes(updateBclikes);
				System.out.println(getBclikes());
		//		System.out.println(currentBclikes);
				System.out.println("추천수 : "+ updateBclikes);
				
				lastLikeTime = currentTime;
		
				} else {
					
						info5 = new JDialog(frame,"안내창",true);
						info5.setSize(220,100);
						info5.setLocation(400,400);
						info5.setLayout(new FlowLayout());
						
						JLabel mas = new JLabel("1분에 한 번만 추천할 수 있습니다.",JLabel.CENTER);
						JButton ok1 = new JButton("확인");
						info5.add(mas);
						info5.add(ok1);

						ok1.addActionListener(new ActionListener() { // 수정 버튼
							public void actionPerformed(ActionEvent e) {
								info5.dispose(); 
							}
						});
						info5.setVisible(true);
						
				}
			}
		});
		String blikes = Integer.toString(bclikes);
		 lblNewLabel_18 = new JLabel(blikes);// 추천수 
		lblNewLabel_18.setBounds(727, 139, 57, 23);
		frame.getContentPane().add(lblNewLabel_18);
		lblNewLabel_18.setBorder(bb);

		JTextArea lblNewLabel_3 = new JTextArea(bcontent);
		JScrollPane scrollPane = new JScrollPane(lblNewLabel_3);
		scrollPane.setBounds(15, 177, 757, 513); // 위치 및 크기 설정
		lblNewLabel_3.setEditable(false);
		frame.getContentPane().add(scrollPane); 	// 내용칸
		lblNewLabel_3.setBorder(bb);
		

		JLabel lblNewLabel_22 = new JLabel(); // 내용
		lblNewLabel_22.setBounds(15, 177, 757, 513);
		frame.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_19 = new JLabel();	// 작성일자
		lblNewLabel_19.setBounds(559, 140, 101, 23);
		frame.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel();	//조회수
		lblNewLabel_20.setBounds(662, 140, 69, 23);
		frame.getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel();	//추천수
		lblNewLabel_21.setBounds(731, 138, 57, 23);
		frame.getContentPane().add(lblNewLabel_21);

		
		JButton btnNewButton = new JButton("수정"); // 수정 창으로 이동
		btnNewButton.setBounds(566, 700, 97, 36);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { // 수정 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("수정")) {
					Correct correct = new Correct(plz);
				//	frame.dispose();	
				}
			}
		});
		JButton btnNewButton_1 = new JButton("나가기");	
		btnNewButton_1.setBounds(675, 700, 97, 36);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() { // 나가기 버튼
			public void actionPerformed(ActionEvent e) {
				  frame.dispose();	
			}
		});
		JButton btnNewButton_4 = new JButton("이미지");	
		btnNewButton_4.setBounds(200, 700, 97, 36);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setEnabled(false);
		if (bfiledata != null) {
			btnNewButton_4.setEnabled(true);
		}
		btnNewButton_4.addActionListener(new ActionListener() { // 이미지 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("이미지")) {
					Tab.showFrame(plz);
					
				}
			
			}
		});
		
		lblNewLabel_17.setHorizontalAlignment(JLabel.CENTER); // 조회수 가운데 정렬
		lblNewLabel_18.setHorizontalAlignment(JLabel.CENTER); // 추천수 가운데 정렬
//		
//		JButton btnNewButton_2 = new JButton("추천 버튼");
//		btnNewButton_2.setBounds(352, 700, 97, 36);
//		frame.getContentPane().add(btnNewButton_2);
//	
}

	
		public void windowClosing(WindowEvent e) {
			  frame.dispose();   //닫기 눌러서 창닫기
		}


		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			  frame.dispose();	
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
		    if(e.getActionCommand().equals("수정")) {
		    	Correct correct = new Correct(plz);
		        Correct.showFrame(plz);
		        System.out.println("눌러짐");
		    }
		    if (e.getActionCommand().equals("이미지")) {
		    	Tab tab = new Tab(plz);
		    	Tab.showFrame(plz);
		    	 System.out.println("눌러짐");
		    }
		    
		
		  
	}

	
}

