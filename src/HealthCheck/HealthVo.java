package HealthCheck;

public class HealthVo {
	private String id;
	private String DIDATE;
	private int INTAKEC;
	private int USEUPC;
	private int SLEEP;
	private int WEIGHT;
	private int WATER;
	

	public HealthVo(String id, String DIDATE, int intakec, int useupc,int sleep, int weight, int water) {
		this.id = id;
		this.DIDATE = DIDATE;
		this.INTAKEC=intakec;
		this.USEUPC=useupc;
		this.SLEEP=sleep;
		this.WEIGHT=weight;
		this.WATER=water;
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