package Post;
//사용함

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
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
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Correct extends ComDto implements ActionListener, WindowListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

    private JComboBox<String> comboBox;
    private Map<String, Integer> itemToNumberMap;
//	private ResultSet rs;
	private JButton btnNewButton_2,btnNewButton_3,btnNewButton_1,btnNewButton;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3;
	private JComboBox gbc_cateCombo;
	private JTextArea textField2;
//	Scanner sc = new Scanner(System.in);
	static int plz ;
	String driver = "ora"+ "cle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	Connection con = null;
	PreparedStatement pstmt= null;
	PreparedStatement pstmt1= null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	String bcno;	
	String bno;
	String bctitle;
	String user_id;
	String bcontent ;
	String bcdate ;
	int bcviews;
	int bclikes;
	String bcdelete ;
	String bcfilename;
	Blob bcfiledata;
	ImageIcon icon;
	String pwd;
	JDialog info1,info,info2;
	
	
	  int selectedNumber=0;
    public static void showFrame(int plz) {
    	System.out.println("눌러짐");
        Correct correct = new Correct(plz);
        correct.frame.setVisible(true);
    }
	public Correct(int plz) {
		
		con = null;

		ImageIcon img = new ImageIcon("button_image/logo.jpg");
		frame = new JFrame("게시글 수정");
		frame.setBounds(560, 180, 800, 800);
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
		
//		String[] category = { " 전체 "," 운동 ", " 음식 " , " 수면시간"};
		
		
		comboBox = new JComboBox<>();
		itemToNumberMap = new HashMap<>();
		
		addItemWithNumber("전체", 1);
        addItemWithNumber("운동", 2);
        addItemWithNumber("음식", 3);
        addItemWithNumber("수면시간", 4);
        

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = comboBox.getSelectedIndex();
                selectedNumber = selectedIndex ;
                System.out.println("선택한 값의 번호: " + selectedNumber);
            }
        });
		GridBagConstraints gbc_cateCombo = new GridBagConstraints();
		gbc_cateCombo.insets = new Insets(0, 0, 5, 5);
		gbc_cateCombo.gridx = 1;
		gbc_cateCombo.gridy = 6;
		frame.getContentPane().add(comboBox, gbc_cateCombo);
		
		
//		int selectedIndex = comboBox.getSelectedIndex();
//		String selectedItem = null;
//		if (selectedIndex >= 0 && selectedIndex < comboBox.getItemCount()) {
//		    selectedItem = comboBox.getItemAt(selectedIndex);
//		}
//		if (selectedItem != null) {
//		    comboBox.setSelectedItem(selectedItem);
//		}
//		int selectedNumber = selectedIndex + 1;
//
//		System.out.println("선택한 값의 번호: " + selectedIndex);
		
		
		
		
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
		//		bcfiledata = rs.getBlob("BCFILEDATA");
				bcviews = rs.getInt("bcviews");
				bclikes = rs.getInt("bclikes");
		
	
		//System.out.println(bcno);
//				icon = new ImageIcon(image);
			}
			System.out.println(bcno + " , " + bno + " , " + user_id + " , " + " , " + bctitle + " , "
					+ bcontent + " , " + bcdate + " , " + bcdelete + " , " + bcviews  + " , "	+ bclikes);
	

		
			
		JLabel lblNewLabel_2 = new JLabel("작성자 :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 20;
		gbc_lblNewLabel_2.gridy = 6;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(user_id);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 21;
		gbc_lblNewLabel_3.gridy = 6;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField = new JTextField(bctitle);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 18;
		gbc_textField.insets = new Insets(5, 5, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 6;														// 제목
		frame.getContentPane().add(textField, gbc_textField); // 제목
		textField.setColumns(40);
		textField_1 = new JTextField();
		
		
		 textField2 = new JTextArea (bcontent); // 내용
		textField2.setLineWrap(true);
		textField2.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textField2);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridheight = 20;
		gbc_textField_1.gridwidth = 25;
		gbc_textField_1.insets = new Insets(4, 8, 50, 50);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 8;
		frame.getContentPane().add(scrollPane, gbc_textField_1);
		textField_1.setColumns(10);															 // 내용
		
		JLabel lblNewLabel = new JLabel("비밀번호 :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 26;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
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
		JPasswordField passwordField = new JPasswordField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 9;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 26;	 												// 비밀번호
		frame.getContentPane().add(passwordField, gbc_textField_2);
		passwordField.setColumns(10);
		JButton btnNewButton_3 = new JButton("수정");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 3;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 20;
		gbc_btnNewButton_3.gridy = 26;
		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		btnNewButton_3.setEnabled(false);
	
		
	btnNewButton_3.addActionListener(new ActionListener() { // 수정 버튼
			
			public void actionPerformed(ActionEvent e) {

				try {
					
					
					String textField5 = textField.getText();
					String textField6 = textField2.getText();
					pstmt =null;
					con = DriverManager.getConnection(url, user, password);
					String sql = " UPDATE BCONTENTS SET BCTITLE = ?, BCONTENT = ?, BNO = ? WHERE BCNO = ?";
					pstmt = con.prepareStatement(sql);
				//	System.out.println("bno 번호 :" +selectedNumber);
					pstmt.setString(1,textField5);
					pstmt.setString(2,textField6);
					pstmt.setInt(3,selectedNumber);
					pstmt.setInt(4,plz);
					
					System.out.println("pstmt: " + pstmt);
					rs = pstmt.executeQuery();
					System.out.println("rs : " + rs);
					

					 info1 = new JDialog(frame,"안내창",true);
					info1.setSize(200,100);
					info1.setLocation(850, 550);
					info1.setLayout(new FlowLayout());
					
					JLabel mas = new JLabel("정상적으로 수정되었습니다.",JLabel.CENTER);
					JButton ok1 = new JButton("확인");
					info1.add(mas);
					info1.add(ok1);

					ok1.addActionListener(new ActionListener() { // 수정 버튼
						public void actionPerformed(ActionEvent e) {
							info1.dispose(); 
							frame.dispose();
						}
					});
					info1.setVisible(true);
				}catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						if(rs !=null) {
							rs.close();
						}
					}catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				 // frame.dispose();		
				}
		});

		
		
		
		JButton btnNewButton_4 = new JButton("삭제");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 3;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 17;
		gbc_btnNewButton_4.gridy = 26;
		frame.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_4.setEnabled(false);
		
		
		JButton ok2 = new JButton("확인");
		JButton no2 = new JButton("취소");
		btnNewButton_4.addActionListener(new ActionListener() { // 삭제 버튼
			
			public void actionPerformed(ActionEvent e) {

				info2 = new JDialog(frame,"안내창",true);
				info2.setSize(200,100);
				info2.setLocation(850, 550);
				info2.setLayout(new FlowLayout());
					
				JLabel mas2 = new JLabel("정말 삭제하시겠습니까 ?",JLabel.CENTER);
				info2.add(mas2);
				info2.add(ok2);
				info2.add(no2);
				info2.setVisible(true);
			}
		});
		
			
				 ok2.addActionListener(new ActionListener() { // 확인 버튼
			            public void actionPerformed(ActionEvent e) {
			
				try {
					pstmt =null;
					con = DriverManager.getConnection(url, user, password);
					String sql = "DELETE BCONTENTS WHERE BCNO = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,plz);
					
					System.out.println("pstmt: " + pstmt);
					int rs = pstmt.executeUpdate();
					System.out.println("rs : " + rs);
					  
                    if (rs > 0) {
                        System.out.println("삭제 성공");
                    } else {
                        System.out.println("삭제 실패");
                    }
						info2 = new JDialog(frame,"안내창",true);
						info2.setSize(200,100);
						info2.setLocation(850, 550);
						info2.setLayout(new FlowLayout());
						
						
				}catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						if(rs !=null) {
							rs.close();
						}
					}catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				
				info2.dispose(); 
				frame.dispose();
				  	}

		
		});
			
				no2.addActionListener(new ActionListener() { // 취소 버튼
					public void actionPerformed(ActionEvent e) {
						info2.dispose(); 
						frame.dispose();
					}
		});
		
		
	
		
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
				  frame.dispose(); 
			}
		});
	
		btnNewButton_1.addActionListener(new ActionListener() { // 확인버튼
			
			public void actionPerformed(ActionEvent e) {

				try {
					pstmt =null;
					con = DriverManager.getConnection(url, user, password);
					String sql = "SELECT USERS.PWD FROM BCONTENTS  JOIN USERS  ON BCONTENTS.USER_ID = USERS.USER_ID where bcno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,plz);
					
					System.out.println("pstmt: " + pstmt);
					rs = pstmt.executeQuery();
					System.out.println("rs : " + rs);

			
					
					while (rs.next()) {
					pwd = rs.getString("PWD");
				
					// 실행시켜서 숫자 입력하고 확인해보면 null값이 나오는데 null이 아닌 값으로 나오게 하면 성공
					// 값만 나오게 해서 붙이면 됨 그리고 연결할때 버튼에 있는 숫자 대입하면 될듯	
//						InputStream inputStream = blob.getBinaryStream();
//						BufferedImage image = ImageIO.read(inputStream);
//						icon = new ImageIcon(image);
					}
			
					System.out.println(pwd);
				
							char[] pwd1 = passwordField.getPassword();
							String pwd2= new String (pwd1);
							System.out.println(pwd2);
							if( ! pwd2.equals(pwd)) { // db에서 로그인 한 비밀번호 확인 후 수정 gpwd 
								//frame = new JFrame("확인해주세요");
								 info = new JDialog(frame,"안내창",true);
								info.setSize(200,100);
								info.setLocation(850, 550);
								info.setLayout(new FlowLayout());
								
								JLabel mas = new JLabel("비밀번호를 확인해주세요.",JLabel.CENTER);
								JButton ok = new JButton("확인");
								info.add(mas);
								info.add(ok);
								ok.addActionListener(new ActionListener() { // ok버튼
									public void actionPerformed(ActionEvent e) {
										info.dispose(); 
									}
								});
								
								System.out.print("비밀번호를 확인해주세요."); // 팝업창 나오게하기
								info.setVisible(true);
								
								
								} else {
									System.out.println("확인되었습니다.");
									btnNewButton_3.setEnabled(true);
									btnNewButton_4.setEnabled(true);
							

				}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						if(rs !=null) {
							rs.close();
						}
					}catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				 	}
		});
	}
	


			
	private void addItemWithNumber(String category, int plz) {
		itemToNumberMap.put(category, plz);
        comboBox.addItem(category);
		
	}
	public int getNumberForItem(String item) {
        return itemToNumberMap.get(item);
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
		   frame.dispose(); 
		   info.dispose();
		   info1.dispose();
		   
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
		   
	   
	   }
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			 Correct cor = new Correct(plz);
					//EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								
							//	Read read = new Read();
							//	window.frame.setVisible(true);
								cor.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
				
				

		 });	
	}
}
