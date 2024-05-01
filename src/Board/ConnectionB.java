package Board;  //DB 접속 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionB {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERID = "c##green";
	public static final String USERPWD = "green1234";
	
	
	public ConnectionB() {
		try { 
			Class.forName(DRIVER_NAME);
			
			conn = DriverManager.getConnection(URL,USERID,USERPWD);
			
		}catch(Exception e) {
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
