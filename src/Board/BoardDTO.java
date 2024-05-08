package Board; //DTO 클래스

import java.util.Date;

public class BoardDTO {
	int bno;
	String title;
	String bmain;
	String user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	Date bDate;
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getbmain() {
		return bmain;
	}
	public void setbmain(String bmain) {
		this.bmain = bmain;
	}
	public Date getBDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	

}
