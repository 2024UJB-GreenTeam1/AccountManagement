package HealthCheck;

public class HealthVo {
//	private String id;
//	private String DIDATE;
	private int avg_exercise_hours;
	private int avg_calories_burned;
	private int avg_calories_intake;
	private int avg_water_intake;
	private int avg_sleep_hours;
	private int current_BMI;

	public HealthVo(int avg_exercise_hours, 
			int avg_calories_burned,
			int avg_calories_intake, 
			int avg_water_intake, 
			int avg_sleep_hours,
			int current_BMI) {
//		this.id = id;
//		this.DIDATE = DIDATE;
		this.avg_exercise_hours=avg_exercise_hours;
		this.avg_calories_burned=avg_calories_burned;
		this.avg_calories_intake=avg_calories_intake;
		this.avg_water_intake=avg_water_intake;
		this.avg_sleep_hours=avg_sleep_hours;
		this.current_BMI=current_BMI;
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
	
//	public String getDIDATE() {
//		return DIDATE;
//	}

	public int getAvg_exercise_hours() {
		return avg_exercise_hours;
	}

	public int getAvg_calories_burned() {
		return avg_calories_burned;
	}

	public int getAvg_calories_intake() {
		return avg_calories_intake;
	}

	public int getAvg_water_intake() {
		return avg_water_intake;
	}

	public int getAvg_sleep_hours() {
		return avg_sleep_hours;
	}

	public int getCurrent_BMI() {
		return current_BMI;
	}


}