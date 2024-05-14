package Board; //DB 접속 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionB {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static final String driver = "oracle.jdbc.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String user = "c##green";
	public static final String password = "green1234";

	public ConnectionB() {
		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getRs() {
		return rs;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}
