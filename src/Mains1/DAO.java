package Mains1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Post.Read;

public class DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	Mainscreen f;

	public DAO() {
		connDB();
	}

	// 추천수 상위 3개 게시글 가져오기
	public ResultSet like3() {
		ResultSet resultSet = null;
		try {
			String sql = "SELECT * FROM BCONTENTS ORDER BY BCLIKES DESC FETCH FIRST 3 ROWS ONLY";
			pstmt = con.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	// 버튼 누르시 게시글 이동
	public void showFrame1() {
		f = new Mainscreen();
		try {
			String sql = "SELECT * FROM BCONTENTS ORDER BY BCLIKES DESC FETCH FIRST 1 ROWS ONLY";
			pstmt = con.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				int plz = resultSet.getInt("BCNO");
				Read read = new Read(plz);
				read.frame.setVisible(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showFrame2() {
		f = new Mainscreen();
		try {
			String sql = "SELECT * FROM BCONTENTS ORDER BY BCLIKES DESC OFFSET 1 ROW FETCH FIRST 1 ROWS ONLY";
			pstmt = con.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				int plz = resultSet.getInt("BCNO");
				Read read = new Read(plz);
				read.frame.setVisible(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showFrame3() {
		f = new Mainscreen();
		try {
			String sql = "SELECT * FROM BCONTENTS ORDER BY BCLIKES DESC OFFSET 2 ROW FETCH FIRST 1 ROWS ONLY";
			pstmt = con.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				int plz = resultSet.getInt("BCNO");
				Read read = new Read(plz);
				read.frame.setVisible(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
