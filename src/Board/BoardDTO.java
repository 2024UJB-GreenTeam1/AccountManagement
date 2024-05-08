package Board; //DTO 클래스

import java.util.Date;

public class BoardDTO {
	int bno;
	String title;
	String bmain;
	String name;
	String busy;
	Date bDate;
	
	
	
	public int getbno() {
		return bno;
	}
	public void setbno(int bno) {
		this.bno = bno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBusy() {
		return busy;
	}
	public void setBusy(String busy) {
		this.busy = busy;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	

}
