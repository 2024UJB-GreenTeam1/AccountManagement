package Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

		private Connection conn;
		
		public DAO(Connection conn) {
			this.conn = conn;
		}
	
		
		
//		public int getMaxNum() { 
//			int maxNum =0;
//			
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			String sql;
//			
//			try {
//				sql = " select  nvl(max(num),0) from board";
//				
//				pstmt = conn.prepareStatement(sql);
//				
//				rs = pstmt.executeQuery();
//				
//				if (rs.next()) {
//					maxNum = rs.getInt(1);
//				}
//				rs.close();
//				pstmt.close();
//			}catch (Exception e) {
//				System.out.println(e.toString());
//				
//			}
//			return maxNum;
//			
//		}
//		
		
		public int insertData (DTO dto) { // insert
			int result = 0;
			
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				
				sql = "intset into board (num,title,name,";
				sql += " content,time_posted,hits,id)" ;
				sql += "values(?,?,?,?,?,sysdate,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getNum());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getId());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getTime_posted());
				pstmt.setString(6, dto.getHits());

				result = pstmt.executeUpdate();
				
				pstmt.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return result;
		}
		
		
		
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
		
		public List<DTO> getLists(int start, int end,String searchKey, String searchValue){
			
			List<DTO> lists = new ArrayList<DTO>();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
				searchValue = "%" + searchValue + "%";
				sql = "select * from (";
				sql += "select rownum rnum,data.*from (";
				sql +=  " select num,title,content,hits,time_posted,id,";
				sql += "to_char(created, 'YYYY-MM-DD') created ";
				sql +=  "from board where " + searchKey + "like ?";
				sql += "order by num desc) data)";
				sql += "where rnum>= ? and rum<=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, searchValue);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					DTO dto = new DTO();
					
					dto.setNum(rs.getInt("num"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setHits(rs.getString("hits"));
					dto.setTime_posted(rs.getString("time_posted"));
					dto.setId(rs.getString("id"));
					
					lists.add(dto);
				}
				
				rs.close();
				pstmt.close();

			}catch (Exception e) {
				System.out.println(e.toString());
				
			}
			return lists;
		}
		
		
		public DTO getReadData(int num) { 
			
			DTO dto = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
				
				sql = "select num,title,name,";
				sql += " content,time_posted,hits,id" ;
				sql += " from board where num = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, num);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					
					dto = new DTO();
					
					dto.setNum(rs.getInt("num"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setHits(rs.getString("hits"));
					dto.setTime_posted(rs.getString("time_posted"));
					dto.setId(rs.getString("id"));
					
				}
				rs.close();
				pstmt.close();
				
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
			return dto;
		}
		
		
		public int updateHitCount(int num) { // hitcount
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				sql = " update board set hits = hits +1 where num = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1,num);
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return result;
		}
		
		
		public int updateData(DTO dto) { 
			int result = 0;
			
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				sql = "update board set name = ?, pwd =? ,email = ?, content = ?,";
				sql += "title = ? ,where num = ?";
			
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getNum());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getId());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getTime_posted());
				pstmt.setString(6, dto.getHits());
				
				result = pstmt.executeUpdate();
				
				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return result;
		} 
		public int deleteData(int num) { //delete
			int result = 0;
			
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				
				sql = "delete board where num = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, num);
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return result;
		}
		
}
