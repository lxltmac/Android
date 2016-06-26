package lin.linorder.dao.order;

import java.util.List;

import lin.linorder.models.order.Order;
import lin.linorder.models.order.OrderChui;
import lin.linorder.models.order.OrderList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrderDao {
	private SessionFactory sessionFactory;
	/**
	 * ��������
	 * @param userName
	 * @return
	 */
	public Order loadOrder(String orderName,String tableNum) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Order where orderName=? and tableNum=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, orderName);
			queryObject.setParameter(1, tableNum);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				Order order = (Order)list.get(0);
				return order;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ���ű���
	 * @param userName
	 * @return
	 */
	public OrderList loadtableNum(String tableNum) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from OrderList where tableNum=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, tableNum);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				OrderList order = (OrderList)list.get(0);
				return order;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * �ߵ����ű���
	 * @param userName
	 * @return
	 */
	public OrderChui loadChuitableNum(String tableNum) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from OrderChui where tableNum=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, tableNum);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				OrderChui order = (OrderChui)list.get(0);
				return order;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * ����������
	 * @param user
	 * @return
	 */
	public boolean addOrder(Order order){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction(); 
			int row = Integer.parseInt(session.save(order).toString());
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
	 * �����������
	 * @param user
	 * @return
	 */
	public boolean addOrderList(OrderList order){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction(); 
			int row = Integer.parseInt(session.save(order).toString());
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
	 * �ߵ��������
	 * @param user
	 * @return
	 */
	public boolean chuiOrderList(OrderChui order){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction(); 
			int row = Integer.parseInt(session.save(order).toString());
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
	 * ���ݲ���ɾ������
	 * @param id
	 * @return
	 */
	public boolean deleteOrderListById(String orderName,String tableNum){
		//����session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where orderName=? and tableNum=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, orderName);
			queryObject.setParameter(1, tableNum);
			List<Order> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					Order order=list.get(i);
					session.delete(order);
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
	
//	
	
	/**
	 * ����idɾ������
	 * @param id
	 * @return
	 */
	public boolean deleteOrderById(int id){
		//����session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Order> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					Order order=list.get(i);
					session.delete(order);
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
	 * ����idɾ������
	 * @param id
	 * @return
	 */
	public boolean deleteTableById(int id){
		//����session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from OrderList where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<OrderList> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					OrderList orderList=list.get(i);
					session.delete(orderList);
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
	 * ����id���Ҷ���
	 * @param id
	 * @return
	 */
	public Order queryOrderById(int id){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Order> list=queryObject.list();
			Order order=list.get(0);
			session.close();
			return order;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * �������Ų��Ҷ���
	 * @param id
	 * @return
	 */
	public List<Order> queryOrderByNum(String tableNum){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where tableNum=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, tableNum);
			List<Order> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ���ݴߵ����Ų��Ҷ���
	 * @param id
	 * @return
	 */
	public List<OrderChui> queryOrderChuiByNum(String tableNum){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from OrderChui where tableNum=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, tableNum);
			List<OrderChui> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * ���¶���
	 * @param newUser
	 * @return
	 */
	public boolean updateOrder(Order order){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				session.update(order);
				transaction.commit();
				session.close();
				return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
	
	/**
	 * ��ѯ��ǰ���µĲ�ƷID
	 * 
	 */
	public Order checkOrderId(String orderName,String tableNum) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Order where orderName=? and tableNum=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, orderName);
			queryObject.setParameter(1, tableNum);
			List<Order> list = queryObject.list();
			System.out.println("list==========="+list);
			System.out.println("list.get(0)==========="+list.get(0));
			Order order = list.get(0);
			System.out.println("order==========="+order);
			session.close();
			return order;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��ѯ��ǰɾ��������ID
	 * 
	 */
	public OrderList checkOrderListId(String tableNum) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from OrderList where tableNum=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, tableNum);
			List<OrderList> list = queryObject.list();
			System.out.println("list==========="+list);
			System.out.println("list.get(0)==========="+list.get(0));
			OrderList order = list.get(0);
			System.out.println("order==========="+order);
			session.close();
			return order;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Order> queryAllOrders(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order";
			Query queryObject=session.createQuery(queryString);
			List<Order> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * ��ѯ��������
	 * @return
	 */
	public List<OrderList> queryAllOrderLists(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from OrderList";
			Query queryObject=session.createQuery(queryString);
			List<OrderList> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public List<OrderChui> queryAllOrderChuis(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from OrderChui";
			Query queryObject=session.createQuery(queryString);
			List<OrderChui> list=queryObject.list();
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
	public List<Order> queryByPage(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from Order ";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<Order> list=queryObject.list();
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
	public List<Order> queryByPageNum(int pageNo,int pageSize,String tableNum){
		//session
		Session session=null;
		String hql="from Order where tableNum=?";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			queryObject.setParameter(0, tableNum);
			List<Order> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��ҳ��ѯ����
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<OrderList> queryByPageList(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from OrderList ";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<OrderList> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��ҳ��ѯ�ߵ�����
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<OrderChui> queryByPageChui(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from OrderChui ";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<OrderChui> list=queryObject.list();
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
