package lin.linorder.action.order;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import lin.linorder.dao.order.OrderDao;
import lin.linorder.models.order.Order;
import lin.linorder.service.order.OrderService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrderAction extends ActionSupport {
	private int id;
	private String orderNum;
	private String orderName;
	private String orderPrice;
	private String tableNum;
	 
	private Order order;
	private OrderDao orderDao;
	private OrderService orderService;
	
	HttpServletRequest request;
	HttpSession session;
	
	public OrderAction(){
		
	}
	
	/**
	 * 添加订单
	 * @return
	 */
	public String addOrder(){
		order.setId(id);
		order.setOrderNum(orderNum);
		order.setOrderName(orderName);
		order.setOrderPrice(orderPrice);
		
		if(orderService.addOrder(order)){
			return "addOrderSuccess";
		}else{
		    return "addOrderInput";
		}
	}
	
	/**
	 * 删除订单
	 * @return
	 */
	public void deleteOrder(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			order.setId(id);
			int del_id= Integer.valueOf(id).intValue();
			if(orderService.deleteOrderById(del_id)){
				System.out.print(del_id);
	//			return "addUserSuccess";
				out.print("true");
			}else{
	//			return "userShowAction";
				out.print("false");
			}
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id查找订单
	 * @return
	 */
	public String queryOrder(){
		order.setId(id);
		int del_id= Integer.valueOf(id).intValue();
		System.out.print(del_id);
		order = orderService.queryOrderById(del_id);
		if(order!=null){
			return "query";
		}else{
			return "queryInput";
		}
	}
	
//	/**
//	 * 根据桌号查找订单
//	 * @return
//	 */
//	public String queryOrderNum(){
//		order.setTableNum(tableNum);
//		order = orderService.queryOrderByNum(tableNum);
//		if(order!=null){
//			return "queryOrder";
//		}else{
//			return "queryInput";
//		}
//	}
	
	
	
	/**
	 * 更新订单
	 * @return
	 */
	public String updateUser(){
		order.setId(order.getId());
		order.setOrderNum(orderNum);
		order.setOrderName(orderName);
		order.setOrderPrice(orderPrice);
		
		if(orderService.updateOrder(order)){
			return "addOrderSuccess";
		}else{
			return "query";
		}
	}
	
//	/**
//	 * 检查是前台用户是不是已经存在
//	 * 
//	 */
//	public void checkUsername(){
//		try{
//			HttpServletResponse response = ServletActionContext.getResponse();
//			PrintWriter out = response.getWriter();
//		    if(userService.checkUsername(username)){
//		    	out.print("true");
//		    }else{
//		    	out.print("false");
//		    }
//		    out.flush();
//		    out.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	} 
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public String getTableNum() {
		return tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
}
