package login;

import HealthCheck.HealthVo;

public class InfoVo {
	private String id;
	private String pwd;
	

	public InfoVo(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}
	
//	HealthVo health = new HealthVo(id, pwd, 0, 0, 0, 0, 0);
//	HealthVo health = new HealthVo();
//	health.setId(id);
	
	
}