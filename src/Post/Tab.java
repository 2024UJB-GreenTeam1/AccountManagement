package Post;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
// 			read 게시글에서 이미지 버튼 눌러서 이미지 있으면 이미지 창이 뜨게 만들기
// 수정 눌렀을때 제목 칸이 줄어드는거 수정하기
// 게시글을 눌렀을때 이미지가 없다면 이미지 버튼이 없고 있다면 이미지이 있게 해보기 아마 if문 사용하면 될듯 싶음

import kakaomap.Correct;

public class Tab  extends JFrame{
	private JTabbedPane jTabbedPane;
	private JPanel tab1Panel;
	private JPanel tab2Panel;
	private JFrame frame;
	String sql = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	ImageIcon icon;
	Image image;
	Image img;
	Blob bfiledata;
	
	String driver = "ora" + "cle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();
	
	public static void showFrame() {

		System.out.println("눌러짐");
		Tab tab = new Tab();
		tab.frame.setVisible(true);
	//	tab.Tabframe();
	}

	

//	public  Tabframe() {
//
//	}
	
	public Tab() {
		frame = new JFrame("이미지 출력");

		frame.setBounds(200, 200, 280, 280);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);

		sql = "select bfiledata from bcontents where bcno = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,i);
		System.out.println("pstmt: " + pstmt);
		rs = pstmt.executeQuery();
		System.out.println("rs : " + rs);
		if(rs.next()) {
			bfiledata = rs.getBlob("bfiledata");
			
			try {
				  byte[] imageData = bfiledata.getBytes(1, (int) bfiledata.length()); // Blob 데이터를 바이트 배열로 변환
				    ByteArrayInputStream bis = new ByteArrayInputStream(imageData); // ByteArrayInputStream을 사용하여 바이트 배열을 스트림으로 읽음
				    img = ImageIO.read(bis); // 이미지 읽기
				    icon = new ImageIcon(img); // ImageIcon 생성
				    JLabel label = new JLabel(icon);
				    frame.getContentPane().add(label);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}   
	
	public static void main(String[] args) {
//		Tab tab = new Tab();
//		tab.showFrame();
		 SwingUtilities.invokeLater(new Runnable() {
			
					//EventQueue.invokeLater(new Runnable() {
						public void run() {
							
							Tab.showFrame();
						}
				
				
							// 
		 });	
	}
}
