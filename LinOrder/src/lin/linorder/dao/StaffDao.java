package lin.linorder.dao;

import java.util.List;

import lin.linorder.models.Staff;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StaffDao {
	private SessionFactory sessionFactory;
	//��֤Android�ͻ��˵��û���¼
	public Staff loadUser(String name) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Staff where name=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, name);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				Staff staff = (Staff)list.get(0);
				return staff;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * ��̨��¼��֤
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean loginCheck(String name,String password){
		boolean flag = true;
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String queryString = "from Staff where name=? and password=? ";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, name);
			queryObject.setParameter(1, password);
			List<?> list = queryObject.list();
			session.close();
			if(list.size()==0){
				flag = false;
			}
		    return flag;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	public List<Staff> queryAllUsers(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Staff";
			Query queryObject=session.createQuery(queryString);
			List<Staff> list=queryObject.list();
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
	public List<Staff> queryByPage(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from Staff ";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
//			StringBuffer queryString= new StringBuffer("select * from users_air limit "+(pageNo*pageSize-pageSize)+","+pageSize+"");
//			SQLQuery queryObject=session.createSQLQuery(queryString.toString());
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<Staff> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��Ӻ�̨�û�
	 * @param staff
	 * @return
	 */
	public boolean addUser(Staff staff){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			int row = Integer.parseInt(session.save(staff).toString());
			transaction.commit();
			session.close();
			if(row > 0){
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
	 * ����idɾ���û�
	 * @param id
	 * @return
	 */
	public boolean deleteUserById(int id){
		//����session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Staff where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Staff> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					Staff staff=list.get(i);
					session.delete(staff);
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
	 * ����id�����û�
	 * @param id
	 * @return
	 */
	public Staff queryUserById(int id){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Staff where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Staff> list=queryObject.list();
			Staff staff=list.get(0);
			session.close();
			return staff;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	/**
	 * �����û�
	 * @param newUser
	 * @return
	 */
	public boolean updateUser(Staff staff){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				session.update(staff);
				transaction.commit();
				session.close();
				return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * ����name��������
	 * @param id
	 * @return
	 */
	public Staff queryUserByName(String name){
		//����session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Staff where name=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, name);
			List<Staff> list=queryObject.list();
			Staff staff=list.get(0);
			session.close();
			return staff;
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
 