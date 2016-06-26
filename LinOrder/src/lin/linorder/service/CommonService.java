package lin.linorder.service;

import java.util.List;

import lin.linorder.dao.CommonDao;
import lin.linorder.models.City;
import lin.linorder.models.Province;

public class CommonService {
	private CommonDao commonDao;
	
	/**
	 * ��ȡʡ��
	 * @return
	 */
	public List<?> getProvinces(){
		System.out.println("commonservice_getprovinces: in ");
		List<?> provinces = commonDao.loadProvinces();
		//System.out.println("lxl"+provinces);
		return provinces;
		
	}
	/**
	 * ����ʡ��ID��ȡʡ��
	 * @param provinceID
	 * @return
	 */
	public Province getProvince(String provinceID){
		return commonDao.loadProvince(provinceID);
	}
	
	/**
	 * ����ʡ��ID��ȡ����
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
	 * ���ݳ���ID��ȡ����
	 * @param cityID
	 * @return
	 */
	public City getCity(String cityID){
		System.out.println("commonservice_city: in ");
		City city = commonDao.loadCity(cityID);
		System.out.println("����"+city);
		return city;
	}
	public CommonDao getCommonDao() {
		return commonDao;
	}
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	
	
}
