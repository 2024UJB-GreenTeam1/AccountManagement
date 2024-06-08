package login;

public class InfoVo2 {
	private static InfoVo2 instance;
	
	private String id;
	private String pwd;
	
	public InfoVo2() {
	
	}
	
	public static InfoVo2 getInstance() {
		if(instance == null) {
			synchronized(InfoVo2.class) {
				instance = new InfoVo2();
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