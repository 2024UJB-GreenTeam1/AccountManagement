package Profile;

public class DTO {
	private String name;
	private String ID;
	private String email;
	private String phone;
	private String year;
	private int height;
	private int weight;

	public DTO(String name, String ID, String email, String phone, String year, int height) {
		this.name = name;
		this.ID = ID;
		this.email = email;
		this.phone = phone;
		this.year = year;
		this.height = height;
	}

	public DTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
