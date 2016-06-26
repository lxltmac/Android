package lin.linorder.models;

import net.sf.json.JSONString;

public class Staff implements JSONString {
	private int id;
	private String name;
	private String password;
	private String newPwd;
	private String email;
	private String address;
	private String sex;
	private String duty;
	private String phone;
	private City city;
	private int deleteFlag;
	private int freeBuff;
	
	public Staff(){
		super();
	}
	
	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
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

	//处理json解决hibernate中级联对象延迟加载问题
	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub
		return "{id:'"+id+"',name:'"+name+"',password:'"+password+"',email:'"+email+"',sex:'"+sex+"',duty:'"+duty+"',phone:'"+phone+"',city:'"+city+"'}";
	}
	
}
