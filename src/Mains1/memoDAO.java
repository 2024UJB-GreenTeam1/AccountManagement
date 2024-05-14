package Mains1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;

public class memoDAO {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "c##green";						
    String password = "green1234";

    private Connection con;
    private Statement stmt;
    private ResultSet rs, rsL;
	JButton[] dayButtons;
    // 날짜 얻기
	private String selectedDate;	

	
	
	
   public void displayCalendarInfo() {
    	connDB();
        // 데이터베이스에서 날짜별 메모 데이터 가져오기
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            for (JButton btn : dayButtons) {
            	   CalendarMain1 calendar = new CalendarMain1();
                   String year = calendar.yearCombo.getSelectedItem().toString();
                   String month = calendar.monthCombo.getSelectedItem().toString();
                   String day = btn.getText();
                   
//                   // 날짜 얻기
//                   System.out.println("선택된 날짜: " + selectedDate);
//                 		  ;
//
//                   // 월과 일을 MM과 dd 포맷으로 맞추기 위해 필요하면 '0'을 추가
                   month = String.format("%02d", Integer.parseInt(month));
                   String date1 = String.format("%02d", Integer.parseInt(day));
//
//                   // 포맷을 사용하여 LocalDate 객체 생성
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                   LocalDate date5 = LocalDate.parse(year + month + date1, formatter);
                   
                
                String query = "SELECT CMTITLE, cmcontent FROM Calendar_Memo WHERE cmdate = TO_DATE(?, 'YYYY-MM-DD')";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setObject(1, date5);  // 현재 연도와 월을 가져와서 날짜 형식 완성
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            String title = rs.getString("CMTITLE");
                            String content = rs.getString("cmcontent");
                            btn.setToolTipText("<html>Title: " + title + "<br/>Content: " + content + "</html>");
                        } else {
                            btn.setToolTipText("No memo for this day.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
//	private String getCurrentYearMonth() {
//		// TODO Auto-generated method stub
//		 return year + "-" + String.format("%02d", month);
//	}


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
