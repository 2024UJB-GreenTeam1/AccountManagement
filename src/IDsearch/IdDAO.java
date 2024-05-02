package IDsearch;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class IdDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";						
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<IdVo> list(String pname) {		//
		ArrayList<IdVo> list = new ArrayList<IdVo>();

		try {
			connDB();

			String query = "SELECT * FROM USERS";			//USERS테이블에서 USER_id, pwd 필드 조회
			if (pname != null) {
				query += " where NAME='" + pname + "'";			
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
					String id = rs.getString("USER_ID");	//USERS테이블에서 USER_id, pwd, name 필드 조회
					String pwd = rs.getString("pwd");
					String name  = rs.getString("name");
					String email  = rs.getString("email");		//여기에 추가해줘야함
					IdVo data = new IdVo(id, pwd, name, email);
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