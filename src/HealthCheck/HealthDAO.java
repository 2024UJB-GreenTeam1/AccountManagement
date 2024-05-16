package HealthCheck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import login.InfoVo;

public class HealthDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	// 주간평균
	public ArrayList<HealthVo> list(/* String pid */) {
		ArrayList<HealthVo> list = new ArrayList<HealthVo>(); // HealthVo

		try {
			connDB();
			// 로그인아이디호출
			String userId1 = InfoVo.getInstance().getId();
			// DAILYINPUT테이블에서 필드 조회쿼리(로그인테이블과 조인)
			String query = "SELECT " +
                    "AVG(di.EXHOUR) AS avg_exercise_hours, " +
                    "AVG(di.USEUPC) AS avg_calories_burned, " +
                    "AVG(di.INTAKEC) AS avg_calories_intake, " +
                    "AVG(di.WATER) AS avg_water_intake, " +
                    "AVG(di.SLEEP) AS avg_sleep_hours, " +
                    "(SELECT WEIGHT / (u.HEIGHT / 100 * u.HEIGHT / 100) " +
                    " FROM DAILYINPUT d2 " +
                    " JOIN USERS u ON d2.USER_ID = u.USER_ID " +
                    " WHERE d2.USER_ID = di.USER_ID AND " +
                    "       d2.DIDATE = (SELECT MAX(DIDATE) " +
                    "                    FROM DAILYINPUT " +
                    "                    WHERE USER_ID = d2.USER_ID)) " +
                    "AS current_BMI " +
                    "FROM DAILYINPUT di " +
                    "WHERE di.USER_ID = '"+userId1+"' " +
                    "AND di.DIDATE BETWEEN SYSDATE - 7 AND SYSDATE " +
                    "GROUP BY di.USER_ID";

			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
//					String id = rs.getString("USER_ID");	//DAILYINPUT테이블에서 USER_id,  필드 조회
//					String DIDATE = rs.getString("DIDATE");
					int avg_exercise_hours = rs.getInt("avg_exercise_hours");
					int avg_calories_burned = rs.getInt("avg_calories_burned");
					int avg_calories_intake = rs.getInt("avg_calories_intake");
					int avg_water_intake = rs.getInt("avg_water_intake");
					int avg_sleep_hours = rs.getInt("avg_sleep_hours");
					int current_BMI = rs.getInt("current_BMI");

					// HealthVo에 데이터 넣어주기
					HealthVo data = new HealthVo(avg_exercise_hours, avg_calories_burned, avg_calories_intake,
							avg_water_intake, avg_sleep_hours, current_BMI);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// 월간평균
	public ArrayList<HealthVo> list2(/* String pid */) {
		ArrayList<HealthVo> list2 = new ArrayList<HealthVo>(); // HealthVo

		try {
			connDB();

			// 로그인아이디호출
			String userId1 = InfoVo.getInstance().getId();
			// DAILYINPUT테이블에서 필드 조회쿼리(로그인테이블과 조인)
			String query = "SELECT " +
                    "AVG(di.EXHOUR) AS avg_exercise_hours, " +
                    "AVG(di.USEUPC) AS avg_calories_burned, " +
                    "AVG(di.INTAKEC) AS avg_calories_intake, " +
                    "AVG(di.WATER) AS avg_water_intake, " +
                    "AVG(di.SLEEP) AS avg_sleep_hours, " +
                    "(SELECT WEIGHT / (u.HEIGHT / 100 * u.HEIGHT / 100) " +
                    " FROM DAILYINPUT d2 " +
                    " JOIN USERS u ON d2.USER_ID = u.USER_ID " +
                    " WHERE d2.USER_ID = di.USER_ID AND " +
                    "       d2.DIDATE = (SELECT MAX(DIDATE) " +
                    "                    FROM DAILYINPUT " +
                    "                    WHERE USER_ID = d2.USER_ID)) " +
                    "AS current_BMI " +
                    "FROM DAILYINPUT di " +
                    "WHERE di.USER_ID = '"+userId1+"' " +
                    "AND di.DIDATE BETWEEN SYSDATE - 30 AND SYSDATE " +
                    "GROUP BY di.USER_ID";

			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
//					String id = rs.getString("USER_ID");	//DAILYINPUT테이블에서 USER_id,  필드 조회
//					String DIDATE = rs.getString("DIDATE");
					int avg_exercise_hours = rs.getInt("avg_exercise_hours");
					int avg_calories_burned = rs.getInt("avg_calories_burned");
					int avg_calories_intake = rs.getInt("avg_calories_intake");
					int avg_water_intake = rs.getInt("avg_water_intake");
					int avg_sleep_hours = rs.getInt("avg_sleep_hours");
					int current_BMI = rs.getInt("current_BMI");

					// HealthVo에 데이터 넣어주기
					HealthVo data = new HealthVo(avg_exercise_hours, avg_calories_burned, avg_calories_intake,
							avg_water_intake, avg_sleep_hours, current_BMI);
					list2.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list2;
	}
	
	// 연간평균
	public ArrayList<HealthVo> list3(/* String pid */) {
		ArrayList<HealthVo> list3 = new ArrayList<HealthVo>(); // HealthVo

		try {
			connDB();

			// 로그인아이디호출
			String userId1 = InfoVo.getInstance().getId();
			// DAILYINPUT테이블에서 필드 조회쿼리(로그인테이블과 조인)
			String query = "SELECT " +
                    "AVG(di.EXHOUR) AS avg_exercise_hours, " +
                    "AVG(di.USEUPC) AS avg_calories_burned, " +
                    "AVG(di.INTAKEC) AS avg_calories_intake, " +
                    "AVG(di.WATER) AS avg_water_intake, " +
                    "AVG(di.SLEEP) AS avg_sleep_hours, " +
                    "(SELECT WEIGHT / (u.HEIGHT / 100 * u.HEIGHT / 100) " +
                    " FROM DAILYINPUT d2 " +
                    " JOIN USERS u ON d2.USER_ID = u.USER_ID " +
                    " WHERE d2.USER_ID = di.USER_ID AND " +
                    "       d2.DIDATE = (SELECT MAX(DIDATE) " +
                    "                    FROM DAILYINPUT " +
                    "                    WHERE USER_ID = d2.USER_ID)) " +
                    "AS current_BMI " +
                    "FROM DAILYINPUT di " +
                    "WHERE di.USER_ID = '"+userId1+"' " +
                    "AND di.DIDATE BETWEEN SYSDATE - 365 AND SYSDATE " +
                    "GROUP BY di.USER_ID";

			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
//					String id = rs.getString("USER_ID");	//DAILYINPUT테이블에서 USER_id,  필드 조회
//					String DIDATE = rs.getString("DIDATE");
					int avg_exercise_hours = rs.getInt("avg_exercise_hours");
					int avg_calories_burned = rs.getInt("avg_calories_burned");
					int avg_calories_intake = rs.getInt("avg_calories_intake");
					int avg_water_intake = rs.getInt("avg_water_intake");
					int avg_sleep_hours = rs.getInt("avg_sleep_hours");
					int current_BMI = rs.getInt("current_BMI");

					// HealthVo에 데이터 넣어주기
					HealthVo data = new HealthVo(avg_exercise_hours, avg_calories_burned, avg_calories_intake,
							avg_water_intake, avg_sleep_hours, current_BMI);
					list3.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list3;
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
}