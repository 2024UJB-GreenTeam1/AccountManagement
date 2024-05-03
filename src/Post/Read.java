package Post;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Post.ComDto;
import Post.Correct;

public class Read extends ComDto implements ActionListener, WindowListener{

	private JFrame frame;
	private JButton np,search2,before,after,logo,click;
	private JLabel board,writer,writing,date,recommend,check,page,writer2,writing2,date2,recommend2,check2;
	private TextField search;
	private JPanel main;
	private Choice category;
	private LineBorder bb = new LineBorder(Color.black, 1, true); 

	String driver = "ora"+ "cle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Read window = new Read();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Read() {
		initialize();
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
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		logo = new JButton(new ImageIcon("C:/Users/Manic-063/Desktop/t/project/logo.jpg"));
//		logo.setBorderPainted(false);
//		logo.setFocusPainted(false);
//		logo.setContentAreaFilled(false);
		
		Connection2 con2 = new Connection2();
		ImageIcon img = new ImageIcon("button_image/logo.jpg");
		Font font = new Font("맑은 고딕",Font.BOLD,40);  //게시판 
		Font font2 = new Font("맑은 고딕",Font.BOLD,13); //작성자 내용 날짜 추천수 조회수 카테고리
		
		
//		JButton btnNewButton_3 = new JButton((new ImageIcon("C:/Users/Manic-063/Desktop/t/project/logo.jpg")));
//		btnNewButton_3.setBounds(42, 25, 157, 70);
//		frame.getContentPane().add(btnNewButton_3);
//		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("게시글");
		lblNewLabel.setBounds(316, 17, 206, 78);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(font);
	
//		JButton btnNewButton_6 = new JButton(img);
//		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
//		gbc_btnNewButton_6.gridheight = 3;
//		gbc_btnNewButton_6.gridwidth = 3;
//		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton_6.gridx = 1;
//		gbc_btnNewButton_6.gridy = 1;
//		btnNewButton_6.setBorderPainted(false);
//		btnNewButton_6.setContentAreaFilled(false);
//		frame.getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);
//		
		
		
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
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(556, 116, 104, 23);	//작성일자 칸
		frame.getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setBorder(bb);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(658, 116, 69, 23);	// 조회수 칸
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setBorder(bb);
		
		JLabel lblNewLabel_8 = new JLabel("");
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
		
		JLabel lblNewLabel_14 = new JLabel(con2.getUser_id()); // 작성자
		lblNewLabel_14.setBounds(16, 139, 79, 21);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel(con2.getBctitle()); // 제목
		lblNewLabel_15.setBounds(104, 143, 442, 15);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel();
		lblNewLabel_16.setBounds(558, 139, 102, 23);
		frame.getContentPane().add(lblNewLabel_16);
		lblNewLabel_16.setBorder(bb);
		
		JLabel lblNewLabel_17 = new JLabel();
		lblNewLabel_17.setBounds(658, 139, 69, 23);
		frame.getContentPane().add(lblNewLabel_17);
		lblNewLabel_17.setBorder(bb);
		
		JLabel lblNewLabel_18 = new JLabel();
		lblNewLabel_18.setBounds(727, 139, 57, 23);
		frame.getContentPane().add(lblNewLabel_18);
		lblNewLabel_18.setBorder(bb);

		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(15, 177, 757, 513);
		frame.getContentPane().add(lblNewLabel_3); 	// 내용칸
		lblNewLabel_3.setBorder(bb);

		JLabel lblNewLabel_22 = new JLabel(con2.getBcontent()); // 내용
		lblNewLabel_22.setBounds(15, 177, 757, 513);
		frame.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_19 = new JLabel(con2.getSysdate());	// 작성일자
		lblNewLabel_19.setBounds(559, 140, 101, 23);
		frame.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel(con2.getBcviews());	//조회수
		lblNewLabel_20.setBounds(662, 140, 69, 23);
		frame.getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel(con2.getBclikes());	//추천수
		lblNewLabel_21.setBounds(731, 138, 57, 23);
		frame.getContentPane().add(lblNewLabel_21);
//		JScrollPane scrollPane = new JScrollPane(con2.getBcontent());
//		scrollPane.setBounds(11, 168, 760, 518);
//		frame.getContentPane().add(scrollPane);
//		
		JButton btnNewButton = new JButton("수정"); // 수정 창으로 이동
		btnNewButton.setBounds(566, 700, 97, 36);
		frame.getContentPane().add(btnNewButton);
//		btnNewButton.addActionListener(new ActionListener() { // 수정 버튼
//			public void actionPerformed(ActionEvent e) {
//				if(e.getActionCommand().equals("수정")) {
//					Correct correct = new Correct();
//				
//				}
//			
//			}
//		});
		JButton btnNewButton_1 = new JButton("나가기");
		btnNewButton_1.setBounds(675, 700, 97, 36);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() { // 나가기 버튼
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		JButton btnNewButton_2 = new JButton("추천 버튼");
		btnNewButton_2.setBounds(352, 700, 97, 36);
		frame.getContentPane().add(btnNewButton_2);
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
				if(e.getActionCommand().equals("수정")) {
					Correct correct = new Correct();
				
				}
			
			
		 Read read = new Read();
	}
}

