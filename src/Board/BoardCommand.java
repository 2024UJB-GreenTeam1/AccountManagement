package Board;  //자료 가져오는 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BoardCommand extends ConnectionB {
	private Connection conn;
	protected PreparedStatement pstmt; // 원래 private
	private ResultSet rs;
	
	public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERID = "c##green";
	public static final String USERPWD = "green1234";
	
	public void list() {  //데이터 가져오기
		try {
			String sql = "" + "Select * " + "FROM  post";
		    conn = DriverManager.getConnection(URL, USERID, USERPWD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
		
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			exit();
		}
					
		
		
	}
	public void exit() {
		if(conn != null) {
			try { 
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insert(BoardDTO dto) {  //삽입
		try {
			conn = DriverManager.getConnection(URL,USERID,USERPWD);
			String sql = "insert into post(bno, btitle, bdate, ) valuses (SEQ_BOARD_NUM,?,SYSDATE)";
			setPstmt(conn.prepareStatement(sql));
			getPstmt().setString(1, dto.getTitle());
			
			getPstmt().executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {			
		}try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public List<BoardDTO> select() {  //테이블 데이터 가져오기
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			conn = DriverManager.getConnection(URL,USERID,USERPWD);
			String sql = "select bno,btitle,bmain,bdate,busy " + "from post "+
			"order by bno DESC";
			setPstmt(conn.prepareStatement(sql));
			rs = getPstmt().executeQuery();
			
			while(rs.next()) {
				int bno  =rs.getInt("bno"); 
				String btitle =rs.getString("btitle");
				String bmain = rs.getString("bmain");
				Date bDate =rs.getDate("bDate");
				int busy = rs.getInt("busy");
				
				Object data[] = {bno,btitle,bmain,bDate,busy};
				//list.add(board);
				System.out.println(bno+","+btitle+","+bmain+","+bDate+","+busy);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			try { 
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return list;
	}
	
	public void count() {
		try {
			String sql = "" + "select count(*) " + "from post ";
			ConnectionB cb = new ConnectionB(); // 연결
			Connection conn = DriverManager.getConnection(URL, USERID, USERPWD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			setRs(pstmt.executeQuery());
			while (getRs().next()) {
				int count= getRs().getInt("count(*)");				
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		BoardCommand bl = new BoardCommand();  //접속
		bl.select();
	}
	
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
}
