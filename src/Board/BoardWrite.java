package Board;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Board.Boardset;
import login.InfoVo;
import Board.ConnectionB;

public class BoardWrite extends BoardDTO implements WindowListener, ActionListener {
	private JTextArea maincontent2;
	private JFrame f;
	private JLabel title;
	private JPanel maindp, maindptitle2, content2;
	private JButton write, cancle, maincontent,fileButton;
	private JTextField maindptitlecontent,fileTextField;
	private Choice category;
	BoardWrite bw;
	public BoardWrite() {
		Font font = new Font("맑은 고딕", Font.BOLD, 50);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 20); // 작성자 내용 날짜 추천수 조회수 카테고리
		Font font4 = new Font("MD아롱체", Font.ITALIC, 20);
		Color gr = new Color(205, 250, 219);
		
		
		f = new JFrame("새글작성");
		f.setSize(800, 800);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.addWindowListener(this);
		f.getContentPane().setBackground(Color.white); // JFrame은 이걸로

		JButton write = new JButton("작성");
		write.setBounds(12, 584, 102, 40);
		write.addActionListener(this);
		write.setContentAreaFilled(false);
		write.setBackground(Color.white);
		
		//첨부파일 버튼 //  
		fileTextField = new JTextField();
        fileTextField.setEditable(false);
        fileTextField.setColumns(20);
        fileTextField.setBounds(300, 584, 102, 40);
        fileTextField.setBackground(Color.white);
        fileButton = new JButton("첨부파일");
        fileButton.setContentAreaFilled(false);
        fileButton.setBackground(Color.white);
        fileButton.setBounds(405, 584, 102, 40);
		fileButton.addActionListener(this);
	       
	       
	        
		category = new Choice();
		category.add("Total");
		category.add("Exercise");  //1
		category.add("Food");  //2
		category.add("Sleep"); //3
		category.setFont(font4);
		category.setSize(200, 100); // 카테고리
		category.setLocation(50, 10);
		f.add(category);

		JButton cancle = new JButton("취소");
		cancle.setBounds(670, 584, 102, 40);
		cancle.addActionListener(this);
		cancle.setContentAreaFilled(false);
		cancle.setBackground(Color.white);
		
		JPanel maindp = new JPanel();
		maindp.setBounds(0, 90, 600, 335);
		maindp.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

		JPanel content2 = new JPanel(); // 메인쪽패널
		content2.setBounds(15, 60, 757, 500);
		content2.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

		// textArea = new JTextArea(); //내용
		// textArea.setBounds(33, 100, 565, 312);
		// textArea.setColumns(10);

		f.getContentPane().add(cancle);
		f.getContentPane().add(write);
		f.getContentPane().add(content2);
		f.getContentPane().add(fileTextField);
		f.getContentPane().add(fileButton);
		content2.setLayout(null);

		JPanel maindptitle2_1 = new JPanel();
		maindptitle2_1.setBounds(0, 0, 756, 38);
		maindptitle2_1.setBackground(gr);
		content2.add(maindptitle2_1);
		maindptitle2_1.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		maindptitle2_1.setLayout(null);

		JLabel maindptitle = new JLabel("제목");
		maindptitle.setBounds(0, 0, 50, 38);
		maindptitle.setHorizontalAlignment(JLabel.CENTER);
		maindptitle.setFont(font4);
		maindptitle2_1.add(maindptitle);
		maindptitle.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

		maindptitlecontent = new JTextField("");
		maindptitlecontent.setBounds(50, 1, 707, 37);
		maindptitle2_1.add(maindptitlecontent);
		maindptitlecontent.setColumns(10);

		JLabel content = new JLabel("내용");
		content.setBounds(0, 36, 50, 464);
		content.setFont(font4);
		content.setHorizontalAlignment(JLabel.CENTER);
		content2.setBackground(gr);
		content2.add(content);
		content.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

		maincontent2 = new JTextArea("");
		maincontent2.setBounds(50, 38, 705, 460);
		content2.add(maincontent2);

		JLabel title_1 = new JLabel("새글작성");
		title_1.setBounds(257, 10, 200, 40);
		f.getContentPane().add(title_1);
		title_1.setFont(new Font("MD아롱체", Font.PLAIN, 40));
		title_1.setHorizontalAlignment(JLabel.CENTER);
		f.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
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
	public void actionPerformed(ActionEvent e) { // 나중에 작성부분 command로 옮기기
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("취소")) {
			f.setVisible(false);
			Boardset bs = new Boardset();
		 		} else if (e.getActionCommand().equals("작성")) {
			String num =category.getSelectedItem();
			int a = 0;
			String b = "0";
			if(num.equals("Total")) {
				a=0;
				b=Integer.toString(a);	
			}else if(num.equals("Exercise")){
				a=1;
				b=Integer.toString(a);	
			}else if(num.equals("Food")) {
				a=2;
				b=Integer.toString(a);	
			}else if(num.equals("Sleep")) {
				a=3;
				b=Integer.toString(a);	
			}
			
			try {
				ConnectionB cb = new ConnectionB(); // 연결
				 File file = new File(fileTextField.getText());
				 String fileName = file.getName();
				String userId1 = InfoVo.getInstance().getId();					//로그인아이디얻기 싱클톤패턴
				Connection conn = DriverManager.getConnection(url, user, password);
				String sql = "" + "insert into bcontents(bno,bcno, "
						+ "bctitle,bcontent, "
						+ "bcdate,bclikes,"
						+ "bcviews,bcfilename,bfiledata,User_id) "

// 						+ "values(" + b + ",BCNO.NEXTVAL,?,?,SYSDATE,?,?,?,?,'green') ";/*SEQ_BCNO.NEXTVAL*/

// 						+ "values(" + b + ",BCNO.NEXTVAL,?,?,SYSDATE,?,?,?,?,'green') ";/*SEQ_BCNO.NEXTVAL*/

						+ "values("+b+",SEQ_BCNO.NEXTVAL,?,?,SYSDATE,?,?,?,?,?) ";/*SEQ_BCNO.NEXTVAL*/

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, maindptitlecontent.getText());
				// System.out.println(maindptitlecontent.getText());
				pstmt.setString(2, maincontent2.getText());
				// System.out.println(maincontent2.getText());
				pstmt.setInt(3, 0);
				pstmt.setInt(4, 0);
				//if(file != null || fileName != null) {
				pstmt.setString(5, fileName);						
				FileInputStream inputStream = new FileInputStream(file);
				pstmt.setBlob(6,inputStream);	
				//}else {
				//	pstmt.setstring(5);
				//	pstmt.setBlob(6);
				//}
        	pstmt.setString(7,userId1);	
				pstmt.executeUpdate();

				maindptitlecontent.setText("");
				maincontent2.setText("");
				
				// 완료메시지
				JOptionPane.showMessageDialog(f, 
						"게시글 등록이 완료되었습니다.", "BoardWrite", JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						Boardset bs = new Boardset();

			} catch (SQLException | FileNotFoundException e2) {
				e2.printStackTrace();
			} finally {
				try {	
					pstmt.close();
					// System.exit(0);
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
				
			}
		
			
		}
		//첨부파일창
		if (e.getSource() == fileButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg"));

            int result = fileChooser.showOpenDialog(f);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileTextField.setText(selectedFile.getAbsolutePath());
            }
        }
	}

}
