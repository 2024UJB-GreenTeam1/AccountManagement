package Post;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ReadDao {
	Scanner sc = new Scanner(System.in);

	String driver = "ora" + "cle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	String sql = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;

	String bcno ;
	String bno ;
	String user_id ;
	String bcnickname;
	String bctitle ;
	String bcontent ;
	String bcdate ;
	String bcdelete;
	int bcviews;
	int bclikes;
	Blob bcfiledata;
	String bcfilename;  
	
	
//	int i = sc.nextInt();
	
	//ResultSet rs = null;
//	public ResultSet select() {
//		try {
//		//	int num = sc.nextInt();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, user, password);
//			String sql = " select * from bcontents ";
//			pstmt = con.prepareStatement(sql);
//			//pstmt.setInt(1,num);
//			System.out.println("pstmt: " + pstmt);
//			rs = pstmt.executeQuery();
//			System.out.println("rs : " + rs);
//
//			while (rs.next()) {
//				bcno = rs.getString("bcno");
//				bno = rs.getString("bno");
//				user_id = rs.getString("user_id");
//				bcnickname = rs.getString("bcnickname");
//				bctitle = rs.getString("bctitle");
//				bcontent = rs.getString("bcontent");
//				bcdate = rs.getString("bcdate");
//				bcdelete = rs.getString("bcdelete");
//				bcfilename = rs.getString("bcfilename");
//		//		bcfiledata = rs.getBlob("BCFILEDATA");
//				bcviews = rs.getInt("bcviews");
//				bclikes = rs.getInt("bclikes");
//			   
//		        
//				Object data[] = { bcno, bno, user_id, bcnickname, bctitle, bcontent, bcdate, bcdelete, bcviews,
//						bcfiledata, bclikes };
//				// model.addRow(data);
//				System.out.println(bcno + " , " + bno + " , " + user_id + " , " + bcnickname + " , " + bctitle + " , "
//						+ bcontent + " , " + bcdate + " , " + bcdelete + " , " + bcviews + " , " + bcfiledata + " , "
//						+ bclikes);
//
//			}
//		} catch (Exception e) {
//			System.out.println("select() 실행 오류 : " + e);
//		}
//		return rs;
//	}

//	public int getBclikes() {
//	
//		return bclikes;
//	}
//
//	public void updatebclikes(int newBclikes) {
//	this.bclikes = newBclikes;
//
//	try {
//	String driver = "ora"+ "cle.jdbc.driver.OracleDriver";
//	con=DriverManager.getConnection(url,user,password);
//	String sql = "update bcontents set bclikes = bclikes + 1 where bcno = ?"; 
//	try (PreparedStatement pstmt = con.prepareStatement(sql)){
//		pstmt.setInt(1,i);
//		pstmt.executeUpdate();
//	}
//	}catch(SQLException e) {
//		e.printStackTrace();
//	} finally {
//		if (con !=null) {
//			try {
//				con.close();
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
//	try {
//		
//		Class.forName(driver);
//		con = DriverManager.getConnection(url, user, password);
//		
//		String sql = " select * from bcontents where bcno = ?";
//		
//		try(PreparedStatement pstmt = con.prepareStatement(sql)){
//			pstmt.setInt(1,num);
//			pstmt.executeUpdate(); 
//		}
////		System.out.println("pstmt: " + pstmt);
////		rs = pstmt.executeQuery();
////		System.out.println("rs : " + rs);
//
//
//	public void update() {
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, user, password);
//
//			sql = "select * from bcontents";
//			pstmt = con.prepareStatement(sql);
//			System.out.println("pstmt: " + pstmt);
//			rs = pstmt.executeQuery();
//			System.out.println("rs : " + rs);
//
//			if (rs.next()) {
//				System.out.print("수정할 제목 입력 >> ");
//				String bctitle = sc.next(); // 제목 입력
//				System.out.print("수정할 내용 입력 >> ");
//				String bcontent = sc.next();
//				sql = " update bcontents " + "set bctitle = ?," + "  bcontent= ? " + "where bcno = ?; ";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, bctitle);
//				pstmt.setString(2, bcontent);
//				int re = pstmt.executeUpdate();
//				if (re == 1) {
//					System.out.println("수정 성공");
//				} else {
//					System.out.println("수정 실패");
//				}
//			} else {
//				System.out.println("수정 실패");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	public ResultSet iselect() {
//	
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, user, password);
//			String sql = " select * from bcontents where bcno = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1,i);
//			
//			System.out.println("pstmt: " + pstmt);
//			rs = pstmt.executeQuery();
//			System.out.println("rs : " + rs);
//
//			while (rs.next()) {
//				bcno = rs.getString("bcno");
//				bno = rs.getString("bno");
//				user_id = rs.getString("user_id");
//				bcnickname = rs.getString("bcnickname");
//				bctitle = rs.getString("bctitle");
//				bcontent = rs.getString("bcontent");
//				bcdate = rs.getString("bcdate");
//				bcdelete = rs.getString("bcdelete");
//				bcfilename = rs.getString("bcfilename");
//		//		bcfiledata = rs.getBlob("BCFILEDATA");
//				bcviews = rs.getInt("bcviews");
//				bclikes = rs.getInt("bclikes");
//				
//			
//		        
////				Object data[] = { bno, user_id, bcnickname, bctitle, bcontent, bcdate, bcdelete, bcviews,
////						bcfiledata, bclikes };
//				// model.addRow(data);
//				System.out.println(bcno + " , " + bno + " , " + user_id + " , " + bcnickname + " , " + bctitle + " , "
//						+ bcontent + " , " + bcdate + " , " + bcdelete + " , " + bcviews + " , "  + " , "
//						+ bclikes);
//					System.out.println(rs);
//			}
//		} catch (Exception e) {
//			System.out.println("select() 실행 오류 : " + e);
//		}
//		return rs;
//	}

}