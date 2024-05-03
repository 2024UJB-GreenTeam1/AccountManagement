package Post;  //DB 접속 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connection2 {
	private String user_id;
	private String bctitle;
	private String sysdate;
	private String bcviews;
	private String bclikes;
	private String bcontent;
	public Connection2(){
		super();
	}
	
	public Connection2(String user_id,String bctitle,String sysdate,String bcviews,String bclikes, String bcontent) {
		this.user_id = user_id;
		this.bctitle = bctitle;
		this.sysdate = sysdate;
		this.bcviews = bcviews;
		this.bclikes = bclikes;
		this.bcontent = bcontent;
		
		
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBctitle() {
		return bctitle;
	}

	public void setBctitle(String bctitle) {
		this.bctitle = bctitle;
	}

	public String getSysdate() {
		return sysdate;
	}

	public void setSysdate(String sysdate) {
		this.sysdate = sysdate;
	}

	public String getBcviews() {
		return bcviews;
	}

	public void setBcviews(String bcviews) {
		this.bcviews = bcviews;
	}

	public String getBclikes() {
		return bclikes;
	}

	public void setBclikes(String bclikes) {
		this.bclikes = bclikes;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	
}
	
	
