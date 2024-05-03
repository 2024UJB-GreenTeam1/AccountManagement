package FileInsert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardInsert {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver등록
			Class.forName("oracle.jdbc.OracleDriver");

			// 연결하기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "c##green", "green1234");
			// 매개변수화된 SQL문 작성
			String sql = "" + "INSERT INTO boards(bno, btitle, bmain, bdate,busy)"
					+ "VALUES(?,?,?,SYSDATE,1)";

			// PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			pstmt.setString(2, "음식게시판");
			pstmt.setString(3, "음식에 관련된 게시물을 공유해주세요");
//			pstmt.setInt(5,'1');
			

			// SQL 문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수 : " + rows);

			// PreparedStatement 닫기
			pstmt.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// 연결 끊기
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}