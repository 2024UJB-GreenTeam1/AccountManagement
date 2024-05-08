package HealthCheck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Profile.DTO;
import login.InfoVo;

public class HealthDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con; // 안돼네////
	private Statement stmt;
	private ResultSet rs;
//	private PreparedStatement pstmt; //
//	private InfoVo info; // 

	public HealthDAO() {
		connDB();
	}

	
	//<주간평균>
	public ArrayList<HealthVo> list() {
		ArrayList<HealthVo> list = new ArrayList<HealthVo>();

		try {
			connDB();
			String userId1 = InfoVo.getInstance().getId();// ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
			// 프린트
			System.out.println(userId1);
			String query = "select 	D.USER_ID, D.DIDATE ,D.INTAKEC,D.USEUPC ,D.SLEEP ,D.WEIGHT ,D.WATER \r\n"
					+ "	from 	DAILYINPUT D \r\n";
			if (userId1 != null) {
				query += " WHERE USER_ID=?";
			}

			PreparedStatement pstmt = con.prepareStatement(query);
			if (userId1 != null) {
				pstmt.setString(1, userId1);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("USER_ID"); // DAILYINPUT테이블에서 USER_id, 필드 조회
				String DIDATE = rs.getString("DIDATE");
				int INTAKEC = rs.getInt("INTAKEC");
				int USEUPC = rs.getInt("USEUPC");
				int SLEEP = rs.getInt("SLEEP");
				int WEIGHT = rs.getInt("WEIGHT");
				int WATER = rs.getInt("WATER");

				HealthVo data = HealthVo.getInstance();// ★☆★☆★☆★☆
				// HealthVo에 데이터 넣어주기
				data.setDataHealth(id, DIDATE, INTAKEC, USEUPC, SLEEP, WEIGHT, WATER);
				list.add(data);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제 코드??
			closeResources();
		}
		return list;
	}

	
	//<월간평균>
	public ArrayList<HealthVo> list2() {
		ArrayList<HealthVo> list2 = new ArrayList<HealthVo>();

		try {
			connDB();
			String userId1 = InfoVo.getInstance().getId();// ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
			// 프린트
			System.out.println(userId1);
			String query = "select 	D.USER_ID, D.DIDATE ,D.INTAKEC,D.USEUPC ,D.SLEEP ,D.WEIGHT ,D.WATER \r\n"
					+ "	from 	DAILYINPUT D \r\n";
			if (userId1 != null) {
				query += " WHERE USER_ID=?";
			}

			PreparedStatement pstmt = con.prepareStatement(query);
			if (userId1 != null) {
				pstmt.setString(1, userId1);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("USER_ID"); // DAILYINPUT테이블에서 USER_id, 필드 조회
				String DIDATE = rs.getString("DIDATE");
				int INTAKEC = rs.getInt("INTAKEC");
				int USEUPC = rs.getInt("USEUPC");
				int SLEEP = rs.getInt("SLEEP");
				int WEIGHT = rs.getInt("WEIGHT");
				int WATER = rs.getInt("WATER");

				HealthVo data = HealthVo.getInstance();// ★☆★☆★☆★☆
				// HealthVo에 데이터 넣어주기
				data.setDataHealth(id, DIDATE, INTAKEC, USEUPC, SLEEP, WEIGHT, WATER);
				list2.add(data);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제 코드??
			closeResources();
		}
		return list2;
	}
	
	
	
	
//	private String getCurrentUserId() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
//			stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeResources() {
		try {
			if (rs != null)
				rs.close();
//            if (rsL != null) rsL.close(); //??뭐지
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}