package Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "C##GREEN";
	String password = "GREEN1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ProfileDAO() {
		connDB();
	}

	public void Tabinsert(char height, char weight) {

		try {
			String sql = "" + "UPDATE USERS ?" + "SET HEIGHT=?" + "WHERE";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, String.valueOf(height));
			pstmt.setString(2, String.valueOf(weight));

			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

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
