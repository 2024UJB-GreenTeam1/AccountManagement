package Mains1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import login.InfoVo;

//자바 프로그램에서 데이터베이스 작업만 수행, 자바 프로그램의 다른 기능을 하는 클래스와 구분해 작업
public class MainpopupDAO {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "c##green";
    String password = "green1234";

    private Connection con;
    private PreparedStatement pstmt;

    // 데이터베이스 연결 메소드
    public void connDB() throws SQLException, ClassNotFoundException {
        if (con == null || con.isClosed()) {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                System.err.println("JDBC 드라이버를 찾을 수 없습니다.");
                throw e;
            } catch (SQLException e) {
                System.err.println("데이터베이스 연결 실패:");
                e.printStackTrace();
                throw e;
            }
        }
    }

    public void insertDailyInput(int weight, int useupc, int intakec, int sleep, int water) {
        try {
            connDB(); // 데이터베이스 연결 확인 및 연결
            String userId1 = InfoVo.getInstance().getId();	
            String sql = "INSERT INTO DAILYINPUT (WEIGHT, USEUPC, INTAKEC, SLEEP, WATER,USER_ID,DNO_SEQ) VALUES (?,?, ?, ?, ?, ?,SEQ_DNO_SEQ.NEXTVAL)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, weight);
            pstmt.setInt(2, useupc);
            pstmt.setInt(3, intakec);
            pstmt.setInt(4, sleep);
            pstmt.setInt(5, water);
            pstmt.setString(6, userId1);
            pstmt.executeUpdate(); // 쿼리 실행
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("데이터 삽입 중 오류 발생:");
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
