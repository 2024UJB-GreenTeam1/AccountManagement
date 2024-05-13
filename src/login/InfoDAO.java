package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InfoDAO {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "c##green";						
    String password = "green1234";

    private Connection con;
    private Statement stmt;
    private ResultSet rs, rsL;

    public ArrayList<InfoVo> list(String pid) {
        ArrayList<InfoVo> list = new ArrayList<InfoVo>();

        try {
            connDB();

            String query = "SELECT * FROM USERS";			
            if (pid != null) {
                query += " WHERE USER_ID=?";
            }

            PreparedStatement pstmt = con.prepareStatement(query);
            if (pid != null) {
                pstmt.setString(1, pid);
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("USER_ID");
                String pwd = rs.getString("pwd");

                InfoVo data = InfoVo.getInstance();
                data.setData(id, pwd);
                list.add(data);

                // Insert into LOGIN table
//                String insertQuery = "INSERT INTO LOGIN(USER_ID, LNO, LDATE) VALUES (?, 1, DEFAULT)";
//                PreparedStatement insertStmt = con.prepareStatement(insertQuery);
//                insertStmt.setString(1, pid);
//                insertStmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return list;
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

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (rsL != null) rsL.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
