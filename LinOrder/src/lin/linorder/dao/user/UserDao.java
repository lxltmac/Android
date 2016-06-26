package lin.linorder.dao.user;

import java.util.List;

import lin.linorder.models.user.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {
	private SessionFactory sessionFactory;
	/**
	 * 用户保存
	 * @param userName
	 * @return
	 */
	public User loadUser(String username) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from User where username=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, username);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				User user = (User)list.get(0);
				return user;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 前台用户添加
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction(); 
			int row = Integer.parseInt(session.save(user).toString());
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
	public boolean deleteUserById(int id){
		//创建session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<User> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					User user=list.get(i);
					session.delete(user);
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
	 * 根据id查找前台用户
	 * @param id
	 * @return
	 */
	public User queryUserById(int id){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<User> list=queryObject.list();
			User user=list.get(0);
			session.close();
			return user;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据name查找名字
	 * @param id
	 * @return
	 */
	public User queryUserByName(String username){
		//创建session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User where username=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, username);
			List<User> list=queryObject.list();
			User user=list.get(0);
			session.close();
			return user;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 更新前台用户
	 * @param newUser
	 * @return
	 */
	public boolean updateUser(User user){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				session.update(user);
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
	public List<User> queryAllUsers(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User";
			Query queryObject=session.createQuery(queryString);
			List<User> list=queryObject.list();
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
	public List<User> queryByPage(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from User ";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<User> list=queryObject.list();
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
