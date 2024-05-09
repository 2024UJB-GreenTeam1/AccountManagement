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

//	public HealthDAO() {
//		connDB();
//	}

	// <주간평균>
	public ArrayList<HealthVo> list() {
		ArrayList<HealthVo> list = new ArrayList<HealthVo>();

		try {
			connDB();
			String userId1 = InfoVo.getInstance().getId();// ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
			// 프린트
			System.out.println(userId1);
			String query ="" + "SELECT\r\n"
			        + "    U.USER_ID,\r\n"
			        + "    AVG(DI.EXHOUR) AS WEEKLY_AVG_EXERCISE_HOURS,\r\n"
			        + "    AVG(DI.USEUPC) AS WEEKLY_AVG_CALORIES_BURNED,\r\n"
			        + "    AVG(DI.INTAKEC) AS WEEKLY_AVG_CALORIES_INTAKE,\r\n"
			        + "    AVG(DI.WATER) AS WEEKLY_AVG_WATER_INTAKE,\r\n"
			        + "    AVG(DI.WEIGHT / ((U.HEIGHT / 100) * (U.HEIGHT / 100))) AS WEEKLY_AVG_BMI,\r\n"
			        + "    AVG(DI.SLEEP) AS WEEKLY_AVG_SLEEP_HOURS\r\n"
			        + "FROM\r\n"
			        + "    DAILYINPUT DI\r\n"
			        + "JOIN\r\n"
			        + "    USERS U ON DI.USER_ID = U.USER_ID\r\n";
//			        + "WHERE\r\n"
//			        + "    DI.USER_ID = '?'\r\n"
//			        + "    AND DI.DIDATE >= TRUNC(SYSDATE) - 7\r\n"
//			        + "GROUP BY\r\n"
//			        + "    U.USER_ID";
		
//			if (userId1 != null) {
//
//			}

			PreparedStatement pstmt = con.prepareStatement(query);
			if (userId1 != null) {
				query += " WHERE\r\n"
						+ "    DI.USER_ID = '?'\r\n"	       /////아이디
						+ "    AND DI.DIDATE >= TRUNC(SYSDATE) - 7\r\n";
				query += " GROUP BY\r\n"
						+ "	U.USER_ID";
				pstmt.setString(1, userId1);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("USER_ID"); // DAILYINPUT테이블에서 USER_id, 필드 조회
//				String DIDATE = rs.getString("DIDATE");
				int AVG_EXERCISE_HOURS = rs.getInt("WEEKLY_AVG_EXERCISE_HOURS");
				int AVG_CALORIES_INTAKE = rs.getInt("WEEKLY_AVG_CALORIES_INTAKE");
				int AVG_CALORIES_BURNED = rs.getInt("WEEKLY_AVG_CALORIES_BURNED");
				int AVG_SLEEP_HOURS = rs.getInt("WEEKLY_AVG_SLEEP_HOURS");
				int AVG_BMI = rs.getInt("WEEKLY_AVG_BMI");
				int AVG_WATER_INTAKE = rs.getInt("WEEKLY_AVG_WATER_INTAKE");

				HealthVo data = HealthVo.getInstance();// ★☆★☆★☆★☆
				// HealthVo에 데이터 넣어주기
				data.setDataHealth(id, AVG_EXERCISE_HOURS, 
						AVG_CALORIES_INTAKE, 
						AVG_CALORIES_BURNED, 
						AVG_SLEEP_HOURS,
						AVG_BMI, AVG_WATER_INTAKE);
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

	// <월간평균>
	public ArrayList<HealthVo> list2() {
		ArrayList<HealthVo> list2 = new ArrayList<HealthVo>();

		try {
			connDB();
			String userId1 = InfoVo.getInstance().getId();// ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
			// 프린트
			System.out.println(userId1);
			String query2 = "" +"SELECT\r\n"
			        + "    U.USER_ID,\r\n"
			        + "    AVG(DI.EXHOUR) AS WEEKLY_AVG_EXERCISE_HOURS,\r\n"
			        + "    AVG(DI.USEUPC) AS WEEKLY_AVG_CALORIES_BURNED,\r\n"
			        + "    AVG(DI.INTAKEC) AS WEEKLY_AVG_CALORIES_INTAKE,\r\n"
			        + "    AVG(DI.WATER) AS WEEKLY_AVG_WATER_INTAKE,\r\n"
			        + "    AVG(DI.WEIGHT / ((U.HEIGHT / 100) * (U.HEIGHT / 100))) AS WEEKLY_AVG_BMI,\r\n"
			        + "    AVG(DI.SLEEP) AS WEEKLY_AVG_SLEEP_HOURS\r\n"
			        + "FROM\r\n"
			        + "    DAILYINPUT DI\r\n"
			        + "JOIN\r\n"
			        + "    USERS U ON DI.USER_ID = U.USER_ID\r\n";
//			        + "WHERE\r\n"
//			        + "    DI.USER_ID = '?'\r\n"
//			        + "    AND DI.DIDATE >= TRUNC(SYSDATE) - 7\r\n"
//			        + "GROUP BY\r\n"
//			        + "    U.USER_ID";
			if (userId1 != null) {

			}

			PreparedStatement pstmt = con.prepareStatement(query2);
			if (userId1 != null) {
				query2 += " WHERE\r\n"
						+ "    DI.USER_ID = '"+"?"+"'\r\n"	       /////아이디
						+ "    AND DI.DIDATE >= TRUNC(SYSDATE) - 30\r\n";
				query2 += " GROUP BY\r\n"
						+ "	U.USER_ID";
				pstmt.setString(1, userId1);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("USER_ID"); // DAILYINPUT테이블에서 USER_id, 필드 조회
//				String DIDATE = rs.getString("DIDATE");
				int AVG_EXERCISE_HOURS = rs.getInt("MONTHLY_AVG_EXERCISE_HOURS");
				int AVG_CALORIES_INTAKE = rs.getInt("MONTHLY_AVG_CALORIES_INTAKE");
				int AVG_CALORIES_BURNED = rs.getInt("MONTHLY_AVG_CALORIES_BURNED");
				int AVG_SLEEP_HOURS = rs.getInt("MONTHLY_AVG_SLEEP_HOURS");
				int AVG_BMI = rs.getInt("MONTHLY_AVG_BMI");
				int AVG_WATER_INTAKE = rs.getInt("MONTHLY_AVG_WATER_INTAKE");

				HealthVo data2 = HealthVo.getInstance();// ★☆★☆★☆★☆
				// HealthVo에 데이터 넣어주기
				data2.setDataHealth(id, AVG_EXERCISE_HOURS, 
						AVG_CALORIES_INTAKE, 
						AVG_CALORIES_BURNED, 
						AVG_SLEEP_HOURS,
						AVG_BMI, AVG_WATER_INTAKE);
				list2.add(data2);
				
				//프린트
				System.out.println(AVG_EXERCISE_HOURS);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제 코드??
			closeResources();
		}
		return list2;
	}

	private String getCurrentUserId() {
		// TODO Auto-generated method stub
		return null;
	}

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