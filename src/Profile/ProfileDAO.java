package Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public void delete(String id) {
		try {
			String sql = "" + "DELETE FROM profile Where bweriter=?";
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
