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
	private InfoVo info;			//★☆★☆★☆★☆★☆★☆
		
	public ProfileDAO() {
		connDB();
	}

	// 회원 탈퇴
	public void delete(String id) {
		try {
			String sql = "" + "DELETE FROM USERS Where bweriter=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int rows = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	// 몸무게 키 수정 몸무게는 데일리에서 가져와야 해서 쿼리문 수정 해야됨
	public void updateHW(String userId, char height, char weight) {
		try {
			String sql = "UPDATE USERS SET HEIGHT=?, WEIGHT=? WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(height));
			pstmt.setString(2, String.valueOf(weight));
			pstmt.setString(3, userId);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 비밀번호 업데이트
	public void updatepwd(String pwd, String userId) {
		try {
			String sql = "" + "UPDATE ISERS SET PWD =? " + " WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 이메일 업데이트
	public void updatemail(String email, String userId) {
		try {
			String sql = "" + "UPDATE ISERS SET EMAIL =? " + " WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원정보 표시
	public DTO getUserProfile(String userId) {		//★☆★☆★☆★☆★☆
        DTO userProfile = null;
        String userId1 = InfoVo.getInstance().getId();

        try {
            String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
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
				userProfile = new DTO(name, id, email, phone, year, height);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제 코드??
        }

        return userProfile;
    }


	

	private void connDB() {
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
