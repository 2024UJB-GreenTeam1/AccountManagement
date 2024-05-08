package Post;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Correct extends ComDto implements ActionListener, WindowListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
//	private Statement stmt;
	private Connection con;
//	private ResultSet rs;
	private JButton btnNewButton_2,btnNewButton_3,btnNewButton_1,btnNewButton;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3;
	private JComboBox gbc_cateCombo;
	
	
	public Correct() {
		
		con = null;

		ImageIcon img = new ImageIcon("button_image/logo.jpg");
		frame = new JFrame("게시글 수정");
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TextArea tx = new TextArea();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 21, 0, -33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton_2 = new JButton(img);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 3;
		gbc_btnNewButton_2.gridwidth = 3;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 1;
		 btnNewButton_2.setBorderPainted(false);
		 btnNewButton_2.setContentAreaFilled(false);
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("                                              제목 :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		String[] category = { " 운동 ", " 음식 " , " 수면시간"};
		JComboBox cateCombo = new JComboBox(category);
		GridBagConstraints gbc_cateCombo = new GridBagConstraints();
		gbc_cateCombo.insets = new Insets(0, 0, 5, 5);
		gbc_cateCombo.gridx = 1;
		gbc_cateCombo.gridy = 6;
		frame.getContentPane().add(cateCombo, gbc_cateCombo);
		
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 18;
		gbc_textField.insets = new Insets(5, 5, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 6;														// 제목
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(40);
		
//		for (int i = 0; i < list.size(); i++) {
//			ComDto data = (ComDto)list.get(i);
//			 gid = data.getUser_id();
//		} // "bcnickname"에 bcnickname 넣어야함 
		
		textField_1 = new JTextField();
		
		JLabel lblNewLabel_2 = new JLabel("작성자 :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 20;
		gbc_lblNewLabel_2.gridy = 6;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("아이디");
		
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 21;
		gbc_lblNewLabel_3.gridy = 6;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridheight = 20;
		gbc_textField_1.gridwidth = 25;
		gbc_textField_1.insets = new Insets(4, 8, 50, 50);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 8;
		frame.getContentPane().add(tx, gbc_textField_1);
		textField_1.setColumns(10);															 // 내용
		
		JLabel lblNewLabel = new JLabel("비밀번호 :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 26;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JPasswordField textField_2 = new JPasswordField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 9;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 26;	 // 비밀번호
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("수정");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 3;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 20;
		gbc_btnNewButton_3.gridy = 26;
		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		btnNewButton_3.setEnabled(false);
	
		JButton btnNewButton_4 = new JButton("삭제");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 3;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 17;
		gbc_btnNewButton_4.gridy = 26;
		frame.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_4.setEnabled(false);
	
		
		JButton btnNewButton_1 = new JButton("확인");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 13;
		gbc_btnNewButton_1.gridy = 26;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
//		 영어 & 숫자만 : ^[a-zA-Z0-9]
		
		
		JButton btnNewButton = new JButton("취소");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 23;
		gbc_btnNewButton.gridy = 26;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	
		frame.setVisible(true);
		
		
		
		btnNewButton.addActionListener(new ActionListener() { // 취소 버튼
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	
		btnNewButton_1.addActionListener(new ActionListener() { // 확인버튼
			
			public void actionPerformed(ActionEvent e) {
			
							
							String n= textField_2.getText() ;
							
							if( ! n.equals("123")) { // db에서 로그인 한 비밀번호 확인 후 수정 gpwd 
									System.out.print("비밀번호를 확인해주세요."); // 팝업창 나오게하기

								} else {
									System.out.print("확인되었습니다.");
									btnNewButton_3.setEnabled(true);
									btnNewButton_4.setEnabled(true);
							

				}
			}
		});
	}
		
//		btnNewButton_3.addMouseListener(new MouseAdapter() { // 수정 버튼
//			String title2 = textField.getText();
//			String content = tx.getText();
//			public void mouseClicked(MouseEvent e) {
//				Statement stmt;
//	
//				String sql = "update BCONTENTs set  title  " + title2+ " content  " +content + "where num = ?";
//				stmt = null;
//				try{
//				stmt = con.createStatement();
//					
//				int rs = stmt.executeUpdate(sql);
//				if( rs > 0) {
//					System.out.println("수정 성공");
//				}else {
//					System.out.println("수정 실패");
//
//				}
//				}catch (Exception c) {
//				c.printStackTrace();
//			}finally {
//				try {
//					stmt.close();
//					con.close();
//				}catch(SQLException c) {
//					c.printStackTrace();
//				}
//			}
//			}
//		});
//			
//	}
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
//	         BoardWrite bw = new BoardWrite();
	      
	      }
	   
	   }
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		Correct cor = new Correct();
		  cor.frame.setVisible(true);
	}
		 });	
}
}




























