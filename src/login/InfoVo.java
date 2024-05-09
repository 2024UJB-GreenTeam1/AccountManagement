package login;

import HealthCheck.HealthVo;

public class InfoVo {
	private static InfoVo instance;
	
	private String id;
	private String pwd;
	
	public InfoVo() {
	
	}
	
	public static InfoVo getInstance() {
		if(instance == null) {
			synchronized(InfoVo.class) {
				instance = new InfoVo();
			}
		}
		return instance;
	}

	public String getId() {
		return id;
	}

		
	public String getPwd() {
		return pwd;
	}

	
	
	public void setData(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		
	}
	
	

	
//	HealthVo health = new HealthVo(id, pwd, 0, 0, 0, 0, 0);
//	HealthVo health = new HealthVo();
//	health.setId(id);
	
	
}