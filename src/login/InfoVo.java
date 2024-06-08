package login;



public class InfoVo {
//클래스의 유일한 인스턴스를 저장할 정적 변수. 정적 변수는 클래스 로딩 시 초기화
	private static volatile InfoVo instance;
	private String id;
	private String pwd;
	private InfoVo() {
	
	}
	 // 싱글톤 인스턴스를 반환하는 메소드.
	public static InfoVo getInstance() {
// 인스턴스가 생성되지 않았다면 동기화 블록으로 진입
		if(instance == null) {
	// 여러 스레드가 동시에 getInstance()를 호출할 때 인스턴스가 중복 생성되는 것을 방지
			synchronized(InfoVo.class) {
				if (instance == null) {
				instance = new InfoVo();
				}
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