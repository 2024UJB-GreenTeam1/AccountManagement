package IDsearch;

import java.sql.*;

import javax.swing.JTextField;

public class UserSelectExample {

//	IDsearch search ;
	
	public void connection(){
		Connection conn=null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn=DriverManager.getConnection( 
					"jdbc:oracle:thin:@localhost:1521/XE",
					"C##GREEN",
					"GREEN1234"
					);
			
			//매개변수화된 SQL 문 작성
			String sql = " "+
			"SELECT NAME, USER_ID, PWD, EMAIL, PHONE "+
					" FROM USERS "+
			" WHERE NAME = ?";								// "?" 
			
////			IDsearch search = new IDsearch();
	
			IDsearch search = new IDsearch();
//			search.setName(search.tfName.getText());	
			
//			String s = new String();
//			s= search.getName();
//			search.setName(search.tfName.getText());
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, search.getName());	//위의 1번 "?"라는 뜻.
			System.out.println(search.getName());
			
			
			pstmt.setString(1, search.getName());
			
			//SQL 문 실행 후, ResultSet을 통해 데이터 읽기
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { //1개의 데이터 행을 가져왔을 경우
				User user = new User();
				
				
				user.setUserId(rs.getString("user_id"));
				user.setUserPassword(rs.getString("pwd"));
				user.setUserName(rs.getString("name"));
				user.setUserPhone(rs.getString("phone"));			//INT 값 불러올 시 컬럼 순번을 이용 할수 있음
				user.setUserEmail(rs.getString("email"));		
				
				
//				if(user.get)
				
				
				
				
				System.out.println(user);
			}else {									//데이터 행을 가져오지 않았을 경우
				System.out.println("사용자 아이디가 존재하지 않음");
			}
			rs.close();
			
			//PreparedStatement 닫기
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					//연결 끊기
					conn.close();
				}catch(SQLException e) {}
			}
		}	
	}



}
