package Mains1;

public class VO {
	private String id;
	private String title;
	private int like;
	private int views;
	
	public VO(String id, String title, int like, int views) {
		this.id = id;
		this.title = title;
		this.like = like;
		this.views = views;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	
	
	
	
}
