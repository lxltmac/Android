package lin.linorder.dao.goods;

import java.util.List;

import lin.linorder.models.goods.Food;
import lin.linorder.models.goods.FoodStyle;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FoodStyleDao {
	private SessionFactory sessionFactory;
	/**
	 * 菜系名字保存
	 * @param StyleName
	 * @return
	 */
	public FoodStyle loadFoodStyle(String styleName) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from FoodStyle where styleName=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, styleName);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				FoodStyle foodStyle = (FoodStyle)list.get(0);
				return foodStyle;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 菜系添加
	 * @param foodStyle
	 * @return
	 */
	public boolean addFoodStyle(FoodStyle foodStyle){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction(); 
			int row = Integer.parseInt(session.save(foodStyle).toString());
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
	 * 根据id删除菜系
	 * @param id
	 * @return
	 */
	public boolean deleteFoodStyleById(int id){
		//创建session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from FoodStyle where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<FoodStyle> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					FoodStyle foodStyle=list.get(i);
					session.delete(foodStyle);
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
	 * 根据id查找菜系
	 * @param id
	 * @return
	 */
	public FoodStyle queryFoodStyleById(int id){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from FoodStyle where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<FoodStyle> list=queryObject.list();
			FoodStyle foodStyle=list.get(0);
			session.close();
			return foodStyle;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 更新菜系
	 * @param newUser
	 * @return
	 */
	public boolean updateFoodStyle(FoodStyle foodStyle){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				session.update(foodStyle);
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
	public List<FoodStyle> queryAllFoodStyles(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from FoodStyle";
			Query queryObject=session.createQuery(queryString);
			List<FoodStyle> list=queryObject.list();
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
	public List<FoodStyle> queryByPage(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from FoodStyle ";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<FoodStyle> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
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
