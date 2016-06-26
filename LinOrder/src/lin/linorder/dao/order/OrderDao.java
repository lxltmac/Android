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
	 * 订单保存
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
	 * 桌号保存
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
	 * 催单桌号保存
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
	 * 订单添加添加
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
	 * 订单桌号添加
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
	 * 催单桌号添加
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
	 * 根据菜名删除订单
	 * @param id
	 * @return
	 */
	public boolean deleteOrderListById(String orderName,String tableNum){
		//创建session
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
	 * 根据id删除订单
	 * @param id
	 * @return
	 */
	public boolean deleteOrderById(int id){
		//创建session
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
	 * 根据id删除桌号
	 * @param id
	 * @return
	 */
	public boolean deleteTableById(int id){
		//创建session
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
	 * 根据id查找订单
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
	 * 根据桌号查找订单
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
	 * 根据催单桌号查找订单
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
	 * 更新订单
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
	 * 查询当前更新的菜品ID
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
	 * 查询当前删除的桌号ID
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
	 * 查询订单
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
	 * 查询订单桌号
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
	 * 查询订单桌号
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
	 * 分页查询
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
	 * 分页查询
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
	 * 分页查询桌号
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
	 * 分页查询催单桌号
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
