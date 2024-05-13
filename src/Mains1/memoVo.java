package Mains1;

import HealthCheck.HealthVo;

public class memoVo {
	private static memoVo instance;
	
	private String id;
	private String pwd;
	
	public memoVo() {
	
	}
	
	public static memoVo getInstance() {
		if(instance == null) {
			synchronized(memoVo.class) {
				instance = new memoVo();
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