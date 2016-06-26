package lin.linorder.dao;

import java.util.List;

import lin.linorder.models.City;
import lin.linorder.models.Province;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CommonDao {
	private SessionFactory sessionFactory;
	/**
	 * 读取省份
	 * @return
	 */
	public List<?> loadProvinces(){
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Province";
			Query queryObject =  session.createQuery(queryString);
			List<?> provinces = queryObject.list();
			session.close();
			return provinces;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 通过省ID读取省份
	 * @param provinceID
	 * @return
	 */
	public Province loadProvince(String provinceID){
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Province where provinceID=" + provinceID;
			Query queryObject = session.createQuery(queryString);
			List<?> list = queryObject.list();
			Province province = (Province)list.get(0);
			System.out.println("commondao_loadprovince 城市="+province.getCitys());//避免无法传值到getCitys
			session.close();
			return province;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	} 
	/**
	 * 通过城市ID读取城市
	 * @param cityID
	 * @return
	 */
	public City loadCity(String cityID){
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from City where cityID=" + cityID;
			Query queryObject = session.createQuery(queryString);
			List<?> list = queryObject.list();
			City city = (City)list.get(0);
			session.close();
			return city;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
