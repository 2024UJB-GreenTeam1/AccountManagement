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

	private Connection con;						//안돼네////
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<InfoVo> list(String pid) {				//InfoVo
		ArrayList<HealthVo> list = new ArrayList<HealthVo>();		//HealthVo

		try {
			connDB();

			String query = "SELECT * FROM DAILYINPUT";			//DAILYINPUT테이블에서 필드 조회
			if (pid != null) {
				query += " where USER_ID='" + pid + "'";			
			}
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
					String id = rs.getString("USER_ID");	//DAILYINPUT테이블에서 USER_id, pwd 필드 조회
					String DIDATE = rs.getString("DIDATE");
					int INTAKEC = rs.getInt("INTAKEC");
					int USEUPC = rs.getInt("USEUPC");
					int SLEEP = rs.getInt("SLEEP");
					int WEIGHT = rs.getInt("WEIGHT");
					int WATER = rs.getInt("WATER");

					HealthVo data = new HealthVo(id, DIDATE, INTAKEC, USEUPC,SLEEP, WEIGHT, WATER);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
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