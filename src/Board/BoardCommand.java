package Board;  //자료 가져오는 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BoardCommand {
	private Connection conn;
	protected PreparedStatement pstmt; // 원래 private
	private ResultSet rs;
	
	public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERID = "c##green";
	public static final String USERPWD = "green1234";
	
	public void list() {  //데이터 가져오기
		try {
			String sql = "" + "Select w_num,user_id,content,dates,recommend,checks " + "FROM WRITINGPULL ";
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
			String sql = "insert into Boards(bno, btitle, bdate, busy) valuses (SEQ_BOARD_NUM,?,?,SYSDATE )";
			setPstmt(conn.prepareStatement(sql));
			getPstmt().setString(1, dto.getTitle());
			getPstmt().setString(2, dto.getBusy());
			
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
			String sql = "select user_id,content,dates,recommend,checks " + "from USERS "+
			"order by user_id";
			setPstmt(conn.prepareStatement(sql));
			rs = getPstmt().executeQuery();
			
			while(rs.next()) {
				/*
				 * BoardDTO board = new BoardDTO(); 
				 * board.setUser_id(rs.getString("User_id"));
				 * board.setContent(rs.getString("Content"));
				 * board.setDate(rs.getDate("dates"));
				 * board.setRecommend(rs.getInt("recommend"));
				 * board.setChecks(rs.getInt("checks"));
				 */
				String user_id =rs.getString("User_id"); 
				String content =rs.getString("Content");
				Date dates =rs.getDate("dates");
				int recommend = rs.getInt("recommend");
				int checks = rs.getInt("checks");
				
				Object data[] = {user_id,content,dates,recommend,checks};
				//list.add(board);
				System.out.println(user_id+","+content+","+dates+","+recommend+","+checks);
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