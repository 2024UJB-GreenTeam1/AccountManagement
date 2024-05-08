package HealthCheck;

import login.InfoVo;

public class HealthVo {
	private static HealthVo instance;
	private String id;
	private String DIDATE;
	private int INTAKEC;
	private int USEUPC;
	private int SLEEP;
	private int WEIGHT;
	private int WATER;
	
	public HealthVo() {
		
	}

	public void setDataHealth(String id, String DIDATE, int intakec, int useupc,int sleep, int weight, int water) {
		this.id = id;
		this.DIDATE = DIDATE;
		this.INTAKEC=intakec;
		this.USEUPC=useupc;
		this.SLEEP=sleep;
		this.WEIGHT=weight;
		this.WATER=water;
	}
	
	public static HealthVo getInstance() {
		if(instance == null) {
			synchronized(HealthVo.class) {
				instance = new HealthVo();
			}
		}
		return instance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDIDATE() {
		return DIDATE;
	}

	public int getINTAKEC() {
		return INTAKEC;
	}

	public int getUSEUPC() {
		return USEUPC;
	}

	public int getSLEEP() {
		return SLEEP;
	}

	public int getWEIGHT() {
		return WEIGHT;
	}

	public int getWATER() {
		return WATER;
	}


}