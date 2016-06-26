package lin.linorder.action.order;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lin.linorder.models.order.Order;
import lin.linorder.service.order.OrderService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteOrderAllAction extends ActionSupport {
	private OrderService orderService;
	private Order order;
	private String tableNum;
	private String orderName;
	private int id;
	
	public void deleteOrderHttp(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		//获得响应的输出流
		PrintWriter pw = response.getWriter();
		//获取客户端请求
		String tableNum = request.getParameter("tableNum");
		String orderName = request.getParameter("tableName");
		System.out.println("桌号====="+tableNum);
		System.out.println("菜名====="+orderName);
		//System.out.println("idsd==========="+orderService.checkOrderId(orderName,tableNum).getId());
		//实例化数据访问对象
//		order.setId(orderService.checkOrderId(orderName).getId());
		order.setTableNum(tableNum);
		order.setOrderName(orderName);
		order.setId(orderService.checkOrderId(orderName,tableNum).getId());
			if(orderService.deleteOrderById(orderService.checkOrderId(orderName,tableNum).getId())){
				 pw.print(build(order));
			}else{
				pw.print(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	private String build(Order order) {
        String userMsg = "";
        userMsg += "id=" + order.getId();
        userMsg += ";";
        userMsg += "tableNum=" + order.getTableNum();
        userMsg += "orderName=" + order.getOrderName();
        return userMsg;
    }
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
