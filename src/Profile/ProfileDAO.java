package Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.InfoVo;

public class ProfileDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private InfoVo info;

	public ProfileDAO() {
		connDB();
	}

	// 회원 탈퇴 아직 해결하지 못함
	public void delete(DTO user) {
		String userId1 = InfoVo.getInstance().getId();
		try {
			String deletesql = "" + "DELETE FROM DAILYINPUT WHERE USER_ID = ?";
			PreparedStatement pstmt1 = con.prepareStatement(deletesql);
			pstmt1.setString(1, userId1);
			pstmt1.executeUpdate();
			pstmt1.close();
			
//			String deletesql2 = "" + "DELETE FROM LOGIN WHERE USER_ID = ?";
//			PreparedStatement pstmt2 = con.prepareStatement(deletesql2);
//			pstmt2.setString(1, userId1);
//			pstmt2.executeUpdate();
//			pstmt2.close();
						
			String sql = "" + "DELETE FROM USERS WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId1);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	// 몸무게 키 수정 몸무게는 데일리에서 가져와야 해서 쿼리문 수정 해야됨
	public void updateHW(int height, int weight) {
		String userId1 = InfoVo.getInstance().getId();
		try {
			String updateUserSql = "UPDATE USERS SET HEIGHT = ? WHERE USER_ID = ?";
			PreparedStatement updatePstmt = con.prepareStatement(updateUserSql);
			updatePstmt.setInt(1, height);
			updatePstmt.setString(2, userId1);
			updatePstmt.executeUpdate();
			updatePstmt.close();

			// DAILYINPUT 테이블에 몸무게 삽입
			String insertDailyInputSql = "UPDATE DAILYINPUT SET WEIGHT = ? WHERE USER_ID = ?";
			PreparedStatement insertPstmt = con.prepareStatement(insertDailyInputSql);
			insertPstmt.setInt(1, weight);
			insertPstmt.setString(2, userId1);
			insertPstmt.executeUpdate();
			insertPstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 비밀번호 업데이트 완료
	public void updatepwd(String pwd, String userId) {
		String userId1 = InfoVo.getInstance().getId();

		try {
			String sql = "" + "UPDATE USERS SET PWD =? " + " WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, userId1);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 이메일 업데이트 완료
	public void updatemail(String email, String userId) {
		String userId1 = InfoVo.getInstance().getId();
		try {
			String sql = "" + "UPDATE USERS SET EMAIL =? " + " WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, userId1);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원정보 표시
	public DTO getUserProfile(String userId) {
		DTO userProfile = null;
		String userId1 = InfoVo.getInstance().getId();

		try {
			String sql = "SELECT USERs.*, dailyinput.WEIGHT " + "FROM USERS "
					+ "JOIN DAILYINPUT ON users.USER_ID  = dailyinput.USER_ID " + "WHERE users.USER_ID =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId1);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 사용자 정보를 ProfileDTO 객체에 담기
				String name = rs.getString("name");
				String id = rs.getString("USER_ID");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String year = rs.getString("year");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				userProfile = new DTO(name, id, email, phone, year, height, weight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//리소스해제코드?
//		    try {
//		        if (rs != null) rs.close();
//		        if (pstmt != null) pstmt.close();
//		        if (con != null) con.close();
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		    }
		}

		return userProfile;
	}

	void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
