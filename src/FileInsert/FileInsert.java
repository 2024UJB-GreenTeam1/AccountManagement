package FileInsert;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;			//TestTestTestTestTestTestTestTestTestTestTest

public class FileInsert {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn=DriverManager.getConnection( 
					"jdbc:oracle:thin:@localhost:1521/XE",
					"c##green",
					"green1234"
					);
			
			//매개변수화된 SQL 문 작성
			String sql = ""+
//			"INSERT INTO board(bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata)"+
//					"VALUES(SEQ_BNO.NEXTVAL,? ,?,?,SYSDATE,?,?)";
			
			"INSERT INTO BCONTENTS(bcno,bno,user_id, bcnickname,bctitle,bcontent,bcdate,"
			+ "bcdelete,bcfilename,bfiledata,bcviews,bclikes)"+
			"VALUES(SEQ_BNO.NEXTVAL,?,? ,?,?,?,SYSDATE,?,?,?,?,?)";	/*SEQ_BNO.NEXTVAL*/
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"bno"});
//			pstmt.setInt(1,1);
			pstmt.setInt(1,2);
			pstmt.setString(2,"GREEN");
			pstmt.setString(3,"감자중독자");
			pstmt.setString(4,"누가 내 감자를 옮겼을까?");
			pstmt.setString(5,"감자튀김, 감자볶음, 감자떡, 감자칩, 감자밥, 감자탕, 감자가 너무좋아. 감자는 다이어트에 효능을 보인다.");
			pstmt.setInt(6,0);
			pstmt.setString(7,"potato.jpg");
			pstmt.setBlob(8,new FileInputStream("src/FileInsert/potato.jpg"));
			pstmt.setInt(9,0);
			pstmt.setInt(10,0);
			
			//SQL 문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: "+rows);
			
			//bno 값 얻기
			if(rows ==1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno: "+bno);
				}
				rs.close();
			}
			//PreparedStatement 닫기
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					//연결 끊기
					conn.close();
				}catch (SQLException e) {}
			}
		}
		
	}

}
