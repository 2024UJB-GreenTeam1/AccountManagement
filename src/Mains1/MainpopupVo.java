package Mains1;

public class MainpopupVo {
	private int weight;
	private int useupc;
	private int intakec;
	private int sleep;
	private int water;

	public MainpopupVo(int weight, int useupc, int intakec, int sleep, int water) {

		this.weight = weight;
		this.useupc = useupc;
		this.intakec = intakec;
		this.sleep = sleep;
		this.water = water;
	}

	public int getWeight() {
		return weight;
	}

	public int getUseupc() {
		return useupc;
	}

	public int getIntakec() {
		return intakec;
	}

	public int getSleep() {
		return sleep;
	}

	public int getWater() {
		return water;
	}

}
