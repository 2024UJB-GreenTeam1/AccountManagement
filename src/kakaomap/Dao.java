package kakaomap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import NEWP.newDto;


//  글 읽기 쪽인듯
public class Dao {
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String user = "c##green";
//	String password = "green1234";
//
//		private Connection conn;
//		
//		public Dao(Connection conn) {
//			this.conn = conn;
//		}
//	
//		
//		
		
		public boolean insert (newDto dto) { // insert
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
			
				sql = "intsert into newboard (num,title,";
				sql += " content,time_posted,hits,id)" ;
				sql += "values(DTO.NEXTVAL,?,?,sysdate,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getNum());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getId());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getTime_posted());
				pstmt.setString(6, dto.getHits());

				result = pstmt.executeUpdate();
				
				//pstmt.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {

				}
			}
			if (result > 0) {
				// 성공
				return true;
			} else {
				// 실패
				return false;
			}

		}
		public boolean update(newDto dto) { 
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
			
				sql = "update boards set  title =? , content = ?,";
				sql +=  " where num = ?";
			
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getTitle());
			//	pstmt.setString(2, dto.getId());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getTime_posted());
			//	pstmt.setString(5, dto.getHits());
			//	pstmt.setInt(6, dto.getNum());
				
				result = pstmt.executeUpdate();
				
			
			} catch (Exception e) {
				System.out.println(e.toString());
			}finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {

				}
			}
			if (result > 0) {
				// 성공
				return true;
			} else {
				// 실패
				return false;
			}

	}
		public boolean delete(newDto dto) { //delete
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
		
				sql = "delete from board where num = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getNum());
				
				result = pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {

				}
			}
			if (result > 0) {
				// 성공
				return true;
			} else {
				// 실패
				return false;
			}

		}
		
		public newDto getData(int num) { 
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			newDto dto = null;
			
			try {
			
				String sql = " select pwd, title, content,hits,TO_CHAR(time_posted,'YYYY.mm.DD.HH.MM.ss') as time_posted" ;
				sql += " FROM DTO ";
				sql += " WHERE num = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
			//		dto = new ComDto();
					dto.setNum(num);
				//	dto.setPwd("pwd");
					dto.setTitle("title");
					dto.setContent("content");
					dto.setHits("hits");
					dto.setTime_posted("time_posted");
					dto.setId("id");
				}
				rs.close();
				pstmt.close();
			}catch (Exception e) {
				System.out.println(e.toString());
				
			} finally {
				try {
					if(rs != null)
						rs.close();
					if(pstmt != null)
						pstmt.close();
					if(conn != null)
						conn.close();
				}catch (SQLException e) {
					
				}
			}
			return dto;
			
		}
		public List<newDto> getList(){
			
			Connection conn = null;
			List<newDto> lists = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
			
				sql = "select num,pwd,title,content,hits,TO_CHAR(time_posted,'YYYY.mm.dd.HH.MM.ss') as  time_posted,id";
				sql += " FROM board ";
			
				pstmt = conn.prepareStatement(sql);
				
		
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					newDto dto = new newDto();
					
					dto.setNum(rs.getInt("num"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setHits(rs.getString("hits"));
					dto.setTime_posted(rs.getString("time_posted"));
					dto.setId(rs.getString("id"));
					
					lists.add(dto);
				}
				
			}catch (Exception e) {
				System.out.println(e.toString());
				
			} finally {
				try {
					if (rs != null)
						rs.close();
					if( pstmt != null)
						pstmt.close();
					if(conn != null)
						conn.close();
				
				}catch (SQLException e) {
					
				}
			}
			return getList();
			
		}
		
		
}

//		
//		public int getDataCount(String searchKey , String searchValue) { // count
//			int totalCount = 0;
//			
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			String sql;
//			
//			try {
//				
//				searchValue = "%" + searchValue + "%";
//				
//				sql = "select nvl(count(*),0) from board";
//				sql += "where " + searchKey + " like ?";
//				
//				pstmt = conn.prepareStatement(sql);
//				
//				pstmt.setString(1, searchValue);
//			
//				rs = pstmt.executeQuery();
//				
//				if (rs.next()) {
//					totalCount = rs.getInt(1);
//				}
//				 rs.close();
//				 pstmt.close();
//				 
//			} catch (Exception e) {
//				System.out.println(e.toString());
//				
//			}
//			return totalCount;
//			
//			
//		}
//		
//		
//		public DTO getReadData(int num) { 
//			
//			DTO dto = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			String sql;
//			
//			try {
//				
//				sql = "select num,title, ";
//				sql += " content,time_posted,hits,id" ;
//				sql += " from board where num = ?";
//				
//				pstmt = conn.prepareStatement(sql);
//				
//				pstmt.setInt(1, num);
//				
//				rs = pstmt.executeQuery();
//				
//				if (rs.next()) {
//					
//					dto = new DTO();
//					
//					dto.setNum(rs.getInt("num"));
//					dto.setTitle(rs.getString("title"));
//					dto.setContent(rs.getString("content"));
//					dto.setHits(rs.getString("hits"));
//					dto.setTime_posted(rs.getString("time_posted"));
//					dto.setId(rs.getString("id"));
//					
//				}
//				rs.close();
//				pstmt.close();
//				
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			
//		}
//			return dto;
//		}
//		
//		
//		public int updateHitCount(int num) { // hitcount
//			int result = 0;
//			PreparedStatement pstmt = null;
//			String sql;
//			
//			try {
//				sql = " update board set hits = hits +1 where num = ?";
//				
//				pstmt = conn.prepareStatement(sql);
//				
//				pstmt.setInt(1,num);
//				
//				result = pstmt.executeUpdate();
//				
//				pstmt.close();
//				
//			} catch (Exception e) {
//				System.out.println(e.toString());
//			}
//			return result;
//		}
//		