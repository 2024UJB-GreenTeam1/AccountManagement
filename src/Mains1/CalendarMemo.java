package Mains1;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Board.ConnectionB;
import login.InfoVo;

public class CalendarMemo {				/////////년월이 입력 안받아짐.
	public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERID = "c##green";
	public static final String USERPWD = "green1234";
	private memoDAO dao;
	ArrayList<memoVo> list;
	
    // 날짜 얻기
	private String selectedDate;	
	private String selectedMonth;	
	private String selectedYear;	

   public CalendarMemo(String selectedDate, String selectedMonth, String selectedYear) {
		// TODO Auto-generated constructor stub
	   this.selectedDate = selectedDate;
	   this.selectedMonth = selectedMonth;
	   this.selectedYear = selectedYear;
	}

public void excute() {
      
	   
	   dao = new memoDAO();

      JFrame f = new JFrame("일정관리 입력");
      f.setSize(400, 300);
      f.setLayout(new FlowLayout());
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocationRelativeTo(null);
      
      JTextField titleField = new JTextField("제목을 입력해주세요.", 30);
      titleField.selectAll();  // 텍스트 필드 클릭 시 기본 텍스트 선택
      
      //텍스트 창 생성
      JTextArea comments = new JTextArea("내용을 입력해주세요.", 10, 30);
      
      //버튼 생성
      JButton registrationButton = new JButton("리셋");
      
      registrationButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            comments.setText("");
            titleField.setText("");
         }
      });
      
      JButton modificationButton = new JButton("등록");
      
      

      modificationButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
//              saveData(titleField.getText(),comments.getText()); // 입력된 텍스트 데이터 저장
        	  CalendarMain1 calendar = new CalendarMain1();

              // 월과 일을 MM과 dd 포맷으로 맞추기 위해 필요하면 '0'을 추가
        	  selectedMonth = String.format("%02d", Integer.parseInt(selectedMonth));
              String date1 = String.format("%02d", Integer.parseInt(selectedDate));

              // 포맷을 사용하여 LocalDate 객체 생성
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
              LocalDate date5 = LocalDate.parse(selectedYear + selectedMonth + date1, formatter);

      		PreparedStatement pstmt = null;
			////////////////////
      		try {
				ConnectionB cb = new ConnectionB(); // 연결
				String userId1 = InfoVo.getInstance().getId();					//로그인아이디얻기 싱클톤패턴
				Connection conn = DriverManager.getConnection(URL, USERID, USERPWD);
				String sql = "" + "insert into Calendar_Memo(CMNO_SEQ, user_id,"
						+ "CMTITLE,cmcontent,cmdate) "
						+ "values(SEQ_CMNO_SEQ.NEXTVAL,?,?,?,?) ";/*SEQ_BCNO.NEXTVAL*/

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId1);
				pstmt.setString(2, titleField.getText());
				pstmt.setString(3, comments.getText());
				pstmt.setObject(4, date5);					///
				pstmt.executeUpdate();

				titleField.setText("");
				comments.setText("");
				System.out.println("저장완료");
				f.dispose();
				// 완료메시지
				JOptionPane.showMessageDialog(f, 
						"일정이 등록되었습니다.", "BoardWrite", JOptionPane.ERROR_MESSAGE);

			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {	
					pstmt.close();
					// System.exit(0);
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
				
			}
      		

      		
          }
      });


      f.add(modificationButton);
      
      f.add(titleField);
      f.add(comments);
      f.add(registrationButton);
      f.add(modificationButton);
      comments.selectAll();
      f.setVisible(true);
  	//창닫기
  	f.addWindowListener(new WindowAdapter() {
  	    public void windowClosing(WindowEvent evt) {
  	        int resp = JOptionPane.showConfirmDialog(f, "일정입력을 중단하시겠습니까?",
  	            "Exit?", JOptionPane.YES_NO_OPTION);
  	        if (resp == JOptionPane.YES_OPTION) {
  	        	f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  	        } else {
  	            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  	        }
  	    }
  	});
		


   }
   public static void saveData(String title,String data) {
     
	    System.out.println("저장된 제목: " + title);
       System.out.println("저장된 데이터: " + data);
       
      
       

       
       
   }

//   public static void display() {
//       new CalendarMemo(); // CalendarMemo 객체 생성
//   }
}