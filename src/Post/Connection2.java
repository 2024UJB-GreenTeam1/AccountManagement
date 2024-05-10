package Post;  //DB 접속 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connection2 {
	private String bcno;
	private String bno;
	private String user_id;
	private String bcnickname;
	private String bctitle;
	private String bcontent;
	private String bcdate;
	private String bcdelete;
	private String bcfilename;
	private int bcviews;
	private String bcfiledata;
	private int bclikes;
	public Connection2(){
		super();
	}
	
	public Connection2(String bcno,String bno,String user_id,String bcnickname,String bctitle, String bcontent,String bcdate,String bcdelete,String bcfilename,int bcviews,String bcfiledata,int bclikes) {
		this.bcno = bcno;
		this.bno = bno;
		this.user_id = user_id;
		this.bcnickname = bcnickname;
		this.bctitle = bctitle;
		this.bcontent = bcontent;
		this.bcdate = bcdate;
		this.bcdelete = bcdelete;
		this.bcfilename = bcfilename;
		this.bcviews = bcviews;
		this.bcfiledata = bcfiledata;
		this.bclikes = bclikes;
		
		
		
	}

	public String getBcno() {
		return bcno;
	}

	public void setBcno(String bcno) {
		this.bcno = bcno;
	}

	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBcnickname() {
		return bcnickname;
	}

	public void setBcnickname(String bcnickname) {
		this.bcnickname = bcnickname;
	}

	public String getBctitle() {
		return bctitle;
	}

	public void setBctitle(String bctitle) {
		this.bctitle = bctitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBcdate() {
		return bcdate;
	}

	public void setBcdate(String bcdate) {
		this.bcdate = bcdate;
	}

	public String getBcdelete() {
		return bcdelete;
	}

	public void setBcdelete(String bcdelete) {
		this.bcdelete = bcdelete;
	}

	public String getBcfilename() {
		return bcfilename;
	}

	public void setBcfilename(String bcfilename) {
		this.bcfilename = bcfilename;
	}

	public int getBcviews() {
		return bcviews;
	}

	public void setBcviews(int bcviews) {
		this.bcviews = bcviews;
	}

	public String getBcfiledata() {
		return bcfiledata;
	}

	public void setBcfiledata(String bcfiledata) {
		this.bcfiledata = bcfiledata;
	}

	public int getBclikes() {
		return bclikes;
	}

	public void setBclikes(int bclikes) {
		this.bclikes = bclikes;
	}
}