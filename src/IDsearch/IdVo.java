package IDsearch;

import javax.swing.JTextField;

public class IdVo {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	public IdVo(String id, String pwd, String name, String email) {		//¼ø¼­
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}