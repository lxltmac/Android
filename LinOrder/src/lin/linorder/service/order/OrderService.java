package lin.linorder.service.order;

import java.util.List;


import lin.linorder.dao.order.OrderDao;
import lin.linorder.models.order.Order;
import lin.linorder.models.order.OrderChui;
import lin.linorder.models.order.OrderList;

public class OrderService {
	private OrderDao orderDao;
	
	/**
	 * 订单添加
	 * @param user
	 * @return
	 */
	public boolean addOrder(Order order){
		return orderDao.addOrder(order);
	}
	/**
	 * 桌号添加
	 * @param user
	 * @return
	 */
	public boolean addOrderList(OrderList order){
		return orderDao.addOrderList(order);
	}
	
	/**
	 * 催单桌号添加
	 * @param user
	 * @return
	 */
	public boolean chuiOrderChui(OrderChui order){
		return orderDao.chuiOrderList(order);
	}

	/**
	 * Android检查更新桌号
	 * @param user
	 * @return
	 */
	public boolean checkTableNum(String tableNum) {
		OrderList order = orderDao.loadtableNum(tableNum);
		System.out.println("当前提交桌号: order="+order);
		if(order == null){
			return true;
		}
		return false;
	}
	
	/**
	 * Android检查更新桌号
	 * @param user
	 * @return
	 */
	public boolean chuiTableNum(String tableNum) {
		OrderChui order = orderDao.loadChuitableNum(tableNum);
		System.out.println("当前提交桌号: order="+order);
		if(order == null){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Android检查更新菜单
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
	 * Android检查更新菜单id
	 * @param user
	 * @return
	 */
	public Order checkOrderId(String orderName,String tableNum) {
		return orderDao.checkOrderId(orderName,tableNum);
		
	}
	
	/**
	 * Android检查删除桌号id
	 * @param user
	 * @return
	 */
	public OrderList checkOrderListId(String tableNum) {
		return orderDao.checkOrderListId(tableNum);
		
	}
	
	/**
	 * 删除
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
	 * 删除桌号
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
	 * 删除
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
	 * 根据id获取信息
	 * @param id
	 * @return
	 */
	public Order queryOrderById(int id){
		Order order;
		order = orderDao.queryOrderById(id);
		return order;
	}
	
	/**
	 * 根据桌号获取信息
	 * @param id
	 * @return
	 */
	public List<Order> queryOrderByNum(String tableNum){
		List<Order> orders;
		orders = orderDao.queryOrderByNum(tableNum);
		return orders;
	}
	
	/**
	 * 根据催单桌号获取信息
	 * @param id
	 * @return
	 */
	public List<OrderChui> queryOrderChuiByNum(String tableNum){
		List<OrderChui> orders;
		orders = orderDao.queryOrderChuiByNum(tableNum);
		return orders;
	}
	
	/**
	 * 更新操作
	 * @param newFood
	 * @return
	 */
	public boolean updateOrder(Order order){
		return orderDao.updateOrder(order);
	}
	
	/**
	 * 查询数据
	 * @return
	 */
	public List<Order> queryAllOrders(){
		List<Order> orders;
		orders=orderDao.queryAllOrders();
	    return orders;
	}
	
	/**
	 * 查询桌号
	 * @return
	 */
	public List<OrderList> queryAllOrderLists(){
		List<OrderList> orders;
		orders=orderDao.queryAllOrderLists();
	    return orders;
	}
	
	/**
	 * 查询催单桌号
	 * @return
	 */
	public List<OrderChui> queryAllOrderChuis(){
		List<OrderChui> orders;
		orders=orderDao.queryAllOrderChuis();
	    return orders;
	}
	
	
	/**
	 * 分页查询
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
	 * 分页查询
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
		 * 分页查询
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
	 * 分页查询
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
//	 * 检查当前是否存在
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
