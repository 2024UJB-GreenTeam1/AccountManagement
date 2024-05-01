package Post;

public class ComDto {
	private String user_id;
	private String pwd;
	private String bctitle;
	private String bcontent;
	private int bcviews;
	private int bcno;
	public ComDto() {
		super();
	}
	
	public ComDto (String user_id,String pwd,String bctitle, String bcontent,int bcviews,int bcno) {
	this.user_id = user_id;
	this.pwd = pwd;
	this.bctitle = bctitle;
	this.bcontent = bcontent;
	this.bcviews = bcviews;
	this.bcno = bcno;
	}
	public  int getBcno() {
		return bcno;
	}

	public void setBno(int bcno) {
		this.bcno = bcno;
	}
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public int getBcviews() {
		return bcviews;
	}

	public void setBcviews(int bcviews) {
		this.bcviews = bcviews;
	}
}
