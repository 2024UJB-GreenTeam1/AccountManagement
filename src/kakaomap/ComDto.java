package kakaomap;
//사용함
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ComDto {
	private String user_id;
	private String pwd;
	private String bctitle;
	private String bcontent;
	private int bcviews;
	private int bcno;
	public static final String driver = "ora"+ "cle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String user = "c##green";
	public static final String password = "green1234";
	
	public ComDto () {
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url,user,password);
				}catch (Exception e) {
					System.out.println(e);
				}
				
			}
	
	public  int getBcno() {
		return bcno;
	}

	public void setBno(int bcno) {
		this.bcno = bcno;
	}
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getBctitle() {
		return bctitle;
	}

	public void setBctitle(String bctitle) {
		this.bctitle = bctitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getBcviews() {
		return bcviews;
	}

	public void setBcviews(int bcviews) {
		this.bcviews = bcviews;
	}
}
