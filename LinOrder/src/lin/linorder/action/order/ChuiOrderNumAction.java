package lin.linorder.action.order;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lin.linorder.models.order.Order;
import lin.linorder.models.order.OrderChui;
import lin.linorder.models.order.OrderList;
import lin.linorder.service.order.OrderService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ChuiOrderNumAction extends ActionSupport {
	private OrderService orderService;
	private OrderChui orderChui;
	private String tableNum;
	
	public void addOrderHttp(){
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html");
			//获得响应的输出流
			PrintWriter pw = response.getWriter();
			//获取客户端请求
			String tableNum = request.getParameter("tableNum");
			//实例化数据访问对象
			orderChui.setTableNum(tableNum);
			if(orderService.chuiTableNum(tableNum)){
				if(orderService.chuiOrderChui(orderChui)){
					 pw.print(build(orderChui));
				}else{
					pw.print("0");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	private String build(OrderChui order) {
        String userMsg = "";
        userMsg += "id=" + order.getId();
        userMsg += ";";
        userMsg += "tableNum=" + order.getTableNum();
        return userMsg;
    }
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public OrderChui getOrderChui() {
		return orderChui;
	}
	public void setOrderChui(OrderChui orderChui) {
		this.orderChui = orderChui;
	}
	public String getTableNum() {
		return tableNum;
	}
	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}
	
}
