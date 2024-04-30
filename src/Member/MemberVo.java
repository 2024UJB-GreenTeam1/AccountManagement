package Member;

public class MemberVo {
	private String id;
	private String pwd;

	public MemberVo(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
}