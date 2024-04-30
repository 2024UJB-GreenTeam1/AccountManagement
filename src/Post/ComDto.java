package Post;



public class ComDto {
	
	private int num;
	private String pwd;
	private String title;
	private String content;
	private String hits;
	private String time_posted;
	private String id;
	
	public ComDto() {
		super();
	}
	
	public ComDto (int num, String pwd, String title, String content,String hits,String time_posted,String id) {
		super();
		this.num = num;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.time_posted = time_posted;
		this.id = id;
		
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public void setTime_posted(String time_posted) {
		this.time_posted = time_posted;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public String getPwd() {
		return pwd;
	}
	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getHits() {
		return hits;
	}
	public String getTime_posted() {
		return time_posted;
	}

	public String getId() {
		return id;
	}

}
