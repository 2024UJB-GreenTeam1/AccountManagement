package HealthCheck2;

import login.InfoVo;

public class HealthVo {
	private static HealthVo instance;
	private String id;
//	private String DIDATE;
	private int AVG_EXERCISE_HOURS;
	private int AVG_CALORIES_INTAKE;
	private int AVG_CALORIES_BURNED;
	private int AVG_SLEEP_HOURS;
	private int AVG_BMI;
	private int AVG_WATER_INTAKE;

	public HealthVo() {

	}

	public void setDataHealth(String id, int AVG_EXERCISE_HOURS, int AVG_CALORIES_INTAKE,
			int AVG_CALORIES_BURNED, int AVG_SLEEP_HOURS, int AVG_BMI, int AVG_WATER_INTAKE) {

		this.id = id;
//		this.DIDATE = DIDATE;
		this.AVG_EXERCISE_HOURS = AVG_EXERCISE_HOURS;
		this.AVG_CALORIES_INTAKE = AVG_CALORIES_INTAKE;
		this.AVG_CALORIES_BURNED = AVG_CALORIES_BURNED;
		this.AVG_SLEEP_HOURS = AVG_SLEEP_HOURS;
		this.AVG_BMI = AVG_BMI;
		this.AVG_WATER_INTAKE = AVG_WATER_INTAKE;
	}

	//////////////////////////////////////////
	public static HealthVo getInstance() {
		if (instance == null) {
			synchronized (HealthVo.class) {
				instance = new HealthVo();
			}
		}
		return instance;
	}

	public void setId(String id) {
		this.id = id;
	}

//////////////////////////////////////////////////////
	public String getId() {
		return id;
	}

//	public String getDIDATE() {
//		return DIDATE;
//	}

	public int getAVG_CALORIES_INTAKE() {
		return AVG_CALORIES_INTAKE;
	}

	public int getAVG_CALORIES_BURNED() {
		return AVG_CALORIES_BURNED;
	}

	public int getAVG_SLEEP_HOURS() {
		return AVG_SLEEP_HOURS;
	}

	public int getAVG_BMI() {
		return AVG_BMI;
	}

	public int getAVG_WATER_INTAKE() {
		return AVG_WATER_INTAKE;
	}

	public int getAVG_EXERCISE_HOURS() {
		return AVG_EXERCISE_HOURS;
	}

}