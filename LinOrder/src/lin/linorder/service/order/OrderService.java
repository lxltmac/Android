package lin.linorder.service.order;

import java.util.List;


import lin.linorder.dao.order.OrderDao;
import lin.linorder.models.order.Order;
import lin.linorder.models.order.OrderChui;
import lin.linorder.models.order.OrderList;

public class OrderService {
	private OrderDao orderDao;
	
	/**
	 * �������
	 * @param user
	 * @return
	 */
	public boolean addOrder(Order order){
		return orderDao.addOrder(order);
	}
	/**
	 * �������
	 * @param user
	 * @return
	 */
	public boolean addOrderList(OrderList order){
		return orderDao.addOrderList(order);
	}
	
	/**
	 * �ߵ��������
	 * @param user
	 * @return
	 */
	public boolean chuiOrderChui(OrderChui order){
		return orderDao.chuiOrderList(order);
	}

	/**
	 * Android����������
	 * @param user
	 * @return
	 */
	public boolean checkTableNum(String tableNum) {
		OrderList order = orderDao.loadtableNum(tableNum);
		System.out.println("��ǰ�ύ����: order="+order);
		if(order == null){
			return true;
		}
		return false;
	}
	
	/**
	 * Android����������
	 * @param user
	 * @return
	 */
	public boolean chuiTableNum(String tableNum) {
		OrderChui order = orderDao.loadChuitableNum(tableNum);
		System.out.println("��ǰ�ύ����: order="+order);
		if(order == null){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Android�����²˵�
	 * @param user
	 * @return
	 */
	public boolean checkOrderName(String orderName,String tableNum) {
		Order order = orderDao.loadOrder(orderName,tableNum);
//		System.out.println("userservice_login: user="+user);
		if(order == null){
			return true;
		}
		return false;
	}
	
	/**
	 * Android�����²˵�id
	 * @param user
	 * @return
	 */
	public Order checkOrderId(String orderName,String tableNum) {
		return orderDao.checkOrderId(orderName,tableNum);
		
	}
	
	/**
	 * Android���ɾ������id
	 * @param user
	 * @return
	 */
	public OrderList checkOrderListId(String tableNum) {
		return orderDao.checkOrderListId(tableNum);
		
	}
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteOrderById(int id){
		if(orderDao.deleteOrderById(id)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	public boolean deleteTableById(int id){
		if(orderDao.deleteTableById(id)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteOrderListById(String orderName,String tableNum){
		if(orderDao.deleteOrderListById(orderName, tableNum)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ����id��ȡ��Ϣ
	 * @param id
	 * @return
	 */
	public Order queryOrderById(int id){
		Order order;
		order = orderDao.queryOrderById(id);
		return order;
	}
	
	/**
	 * �������Ż�ȡ��Ϣ
	 * @param id
	 * @return
	 */
	public List<Order> queryOrderByNum(String tableNum){
		List<Order> orders;
		orders = orderDao.queryOrderByNum(tableNum);
		return orders;
	}
	
	/**
	 * ���ݴߵ����Ż�ȡ��Ϣ
	 * @param id
	 * @return
	 */
	public List<OrderChui> queryOrderChuiByNum(String tableNum){
		List<OrderChui> orders;
		orders = orderDao.queryOrderChuiByNum(tableNum);
		return orders;
	}
	
	/**
	 * ���²���
	 * @param newFood
	 * @return
	 */
	public boolean updateOrder(Order order){
		return orderDao.updateOrder(order);
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Order> queryAllOrders(){
		List<Order> orders;
		orders=orderDao.queryAllOrders();
	    return orders;
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<OrderList> queryAllOrderLists(){
		List<OrderList> orders;
		orders=orderDao.queryAllOrderLists();
	    return orders;
	}
	
	/**
	 * ��ѯ�ߵ�����
	 * @return
	 */
	public List<OrderChui> queryAllOrderChuis(){
		List<OrderChui> orders;
		orders=orderDao.queryAllOrderChuis();
	    return orders;
	}
	
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<Order> queryByPage(int pageNo,int pageSize){
			List<Order> orders;
			orders=orderDao.queryByPage(pageNo,pageSize);
			return orders;
		}
		
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<OrderList> queryByPageList(int pageNo,int pageSize){
			List<OrderList> orders;
			orders=orderDao.queryByPageList(pageNo,pageSize);
			return orders;
		}
		
		/**
		 * ��ҳ��ѯ
		 * @param pageNo
		 * @param pageSize
		 * @return
		 */
			public List<OrderChui> queryByPageChui(int pageNo,int pageSize){
				List<OrderChui> orders;
				orders=orderDao.queryByPageChui(pageNo,pageSize);
				return orders;
			}
		
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<Order> queryByPageNum(int pageNo,int pageSize,String tableNum){
			List<Order> orders;
			orders=orderDao.queryByPageNum(pageNo,pageSize,tableNum);
			return orders;
		}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
//	/**
//	 * ��鵱ǰ�Ƿ����
//	 * @return
//	 */
//	public boolean checkUsername(String username){
//		User user = userDao.loadUser(username);
//		if(user == null){
//			return true;
//		}else{
//			return false;
//		}
//	}

	
	
}
