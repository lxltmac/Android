package lin.linorder.dao.goods;

import java.util.List;

import lin.linorder.models.City;
import lin.linorder.models.Province;
import lin.linorder.models.goods.Food;
import lin.linorder.models.goods.FoodStyle;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FoodDao {
	private SessionFactory sessionFactory;
	/**
	 * 菜名保存
	 * @param foodName
	 * @return
	 */
	public Food loadFood(String foodName) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Food where foodName=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, foodName);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				Food food = (Food)list.get(0);
				return food;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 菜品添加
	 * @param food
	 * @return
	 */
	public boolean addFood(Food food){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction(); 
			int row = Integer.parseInt(session.save(food).toString());
			transaction.commit();
			session.close();
			if(row > 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据id删除菜品
	 * @param id
	 * @return
	 */
	public boolean deleteFoodById(int id){
		//创建session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Food where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Food> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					Food food=list.get(i);
					session.delete(food);
				}
				transaction.commit();
				session.close();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据id查找菜品
	 * @param id
	 * @return
	 */
	public Food queryFoodById(int id){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Food where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Food> list=queryObject.list();
			Food food=list.get(0);
			session.close();
			return food;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 更新菜品
	 * @param newUser
	 * @return
	 */
	public boolean updateFood(Food food){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				session.update(food);
				transaction.commit();
				session.close();
				return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查询
	 * @return
	 */
	public List<Food> queryAllFoods(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Food order by id desc";
			Query queryObject=session.createQuery(queryString);
			List<Food> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Food> queryByPage(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from Food order by id desc";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<Food> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 读取菜系
	 * @return
	 */
	public List<?> loadFoodStyle(){
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from FoodStyle";
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
	 * 通过菜系ID读取菜系
	 * @param foodStyleId
	 * @return
	 */
	public FoodStyle loadFoodStyle(String foodStyleId){
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from FoodStyle where foodStyleId=" + foodStyleId;
			Query queryObject = session.createQuery(queryString);
			List<?> list = queryObject.list();
			FoodStyle foodStyle = (FoodStyle)list.get(0);
			System.out.println("foodDao_loadFoodStyle 城市="+foodStyle.getFoods());//避免无法传值到getFoods
			session.close();
			return foodStyle;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过菜品ID读取菜品
	 * @param id
	 * @return
	 */
	public Food loadFoods(String id){
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Food where id=" + id;
			Query queryObject = session.createQuery(queryString);
			List<?> list = queryObject.list();
			Food food = (Food)list.get(0);
			session.close();
			return food;
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
