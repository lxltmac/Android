package lin.linorder.models;

import java.util.ArrayList;
import java.util.List;


public class Province {
	private String provinceID;
	private String province;
	private List<City> citys = new ArrayList<City>();
	public Province(){
		
	}
	public String getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(String provinceID) {
		this.provinceID = provinceID;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
}
