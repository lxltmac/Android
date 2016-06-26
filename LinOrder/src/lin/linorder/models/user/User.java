package lin.linorder.models.user;

public class User {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String phone;
	private int deleteFlag;
	private int freeBuff;
	
	private User(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public int getFreeBuff() {
		return freeBuff;
	}

	public void setFreeBuff(int freeBuff) {
		this.freeBuff = freeBuff;
	}
	
	
}
