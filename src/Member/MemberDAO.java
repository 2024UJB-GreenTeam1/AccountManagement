package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "C##GREEN";
	String password = "GREEN1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO() {
		connDB();
	}

	// 아이디 중복 확인 메서드
	public boolean isIdDuplicate(String userId) {
		try {
			String sql = "SELECT COUNT(*) AS count FROM MEMBERS WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("count");
				return count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 닉네임 중복 확인 메서드
	public boolean isNickname(String Name) {
		try {
			String sql = "SELECT COUNT(*) AS count FROM MEMBERS WHERE NAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("count");
				return count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int insert(String id, String name) {
		int i = 0;
		try {
			String sql = "" + "INSERT INTO MEMBERS(ID,NAME) " + "VALUES(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			i = pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
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
