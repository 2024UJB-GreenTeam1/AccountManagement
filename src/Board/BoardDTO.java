package Board; //DTO 클래스

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
							//테이블정의서에 작성된 컬럼명으로 수정했음
public class BoardDTO {		//btitle->bctitle, bmain->bcontents,bdate->bcdate
	int bno;  //카테고리
	String bctitle;
	String bcontents;
	String user_id;
	Date bcDate;
	private Connection conn;
	protected PreparedStatement pstmt; // 원래 private
	private ResultSet rs;
	
	public static final String driver = "oracle.jdbc.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String user = "c##green";
	public static final String password = "green1234";
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

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public static final String USERPWD = "green1234";

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBcTitle() {
		return bctitle;
	}

	public void setBcTitle(String bctitle) {
		this.bctitle = bctitle;
	}

	public String getbmain() {
		return bcontents;
	}

	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}

	public Date getBDate() {
		return bcDate;
	}

	public void setbDate(Date bcDate) {
		this.bcDate = bcDate;
	}

}
