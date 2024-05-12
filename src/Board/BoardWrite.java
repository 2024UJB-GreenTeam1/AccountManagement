package Board;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import login.InfoVo;

public class BoardWrite extends BoardDTO implements WindowListener, ActionListener {
	private JTextArea maincontent2;
	private JFrame f;
	private JLabel title;
	private JPanel maindp, maindptitle2, content2;
	private JButton write, cancle, maincontent,fileButton;
	private JTextField maindptitlecontent,fileTextField;
	private Choice category;
	public BoardWrite() {
		Font font = new Font("맑은 고딕", Font.BOLD, 50);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);

		f = new JFrame("새글작성");
		f.setSize(800, 800);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.addWindowListener(this);

		JButton write = new JButton("작성");
		write.setBounds(12, 584, 102, 40);
		write.addActionListener(this);
		
		//첨부파일 버튼 //
		 fileTextField = new JTextField();
	        fileTextField.setEditable(false);
	        fileTextField.setColumns(20);
	        fileTextField.setBounds(300, 584, 102, 40);
	        fileButton = new JButton("첨부파일...");
	        fileButton.setBounds(405, 584, 102, 40);
	        fileButton.addActionListener(this);
	       
	       
	        
		category = new Choice();
		category.add("");
		category.add("exercise");  //1
		category.add("food");  //2
		category.add("sleep"); //3
		category.setFont(font2);
		category.setSize(200, 100); // 카테고리
		category.setLocation(50, 10);
		f.add(category);

		JButton cancle = new JButton("취소");
		cancle.setBounds(670, 584, 102, 40);
		cancle.addActionListener(this);

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
		content2.add(maindptitle2_1);
		maindptitle2_1.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		maindptitle2_1.setLayout(null);

		JLabel maindptitle = new JLabel("제목");
		maindptitle.setBounds(0, 0, 50, 38);
		maindptitle.setHorizontalAlignment(JLabel.CENTER);
		maindptitle.setFont(font2);
		maindptitle2_1.add(maindptitle);
		maindptitle.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

		maindptitlecontent = new JTextField("");
		maindptitlecontent.setBounds(50, 1, 707, 37);
		maindptitle2_1.add(maindptitlecontent);
		maindptitlecontent.setColumns(10);

		JLabel content = new JLabel("내용");
		content.setBounds(0, 36, 50, 464);
		content.setFont(font2);
		content.setHorizontalAlignment(JLabel.CENTER);
		content2.add(content);
		content.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

		maincontent2 = new JTextArea("");
		maincontent2.setBounds(50, 38, 705, 460);
		content2.add(maincontent2);

		JLabel title_1 = new JLabel("새글작성");
		title_1.setBounds(257, 10, 200, 40);
		f.getContentPane().add(title_1);
		title_1.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
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
		} else if (e.getActionCommand().equals("작성")) {
			String num =category.getSelectedItem();
			int a = 0;
			String b = "";
			if(num.equals("")) {
				a=0;
				b=Integer.toString(a);	
			}else if(num.equals("exercise")){
				a=1;
				b=Integer.toString(a);	
			}else if(num.equals("food")) {
				a=2;
				b=Integer.toString(a);	
			}else if(num.equals("sleep")) {
				a=3;
				b=Integer.toString(a);	
			}
			
			try {
				ConnectionB cb = new ConnectionB(); // 연결
				 File file = new File(fileTextField.getText());
				 String fileName = file.getName();
				String userId1 = InfoVo.getInstance().getId();					//로그인아이디얻기 싱클톤패턴
				Connection conn = DriverManager.getConnection(URL, USERID, USERPWD);
				String sql = "" + "insert into bcontents(bno,bcno, "
						+ "bctitle,bcontent, "
						+ "bcdate,bclikes,"
						+ "bcviews,bcfilename,bfiledata,User_id) "
						+ "values(+"+b+",SEQ_BCNO.NEXTVAL,?,?,to_char(Sysdate,'YYYY-MM-DD'),?,?,?,?,?) ";/*SEQ_BCNO.NEXTVAL*/
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, maindptitlecontent.getText());
				// System.out.println(maindptitlecontent.getText());
				pstmt.setString(2, maincontent2.getText());
				// System.out.println(maincontent2.getText());
				pstmt.setInt(3, 0);
				pstmt.setInt(4, 0);
				pstmt.setString(5, fileName);						
				FileInputStream inputStream = new FileInputStream(file);
				pstmt.setBlob(6,inputStream);	
				pstmt.setString(7, userId1);									//USER_ID넣기
				pstmt.executeUpdate();

				maindptitlecontent.setText("");
				maincontent2.setText("");

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
