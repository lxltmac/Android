package lin.linorder.service;

import java.util.List;

import lin.linorder.dao.CommonDao;
import lin.linorder.models.City;
import lin.linorder.models.Province;

public class CommonService {
	private CommonDao commonDao;
	
	/**
	 * 获取省份
	 * @return
	 */
	public List<?> getProvinces(){
		System.out.println("commonservice_getprovinces: in ");
		List<?> provinces = commonDao.loadProvinces();
		//System.out.println("lxl"+provinces);
		return provinces;
		
	}
	/**
	 * 根据省份ID读取省份
	 * @param provinceID
	 * @return
	 */
	public Province getProvince(String provinceID){
		return commonDao.loadProvince(provinceID);
	}
	
	/**
	 * 根据省份ID读取城市
	 * @param provinceID
	 * @return
	 */
	public List<?> getCitys(String provinceID){
		System.out.println("commonservice_citys: in ");
		Province province= commonDao.loadProvince(provinceID);
		System.out.println("commonService_citys="+province.getCitys());
		return province.getCitys();
	}
	/**
	 * 根据城市ID读取城市
	 * @param cityID
	 * @return
	 */
	public City getCity(String cityID){
		System.out.println("commonservice_city: in ");
		City city = commonDao.loadCity(cityID);
		System.out.println("城市"+city);
		return city;
	}
	public CommonDao getCommonDao() {
		return commonDao;
	}
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	
	
}
