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
	 * �û�����
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
	 * ǰ̨�û����
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
	 * ����idɾ����Ʒ
	 * @param id
	 * @return
	 */
	public boolean deleteUserById(int id){
		//����session
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
	 * ����id����ǰ̨�û�
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
	 * ����name��������
	 * @param id
	 * @return
	 */
	public User queryUserByName(String username){
		//����session
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
	 * ����ǰ̨�û�
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
	 * ��ѯ
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
	 * ��ҳ��ѯ
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
