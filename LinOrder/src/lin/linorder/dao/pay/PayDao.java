package lin.linorder.dao.pay;

import java.util.List;

import lin.linorder.models.pay.Pay;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PayDao {
	private SessionFactory sessionFactory;
	
	/**
	 * ����������
	 * @param user
	 * @return
	 */
	public boolean addPay(Pay pay){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction(); 
			int row = Integer.parseInt(session.save(pay).toString());
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
	
	
//	/**
//	 * ��������ɾ���˵�
//	 * @param id
//	 * @return
//	 */
//	public boolean deletePayById(String tableNum){
//		//����session
//		Session session=null;
//		Transaction transaction=null;
//		try{
//			session=sessionFactory.openSession();
//			String queryString="from Pay where tableNum=?";
//			Query queryObject=session.createQuery(queryString);
//			queryObject.setParameter(0, tableNum);
//			List<Pay> list=queryObject.list();
//			if(list.size()>0){
//				transaction=session.beginTransaction();
//				for(int i=0;i<list.size();i++){
//					Pay pay=list.get(i);
//					session.delete(pay);
//				}
//				transaction.commit();
//				session.close();
//				return true;
//			}else{
//				return false;
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	
	
	/**
	 * ����idɾ���˵�
	 * @param id
	 * @return
	 */
	public boolean deletePayById(int id){
		//����session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Pay where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Pay> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					Pay pay=list.get(i);
					session.delete(pay);
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
	 * ����id�����˵�
	 * @param id
	 * @return
	 */
	public Pay queryPayById(int id){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Pay where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Pay> list=queryObject.list();
			Pay pay=list.get(0);
			session.close();
			return pay;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * ��ѯ�˵�
	 * @return
	 */
	public List<Pay> queryAllPays(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Pay order by id desc";
			Query queryObject=session.createQuery(queryString);
			List<Pay> list=queryObject.list();
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
	public List<Pay> queryByPage(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from Pay order by id desc";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<Pay> list=queryObject.list();
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
	public List<Pay> queryByPageNum(int pageNo,int pageSize,String payTableNum){
		//session
		Session session=null;
		String hql="from Pay where payTableNum=?";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			queryObject.setParameter(0, payTableNum);
			List<Pay> list=queryObject.list();
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
